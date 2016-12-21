package com.DanielRoudnitsky;

/**
 * Created by droudy on 12/17/16.
 */

import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.bytedeco.javacv.ImageTransformer;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.LineSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentencePreProcessor;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.apache.commons.io.LineIterator;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.indexing.INDArrayIndex;
import org.nd4j.linalg.indexing.NDArrayIndex;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;


/** A custom DataSetIterator created for the cornell movie dialogue corpus (https://www.cs.cornell.edu/~cristian/Cornell_Movie-Dialogs_Corpus.html)
 * to be used for neural conversational model using sequence to sequence learning
 *
 * For an "input" consisting of a sequence of N words into the model, the input vector would be size N * (embedding size used in the word2vec model)
 * For a label consisting of a sequence of M words, the label vector contains the one hot encodings for each word in the label, so it
 * would be size M * (size of one hot encoded vector which should be the number of unique words in the training data)
 *
 */

public class CustomSequenceIterator {

    private HashMap<String, String> seq_hm; // Hash map to contain each sequence and its ID
    private String inputTrainingSeq;
    private String labeledOutputSeq;
    private LineIterator inputIterator;
    private LineIterator labelIterator;
    private int maxSeqLength;

    private int cursor = 0;                 // "cursor" to keep track of current iteration
    private TokenizerFactory tokenizerFactory;
    private Word2Vec wordVectors;
    private Logger log = Logger.getLogger(NeuralChatBot.class.getName());

    public CustomSequenceIterator(HashMap seq_hm, String inputTrainingSeq, String labeledOutputSeq, Word2Vec wordVectors){
        this.seq_hm = seq_hm;
        this.inputTrainingSeq = inputTrainingSeq;
        this.labeledOutputSeq = labeledOutputSeq;
        this.maxSeqLength = maxSeqLength;
        try {
            this.inputIterator = new LineIterator(new FileReader(inputTrainingSeq));
            this.labelIterator = new LineIterator(new FileReader(labeledOutputSeq));
        } catch (java.io.FileNotFoundException e){
            e.printStackTrace();
        }
        this.tokenizerFactory = new DefaultTokenizerFactory();
        this.tokenizerFactory.setTokenPreProcessor(new CommonPreprocessor());
        this.wordVectors = wordVectors;
    }

    //@override // return DataSet
    public void next(int num) {
        List<String> inputs = new ArrayList<String>(num);
        List<String> labels = new ArrayList<String>(num);

        for(int i=0; i<num; i++){
            inputs.add(seq_hm.get(inputIterator.next())); //Retrieve an input for training
            labels.add(seq_hm.get(labelIterator.next())); //Retrieve its label
        }
        // Tokenize inputs and labels
        List<List<String>> allInputTokens = new ArrayList(num);
        List<List<String>> allOutputTokens = new ArrayList(num);

        int maxInputLength = tokenizeSequence(allInputTokens, inputs);
        int maxOutputLength = tokenizeSequence(allOutputTokens, labels);
        int vectorSize = wordVectors.getLayerSize();

        INDArray features = Nd4j.create(num, vectorSize, maxInputLength + maxOutputLength);
        INDArray featuresMask = Nd4j.zeros(num, maxInputLength + maxOutputLength);
        int[] maskTemp = new int[2];

        for(int i=0; i<num; i++){
            maskTemp[0] = i;
            List<String> tokens = allInputTokens.get(i);
            // Get word embedding for each token and populate INDArray features
            for(int j=0; j<tokens.size(); j++){
                String word = tokens.get(j);
                INDArray wordVector = wordVectors.getWordVectorMatrix(word);
                features.put(new INDArrayIndex[]{NDArrayIndex.point(i), NDArrayIndex.all(), NDArrayIndex.point(j)}, wordVector);
                maskTemp[1] = j;
                featuresMask.putScalar(maskTemp, 1.0);
            }
        }
        System.out.println(features.toString());
    }

    /** Tokenize a list of string sequences and return the maximum length encountered in the sequences
     *
     * @param allTokens List where all the tokens will be placed
     * @param sequence  List of sequences to tokenize
     * @return the maximum length of sequence encountered
     */
    private int tokenizeSequence(List<List<String>> allTokens, List<String> sequence){
        int maxLength = 0;
        for(String s: sequence){
            List<String> tokens = tokenizerFactory.create(s).getTokens();
            maxLength = (maxLength > tokens.size()) ? maxLength : tokens.size();
            System.out.println(maxLength);
            allTokens.add(tokens);
        }
        return maxLength;
    }


    public void reset(){
        try {
            this.inputIterator = new LineIterator(new FileReader(inputTrainingSeq));
            this.labelIterator = new LineIterator(new FileReader(labeledOutputSeq));
        } catch (java.io.FileNotFoundException e){
            e.printStackTrace();
        }
        this.cursor = 0;
    }
}

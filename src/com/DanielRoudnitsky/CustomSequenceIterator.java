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

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;


/** A custom DataSetIterator created for the cornell movie dialogue corpus (https://www.cs.cornell.edu/~cristian/Cornell_Movie-Dialogs_Corpus.html)
 * to be used for neural conversational model using sequence to sequence learning
 *
 */

public class CustomSequenceIterator extends DataSetIterator{

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

    public CustomSequenceIterator(HashMap seq_hm, String inputTrainingSeq, String labeledOutputSeq, int maxSeqLength, Word2Vec wordVectors){
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

        for(String s: inputs) System.out.println(s);
        for(String s: labels) System.out.println(s);

        /*
        // Retrieve sentence and its label
        String input_sentence = seq_hm.get(inputIterator.next());
        String output_sentence = seq_hm.get(labelIterator.next());

        // Tokenize input and its label
        List<String> input_tokens = tokenizerFactory.create(input_sentence).getTokens();
        List<String> output_tokens = tokenizerFactory.create(output_sentence).getTokens();

        int vectorSize = wordVectors.getLayerSize();
        INDArray Input = Nd4j.create()
        */
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

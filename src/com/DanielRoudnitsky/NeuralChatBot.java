package com.DanielRoudnitsky;

import java.io.*;
import java.util.HashMap;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.LineSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentencePreProcessor;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import java.util.logging.Logger;

public class NeuralChatBot {

    public HashMap<String, String> seq_hm = new HashMap(); // Hash map to contain each sequence and its ID
    public final String LINES_FILE = "lines.txt";          // Path to .txt containing all sequences (movie line)
    public final String IDS_FILE = "line_ids.txt";         // Path to .txt containing the corresponding ID for all sequences (movie dialogue)
    public final String INPUT_SEQ_FILE = "input_seq.txt";  // Path to .txt containing the ID for each input example for training
    public final String OUTPUT_SEQ_FILE = "labels.txt";    // Path to .txt containing the ID for the corresponding labeled output for each input example (labeled training output)

    private Logger log = Logger.getLogger(NeuralChatBot.class.getName());

    public NeuralChatBot() throws java.io.FileNotFoundException{
        populateHashMap(IDS_FILE, LINES_FILE);
        CustomSequenceIterator sequenceIterator = new CustomSequenceIterator(seq_hm, INPUT_SEQ_FILE, OUTPUT_SEQ_FILE,
                                                                             createWord2VecEmbeddings(LINES_FILE));
        sequenceIterator.next(1);
    }

    /**
     * Map each key in pathToKeys to its corresponding value in pathToValues. Assumes that each line in pathToKeys contains one key and
     * each line in pathToValues contains the value for the corresponding key in pathToKeys. Both files should contain the same number of lines
     * for a proper mapping between keys and values
     */
    private void populateHashMap(String pathToKeys, String pathToValues) {
        try {
            FileReader key_reader = new FileReader(pathToKeys);
            FileReader value_reader = new FileReader(pathToValues);
            BufferedReader key_buffer = new BufferedReader(key_reader);
            BufferedReader value_buffer = new BufferedReader(value_reader);
            log.info("Creating hash table for the sequences and their corresponding ids...");
            String key = null;
            while ((key = key_buffer.readLine()) != null)
                this.seq_hm.put(key.trim(), value_buffer.readLine());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Create Word2Vec embeddings for the corpus, these embeddings will be used to represent the sequences inputted into the RNN,
     * serialize the model into memory as "word_embeddings.txt"(large file) if the model hasn't been created already
     *
     * @param pathToCorpus path to file containing corpus for which to create embeddings
     */
    private Word2Vec createWord2VecEmbeddings(String pathToCorpus) throws java.io.FileNotFoundException {
        if (new File("word_embeddings.txt").exists()) {
            log.info("Loading existing Word2Vec model....");
            Word2Vec word2Vec = WordVectorSerializer.loadFullModel("word_embeddings.txt");
            return word2Vec;
        } else {
            SentenceIterator iter = new LineSentenceIterator(new File(pathToCorpus));
            iter.setPreProcessor(new SentencePreProcessor() {
                @Override
                public String preProcess(String sentence) {
                    return sentence.toLowerCase();
                }
            });
            TokenizerFactory tokenizer = new DefaultTokenizerFactory();
            tokenizer.setTokenPreProcessor(new CommonPreprocessor());

            log.info("Building Word2Vec model....");
            Word2Vec word2Vec = new Word2Vec.Builder()
                    .learningRate(.025)
                    .minWordFrequency(1) // need an embedding for each word in our corpus
                    .iterations(5)
                    .layerSize(3)
                    .seed(42)
                    .windowSize(5)
                    .iterate(iter)
                    .tokenizerFactory(tokenizer)
                    .build();

            log.info("Fitting Word2Vec model....");
            word2Vec.fit();
            log.info("Saving vectors....");
            WordVectorSerializer.writeFullModel(word2Vec, "word_embeddings.txt");

            return word2Vec;
        }
    }
}

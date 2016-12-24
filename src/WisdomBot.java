/*
 * Magpie Project
 * AP Computer Science
 * Mr.Levin
 * Daniel Roudnitsky, Cindy Wu, Candy Yuen
 * Period 8
 */
import java.util.concurrent.ThreadLocalRandom;

/**
 * A "wise" bot that responds with somewhat vague and wise responses
 */

public class WisdomBot implements ChatBot{

    private String lastInput = null; // null value indicates that there hasn't been an input yet
    private int lastRandInt = -1;    // -1 "filler" value so that we know that we haven't created a random number yet

    private String[][][] responsePairs = {
        {{"hello", "how are you", "hi", "whats up"}, {"Hello, I am wise, how are you?"}},
        {{"wise", "wisdom", "man", "men"}, {"Wise men speak because they have something to say; Fools because they have to say something."}},
        {{"women", "girl", "beautiful"}, {"A beautiful woman delights the eye; a wise woman, the understanding; a pure one, the soul."}},
        {{"intelligent", "smart", "clever"}, {"I am so clever that sometimes I don't understand a single word of what I am saying."}},
        {{"hate", "love"}, {"It is easy to hate and it is difficult to love. This is how the whole scheme of things works." +
                            " All good things are difficult to achieve; and bad things are very easy to get."}},
        {{"yes", "okay"}, {"Too much agreement kills the chat."}},
        {{"good", "bad", "horrible", "great"}, {"The good life is one inspired by love and guided by knowledge."}},
        // !!! NSFW !!! (Sorry Mr. Levin)
        {{"fuck", "penis", "bitch", "ass", "anus"}, {"Cursing is invoking the assistance of a spirit to help you inflict suffering." +
                                                             "Swearing on the other hand, is invoking, only the witness of a spirit to an " +
                                                             "statement you wish to make."}},
        {{"what"},{"what?"}},
        {{"dont know"}, {"Me neither and I am wise"}},
        {{"why?", "why"}, {"Why does anything exist? What is the meaning of it all?"}},
        {{"bye", "goodbye", "peace"}, {"Bye! It was nice giving you wisdom!"}}
    };
    private String[] randomResponses = {
            "The good life is one inspired by love and guided by knowledge.",
            "Love myself I do. Not everything, but I love the good as well as the bad. I love my crazy lifestyle, and I love my hard discipline." +
                    " I love my freedom of speech and the way my eyes get dark when I'm tired. I love that I have learned to trust people with my " +
                    "heart, even if it will get broken. I am proud of everything that I am and will become.",
            "A good teacher can inspire hope, ignite the imagination, and instill a love of learning.",
            "To be or not to be, that is the question.",
            "We shall never know all the good that a simple smile can do."
    };

    public String getGreeting(){
        return "Hi! I am the wisdom bot, here to offer you some wisdom";
    }

    public String getResponse(String input){
        if(lastInput != null)
            if(lastInput.equals(input)) // If an input was repeated consecutively
                return "Repetition makes reputation and reputation makes customers";
        lastInput = input;

        for(String[][] pair: responsePairs)
            for(String s: pair[0])
                if (input.contains(s)) return pair[1][0];


        return getRandomResponse();
    }

    public String getRandomResponse(){
        int randIndex = ThreadLocalRandom.current().nextInt(0, randomResponses.length);

        // Don't want repeating statements caused by the same number being generated consecutively
        while(lastRandInt == randIndex)
            randIndex = ThreadLocalRandom.current().nextInt(0, randomResponses.length);
        lastRandInt = randIndex;

        return randomResponses[randIndex];
    }
}

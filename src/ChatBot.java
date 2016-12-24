/*
 * Magpie Project
 * AP Computer Science
 * Mr.Levin
 * Daniel Roudnitsky, Cindy Wu, Candy Yuen
 * Period 8
 */

/**
 * A simple interface to be implemented by the different types of chatbots
 */

public interface ChatBot {

    // Get a greeting from the chatbot
    String getGreeting();

    // Get a hard coded response from the chatbot based on the input
    String getResponse(String statement);

    // Get a random response if there is no hard coded response for a given input
    String getRandomResponse();

}

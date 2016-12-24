/*
 * Magpie Project
 * AP Computer Science
 * Mr.Levin
 * Daniel Roudnitsky, Cindy Wu, Candy Yuen
 * Period 8
 */

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ChatbotRunner
{
    /* Last random number generated for picking a bot personality
     -1 "filler" value so that we know that we haven't created a randBot yet */
    private static int lastRandBotInt = -1;

	public static void main(String[] args)
	{
        System.out.println("shit".contains("shit"));
        String response;
        Scanner scanner = new Scanner(System.in);
        System.out.println("// Enter \"new personality\" to get a chatbot with a different personality");

        ChatBot randBot = getRandomBot();
        System.out.println(randBot.getGreeting());

        while(!(response = scanner.nextLine().toLowerCase()).contains("bye")){ // Get response and exit loop if it == "bye"
            if(response.contains("new personality")){
                randBot = getRandomBot();
                System.out.println(randBot.getGreeting());
            }
            else{
                System.out.println(randBot.getResponse(response));
            }
        }
        System.out.println(randBot.getResponse("bye")); // Get a proper farewell
    }

    /**
     * Method to create a new chat bot based on a random number, doesn't allow for the same type of bot to
     * be returned consecutively
     * @return A chatbot instance that implements the ChatBot interface
     */
	private static ChatBot getRandomBot(){
        ChatBot randBot = null;
        int rand = ThreadLocalRandom.current().nextInt(0, 3); // random int from 0 to 2 for the three bots

        // To avoid having the same bot returned consecutively
        while(lastRandBotInt == rand)
            rand = ThreadLocalRandom.current().nextInt(0, 3);
        lastRandBotInt = rand; // update lastRandBotInt

        switch (rand){
            case 0:
                randBot = new DoucheBot();
                break;
            case 1:
                randBot = new NerdBot();
                break;
            case 2:
                randBot = new WisdomBot();
                break;
        }

        return randBot;
    }
}

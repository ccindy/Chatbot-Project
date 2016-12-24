/*
 * Magpie Project
 * AP Computer Science
 * Mr.Levin
 * Daniel Roudnitsky, Cindy Wu, Candy Yuen
 * Period 8
 */

import java.util.Scanner;

public class PhysicsGame {
    /*
    * Physics game
    * the person can ask the nerdBot questions about physics and he would try to answer them.
    */
    public void startGame(){
        System.out.println(getGreeting());

        Scanner scanner = new Scanner(System.in);
        String response;

        while(!(response = scanner.nextLine().toLowerCase()).contains("exit")){
            getAnswer(response);
        }
    }

	private String getGreeting()
	{
		final int NUMBER_OF_GREETINGS = 1;
		double r = Math.random();
		int whichGreeting = (int)(r * NUMBER_OF_GREETINGS);
		String greeting="Hello";
		if (whichGreeting == 0)
		{
			greeting = "I am getting bored.. Let's play a physics game! Answer yes or no (type exit to quit the game)";
		}
		return greeting;
	}

    //nerdBot tries to answer the question according to these keywords
    public String getAnswer(String statement)
    {
			String response = "";
			//if 'no' and 'joke' are both detected in a statement and no comes before joke, it returns "You're a joke."
			if (statement.indexOf("yes") >= 0)
			{ 
			response = "Yeah!! Ask me any question about physics and I will know the answer. If I answered it correctly, then I won";
			}
			if (statement.indexOf("no") >= 0)
			{ 
			response = "...okay then :(";
			}
			else if (statement.indexOf("gravity") >= 0)
			{
				response = "It is 9.81m/s^2";
			}
			else if (statement.indexOf("velocity") >= 0)
			{
				response = "It is the derivative, rate of change of displacement. The area of the acceleration graph = velocity"
						+"vf = vi + at";
			}
			else if (statement.indexOf("acceleration") >= 0)
			{
				response = "The derivative of velocity a = v/t";
				
			}
			else if (statement.indexOf("electricity") >= 0)
			{
				response = "There are positive and negative";
			}
			else if (statement.indexOf("magnet") >= 0)
			{
				response = "North and south";
			}
			else if (statement.indexOf("diaplacement") >= 0)
			{
				response = "Delta x and x final minus x initial";
			}
			else if (statement.indexOf("force") >= 0)
			{
				response = "Please specify what force you are taking about";
			}
			if (statement.indexOf("friction") >= 0)
			{
				response = "f = miu N . Force between rough surfaces.";
			}
			if (statement.indexOf("normal") >= 0)
			{
				response = "Opposite direction from Fg. It is for balancing out Fg.";
			}
			if (statement.indexOf("Fg") >= 0 ||
					statement.indexOf("fg") >= 0 )
			{
				response = "Gravitational force. Fg=mg";
			}

			return response;
	}
}

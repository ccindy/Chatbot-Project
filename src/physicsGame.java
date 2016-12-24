
public class physicsGame {
	/*
	 * Physics game
	 * the person can ask the nerdBot questions about physics and he would try to answer them.
	 */
	public String getGreeting()
	{
		final int NUMBER_OF_GREETINGS = 1;
		double r = Math.random();
		int whichGreeting = (int)(r * NUMBER_OF_GREETINGS);
		String greeting = "";
		//There is only one greeting for the physics game
		if (whichGreeting == 0)
		{
			greeting = "I am getting bored.. Let's play a physics game! Answer yes or no";
		}
		return greeting;
	}
	//nerdBot tries to answer the question according to these keywords
		public String getAnswer(String statement)
		{
			String response = "";
			//if the person wants to play the game	
			if (statement.indexOf("yes") >= 0)
			{ 
			response = "Yeah!! Ask me any question about physics and I will know the answer. If I answered it correctly, then I won";
			}
			//if the person says no
			else if (statement.indexOf("no") >= 0)
			{ 
			response = "...okay then :( BUT YOU CANNOT EXIT THE GAME UNLESS YOU RESTART";
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
			else if (statement.indexOf("friction") >= 0)
			{
				response = "f = miu N . Force between rough surfaces.";
			}
			else if (statement.indexOf("normal") >= 0)
			{
				response = "Opposite direction from Fg. It is for balancing out Fg.";
			}
			else if (statement.indexOf("Fg") >= 0 ||
					statement.indexOf("fg") >= 0 )
			{
				response = "Gravitational force. Fg=mg";
			}
			//if the queston doesnt fit any of the keyword, the nerdBot would get a random response
			else
			{
				response = getRandomResponse();
			}

			return response;
	}
		private String getRandomResponse()
		{
			final int NUMBER_OF_RESPONSES = 6;
			double r = Math.random();
			int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
			String response = "";
			
			if (whichResponse == 0)
			{
				response = "I don't understand your question...Can you ask something else?";
			}
			else if (whichResponse == 1)
			{
				response = "Is this biology question? Because I only understand physics.";
			}
			else if (whichResponse == 2)
			{
				response = "Sorry! I don't know the answer.";
			}
			else if (whichResponse == 3)
			{
				response = "I am always smart...but maybe not this time ";
			}
			else if (whichResponse == 4)
			{
				response = "Thinking...";
			}
			else if (whichResponse == 5)
			{
				response = "Please google it yourself. www.google.com";
			}

			return response;
		}


}

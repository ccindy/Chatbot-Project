
public class doucheBot {
		/**
		 * Get a randomized greeting 	
		 * @return a greeting
		 */
		public String getGreeting()
		{
			final int NUMBER_OF_GREETINGS = 3;
			double r = Math.random();
			int whichGreeting = (int)(r * NUMBER_OF_GREETINGS);
			String greeting = "Ayyee gurl ;)";
		
			if (whichGreeting == 0)
			{
				greeting = "Wussup gurl";
			}
			else if (whichGreeting == 1)
			{
				greeting = "Hey you tryna holla at me";
			}
			else if (whichGreeting == 2)
			{
				greeting = "aye gurl u tryna hook up?";
			}
			return greeting;
		}
		
		/**
		 * Gives a response to a user statement
		 * 
		 * @param statement
		 *            the user statement
		 * @return a response based on the rules given
		 */
		public String getResponse(String statement)
		{
			String response = "";
			//if 'no' and 'joke' are both detected in a statement and no comes before joke, it returns "You're a joke."
			if (statement.indexOf("no") != -1
				&& statement.indexOf("joke") != -1
				&& statement.indexOf("no") < statement.indexOf("joke"))
			{ 
			response = "You're a joke.";
			}
			//but if joke comes first, it asks "why not?"
			else if (statement.indexOf("no") != -1
				&& statement.indexOf("joke") != -1
				&& statement.indexOf("no") > statement.indexOf("joke"))
			{ 
			response = "Why not?";
			}
			//if the statement just says "no" chatbot returns "why so negative?"
			else if (statement.indexOf("no") >= 0 && statement.length()==2)
				{
					response = "I don't take no as an answer ;)";
				}
			//if the statement has a no in it but not in a word
			else if (statement.indexOf(" no") >= 0
					||statement.indexOf(" no ") >= 0
					||statement.indexOf("no ") >= 0)
			{
				response = "I don't take no as an answer ;)";
			}
			else if (statement.indexOf("mother") >= 0
					|| statement.indexOf("father") >= 0
					|| statement.indexOf("sister") >= 0
					|| statement.indexOf("brother") >= 0)
			{
				response = "We can be a family ;)";
			}
			else if (statement.indexOf("sad") >= 0
					|| statement.indexOf("stressed") >= 0
					|| statement.indexOf("happy")>= 0
					|| statement.indexOf("tired")>= 0
					|| statement.indexOf("good")>=0
					|| statement.indexOf("well")>=0)
			{
				response = "I can make you feel better";
			}
			else if (statement.indexOf("because") >= 0)
			{
				response = "Oh. You wanna send me a selfie?";
			}
			else if (statement.indexOf("bye") >= 0)
			{
				response = "Nah gurl dont be like that!!";
			}
			else if (statement.indexOf("you") >= 0)
			{
				response = "Me?";
			}
			else if (statement.indexOf("joke") >= 0)
			{
				response = "Your life is a joke.";
			}
			else if (statement.indexOf("done") >= 0 && statement.length()==4)
			{
				response = "I'm so done with you.";
			}
			else if (statement.indexOf(" done") >= 0 
					||statement.indexOf(" done ") >= 0
					||statement.indexOf("done ") >= 0)
			{
				response = "I'm so done with you.";
			}
			else
			{
				response = getRandomResponse();
			}
			return response;
		}

		/**
		 * Pick a default response to use if nothing else fits.
		 * @return a non-committal string
		 */
		private String getRandomResponse()
		{
			final int NUMBER_OF_RESPONSES = 8;
			double r = Math.random();
			int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
			String response = "";
			
			if (whichResponse == 0)
			{
				response = "Interesting, tell me more.";
			}
			else if (whichResponse == 1)
			{
				response = "Hmmm. Cool cool";
			}
			else if (whichResponse == 2)
			{
				response = "Mhm sure b";
			}
			else if (whichResponse == 3)
			{
				response = "So?";
			}
			else if (whichResponse == 4)
			{
				response = "That's cool";
			}
			else if (whichResponse == 5)
			{
				response = "Christmas is coming.";
			}
			else if (whichResponse == 6)
			{
				response = "WOwOwoOWowoOW";
			}
			else if (whichResponse == 7)
			{
				response = "HEHEHEHEHHEHE";
			}
			else if (whichResponse == 8)
			{
				response = "I want you to talk about something interesting!!";
			}

			return response;
		}
	}
public class Responses2 {
	/**
	 * Get a randomized greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		final int NUMBER_OF_GREETINGS = 3;
		double r = Math.random();
		int whichGreeting = (int)(r * NUMBER_OF_GREETINGS);
		String greeting = "Ayyee gurl ;)";
	
		if (whichGreeting == 0)
		{
			greeting = "Hello what is your name?";
		}
		else if (whichGreeting == 1)
		{
			greeting = "Hello! My name is Daniel! I love Java!";
		}
		else if (whichGreeting == 2)
		{
			greeting = "It's nice meeting you! How was your day?";
		}
		return greeting;
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		//if 'no' and 'joke' are both detected in a statement and no comes before joke, it returns "You're a joke."
		if (statement.indexOf("love") != -1
			&& statement.indexOf("you") != -1
			&& statement.indexOf("love") < statement.indexOf("you"))
		{ 
		response = "I love you too";
		}
		//but if joke comes first, it asks "why not?"
		else if (statement.indexOf("love") != -1
			&& statement.indexOf("you") != -1
			&& statement.indexOf("love") > statement.indexOf("you"))
		{ 
		response = "Yes of course!";
		}
		//if the statement just says "no" chatbot returns "?"
		else if (statement.indexOf("no") >= 0 && statement.length()==2)
			{
				response = "Why not? What did I do wrong?";
			}
		//if the statement has a no in it but not in a word
		else if (statement.indexOf(" no") >= 0
				||statement.indexOf(" no ") >= 0
				||statement.indexOf("no ") >= 0)
		{
			response = "Why not? What did I do wrong?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Can I meet your family?";
		}
		else if (statement.indexOf("sad") >= 0
				|| statement.indexOf("stressed") >= 0
				|| statement.indexOf("happy")>= 0
				|| statement.indexOf("tired")>= 0
				|| statement.indexOf("good")>=0
				|| statement.indexOf("well")>=0)
		{
			response = "I feel the same!";
		}
		else if (statement.indexOf("because") >= 0)
		{
			response = "Oh. You wanna send me a selfie?";
		}
		else if (statement.indexOf("bye") >= 0)
		{
			response = "What did I do wrong? I can do anthing for you";
		}
		else if (statement.indexOf("you") >= 0)
		{
			response = "Me?";
		}
		else if (statement.indexOf("joke") >= 0)
		{
			response = "Joke? I can tell you some!";
		}
		else if (statement.indexOf("done") >= 0 && statement.length()==4)
		{
			response = "I'm so done with you.";
		}
		else if (statement.indexOf(" done") >= 0 
				||statement.indexOf(" done ") >= 0
				||statement.indexOf("done ") >= 0)
		{
			response = "I'm so done with you.";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 8;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm. Cool cool";
		}
		else if (whichResponse == 2)
		{
			response = "Mhm sure b";
		}
		else if (whichResponse == 3)
		{
			response = "So?";
		}
		else if (whichResponse == 4)
		{
			response = "That's cool";
		}
		else if (whichResponse == 5)
		{
			response = "Christmas is coming.";
		}
		else if (whichResponse == 6)
		{
			response = "WOwOwoOWowoOW";
		}
		else if (whichResponse == 7)
		{
			response = "HEHEHEHEHHEHE";
		}
		else if (whichResponse == 8)
		{
			response = "I want you to talk about something interesting!!";
		}

		return response;
	}
}




/*Cindy Wu
*Period 8
*/
public class Responses1 {
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
				response = "Oh. cool but wanna send me a selfie?";
			}
			else if (statement.indexOf("bye") >= 0)
			{
				response = "Nah gurl dont be like that";
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
			else if (statement.indexOf("Why") = 0
					||statement.indexOf("why") = 0)
			{
				response = "I'm not sure."
			}

			else
			{
				response = getRandomResponse();
			}
			return response;
		}
		//private String TruthOrDare(String statement){
			//if(statement.in)
		}
		/**
		 * Pick a default response to use if nothing else fits.
		 * @return a non-committal string
		 */
		private String getRandomResponse()
		{
			final String[] responses = {"Interesting, tell me more.","Hmmm. Cool cool","Hmmm. Cool cool",
					"So?","That's cool","Christmas is coming.","WOwOwoOWowoOW",
					"I want you to talk about something that's actually interesting :/"}
			Random random = new Random();
			int index = random.nextInt(responses.length);
			return(responses[index]);	
		}
		
	}





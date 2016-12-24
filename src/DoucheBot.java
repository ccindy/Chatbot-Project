/*
 * Magpie Project
 * AP Computer Science
 * Mr.Levin
 * Daniel Roudnitsky, Cindy Wu, Candy Yuen
 * Period 8
 */

/**
 * A douchey chatbot that responds with douchey remarks
 */
public class DoucheBot implements ChatBot{
		/**
		 * Get a randomized greeting 	
		 * @return a greeting
		 */
		public String getGreeting()
		{
			final int NUMBER_OF_GREETINGS = 3;
			double r = Math.random();
			int whichGreeting = (int)(r * NUMBER_OF_GREETINGS);
			String greeting = "";
		
			if (whichGreeting == 0)
			{
				greeting = "Wussup gurl";
			}
			else if (whichGreeting == 1)
			{
				greeting = "Hey you tryna holla at me?";
			}
			else if (whichGreeting == 2)
			{
				greeting = "aye gurl u tryna hook up?";
			}
            System.out.println("(You can ask me for truths or dares)");
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
			else if (statement.indexOf("why") >= 0
					||statement.indexOf("how") >= 0
					||statement.indexOf("which") >= 0)
			{
				response = "I am tired of questions.";
			}
			if (statement.indexOf("my ") >= 0
					&& statement.indexOf("name") >= 0
					||statement.indexOf("I am") >= 0
					||statement.indexOf("i am") >= 0)
			{
				response = "Hey nice to meet you girl. Be my girl.";
			}
			else if (statement.indexOf("name") >= 0
					||statement.indexOf("called") >= 0)
			{
				response = "My name is George btw ;)";
			}
			else if (statement.indexOf("bmcc") >= 0
					||statement.indexOf("cuny") >= 0)
			{
				response = "That's literally my dream college";
			}
			else if (statement.indexOf("family") >= 0
					||statement.indexOf("baby") >= 0)
			{
				response = "We can make babies;)";
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
			else if (statement.indexOf("school") >= 0 
					||statement.indexOf("book") >= 0
					||statement.indexOf("teacher") >= 0
					||statement.indexOf("class") >= 0)
			{
				response = "Can you not talk about school?";
			}
			else if (statement.indexOf("college") >= 0
					||statement.indexOf("mcd") >= 0
					||statement.indexOf("McDonald's") >= 0)
			{
				response = "I am working in McDonald's for life. No college:)";
			}
			else if (statement.indexOf("girlfriend") >= 0
					||statement.indexOf("relationship") >= 0
					||statement.indexOf("love") >= 0
					||statement.indexOf("boyfriend") >= 0)
			{
				response = "I dated 100 girls and you will be the 101st ;)";
			}
			else if(statement.indexOf("truth") >= 0){
                String[] truths = {"Did you ever break the law?",
                                   "What's the worst lie you've told?",
                        			"You like someone,right? 😉",
                        			"Tell me the most embarassing thing you've ever done.",
                        			"I bet you've cheated on a test before, right?"};
                double r = Math.random();
                int index = (int)(r * truths.length);
                return truths[index];
            }
            else if(statement.indexOf("dare") >= 0){
                String[] dares = {"Lick the person next to you 😛",
                				 "Go outside and yell 'I AM LOOKING FOR A GOD'",
                				 "Challenge a stranger to a duel.",
                				 "Scream Twinkle Twinkle Little Stars out the window 😀",
                				 "LICK THE WALL"};
                double r = Math.random();
                int index = (int)(r * dares.length);
                return dares[index];
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
		public String getRandomResponse()
		{
			final int NUMBER_OF_RESPONSES = 10;
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
			else if (whichResponse == 9)
			{
				response = "Talk about something that is not school related.";
			}
			else if (whichResponse == 10)
			{
				response = "I am going to BMCC HOLAAAAA";
			}

			return response;
		}
	}




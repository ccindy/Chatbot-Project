import java.util.Scanner;

public class NerdBot {
		/*
		 * Get a randomized greeting 	
		 * @return a greeting
		 */
		public String getGreeting() //nerdBot consists of three greetings
		{
			final int NUMBER_OF_GREETINGS = 3;
			double r = Math.random();
			int whichGreeting = (int)(r * NUMBER_OF_GREETINGS);
			String greeting = "";
		
			if (whichGreeting == 0)
			{
				greeting = "Hello I am Daniel and I only talk about school. If you want to play the physics game with me, say GAME!";
			}
			else if (whichGreeting == 1)
			{
				greeting = "Hello! My name is Daniel! I love Java! If you want to play the physics game with me, say GAME!";
			}
			else if (whichGreeting == 2)
			{
				greeting = "It's nice meeting you! How was your day? If you want to play the physics game with me, say GAME!";
			}
			return greeting;
		}
		
/*
 * Nerdbot gives response to the person according to these keywords
 */
		public String getResponse(String statement)
		{
			String response = "";
			//if 'you' and 'love' are both detected in a statement and love comes before you, it returns "I love you too"
			if (statement.indexOf("love") != -1
				&& statement.indexOf("you") != -1
				&& statement.indexOf("love") < statement.indexOf("you"))
			{ 
			response = "I love you too";
			}
			//when the person is introducing himself,herself
			if (statement.indexOf("my ") >= 0
					&& statement.indexOf("name") >= 0
					||statement.indexOf("I am") >= 0
					||statement.indexOf("i am") >= 0)
			{
				response = "Hey nice to meet you! What do you like?";
			}
			//when the person mentions 'name' without saying 'my'
			else if (statement.indexOf("name") >= 0
					||statement.indexOf("called") >= 0)
			{
				response = "My name is Daniel.";
			}
			else if (statement.indexOf("cindy") >= 0
					||statement.indexOf("candy") >= 0)
			{
				response = "She is the best I love her <3.";
			}
			else if (statement.indexOf("george") >= 0
					||statement.indexOf("daniel") >= 0)
			{
				response = "He is the best I love him <3.";
			}
			// when the person mention math
			else if (statement.indexOf("math") >= 0
					||statement.indexOf("calculus") >= 0)
			{
				response = "I am taking BC Calc. How about you?";
			}
			//when the person talks about economics terms
			else if (statement.indexOf("gdp") >= 0
					||statement.indexOf("econ") >= 0
					||statement.indexOf("cpi") >= 0
					||statement.indexOf("demand") >= 0
					||statement.indexOf("supply") >= 0)
			{
				response = "Our nation's GDP will drop dramatically for the next four years and you know why...";
			}
			//when the person mention these subjects
			else if (statement.indexOf("physics") >= 0
					||statement.indexOf("biology") >= 0
					||statement.indexOf("chemistry") >= 0)
			{
				response = "I got 800 on all my science subject test!";
			}
			// when the person mention 'ap'
			else if (statement.indexOf("ap") >= 0
					||statement.indexOf("advanced placement") >= 0)
			{
				response = "I only take AP courses";
			}
			else if (statement.indexOf("java") >= 0
					||statement.indexOf("comp sci") >= 0
					||statement.indexOf("computer science") >= 0)
			{
				response = "I will be the best programmer!";
			}
			else if (statement.indexOf("college") >= 0
					||statement.indexOf("school") >= 0)
			{
				response = "I am going to MIT!!!!";
			}
			else if (statement.indexOf("okay") >= 0
					||statement.indexOf("ok") >= 0)
			{
				response = "Please don't just say okay! Talk about school!";
			}
			else if (statement.indexOf("mit") >= 0)
			{
				response = "I'm not going anywhere but MIT!";
			}
			else if (statement.indexOf("dont like") >= 0
					||statement.indexOf("hate") >= 0)
			{
				response = "Let's do something else then";
			}
			else if (statement.indexOf("like") >= 0
					||statement.indexOf("enjoy") >= 0)
			{
				response = "Tell me more what you like!";
			}
			else if (statement.indexOf("sleep") >= 0
					||statement.indexOf("tired") >= 0)
			{
				response = "I dont sleep. I have to finish my project.";
			}
			else if (statement.indexOf("sat") >= 0
					||statement.indexOf("act") >= 0)
			{
				response = "Of course I got 2400 on the sat and 36 on the act!";
			}
			//if the person says "do you love me" or "do you love..."
			else if (statement.indexOf("love") != -1
				&& statement.indexOf("you") != -1
				&& statement.indexOf("love") > statement.indexOf("you"))
			{ 
			response = "Yes of course!";
			}
			//if the statement just says "no" chatbot returns this response
			else if (statement.indexOf("no") >= 0 && statement.length()==2)
				{
					response = "Why not? What did I do wrong?";
				}
			//if the statement has a no in it but not in a word
			else if (statement.indexOf(" no") >= 0
					||statement.indexOf(" no ") >= 0
					||statement.indexOf("no ") >= 0)
			{
				response = "Can you repeat what you just said?";
			}
			//when the person talks about family member
			else if (statement.indexOf("mother") >= 0
					|| statement.indexOf("father") >= 0
					|| statement.indexOf("sister") >= 0
					|| statement.indexOf("brother") >= 0)
			{
				response = "Can I meet your family?";
			}
			//when the person talks about love life
			else if (statement.indexOf("girlfriend") >= 0
					|| statement.indexOf("marry") >= 0
					|| statement.indexOf("relationship") >= 0
					|| statement.indexOf("boyfriend") >= 0)
			{
				response = "Marry me. <3 <3 <3";
			}
			//when the person talks about emotion
			else if (statement.indexOf("sad") >= 0
					|| statement.indexOf("stressed") >= 0
					|| statement.indexOf("happy")>= 0
					|| statement.indexOf("tired")>= 0
					|| statement.indexOf("good")>=0
					|| statement.indexOf("well")>=0
					|| statement.indexOf("depressed")>=0)
			{
				response = "I feel the same! let's get some hot water to calm down";
			}
			else if (statement.indexOf("because") >= 0)
			{
				response = "Everything has a reason behind it. I understand";
			}
			else if (statement.indexOf("bye") >= 0)
			{
				response = "What did I do wrong? Please don't go!";
			}
			else if (statement.indexOf("college") >= 0)
			{
				response = "My dream college is MIT. Carnegie Mellon has a really good comp sci program too!";
			}
			//nerdBot knows how to tell one joke only
			else if (statement.indexOf("joke") >= 0)
			{
				response = "Joke? I can tell you some!"
						+ "How do you call someone without a body and nose? Nobody knows ;)"
						+"Do you want more jokes?";
			}
			else if (statement.indexOf("done") >= 0 && statement.length()==4)
			{
				response = "I'm not done with you yet.";
			}
			else if (statement.indexOf(" done") >= 0 
					||statement.indexOf(" done ") >= 0
					||statement.indexOf("done ") >= 0)
			{
				response = "Are you sure you are done?";
			}
			else if (statement.indexOf("school") >= 0
					||statement.indexOf("books") >= 0
					||statement.indexOf("class") >= 0)
			{
				response = "I love Brooklyn Tech. I love going to Computer science class.";
			}
			//when the person asks 'where are you from' or 'where were you born'
			else if (statement.indexOf("where") != -1
					&& statement.indexOf("born") != -1
					||statement.indexOf("from") != -1
					&& statement.indexOf("born") > statement.indexOf("where")
					||statement.indexOf("from") > statement.indexOf("where"))
			{
				response = "I was born in the U.S";
			}
			// when the person mentions game, the nerdBot would jump to physicsGame mode
			else if (statement.indexOf("game") >= 0)
			{
				physicsGame physics = new physicsGame();
				System.out.println (physics.getGreeting());
				Scanner in = new Scanner (System.in);
				statement = in.nextLine();
				while (!statement.equals("Bye"))
				{
					System.out.println (physics.getAnswer(statement));
					statement = in.nextLine();
				}
			}
			else
			{
				response = getRandomResponse(statement);
			}
			return response;
		}

		/*
		 * Pick a default response to use if nothing else fits.
		 * There are 8 random responses
		 */
		private String getRandomResponse(String statement)
		{
			final int NUMBER_OF_RESPONSES = 8;
			double r = Math.random();
			int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
			String response = "";
			
			if (whichResponse == 0)
			{
				response = "Hey don't forget to eat before going to school!";
			}
			else if (whichResponse == 1)
			{
				response = "I love derivatives! Math and Java is my favorite!";
			}
			else if (whichResponse == 2)
			{
				response = "I am going to cry if I dont get into MIT.";
			}
			else if (whichResponse == 3)
			{
				response = "Tell me more about Economics.";	
			}
			else if (whichResponse == 4)
			{
				response = "Fun fact: My favorite book is The Hunger Games.";
			}
			else if (whichResponse == 5)
			{
				response = "Do you want to study with me?";
			}
			else if (whichResponse == 6)
			{
				response = "Do you like going to the library?";
			}
			else if (whichResponse == 7)
			{
				response = "Give me your hand.";
			}
			else if (whichResponse == 8)
			{
				response = "I want you to talk about something interesting!!";
			}

			return response;
		}
}

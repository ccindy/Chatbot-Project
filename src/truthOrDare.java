
public class truthOrDare {
	public String getGreeting()
	{
		final int NUMBER_OF_GREETINGS = 1;
		double r = Math.random();
		int whichGreeting = (int)(r * NUMBER_OF_GREETINGS);
		String greeting = "";
		if (whichGreeting == 0)
		{
			greeting = "Welcome to truth or dare! Say 'truth' or 'dare'!!!";
		}
		return greeting;
	}
		public String GetTruth(String statement){
			String y = "";
			if(statement.indexOf("truth") >= 0
				||statement.indexOf("truth") >= 0)
			{
			 String[] Truths = {"Did you ever break the law?",
					"What's the worst lie you've told?",
					"You like someone,right? 😉",
					"Tell me the most embarassing thing you've ever done.",
					"I bet you've cheated on a test before, right?"};
			 double r = Math.random();
			 int index = (int)(r * Truths.length);
			 String Truth = (Truths[index]); 
			 y = Truth;
			}
			return y;
		}
		public String GetDare(String statement){ 
			String y = "";
			if(statement.indexOf("dare") >= 0
					||statement.indexOf("DARE") >= 0)
			{
			String[] Dares = {"Lick the person next to you 😛",
					"Go outside and yell 'I AM LOOKING FOR A GOD'",
					"Challenge a stranger to a duel.",
					"Scream Twinkle Twinkle Little Stars out the window 😀",
					"LICK THE WALL"};
			 double r = Math.random();
			 int index = (int)(r * Dares.length);
			 String Dare = (Dares[index]);
			 y=Dare;
			}
			return y;
		} 
	}



public class physicsGame {
	public String getGreeting()
	{
		final int NUMBER_OF_GREETINGS = 1;
		double r = Math.random();
		int whichGreeting = (int)(r * NUMBER_OF_GREETINGS);
		String greeting="Hello";
		if (whichGreeting == 0)
		{
			greeting = "I am getting bored.. Let's play a physics game! Answer yea or no";
		}
		return greeting;
	}
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
			else if (statement.indexOf("acceleration") >= 0)
			{
				response = "It is 9.81m/s^2";
			}
			return response;
	}

}

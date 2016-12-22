
public class physicsGame {
	public String getGreeting()
	{
		final int NUMBER_OF_GREETINGS = 1;
		double r = Math.random();
		int whichGreeting = (int)(r * NUMBER_OF_GREETINGS);
		String greeting="Hello";
		if (whichGreeting == 0)
		{
			greeting = "I am getting bored.. Let's play a physics game!";
		}
		return greeting;
	}

}

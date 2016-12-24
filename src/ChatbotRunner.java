import java.util.Scanner;
/*
 * AP Computer Science
 * Mr.Levin
 * Daniel Roudnitsky, Cindy Wu, Candy Yuen
 * Period 8
 */
public class ChatbotRunner
{
	public static void main(String[] args)
	{
		System.out.println("// A bot personality is randomly chosen, rerun the program for a new personality.");
		int randomBot=3;
		double r = Math.random();
		int number = (int)(r * randomBot);
		String response = "";
		if(number==1)
		{
		doucheBot jerky = new doucheBot();
		System.out.println (jerky.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (jerky.getResponse(statement));
			statement = in.nextLine();
		}
		}
		else if(number == 2)
		{
				NerdBot nerd = new NerdBot();
				System.out.println (nerd.getGreeting());
				Scanner in = new Scanner (System.in);
				String statement = in.nextLine();
			
			while (!statement.equals("Bye"))
			{
				System.out.println (nerd.getResponse(statement));
				statement = in.nextLine();
			}
		}
		else{
			WisdomBot wisdomBot = new WisdomBot();
			wisdomBot.startBot();
		}
	}
}

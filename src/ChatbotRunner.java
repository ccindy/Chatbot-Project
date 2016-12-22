import java.util.Scanner;
public class ChatbotRunner
{
	public static void main(String[] args)
	{
		int randomBot=2;
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
		else
		{
			while(true)
			{
				nerdBot nerd = new nerdBot();
				System.out.println (nerd.getGreeting());
				Scanner in = new Scanner (System.in);
				String statement = in.nextLine();
				int numofresponse = 0;
				int count=0;
			
			while (!statement.equals("Bye"))
			{
				System.out.println (nerd.getResponse(statement));
				statement = in.nextLine();
				numofresponse++;
				while(numofresponse>10 && count<1 || statement.equals("game"))
				{
				physicsGame game = new physicsGame();
				System.out.println (game.getGreeting());
				Scanner question = new Scanner(System.in);
				String say = question.nextLine();
				while(!statement.equals("no"))
				{
				System.out.println (game.getAnswer(say));
				say = question.nextLine();
				count++;
				}
				}
			}
			}
		}
	}
	}

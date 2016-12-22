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
			nerdBot nerd = new nerdBot();
			System.out.println (nerd.getGreeting());
			Scanner in = new Scanner (System.in);
			String statement = in.nextLine();
			int numofrespond = 0;
			
			while (!statement.equals("Bye"))
			{
				System.out.println (nerd.getResponse(statement));
				statement = in.nextLine();
				numofrespond++;
				while(numofrespond>10)
				{
				
				}
			}
			}
		}
	}

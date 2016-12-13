import java.util.Scanner;
public class ChatbotRunner
{
	public static void main(String[] args)
	{
		Responses1 jerky = new Responses1();
		
		System.out.println (jerky.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (jerky.getResponse(statement));
			statement = in.nextLine();
		}
	}

}
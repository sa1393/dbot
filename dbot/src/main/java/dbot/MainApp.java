package dbot;

import listener.LunchListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;

public class MainApp {
	public static void main(String[] args) {
		JDABuilder builder = new JDABuilder(AccountType.BOT);
		String token = "NjI2NjExMzk0MzMwMjMwNzk1.XYwuhA.5mNw-_YbvE_U67J9eRTTlfuJ6Dw";
		builder.setToken(token);
		
		try {
			builder.addEventListeners(new LunchListener());
			builder.build();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class LunchListener extends ListenerAdapter {
	//메세지 받았을때 할 일
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		//사용자가 친 메세지를 그대로 모두 가져옴
		String msg = event.getMessage().getContentRaw();
		
		if(msg.startsWith("!sun")) {
			int idx = msg.indexOf(" "); //첫번째로 나오는 공백을 찾아
			if(idx < 0) {
				//queue 내 순서 기달
				sayMsg("봇인데요. 어쩌라고요", event);
				return;
			}
			String cmd = msg.substring(idx + 1);
			idx = cmd.indexOf(" ");
			
			String param = "";
			if(idx > 0) {
				param = cmd.substring(idx + 1);
				cmd = cmd.substring(0, idx);
				
			}
			
			switch(cmd) {
			
			case "echo":
				if(param == " ") {
					sayMsg("echo 명령어는 메아리 할 말을 입력해야 한다.", event);
				}
				else {
					sayMsg(param, event);
				}
				break;
				
			case "help":
				sayMsg("echo 명령어를 통해 봇이 말을 따라하게 할 수 있습니다", event);
				
				break;
			}
			
		}
		
	}
	
	private void sayMsg(String messege, MessageReceivedEvent e) {
		e.getChannel().sendMessage(messege).queue();
	}
}

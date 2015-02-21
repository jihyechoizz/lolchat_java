package connection;


import vo.User;

import com.github.theholywaffle.lolchatapi.ChatServer;
import com.github.theholywaffle.lolchatapi.FriendRequestPolicy;
import com.github.theholywaffle.lolchatapi.LolChat;
import com.github.theholywaffle.lolchatapi.riotapi.RateLimit;
import com.github.theholywaffle.lolchatapi.riotapi.RiotApiKey;

public class RiotLoginCert {
	public static boolean checkValidAccount(User user){
		LolChat api = new LolChat(ChatServer.KR, FriendRequestPolicy.ACCEPT_ALL, new RiotApiKey("", RateLimit.DEFAULT));
		try{
			if(!(api.login(user.getId(), user.getPw()))) {
				api.disconnect();
				api.setOffline();
				return false;
			}
		} catch (Exception e){
			return false;
		}
		return true;
	}
}

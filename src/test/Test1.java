package test;

import com.github.theholywaffle.lolchatapi.ChatServer;
import com.github.theholywaffle.lolchatapi.FriendRequestPolicy;
import com.github.theholywaffle.lolchatapi.LolChat;
import com.github.theholywaffle.lolchatapi.listeners.ChatListener;
import com.github.theholywaffle.lolchatapi.riotapi.RateLimit;
import com.github.theholywaffle.lolchatapi.riotapi.RiotApiKey;
import com.github.theholywaffle.lolchatapi.wrapper.Friend;

public class Test1 {

	public static void main(String args[]){
		LolChat api = new LolChat(ChatServer.KR, FriendRequestPolicy.ACCEPT_ALL, new RiotApiKey("9ca5e557-7da5-4193-b153-8629824fa033", RateLimit.DEFAULT));
		if(!(api.login(TestUserInfo.id, TestUserInfo.pw))) {
			return;
		}
		for(Friend f : api.getFriends()) {
			System.out.println(f.getName());
//			f.sendMessage("Hello 친구야 !");
		}
//		
//		for(Friend f : api.getFriends()) {
//			f.sendMessage("Hello 친구야 리스너 !", new ChatListener() {
//				@Override
//				public void onMessage(Friend paramFriend, String paramString) {
//					System.out.println("누가보냈나 ? : " + paramFriend.getName() + " message : " + paramString);
//				}
//			});
//		}
//		
		
		
	}
}

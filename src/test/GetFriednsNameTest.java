package test;

import org.junit.Test;

import com.github.theholywaffle.lolchatapi.ChatServer;
import com.github.theholywaffle.lolchatapi.FriendRequestPolicy;
import com.github.theholywaffle.lolchatapi.LolChat;
import com.github.theholywaffle.lolchatapi.riotapi.RateLimit;
import com.github.theholywaffle.lolchatapi.riotapi.RiotApiKey;
import com.github.theholywaffle.lolchatapi.wrapper.Friend;
import com.github.theholywaffle.lolchatapi.wrapper.FriendGroup;

public class GetFriednsNameTest {

	@Test
	public void test1(){
		LolChat api = new LolChat(ChatServer.KR,
				FriendRequestPolicy.ACCEPT_ALL, new RiotApiKey("",
						RateLimit.DEFAULT));
		if (!(api.login(TestUserInfo.id, TestUserInfo.pw))) {
			return;
		}
		for (Friend f : api.getFriends()) {
			System.out.println("  " + f.getName() + "  " + f.getUserId()
					+ "  " + f.getFriendStatus() + "  " + f.getGroup().getName() + "  " + f.getChatMode()
					+ "   " + f.isOnline()
					);
		}
	}	
	
//	@Test
	public void test2(){
		LolChat api = new LolChat(ChatServer.KR,
				FriendRequestPolicy.ACCEPT_ALL, new RiotApiKey("",
						RateLimit.DEFAULT));
		if (!(api.login(TestUserInfo.id, TestUserInfo.pw))) {
			return;
		}
		for(FriendGroup g : api.getFriendGroups()) {
			System.out.println("Group : " + g.getName());
		}
	}
}

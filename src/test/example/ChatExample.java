package test.example;

import com.github.theholywaffle.lolchatapi.ChatServer;
import com.github.theholywaffle.lolchatapi.FriendRequestPolicy;
import com.github.theholywaffle.lolchatapi.LolChat;
import com.github.theholywaffle.lolchatapi.listeners.ChatListener;
import com.github.theholywaffle.lolchatapi.riotapi.RateLimit;
import com.github.theholywaffle.lolchatapi.riotapi.RiotApiKey;
import com.github.theholywaffle.lolchatapi.wrapper.Friend;


public class ChatExample {

	public static void main(String[] args) {
		new ChatExample();
	}

	public ChatExample() {
		final LolChat api = new LolChat(ChatServer.EUW,
				FriendRequestPolicy.ACCEPT_ALL, new RiotApiKey("RIOT-API-KEY",
						RateLimit.DEFAULT));
		if (api.login("myusername", "mypassword")) {

			// Example 1: Send Chat Message to all your friends
			for (final Friend f : api.getFriends()) {
				f.sendMessage("Hello " + f.getName());
			}

			// Example 2: Send Chat Message to all your friends and wait for an
			// response
			for (final Friend f : api.getFriends()) {
				f.sendMessage("Hello " + f.getName(), new ChatListener() {

					@Override
					public void onMessage(Friend friend, String message) {
						System.out.println("Friend " + friend.getName()
								+ " responded to my Hello World!");
					}
				});
			}

			// Example3: Send Chat Message to an specific friend
			final Friend f = api.getFriendByName("Dyrus");
			if (f != null && f.isOnline()) {
				f.sendMessage("Hi, I'm your biggest fan!");
			}
		}
	}

}

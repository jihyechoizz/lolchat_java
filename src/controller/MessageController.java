package controller;

import vo.Message;
import vo.User;

import com.github.theholywaffle.lolchatapi.ChatServer;
import com.github.theholywaffle.lolchatapi.FriendRequestPolicy;
import com.github.theholywaffle.lolchatapi.LolChat;
import com.github.theholywaffle.lolchatapi.riotapi.RateLimit;
import com.github.theholywaffle.lolchatapi.riotapi.RiotApiKey;
import com.github.theholywaffle.lolchatapi.wrapper.Friend;

public class MessageController {

	public String sendMessageToOneFriend(User user, Message msg){
		
		LolChat api = new LolChat(ChatServer.KR, FriendRequestPolicy.ACCEPT_ALL, new RiotApiKey("", RateLimit.DEFAULT));
		if(!(api.login(user.getId(), user.getPw()))) {
			return null;
		}
		Friend f = api.getFriendById(msg.getTargetId());
		f.sendMessage(msg.getChat());
		
		
		
		return msg.getTargetId();
	}
	
}

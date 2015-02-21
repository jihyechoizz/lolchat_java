package test;

import vo.User;


public class TestMain {

	public static void main(String args[]){
		User user = new User();
		user.setId(TestUserInfo.id+"a");
		user.setPw(TestUserInfo.pw);
		UserCertTest test1 = new UserCertTest(user);
		
		user.setId(TestUserInfo.id);
		
//		UserCertTest test2 = new UserCertTest(user);
	}
}
 
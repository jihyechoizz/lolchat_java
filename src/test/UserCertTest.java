package test;

import vo.User;
import connection.RiotLoginCert;


public class UserCertTest {
	public UserCertTest(User user){
		
		boolean test = RiotLoginCert.checkValidAccount(user);
		if(test == false){
			System.out.println("Shit");
		}
		else {
			System.out.println("Good");
		}
	}
}

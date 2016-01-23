package app

import com.vaadin.ui.*
import com.vaadin.grails.*
import com.vaadin.terminal.*
import com.vaadin.server.*
import com.vaadin.ui.MenuBar.MenuItem
import com.vaadin.annotations.*
import com.vaadin.ui.Image
import com.vaadin.data.*
import app.MyUI
import library.*


class LoginController {
	
	
	Integer loginCheck(String username,String password) {
		def chk = Member.executeQuery("from Member")
		int i=0;
		
/*
		for(n in chk) {
			if(username == n.username && password == n.password) {
				i++;
				System.out.println("N"+n.username)
				System.out.println("N"+n.password)

				break;
			}
		}
*/
				
			def check = User.executeQuery("from User")
			System.out.println("size user "+check.size())
			for(q in check){
					System.out.println("Q"+q.username)
					System.out.println("Q"+q.password)

				if(username == q.username && password == q.password){
					i++;
					System.out.println("Q"+q.username)
					System.out.println("Q"+q.password)
					break;
				}
			}
		
		return i;
	}

	

}
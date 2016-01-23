package app

import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.ComboBox
import com.vaadin.ui.Notification
import com.vaadin.grails.Grails
import library.TypeBook
import library.Book
import app.MyUI
import app.*

class AddController {

	VerticalLayout todoLayout
	
	void addItem(String idBook, String nameBook, String author, String publisher, 
		Integer edition, String description, String shelf, Integer price) {

		Book books = new Book()

		TypeBook types = Tab.select.getValue()
		Date dateReg = new Date()

		System.out.println(idBook)
		System.out.println(nameBook)
		System.out.println(author)
		System.out.println(publisher)
		System.out.println(edition)
		System.out.println(description)
		System.out.println(shelf)
		System.out.println(price)
		System.out.println(types)

		books.setIdBook(idBook)
		books.setNameBook(nameBook)
		books.setAuthor(author)
		books.setPublisher(publisher)
		books.setBuildYear(edition)
		books.setDetail(description)
		books.setShelf(shelf)
		books.setPrice(price)
		books.setTypeBook(types)
		books.setDateReturn(dateReg)
		books.setDateReg(dateReg)
		books.setStatus("พร้อมให้ยืม")
		
		
		if(idBook.length() < 10){
			Notification.show("Book ID only had 10 characters.", Notification.Type.TRAY_NOTIFICATION);
        }else if(edition == Integer){
        	Notification.show("Edition take the integer only.", Notification.Type.TRAY_NOTIFICATION);
        }else{
            books = books.save(flush: true)
			Notification.show("Save complete", Notification.Type.TRAY_NOTIFICATION);
		}
	}
}
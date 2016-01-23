package app

import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.ComboBox
import com.vaadin.grails.Grails
import library.TypeBook
import library.Book
import app.MyUI
import app.*
import library.*


class SearchController2 {

	VerticalLayout todoLayout
	
	void searchBook(String idBook){
    	def book = Book.executeQuery("from Book where idBook = :d",[d:idBook])

    	System.out.println(idBook)
    	System.out.println(book.size())

    	for(n in book){
		String idbook = n.idBook	
		String nameBook = n.nameBook
		String author = n.author
		String publisher = n.publisher
		String shelf = n.shelf
    	
    	TabSearch.topic10.setValue(idbook)
    	TabSearch.topic11.setValue(nameBook)
        TabSearch.topic12.setValue(author)
		TabSearch.topic13.setValue(publisher)
    	TabSearch.topic14.setValue(shelf)

    	System.out.println(n.idBook)
    	System.out.println(n.nameBook)
        System.out.println(n.author)
		System.out.println(n.publisher)
    	System.out.println(n.shelf)
   		}
	}
}
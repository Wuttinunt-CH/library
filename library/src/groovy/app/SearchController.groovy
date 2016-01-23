package app

import com.vaadin.ui.*
import com.vaadin.grails.*
import com.vaadin.terminal.*
import com.vaadin.server.*
import com.vaadin.ui.MenuBar.MenuItem
import com.vaadin.annotations.*
import com.vaadin.ui.Image
import com.vaadin.data.*
import java.util.*
import java.text.*
import java.util.GregorianCalendar
import java.util.Date
import groovy.time.*

import app.MyUI
import library.*
import library.BookOrder


class SearchContorller {
 void searchContorller(String idBook){
    	def book = Book.executeQuery("from Book where idBook = :d",[d:idBook])

    	System.out.println(idBook)
    	System.out.println(book.size())


    	for(n in book){
    	String bookName = n.nameBook
    	String typeBook = n.typeBook
        String status = n.status
    	
    	RepairBook.textName.setValue(bookName)
    	RepairBook.textType.setValue(typeBook)
        RepairBook.textStatus.setValue(status)
    
    	System.out.println(n.nameBook)
    	System.out.println(n.typeBook)
        System.out.println(n.status)

        }
    	
    }
}
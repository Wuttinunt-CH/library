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


class Controller2 {
	void order(String bookname,String booktypes,String bookpub,Integer bookcost,Integer booknum) {

        BookOrder bo = new BookOrder()
        bo.setBookname(bookname)
        bo.setBooktypes(booktypes)
        bo.setBookpub(bookpub)
        bo.setBookcost(bookcost)
        bo.setBooknum(booknum)
        bo = bo.save()


        
/*
         if(b != null) {
            Notifi
        cation.show("บันทึกสำเร็จ", Notification.Type.TRAY_NOTIFICATION);
         } */
          if(bo == null){
            Notification.show("กรุณากรอกให้ครบ", Notification.Type.TRAY_NOTIFICATION);
         }

    }
}
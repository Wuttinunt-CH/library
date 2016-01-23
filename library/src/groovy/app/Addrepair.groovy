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


class AddRepair {
 void addRepair(String cause,String bookId){

        System.out.println(">>> 1"+cause)
        System.out.println(">>> 2"+bookId)
        String state
        def u = Book.executeQuery("from Book where idBook = :idbook",[idbook:bookId])
        for (o in u){
                state = o.status
                System.out.println(state)
            }

        Repair r = new Repair()
        r.setCause(cause)
        r = r.save(flush: true)

        if(cause == ""){
             Notification.show("บันทึกล้มเหลว", Notification.Type.TRAY_NOTIFICATION)
           }
        else if(bookId == ""){
            Notification.show("บันทึกล้มเหลว", Notification.Type.TRAY_NOTIFICATION)
        } 
        else{
            String x = "ชำรุด"
            Book.executeUpdate("update Book r set r.status=:newStatus "+"where r.idBook=:idbook",[newStatus: x,idbook: bookId])
            Book.executeUpdate("update Book rr set rr.detail=:newDetail "+"where rr.idBook=:idbook",[newDetail: cause,idbook: bookId])
            Notification.show("บันทึกรายการแจ้งซ่อมสำเร็จ ", Notification.Type.TRAY_NOTIFICATION)
            //Book.status.setValue("ชำรุด")
            }
    }
}

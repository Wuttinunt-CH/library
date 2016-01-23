package app.Book_BnR

import com.vaadin.ui.*
import com.vaadin.grails.*
import com.vaadin.terminal.*
import com.vaadin.server.*
import com.vaadin.ui.MenuBar.MenuItem
import com.vaadin.annotations.*
import com.vaadin.ui.Image
import com.vaadin.data.*
import com.vaadin.ui.Button.*
import com.vaadin.event.*
import com.vaadin.data.Property.*

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.ui.FormLayout;

import java.util.Iterator;
import java.util.function.Consumer;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;
import com.vaadin.data.*
import java.util.*
import java.text.*
import java.util.GregorianCalendar
import java.util.Date
import groovy.time.*

import app.MyUI
import library.*

import com.vaadin.ui.themes.ValoTheme
import com.vaadin.ui.themes.Reindeer

@Theme("todo")
   
class MySub extends Window {
    public MySub(String username,Date dateExpTest,String idBookget,String datBorrow,Integer intdate) {
        //super(); // Set window caption
        //center();

        setModal(true);
        setClosable(false);
        setResizable(false);

        VerticalLayout content = new VerticalLayout();
        HorizontalLayout hlayout = new HorizontalLayout()
        content.setMargin(true);
        content.setSpacing(true);
        Long id = 2
        TextField valueEditor
        TextField dateBorrow
        TextField dateReturn
        TextField bookId

        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy")
        Label detail = new Label("รายละเอียดการยืมหนังสือ")
        def dd = Book.executeQuery("from Book where idBook = :idBook",[idBook:idBookget])
        for(e in dd){

        String datereturn = dateFormat.format(dateExpTest)
        System.out.println("date return in class Book >> " + datereturn)

        valueEditor = new TextField("รหัสสมาชิก : ",username)
        valueEditor.setEnabled(false)
        valueEditor.addStyleName("blueLabel")

        bookId = new TextField("รหัสหนังสือ : ",idBookget)
            bookId.setEnabled(false)
            bookId.addStyleName("blueLabel")
        //TextField name = new TextField("ชื่อ-สกุล สมาชิก : ",n.);
        dateBorrow = new TextField("วันที่ยืม : ",datBorrow)
          dateBorrow.setEnabled(false)
        dateReturn = new TextField("กำหนดส่งคืน : ",datereturn)
          dateReturn.setEnabled(false)
          dateReturn.addStyleName("fancylabel")


        }

        //def d = Borrow.executeQuery("from Borrow where id = :id",[id:id])
        
        //for(n in d){ 
          //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         // Date adateB = n.dateBorrow
        //  Date adateR = n.dateReturn
        //  String ddateBorrow = dateFormat.format(adateB)
        //  String ddateReturn = dateFormat.format(adateR)
        
        
      

       
        Button saveButton = new Button("ปิด")
           saveButton.addClickListener({ event ->  

                this.close();
                                
                   } as Button.ClickListener)
      


        
        content.addComponent(detail)
        content.addComponent(valueEditor)
        content.addComponent(bookId)
        content.addComponent(dateBorrow)
        content.addComponent(dateReturn)
        content.addComponent(saveButton)
        content.setComponentAlignment(saveButton,Alignment.MIDDLE_RIGHT)
        content.setComponentAlignment(detail,Alignment.MIDDLE_CENTER)

        setContent(content);

      }
    }
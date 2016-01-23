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

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.AbstractTextField.TextChangeEventMode;

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
import app.Book_BnR.*
import app.*

import com.vaadin.ui.themes.ValoTheme
import com.vaadin.ui.themes.Reindeer

//@Theme("todo")

   
class MySubR extends Window {
    public MySubR(String idBookget,Integer fine,Integer totaldate) {
        //super(); // Set window caption
        //center();

        setModal(true);
        setClosable(false);
        setResizable(false);

        VerticalLayout content = new VerticalLayout();
        HorizontalLayout hlayout = new HorizontalLayout()
        content.setMargin(true);
        content.setSpacing(true);
        content.setWidth("16em")
        Long id = 2
        TextField valueEditor
        TextField dateBorrow
        TextField dateR
        TextField fineT
        TextField calDate
        TextField cash
        TextField total
        Integer totaldateCon = totaldate


        if(totaldate <= 0){
            totaldateCon = 0
        }
        System.out.println("cal date 1 >> "+totaldate)
        System.out.println("cal date 2 >> "+totaldateCon)
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ,เวลา HH:mm:ss")
        Date date = new Date()
        String d = dateFormat.format(date)
        Label detail = new Label("    ►บันทึกการคืนหนังสือ สำเร็จ◄")
        
        valueEditor = new TextField("รหัสหนังสือ : ",idBookget)
        valueEditor.setEnabled(false)
        valueEditor.addStyleName("blueLabel")
        valueEditor.setWidth("14em")

        
        dateR = new TextField("วันที่ส่งคืนหนังสือ : ",d)
            dateR.setEnabled(false)
            dateR.addStyleName("blueLabel")
            dateR.setWidth("14em")
        //TextField name = new TextField("ชื่อ-สกุล สมาชิก : ",n.);

        calDate = new TextField("จำนวนวันที่ส่งคืนล่าช้า(วัน) : ",totaldateCon.toString())
            calDate.setWidth("5em")
            calDate.addStyleName("redCenterLabel")
            calDate.setEnabled(false)
       
        fineT = new TextField("ค่าปรับ(บาท) : ",fine.toString()+".00")
          fineT.setEnabled(false)
          fineT.addStyleName("redCenterLabel")
          fineT.setWidth("5em")

        cash = new TextField("รับเงิน : ")
            cash.addStyleName("redCenterLabel")
            cash.setWidth("10em")
            cash.setImmediate(true)


        total = new TextField("เงินทอน : ")
            total.addStyleName("blueLabel2")
            total.setWidth("10em")
            total.setEnabled(false)
            total.setValue("0.00")

            if(fine == 0){
                cash.setEnabled(false)
                }else {
                cash.setEnabled(true)
            }


            cash.addTextChangeListener(new TextChangeListener() {
           public void textChange(TextChangeEvent event) {


                int len = event.getText().length();

                if(len > 0){

                String a = event.getText()
                int b = Integer.parseInt(a)
                if(b != 0){
                int cal = b - fine 
                System.out.println(a)
                System.out.println(cal)
                String aa = cal.toString()
                total.setValue(aa+".00")
                }else if(b == 0){
                    cash.setEnabled(false)
                }else
                    cash.setEnabled(true)
                }else
                    total.setValue("0.00")


                //Integer a = Integer.parseInteger(event.getText())
                //Integer b = a - t
                //System.out.println("calculate >> "len.toString)
             
          }})


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
        content.addComponent(dateR)
        content.addComponent(calDate)
        content.addComponent(fineT)
        content.addComponent(cash)
        content.addComponent(total)
        //content.addComponent(dateReturn)
        content.addComponent(saveButton)
        content.setComponentAlignment(saveButton,Alignment.MIDDLE_RIGHT)
        //content.setComponentAlignment(detail,Alignment.MIDDLE_CENTER)

        setContent(content);

      }
    }
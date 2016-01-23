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

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.AbstractTextField.TextChangeEventMode;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.ui.FormLayout;
import com.vaadin.shared.ui.label.ContentMode;

import app.MyUI
import app.*
import library.*

import com.vaadin.ui.themes.ValoTheme
import com.vaadin.ui.themes.Reindeer
@Theme("todo")


class BorrowBook extends CustomComponent {

 // static ComboBox userGroup
    static TextField idUser
    static TextField name
    static TextField userType
    static TextField total
    static TextField idBook
    static TextField nameBook
    static TextField bookType
    static TextField bookStatus
    static TextField bookDateR
    static TextArea detail
    static Button submit
    static Button cancel
    static PopupDateField inlineDateB
    static PopupDateField inlineDateR

    public BorrowBook(){
        super()
        this.configure()

    }


    public BorrowBook(String caption) {
      super(caption)
      this.configure()
    }

    private void configure() {

      Controller control = new Controller()

      VerticalLayout center = new VerticalLayout()

      Panel panel = new Panel("ยืมหนังสือ")
      VerticalLayout mainVlayout = new VerticalLayout()

      HorizontalLayout mHlayout = new HorizontalLayout()

      //VerticalLayout mainLayout = new VerticalLayout()
      VerticalLayout vlayout = new VerticalLayout()
     // VerticalLayout vvlayout = new VerticalLayout()
      HorizontalLayout hlayout = new HorizontalLayout()
      HorizontalLayout hhlayout = new HorizontalLayout()
      HorizontalLayout hhhlayout = new HorizontalLayout()
      HorizontalLayout hhhhlayout = new HorizontalLayout()
      panel.setContent(mainVlayout)
      //panel.setWidth("80%")
      //panel.setMargin(true)
      //mainVlayout.setSizeFull()
      mainVlayout.setMargin(true)
      mainVlayout.setSpacing(true)
      //mainVlayout.setWidth("80%")
      vlayout.setSpacing(true)
      vlayout.setMargin(true)
      //vlayout.setSizeFull()
      //vvlayout.setSpacing(true)
      //vvlayout.setMargin(true)
      vlayout.setWidth("100%")
      //vvlayout.setWidth("100%")
      mHlayout.setWidth("80%")
     // hlayout.setSpacing(true)
     // hlayout.setMargin(true)
      


      //search info member
      idUser = new TextField()
        Label idUsertxt = new Label("       รหัสสมาชิก :  ")
          idUsertxt.addStyleName("fancylabel")
          idUser.setMaxLength(10)
          idUser.addStyleName("orangeLabel")

          //idUser.setRequired(true)
          Button memberSearch = new Button("ค้นหา")
            memberSearch.addStyleName("myButtonSearch")
            memberSearch.setIcon(FontAwesome.SEARCH)
            //memberSearch.setEnabled(false)

        name = new TextField()
        Label nametxt = new Label("ชื่่อ-สกุล สมาชิก :  ")
          name.setEnabled(false)
          name.setWidth("16em")


          
      userType = new TextField()
        Label userTypetxt = new Label("  ประเภทสมาชิก :  ")
          userType.setEnabled(false)
          //unit = "0";
      total = new TextField()
        Label totalDate = new Label("จำนวนวันที่ยืมได้ : ")
          total.setEnabled(false)
          total.setWidth("3em")
          total.addStyleName("blueLabel2")
            Label unitDatetxt = new Label(" วัน")

/*
            // Display the current length interactively in the counter
        idUser.addTextChangeListener(new TextChangeListener() {
           public void textChange(TextChangeEvent event) {
             int len = event.getText().length();
               
               if(len > 0){
                memberSearch.setEnabled(true)
               }else {
                memberSearch.setEnabled(false)
                name.clear()
                userType.clear()
                total.clear()
               }
          }})

*/
    
    //layout.addComponent(check1)
    //layout.setExpandRatio(check1,0.1f)



      //user
      hlayout.addComponent(idUsertxt)
      hlayout.addComponent(idUser)
      hlayout.addComponent(memberSearch)

      hhlayout.addComponent(nametxt)
      hhlayout.addComponent(name)

      hhhlayout.addComponent(userTypetxt)
      hhhlayout.addComponent(userType)

      hhhhlayout.addComponent(totalDate)
      hhhhlayout.addComponent(total)
      hhhhlayout.addComponent(unitDatetxt)


      vlayout.addComponent(hlayout)
      vlayout.addComponent(hhlayout)
      vlayout.addComponent(hhhlayout)
      vlayout.addComponent(hhhhlayout)


      memberSearch.addClickListener({ event -> 
        if(idUser.getValue() == ""){
          Notification.show("กรุณาระบุ รหัสสมาชิก", Notification.Type.TRAY_NOTIFICATION)

        }else {
          control.chkUser(idUser.getValue().toUpperCase())
        }
        } as Button.ClickListener)


      HorizontalLayout ahlayout = new HorizontalLayout()
      HorizontalLayout bhlayout = new HorizontalLayout()
      HorizontalLayout chlayout = new HorizontalLayout()
      HorizontalLayout dhlayout = new HorizontalLayout()
      HorizontalLayout ehlayout = new HorizontalLayout()
      HorizontalLayout eehlayout = new HorizontalLayout()
      HorizontalLayout fhlayout = new HorizontalLayout()
      HorizontalLayout ghlayout = new HorizontalLayout()
      VerticalLayout mvlayout = new VerticalLayout()
      //VerticalLayout dvlayout = new VerticalLayout()

      mvlayout.setSpacing(true)
      mvlayout.setMargin(true)

      idBook = new TextField()
        Label idBooktxt = new Label("      รหัสหนังสือ : ")
            idBooktxt.addStyleName("fancylabel")
            idBook.setMaxLength(10)
            idBook.addStyleName("orangeLabel")

      Button bookSearch = new Button("ค้นหา")
            bookSearch.addStyleName("myButtonSearch")
              bookSearch.setIcon(FontAwesome.SEARCH)
              //bookSearch.setEnabled(false)


      nameBook = new TextField()
        Label nameBooktxt = new Label("            ชื่อเรื่อง : ")
          nameBook.setWidth("17em")
          nameBook.setEnabled(false)

      bookType = new TextField()
        Label bookTypetxt = new Label("ประเภทหนังสือ : ")
          bookType.setWidth("16em")
          bookType.setEnabled(false)
      bookStatus = new TextField()
        Label bookStatustxt = new Label("             สถานะ : ")
          bookStatus.setEnabled(false)

      bookDateR = new TextField()
        Label bookDateRtxt = new Label("   กำหนดส่งคืน : ")
          bookDateR.setEnabled(false)

      inlineDateB = new PopupDateField()
        Label datetxt = new Label("            วันที่ยืม : ")

      inlineDateB.setValue(new Date())

      detail = new TextArea()
        Label detailtxt = new Label("        หมายเหตุ : ")
        detail.setEnabled(false)
        detail.setRows(3)
/*
      
      idBook.addTextChangeListener(new TextChangeListener() {
           public void textChange(TextChangeEvent event) {
             int len = event.getText().length();
                if(len > 0){
                bookSearch.setEnabled(true)
               }else {
                bookSearch.setEnabled(false)
                nameBook.clear()
                bookType.clear()
                bookStatus.clear()
                bookDateR.clear()
                detail.setValue("")

               }
          }})
  */                     

        bookSearch.addClickListener({ event ->
          String s = idBook.getValue()
          
         

          if(idBook.getValue() == ""){
              Notification.show("กรุณาระบุ รหัสหนังสือ", Notification.Type.TRAY_NOTIFICATION)
            }else if(idBook.getValue().length() < 10){
              Notification.show("รหัสหนังสือไม่ถูกต้อง โปรดลองใหม่อีกครั้ง", Notification.Type.TRAY_NOTIFICATION)

              nameBook.clear()
              bookType.clear()
              bookStatus.clear()
              bookDateR.clear()
              detail.setValue("")
            }
            

            else
          control.chkBook(idBook.getValue()) 
          
          } as Button.ClickListener)

      HorizontalLayout buttonLayout = new HorizontalLayout()
      HorizontalLayout dateLayout = new HorizontalLayout()
        submit = new Button("บันทึกการยืม")
        submit.setIcon(FontAwesome.SAVE)
        submit.addStyleName(ValoTheme.BUTTON_FRIENDLY)

        if(nameBook.getValue() == "" || name.getValue() == ""){
          submit.setEnabled(false)
        }else{
          submit.setEnabled(true)
        }
        cancel = new Button("ยกเลิก")
        cancel.setIcon(FontAwesome.TRASH_O)
        cancel.addStyleName(ValoTheme.BUTTON_DANGER)

            submit.addClickListener({ event -> 

              String detailGet

              if(idUser.getValue() == "" || idBook.getValue() == ""){
                Notification.show("กรุณาตรวจสอบข้อมูล สมาชิก", Notification.Type.TRAY_NOTIFICATION)
              }else if(nameBook.getValue() == "" || name.getValue() == ""){
                Notification.show("กรุณาตรวจสอบข้อมูล ข้อมูลหนังสือ", Notification.Type.TRAY_NOTIFICATION)
              }

              else{
                if(detail.getValue() ==""){
                    detailGet = "--No detail--"
                }else {
                    detailGet = detail.getValue()
                }
              control.addBorrow(idUser.getValue(),idBook.getValue(),inlineDateB.getValue(),detailGet) 
            }


              } as Button.ClickListener)

            cancel.addClickListener({ event -> 
             
                  control.clearB()

                    } as Button.ClickListener)


      // A pop-up view without minimalized representation
      TextField nameShow
      TextField username

        FormLayout sample = new FormLayout();
        sample.addStyleName("outlined");
        //sample.setSizeFull();
        sample.setWidth("20em")
        sample.setSpacing(true);
 
 
        sample.addComponent(new CheckBox("Child 3"));
        sample.addComponent(new Button("Child 4"));
     /*  
       
       PopupView popup = new PopupView(null,sample
          
          //nameShow = new TextField("ชื่่อ-สกุล สมาชิก :  ")
          //nameShow.setIcon(FontAwesome.USER)


    )
*/


      

       /* 
       edit.addClickListener({ event ->  
          String user =  idUser.getValue()
          String book =  idBook.getValue()  
                UI.getCurrent().addWindow(new MySub())
                   } as Button.ClickListener)

   /*   
        
      // A component to open the view
    Button button = new Button("Show table", {click -> // Java 8
     popup.setPopupVisible(true)}as Button.ClickListener);

*/


      //button
      buttonLayout.addComponent(submit)
      buttonLayout.addComponent(cancel)


      //book
      ahlayout.addComponent(idBooktxt)
      ahlayout.addComponent(idBook)
      //ahlayout.addComponent(counter)
      ahlayout.addComponent(bookSearch)

      bhlayout.addComponent(nameBooktxt) 
      bhlayout.addComponent(nameBook)

      chlayout.addComponent(bookTypetxt)
      chlayout.addComponent(bookType)

      dhlayout.addComponent(bookStatustxt)
      dhlayout.addComponent(bookStatus)

      fhlayout.addComponent(bookDateRtxt)
      fhlayout.addComponent(bookDateR)

      ehlayout.addComponent(datetxt)
      ehlayout.addComponent(inlineDateB)

      ghlayout.addComponent(detailtxt)
      ghlayout.addComponent(detail)


      //ehlayout.addComponent(inlineDateR)

      mvlayout.addComponent(ahlayout)
      mvlayout.addComponent(bhlayout)
      mvlayout.addComponent(chlayout)
      mvlayout.addComponent(dhlayout)
      mvlayout.addComponent(fhlayout)
      //mvlayout.addComponent(eehlayout)
      mvlayout.addComponent(ehlayout)
      mvlayout.addComponent(ghlayout)
      mHlayout.addComponent(vlayout)
     // 

      //dateLayout.addComponent(popupDateB)
      //dateLayout.addComponent(popupDateR)

      //mvlayout.addComponent(popupDateB)
      mHlayout.addComponent(mvlayout)
      
      mainVlayout.addComponent(mHlayout)
      //mainVlayout.addComponent(dateLayout)
      mainVlayout.addComponent(buttonLayout)
      //mHlayout.addComponent(vvlayout)
      //mHlayout.addComponent(popup)
      //mainVlayout.addComponent(popupContent)
      //mainVlayout.addComponents(button, popup);
      //mainVlayout.addComponent(edit)
      

      mainVlayout.setComponentAlignment(mHlayout,Alignment.MIDDLE_CENTER)
      mainVlayout.setComponentAlignment(buttonLayout,Alignment.MIDDLE_RIGHT)
      //mainVlayout.setComponentAlignment(mvlayout,Alignment.MIDDLE_LEFT)

      setCompositionRoot(panel)




    }




      
}

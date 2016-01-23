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


class BookReturn extends CustomComponent {

    static TextField idUser
    static TextField name
    static TextField userType
    static TextField idBook
    static TextField nameBook
    static TextField bookType
    static TextField bookStatus
    static TextField dateReturn
    static TextArea detail
    static TextField fine
    static Button submit
    static Button cancel


    public BookReturn(){
        super()
        this.configure()

    }

    public BookReturn(String caption) {
      super(caption)
      this.configure()
    }

    private void configure() {

      Controller control = new Controller()

      VerticalLayout center = new VerticalLayout()

      Panel panel = new Panel("คืนหนังสือ")
      VerticalLayout mainVlayout = new VerticalLayout()

      HorizontalLayout mHlayout = new HorizontalLayout()

      //VerticalLayout mainLayout = new VerticalLayout()
      VerticalLayout vlayout = new VerticalLayout()
      VerticalLayout vvlayout = new VerticalLayout()
      HorizontalLayout hlayout = new HorizontalLayout()
      HorizontalLayout hhlayout = new HorizontalLayout()
      HorizontalLayout hhhlayout = new HorizontalLayout()
      panel.setContent(mainVlayout)
      vlayout.setSpacing(true)
      vlayout.setMargin(true)
      vvlayout.setSpacing(true)
      vvlayout.setMargin(true)
      vlayout.setWidth("100%")
      vvlayout.setWidth("100%")


      HorizontalLayout ahlayout = new HorizontalLayout()
      HorizontalLayout bhlayout = new HorizontalLayout()
      HorizontalLayout chlayout = new HorizontalLayout()
      HorizontalLayout dhlayout = new HorizontalLayout()
      HorizontalLayout ehlayout = new HorizontalLayout()
      HorizontalLayout fhlayout = new HorizontalLayout()
      HorizontalLayout ghlayout = new HorizontalLayout()
      HorizontalLayout gghlayout = new HorizontalLayout()
      HorizontalLayout ihlayout = new HorizontalLayout()
      VerticalLayout mvlayout = new VerticalLayout()
      VerticalLayout dvlayout = new VerticalLayout()

      mvlayout.setSpacing(true)
      mvlayout.setMargin(true)

      idBook = new TextField()
        Label idBooktxt = new Label("      รหัสหนังสือ : ")
            idBooktxt.addStyleName("fancylabel")
            idBook.setMaxLength(10)
          Button bookSearch = new Button("ค้นหา")
            bookSearch.addStyleName("myButtonSearch")
            //bookSearch.setEnabled(false)

            bookSearch.setClickShortcut(ShortcutAction.KeyCode.ENTER);


      nameBook = new TextField()
        Label nameBooktxt = new Label("            ชื่อเรื่อง : ")
          nameBook.setWidth("16em")
          nameBook.setEnabled(false)

      bookType = new TextField()
        Label bookTypetxt = new Label("ประเภทหนังสือ : ")
          bookType.setWidth("16em")
          bookType.setEnabled(false)
      bookStatus = new TextField()
        Label bookStatustxt = new Label("             สถานะ : ")
          bookStatus.setEnabled(false)
      dateReturn = new TextField()
        Label dateReturntxt = new Label("        กำหนดส่ง : ")
          dateReturn.setEnabled(false)

      fine = new TextField()
        Label finetxt = new Label("             ค่าปรับ : ")
          fine.setEnabled(false)
          fine.addStyleName("redCenterLabel")
          finetxt.addStyleName("fancylabel")
            fine.setWidth("5em")
        Label unittxt = new Label(" บาท")


      detail = new TextArea()
        Label detailtxt = new Label("         หมายเหตุ : ")
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
                dateReturn.clear()
                fine.setValue("")
                detail.setValue("")
                submit.setEnabled(false)
                
               }
          }})

*/

        bookSearch.addClickListener({ event -> 

          if(idBook.getValue() == ""){
              Notification.show("กรุณาระบุ รหัสหนังสือ", Notification.Type.TRAY_NOTIFICATION)
          }else if(idBook.getValue().length() < 10){
              Notification.show("รหัสหนังสือไม่ถูกต้อง โปรดลองใหม่อีกครั้ง", Notification.Type.TRAY_NOTIFICATION)
              nameBook.clear()
              bookType.clear()
              bookStatus.clear()
              dateReturn.clear()
              fine.clear()
              detail.setValue("")
            }else

          control.chkBookR(idBook.getValue()) 
          
          } as Button.ClickListener)

      
      HorizontalLayout buttonLayout = new HorizontalLayout()
        submit = new Button("บันทึกการคืน")
        submit.setIcon(FontAwesome.SAVE)
        submit.addStyleName(ValoTheme.BUTTON_FRIENDLY)
        if(nameBook.getValue() == ""){
          submit.setEnabled(false)
        }else if(nameBook.getValue() != ""){
          submit.setEnabled(true)
        }
        cancel = new Button("ยกเลิก")
        cancel.setIcon(FontAwesome.TRASH_O)
        cancel.addStyleName(ValoTheme.BUTTON_DANGER)

            submit.addClickListener({ event -> 
              String detailGet

              if(idBook.getValue() == ""){
                Notification.show("กรุณาตรวจสอบ ข้อมูลหนังสือ", Notification.Type.TRAY_NOTIFICATION)
              }else if(nameBook.getValue() == ""){
                Notification.show("กรุณาตรวจสอบ ข้อมูลหนังสือ", Notification.Type.TRAY_NOTIFICATION)
              }
              else{
                if(detail.getValue() == ""){
                  detailGet = "--No Detail--"
                }else {
                  detailGet = detail.getValue()
                }
              control.addBorrowReturn(idBook.getValue(),detailGet) 
            }

              } as Button.ClickListener)

            cancel.addClickListener({ event ->      
                  control.clearR()
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
       
       PopupView popup = new PopupView(null,sample
          
    )


      

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
      ahlayout.addComponent(bookSearch)

      bhlayout.addComponent(nameBooktxt) 
      bhlayout.addComponent(nameBook)

      chlayout.addComponent(bookTypetxt)
      chlayout.addComponent(bookType)

      dhlayout.addComponent(bookStatustxt)
      dhlayout.addComponent(bookStatus)

      ehlayout.addComponent(dateReturntxt)
      ehlayout.addComponent(dateReturn)

      fhlayout.addComponent(finetxt)
      fhlayout.addComponent(fine)
      fhlayout.addComponent(unittxt)\

      ihlayout.addComponent(detailtxt)
      ihlayout.addComponent(detail)

      mvlayout.addComponent(ahlayout)
      mvlayout.addComponent(bhlayout)
      mvlayout.addComponent(chlayout)
      mvlayout.addComponent(dhlayout)
      mvlayout.addComponent(ehlayout)
      mvlayout.addComponent(fhlayout)
      mvlayout.addComponent(ihlayout)
      //mvlayout.addComponent(ghlayout)
      //mvlayout.addComponent(gghlayout)

      mHlayout.addComponent(vlayout)
      mHlayout.addComponent(mvlayout)
      mainVlayout.addComponent(mHlayout)
      //>>
      mainVlayout.addComponent(buttonLayout)
      //mHlayout.addComponent(vvlayout)
      //mHlayout.addComponent(popup)
      //mainVlayout.addComponent(popupContent)
      //mainVlayout.addComponents(button, popup);
      //mainVlayout.addComponent(edit)
      

      mainVlayout.setComponentAlignment(mHlayout,Alignment.MIDDLE_CENTER)
      mainVlayout.setComponentAlignment(buttonLayout,Alignment.MIDDLE_RIGHT)

      setCompositionRoot(panel)




    }




      
}

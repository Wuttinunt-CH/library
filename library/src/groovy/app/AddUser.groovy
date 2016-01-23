package app

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
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button
import com.vaadin.ui.CustomComponent
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Panel
import com.vaadin.ui.TextField
import com.vaadin.ui.UI
import com.vaadin.ui.TextArea
import com.vaadin.ui.OptionGroup
import com.vaadin.ui.DateField
import com.vaadin.ui.ComboBox
import com.vaadin.ui.Table
import com.vaadin.ui.NativeSelect
import com.vaadin.ui.Label
import com.vaadin.ui.Grid
import com.vaadin.Grails.*
import com.vaadin.server.*
import com.vaadin.terminal.*
import com.vaadin.ui.*
import com.vaadin.annotations.*
import com.vaadin.data.*
import java.util.*
import system.*
import app.*
import app.User.*
import library.*
import library.User
import com.vaadin.ui.themes.ValoTheme
import com.vaadin.ui.themes.Reindeer
import com.vaadin.data.Property.*
import com.vaadin.ui.Grid.SelectionMode



class AddUser extends CustomComponent {

    static TextField username
    static TextField password
    static ComboBox prefix
    static TextField fname
    static TextField lname
    static ComboBox sex
    static TextField age
    static TextField tel
    static TextField email
    static PopupDateField dateReg
    static ComboBox typeUser


    static TextArea detail
    static TextField fine
    static Button submit
    static Button cancel


    public AddUser(){
        super()
        this.configure()

    }

    public AddUser(String caption) {
      super(caption)
      this.configure()
    }

    private void configure() {

      Controller control = new Controller()

      VerticalLayout center = new VerticalLayout()

      Panel panel = new Panel("เพิ่ม สมาชิก")
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
      HorizontalLayout jhlayout = new HorizontalLayout()
      HorizontalLayout khlayout = new HorizontalLayout()
      HorizontalLayout lhlayout = new HorizontalLayout()
      HorizontalLayout mhlayout = new HorizontalLayout()
      HorizontalLayout gghlayout = new HorizontalLayout()
      HorizontalLayout ihlayout = new HorizontalLayout()
      VerticalLayout mvlayout = new VerticalLayout()
      VerticalLayout dvlayout = new VerticalLayout()

      mvlayout.setSpacing(true)
      mvlayout.setMargin(true)


     	username = new TextField("ชื่อผู้ใช้ : ")
        username.setIcon(FontAwesome.USER)
        username.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON)
        username.setInputPrompt("B58xxxxx")
        username.setMaxLength(8);
        username.setWidth("25em")

     	password = new TextField("รหัส : ")
        password.setIcon(FontAwesome.LOCK)
        password.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON)
        password.setInputPrompt("ตัวเลข 4 หลัก")
        password.setMaxLength(4);
        password.setWidth("20em")

     	prefix = new ComboBox("คำนำหน้า : ")
        prefix.addItems("นาย","นางสาว","นาง")
        prefix.setWidth("25em")
        prefix.setNullSelectionAllowed(false)

     	fname = new TextField("ชื่อ")
        fname.setWidth("25em")
        fname.setInputPrompt("บัวตูม")

     	lname = new TextField("สกุล")
        lname.setWidth("25em")
        lname.setInputPrompt("บัวบาน")

     	sex = new ComboBox("เพศ")
        sex.addItem("ชาย")
        sex.addItem("หญิง")
        sex.setNullSelectionAllowed(false)
        sex.setWidth("25em")

     	age = new TextField("อายุ")

     	tel = new TextField("เบอร์")
        tel.setWidth("25em")
        tel.setInputPrompt("08xxxxxxxx")
        tel.setMaxLength(10);

     	email = new TextField("email")
        email.setWidth("25em")
        email.setInputPrompt("exsample@email.com")

     	typeUser = new ComboBox("ประเภทสมาชิก")

     	def u = UserGroup.executeQuery("from UserGroup")

     		for(a in u){
     			typeUser.addItem(a)
     		}


     	dateReg = new PopupDateField("วันที่ลงทะเบียน")


     	ahlayout.addComponent(username)
     	bhlayout.addComponent(password)
     	chlayout.addComponent(prefix)
     	dhlayout.addComponent(fname)
     	ehlayout.addComponent(lname)
     	fhlayout.addComponent(sex)
     	ghlayout.addComponent(age)
     	jhlayout.addComponent(tel)
     	khlayout.addComponent(email)
     	
     	lhlayout.addComponent(dateReg)
     	mhlayout.addComponent(typeUser)
      
      HorizontalLayout buttonLayout = new HorizontalLayout()
        submit = new Button("บันทึก")
        submit.setIcon(FontAwesome.SAVE)
        submit.addStyleName(ValoTheme.BUTTON_FRIENDLY)
        
        cancel = new Button("ยกเลิก")
        cancel.setIcon(FontAwesome.TRASH_O)
        cancel.addStyleName(ValoTheme.BUTTON_DANGER)

            submit.addClickListener({ event -> 
              
            	Integer ageToInt = Integer.parseInt(age.getValue())
            	//char sexTochar = sex.getValue()
              Character sexTochar
        if(sex.getValue() == "ชาย"){
            sexTochar = 'M'
        }else if(sex.getValue() == "หญิง"){
            sexTochar = 'F'
        }
          control.addUser(username.getValue(),password.getValue(),prefix.getValue(),fname.getValue(),
          lname.getValue(),sexTochar,ageToInt,tel.getValue(),email.getValue(),dateReg.getValue()) 

              }as Button.ClickListener)

            cancel.addClickListener({ event ->      
                  //control.clearR()
                  } as Button.ClickListener)


    

      

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




      mvlayout.addComponent(ahlayout)
      mvlayout.addComponent(bhlayout)
      mvlayout.addComponent(chlayout)
      mvlayout.addComponent(dhlayout)
      mvlayout.addComponent(ehlayout)
      mvlayout.addComponent(fhlayout)
      mvlayout.addComponent(ghlayout)
      mvlayout.addComponent(jhlayout)
      mvlayout.addComponent(khlayout)
      
      mvlayout.addComponent(lhlayout)
      mvlayout.addComponent(mhlayout)


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

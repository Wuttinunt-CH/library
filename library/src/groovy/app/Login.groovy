 package app



import com.vaadin.ui.*
import com.vaadin.grails.*
import com.vaadin.terminal.*
import com.vaadin.server.*
import com.vaadin.ui.MenuBar.MenuItem
import com.vaadin.annotations.*
import com.vaadin.ui.Image
import com.vaadin.data.*
import com.vaadin.shared.ui.combobox.FilteringMode
import com.vaadin.data.Property.ValueChangeEvent
import com.vaadin.data.Property.ValueChangeListener
import com.vaadin.data.util.BeanItemContainer
import com.vaadin.event.ShortcutAction.*;
import com.vaadin.event.*;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.themes.Reindeer
import com.vaadin.ui.themes.Runo
import java.util.*
import library.*



@Theme("todo")

class Login extends UI {
   
    public VerticalLayout page = new VerticalLayout()

    public VerticalLayout manage(String x) {
        page.removeAllComponents()
        
            VerticalLayout loginPage = loginPage()
            page.addComponent(loginPage)
            page.setComponentAlignment(loginPage,Alignment.MIDDLE_CENTER)

        return page
    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {

    }
      
        
     

public VerticalLayout loginPage() {

    VerticalLayout index = new VerticalLayout()
        index.setMargin(true)
        index.setWidth("25%")

        Panel box = new Panel()
        Panel cform = new Panel()
        Panel sform = new Panel()
        Panel txtheader = new Panel()
        HorizontalLayout header = new HorizontalLayout()
        VerticalLayout content = new VerticalLayout()
        HorizontalLayout footer = new HorizontalLayout()
        VerticalLayout big = new VerticalLayout()
        TextField username = new TextField("Username")
        username.setInputPrompt("ex. John")
        username.setRequired(true)
        username.setWidth("12em")
        username.setIcon(FontAwesome.USER)
        PasswordField password = new PasswordField("Password")
        password.setInputPrompt("12345678")
        password.setRequired(true)
        password.setWidth("12em")
        password.setIcon(FontAwesome.KEY)
        Button submit = new Button("Login")
        Button cancel = new Button("Cancel")

        //submit.setIcon(FontAwesome.SIGN_IN);
        submit.addStyleName("myButtonLogin");
        cancel.addStyleName("myButtonCancel")
        //submit.addStyleName(Reindeer.BUTTON_SMALL);
        //submit.addStyleName("blue");
        username.focus()
        
        //submit.addStyleName(ValoTheme.BUTTON_PRIMARY);
        
        Label txt = new Label("Please Login")

        submit.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        header.setSpacing(true)
        content.setSpacing(true)
       // footer.setSpacing(true)
        header.setMargin(true)
        content.setMargin(true)
        //footer.setMargin(true)
        big.setSpacing(true)
        big.setMargin(true)

        box.setContent(big)
        //txtheader.setContent(header)
        cform.setContent(content)
        //sform.setContent(footer)

        //big.addComponent(txtheader)
        big.addComponent(cform)
        //big.addComponent(sform)


        

        header.addComponent(txt)
        content.addComponent(username)
        content.addComponent(password)
        footer.addComponent(submit)
        footer.addComponent(cancel)
        content.addComponent(footer)
        content.setComponentAlignment(username,Alignment.MIDDLE_CENTER)
        content.setComponentAlignment(password,Alignment.MIDDLE_CENTER)
        //content.setComponentAlignment(submit,Alignment.BOTTOM_RIGHT)
        content.setComponentAlignment(footer,Alignment.BOTTOM_RIGHT)
        index.addComponent(box)

        submit.addClickListener({ event ->
            LoginController e = new LoginController()
            if(username.getValue() ==""){

                Notification.show("กรุณาระบุ : Username", Notification.Type.TRAY_NOTIFICATION);

    
                }else if(e.loginCheck(username.getValue().toUpperCase(),password.getValue()) == 1 || username.getValue()=="a" && password.getValue() == "a") {
                //DrugUI d = new DrugUI()
                Object c = UI.getCurrent().getSession().setAttribute("login",username)
                Page.getCurrent().getJavaScript().execute("location.reload()");

            }else {
                Notification.show("Username หรือ Password ไม่ถูกต้อง !!!", Notification.Type.TRAY_NOTIFICATION);
                password.focus()
                Object c = UI.getCurrent().getSession().setAttribute("login",null)
            }
        
        } as Button.ClickListener)


        cancel.addClickListener({ event ->
            
            username.clear()
            password.setValue("")
        
        } as Button.ClickListener)

        return index

}



    String getUserLogin() {
        Object c = UI.getCurrent().getSession().getAttribute("login")
        return c
    }
    public VerticalLayout menubar() {

          VerticalLayout m = new VerticalLayout()
          MenuBar mBar = new MenuBar()

          MenuItem user_show = mBar.addItem("Welcome : " + getUserLogin() + " ", null, null)
          
          
          MenuItem log_m = mBar.addItem("Sign Out", FontAwesome.SIGN_OUT,  new MenuBar.Command() {
                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                            Object c = UI.getCurrent().getSession().setAttribute("login",null)
                            Page.getCurrent().getJavaScript().execute("location.reload()");
                        }})
          if(getUserLogin() == "admin") {
          /* admin_m.addItem("Add Employee", FontAwesome.PLUS, new MenuBar.Command() {
                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                            manage("addEmployee")
                        }})

*/    
          m.addComponent(mBar)
            return m
    }
  
 
        
}
}
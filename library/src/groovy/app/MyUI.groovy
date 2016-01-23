package app

import com.vaadin.ui.*
import com.vaadin.grails.*
import com.vaadin.terminal.*
import com.vaadin.server.*
import com.vaadin.ui.MenuBar.MenuItem
import com.vaadin.annotations.*
import com.vaadin.ui.Image
import com.vaadin.data.*

import app.MyUI
import app.*
import app.Book_BnR.*
import library.*

import com.vaadin.ui.themes.ValoTheme
import com.vaadin.ui.themes.Reindeer

//import app.one.*


@Title("ระบบจัดการห้องสมุด") 
@Theme("todo")

class MyUI extends UI {

    LoginController n = new LoginController()
    static String typeUserCheckLevel
   
    public VerticalLayout page = new VerticalLayout()

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Object c = UI.getCurrent().getSession().getAttribute("login")
        VerticalLayout layout = new VerticalLayout()
        //layout.setWidth("100em")
        layout.setMargin(true)
        //layout.setSizeUndefined()
        VerticalLayout mmLayout = new VerticalLayout()
        //mmLayout.setMargin(true)
        //mmLayout.setWidth(true)

        //layout.setComponentAlignment(mmLayout,Alignment.MIDDLE_CENTER)
            
        if(c == null) {
            println("")
            
            VerticalLayout page = homeIndex()
            layout.addComponent(page)
            layout.setComponentAlignment(page,Alignment.MIDDLE_CENTER)
        }else {
          
          String nameV = getUserLogin()
          def nameView = User.executeQuery("from User where username = :uu",[uu : nameV.toUpperCase()])
          System.out.println("size User >>"+nameView.size())
          System.out.println("user  >>"+nameV)
          String nameF
          String nameL

          for(h in nameView){
                nameF = h.fname
                nameL = h.lname
                typeUserCheckLevel = h.group.id_group
                System.out.println("User Level  >>"+nameView.size())
          
          }
          
          //Panel mpanel = new Panel()
          VerticalLayout mLayout = new VerticalLayout()
          HorizontalLayout hLayout = new HorizontalLayout()
          //mLayout.setMargin(true)
          //mLayout.setSpacing(true)
          //mpanel.setContent(mLayout)

          ThemeResource imghome = new ThemeResource("img/clrem_logo_th.png")
          Image image = new Image("",imghome);
          	image.setWidth("50em")

          Label textUser = new Label("►Welcome◄ Username : "+ getUserLogin() + "  [ "+ nameF +" " +nameL +" ]     ")
          Button buttonLogout = new Button()
          	textUser.addStyleName("custom-label")          
          //buttonLogout.setIcon(FontAwesome.SIGN_OUT)
          buttonLogout.addStyleName("buttonLogout")
          //buttonLogout.addStyleName(Reindeer.LABEL_H1)


          buttonLogout.addClickListener({ event ->
                c = UI.getCurrent().getSession().setAttribute("login",null)
                Page.getCurrent().getJavaScript().execute("location.reload()");
                System.out.println("User Logout")
        
        } as Button.ClickListener)
          hLayout.addComponent(image)        
          hLayout.addComponent(textUser)
          hLayout.addComponent(buttonLogout)
          mLayout.addComponent(hLayout)
          mLayout.setComponentAlignment(hLayout,Alignment.TOP_RIGHT)
         

          VerticalLayout mBar = menubar()

         
          mmLayout.addComponent(mBar)
          layout.addComponent(mLayout)
          layout.addComponent(mmLayout)
          //layout.setComponentAlignment(mBar,Alignment.TOP_RIGHT)
          //layout.setComponentAlignment(mpanel,Alignment.TOP_RIGHT)

          VerticalLayout page = manage()
          layout.addComponent(page)
          page.setWidth("100%")
          layout.setComponentAlignment(page,Alignment.MIDDLE_RIGHT)
          layout.setComponentAlignment(mmLayout,Alignment.TOP_CENTER)
          layout.setComponentAlignment(mLayout,Alignment.TOP_CENTER)
          //layout.setComponentAlignment(mBar,Alignment.TOP_CENTER)
          
        } 
        setContent(layout)
    }

    protected VerticalLayout manage(String mode) {
      

      VerticalLayout alayout = new VerticalLayout()
      page.removeAllComponents()      


     System.out.println(mode)


        if(mode == "addBorrow") {

            Book_BnR.BorrowBook r = new Book_BnR.BorrowBook()
            alayout.addComponent(r)
            println("BorrowBook page")
            page.addComponent(alayout)

        }else if(mode == "addReturn"){
            Book_BnR.BookReturn d = new Book_BnR.BookReturn()
            alayout.addComponent(d)
            println("BookReturn Page")
            page.addComponent(alayout)
        }else if(mode == "BandR"){
            TodoEditboss t = new TodoEditboss()
            alayout.addComponent(t)
            println("BookReturn Page")
            page.addComponent(alayout)
        }else if(mode == "addReserv"){
            Reservations1  rr= new Reservations1()
            Reservations rrr = new Reservations()
            alayout.addComponent(rr)
            alayout.addComponent(rrr)
            println("reserv Page")
            page.addComponent(alayout)
        }else if(mode == "addReserv1"){
            
            Reservations2 rrrr = new Reservations2()
            
            alayout.addComponent(rrrr)
            println("reserv1 Page")
            page.addComponent(alayout)
        }
        else if(mode == "addOrder"){
            BookOrder2 order = new BookOrder2()
            alayout.addComponent(order)
            //alayout.addComponent(order)
            println("Order Page")
            page.addComponent(alayout)
        }
        else if(mode == "addBook"){
            Bookdata bookdata = new Bookdata()
            alayout.addComponent(bookdata)
            //alayout.addComponent(order)
            println("addBook Page")
            page.addComponent(alayout)
        }
        else if(mode == "searchBook"){
            Booksearch booksearch = new Booksearch()
            alayout.addComponent(booksearch)
            //alayout.addComponent(order)
            println("searchBook Page")
            page.addComponent(alayout)
        }
        else if(mode == "Repair"){
            RepairBook rep = new RepairBook()
            alayout.addComponent(rep)
            println("RepairBook Page")
            page.addComponent(alayout)
        }    
        else if(mode == "Reserve"){
            Reserve_book reserve = new Reserve_book()
            alayout.addComponent(reserve)
            println("RepairBook Page")
            page.addComponent(alayout)
        } 
        else if(mode == "addUser"){
            AddUser uuu = new AddUser()
            alayout.addComponent(uuu)
            println("Add User Page")
            page.addComponent(alayout)
        }
        else if(mode == "UserShow"){
            UserShow uss = new UserShow()
            alayout.addComponent(uss)
            println("Show User Page")
            page.addComponent(alayout)
        }     
        else{
            VerticalLayout home = home()
            println("user already logged in")
            println("login by "+ getUserLogin())


            page.addComponent(home)
            page.setComponentAlignment(home,Alignment.MIDDLE_CENTER)
            println("Load data Homepage")
            
        }
           

        return page
    }
    String getUserLogin() {
        Object c = UI.getCurrent().getSession().getAttribute("login")
        return c
    }

   

    public VerticalLayout menubar() {

        String ggname = getUserLogin().toString()
        String userGroup
        def name = User.executeQuery("from User where username = :user",[user:ggname])

          for(n in name) {
              
              userGroup = n.group
              
      
              }

          VerticalLayout m = new VerticalLayout()
          //MenuBar mBar = new MenuBar()

          System.out.println(userGroup)

          //MenuItem user_show = mBar.addItem("Hello : " + getUserLogin() + " ", null, null) 
         // MenuItem not = mBar.addItem(" Not NotAllow ", null, null) 


        //  MenuItem drug_m = mBar.addItem("ข้อมูลยา", FontAwesome.EDIT,null)
                         

          MenuBar mBar = new MenuBar()

           MenuItem home = mBar.addItem("   หน้าหลัก   ", FontAwesome.HOME, new MenuBar.Command(){

                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                          Page.getCurrent().getJavaScript().execute("location.reload()")

                        }})

           if(typeUserCheckLevel == "admin" || typeUserCheckLevel == "authority"){

      //layout.addComponent(mBar)
        MenuItem a = mBar.addItem("ยืม-คืนหนังสือ", FontAwesome.BOOK,null)
                      a.addItem("ยืมหนังสือ",FontAwesome.PLUS , new MenuBar.Command() {
                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                            //BorrowBook borrow = new BorrowBook()
                            //layout.addComponent(borrow)
                            manage("addBorrow")
                      }})
                      a.addItem("คืนหนังสือ",FontAwesome.REPLY , new MenuBar.Command() {
                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                            //BookReturn returnB = new BookReturn()
                            //layout.addComponent(returnB)
                            manage("addReturn")
                      }})
        MenuItem bookingRoomMenu = mBar.addItem("จองห้องค้นคว้า", FontAwesome.TICKET,null)
                        bookingRoomMenu.addItem("จองห้องค้นคว้า",FontAwesome.PLUS, new MenuBar.Command() {
                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                          manage("addReserv")
                            }})                            
                           

        MenuItem orderbook = mBar.addItem("สั่งซื้อและแจ้งซ่อม", FontAwesome.SHOPPING_CART,null)
                        orderbook.addItem("สั่งซื้อหนังสือเข้าห้องสมุด",FontAwesome.SHOPPING_CART , new MenuBar.Command() {
                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                            //BookOrder2 order = new BookOrder2()
                            //layout.addComponent(order)
                            manage("addOrder")

                      }})
                       orderbook.addItem("แจ้งซ่อมหนังสือ",FontAwesome.WRENCH , new MenuBar.Command() {
                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                           manage("Repair")
                      }})
                                             

                      bookingRoomMenu.addItem("สละสิทธิ์การจองห้อง",FontAwesome.TABLE, new MenuBar.Command() {
                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                          manage("addReserv1")
                          
                      }})

        MenuItem bookdata1 = mBar.addItem("บันทึกข้อมูลหนังสือ", FontAwesome.SAVE,new MenuBar.Command(){
                         @Override
                        public void menuSelected(MenuItem selectedItem) {
                            //BookOrder2 order = new BookOrder2()
                            //layout.addComponent(order)
                            manage("addBook")

                      }})

        


       

        MenuItem boss = mBar.addItem("ยืมคืนอุปกรณ์", FontAwesome.HAND_O_RIGHT,null)
                       boss.addItem("ยืมคืนอุปกรณ์",FontAwesome.PLUS , new MenuBar.Command() {
                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                           manage("BandR")
                      }})

        MenuItem boss2 = mBar.addItem("จองหนังสือ", FontAwesome.HAND_O_RIGHT,null)
                       boss2.addItem("จองหนังสือ",FontAwesome.PLUS , new MenuBar.Command() {
                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                           manage("Reserve")
                      }})  

         MenuItem arm = mBar.addItem("งานทะเบียนสมาชิก", FontAwesome.BOLT,null)
                       arm.addItem("ลงทะเบียนสมาชิก",FontAwesome.PLUS , new MenuBar.Command() {
                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                           manage("addUser")
                      }})   
                      arm.addItem("ลบข้อมูลสมาชิก",FontAwesome.ERASER , new MenuBar.Command() {
                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                           manage("UserShow")
                      }})              

}else {

	MenuItem booksearch1 = mBar.addItem("      ค้นหาหนังสือ      ", FontAwesome.SEARCH,new MenuBar.Command(){
                         @Override
                        public void menuSelected(MenuItem selectedItem) {
                            //BookOrder2 order = new BookOrder2()
                            //layout.addComponent(order)
                            manage("searchBook")

                      }})
}
/*  
         
          MenuItem log_m = mBar.addItem("Welcome "+ getUserLogin()+"Sign Out", FontAwesome.SIGN_OUT,  new MenuBar.Command() {
                        @Override
                        public void menuSelected(MenuItem selectedItem) {
                            Object c = UI.getCurrent().getSession().setAttribute("login",null)
                            Page.getCurrent().getJavaScript().execute("location.reload()");
                        }})

*/
         
          m.addComponent(mBar)
          m.setComponentAlignment(mBar,Alignment.TOP_CENTER)

          return m
    
}



protected VerticalLayout home() {

        String ggname = getUserLogin().toString()
        String fname
        String lname
        String userGroup
        //รอแก้ไข
        def name = Member.executeQuery("from Member where username = :user",[user:ggname])

          for(n in name) {
              fname = n.fname.toString()
              lname = n.lname.toString()
              //userGroup = n.group

              }
          
        // New value
        VerticalLayout home = new VerticalLayout()
        VerticalLayout layout = new VerticalLayout()
        VerticalLayout tlayout = new VerticalLayout()
       // VerticalLayout block0 = new VerticalLayout()
        VerticalLayout block1 = new VerticalLayout()
       // VerticalLayout block2 = new VerticalLayout()
       // VerticalLayout block3 = new VerticalLayout()
       // HorizontalLayout bt_inside = new HorizontalLayout()
        Panel box = new Panel()
        //Panel header = new Panel()
        //Panel content = new Panel()
        //Panel footer = new Panel()
        Label txt = new Label("บรรณาสาร ยินดีต้อนรับ")
        
       
        ThemeResource imghome = new ThemeResource("img/img2.jpg")
        Image image = new Image("",imghome);

        ThemeResource imghomeA = new ThemeResource("img/welcome.png")
        Image imageWel = new Image("",imghomeA);

        //set Width
        layout.setWidth("100%")
        //layout.setSizeFull()
        //layout.setMargin(true)
        home.setWidth("75%")
        txt.setStyleName("h2")
        block1.setWidth("40em")

        image.setWidth("50em")
        imageWel.setWidth("20em")
        //txt2.setStyleName("h2")


        //set spacing and margin
        //layout.setMargin(true)
        //layout.setSpacing(true)
        //home.setMargin(true)
        //home.setSpacing(true)
        layout.addComponent(imageWel)
        layout.addComponent(image)
        box.setContent(layout)
        //home.addComponent(txt)
        //layout.addComponent(txt2)
        page.addComponent(layout)
        page.addComponent(tlayout)
        //home.addComponent(box)
        layout.setComponentAlignment(imageWel,Alignment.MIDDLE_CENTER)
        layout.setComponentAlignment(image,Alignment.MIDDLE_CENTER)
        //page.setComponentAlignment(tlayout,Alignment.MIDDLE_CENTER)
        //home.setComponentAlignment(box,Alignment.TOP_CENTER)
        //home.setComponentAlignment(txt,Alignment.MIDDLE_CENTER)
        //home.setComponentAlignment(txt,Alignment.MIDDLE_CENTER)
        //image.setWidth("100%")
        
        return layout
 
    }    




   
    protected VerticalLayout homeIndex() {
        // New value
        VerticalLayout home = new VerticalLayout()
        Login e = new Login()
        VerticalLayout j = e.manage()
        home.addComponent(j)
        j.setWidth("100%")
        
        return home
 
    }    
}

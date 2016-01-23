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
import com.vaadin.event.SelectionEvent.*
import com.vaadin.ui.Grid.*
import com.vaadin.event.SelectionEvent.SelectionListener




import app.MyUI
import library.*

import com.vaadin.ui.themes.ValoTheme
import com.vaadin.ui.themes.Reindeer


class BookOrder2 extends CustomComponent {

    static Grid grid

    public BookOrder2(){
        super()
        this.configure()

    }


    public BookOrder2(String caption) {
      super(caption)
      this.configure()
    }

    private void configure() {

        VerticalLayout layout = new VerticalLayout()

        Panel panel = new Panel()
        panel.setContent(layout)
        layout.setSizeFull()
        layout.setMargin(true)


        HorizontalLayout hlayout = new HorizontalLayout()
        hlayout.setSpacing(true)
        layout.addComponent(hlayout)

        TextField textName = new TextField()
        Label l1 = new Label("ชื่อหนังสือ:")
        textName.setSizeFull()
        textName.setWidth("9em")
        hlayout.addComponent(l1)
        hlayout.addComponent(textName)
        hlayout.setExpandRatio(textName, 1.0f)

        TextField textType = new TextField()
        Label l2 = new Label("ประเภทหนังสือ:")
        textType.setSizeFull()
        textType.setWidth("9em")
        hlayout.addComponent(l2)
        hlayout.addComponent(textType)
        hlayout.setExpandRatio(textType, 1.0f)


        TextField textPub = new TextField()
        Label l3 = new Label("สำนักพิมพ์:")
        textPub.setSizeFull()
        textPub.setWidth("7em")
        hlayout.addComponent(l3)
        hlayout.addComponent(textPub)
        hlayout.setExpandRatio(textPub, 1.0f)

        TextField textCost = new TextField()
        Label l4 = new Label("ราคาหนังสือ:")
        textCost.setSizeFull()
        textCost.setWidth("7em")
        hlayout.addComponent(l4)
        hlayout.addComponent(textCost)
        hlayout.setExpandRatio(textCost, 1.0f)

        TextField textNum = new TextField()
        Label l5 = new Label("จำนวนหนังสือ:")
        textNum.setSizeFull()
        textNum.setWidth("7em")
        hlayout.addComponent(l5)
        hlayout.addComponent(textNum)
        hlayout.setExpandRatio(textNum, 1.0f)

        Button buttonAdd = new Button("เพิ่ม")
        hlayout.addComponent(buttonAdd)
        hlayout.setComponentAlignment(buttonAdd,Alignment.BOTTOM_CENTER)

        buttonAdd.addClickListener({event ->
            String n = textName.getValue()
            String t = textType.getValue()
            String p = textPub.getValue()
            String c = textCost.getValue()
            String nu = textNum.getValue()
            Integer a = Integer.parseInt(c)
            Integer b = Integer.parseInt(nu)
        
           Controller2 c2 = new Controller2()
            c2.order(n,t,p,a,b)
            } as Button.ClickListener)

        VerticalLayout vlayout = new VerticalLayout()
        vlayout.setSpacing(true)
        layout.addComponent(vlayout)

        Table table = new Table(" ");
        table.setWidth("100%")
        vlayout.addComponent(table)

        table.addContainerProperty("ชื่อหนังสือ",String.class, null);
        table.addContainerProperty("ประเภทหนังสือ",String.class, null);
        table.addContainerProperty("สำนักพิมพ์",String.class, null);
        table.addContainerProperty("ราคาหนังสือ",Integer.class, null);
        table.addContainerProperty("จำนวนหนังสือ",Integer.class, null);

        for (u in BookOrder.list()){
        Object newItemId = table.addItem()
        Item row1 = table.getItem(newItemId)
        row1.getItemProperty("ชื่อหนังสือ").setValue(u.bookname)
        row1.getItemProperty("ประเภทหนังสือ").setValue(u.booktypes)
        row1.getItemProperty("สำนักพิมพ์").setValue(u.bookpub)
        row1.getItemProperty("ราคาหนังสือ").setValue(u.bookcost)
        row1.getItemProperty("จำนวนหนังสือ").setValue(u.booknum)
        }       

      //  Button buttonDelete = new Button("ลบ")
      //  hlayout.addComponent(buttonDelete)
      //  hlayout.setComponentAlignment(buttonDelete,Alignment.BOTTOM_CENTER)

        setCompositionRoot(panel)

         }
     }
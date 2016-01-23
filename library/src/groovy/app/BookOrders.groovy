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


class BookOrders extends CustomComponent {

    static Grid grid

    public BookOrders(){
        super()
        this.configure()

    }


    public BookOrders(String caption) {
      super(caption)
      this.configure()
    }

    private void configure() {

    	Controller c = new Controller()

        Panel panel = new Panel()
        VerticalLayout layout = new VerticalLayout()
        VerticalLayout vlayout = new VerticalLayout();
        HorizontalLayout hlayout = new HorizontalLayout()
        panel.setContent(layout)

        Button buttonAdd = new Button("Add")
        buttonAdd.addStyleName(ValoTheme.BUTTON_PRIMARY)
        //Button buttonDelete = new Button("Delete")
        //buttonDelete.addStyleName(ValoTheme.BUTTON_PRIMARY);

        grid = new Grid("  ")
        grid.setWidth("100%")
        grid.addColumn("ชื่อหนังสือ", String.class);
        grid.addColumn("ประเภทหนังสือ", String.class);
        grid.addColumn("สำนักพิมพ์", String.class);
        grid.addColumn("ราคา", Integer.class);
        grid.addColumn("จำนวน", Integer.class);
        



        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        
        grid.setEditorEnabled(false);

     //   bo.loadBookOrder()



       /* grid.addSelectionListener(new SelectionListener() {
            @Override
            public void select(SelectionEvent event) {
                int no = grid.getSelectedRow() 
                String cid = grid.getContainerDataSource().getItem(no).getItemProperty("ลำดับ")
               
                System.out.println(cid)
              
                Item item = grid.getContainerDataSource().getItem(grid.getSelectedRow());
                System.out.println(item)
            }
        })
        bo.setTodoLayout(layout)

        */
        

        TextField textName = new TextField()
            Label l1 = new Label("  ชื่อหนังสือ: ")
        textName.setInputPrompt("ระบุชื่อหนังสือ")
        textName.setWidth("12em")
        hlayout.addComponent(l1)
        hlayout.addComponent(textName)

        TextField textType = new TextField()
            Label l2 = new Label("  ประภทหนังสือ: ")
        textType.setInputPrompt("ระบุชื่อหนังสือ")
        textType.setWidth("10em")
        hlayout.addComponent(l2)
        hlayout.addComponent(textType)

        TextField textPub = new TextField()
            Label l3 = new Label("  สำนักพิมพ์: ")
        textPub.setInputPrompt("ระบุสำนักพิมพ์")
        textPub.setWidth("9em")
        hlayout.addComponent(l3)
        hlayout.addComponent(textPub)

        TextField textCost = new TextField()
            Label l4 = new Label("  ราคาหนังสือ: ")
        textCost.setInputPrompt("ระบุราคาหนังสือ")
        textCost.setWidth("9em")
        hlayout.addComponent(l4)
        hlayout.addComponent(textCost)

        TextField textNum = new TextField()
            Label l5 = new Label("  จำนวนหนังสือ: ")
        textNum.setInputPrompt("ระบุจำนวนหนังสือ")
        textNum.setWidth("9em")
        hlayout.addComponent(l5)
        hlayout.addComponent(textNum)
        
            Label l6 = new Label("   ")
        hlayout.addComponent(l6)
        hlayout.addComponent(buttonAdd)

        buttonAdd.addClickListener({event ->
        	String x = textCost.getValue()
        	String y = textNum.getValue()
        	String n = textName.getValue()
        	String t = textType.getValue()
        	String p = textPub.getValue()
        	int a = Integer.parseInt(x)
        	int b = Integer.parseInt(y)
            c.addOrder(n,t,p,a,b)
            } as Button.ClickListener)
        

   // Delete Button
/*
        buttonDelete.addClickListener({ event ->
               
               if(grid.getSelectedRow() >= 1){

                int no = grid.getSelectedRow()  
                System.out.println("Selected ROW: " + grid.getSelectedRow())
                String cid = grid.getContainerDataSource().getItem(no).getItemProperty("ลำดับ")
               
                System.out.println(cid) 
                
                bo.dDelete(cid,id) 
                }else
                    Notification.show("คุณยังไม่ได้เลือกข้อมูลที่ต้องการจะลบ", Notification.Type.WARNING_MESSAGE);
                } as Button.ClickListener)


                //layout.addComponent(getAllDrugDataList())

                */

        layout.addComponent(vlayout)   
        layout.addComponent(hlayout)
        grid.setImmediate(true);
        layout.addComponent(hlayout)
        layout.addComponent(grid)

        
        //layout.addComponent(buttonDelete)
        
        
        //layout.setComponentAlignment(buttonDelete,Alignment.BOTTOM_RIGHT)
        setCompositionRoot(panel)



    }

   private Controller getController(){
        Object c = UI.getCurrent().getSession().getAttribute("Controller")
        return(Controller)c
    }
      
}

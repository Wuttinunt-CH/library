package app
import com.vaadin.ui.*
import com.vaadin.ui.VerticalLayout 
import com.vaadin.server.VaadinRequest 
import com.vaadin.ui.Label 
import com.vaadin.grails.Grails 
import com.vaadin.ui.Alignment 
import com.vaadin.ui.CustomComponent 
import com.vaadin.ui.Panel 
import com.vaadin.ui.HorizontalLayout 
import com.vaadin.ui.Table
import com.vaadin.ui.Grid.SelectionMode
import com.vaadin.ui.Button
import com.vaadin.data.Property
import com.vaadin.data.Property.ValueChangeEvent
import com.vaadin.data.util.HierarchicalContainer
import com.vaadin.event.ItemClickEvent
import com.vaadin.ui.ComboBox
import com.vaadin.data.Item
import app.*
import com.vaadin.ui.Notification
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Image

import library.*
import library.User
import library.Tool
class TodoEditboss extends CustomComponent {

	public TodoEditboss() {
		Controller c = new Controller()
		Panel editPanel = new Panel("ระบบยืม-คืนอุปกรณ์")
		VerticalLayout todolayout = new VerticalLayout()
		editPanel.setContent(todolayout)
		todolayout.setSizeFull()
		todolayout.setMargin(true)
		todolayout.setSpacing(true)

		
		HorizontalLayout layout11 = new HorizontalLayout()		
		layout11.setSizeFull()		
		layout11.setSpacing(true)
		todolayout.addComponent(layout11)


        Select textfieldto1 = new Select("รหัสอุปกรณ์")
        textfieldto1.setWidth("17em")
        layout11.addComponent(textfieldto1)
        textfieldto1.addItems("A00000","B11111","C22222","D33333","E44444")        
        layout11.setComponentAlignment(textfieldto1,Alignment.MIDDLE_LEFT)

		Select textfieldto2 = new Select("ประเภทอุปกรณ์")
        textfieldto2.setWidth("17em")
        layout11.addComponent(textfieldto2)
        textfieldto2.addItems("หูฟัง","เฟรชไดรฟ์","VCD and DVD","เครื่องเเปลภาษา","แท็บเล็ต")
        layout11.setComponentAlignment(textfieldto2,Alignment.MIDDLE_LEFT)

		Select select = new Select("จำนวนที่ยืม")
        select.setWidth("17em")
        layout11.addComponent(select)
        layout11.setComponentAlignment(select,Alignment.MIDDLE_LEFT)        
        select.addItems("1 ชิ้น","2 ชิ้น","3 ชิ้น","4 ชิ้น","5 ชิ้น")

        

        HorizontalLayout layout22 = new HorizontalLayout()		
		layout22.setSizeFull()
		
		layout22.setSpacing(true)
		todolayout.addComponent(layout22)

		PopupDateField time1 = new PopupDateField("วันที่ยืม")
		time1.setValue(new Date())
		time1.setWidth("25em")
        layout22.addComponent(time1)

        PopupDateField time2 = new PopupDateField("วันที่คืน")
		time2.setValue(new Date())
		time2.setWidth("25em")
        layout22.addComponent(time2)
		
		HorizontalLayout layout33 = new HorizontalLayout()		
		layout33.setWidth("100%")			
		layout33.setSpacing(true)
		todolayout.addComponent(layout33)

		ComboBox idname = new ComboBox("รหัสนักศึกษา")
        idname.setWidth("18em")        
        layout33.addComponent(idname)        
		layout33.setComponentAlignment(idname,Alignment.MIDDLE_LEFT)
		for (u in User.list()){
			idname.addItem(u.id)
			       		
        }

        TextField fname = new TextField("ชื่อนักศึกษา")
        fname.setWidth("18em")
        layout33.addComponent(fname)
        layout33.setComponentAlignment(fname, Alignment.MIDDLE_LEFT) 

        TextField lname = new TextField("นามสกุล")
        lname.setWidth("18em")
        layout33.addComponent(lname)
        layout33.setComponentAlignment(lname, Alignment.MIDDLE_LEFT)
		

		Button addButton = new Button("บันทึก")
		layout33.addComponent(addButton)
		addButton.setWidth("5em")
		layout33.setComponentAlignment(addButton,Alignment.MIDDLE_RIGHT)

		
		Grid gridTable2 = new Grid()
        gridTable2.setSelectionMode(SelectionMode.NONE)
        gridTable2.setWidth("100%")
        gridTable2.addColumn("รหัสอุปกรณ์", String.class);
		gridTable2.addColumn("ชื่ออุปกรณ์", String.class);
		gridTable2.addColumn("จำนวนที่ยืม", String.class);
		gridTable2.addColumn("วันที่ยืม", Date.class);
		gridTable2.addColumn("วันที่คืน", Date.class);
		gridTable2.addColumn("รหัสนักศึกษา", Long.class);
		gridTable2.addColumn("ชื่อนักศึกษา", String.class);
		gridTable2.addColumn("นามสกุล", String.class);
		todolayout.addComponent(gridTable2)
		c.setGridTable2(gridTable2)
		c.getTableDataBoss()
		
		

		 

		addButton.addClickListener({ event ->
			c.addTodoItemboss(textfieldto1.getValue(),textfieldto2.getValue(),select.getValue(),time1.getValue(),time2.getValue(),idname.getValue(),fname.getValue(),lname.getValue())	
			
					
		} as Button.ClickListener)	

		setCompositionRoot(editPanel)
	}
	
}
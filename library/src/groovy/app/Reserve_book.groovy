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
class Reserve_book extends CustomComponent {

	public Reserve_book() {
		Controller_reserve c = new Controller_reserve()
		Panel editPanel = new Panel("จองหนังสือ")
		VerticalLayout todolayout = new VerticalLayout()
		editPanel.setContent(todolayout)
		todolayout.setSizeFull()
		todolayout.setMargin(true)
		todolayout.setSpacing(true)

		
		HorizontalLayout layout1 = new HorizontalLayout()		
		layout1.setSizeFull()	
		//layout1.setMargin(true)	
		layout1.setSpacing(true)
		todolayout.addComponent(layout1)

		/* VerticalLayout layout2 = new VerticalLayout()
		editPanel.setContent(layout2)
		layout2.setSizeFull()		
		layout2.setSpacing(true)
		layout1.addComponent(layout2)
*/
		ComboBox namebook = new ComboBox("ชื่อหนังสือ")
        namebook.setWidth("38em")        
        layout1.addComponent(namebook)        
		layout1.setComponentAlignment(namebook,Alignment.MIDDLE_LEFT)

        TextField idbook = new TextField("รหัสหนังสือ")
        idbook.setWidth("20em")        
        layout1.addComponent(idbook)        
		layout1.setComponentAlignment(idbook,Alignment.BOTTOM_LEFT)
		

		for (u in Book.list()){
			namebook.addItem(u.nameBook)
			
       		
        }


        PopupDateField date1 = new PopupDateField("วันที่จอง")
		date1.setValue(new Date())
		date1.setWidth("25em")
        todolayout.addComponent(date1)
        todolayout.setComponentAlignment(date1, Alignment.MIDDLE_LEFT) 

        ComboBox idname = new ComboBox("รหัสนักศึกษา")
        idname.setWidth("40em")
        todolayout.addComponent(idname)
        todolayout.setComponentAlignment(idname, Alignment.MIDDLE_LEFT)

        for (a in User.list()){
			idname.addItem(a.id)
       		
        }

        TextField fname = new TextField("ชื่อนักศึกษา")
        fname.setWidth("40em")
        todolayout.addComponent(fname)
        todolayout.setComponentAlignment(fname, Alignment.MIDDLE_LEFT) 

        TextField lname = new TextField("นามสกุล")
        lname.setWidth("40em")
        todolayout.addComponent(lname)
        todolayout.setComponentAlignment(lname, Alignment.MIDDLE_LEFT) 

        Button button = new Button("บันทึก")
        todolayout.addComponent(button)
        todolayout.setComponentAlignment(button,Alignment.MIDDLE_LEFT)

        Grid gridTable2 = new Grid()
        gridTable2.setSelectionMode(SelectionMode.NONE)
        gridTable2.setWidth("100%")
        gridTable2.addColumn("ชื่อหนังสือ", String.class);
		gridTable2.addColumn("รหัสหนังสือ", String.class);
		gridTable2.addColumn("วันที่จอง", Date.class);
		gridTable2.addColumn("รหัสนักศึกษา", Long.class);
		gridTable2.addColumn("ชื่อนักศึกษา", String.class);
		gridTable2.addColumn("นามสกุล", String.class);
		todolayout.addComponent(gridTable2)
		c.setGridTable2(gridTable2)
		c.getTableDataBoss()

        button.addClickListener({ event ->

			c.reserve(namebook.getValue(),idbook.getValue(),date1.getValue(),idname.getValue(),fname.getValue(),lname.getValue())	
			
					
		} as Button.ClickListener)

		setCompositionRoot(editPanel)
	}
	
}
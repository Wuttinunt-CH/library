package app

import com.vaadin.ui.VerticalLayout
import com.vaadin.server.VaadinRequest
import com.vaadin.server.Page
import com.vaadin.ui.Label
import com.vaadin.grails.Grails
import com.vaadin.ui.Table
import com.vaadin.data.Item
import com.vaadin.server.ExternalResource
import com.vaadin.shared.ui.label.ContentMode
import com.vaadin.annotations.Theme
import com.vaadin.ui.Grid.SelectionMode
import com.vaadin.ui.DateField
import com.vaadin.ui.*
import com.vaadin.grails.*
import com.vaadin.server.*
import com.vaadin.terminal.*
import com.vaadin.ui.MenuBar.MenuItem
import com.vaadin.annotations.*
import com.vaadin.data.*
import com.vaadin.shared.ui.combobox.FilteringMode
import com.vaadin.data.Property.ValueChangeEvent
import com.vaadin.data.Property.ValueChangeListener
import com.vaadin.data.util.BeanItemContainer
import java.util.*
import system.*
//A1——
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

class UserShow extends CustomComponent {
   	static Grid gridUser

    public UserShow() {
	
        Controller u = new Controller()
        VerticalLayout layout = new VerticalLayout()
	Panel editPanel2 = new Panel()
        editPanel2.setContent(layout)
        layout.setSizeFull()
        layout.setMargin(true)

	gridUser = new Grid("ตารางแสดงข้อมูลสมาชิก")
        gridUser.setSelectionMode(SelectionMode.SINGLE)
        gridUser.setWidth("100%")
     	//gridUser.addColumn("ID", Integer.class);
        gridUser.addColumn("ชื่อผู้ใช้", String.class);
        gridUser.addColumn("รหัสผ่าน", String.class);
		gridUser.addColumn("คำนำหน้า", String.class);
		gridUser.addColumn("ชื่อ", String.class);
		gridUser.addColumn("สกุล", String.class);
		gridUser.addColumn("เพศ", Character.class);
		gridUser.addColumn("อายุ", Integer.class);
		gridUser.addColumn("เบอร์โทรศัพท์", String.class);
		gridUser.addColumn("email", String.class);
		gridUser.addColumn("วันลงทะเบียน", Date.class);
		layout.addComponent(gridUser)
		u.setGridUser(gridUser)
		u.getTableUser()

	Button delButton = new Button("ลบผู้ใช้")
	layout.addComponent(delButton)
	
	delButton.addClickListener({ event ->
 			if(gridUser.getSelectedRow() !=null && gridUser.getSelectedRow() > 0){
				int rowId = gridUser.getSelectedRow()
				String cid1 = gridUser.getContainerDataSource().getItem(rowId).getItemProperty("ID")
				print rowId
				print cid1
 				u.deleteUser(cid1)				
 				gridUser.getContainerDataSource().removeItem(gridUser.getSelectedRow())
       			}else{
 				new Notification("ยังไม่ได้เลือก",
           		Notification.Type.WARNING_MESSAGE).show(Page.getCurrent())}
 			} as Button.ClickListener)

        setCompositionRoot(editPanel2)
    }
    
   
}
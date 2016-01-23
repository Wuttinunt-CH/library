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
import library.Table_reservations

class Reservations extends CustomComponent {
   	static Grid gridTable

    public Reservations() {
	
        Controller cc = new Controller()
        VerticalLayout layout = new VerticalLayout()
	Panel editPanel2 = new Panel()
        editPanel2.setContent(layout)
        layout.setSizeFull()
        layout.setMargin(true)
	

	gridTable = new Grid()
        gridTable.setSelectionMode(SelectionMode.SINGLE)
        gridTable.setWidth("100%")
     	gridTable.addColumn("ID", Integer.class);
        gridTable.addColumn("รหัสนักศึกษา", String.class);
	gridTable.addColumn("วันที่", Date.class);
	gridTable.addColumn("เวลาที่จอง", String.class);
	gridTable.addColumn("ประเภทห้อง", String.class);
	gridTable.addColumn("วัตถุประสงค์", String.class);
	layout.addComponent(gridTable)
	cc.setGridTable(gridTable)
	cc.getTableData()

        setCompositionRoot(editPanel2)
    }
    
   
}
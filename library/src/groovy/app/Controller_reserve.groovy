package app
import com.vaadin.ui.*
import com.vaadin.ui.VerticalLayout 
import com.vaadin.server.VaadinRequest 
import com.vaadin.ui.Label 
import com.vaadin.grails.Grails 
import com.vaadin.ui.Alignment 
import com.vaadin.ui.CustomComponent 

import com.vaadin.ui.HorizontalLayout 
import com.vaadin.ui.Table
import com.vaadin.ui.Grid.SelectionMode

import com.vaadin.data.Property
import com.vaadin.data.Property.ValueChangeEvent
import com.vaadin.data.util.HierarchicalContainer
import com.vaadin.event.ItemClickEvent

import com.vaadin.data.Item
import app.*
import com.vaadin.ui.Notification
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Image

import library.*

class Controller_reserve {
	Grid gridTable2
	void reserve(String namebook,String idbook,Date date,Long idname,String fname,String lname){

			Reserve r = new Reserve()
			r.setNamebook(namebook)
			r.setIdbook(idbook)			
			r.setDate(date)
			r.setIdname(idname)
			r.setFname(fname)
			r.setLname(lname)

			r = r.save()

			if(r != null) {
            Notification.show("Save complete", Notification.Type.TRAY_NOTIFICATION);
        getTableDataBoss()
        }else {
            Notification.show("Data not complete", Notification.Type.TRAY_NOTIFICATION);
        }
		
	}

	void getTableDataBoss(){
    def rr = Reserve.executeQuery("from Reserve")
    gridTable2.getContainerDataSource().removeAllItems()
    for(r1 in rr){
        gridTable2.addRow(r1.namebook, r1.idbook, r1.date, r1.idname, r1.fname, r1.lname)
    }
    }


	
}
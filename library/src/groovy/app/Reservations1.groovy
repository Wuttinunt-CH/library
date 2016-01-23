package app
import com.vaadin.ui.UI 
import com.vaadin.ui.VerticalLayout 
import com.vaadin.server.VaadinRequest 
import com.vaadin.ui.Label 
import com.vaadin.grails.Grails 
import com.vaadin.ui.Alignment 
import com.vaadin.ui.CustomComponent 
import com.vaadin.ui.Panel 
import com.vaadin.ui.HorizontalLayout 
import com.vaadin.ui.Table 
import com.vaadin.ui.TextField 
import com.vaadin.ui.Button
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.ui.Grid.SelectionMode
import com.vaadin.event.ItemClickEvent;
import com.vaadin.data.Item;
import com.vaadin.ui.NativeSelect
import com.vaadin.ui.PopupDateField
import java.util.*
import com.vaadin.ui.*
import room.*
import library.*
import com.vaadin.ui.ComboBox
import com.vaadin.server.FontAwesome;


class Reservations1 extends CustomComponent {
    ComboBox ownerSelecter


    public Reservations1() {
        Controller c = new Controller()
        HorizontalLayout layout = new HorizontalLayout()
        Panel editPanel = new Panel()
        editPanel.setContent(layout)
        layout.setSizeFull()
        layout.setMargin(true)



    TextField check = new TextField("รหัสนักศึกษาสำหรับรับอุปกรณ์")
    layout.addComponent(check)
    layout.setExpandRatio(check,0.1f)

    PopupDateField check1 = new PopupDateField("วันที่")
    check1.setValue(new Date());
    layout.addComponent(check1)
    layout.setExpandRatio(check1,0.1f)

    ComboBox check2 = new ComboBox("เวลาที่จอง")
    check2.addItem("1 hr")
    check2.addItem("2 hr")
    check2.addItem("3 hr")
    check2.setNullSelectionAllowed(false)   
    layout.addComponent(check2)
    layout.setExpandRatio(check2,0.1f)

    ComboBox check3 = new ComboBox("ประเภทห้อง")
    check3.addItem("เดี่ยว สำหรับ1 คน")
    check3.addItem("กลุ่ม สำหรับ3-5 คน")
    check3.setNullSelectionAllowed(false)      
    layout.addComponent(check3)
    layout.setExpandRatio(check3,0.1f)

    ComboBox check4 = new ComboBox("วัตถุประสงค์")
    check4.addItem("ติวหนังสือ")
    check4.addItem("ทำรายงานหรือโปรเจคกลุ่ม")
    check4.addItem("ศึกษาข้อมูลต่างๆ")
    check4.setNullSelectionAllowed(false)
    layout.addComponent(check4)
    layout.setExpandRatio(check4,0.1f)

	Button addButton1 = new Button("Save", FontAwesome.SAVE)
        layout.addComponent(addButton1)
        layout.setComponentAlignment(addButton1, Alignment.BOTTOM_LEFT)
        layout.setExpandRatio(addButton1,0.05f)

        addButton1.addClickListener({event ->
c.addTodoItem(check.getValue(),check1.getValue(),check2,check3,check4)
            } as Button.ClickListener)

       setCompositionRoot(editPanel)                        
                      
    }
    
    
}
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


class RepairBook extends CustomComponent {

    static Grid grid
    static TextField textID
    static TextField textName
    static TextField textType
    static TextField textStatus
    static TextField textCause

    public RepairBook(){
        super()
        this.configure()

    }


    public RepairBook(String caption) {
      super(caption)
      this.configure()
    }

    private void configure() {

        SearchContorller control = new SearchContorller()

        VerticalLayout layout = new VerticalLayout()

        Panel panel = new Panel()
        panel.setContent(layout)
        layout.setSizeFull()
        layout.setMargin(true)


        HorizontalLayout hlayout = new HorizontalLayout()
        hlayout.setSpacing(true)
        layout.addComponent(hlayout)

        textID = new TextField()
        Label l1 = new Label("รหัสหนังสือ:")
        textID.setSizeFull()
        textID.setWidth("9em")
        textID.setMaxLength(10)
        hlayout.addComponent(l1)
        hlayout.addComponent(textID)
        hlayout.setExpandRatio(textID, 1.0f)

        textName = new TextField()
        Label l2 = new Label("ชื่อเรื่อง:")
        textName.setSizeFull()
        textName.setWidth("9em")
        hlayout.addComponent(l2)
        hlayout.addComponent(textName)
        hlayout.setExpandRatio(textName, 1.0f)


        textType = new TextField()
        Label l3 = new Label("ประภทหนังสือ:")
        textType.setSizeFull()
        textType.setWidth("7em")
        hlayout.addComponent(l3)
        hlayout.addComponent(textType)
        hlayout.setExpandRatio(textType, 1.0f)

        textStatus = new TextField()
        Label l4 = new Label("สถานะ:")
        textStatus.setSizeFull()
        textStatus.setWidth("7em")
        hlayout.addComponent(l4)
        hlayout.addComponent(textStatus)
        hlayout.setExpandRatio(textStatus, 1.0f)

        textCause = new TextField()
        Label l5 = new Label("สาเหตุ:")
        textCause.setSizeFull()
        textCause.setWidth("7em")
        hlayout.addComponent(l5)
        hlayout.addComponent(textCause)
        hlayout.setExpandRatio(textCause, 1.0f)

        Button buttonSearch = new Button("ค้นหา")
        hlayout.addComponent(buttonSearch)
        hlayout.setComponentAlignment(buttonSearch,Alignment.BOTTOM_CENTER)

        buttonSearch.addClickListener({ event -> control.searchContorller(textID.getValue()) 
          } as Button.ClickListener)

        Button buttonAdd = new Button("บันทึก")
        hlayout.addComponent(buttonAdd)
        hlayout.setComponentAlignment(buttonAdd,Alignment.BOTTOM_CENTER)

        buttonAdd.addClickListener({event ->

            String x = textCause.getValue()

        AddRepair a = new AddRepair()
            a.addRepair(x,textID.getValue())
            } as Button.ClickListener)
    
        setCompositionRoot(panel)
         }


         
     }
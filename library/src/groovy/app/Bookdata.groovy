package app
import com.vaadin.server.VaadinRequest
import com.vaadin.grails.Grails
import com.vaadin.ui.CustomComponent 
import com.vaadin.ui.UI

import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Alignment
import com.vaadin.ui.Label
import com.vaadin.ui.Panel
import com.vaadin.ui.Button

import com.vaadin.annotations.Theme

import app.MyUI
import library.*

import com.vaadin.ui.themes.ValoTheme
import com.vaadin.ui.themes.Reindeer


class Bookdata extends CustomComponent {

    //static Grid grid

    public Bookdata(){
        super()
        this.configure()

    }


    public Bookdata(String caption) {
      super(caption)
      this.configure()
    }

    private void configure() {

        //Panel editPanel = new Panel()
        VerticalLayout layout = new VerticalLayout()
        //editPanel.setContent(layout)
        layout.setSizeFull()
        
        layout.setMargin(true)
        layout.setSpacing(true)

//////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*Label label = new Label("Sut-Se58-Team10 : Library System")
        label.setStyleName("h5")
        label.setSizeUndefined()*/

        Label label2 = new Label("Data Bibliography System")
        label2.setStyleName("h1")
        label2.setSizeUndefined()
//////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*layout.addComponent(label)
        layout.setComponentAlignment(label, Alignment.MIDDLE_CENTER)*/

        layout.addComponent(label2)
        layout.setComponentAlignment(label2, Alignment.MIDDLE_CENTER)
//////////////////////////////////////////////////////////////////////////////////////////////////////////
        Tab tab = new Tab()
        tab.setWidth("45em")
        layout.addComponent(tab)
        layout.setComponentAlignment(tab, Alignment.MIDDLE_CENTER)
//////////////////////////////////////////////////////////////////////////////////////////////////////////
        //setCompositionRoot(editPanel)
        setCompositionRoot(layout)
        //setContent(editPanel)
    }

}

package app

import com.vaadin.ui.UI 
import com.vaadin.grails.Grails 
import com.vaadin.ui.CustomComponent 
/////////////////////////////////////////////////////////////////////////////////////////////////////////// 
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Alignment
import com.vaadin.ui.TextField
import com.vaadin.ui.Panel
import com.vaadin.ui.Button
import com.vaadin.ui.Label
///////////////////////////////////////////////////////////////////////////////////////////////////////////
import com.vaadin.ui.Table
import com.vaadin.data.Item
import com.vaadin.ui.Accordion
import com.vaadin.ui.TabSheet
import com.vaadin.ui.Layout
import com.vaadin.ui.GridLayout
import com.vaadin.ui.Grid
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Notification
import com.vaadin.ui.Grid.SelectionMode
///////////////////////////////////////////////////////////////////////////////////////////////////////////
import library.*
///////////////////////////////////////////////////////////////////////////////////////////////////////////
import com.vaadin.ui.ComboBox

class TabSearch extends CustomComponent {

    static TextField topic10
    static TextField topic11
    static TextField topic12
    static TextField topic13
    static TextField topic14
    static TextField topic15

    public TabSearch() {

        Panel editPanel = new Panel()
        VerticalLayout layout = new VerticalLayout()
        editPanel.setContent(layout)
        layout.setSizeFull()
        //layout.setMargin(true)
        //layout.setSpacing(true)

        Table table2 = new Table();
        //grid4.setCaption("Double click to edit");
        table2.setSizeFull();
        //grid4.setEditorEnabled(true);
        // Define some columns
        table2.addContainerProperty("Book ID", String.class, null)
        table2.addContainerProperty("Book Name", String.class, null)
        table2.addContainerProperty("Author", String.class, null)
        table2.addContainerProperty("Publisher", String.class, null)
        table2.addContainerProperty("Shelf", String.class, null)
        table2.addContainerProperty("Price", Integer.class, null)

        for (u in Book.list()){
        Object newItemId2 = table2.addItem()
        Item row2 = table2.getItem(newItemId2)
        row2.getItemProperty("Book ID").setValue(u.idBook)
        row2.getItemProperty("Book Name").setValue(u.nameBook)
        row2.getItemProperty("Author").setValue(u.author)
        row2.getItemProperty("Publisher").setValue(u.publisher)
        row2.getItemProperty("Shelf").setValue(u.shelf)
        row2.getItemProperty("Price").setValue(u.price)
        }

        layout.addComponent(table2)
        layout.setComponentAlignment(table2, Alignment.MIDDLE_CENTER)       
///////////////////////////////////////////////////////////////////////////////////////////////////////////
        TabSheet tabsheet = new TabSheet();
        layout.addComponent(tabsheet);
///////////////////////////////////////////////////////////////////////////////////////////////////////////
        Layout tab1 = new VerticalLayout()
        tab1.setSizeFull()
        tab1.setMargin(true)
        tab1.setSpacing(true)

        GridLayout grid5 = new GridLayout(2, 7);
        grid5.addStyleName("example-gridlayout");
        grid5.setSizeFull()
        grid5.setMargin(true)
        grid5.setSpacing(true)

        TextField barsearch = new TextField();
        barsearch.setWidth("30em")
        barsearch.setImmediate(true);
        barsearch.setMaxLength(10)
        barsearch.setInputPrompt("Book ID       (ex. 0000000001)")
        grid5.addComponent(barsearch);

        Button search = new Button("Searching");
        grid5.addComponent(search,1,0);

        search.addClickListener({ event ->
            SearchController2 source = new SearchController2()
            source.searchBook(barsearch.getValue())
        } as Button.ClickListener)
        
        topic10 = new TextField("Book ID")
        topic10.setSizeFull()
        topic10.setWidth("11em")
        grid5.addComponent(topic10,0,2)

        topic11 = new TextField("Book Name")
        topic11.setSizeFull()
        topic11.setWidth("11em")
        grid5.addComponent(topic11,0,3)

        topic12 = new TextField("Author")
        topic12.setSizeFull()
        topic12.setWidth("11em")
        grid5.addComponent(topic12,0,4)

        topic13 = new TextField("Publisher")
        topic13.setSizeFull()
        topic13.setWidth("11em")
        grid5.addComponent(topic13,0,5)

        topic14 = new TextField("shelf")
        topic14.setSizeFull()
        topic14.setWidth("11em")
        grid5.addComponent(topic14,0,6)

        tab1.addComponent(grid5)
        tab1.addComponent(table2)
        tabsheet.addTab(tab1, "Searching")
///////////////////////////////////////////////////////////////////////////////////////////////////////////

        setCompositionRoot(editPanel)
    }

}
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

class Tab extends CustomComponent {

    static ComboBox select
    static TextField topic10
    static TextField topic11
    static TextField topic12
    static TextField topic13
    static TextField topic14
    static TextField topic15

    public Tab() {

        Panel editPanel = new Panel()
        VerticalLayout layout = new VerticalLayout()
        editPanel.setContent(layout)
        layout.setSizeFull()
        //layout.setMargin(true)
        //layout.setSpacing(true)

///////////////////////////////////////////////////////////////////////////////////////////////////////////
        GridLayout grid = new GridLayout(2, 9);
        grid.addStyleName("example-gridlayout");
        grid.setSizeFull()
        grid.setMargin(true)
        grid.setSpacing(true)

        TextField topic1 = new TextField("รหัสหนังสือ (Book ID)");
        topic1.setMaxLength(10)
        topic1.setInputPrompt("ex. 0000000001")
        grid.addComponent(topic1); // 0,0,0,1

        TextField topic2 = new TextField("ชื่อหนังสือ (Book Name)");
        topic2.setInputPrompt("ex. เยลลี่ & วุ้นแฟนซี")
        grid.addComponent(topic2); // 1,1,0,1

        TextField topic3 = new TextField("ผู้แต่ง (Author)");
        topic3.setInputPrompt("ex. จุนโกะ")
        grid.addComponent(topic3,0,1);

        TextField topic4 = new TextField("สำนักพิมพ์ (Publisher)");
        topic4.setInputPrompt("ex. สำนักพิมพ์แม่บ้าน")
        grid.addComponent(topic4,1,1,1,1);

        TextField topic5 = new TextField("ปีที่พิมพ์ (Buildyear)");
        topic5.setInputPrompt("ex. 2015")
        grid.addComponent(topic5,0,2);


        select = new ComboBox("ประเภทหนังสือ (Book Type)")
        select.setWidth("11.5em")
        grid.addComponent(select,0,3)

        def b = TypeBook.executeQuery("from TypeBook")
        System.out.println(b.size())
        for (a in TypeBook.list()) {
            select.addItem(a)
        }

        TextField topic7 = new TextField("รายละเอียด (Description)");
        topic7.setInputPrompt("ex. ไอเดียขนมหวานดีไซน์น่ารัก แบบฉบับสไตล์ญี่ปุ่น")
        grid.addComponent(topic7,0,4);

        TextField topic8 = new TextField("สถานที่จัดเก็บ (Shelf)");
        topic8.setInputPrompt("ex. ชั้น 3 บรรณสาร")
        grid.addComponent(topic8,0,5);

        TextField topic9 = new TextField("ราคา (Price)");
        topic9.setInputPrompt("ex. 220")
        grid.addComponent(topic9,0,6);

        Button addButton = new Button("Confirm");
        grid.addComponent(addButton,0,7);
        grid.setComponentAlignment(addButton, Alignment.BOTTOM_LEFT) 

            addButton.addClickListener({event ->
            AddController add = new AddController()
            Integer price 
            price = Integer.parseInt(topic9.getValue())
            Integer buildYear
            buildYear = Integer.parseInt(topic5.getValue())
            add.addItem(topic1.getValue(),topic2.getValue(),
                topic3.getValue(),topic4.getValue(),buildYear,
                topic7.getValue(),topic8.getValue(),
                price)
            } as Button.ClickListener ,)

        layout.addComponent(grid)
///////////////////////////////////////////////////////////////////////////////////////////////////////////
        Table table1 = new Table();
        //grid4.setCaption("Double click to edit");
        table1.setSizeFull();
        //grid4.setEditorEnabled(true);
        // Define some columns
        table1.addContainerProperty("Book ID", String.class, null)
        table1.addContainerProperty("Book Name", String.class, null)
        table1.addContainerProperty("Author", String.class, null)
        table1.addContainerProperty("Publisher", String.class, null)
        table1.addContainerProperty("Buildyear", Integer.class, null)
        table1.addContainerProperty("Description", String.class, null)
        table1.addContainerProperty("Shelf", String.class, null)
        table1.addContainerProperty("Price", Integer.class, null)

        for (u in Book.list()){
        Object newItemId = table1.addItem()
        Item row1 = table1.getItem(newItemId)
        row1.getItemProperty("Book ID").setValue(u.idBook)
        row1.getItemProperty("Book Name").setValue(u.nameBook)
        row1.getItemProperty("Author").setValue(u.author)
        row1.getItemProperty("Publisher").setValue(u.publisher)
        row1.getItemProperty("Buildyear").setValue(u.buildYear)
        row1.getItemProperty("Description").setValue(u.detail)
        row1.getItemProperty("Shelf").setValue(u.shelf)
        row1.getItemProperty("Price").setValue(u.price)
        }
        layout.addComponent(table1)
        layout.setComponentAlignment(table1, Alignment.MIDDLE_CENTER)
///////////////////////////////////////////////////////////////////////////////////////////////////////////
        TabSheet tabsheet = new TabSheet();
        layout.addComponent(tabsheet);
///////////////////////////////////////////////////////////////////////////////////////////////////////////
        Layout tab2 = new VerticalLayout()
        tab2.setSizeFull()
        tab2.setMargin(true)
        tab2.setSpacing(true)
        tab2.addComponent(grid)
        tab2.addComponent(table1)
        tabsheet.addTab(tab2, "Data Bibliography")
///////////////////////////////////////////////////////////////////////////////////////////////////////////

        setCompositionRoot(editPanel)
    }
    private AddController getAddController(){
        Object add = UI.getCurrent().getSession().getAttribute("AddController")
        return(AddController)add
    }
}
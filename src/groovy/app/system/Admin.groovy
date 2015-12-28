package app.system

import com.vaadin.server.*
import com.vaadin.terminal.*
import com.vaadin.ui.*
import com.vaadin.ui.MenuBar.MenuItem
import com.vaadin.shared.ui.MarginInfo
import com.vaadin.annotations.*
import com.vaadin.data.*

import java.util.*
import com.vaadin.grails.Grails


@Title("REG system")
@Theme("team18")
class Admin extends UI {

    @Override

    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout page = new VerticalLayout()
        IndexController c = new IndexController()
        this.getSession().setAttribute("controller",c)
        //- Set Session Controller -//

        if(getController().getLogin() == null) {
            
        	HorizontalLayout layout = new HorizontalLayout()
            VerticalLayout boxCenter = new VerticalLayout()
            //-Create Box-//

            Panel panelCenter = new Panel()
            //-Create Panel-//

            panelCenter.setContent(boxCenter)
            //-Set Layout in Panel-//

            boxCenter.setWidth("250px")
            boxCenter.setHeight("400px")
            layout.setMargin(true);
            //-Set Properties-//

            layout.addComponent(panelCenter)
            page.addComponent(layout)
            //-Set Component-//

            layout.setComponentAlignment(panelCenter,Alignment.MIDDLE_CENTER)
            page.setComponentAlignment(layout,Alignment.MIDDLE_CENTER)
            //- Set Position -//

            boxCenter.addComponent(blockCenter())

            getController().setPageIndex(page)
            //-Save Page to Session-/
    		setContent(getController().getPageIndex())
            //-Load Page from Session -//
            }else {
                //- login Success-//
                Button logout = new Button("Log out")
                page.addComponent(logout)
                getController().setPageIndex(page)
                //-Save Page to Session-/
                setContent(getController().getPageIndex())
                //-Load Page from Session -//
                logout.addClickListener({ event -> 
                    UI.getCurrent().getSession().setAttribute("loginData",null)
                    UI.getCurrent().getSession().setAttribute("loginStatus",null)
                    Page.getCurrent().getJavaScript().execute("location.reload()")
                } as Button.ClickListener)
                //-Create Action-//    

                
            }

        
    }
    
    public VerticalLayout blockCenter() {
        VerticalLayout layout = new VerticalLayout()
        VerticalLayout headerLayout = new VerticalLayout()
        VerticalLayout dataLayout = new VerticalLayout()
        //-Create Box-//

        Panel headerPanel = new Panel()
        Panel dataPanel = new Panel()
        //-Create Panel-//

        Label title = new Label("Lastest News")
        //-Create Label-//

        headerPanel.setContent(headerLayout)
        dataPanel.setContent(dataLayout)
        //-Set Layout in Panel-//

        layout.addComponent(headerPanel)
        layout.addComponent(dataPanel)
        dataLayout.addComponent(testConvertNews())
        headerLayout.addComponent(title)

        //-Set Component-//

        dataLayout.setSizeUndefined()
        //-Set Scrollbar in Panel-//

        headerLayout.setMargin(true)
        dataPanel.setHeight("350px")
        //-Set Properties-//

        return layout
        //-Return Component-//
    }


    public VerticalLayout testConvertNews() {
        VerticalLayout layout = new VerticalLayout()
        layout.setMargin(true)
        int x=8,y=2
        String[][] arr = new String[x][y];
        int i,j=0
        for(i=0;i<x;i++) {
            arr[i][j++] = "Title " + (i+1)
            arr[i][j--] = "Data " + (i+1)
        }
        j=0
        for(i=0;i<x;i++) {
            layout.addComponent(new Label("News title : " + arr[i][j++]))
            layout.addComponent(new Label("...." + arr[i][j--]))
        }
        return layout
    }
    IndexController getController() {
        Object c = UI.getCurrent().getSession().getAttribute("controller")
        return (IndexController)c
    }
}

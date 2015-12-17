package app

import com.vaadin.server.VaadinRequest
import com.vaadin.grails.Grails
import com.vaadin.ui.*
/**
 *
 *
 * @author
 */
class ResultBoundary extends CustomComponent {

    VerticalLayout getResultBoundary (){

		VerticalLayout body = new VerticalLayout()
        body.setWidth("1000px")
        String homeLabel = Grails.i18n("default.home.label")
        Label label = new Label(homeLabel)
        body.addComponent(label)

        Button b = new Button("OK")
        body.addComponent(b)
        body.setComponentAlignment(b,Alignment.TOP_CENTER)
        return body
    }
}

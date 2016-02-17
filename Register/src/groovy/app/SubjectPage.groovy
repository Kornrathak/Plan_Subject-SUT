package app

import com.vaadin.server.FontAwesome
import com.vaadin.server.ExternalResource

import com.vaadin.ui.CustomComponent
import com.vaadin.ui.Panel
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Alignment
import com.vaadin.ui.*

import app.Controller.SubjectPageController

class SubjectPage extends CustomComponent {
	public SubjectPage(){
		Panel editPanel = new Panel("List of Subject")
		Panel p1List = new Panel()
		Panel p2Plan = new Panel()
		HorizontalLayout layout = new HorizontalLayout()
		HorizontalLayout h1button = new HorizontalLayout()
		VerticalLayout v1Subject = new VerticalLayout()
		VerticalLayout v2Plan = new VerticalLayout()
		OptionGroup g1Subject = new OptionGroup("Subject")
		Button b1select = new Button("Select")
		Button b2delete = new Button("Delete")
		Table t1plan = new Table("Plan")
		
		editPanel.setContent(layout)
		editPanel.setSizeFull()
		p1List.setContent(v1Subject)
		p1List.setWidth("100%")
		p2Plan.setContent(v2Plan)
		p2Plan.setWidth("500px")
		
		layout.setSizeFull()
		layout.setMargin(true)
		layout.setSpacing(true)
		v1Subject.setSizeFull()
		v1Subject.setMargin(true)
		v1Subject.setSpacing(true)
		v2Plan.setSizeFull()
		v2Plan.setMargin(true)
		v2Plan.setSpacing(true)
		h1button.setSpacing(true)
		
		t1plan.addContainerProperty("Plan", String.class, null)
		t1plan.addContainerProperty("Subject", String.class, null)
		
		g1Subject = getController().getListSubject(g1Subject)
		
		h1button.addComponents(b1select, b2delete)
		h1button.setComponentAlignment(b1select, Alignment.TOP_RIGHT)
		h1button.setComponentAlignment(b2delete, Alignment.TOP_RIGHT)
		
		v1Subject.addComponents(g1Subject, h1button)
		v1Subject.setComponentAlignment(h1button, Alignment.TOP_RIGHT)
		v2Plan.addComponents(t1plan)
		layout.addComponents(p1List, p2Plan)
		layout.setExpandRatio(p1List, 1.0f)
		
		setCompositionRoot(editPanel)
	}
	
	private SubjectPageController getController(){
		Object c = UI.getCurrent().getSession().getAttribute("subject")
		return (SubjectPageController)c
	}
}
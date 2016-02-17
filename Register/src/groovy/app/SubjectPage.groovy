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
	
		int no = 1
		
		Panel editPanel = new Panel("List of Subject")
		Panel p1List = new Panel()
		Panel p2Plan = new Panel()
		HorizontalLayout layout = new HorizontalLayout()
		HorizontalLayout h1button = new HorizontalLayout()
		HorizontalLayout h2button = new HorizontalLayout()
		VerticalLayout v1Subject = new VerticalLayout()
		VerticalLayout v2Plan = new VerticalLayout()
		OptionGroup g1Subject = new OptionGroup("Subject")
		OptionGroup g2Plan = new OptionGroup("Plan")
		Button b1select = new Button("Select")
		Button b2delete = new Button("Delete")
		Button b3create = new Button("Create")
		Button b4delete = new Button("Delete")
		Table t1plan = new Table("Plan")
		Label l1notfound = new Label()
		
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
		h2button.setSpacing(true)
		
		t1plan.addContainerProperty("Plan", String.class, null)
		t1plan.addContainerProperty("Subject", String.class, null)
		
		g1Subject = getController().getListSubject(g1Subject)
		g2Plan = getController().getListPlan(g2Plan)
		l1notfound.setValue("Not Found")
		l1notfound.setStyleName("h1")
		l1notfound.setSizeUndefined()

		if(getController().checkList() == 0){
			g1Subject.setVisible(false)
			l1notfound.setVisible(true)
		}
		else{
			g1Subject.setVisible(true)
			l1notfound.setVisible(false)
		}
		
		h1button.addComponents(b1select, b2delete)
		h1button.setComponentAlignment(b1select, Alignment.TOP_RIGHT)
		h1button.setComponentAlignment(b2delete, Alignment.TOP_RIGHT)
		
		h2button.addComponents(b3create, b4delete)
		h2button.setComponentAlignment(b3create, Alignment.TOP_RIGHT)
		h2button.setComponentAlignment(b4delete, Alignment.TOP_RIGHT)
		
		v1Subject.addComponents(g2Plan, h2button, g1Subject, l1notfound, h1button)
		v1Subject.setComponentAlignment(l1notfound, Alignment.MIDDLE_CENTER)
		v1Subject.setComponentAlignment(h1button, Alignment.TOP_RIGHT)
		v1Subject.setComponentAlignment(h2button, Alignment.TOP_RIGHT)
		v2Plan.addComponents(t1plan)
		layout.addComponents(p1List, p2Plan)
		layout.setExpandRatio(p1List, 1.0f)
		
		setCompositionRoot(editPanel)
		
		b2delete.addClickListener({ event2 ->
			getController().setDeleteSubject((ArrayList)g1Subject.getValue())
			if(getController().checkList() == 1){
				g1Subject.removeAllItems()
				g1Subject = getController().getListSubject(g1Subject)
			}
			else{
				g1Subject.setVisible(false)
				l1notfound.setVisible(true)
			}
		} as Button.ClickListener)
		
		b3create.addClickListener({ event3 ->
			g2Plan = getController().createChoise(g2Plan)
		} as Button.ClickListener)
		
		b4delete.addClickListener({ event4 ->
			getController().setDeletePlan(g2Plan.getValue())
			g2Plan.removeAllItems()
			g2Plan = getController().getListPlan(g2Plan)
		} as Button.ClickListener)
	}
	
	private SubjectPageController getController(){
		Object c = UI.getCurrent().getSession().getAttribute("subject")
		return (SubjectPageController)c
	}
}
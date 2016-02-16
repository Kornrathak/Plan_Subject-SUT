package app

import com.vaadin.server.FontAwesome
import com.vaadin.server.ExternalResource

import com.vaadin.ui.CustomComponent
import com.vaadin.ui.Panel
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Alignment
import com.vaadin.ui.*

import app.Controller.IncPageController

class IncreasePage extends CustomComponent {
	public IncreasePage(){
		Panel editPanel = new Panel("เพิ่มรายวิชา")
		Panel p1Add = new Panel()
		Panel p2Search = new Panel()
		HorizontalLayout layout = new HorizontalLayout()
		HorizontalLayout h1head = new HorizontalLayout()
		VerticalLayout r1Add = new VerticalLayout()
		VerticalLayout r2Search = new VerticalLayout()
		TextField t1code = new TextField("Subject's Code")
		TextField t2name = new TextField("Subject's Name")
		TextArea t3time = new TextArea("Time")
		TextField t4group = new TextField("Section")
		Button b1add = new Button("Add Subject")
		BrowserFrame browser = new BrowserFrame("Website", new ExternalResource("https://reg.sut.ac.th/registrar/class_info.asp"))
		Label message = new Label()
		
		editPanel.setContent(layout)
		p1Add.setContent(r1Add)
		p2Search.setContent(r2Search)
		editPanel.setSizeFull()
		p1Add.setWidth("100%")
		p2Search.setWidth("100%")
		
		layout.setSizeFull()
		layout.setMargin(true)
		layout.setSpacing(true)
		r1Add.setSizeFull()
		r1Add.setMargin(true)
		r1Add.setSpacing(true)
		r2Search.setSizeFull()
		r2Search.setMargin(true)
		r2Search.setSpacing(true)
		h1head.setSizeFull()
		h1head.setSpacing(true)
		
		browser.setWidth("100%")
		browser.setHeight("400px")
		
		message.setVisible(false)
		
		t1code.setWidth("10em")
		t1code.setMaxLength(6)
		t1code.setInputPrompt("523XXX")
		t2name.setSizeFull()
		t2name.setInputPrompt("Computer Programing I")
		t3time.setSizeFull()
		t3time.setInputPrompt("Mon 10:00-11:00\nTu 18:00-19:00")
		t4group.setWidth("5em")
		t4group.setMaxLength(3)
		t4group.setInputPrompt("1")
		
		h1head.addComponents(t1code, t2name, t4group)
		h1head.setExpandRatio(t2name, 1.0f)
		
		r1Add.addComponents(message, h1head, t3time, b1add)
		r1Add.setComponentAlignment(b1add, Alignment.BOTTOM_RIGHT)
		
		r2Search.addComponents(browser)
		
		layout.addComponents(p1Add, p2Search)
		
		setCompositionRoot(editPanel)
		
		b1add.addClickListener({ e ->
			int chk = getController().setSubject(t1code.getValue(), t2name.getValue(), t4group.getValue(), t3time.getValue())
			message = getController().setCapMessage(message, chk)
		} as Button.ClickListener)
	}
	
	private IncPageController getController(){
		Object c = UI.getCurrent().getSession().getAttribute("increase")
		return (IncPageController)c
	}
}
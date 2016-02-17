package app.Controller

import com.vaadin.ui.*

import register.Subject

class SubjectPageController{
	public OptionGroup getListSubject(OptionGroup list){
		def item = Subject.executeQuery("from Subject")
		for(element in item){	
			String capt = "Code: " + element.code + " | Name: " + element.name + " | Section: " + element.sectiongroup + " | Time: " + element.time
			list.addItem(element)
			list.setItemCaption(element, capt)
		}
		return list
	}
}
package app.Controller

import com.vaadin.ui.*

import register.Subject

class SubjectPageController{
	public int checkList(){
		def item = Subject.executeQuery("from Subject where status = 0")
		if(item.size() != 0)return 1;
		else return 0;
	}

	public void setDeleteSubject(ArrayList list){
		for(int i = 0; i < list.size(); i++){
			def item = list.get(i)
			item.status = 1
			item.withTransaction{
				item = item.save()
			}
		}
	}

	public OptionGroup getListSubject(OptionGroup list){
		def item = Subject.executeQuery("from Subject where status = 0")
		for(element in item){	
			String capt = "Code: " + element.code + " | Name: " + element.name + " | Section: " + element.sectiongroup + " | Time: " + element.time
			list.addItem(element)
			list.setItemCaption(element, capt)
		}
		list.setMultiSelect(true)
		return list
	}
}
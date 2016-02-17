package app.Controller

import com.vaadin.ui.*

import register.Subject
import register.Planning

class SubjectPageController{

	public OptionGroup getListPlan(OptionGroup list){
		def num = Planning.executeQuery("from Planning where status = 0")
		for(element in num){
			list.addItem(element)
			list.setItemCaption(element, element.name)
		}
		return list
	}

	public OptionGroup createChoise(OptionGroup list){
		def num = Planning.executeQuery("from Planning")
		int i = num.size() + 1
		
		Planning plan = new Planning()
		plan.setCode(i)
		plan.setName("Planning " + i)
		plan.setStatus(0)
		plan = plan.save()
		
		list.addItem(plan)
		list.setItemCaption(plan, plan.name)
		return list
	}
	
	public int checkList(){
		def item = Subject.executeQuery("from Subject where status = 0")
		if(item.size() != 0)return 1;
		else return 0;
	}
	
	public void setDeletePlan(Planning plan){
		plan.status = 1
		plan.withTransaction{
			plan = plan.save()
		}
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
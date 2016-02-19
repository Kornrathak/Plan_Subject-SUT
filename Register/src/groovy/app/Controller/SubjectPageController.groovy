package app.Controller

import com.*
import com.vaadin.ui.*
import com.vaadin.ui.Table
import com.vaadin.ui.Table.ColumnGenerator
import com.vaadin.ui.Table.ColumnResizeEvent
import com.vaadin.ui.Table.HeaderClickEvent
import com.vaadin.ui.TableFieldFactory
import com.vaadin.data.*
import com.vaadin.data.Container
import com.vaadin.data.Item
import com.vaadin.data.Property
import java.util.*

import register.Subject
import register.Planning
import register.HavingSubject

class SubjectPageController{

	public Table getPlanningTable(Table table){
		def list = HavingSubject.executeQuery("from HavingSubject")
		def check = Planning.executeQuery("from Planning")
		if(list.isEmpty() == false){
			ArrayList planes = new ArrayList()
			ArrayList subes = new ArrayList()
			ArrayList point = new ArrayList()
			for(int i = 0; i < check.size(); i++) {
				for(int j = 0; j < list.size(); j++) {
					if(check.get(i).name.equals(list.get(j).code) == true) point.add(j)
				}
			}
			for(element in list){
				planes.add(element.plan.name)
				subes.add(element.sub.name)
			}
			println(planes)
			println(subes)
			println(point)
			/*String temp = ""
			for(int i = 0; i < point.size() - 1; i++){
				if(point.get(i) > point.get(i + 1)){
					temp += (subes.get(point.get(i)))
					Object newItemId = table.addItem()
					Item row1 = table.getItem(newItemId)
					row1.getItemProperty("Plan").setValue(planes.get(point.get(i)))
					row1.getItemProperty("Subject").setValue(temp)
					temp = ""
				}
				else temp += (subes.get(point.get(i)) + " | ")
				if(i == point.size() - 2){
					temp += (subes.get(point.get(i + 1)))
					Object newItemId = table.addItem()
					Item row1 = table.getItem(newItemId)
					row1.getItemProperty("Plan").setValue(planes.get(point.get(i)))
					row1.getItemProperty("Subject").setValue(temp)
				}
			}*/
		}
		table.setPageLength(10)
		table.setSelectable(true)
		return table
	}

	public int setPlanning(Planning plan, ArrayList sub){
		if(plan == null && sub.isEmpty() == true) return 99;
		else if(plan == null) return 98;
		else if(sub.isEmpty() == true) return 97;
		else{
			for(int i = 0; i < sub.size(); i++){
				HavingSubject hav = new HavingSubject()
				hav.setCode(plan.name)
				hav.setPlan(plan)
				hav.setSub(sub.get(i))
				hav = hav.save()
			}
			return 0;
		}
	}

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
		if(plan != null){
			plan.status = 1
			plan.withTransaction{
				plan = plan.save()
			}
		}
		else Notification.show("!!Please!! Choose Planning", Notification.Type.TRAY_NOTIFICATION)
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
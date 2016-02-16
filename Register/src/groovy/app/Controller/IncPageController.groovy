package app.Controller

import org.apache.commons.lang.StringUtils
import java.lang.String

import com.vaadin.ui.Label
import com.vaadin.ui.Notification

import register.Subject

class IncPageController{
	public int setSubject(String code, String name, String sec, String time){
		if(StringUtils.isBlank(code) == true || StringUtils.isBlank(name) == true || StringUtils.isBlank(sec) == true || StringUtils.isBlank(time) == true) return 99;
		else if(code.length() != 6) return 97
		else if(checkString(code, 0) == 1) return 98
		else if(checkString(sec, 0) == 1) return 96
		else if(checkString(time, 1) == 1) return 95
		else{
			Subject sub = new Subject()
			sub.setCode(code)
			sub.setName(name)
			sub.setSection(sec)
			sub.setTime(time)
			sub = sub.save()
			return 0
		}
	}
	
	public Label setCapMessage(Label label, int num){
		if(num == 99) label.setValue("!!Please!! Fill Information")
		else if(num == 98) label.setValue("!!Uncorrect!! Edit Subject's Code")
		else if(num == 97) label.setValue("!!Please!! Fill Subject's Code with 6 Character")
		else if(num == 96) label.setValue("!!Uncorrect!! Edit Section")
		else if(num == 95) label.setValue("!!Please!! Edit to Format's Time")
		else {
			label.setValue("Complete!!")
			Notification.show("Complete!!", Notification.Type.TRAY_NOTIFICATION)
		}
		if(label.getValue() != null) label.setVisible(true)
		return label
	}
	
	private int checkString(String item, int j){
		int chk = 0
		if(j == 0){
			for(int i = 0; i < item.length(); i++){
				if(item.charAt(i) > '9' || item.charAt(i) < '0') chk = 1
			}
		}
		else if(j == 1){
			for(int i = 0; i < item.length(); i++){
				if(item.charAt(i) == '\n'){
					println("true")
					item = item.substring(0, i) + ";" + item.substring(i, item.length())
					println(item)
					break;
				}
				else {
					println("false")
				}
			}
			chk = 1
		}
		return chk
	}
}
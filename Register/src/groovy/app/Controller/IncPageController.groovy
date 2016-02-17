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
			sub.setSectiongroup(Integer.parseInt(sec))
			sub.setTime(getTimes(time))
			sub = sub.save()
			return 0;
		}
	}
	
	public String getTimes(String time){
		ArrayList point = new ArrayList()
		for(int i = 0; i < time.length(); i++){
			if(time.charAt(i) == ':' || time.charAt(i) == ' '){
				point.add(i)
			}
		}
		if(point.size() == 6)time = time.substring(0, point.get(2) + 3) + ';' + time.substring(point.get(2) + 4) + ';'
		else if(point.size() == 3)time = time + ';'
		return time
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
		ArrayList point = new ArrayList()
		if(j == 0){
			for(int i = 0; i < item.length(); i++){
				if(item.charAt(i) > '9' || item.charAt(i) < '0') return 1;
			}
			return 0;
		}
		else if(j == 1){
			for(int i = 0; i < item.length(); i++){
				if(item.charAt(i) == ':' || item.charAt(i) == ' '){
					point.add(i)
				}
			}
			if(point.size() == 6){
				item = item.substring(0, point.get(2) + 3) + ';' + item.substring(point.get(2) + 4) + ';'
				
				String dayone = item.substring(0, point.get(2) + 4)
				String daytwo = item.substring(point.get(2) + 4)
				
				if(	item.substring(0, point.get(0)).equals("Mon") == true ||
					item.substring(0, point.get(0)).equals("Tu") == true ||
					item.substring(0, point.get(0)).equals("Wed") == true ||
					item.substring(0, point.get(0)).equals("Thu") == true ||
					item.substring(0, point.get(0)).equals("Fri") == true ||
					item.substring(0, point.get(0)).equals("Sat") == true ||
					item.substring(0, point.get(0)).equals("Sun") == true) chk++
				else return 1;
				
				if(	item.substring(point.get(2) + 4, point.get(3)).equals("Mon") == true ||
					item.substring(point.get(2) + 4, point.get(3)).equals("Tu") == true ||
					item.substring(point.get(2) + 4, point.get(3)).equals("Wed") == true ||
					item.substring(point.get(2) + 4, point.get(3)).equals("Thu") == true ||
					item.substring(point.get(2) + 4, point.get(3)).equals("Fri") == true ||
					item.substring(point.get(2) + 4, point.get(3)).equals("Sat") == true ||
					item.substring(point.get(2) + 4, point.get(3)).equals("Sun") == true) chk++
				else return 1;

				if(chk != 2) return 1;
				else{
					if(checkTime(item.substring(point.get(0) + 1, point.get(2) + 3)) == 1) return 1;
					else if(checkTime(item.substring(point.get(4) - 2, item.length() - 1)) == 1) return 1;
				}
			}
			else if(point.size() == 3){
				item = item + ';'
				if(item.substring(0, point.get(0)).equals("Mon") == true || item.substring(0, point.get(0)).equals("Tu") == true || item.substring(0, point.get(0)).equals("Wed") == true || item.substring(0, point.get(0)).equals("Thu") == true || item.substring(0, point.get(0)).equals("Fri") == true || item.substring(0, point.get(0)).equals("Sat") == true || item.substring(0, point.get(0)).equals("Sun") == true){
					if(checkTime(item.substring(point.get(0) + 1, point.get(2) + 3)) == 1) return 1;
					else return 0;
				}
				else return 1;
			}
			return 0;
		}
	}
	
	private int checkTime(String time){
		for(int i = 0; i < time.length(); i++){
			if(time.charAt(i) == ':' || time.charAt(i) == '-') i++
			if(time.charAt(i) < '0' || time.charAt(i) > '9') return 1;
		}
		return 0;
	}
}
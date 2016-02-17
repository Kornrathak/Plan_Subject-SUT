package app

import com.vaadin.ui.UI
import com.vaadin.server.VaadinRequest
import com.vaadin.server.FontAwesome
import com.vaadin.grails.Grails

import com.vaadin.annotations.Theme
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.MenuBar
import com.vaadin.ui.MenuBar.MenuItem
import com.vaadin.ui.MenuBar.Command
import com.vaadin.ui.*

import app.IncreasePage
import app.SubjectPage

import app.Controller.IncPageController
import app.Controller.SubjectPageController

@Theme("todo")
class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

		VerticalLayout layout = new VerticalLayout()
		
		IncPageController incCon = new IncPageController()
		this.getSession().setAttribute("increase", incCon)
		
		SubjectPageController subCon = new SubjectPageController()
		this.getSession().setAttribute("subject", subCon)
		
		Panel home = homePage()
		
        layout.addComponent(home)

		setContent(layout)
    }
	
	protected Panel homePage(){
	
		int k = 0
		
		//===============================
		ArrayList list = new ArrayList()
		list.add("Plans")
		list.add(FontAwesome.HOME)
		list.add("Subjectes")
		list.add(FontAwesome.HOME)
		list.add("Add Subject")
		list.add(FontAwesome.HOME)
		//===============================
		
		Panel editPanel = new Panel()
		VerticalLayout layout = new VerticalLayout()
		MenuBar menuUser = new MenuBar()
		
		editPanel.setContent(layout)
		editPanel.setSizeFull()
		layout.setSizeFull()
		layout.setMargin(true)
		layout.setSpacing(true)
		menuUser.addStyleName("mymenuUser")
		
		MenuBar.Command mycommand = new MenuBar.Command(){
			public void menuSelected(MenuItem selectedItem) {
				if(k > 0){
					layout.removeComponent(layout.getComponent(k))
                    k = 0
                }
				switch(selectedItem.getId()){
					case 2: // plan
						
                    break
					case 3: // have subject
						SubjectPage subPage = new SubjectPage()
						layout.addComponent(subPage)
						k++
                    break
					case 4: // add subject
						IncreasePage incPage = new IncreasePage()
						layout.addComponent(incPage)
						k++
                    break
				}
			}
		}
		for(int i = 0; i < list.size(); i+=2){
			MenuItem tag = menuUser.addItem(list.get(i), list.get(i+1), mycommand);
		}
		
		layout.addComponent(menuUser)
		layout.setComponentAlignment(menuUser, Alignment.TOP_CENTER)
		
		return editPanel
	}
}

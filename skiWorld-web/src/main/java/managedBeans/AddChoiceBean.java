package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AddChoiceBean {

	public String choice;
	public String redirect() {
		System.out.println(choice);
		if (choice.equals("ski")){return "AddSkiMan";}
		if (choice.equals("resto")){return "AddResataurantManager";}
		if (choice.equals("event")){return "AddEventHolder";}
		if (choice.equals("inst")){return "AddInstructor";}
return "welcome";
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}


}

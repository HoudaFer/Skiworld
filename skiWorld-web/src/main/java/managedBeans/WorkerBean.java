package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import skiworld.persistence.Worker;
import skiworld.services.IHandelUser;

@ManagedBean
@ViewScoped
public class WorkerBean {
	
	private String lastName;
	private String firstName;
	private String cin;
	private String phone;
	private String email;
	private String adress;
	private String password;
	private String login;
	private String experienceWorker;
	private String speciality;
	private String registrationNumbe;
	private Worker worker;
	private List<Worker> workers;
	private Boolean renderUpdateForm = false;

	
	@EJB
	private IHandelUser handelUser;
	
	public String addingWorker() {
		Worker worker = new Worker();
		worker.setLastName(lastName);
		worker.setFirstName(firstName);
		worker.setCin(cin);
		worker.setPhone(phone);
		worker.setEmail(email);
		worker.setAdress(adress);
		worker.setPassword(password);
		worker.setLogin(login);
		worker.setExperienceWorker(experienceWorker);
		worker.setSpeciality(speciality);
		worker.setRegistrationNumbe(registrationNumbe);
		handelUser.addWorker(worker);
		return "welcome2";
		
	}
	
	@PostConstruct
	public void init(){ 
		worker= new Worker();
		workers=new ArrayList<>();
		workers= handelUser.FindAllWorker();
		worker.getLastName();
		worker.getFirstName();
		worker.getCin();
		worker.getAdress();
		worker.getPassword();
		worker.getLogin();
		worker.getExperienceWorker();
		worker.getSpeciality();
		worker.getRegistrationNumbe();
		worker.getEmail();
		worker.getPhone();

	}
	
	public String deletingWorker(Worker worker) {
		handelUser.deleteWorker(worker);
		init();
		return null;
	}
	
	public String updateWorker() {
		//worker.setIdUser();
		System.out.println(worker.getIdUser());
		handelUser.updateWorker(worker);
		//init();
		return null ;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getExperienceWorker() {
		return experienceWorker;
	}
	public void setExperienceWorker(String experienceWorker) {
		this.experienceWorker = experienceWorker;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getRegistrationNumbe() {
		return registrationNumbe;
	}
	public void setRegistrationNumbe(String registrationNumbe) {
		this.registrationNumbe = registrationNumbe;
	}
	public IHandelUser getHandelUser() {
		return handelUser;
	}
	public void setHandelUser(IHandelUser handelUser) {
		this.handelUser = handelUser;
	}


	public Worker getWorker() {
		return worker;
	}


	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	public Boolean getRenderUpdateForm() {
		return renderUpdateForm;
	}

	public void setRenderUpdateForm(Boolean renderUpdateForm) {
		this.renderUpdateForm = renderUpdateForm;
	}
		
}

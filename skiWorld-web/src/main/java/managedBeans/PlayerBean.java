package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import skiworld.persistence.Event;
import skiworld.persistence.Player;
import skiworld.persistence.PlayersType;
import skiworld.services.EventServiceLocal;
import skiworld.services.PlayerServiceLocal;

@ManagedBean
@ViewScoped
public class PlayerBean {
	
	@EJB
	PlayerServiceLocal local;
	@EJB
	EventServiceLocal local2;
	
	Player player= new Player();
	private List<Player> players= new ArrayList<>();
	private Boolean renderUpdateForm = false;
	
	private List<Event> events;
	
	
	private String lastName;
	private String firstName;
	private String cin;
	private String phone;
	private String email;
	private String adress;
	private String password;
	private String login;
	private int age;
	private int experiencePlayer;
	private boolean isVIP;
	Event evenement = new Event();
	
	
	public String AddPlayer(){
		
		Player player= new Player();
		player.setLastName(lastName);
		player.setFirstName(firstName);
		player.setCin(cin);
		player.setPhone(phone);
		player.setEmail(email);
		player.setAdress(adress);
		player.setPassword(password);
		player.setLogin(login);
		player.setAge(age);
		player.setExperiencePlayer(experiencePlayer);
		player.setVIP(isVIP);
		player.setEvenement(evenement);
		evenement.setIdEvent(1);
		
		
		local.ajouterPlayer(player);
		return null;
	}
	
	@PostConstruct
	public void init()
	{
		player= new Player();
		player.setEvenement(new Event());
		players = local.findAll();
		player.setEvenement(new Event());
		
	}
	
	
	public String delete(Player player) {

		local.supprimerPlayer(player);
		init();
		return null;
	}
	
	public String update() {
		System.out.println(player.getIdUser());
		local.modifierPlayer(player);
		init();
		return null;
	}
	
	public String inisialiser() {
		renderUpdateForm = true;

		return null;
	}

	public PlayerServiceLocal getLocal() {
		return local;
	}

	public void setLocal(PlayerServiceLocal local) {
		this.local = local;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Boolean getRenderUpdateForm() {
		return renderUpdateForm;
	}

	public void setRenderUpdateForm(Boolean renderUpdateForm) {
		this.renderUpdateForm = renderUpdateForm;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	

	public EventServiceLocal getLocal2() {
		return local2;
	}

	public void setLocal2(EventServiceLocal local2) {
		this.local2 = local2;
	}

	public List<Event> events(){
		return events = local2.ListEvents();
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperiencePlayer() {
		return experiencePlayer;
	}

	public void setExperiencePlayer(int experiencePlayer) {
		this.experiencePlayer = experiencePlayer;
	}

	public boolean isVIP() {
		return isVIP;
	}

	public void setVIP(boolean isVIP) {
		this.isVIP = isVIP;
	}

	public Event getEvenement() {
		return evenement;
	}

	public void setEvenement(Event evenement) {
		this.evenement = evenement;
	}
	
	
	

}

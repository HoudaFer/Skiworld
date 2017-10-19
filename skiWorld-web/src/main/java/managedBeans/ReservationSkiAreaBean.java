package managedBeans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import skiworld.persistence.Admin;
import skiworld.persistence.SkiArea;
import skiworld.services.IHandleReservation;
import skiworld.services.IHandleSkiArea;

@ManagedBean
@ViewScoped
public class ReservationSkiAreaBean {

	private List<SkiArea> skiareas;
	private SkiArea selectedskiArea ;
	private Boolean renderReserver=false;
	private Date reservationDate;
	private Admin admin;
	private SkiArea skiareasfiltered;
	@EJB
	IHandleSkiArea handleSkiArea;
	@EJB
	IHandleReservation handleReservation;
	private Date date ;
	
	@ManagedProperty(value="#{authenticationBean}")
	private AuthenticationBean authenticationBean;
	
	public String reserver(){
		handleReservation.ReserverSkiArea((Admin) authenticationBean.getUser(), selectedskiArea, reservationDate);
		System.out.println(reservationDate.toInstant());
		return null;
		
	}
	
	@PostConstruct
	public void init(){
		//skiareas=(handleSkiArea.findAll());
		skiareas=new ArrayList<>() ;
		
	}
	
	
	public void  find2() {
		//reservationDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.format(reservationDate);
		System.out.println(format);
		System.out.println(reservationDate);
		skiareas=handleReservation.findBYDate(reservationDate);
		for (SkiArea skiArea : skiareas) {
			System.out.println(skiArea);

		}
		
	}
	public List<SkiArea> getSkiareas() {
		return skiareas;
	}
	public void setSkiareas(List<SkiArea> skiareas) {
		this.skiareas = skiareas;
	}
	public Boolean getRenderReserver() {
		return renderReserver;
	}
	public void setRenderReserver(Boolean renderReserver) {
		this.renderReserver = renderReserver;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public SkiArea getSelectedskiArea() {
		return selectedskiArea;
	}
	public void setSelectedskiArea(SkiArea selectedskiArea) {
		this.selectedskiArea = selectedskiArea;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public AuthenticationBean getAuthenticationBean() {
		return authenticationBean;
	}
	public void setAuthenticationBean(AuthenticationBean authenticationBean) {
		this.authenticationBean = authenticationBean;
	}
	public SkiArea getSkiareasfiltered() {
		return skiareasfiltered;
	}
	public void setSkiareasfiltered(SkiArea skiareasfiltered) {
		this.skiareasfiltered = skiareasfiltered;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
//	 public void info() {
//	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Reservation done."));
//	    }
	
	
	
	
}

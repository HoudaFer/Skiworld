package managedBeans;


import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import skiworld.persistence.Admin;
import skiworld.persistence.Client;
import skiworld.persistence.RestoTable;
import skiworld.services.IManageTable;
import skiworld.services.IManageTableReservation;
@ManagedBean
@ViewScoped
public class TableReservationBean {
	private List<RestoTable> restotables;
	private RestoTable selectedTable;
	private Boolean renderReserve=false;
	private Date startTime;
	private Date endTime;
	private Client client;
	private Admin admin;
	@EJB
	private IManageTable managetable;
	@EJB
	private IManageTableReservation managereservation;
	@ManagedProperty(value = "#{authenticationBean}")
	private AuthenticationBean authenticationBean;
	
	public String Reserve() {
		managereservation.reserveRestoTable((Client) authenticationBean.getUser(), selectedTable, startTime, endTime);
		System.out.println(startTime.toInstant());
		return null;
	}
	
	@PostConstruct
	public void init() {
		restotables= managetable.findAllTables();
	}
	
	public List<RestoTable> getRestotables() {
		return restotables;
	}
	public void setRestotables(List<RestoTable> restotables) {
		this.restotables = restotables;
	}
	public RestoTable getSelectedTable() {
		return selectedTable;
	}
	public void setSelectedTable(RestoTable selectedTable) {
		this.selectedTable = selectedTable;
	}
	
	public Boolean getRenderReserve() {
		return renderReserve;
	}
	public void setRenderReserve(Boolean renderReserve) {
		this.renderReserve = renderReserve;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public IManageTable getManagetable() {
		return managetable;
	}
	public void setManagetable(IManageTable managetable) {
		this.managetable = managetable;
	}
	
	public IManageTableReservation getManagereservation() {
		return managereservation;
	}

	public void setManagereservation(IManageTableReservation managereservation) {
		this.managereservation = managereservation;
	}

	public AuthenticationBean getAuthenticationBean() {
		return authenticationBean;
	}
	public void setAuthenticationBean(AuthenticationBean authenticationBean) {
		this.authenticationBean = authenticationBean;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
}

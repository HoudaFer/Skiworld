package managedBeans;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;
import javax.faces.application.FacesMessage;

import org.apache.commons.io.IOUtils;

import skiworld.persistence.SkiArea;
import skiworld.persistence.SkiAreaType;
import skiworld.services.IHandleSkiArea;

@ManagedBean
@ViewScoped

public class AddSkiAreaBean {
	@EJB
	IHandleSkiArea HandleSkiArea;
    private Blob uploadImage;
	private List<SkiArea> skiareas;
	private List<SkiArea> skiareasfiltered;
	private String name;
	private String address;
	private Blob image;
	private Part picFile;
	private boolean Available;
	
	private List<SelectItem> selectItemsForPisteTypes;
	private int selectedPisteTypeId = -1;
	
	private List<SelectItem> filterTypes;
	
	private int spectatorNumber;
	SkiArea skiArea = new SkiArea();
	SkiArea skiArea2= new SkiArea();
	SkiArea skiAreafiltered = new SkiArea();
	private Boolean renderUpdateForm = false;

	public String AddSkiArea() throws IOException, SerialException, SQLException {
		SkiArea SkiArea = new SkiArea();
		SkiArea.setName(name);
		SkiArea.setAddress(address);
		SkiArea.setImage(image);
		SkiArea.setAvailable(Available);
		SkiArea.setSpectatorNumber(spectatorNumber);
		
		HandleSkiArea.AddSkiArea(SkiArea);
		init();
		return "ListSkiArea";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSpectatorNumber() {
		return spectatorNumber;
	}

	public void setSpectatorNumber(int spectatorNumber) {
		this.spectatorNumber = spectatorNumber;
	}

	public IHandleSkiArea getHandleSkiArea() {
		return HandleSkiArea;
	}

	public void setHandleSkiArea(IHandleSkiArea handleSkiArea) {
		HandleSkiArea = handleSkiArea;
	}

	public List<SkiArea> getSkiareas() {
		return skiareas;
	}

	public void setSkiareas(List<SkiArea> skiareas) {
		this.skiareas = skiareas;
	}

	public SkiArea getSkiArea() {
		return skiArea;
	}

	public void setSkiArea(SkiArea skiArea) {
		this.skiArea = skiArea;
	}

	public Boolean getRenderUpdateForm() {
		return renderUpdateForm;
	}

	public void setRenderUpdateForm(Boolean renderUpdateForm) {
		this.renderUpdateForm = renderUpdateForm;
	}

	public String deleteSkiArea(SkiArea skiArea) {

		HandleSkiArea.supprimerSkiArea(skiArea);
		init();
		return null;
	}
	
	public String updateSkiArea() throws IOException, SerialException, SQLException {
		System.out.println("id : "+skiArea2.getIdArea());
		if(picFile!=null){
		InputStream is=picFile.getInputStream();
        byte[] content = IOUtils.toByteArray(is);
        Blob blob = new javax.sql.rowset.serial.SerialBlob(content);
        skiArea2.setImage(blob);
		}
		else
			skiArea2.setImage(uploadImage);
		
        skiArea2.setSkiAreaType(HandleSkiArea.findPisteTypeById(selectedPisteTypeId));
        
		HandleSkiArea.modifierSkiArea(skiArea2);
		init();
		return null;
	}
	
	@PostConstruct
	public void init() {
		
		List<SkiAreaType> skiareatypes = HandleSkiArea.getAllPisteType();

		selectItemsForPisteTypes = new ArrayList<SelectItem>(skiareatypes.size());
				for(SkiAreaType skiareatype:skiareatypes){
					selectItemsForPisteTypes.add(new SelectItem(skiareatype.getIdType(),skiareatype.getTypeArea()));
				}
				
				filterTypes = new ArrayList<SelectItem>(skiareatypes.size()+1);
				filterTypes.add(new SelectItem("","select"));
				for(SkiAreaType skiAreaType:skiareatypes){
					filterTypes.add(new SelectItem(skiAreaType.getTypeArea(),skiAreaType.getTypeArea()));
				}
				
		skiArea = new SkiArea();
		skiareas = HandleSkiArea.findAll();
		

	}
	
	public byte[] afficherPic(Blob blob) throws SQLException{

		return blob.getBytes(1, (int) blob.length());
	}
	
	public String inisialiser() {
		selectedPisteTypeId = -1;
		renderUpdateForm = true;
		return null;
	}

	public List<SkiArea> getSkiareasfiltered() {
		return skiareasfiltered;
	}

	public void setSkiareasfiltered(List<SkiArea> skiareasfiltered) {
		this.skiareasfiltered = skiareasfiltered;
	}

	public SkiArea getSkiArea2() {
		return skiArea2;
	}

	public void setSkiArea2(SkiArea skiArea2) {
		this.skiArea2 = skiArea2;
	}

	public Part getPicFile() {
		return picFile;
	}

	public void setPicFile(Part picFile) {
		this.picFile = picFile;
	}

	public List<SelectItem> getSelectItemsForPisteTypes() {
		return selectItemsForPisteTypes;
	}

	public void setSelectItemsForPisteTypes(List<SelectItem> selectItemsForPisteTypes) {
		this.selectItemsForPisteTypes = selectItemsForPisteTypes;
	}

	public int getSelectedPisteTypeId() {
		return selectedPisteTypeId;
	}

	public void setSelectedPisteTypeId(int selectedPisteTypeId) {
		this.selectedPisteTypeId = selectedPisteTypeId;
	}

	public Blob getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(Blob uploadImage) {
		this.uploadImage = uploadImage;
	}

	
	 public boolean isAvailable() {
		return Available;
	}

	public void setAvailable(boolean available) {
		Available = available;
	}

	public void addMessage() {
		String summary = Available? "Checked" : "Unchecked";
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	    }
	
	
	 public void error() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Requeried Field"));
	    }

	public List<SelectItem> getFilterTypes() {
		return filterTypes;
	}

	public void setFilterTypes(List<SelectItem> filterTypes) {
		this.filterTypes = filterTypes;
	}
	     
	  


	
	

}

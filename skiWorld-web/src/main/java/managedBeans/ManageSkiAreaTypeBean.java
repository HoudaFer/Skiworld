package managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import skiworld.persistence.DType;
import skiworld.persistence.SkiAreaType;
import skiworld.services.IHandleTypeSkiArea;

@ManagedBean
@ViewScoped

public class ManageSkiAreaTypeBean {

	@EJB
	IHandleTypeSkiArea handleTypeSkiArea;
	
	private List<SkiAreaType> typeskiareas;

	
	
	private String typeArea;
	private DType difficulty;
	private List<SkiAreaType> skiareatypesfiltered;
	SkiAreaType skiareaType = new SkiAreaType();
	SkiAreaType skiareaType2 = new SkiAreaType();
	private Boolean renderUpdateForm = false;
	
	

	
	public String AddSkiAreaType() {
		SkiAreaType skiareaType = new SkiAreaType();
		skiareaType.setTypeArea(typeArea);
		skiareaType.setDifficulty(difficulty);
		
		handleTypeSkiArea.AddTypeSkiArea(skiareaType);
		init();
		return "ListTypeSkiArea";
	}
	
	public IHandleTypeSkiArea getHandleTypeSkiArea() {
		return handleTypeSkiArea;
	}
	public void setHandleTypeSkiArea(IHandleTypeSkiArea handleTypeSkiArea) {
		this.handleTypeSkiArea = handleTypeSkiArea;
	}
	
	
	public String getTypeArea() {
		return typeArea;
	}

	public void setTypeArea(String typeArea) {
		this.typeArea = typeArea;
	}

	public DType getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(DType difficulty) {
		this.difficulty = difficulty;
	}

	public List<SkiAreaType> getTypeskiareas() {
		return typeskiareas;
	}
	public void setTypeskiareas(List<SkiAreaType> typeskiareas) {
		this.typeskiareas = typeskiareas;
	}
	
	public SkiAreaType getSkiareaType() {
		return skiareaType;
	}
	public void setSkiareaType(SkiAreaType skiareaType) {
		this.skiareaType = skiareaType;
	}
	public Boolean getRenderUpdateForm() {
		return renderUpdateForm;
	}
	public void setRenderUpdateForm(Boolean renderUpdateForm) {
		this.renderUpdateForm = renderUpdateForm;
	}

	public SkiAreaType getSkiareaType2() {
		return skiareaType2;
	}

	public void setSkiareaType2(SkiAreaType skiareaType2) {
		this.skiareaType2 = skiareaType2;
	}


	
	public String deleteSkiAreaType(SkiAreaType skiareaType) {

		handleTypeSkiArea.RemoveTypeSkiArea(skiareaType);
		init();
		return null;
	}
	
	public String updateSkiAreaType() {
		System.out.println("id : "+skiareaType2.getIdType());
		handleTypeSkiArea.UpdateTypeSkiArea(skiareaType2);
		init();
		return null;
	}
	
	
	
	@PostConstruct
	public void init() {
		skiareaType = new SkiAreaType();
		skiareaType2=new SkiAreaType();
		typeskiareas = handleTypeSkiArea.findAll();

	}
	
	public String inisialiser() {
		renderUpdateForm = true;

		return null;
	}

	public List<SkiAreaType> getSkiareatypesfiltered() {
		return skiareatypesfiltered;
	}

	public void setSkiareatypesfiltered(List<SkiAreaType> skiareatypesfiltered) {
		this.skiareatypesfiltered = skiareatypesfiltered;
	}
	
	
	
}

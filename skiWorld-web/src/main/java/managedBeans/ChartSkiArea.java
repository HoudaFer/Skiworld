package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import skiworld.persistence.SkiArea;
import skiworld.services.IHandleSkiArea;

@ManagedBean
@ViewScoped
public class ChartSkiArea {
	
	
	private PieChartModel pieModel1;
	private List<SkiArea> skiAreas;
	private List<Long> xst; 
	private List<Long> lst;
	
	
	
	@EJB
 IHandleSkiArea handleSkiArea;
	
	
@PostConstruct
	public void init(){
	skiAreas = new ArrayList<SkiArea>();
	lst = new ArrayList<>();
	xst = new ArrayList<>();
	skiAreas = handleSkiArea.findAll();
	lst = handleSkiArea.findStat();
	xst = handleSkiArea.findStat1();
	
	graph(skiAreas);
		}
	

private void graph(List<SkiArea> skiAreas){
 pieModel1 = new PieChartModel();

	for (int i=0;i<lst.size();i++)
	{

	pieModel1.set(skiAreas.get(i).getSkiAreaType().getTypeArea(), lst.get(i));
	
	
	}
	pieModel1.setTitle("Number types of SkiAreas");
	pieModel1.setLegendPosition("w");
	
	
}


public PieChartModel getPieModel1() {
	return pieModel1;
}


public void setPieModel1(PieChartModel pieModel1) {
	this.pieModel1 = pieModel1;
}


public List<SkiArea> getSkiAreas() {
	return skiAreas;
}


public void setSkiAreas(List<SkiArea> skiAreas) {
	this.skiAreas = skiAreas;
}


public List<Long> getXst() {
	return xst;
}


public void setXst(List<Long> xst) {
	this.xst = xst;
}
	

}


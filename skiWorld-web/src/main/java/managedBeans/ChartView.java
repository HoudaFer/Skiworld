package managedBeans;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;

import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import skiworld.persistence.Category;
import skiworld.persistence.Product;
import skiworld.services.IShopManager;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ChartView implements Serializable {

	private static final long serialVersionUID = 1L;
	private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    private BarChartModel barModel;
    
    
    public BarChartModel getBarModel() {
		return barModel;
	}

	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
	
    
@EJB
	
	private IShopManager local;
    private java.util.List<Product> p;
    private java.util.List<Category> p1;
    
    
    @PostConstruct
    public void init() {
    createPieModels();
    createAnimatedModels();
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
     
    private void createPieModels() {
        createPieModel1();
        //createPieModel2();
    }	





	
	
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
        p=local.ListProduct();
        p1=local.ListCategory();
        		System.out.println(p.size());
        pieModel1.set("products",p.size());
        pieModel1.set("Categorys",p1.size());
       // pieModel1.set("products1",(p1.size())-(p.size()));
        System.out.println(p1.size());
      
         
        pieModel1.setTitle("products' Statistics");
        pieModel1.setLegendPosition("w");
        pieModel1.setFill(true);
        pieModel1.setShowDataLabels(true);
        pieModel1.setDiameter(150);
    }
     
   
    
    

	

	
	
	 public java.util.List<Product> getP() {
		return p;
	}

	public void setP(java.util.List<Product> p) {
		this.p = p;
	}

	

	private void createAnimatedModels() {
	      
         
	        barModel = initBarModel();
	        barModel .setTitle("Bar Charts");
	        barModel.setAnimate(true);
	        barModel.setLegendPosition("ne");
	        Axis yAxis = barModel.getAxis(AxisType.Y);
	        yAxis.setMin(0);
	        yAxis.setMax(10);
	        yAxis = barModel.getAxis(AxisType.Y);
	        yAxis.setMin(0);
	        yAxis.setMax(30);
	    }
	
	 private BarChartModel initBarModel() {
	        BarChartModel model = new BarChartModel();
	 
	        ChartSeries boys = new ChartSeries();
	        boys.setLabel("products");
	        boys.set(" products", p.size());
	        
	 
	        ChartSeries girls = new ChartSeries();
	        girls.setLabel("Categorys");
	     
	     // girls.set("products1", (p1.size())-(p.size()));
	     girls.set("Categorys", (p1.size()));
	        model.addSeries(boys);
	        model.addSeries(girls);
	         
	        return model;
	    }

	public java.util.List<Category> getP1() {
		return p1;
	}

	public void setP1(java.util.List<Category> p1) {
		this.p1 = p1;
	}

	

	
	
	

	
	
    
    
    
	
}

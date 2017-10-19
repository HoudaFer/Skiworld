package skiworld.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SkiAreaType
 *
 */
@Entity

public class SkiAreaType implements Serializable {

	
	private int idType;
	private String TypeArea;
	private DType Difficulty;
	private List<SkiArea> skiArea ;
	private static final long serialVersionUID = 1L;

	public SkiAreaType() {
		super();
	}   
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdType() {
		return this.idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}   
	public String getTypeArea() {
		return this.TypeArea;
	}

	public void setTypeArea(String TypeArea) {
		this.TypeArea = TypeArea;
	}   
	public DType getDifficulty() {
		return this.Difficulty;
	}

	public void setDifficulty(DType Difficulty) {
		this.Difficulty = Difficulty;
	}
	
	
	@OneToMany(mappedBy="skiAreaType")
	@Column(name="ListskiArea")
	public List<SkiArea> getSkiArea() {
		return skiArea;
	}
	public void setSkiArea(List<SkiArea> skiArea) {
		this.skiArea = skiArea;
	}
	
	
	@PreRemove
	public void preRemove() {
		for (SkiArea p : skiArea)
			p.setSkiAreaType(null);
	}
	
	
   
}

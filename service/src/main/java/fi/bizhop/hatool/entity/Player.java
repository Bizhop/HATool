package fi.bizhop.hatool.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "player")
public class Player extends Base implements Serializable {

	private static final long serialVersionUID = -1820289674725136585L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Size(max=100)
	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "id")
	private List<PlayerData> data;
	
	public Player() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PlayerData> getData() {
		return data;
	}

	public void setData(List<PlayerData> data) {
		this.data = data;
	}
}

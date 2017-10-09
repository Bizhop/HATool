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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "active")
	private Boolean active;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
	@JsonIgnore
	private List<PlayerData> data;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "latest_data")
	private PlayerData latestData;
	
	@Column(name = "position")
	private Position position;
	
	@Column(name = "status")
	private Status status;

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<PlayerData> getData() {
		return data;
	}

	public void setData(List<PlayerData> data) {
		this.data = data;
	}
	
	public PlayerData getLatestData() {
		return latestData;
	}

	public void setLatestData(PlayerData latestData) {
		this.latestData = latestData;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}

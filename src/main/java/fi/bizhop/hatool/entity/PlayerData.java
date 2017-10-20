package fi.bizhop.hatool.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "player_data")
public class PlayerData extends Base implements Serializable {

	private static final long serialVersionUID = 5124537972481264054L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@JoinColumn(name = "player_id", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Player player;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "quality")
	private Integer quality;
	
	@Column(name = "potential")
	private Integer potential;
	
	@Column(name = "goalie")
	private Integer goalie;
	
	@Column(name = "defence")
	private Integer defence;
	
	@Column(name = "attack")
	private Integer attack;
	
	@Column(name = "shooting")
	private Integer shooting;
	
	@Column(name = "passing")
	private Integer passing;
	
	@Column(name = "speed")
	private Integer speed;
	
	@Column(name = "strength")
	private Integer strength;
	
	@Column(name = "self_control")
	private Integer selfControl;
	
	@Column(name = "form")
	private Integer form;
	
	@Column(name = "experience")
	private Integer experience;
	
	@Column(name = "ability_index")
	private Integer abilityIndex;
	
	@Column(name = "weeks")
	private Integer weeks;
	
	@Column(name = "growth_potential")
	private Integer growthPotential;
	
	@Column(name = "efficiency")
	private Integer efficiency;
	
	public PlayerData() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public Integer getPotential() {
		return potential;
	}

	public void setPotential(Integer potential) {
		this.potential = potential;
	}

	public Integer getGoalie() {
		return goalie;
	}

	public void setGoalie(Integer goalie) {
		this.goalie = goalie;
	}

	public Integer getDefence() {
		return defence;
	}

	public void setDefence(Integer defence) {
		this.defence = defence;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getShooting() {
		return shooting;
	}

	public void setShooting(Integer shooting) {
		this.shooting = shooting;
	}

	public Integer getPassing() {
		return passing;
	}

	public void setPassing(Integer passing) {
		this.passing = passing;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getSelfControl() {
		return selfControl;
	}

	public void setSelfControl(Integer selfControl) {
		this.selfControl = selfControl;
	}

	public Integer getForm() {
		return form;
	}

	public void setForm(Integer form) {
		this.form = form;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getAbilityIndex() {
		return abilityIndex;
	}

	public void setAbilityIndex(Integer abilityIndex) {
		this.abilityIndex = abilityIndex;
	}

	public Integer getWeeks() {
		return weeks;
	}

	public void setWeeks(Integer weeks) {
		this.weeks = weeks;
	}

	public Integer getGrowthPotential() {
		return growthPotential;
	}

	public void setGrowthPotential(Integer growthPotential) {
		this.growthPotential = growthPotential;
	}

	public Integer getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(Integer efficiency) {
		this.efficiency = efficiency;
	}
}

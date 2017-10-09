package fi.bizhop.hatool.projection;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface PlayerDataProjection {
	Integer getAge();
	Integer getQuality();
	Integer getPotential();
	Integer getGoalie();
	Integer getDefence();
	Integer getAttack();
	Integer getShooting();
	Integer getPassing();
	Integer getSpeed();
	Integer getStrength();
	Integer getSelfControl();
	Integer getForm();
	Integer getExperience();
	Integer getAbilityIndex();
	Integer getWeeks();
	Integer getGrowthPotential();
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
	Date getCreatedAt();
}

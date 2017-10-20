package fi.bizhop.hatool.projection;

import org.springframework.beans.factory.annotation.Value;

public interface PlayerListingProjection {
	Integer getId();
	String getName();
	String getPosition();
	String getStatus();
	
	@Value("#{target.getLatestData().getAge()}")
	Integer getAge();
	@Value("#{target.getLatestData().getQuality()}")
	Integer getQuality();
	@Value("#{target.getLatestData().getPotential()}")
	Integer getPotential();
	@Value("#{target.getLatestData().getGoalie()}")
	Integer getGoalie();
	@Value("#{target.getLatestData().getDefence()}")
	Integer getDefence();
	@Value("#{target.getLatestData().getAttack()}")
	Integer getAttack();
	@Value("#{target.getLatestData().getShooting()}")
	Integer getShooting();
	@Value("#{target.getLatestData().getPassing()}")
	Integer getPassing();
	@Value("#{target.getLatestData().getSpeed()}")
	Integer getSpeed();
	@Value("#{target.getLatestData().getStrength()}")
	Integer getStrength();
	@Value("#{target.getLatestData().getSelfControl()}")
	Integer getSelfControl();
	@Value("#{target.getLatestData().getForm()}")
	Integer getForm();
	@Value("#{target.getLatestData().getExperience()}")
	Integer getExperience();
	@Value("#{target.getLatestData().getAbilityIndex()}")
	Integer getAbilityIndex();
	@Value("#{target.getLatestData().getWeeks()}")
	Integer getWeeks();
	@Value("#{target.getLatestData().getGrowthPotential()}")
	Integer getGrowthPotential();
	@Value("#{target.getLatestData().getEfficiency()}")
	Integer getEfficiency();
}

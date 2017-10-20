package fi.bizhop.hatool.projection;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public interface PlayerDetailsProjection {
	Integer getId();
	@Value("#{target.getOwner().getId()}")
	Integer getOwnerId();
	String getName();
	@Value("#{target.getLatestData().getAge()}")
	Integer getAge();
	@Value("#{target.getLatestData().getQuality()}")
	Integer getQuality();
	@Value("#{target.getLatestData().getPotential()}")
	Integer getPotential();
	Boolean getActive();
	String getPosition();
	String getStatus();
	Integer getLoyalty();
	@Value("#{target.getData()}")
	List<PlayerDataProjection> getData();
}

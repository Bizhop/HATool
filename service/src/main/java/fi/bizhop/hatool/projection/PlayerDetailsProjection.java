package fi.bizhop.hatool.projection;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public interface PlayerDetailsProjection {
	String getName();
	Boolean getActive();
	String getPosition();
	String getStatus();
	@Value("#{target.getData()}")
	List<PlayerDataProjection> getData();
}

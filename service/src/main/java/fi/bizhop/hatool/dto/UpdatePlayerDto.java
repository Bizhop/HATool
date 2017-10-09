package fi.bizhop.hatool.dto;

import fi.bizhop.hatool.entity.Position;
import fi.bizhop.hatool.entity.Status;

public class UpdatePlayerDto {
	Position position;
	Status status;
	
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

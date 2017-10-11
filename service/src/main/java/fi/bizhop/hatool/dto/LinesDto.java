package fi.bizhop.hatool.dto;

import java.util.ArrayList;
import java.util.List;

public class LinesDto {
	private Line y1;
	private Line y2;
	private Line y3;
	private Line y4;
	private Line j1;
	private Line j2;
	private Line j3;
	private List<LinePlayer> goalies;
	private List<LinePlayer> extra;
	
	public Line getY1() {
		return y1;
	}
	public void setY1(Line y1) {
		this.y1 = y1;
	}
	public Line getY2() {
		return y2;
	}
	public void setY2(Line y2) {
		this.y2 = y2;
	}
	public Line getY3() {
		return y3;
	}
	public void setY3(Line y3) {
		this.y3 = y3;
	}
	public Line getY4() {
		return y4;
	}
	public void setY4(Line y4) {
		this.y4 = y4;
	}
	public Line getJ1() {
		return j1;
	}
	public void setJ1(Line j1) {
		this.j1 = j1;
	}
	public Line getJ2() {
		return j2;
	}
	public void setJ2(Line j2) {
		this.j2 = j2;
	}
	public Line getJ3() {
		return j3;
	}
	public void setJ3(Line j3) {
		this.j3 = j3;
	}
	public List<LinePlayer> getGoalies() {
		if(goalies == null) {
			goalies = new ArrayList<LinePlayer>();
		}
		return goalies;
	}
	public List<LinePlayer> getExtra() {
		if(extra == null) {
			extra = new ArrayList<LinePlayer>();
		}
		return extra;
	}
}
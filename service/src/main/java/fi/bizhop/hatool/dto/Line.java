package fi.bizhop.hatool.dto;

public class Line {
	private LinePlayer c;
	private LinePlayer lw;
	private LinePlayer rw;
	private LinePlayer ld;
	private LinePlayer rd;
	
	public LinePlayer getC() {
		return c;
	}
	public void setC(LinePlayer c) {
		this.c = c;
	}
	public LinePlayer getLw() {
		return lw;
	}
	public void setLw(LinePlayer lw) {
		this.lw = lw;
	}
	public LinePlayer getRw() {
		return rw;
	}
	public void setRw(LinePlayer rw) {
		this.rw = rw;
	}
	public LinePlayer getLd() {
		return ld;
	}
	public void setLd(LinePlayer ld) {
		this.ld = ld;
	}
	public LinePlayer getRd() {
		return rd;
	}
	public void setRd(LinePlayer rd) {
		this.rd = rd;
	}
}

package fi.bizhop.hatool.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "nimi", "ikä", "lah", "pot", "mv", "puol", "hyökk", "lauk", "syö", "nop", "voim", "ihi", "knto", "kok", "ti", "viikko" })
public class Player implements Comparable<Player> {
	private String nimi;
	private String ikä;
	private String lah;
	private String pot;
	private String mv;
	private String puol;
	private String hyökk;
	private String lauk;
	private String syö;
	private String nop;
	private String voim;
	private String ihi;
	private String knto;
	private String kok;
	private String ti;
	private String viikko;
	
	public Player(String nimi, String ikä, String lah, String pot, String mv,
			String puol, String hyökk, String lauk, String syö, String nop,
			String voim, String ihi, String knto, String kok, String ti,
			String viikko) {
		super();
		this.nimi = nimi;
		this.ikä = ikä;
		this.lah = lah;
		this.pot = pot;
		this.mv = mv;
		this.puol = puol;
		this.hyökk = hyökk;
		this.lauk = lauk;
		this.syö = syö;
		this.nop = nop;
		this.voim = voim;
		this.ihi = ihi;
		this.knto = knto;
		this.kok = kok;
		this.ti = ti;
		this.viikko = viikko;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getIkä() {
		return ikä;
	}

	public void setIkä(String ikä) {
		this.ikä = ikä;
	}

	public String getLah() {
		return lah;
	}

	public void setLah(String lah) {
		this.lah = lah;
	}

	public String getPot() {
		return pot;
	}

	public void setPot(String pot) {
		this.pot = pot;
	}

	public String getMv() {
		return mv;
	}

	public void setMv(String mv) {
		this.mv = mv;
	}

	public String getPuol() {
		return puol;
	}

	public void setPuol(String puol) {
		this.puol = puol;
	}

	public String getHyökk() {
		return hyökk;
	}

	public void setHyökk(String hyökk) {
		this.hyökk = hyökk;
	}

	public String getLauk() {
		return lauk;
	}

	public void setLauk(String lauk) {
		this.lauk = lauk;
	}

	public String getSyö() {
		return syö;
	}

	public void setSyö(String syö) {
		this.syö = syö;
	}

	public String getNop() {
		return nop;
	}

	public void setNop(String nop) {
		this.nop = nop;
	}

	public String getVoim() {
		return voim;
	}

	public void setVoim(String voim) {
		this.voim = voim;
	}

	public String getIhi() {
		return ihi;
	}

	public void setIhi(String ihi) {
		this.ihi = ihi;
	}

	public String getKnto() {
		return knto;
	}

	public void setKnto(String knto) {
		this.knto = knto;
	}

	public String getKok() {
		return kok;
	}

	public void setKok(String kok) {
		this.kok = kok;
	}

	public String getTi() {
		return ti;
	}

	public void setTi(String ti) {
		this.ti = ti;
	}

	public String getViikko() {
		return viikko;
	}

	public void setViikko(String viikko) {
		this.viikko = viikko;
	}

	@Override
	public int compareTo(Player o) {
		if(o == null) {
			return 0;
		}
		else {
			return this.getNimi().compareTo(o.getNimi());
		}
	}
}
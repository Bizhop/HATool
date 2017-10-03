package fi.bizhop.hatool.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "nimi", "ika", "lah", "pot", "mv", "puol", "hyokk", "lauk", "syo", "nop", "voim", "ihi", "knto", "kok", "ti", "viikko" })
public class PlayerDto implements Comparable<PlayerDto> {
	private String nimi;
	private String ika;
	private String lah;
	private String pot;
	private String mv;
	private String puol;
	private String hyokk;
	private String lauk;
	private String syo;
	private String nop;
	private String voim;
	private String ihi;
	private String knto;
	private String kok;
	private String ti;
	private String viikko;
	
	public PlayerDto(String nimi, String ika, String lah, String pot, String mv,
			String puol, String hyokk, String lauk, String syo, String nop,
			String voim, String ihi, String knto, String kok, String ti,
			String viikko) {
		super();
		this.nimi = nimi;
		this.ika = ika;
		this.lah = lah;
		this.pot = pot;
		this.mv = mv;
		this.puol = puol;
		this.hyokk = hyokk;
		this.lauk = lauk;
		this.syo = syo;
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

	public String getIka() {
		return ika;
	}

	public void setIka(String ika) {
		this.ika = ika;
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

	public String getHyokk() {
		return hyokk;
	}

	public void setHyokk(String hyokk) {
		this.hyokk = hyokk;
	}

	public String getLauk() {
		return lauk;
	}

	public void setLauk(String lauk) {
		this.lauk = lauk;
	}

	public String getSyo() {
		return syo;
	}

	public void setSyo(String syo) {
		this.syo = syo;
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
	public int compareTo(PlayerDto o) {
		if(o == null) {
			return 0;
		}
		else {
			return this.getNimi().compareTo(o.getNimi());
		}
	}
}
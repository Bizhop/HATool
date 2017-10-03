package fi.bizhop.hatool.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "nimi", "ika", "lah", "pot", "mv", "puol", "hyokk", "lauk", "syo", "nop", "voim", "ihi", "knto", "kok", "ti", "viikko" })
public class PlayerDto implements Comparable<PlayerDto> {
	private String nimi;
	private Integer ika;
	private Integer lah;
	private Integer pot;
	private Integer mv;
	private Integer puol;
	private Integer hyokk;
	private Integer lauk;
	private Integer syo;
	private Integer nop;
	private Integer voim;
	private Integer ihi;
	private Integer knto;
	private Integer kok;
	private Integer ti;
	private Integer viikko;
	
	public PlayerDto(String nimi, Integer ika, Integer lah, Integer pot, Integer mv,
			Integer puol, Integer hyokk, Integer lauk, Integer syo, Integer nop,
			Integer voim, Integer ihi, Integer knto, Integer kok, Integer ti,
			Integer viikko) {
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

	public Integer getIka() {
		return ika;
	}

	public void setIka(Integer ika) {
		this.ika = ika;
	}

	public Integer getLah() {
		return lah;
	}

	public void setLah(Integer lah) {
		this.lah = lah;
	}

	public Integer getPot() {
		return pot;
	}

	public void setPot(Integer pot) {
		this.pot = pot;
	}

	public Integer getMv() {
		return mv;
	}

	public void setMv(Integer mv) {
		this.mv = mv;
	}

	public Integer getPuol() {
		return puol;
	}

	public void setPuol(Integer puol) {
		this.puol = puol;
	}

	public Integer getHyokk() {
		return hyokk;
	}

	public void setHyokk(Integer hyokk) {
		this.hyokk = hyokk;
	}

	public Integer getLauk() {
		return lauk;
	}

	public void setLauk(Integer lauk) {
		this.lauk = lauk;
	}

	public Integer getSyo() {
		return syo;
	}

	public void setSyo(Integer syo) {
		this.syo = syo;
	}

	public Integer getNop() {
		return nop;
	}

	public void setNop(Integer nop) {
		this.nop = nop;
	}

	public Integer getVoim() {
		return voim;
	}

	public void setVoim(Integer voim) {
		this.voim = voim;
	}

	public Integer getIhi() {
		return ihi;
	}

	public void setIhi(Integer ihi) {
		this.ihi = ihi;
	}

	public Integer getKnto() {
		return knto;
	}

	public void setKnto(Integer knto) {
		this.knto = knto;
	}

	public Integer getKok() {
		return kok;
	}

	public void setKok(Integer kok) {
		this.kok = kok;
	}

	public Integer getTi() {
		return ti;
	}

	public void setTi(Integer ti) {
		this.ti = ti;
	}

	public Integer getViikko() {
		return viikko;
	}

	public void setViikko(Integer viikko) {
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
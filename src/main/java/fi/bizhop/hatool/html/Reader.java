package fi.bizhop.hatool.html;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import fi.bizhop.hatool.dto.PlayerDto;

public class Reader {
	
	private static final String playersUrl = "http://www.hockeyarena.net/fi/index.php?p=manager_team_players.php";

	public static List<PlayerDto> readPlayers(Map<String, String> cookies) throws Exception {
		Document doc = Jsoup.connect(playersUrl)
				.cookies(cookies)
				.get();
		
		Element table = doc.getElementById("table-2");
		Elements rows = table.select("tbody").select("tr");
		
		List<PlayerDto> players = new ArrayList<PlayerDto>();
		for(Element row : rows) {
			Elements tds = row.select("td");
			if(tds.size() == 16) {
				players.add(new PlayerDto(clean(tds.get(0)),
						getNumber(tds.get(1)),
						getNumber(tds.get(2)),
						getNumber(tds.get(3)),
						getNumber(tds.get(4)),
						getNumber(tds.get(5)),
						getNumber(tds.get(6)),
						getNumber(tds.get(7)),
						getNumber(tds.get(8)),
						getNumber(tds.get(9)),
						getNumber(tds.get(10)),
						getNumber(tds.get(11)),
						getNumber(tds.get(12)),
						getNumber(tds.get(13)),
						getNumber(tds.get(14)),
						getNumber(tds.get(15))));
			}
		}

		Collections.sort(players);
		return players;
	}
	
	private static String clean(Element td) {
		return td.text().replace("\"A\"", "").replace("\"C\"", "").replaceAll("\\( [0-9]\\)", "").replace("\"", "").trim();
	}
	
	private static Integer getNumber(Element td) {
		try {
			return Integer.parseInt(td.text().replaceAll("[^\\d\\-]", ""));
		}
		catch (NumberFormatException e) {
			System.out.println(e);
			return null;
		}
	}
}
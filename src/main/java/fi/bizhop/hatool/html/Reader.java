package fi.bizhop.hatool.html;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import fi.bizhop.hatool.entity.Player;

public class Reader {
	
	private static final String playersUrl = "http://www.hockeyarena.net/fi/index.php?p=manager_team_players.php";

	public static List<Player> readPlayers(String pastedCookie) throws Exception {
		String[] cookiesArray = pastedCookie.split(";");
		Map<String, String> cookies = new HashMap<String, String>();
		for(String cookie : cookiesArray) {
			String[] split = cookie.split("=");
			if(split.length == 2) {
				String key = split[0].trim();
				String value = split[1].trim();
				cookies.put(key, value);
			}
		}
		
		
		Document doc = Jsoup.connect(playersUrl)
				.cookies(cookies)
				.get();
		
		Element table = doc.getElementById("table-2");
		Elements rows = table.select("tbody").select("tr");
		
		List<Player> players = new ArrayList<Player>();
		for(Element row : rows) {
			Elements tds = row.select("td");
			if(tds.size() == 16) {
				players.add(new Player(clean(tds.get(0)),
						getNumbers(tds.get(1)),
						getNumbers(tds.get(2)),
						getNumbers(tds.get(3)),
						getNumbers(tds.get(4)),
						getNumbers(tds.get(5)),
						getNumbers(tds.get(6)),
						getNumbers(tds.get(7)),
						getNumbers(tds.get(8)),
						getNumbers(tds.get(9)),
						getNumbers(tds.get(10)),
						getNumbers(tds.get(11)),
						getNumbers(tds.get(12)),
						getNumbers(tds.get(13)),
						getNumbers(tds.get(14)),
						getNumbers(tds.get(15))));
			}
		}

		Collections.sort(players);
		return players;
	}
	
	private static String clean(Element td) {
		return td.text().replace("\"A\"", "").replace("\"C\"", "").replaceAll("\\( [0-9]\\)", "").replace("\"", "").trim();
	}
	
	private static String getNumbers(Element td) {
		try {
			Integer number = Integer.parseInt(td.text().replaceAll("[^\\d\\-]", ""));
			return number.toString();
		}
		catch (NumberFormatException e) {
			System.out.println(e);
			return "";
		}
	}
}
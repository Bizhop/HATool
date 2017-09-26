package fi.bizhop.hatool;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.bizhop.hatool.entity.Player;
import fi.bizhop.hatool.html.Reader;

@RestController
public class MainController {
	
	private static final String pastedCookie = "lsum=3420000; ltype=2; __utmz=229377541.1504164268.1.1.utmccn=(direct)|utmcsr=(direct)|utmcmd=(none); halang=en; PHPSESSID=mqofju86tj8h9delqlptt16v93; __utma=229377541.159156878.1504164268.1506412727.1506429446.23; __utmc=229377541; __utmb=229377541";

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/players", method = RequestMethod.GET, produces = "application/json")
    public List<Player> getPlayers(
    		) throws Exception {
    	return Reader.readPlayers(pastedCookie);
    }
}

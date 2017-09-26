package fi.bizhop.hatool;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.bizhop.hatool.entity.Player;
import fi.bizhop.hatool.html.Reader;

@RestController
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/players", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public List<Player> getPlayers(@RequestBody Map<String,String> cookies) throws Exception {
    	return Reader.readPlayers(cookies);
    }
}

package fi.bizhop.hatool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.bizhop.hatool.dto.PlayerDto;
import fi.bizhop.hatool.entity.Player;
import fi.bizhop.hatool.html.Reader;
import fi.bizhop.hatool.service.PlayerService;

@RestController
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	PlayerService playerService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping(value = "/players", method = RequestMethod.GET, produces = "application/json")
    public List<Player> getPlayers() {
    	return playerService.getActivePlayers();
    }

    @RequestMapping(value = "/players", method = RequestMethod.PUT, consumes = "application/json")
    public void getPlayers(@RequestBody List<String> input, HttpServletResponse response) throws Exception {
    	Map<String, String> cookies = new HashMap<String, String>();
    	for(String s : input) {
    		String key = s.substring(0, s.indexOf('='));
    		String value = s.substring(s.indexOf('=') + 1);
    		cookies.put(key, value);
    	}
    	List<PlayerDto> players = Reader.readPlayers(cookies);
    	if(playerService.savePlayers(players)) {
    		response.setStatus(HttpServletResponse.SC_OK);
    	}
    	else {
    		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    	}
    }
}

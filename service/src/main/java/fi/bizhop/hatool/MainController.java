package fi.bizhop.hatool;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.bizhop.hatool.dto.PlayerDto;
import fi.bizhop.hatool.html.Reader;
import fi.bizhop.hatool.service.PlayerService;

@RestController
public class MainController {
	
	@Autowired
	PlayerService playerService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/players", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public void getPlayers(@RequestBody Map<String,String> cookies, HttpServletResponse response) throws Exception {
    	List<PlayerDto> players = Reader.readPlayers(cookies);
    	if(playerService.savePlayers(players)) {
    		response.setStatus(HttpServletResponse.SC_OK);
    	}
    	else {
    		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    	}
    }
}

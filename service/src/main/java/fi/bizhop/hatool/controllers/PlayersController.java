package fi.bizhop.hatool.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.bizhop.hatool.dto.PlayerDto;
import fi.bizhop.hatool.dto.UpdatePlayerDto;
import fi.bizhop.hatool.entity.Person;
import fi.bizhop.hatool.html.Reader;
import fi.bizhop.hatool.projection.PlayerDetailsProjection;
import fi.bizhop.hatool.projection.PlayerListingProjection;
import fi.bizhop.hatool.service.AuthService;
import fi.bizhop.hatool.service.PlayerService;

@RestController
public class PlayersController extends BaseController {

	@Autowired
	PlayerService playerService;

	@Autowired
	AuthService authService;

	@RequestMapping(value = "/players", method = RequestMethod.GET, produces = "application/json")
	public Page<PlayerListingProjection> getPlayers(Pageable pageable, HttpServletRequest request, HttpServletResponse response) {
		Person owner = authService.getUser(request);
		if(owner == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		else {
			response.setStatus(HttpServletResponse.SC_OK);
			return playerService.getActivePlayers(owner, pageable);
		}
	}

	@RequestMapping(value = "/players/{id}", method = RequestMethod.GET, produces = "application/json")
	public PlayerDetailsProjection getPlayer(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) {
		Person owner = authService.getUser(request);
		if(owner == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		else {
			response.setStatus(HttpServletResponse.SC_OK);
			return playerService.getPlayer(owner, id);
		}
	}

	@RequestMapping(value = "/players/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public PlayerDetailsProjection updatePlayer(@PathVariable Integer id, @RequestBody UpdatePlayerDto dto, HttpServletRequest request, HttpServletResponse response) {
		Person owner = authService.getUser(request);
		if(owner == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		else {
			response.setStatus(HttpServletResponse.SC_OK);
			return playerService.updatePlayer(owner, id, dto);
		}
	}

	@RequestMapping(value = "/players/import", method = RequestMethod.PUT, consumes = "application/json")
	public void importPlayers(@RequestBody List<String> input, HttpServletResponse response, HttpServletRequest request) throws Exception {
		Person owner = authService.getUser(request);
		if(owner == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		else {
			Map<String, String> cookies = new HashMap<String, String>();
			for(String s : input) {
				String key = s.substring(0, s.indexOf('='));
				String value = s.substring(s.indexOf('=') + 1);
				cookies.put(key, value);
			}
			List<PlayerDto> players = Reader.readPlayers(cookies);
			if(playerService.savePlayers(owner, players)) {
				response.setStatus(HttpServletResponse.SC_OK);
			}
			else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		}
	}
}

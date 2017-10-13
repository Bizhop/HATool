package fi.bizhop.hatool.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.bizhop.hatool.dto.LinesDto;
import fi.bizhop.hatool.entity.Person;
import fi.bizhop.hatool.service.AuthService;
import fi.bizhop.hatool.service.TeamService;

@RestController
public class TeamController extends BaseController {
	@Autowired
	TeamService teamService;
	
	@Autowired
	AuthService authService;
	
	@RequestMapping(value = "/team/best-lines", method = RequestMethod.GET, produces = "application/json")
	public LinesDto getBestLines(HttpServletRequest request) throws Exception {
		Person owner = authService.getUser(request);
		return teamService.getBestLines(owner);
	}
	
	@RequestMapping(value = "/team/update-values", method = RequestMethod.GET)
	public void updateValues(HttpServletResponse response) throws Exception {
		if(teamService.updateValues()) {
			response.setStatus(HttpServletResponse.SC_OK);
    	}
    	else {
    		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    	}
	}
}

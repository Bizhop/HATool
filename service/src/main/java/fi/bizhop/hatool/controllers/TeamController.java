package fi.bizhop.hatool.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.bizhop.hatool.dto.LinesDto;
import fi.bizhop.hatool.service.TeamService;

@RestController
public class TeamController extends BaseController {
	@Autowired
	TeamService teamService;
	
	@RequestMapping(value = "/team/best-lines", method = RequestMethod.GET, produces = "application/json")
	public LinesDto getBestLines() {
		return teamService.getBestLines();
	}
	
	@RequestMapping(value = "/team/update-values", method = RequestMethod.GET)
	public void updateValues(HttpServletResponse response) {
		if(teamService.updateValues()) {
			response.setStatus(HttpServletResponse.SC_OK);
    	}
    	else {
    		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    	}
	}
}

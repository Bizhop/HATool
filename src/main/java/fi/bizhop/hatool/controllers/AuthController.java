package fi.bizhop.hatool.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.bizhop.hatool.dto.UserDto;
import fi.bizhop.hatool.entity.Person;
import fi.bizhop.hatool.service.AuthService;

@RestController
public class AuthController extends BaseController {

	@Autowired
	AuthService authService;
	
	@RequestMapping(value = "/auth/me", method = RequestMethod.GET, produces="application/json")
	public UserDto getUserInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Person user = authService.getUser(request);
		if(user == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		else {
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			return new UserDto(user.getEmail());
		}
	}
	
	@RequestMapping(value = "/auth/login", method = RequestMethod.GET)
	public UserDto login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Person user = authService.login(request);
		if(user == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		else {
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			return new UserDto(user.getEmail());
		}
	}
}

package fi.bizhop.hatool.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.bizhop.hatool.dao.PersonRepository;
import fi.bizhop.hatool.entity.Person;
import fi.bizhop.hatool.security.TokenAuthentication;

@Service
public class AuthService {
	@Autowired
	PersonRepository personRepo;
	
	public Person getUser(HttpServletRequest request) {
		try {
			String userEmail = TokenAuthentication.getUserEmail(request);
			return personRepo.findByEmail(userEmail);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public Person login(HttpServletRequest request) throws Exception {
		String userEmail = TokenAuthentication.getUserEmail(request);
		if(userEmail == null) {
			return null;
		}
		else {
			Person user = personRepo.findByEmail(userEmail);
			if(user == null) {
				user = new Person(userEmail);
				personRepo.save(user);
			}
			return user;
		}
	}
}

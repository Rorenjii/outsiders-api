package org.outsiders.release.controller;

import java.util.Collections;
import java.util.UUID;

import org.outsiders.release.domain.Ability;
import org.outsiders.release.domain.Race;
import org.outsiders.release.domain.Ability;
import org.outsiders.release.domain.request.AbilityRequest;
import org.outsiders.release.domain.response.AbilityResponse;
import org.outsiders.release.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ability")
public class AbilityController {

	@Autowired
	private AbilityService service;
	
	@GetMapping("/{id}")
	public AbilityResponse getById(@PathVariable("id") String id) {
		AbilityResponse resp = new AbilityResponse();
		try {
			resp.setAbilities(Collections.singletonList(service.findById(id).get()));
			resp.setErrorCode(null);
			resp.setSuccess(true);
			return resp;
		} catch (Exception e) {
			resp.setErrorCode(e.getMessage());
			resp.setSuccess(false);
			return resp;
		}
	}
	
	@GetMapping("/name/{name}")
	public AbilityResponse getByName(@PathVariable("name") String name) {
		AbilityResponse resp = new AbilityResponse();
		try {
			resp.setAbilities(Collections.singletonList(service.findByName(name)));
			resp.setErrorCode(null);
			resp.setSuccess(true);
			return resp;
		} catch (Exception e) {
			resp.setErrorCode(e.getMessage());
			resp.setSuccess(false);
			return resp;
		}
	}
	
	@GetMapping("/")
	public AbilityResponse getAllAbilitys() {
		AbilityResponse resp = new AbilityResponse();
		try {
			resp.setAbilities(service.findAll());
			resp.setErrorCode(null);
			resp.setSuccess(true);
			return resp;
		} catch (Exception e) {
			resp.setErrorCode(e.getMessage());
			resp.setSuccess(false);
			return resp;
		}
	}
	
	@PostMapping("/")
	public AbilityResponse createAbility(@RequestBody AbilityRequest request) {
		AbilityResponse resp = new AbilityResponse();
		try {
			Ability ability = request.getAbility();
			String id = UUID.randomUUID().toString();
			ability.setId(id);
			Ability saved = service.insert(ability);
			resp.setAbilities(Collections.singletonList(saved));
			resp.setErrorCode(null);
			resp.setSuccess(true);
			return resp;
		} catch (Exception e) {
			resp.setErrorCode(e.getMessage());
			resp.setSuccess(false);
			return resp;
		}
	}
	
	@PutMapping("/")
	public AbilityResponse updateAbility(@RequestBody AbilityRequest request) {
		AbilityResponse response = new AbilityResponse();
    	try {
	    	Ability a = service.findById(request.getAbility().getId()).get();
	    	a.updateAbility(request.getAbility());
	    	Ability r = service.insert(a);
	    	response.setAbilities(Collections.singletonList(r));
	    	response.setErrorCode(null);
	    	response.setSuccess(true);
	        return response;
    	} catch (Exception e) {
    		response.setAbilities(null);
    		response.setErrorCode(e.getMessage());
    		response.setSuccess(false);
    		return response;
    	}
	}
	
	@DeleteMapping("/{id}")
	public AbilityResponse deleteAbility(@PathVariable("id") String id) {
		AbilityResponse resp = new AbilityResponse();
		try {
			service.deleteById(id);
			resp.setSuccess(true);
			resp.setErrorCode(null);
			resp.setAbilities(null);
			return resp;
		} catch (Exception e) {
			resp.setSuccess(false);
			resp.setErrorCode(e.getMessage());
			resp.setAbilities(null);
			return resp;
		}
	}
}

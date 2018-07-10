package org.outsiders.release.controller;

import java.util.Collections;
import java.util.UUID;

import org.outsiders.release.domain.Race;
import org.outsiders.release.domain.constant.RaceType;
import org.outsiders.release.domain.Race;
import org.outsiders.release.domain.request.RaceRequest;
import org.outsiders.release.domain.response.RaceResponse;
import org.outsiders.release.domain.response.RaceResponse;
import org.outsiders.release.service.RaceService;
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
@RequestMapping("/api/race")
public class RaceController {

	@Autowired
	private RaceService service;
	
	@GetMapping("/{id}")
	public RaceResponse getById(@PathVariable("id") String id) {
		RaceResponse resp = new RaceResponse();
		try {
			resp.setRaces(Collections.singletonList(service.findById(id).get()));
			resp.setErrorCode(null);
			resp.setSuccess(true);
			return resp;
		} catch (Exception e) {
			resp.setErrorCode(e.getMessage());
			resp.setSuccess(false);
			return resp;
		}
	}
	
	@GetMapping("/type/{type}")
	public RaceResponse getByType(@PathVariable("type") RaceType type) {
		RaceResponse resp = new RaceResponse();
		try {
			resp.setRaces(Collections.singletonList(service.findByType(type)));
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
	public RaceResponse getAllRaces() {
		RaceResponse resp = new RaceResponse();
		try {
			resp.setRaces(service.findAll());
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
	public RaceResponse createRace(@RequestBody RaceRequest request) {
		RaceResponse resp = new RaceResponse();
		try {
			Race race = request.getRace();
			String id = UUID.randomUUID().toString();
			race.setId(id);
			Race saved = service.insert(race);
			resp.setRaces(Collections.singletonList(saved));
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
	public RaceResponse updateRace(@RequestBody RaceRequest request) {
		RaceResponse response = new RaceResponse();
    	try {
	    	Race a = service.findById(request.getRace().getId()).get();
	    	a.updateRace(request.getRace());
	    	Race r = service.insert(a);
	    	response.setRaces(Collections.singletonList(r));
	    	response.setErrorCode(null);
	    	response.setSuccess(true);
	        return response;
    	} catch (Exception e) {
    		response.setRaces(null);
    		response.setErrorCode(e.getMessage());
    		response.setSuccess(false);
    		return response;
    	}
	}
	
	@DeleteMapping("/{id}")
	public RaceResponse deleteRace(@PathVariable("id") String id) {
		RaceResponse resp = new RaceResponse();
		try {
			service.deleteById(id);
			resp.setSuccess(true);
			resp.setErrorCode(null);
			resp.setRaces(null);
			return resp;
		} catch (Exception e) {
			resp.setSuccess(false);
			resp.setErrorCode(e.getMessage());
			resp.setRaces(null);
			return resp;
		}
	}
}

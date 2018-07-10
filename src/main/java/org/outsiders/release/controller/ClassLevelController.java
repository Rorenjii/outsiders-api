package org.outsiders.release.controller;

import java.util.Collections;
import java.util.UUID;

import org.outsiders.release.domain.ClassLevel;
import org.outsiders.release.domain.Race;
import org.outsiders.release.domain.ClassLevel;
import org.outsiders.release.domain.constant.ClassType;
import org.outsiders.release.domain.request.ClassLevelRequest;
import org.outsiders.release.domain.response.ClassLevelResponse;
import org.outsiders.release.domain.response.ClassLevelResponse;
import org.outsiders.release.service.ClassLevelService;
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
@RequestMapping("/api/classlevel")
public class ClassLevelController {

	@Autowired
	private ClassLevelService service;
	
	@GetMapping("/{id}")
	public ClassLevelResponse getById(@PathVariable("id") String id) {
		ClassLevelResponse resp = new ClassLevelResponse();
		try {
			resp.setClassLevels(Collections.singletonList(service.findById(id).get()));
			resp.setErrorCode(null);
			resp.setSuccess(true);
			return resp;
		} catch (Exception e) {
			resp.setErrorCode(e.getMessage());
			resp.setSuccess(false);
			return resp;
		}
	}
	
	@GetMapping("/{classType}/level/{level}")
	public ClassLevelResponse getById(@PathVariable("classType") ClassType classType, @PathVariable("level") int level) {
		ClassLevelResponse resp = new ClassLevelResponse();
		try {
			resp.setClassLevels(Collections.singletonList(service.findByClassTypeAndLevel(classType, level)));
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
	public ClassLevelResponse getAllClassLevels() {
		ClassLevelResponse resp = new ClassLevelResponse();
		try {
			resp.setClassLevels(service.findAll());
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
	public ClassLevelResponse createClassLevel(@RequestBody ClassLevelRequest request) {
		ClassLevelResponse resp = new ClassLevelResponse();
		try {
			ClassLevel classLevel = request.getClassLevel();
			String id = UUID.randomUUID().toString();
			classLevel.setId(id);
			ClassLevel saved = service.insert(classLevel);
			resp.setClassLevels(Collections.singletonList(saved));
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
	public ClassLevelResponse updateClassLevel(@RequestBody ClassLevelRequest request) {
		ClassLevelResponse response = new ClassLevelResponse();
    	try {
	    	ClassLevel a = service.findById(request.getClassLevel().getId()).get();
	    	a.updateClassLevel(request.getClassLevel());
	    	ClassLevel r = service.insert(a);
	    	response.setClassLevels(Collections.singletonList(r));
	    	response.setErrorCode(null);
	    	response.setSuccess(true);
	        return response;
    	} catch (Exception e) {
    		response.setClassLevels(null);
    		response.setErrorCode(e.getMessage());
    		response.setSuccess(false);
    		return response;
    	}
	}
	
	@DeleteMapping("/{id}")
	public ClassLevelResponse deleteClassLevel(@PathVariable("id") String id) {
		ClassLevelResponse resp = new ClassLevelResponse();
		try {
			service.deleteById(id);
			resp.setSuccess(true);
			resp.setErrorCode(null);
			resp.setClassLevels(null);
			return resp;
		} catch (Exception e) {
			resp.setSuccess(false);
			resp.setErrorCode(e.getMessage());
			resp.setClassLevels(null);
			return resp;
		}
	}
}

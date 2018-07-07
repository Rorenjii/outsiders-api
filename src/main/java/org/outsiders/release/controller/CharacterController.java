package org.outsiders.release.controller;

import java.util.Collections;
import java.util.UUID;

import org.outsiders.release.domain.Character;
import org.outsiders.release.domain.request.CharacterRequest;
import org.outsiders.release.domain.response.CharacterResponse;
import org.outsiders.release.service.CharacterService;
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
@RequestMapping("/api/character")
public class CharacterController {

	@Autowired
	private CharacterService service;
	
	@GetMapping("/{id}")
	public CharacterResponse getById(@PathVariable("id") String id) {
		CharacterResponse resp = new CharacterResponse();
		try {
			resp.setCharacters(Collections.singletonList(service.findById(id).get()));
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
	public CharacterResponse getAllCharacters() {
		CharacterResponse resp = new CharacterResponse();
		try {
			resp.setCharacters(service.findAll());
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
	public CharacterResponse createCharacter(@RequestBody CharacterRequest request) {
		CharacterResponse resp = new CharacterResponse();
		try {
			Character character = request.getCharacter();
			String id = UUID.randomUUID().toString();
			character.setId(id);
			Character savedChar = service.insert(character);
			resp.setCharacters(Collections.singletonList(savedChar));
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
	public CharacterResponse updateCharacter(@RequestBody CharacterRequest request) {
			//going to need some chunky custom logic..... enjoy.
		return new CharacterResponse();
	}
	
	@DeleteMapping("/{id}")
	public CharacterResponse deleteCharacter(@PathVariable("id") String id) {
		CharacterResponse resp = new CharacterResponse();
		try {
			service.deleteById(id);
			resp.setSuccess(true);
			resp.setErrorCode(null);
			resp.setCharacters(null);
			return resp;
		} catch (Exception e) {
			resp.setSuccess(false);
			resp.setErrorCode(e.getMessage());
			resp.setCharacters(null);
			return resp;
		}
	}
}

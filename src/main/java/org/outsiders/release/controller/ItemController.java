package org.outsiders.release.controller;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.outsiders.release.domain.Item;
import org.outsiders.release.domain.Race;
import org.outsiders.release.domain.Item;
import org.outsiders.release.domain.request.ItemRequest;
import org.outsiders.release.domain.response.ItemResponse;
import org.outsiders.release.domain.response.ItemResponse;
import org.outsiders.release.service.ItemService;
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
@RequestMapping("/api/item")
public class ItemController {

	@Autowired
	private ItemService service;
	
	@GetMapping("/{id}")
	public ItemResponse getById(@PathVariable("id") String id) {
		ItemResponse resp = new ItemResponse();
		try {
			resp.setItems(Collections.singletonList(service.findById(id).get()));
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
	public ItemResponse getByName(@PathVariable("name") String name) {
		ItemResponse resp = new ItemResponse();
		try {
			resp.setItems(Collections.singletonList(service.findByName(name)));
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
	public ItemResponse getAllItems() {
		ItemResponse resp = new ItemResponse();
		try {
			List<Item> list = service.findAll();
			resp.setItems(list);
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
	public ItemResponse createItem(@RequestBody ItemRequest request) {
		ItemResponse resp = new ItemResponse();
		try {
			Item item = request.getItem();
			String id = UUID.randomUUID().toString();
			item.setId(id);
			Item saved = service.insert(item);
			resp.setItems(Collections.singletonList(saved));
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
	public ItemResponse updateItem(@RequestBody ItemRequest request) {
		ItemResponse response = new ItemResponse();
    	try {
	    	Item a = service.findById(request.getItem().getId()).get();
	    	a.updateItem(request.getItem());
	    	Item r = service.insert(a);
	    	response.setItems(Collections.singletonList(r));
	    	response.setErrorCode(null);
	    	response.setSuccess(true);
	        return response;
    	} catch (Exception e) {
    		response.setItems(null);
    		response.setErrorCode(e.getMessage());
    		response.setSuccess(false);
    		return response;
    	}
	}
	
	@DeleteMapping("/{id}")
	public ItemResponse deleteItem(@PathVariable("id") String id) {
		ItemResponse resp = new ItemResponse();
		try {
			service.deleteById(id);
			resp.setSuccess(true);
			resp.setErrorCode(null);
			resp.setItems(null);
			return resp;
		} catch (Exception e) {
			resp.setSuccess(false);
			resp.setErrorCode(e.getMessage());
			resp.setItems(null);
			return resp;
		}
	}
}

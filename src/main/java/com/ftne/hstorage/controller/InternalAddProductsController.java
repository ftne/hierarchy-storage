package com.ftne.hstorage.controller;

import com.ftne.hstorage.entity.Node;
import com.ftne.hstorage.service.AddProductsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/additional-products")
@AllArgsConstructor
public class InternalAddProductsController {

	private final AddProductsService service;

	@GetMapping(path = "/tree/{id}")
	ResponseEntity<List<Node>> getTree(
			@PathVariable Integer id,
			@RequestParam(required = false, defaultValue = "0") Integer startLvl
	) {
		return ResponseEntity.ok(service.getAddProductsByTreeId(id, startLvl));
	}

	// TODO: get specific lvl
}

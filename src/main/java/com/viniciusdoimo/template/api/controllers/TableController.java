package com.viniciusdoimo.template.api.controllers;

import com.viniciusdoimo.template.api.DTO.RequestSaveTableDTO;
import com.viniciusdoimo.template.api.DTO.ResquestDeleteTableDTO;
import com.viniciusdoimo.template.api.DTO.ResquestUpdateDTO;
import com.viniciusdoimo.template.api.model.ModelTabela;
import com.viniciusdoimo.template.api.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@RestController
@RequestMapping("/table")
@CrossOrigin(origins = "*")
public class TableController {
	@Autowired
	private TableService service;
	
	@GetMapping
	public ResponseEntity<List<ModelTabela>> findAll() {
		List<ModelTabela> listModelTabela = service.findTable();
		return ResponseEntity.ok().body(listModelTabela);
	}

	@PostMapping
	public ResponseEntity<ModelTabela> save(@RequestBody RequestSaveTableDTO resquest){
		ModelTabela modelTabela = service.save(resquest);
		return ResponseEntity.ok().body(modelTabela);
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody ResquestUpdateDTO request){
		String response = service.update(request);
		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping()
	public ResponseEntity<String> delete(@RequestBody ResquestDeleteTableDTO request){
		service.delete(request);
		return ResponseEntity.ok().body("Successful deletion");
	}
}

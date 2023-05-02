package com.deipayandash.kentaurus.DistributedDatabaseMaster.controller;

import com.deipayandash.kentaurus.DistributedDatabaseMaster.model.NodeModel;
import com.deipayandash.kentaurus.DistributedDatabaseMaster.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/data")
public class MasterController {

	@Autowired
	MasterService masterService;
	@GetMapping("/nodes")
	public ResponseEntity<NodeModel> getAllNodes() throws ExecutionException, InterruptedException {
		NodeModel nodeModel= masterService.getAllWords();
		return new ResponseEntity<>(nodeModel, HttpStatus.OK);
	}

	@GetMapping("/words")
	public ResponseEntity<List<String>> getWords(){

		return new ResponseEntity<>(masterService.getNodes(), HttpStatus.OK);
	}

	@DeleteMapping("/words")
	public ResponseEntity<String> deleteWords(){
		return new ResponseEntity<>("All words deleted", HttpStatus.OK);
	}

	@DeleteMapping("/words/{word}")
	public ResponseEntity<String> deleteWord(@PathVariable String word){
		return new ResponseEntity<>("Word was deleted", HttpStatus.OK);
	}

	@PatchMapping("/node/{nodeId}")
	public ResponseEntity<String> nodeAction(@PathVariable String nodeId, @RequestParam String action){
		return new ResponseEntity<>("Node action was successful", HttpStatus.OK);
	}

	@PostMapping("/words")
	public ResponseEntity<String> addAllWords(@RequestBody List<String> newWords){
		return new ResponseEntity<>("Words were added", HttpStatus.OK);
	}
}

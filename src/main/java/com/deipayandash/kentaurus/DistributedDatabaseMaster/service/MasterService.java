package com.deipayandash.kentaurus.DistributedDatabaseMaster.service;

import com.deipayandash.kentaurus.DistributedDatabaseMaster.model.NodeModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class MasterService {

	private RestTemplate restTemplate;
	private Map<String, List<String>> wordsNodeMap = new HashMap<>();

	public MasterService(RestTemplateBuilder restTemplateBuilder){
		restTemplate = restTemplateBuilder.build();
	}

	@Async
	public CompletableFuture<NodeModel> findUser(String node) {
		String url = String.format("http://%s:8081/", node);
		NodeModel result = restTemplate.getForObject(url, NodeModel.class);
		return CompletableFuture.completedFuture(result);
	}

	public NodeModel getAllWords() throws ExecutionException, InterruptedException {
		CompletableFuture<NodeModel> call1 = findUser("localhost");
		CompletableFuture.allOf(call1).join();
		return call1.get();
	}
}

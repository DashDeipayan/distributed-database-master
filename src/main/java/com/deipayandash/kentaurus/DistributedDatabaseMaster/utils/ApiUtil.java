package com.deipayandash.kentaurus.DistributedDatabaseMaster.utils;

import com.deipayandash.kentaurus.DistributedDatabaseMaster.model.NodeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class ApiUtil {

    private RestTemplate restTemplate;

    public ApiUtil(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<NodeModel> getNodeData(String node) {
        String url = String.format("http://%s:8080/node", node);
        try{
            ResponseEntity<NodeModel> response = restTemplate.getForEntity(url, NodeModel.class);
            HttpStatusCode statusCode = response.getStatusCode();
            NodeModel result = response.getBody();
            return CompletableFuture.completedFuture(result);
        }catch (HttpClientErrorException e){
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                NodeModel errorModel = e.getResponseBodyAs(NodeModel.class);
                return CompletableFuture.completedFuture(errorModel);
            } else if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                String errorMessage = "Node not found";
                NodeModel errorModel = new NodeModel("", errorMessage);
                return CompletableFuture.completedFuture(errorModel);
            } else {
                String errorMessage = "Unexpected error occurred";
                NodeModel errorModel = new NodeModel("", errorMessage);
                return CompletableFuture.completedFuture(errorModel);
            }
        }
    }


}

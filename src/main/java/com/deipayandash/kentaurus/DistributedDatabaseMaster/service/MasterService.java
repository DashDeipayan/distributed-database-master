package com.deipayandash.kentaurus.DistributedDatabaseMaster.service;

import com.deipayandash.kentaurus.DistributedDatabaseMaster.model.MasterModel;
import com.deipayandash.kentaurus.DistributedDatabaseMaster.model.NodeModel;
import com.deipayandash.kentaurus.DistributedDatabaseMaster.utils.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class MasterService {

	@Autowired
	private MasterModel masterModel;

	@Autowired
	private ApiUtil apiUtil;

	public List<String> getNodes(){
		return masterModel.getNodes();
	}

	public MasterService() {
	}

	public NodeModel getAllWords() throws ExecutionException, InterruptedException {
		CompletableFuture<NodeModel> call1 = apiUtil.getNodeData("localhost");
		CompletableFuture.allOf(call1).join();
		return call1.get();
	}
}

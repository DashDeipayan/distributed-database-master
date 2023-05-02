package com.deipayandash.kentaurus.DistributedDatabaseMaster.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class NodeModel {

	private String message;
	private String NodeId;

	public NodeModel(String nodeId,String message) {
		NodeId = nodeId;
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NodeModel() {
	}

	public String getNodeId() {
		return NodeId;
	}

	public void setNodeId(String nodeId) {
		NodeId = nodeId;
	}
}

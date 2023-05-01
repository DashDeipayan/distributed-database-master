package com.deipayandash.kentaurus.DistributedDatabaseMaster.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class NodeModel {

	private int NodeId;

	private String NodeAddress;

	private List<String> words;
	private boolean isActive;

	public boolean isActive() {
		return isActive;
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public NodeModel(int nodeId, String nodeAddress) {
		NodeId = nodeId;
		NodeAddress = nodeAddress;
	}

	public NodeModel() {
	}

	public int getNodeId() {
		return NodeId;
	}

	public void setNodeId(int nodeId) {
		NodeId = nodeId;
	}

	public String getNodeAddress() {
		return NodeAddress;
	}

	public void setNodeAddress(String nodeAddress) {
		NodeAddress = nodeAddress;
	}
}

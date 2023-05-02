package com.deipayandash.kentaurus.DistributedDatabaseMaster.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MasterModel {
    @Value("${nodes}")
    private List<String> nodes;

    public MasterModel() {
    }

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}

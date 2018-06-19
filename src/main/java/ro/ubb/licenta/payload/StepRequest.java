package ro.ubb.licenta.payload;

import java.util.List;

public class StepRequest {
    private Long id;

    private List<NodeRequest> nodes;
    private List<ArrayRequest> arrays;

    public List<NodeRequest> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeRequest> nodes) {
        this.nodes = nodes;
    }

    public List<ArrayRequest> getArrays() {
        return arrays;
    }

    public void setArrays(List<ArrayRequest> arrays) {
        this.arrays = arrays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StepRequest{" +
                "id=" + id +
                ", nodes=" + nodes +
                '}';
    }
}

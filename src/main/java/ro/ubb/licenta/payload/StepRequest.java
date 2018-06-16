package ro.ubb.licenta.payload;

import java.util.List;

public class StepRequest {
    private List<NodeRequest> nodes;

    public List<NodeRequest> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeRequest> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        String ret =  "StepRequest{" +
                "nodes = [";
        for(NodeRequest el: nodes){
            ret = ret.concat(el.toString());
        }
        ret = ret.concat("]}");
        return ret;
    }
}

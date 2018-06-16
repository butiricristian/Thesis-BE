package ro.ubb.licenta.payload;

import java.util.List;

public class NodeRequest {
    private Integer internalId;
    private Integer positionX;
    private Integer positionY;
    private Integer size;
    private String color;
    private String value;

    private List<EdgeRequest> edges;

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer internalId) {
        this.internalId = internalId;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<EdgeRequest> getEdges() {
        return edges;
    }

    public void setEdges(List<EdgeRequest> edges) {
        this.edges = edges;
    }
}

package ro.ubb.licenta.model;

import javax.persistence.*;

@Entity
public class Edge {
    @Id
    @GeneratedValue
    private Long id;

    private Integer internalId;
    private Integer leftPosition;
    private Integer topPosition;
    private Float rotation;
    private Integer sizeOfEdge;
    private String color;
    private String value;
    private Integer indexOfNode;
    private Boolean isFirst;

    @ManyToOne
    private Node node;

    public Edge() {
    }

    public Edge(Integer internalId, Integer left, Integer top, Float rotation, Integer size, String color, String value, Integer indexOfNode, Boolean isFirst) {
        this.internalId = internalId;
        this.leftPosition = left;
        this.topPosition = top;
        this.rotation = rotation;
        this.sizeOfEdge = size;
        this.color = color;
        this.value = value;
        this.indexOfNode = indexOfNode;
        this.isFirst = isFirst;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer internalId) {
        this.internalId = internalId;
    }

    public Integer getLeftPosition() {
        return leftPosition;
    }

    public void setLeftPosition(Integer leftPosition) {
        this.leftPosition = leftPosition;
    }

    public Integer getTopPosition() {
        return topPosition;
    }

    public void setTopPosition(Integer topPosition) {
        this.topPosition = topPosition;
    }

    public Float getRotation() {
        return rotation;
    }

    public void setRotation(Float rotation) {
        this.rotation = rotation;
    }

    public Integer getSizeOfEdge() {
        return sizeOfEdge;
    }

    public void setSizeOfEdge(Integer sizeOfEdge) {
        this.sizeOfEdge = sizeOfEdge;
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

    public Integer getIndexOfNode() {
        return indexOfNode;
    }

    public void setIndexOfNode(Integer indexOfNode) {
        this.indexOfNode = indexOfNode;
    }

    public Boolean getFirst() {
        return isFirst;
    }

    public void setFirst(Boolean first) {
        isFirst = first;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}

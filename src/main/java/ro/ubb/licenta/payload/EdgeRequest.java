package ro.ubb.licenta.payload;

public class EdgeRequest {
    private Integer internalId;
    private Integer left;
    private Integer top;
    private Float rotation;
    private Integer size;
    private String color;
    private String value;
    private Integer indexOfNode;
    private String isFirst;

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer internalId) {
        this.internalId = internalId;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Float getRotation() {
        return rotation;
    }

    public void setRotation(Float rotation) {
        this.rotation = rotation;
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

    public Integer getIndexOfNode() {
        return indexOfNode;
    }

    public void setIndexOfNode(Integer indexOfNode) {
        this.indexOfNode = indexOfNode;
    }

    public String getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(String isFirst) {
        this.isFirst = isFirst;
    }
}

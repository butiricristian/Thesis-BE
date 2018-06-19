package ro.ubb.licenta.payload;

import java.util.List;

public class ArrayRequest {
    private Long id;

    private Integer positionX;
    private Integer positionY;
    private Integer size;
    private Integer internalId;
    private List<ArrayElementRequest> arrayElementRequests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer internalId) {
        this.internalId = internalId;
    }

    public List<ArrayElementRequest> getArrayElementRequests() {
        return arrayElementRequests;
    }

    public void setArrayElementRequests(List<ArrayElementRequest> arrayElementRequests) {
        this.arrayElementRequests = arrayElementRequests;
    }
}

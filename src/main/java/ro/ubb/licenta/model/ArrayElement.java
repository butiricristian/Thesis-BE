package ro.ubb.licenta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ArrayElement {
    @Id
    @GeneratedValue
    private Long id;

    private String color;
    private Integer positionX;
    private Integer positionY;
    private Integer internalId;
    private String value;

    @ManyToOne
    private ArrayComponent array;

    public ArrayElement(){}

    public ArrayElement(String color, Integer positionX, Integer positionY, Integer internalId, String value) {
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
        this.internalId = internalId;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer internalId) {
        this.internalId = internalId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayComponent getArray() {
        return array;
    }

    public void setArray(ArrayComponent array) {
        this.array = array;
    }
}

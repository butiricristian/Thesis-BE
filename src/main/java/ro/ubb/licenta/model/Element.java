package ro.ubb.licenta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Element {
    @Id
    @GeneratedValue
    private Long id;

    private ElementType elementType;
    private Integer positionX;
    private Integer positionY;
    private String color;
    private String value;

    @ManyToOne
    private Step step;

    public Element(ElementType elementType, Integer positionX, Integer positionY, String color, String value) {
        this.elementType = elementType;
        this.positionX = positionX;
        this.positionY = positionY;
        this.color = color;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
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
}

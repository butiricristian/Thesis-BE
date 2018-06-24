package ro.ubb.licenta.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ArrayComponent {
    @Id
    @GeneratedValue
    private Long id;

    private Integer positionX;
    private Integer positionY;
    private Integer size;
    private Integer internalId;

    @ManyToOne
    private Step step;

    @OneToMany(mappedBy = "array", cascade = CascadeType.ALL)
    private List<ArrayElement> arrayElements;

    public ArrayComponent(){}

    public ArrayComponent(Integer positionX, Integer positionY, Integer size, Integer internalId) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.size = size;
        this.internalId = internalId;
        this.arrayElements = new ArrayList<>();
    }

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

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public List<ArrayElement> getArrayElements() {
        return arrayElements;
    }

    public void setArrayElements(List<ArrayElement> arrayElements) {
        this.arrayElements = arrayElements;
    }
}

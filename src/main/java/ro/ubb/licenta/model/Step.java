package ro.ubb.licenta.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Step {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL, targetEntity = Node.class)
    private List<Node> nodes;

    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL, targetEntity = ArrayComponent.class)
    private List<ArrayComponent> arrays;

    @ManyToOne
    private Problem problem;

    public Step() {
        this.nodes = new ArrayList<>();
        this.arrays = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<ArrayComponent> getArrays() {
        return arrays;
    }

    public void setArrays(List<ArrayComponent> arrays) {
        this.arrays = arrays;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}

package ro.ubb.licenta.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Step {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL)
    private List<Node> nodes;

    @ManyToOne
    private Problem problem;

    public Step() {
        this.nodes = new ArrayList<>();
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

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}

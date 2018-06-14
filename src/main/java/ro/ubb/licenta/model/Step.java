package ro.ubb.licenta.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Step {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "step")
    private List<Element> elements;

    @ManyToOne
    private Problem problem;
}

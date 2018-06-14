package ro.ubb.licenta.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Problem {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private String exampleInput;
    private String exampleOutput;
    @ManyToOne
    private User author;

    @OneToMany(mappedBy = "problem")
    private List<Step> steps;

    public Problem(String title, String description, String exampleInput, String exampleOutput, User author) {
        this.title = title;
        this.description = description;
        this.exampleInput = exampleInput;
        this.exampleOutput = exampleOutput;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExampleInput() {
        return exampleInput;
    }

    public void setExampleInput(String exampleInput) {
        this.exampleInput = exampleInput;
    }

    public String getExampleOutput() {
        return exampleOutput;
    }

    public void setExampleOutput(String exampleOutput) {
        this.exampleOutput = exampleOutput;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}

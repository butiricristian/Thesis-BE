package ro.ubb.licenta.payload;

import java.util.List;

public class ProblemRequest {
    private Long id;
    private String title;
    private String description;
    private String exampleInput;
    private String exampleOutput;
    private String authorEmail;

    private List<StepRequest> steps;

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

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public List<StepRequest> getSteps() {
        return steps;
    }

    public void setSteps(List<StepRequest> steps) {
        this.steps = steps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String ret = "ProblemRequest{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", exampleInput='" + exampleInput + '\'' +
                ", exampleOutput='" + exampleOutput + '\'' +
                ", authorEmail=" + authorEmail +
                ", steps = [";
        for(StepRequest s : steps){
            ret = ret.concat(s.toString());
        }
        ret = ret.concat("]}");
        return ret;
    }
}

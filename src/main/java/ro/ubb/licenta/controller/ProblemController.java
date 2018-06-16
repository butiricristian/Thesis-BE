package ro.ubb.licenta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.licenta.model.*;
import ro.ubb.licenta.payload.EdgeRequest;
import ro.ubb.licenta.payload.NodeRequest;
import ro.ubb.licenta.payload.ProblemRequest;
import ro.ubb.licenta.payload.StepRequest;
import ro.ubb.licenta.repository.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProblemController {

    private ProblemRepository problemRepository;
    private UserRepository userRepository;
    private EdgeRepository edgeRepository;
    private NodeRepository nodeRepository;
    private StepRepository stepRepository;

    public ProblemController(ProblemRepository problemRepository,
                             UserRepository userRepository,
                             EdgeRepository edgeRepository,
                             NodeRepository nodeRepository,
                             StepRepository stepRepository) {
        this.problemRepository = problemRepository;
        this.userRepository = userRepository;
        this.edgeRepository = edgeRepository;
        this.nodeRepository = nodeRepository;
        this.stepRepository = stepRepository;
    }

    @PostMapping("/uploadProblem")
    public ResponseEntity<?> addProblem(@RequestBody ProblemRequest problemRequest) {
        User author = userRepository.findByEmail(problemRequest.getAuthorEmail()).get();
        Problem newProblem = new Problem(
                problemRequest.getTitle(),
                problemRequest.getDescription(),
                problemRequest.getExampleInput(),
                problemRequest.getExampleOutput(),
                author
        );
        problemRepository.save(newProblem);
        for (StepRequest sr : problemRequest.getSteps()) {
            Step newStep = new Step();
            newStep.setProblem(newProblem);
            stepRepository.save(newStep);
            for (NodeRequest nr : sr.getNodes()) {
                Node newNode = new Node(
                        nr.getInternalId(),
                        nr.getPositionX(),
                        nr.getPositionY(),
                        nr.getSize(),
                        nr.getColor(),
                        nr.getValue());
                newNode.setStep(newStep);
                nodeRepository.save(newNode);
                for (EdgeRequest er : nr.getEdges()) {
                    Edge newEdge = new Edge(
                            er.getInternalId(),
                            er.getLeft(),
                            er.getTop(),
                            er.getRotation(),
                            er.getSize(),
                            er.getColor(),
                            er.getValue(),
                            er.getIndexOfNode(),
                            er.getIsFirst().equals("true"));
                    newEdge.setNode(newNode);
                    edgeRepository.save(newEdge);
                    newNode.getEdges().add(newEdge);
                }
                newStep.getNodes().add(newNode);
            }
            newProblem.getSteps().add(newStep);
        }
        return ResponseEntity.ok("Great job");
    }

    @GetMapping("/problems")
    public ResponseEntity<?> getProblems(){
        List<Problem> problems = problemRepository.findAll();
        List<ProblemRequest> problemRequests = new ArrayList<>();
        for(Problem p: problems){
            ProblemRequest pr = new ProblemRequest();
            pr.setId(p.getId());
            pr.setAuthorEmail(p.getAuthor().getEmail());
            pr.setDescription(p.getDescription());
            pr.setExampleInput(p.getExampleInput());
            pr.setExampleOutput(p.getExampleOutput());
            pr.setTitle(p.getTitle());
            pr.setSteps(new ArrayList<>());
            problemRequests.add(pr);
        }
        return ResponseEntity.ok(problemRequests);
    }

    @GetMapping("/problems/{id}")
    public ResponseEntity<?> getProblem(@PathVariable("id") Long id){
        Problem p = problemRepository.findById(id).get();
        ProblemRequest pr = new ProblemRequest();
        pr.setId(p.getId());
        pr.setAuthorEmail(p.getAuthor().getEmail());
        pr.setDescription(p.getDescription());
        pr.setExampleInput(p.getExampleInput());
        pr.setExampleOutput(p.getExampleOutput());
        pr.setTitle(p.getTitle());
        pr.setSteps(new ArrayList<>());
        for (Step s : p.getSteps()) {
            StepRequest sr = new StepRequest();
            sr.setNodes(new ArrayList<>());
            for (Node n : s.getNodes()) {
                NodeRequest nr = new NodeRequest();
                nr.setInternalId(n.getInternalId());
                nr.setColor(n.getColor());
                nr.setPositionX(n.getPositionX());
                nr.setPositionY(n.getPositionY());
                nr.setSize(n.getSize());
                nr.setValue(n.getValue());
                nr.setEdges(new ArrayList<>());
                for (Edge e : n.getEdges()) {
                    EdgeRequest er = new EdgeRequest();
                    er.setInternalId(e.getInternalId());
                    er.setColor(e.getColor());
                    er.setIndexOfNode(e.getIndexOfNode());
                    er.setIsFirst(e.getFirst().toString());
                    er.setLeft(e.getLeftPosition());
                    er.setRotation(e.getRotation());
                    er.setSize(e.getSizeOfEdge());
                    er.setTop(e.getTopPosition());
                    er.setValue(e.getValue());
                    nr.getEdges().add(er);
                }
                sr.getNodes().add(nr);
            }
            pr.getSteps().add(sr);
        }
        return ResponseEntity.ok(pr);
    }
}

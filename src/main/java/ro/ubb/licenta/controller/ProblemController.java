package ro.ubb.licenta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.licenta.model.*;
import ro.ubb.licenta.payload.*;
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
    private ArrayRepository arrayRepository;
    private ArrayElementRepository arrayElementRepository;

    public ProblemController(ProblemRepository problemRepository, UserRepository userRepository, EdgeRepository edgeRepository, NodeRepository nodeRepository, StepRepository stepRepository, ArrayRepository arrayRepository, ArrayElementRepository arrayElementRepository) {
        this.problemRepository = problemRepository;
        this.userRepository = userRepository;
        this.edgeRepository = edgeRepository;
        this.nodeRepository = nodeRepository;
        this.stepRepository = stepRepository;
        this.arrayRepository = arrayRepository;
        this.arrayElementRepository = arrayElementRepository;
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
        newProblem.setId(problemRequest.getId());
        problemRepository.save(newProblem);
        for (StepRequest sr : problemRequest.getSteps()) {
            Step newStep = new Step();
            newStep.setProblem(newProblem);
            newStep.setId(sr.getId());
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
                if (sr.getId() != null) {
                    newNode.setId(nr.getId());
                }
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
                    if (sr.getId() != null) {
                        newEdge.setId(er.getId());
                    }
                    edgeRepository.save(newEdge);
                    newNode.getEdges().add(newEdge);
                }
                newStep.getNodes().add(newNode);
            }
            for(ArrayRequest ar : sr.getArrays()){
                ArrayComponent newArrayComponent = new ArrayComponent(
                        ar.getPositionX(),
                        ar.getPositionY(),
                        ar.getSize(),
                        ar.getInternalId()
                );
                newArrayComponent.setStep(newStep);
                if (sr.getId() != null) {
                    newArrayComponent.setId(ar.getId());
                }
                arrayRepository.save(newArrayComponent);
                for(ArrayElementRequest aer: ar.getArrayElementRequests()){
                    ArrayElement newArrayElement = new ArrayElement(
                            aer.getColor(),
                            aer.getPositionX(),
                            aer.getPositionY(),
                            aer.getInternalId(),
                            aer.getValue()
                    );
                    newArrayElement.setArray(newArrayComponent);
                    if (sr.getId() != null) {
                        newArrayElement.setId(aer.getId());
                    }
                    arrayElementRepository.save(newArrayElement);
                    newArrayComponent.getArrayElements().add(newArrayElement);
                }
                newStep.getArrays().add(newArrayComponent);
            }
            newProblem.getSteps().add(newStep);
        }
        return ResponseEntity.ok("Great job");
    }

    @GetMapping("/problems")
    public ResponseEntity<?> getProblems() {
        List<Problem> problems = problemRepository.findAll();
        List<ProblemRequest> problemRequests = new ArrayList<>();
        for (Problem p : problems) {
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
    public ResponseEntity<?> getProblem(@PathVariable("id") Long id) {
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
            sr.setId(s.getId());
            sr.setNodes(new ArrayList<>());
            sr.setArrays(new ArrayList<>());
            for (Node n : s.getNodes()) {
                NodeRequest nr = new NodeRequest();
                nr.setId(n.getId());
                nr.setInternalId(n.getInternalId());
                nr.setColor(n.getColor());
                nr.setPositionX(n.getPositionX());
                nr.setPositionY(n.getPositionY());
                nr.setSize(n.getSize());
                nr.setValue(n.getValue());
                nr.setEdges(new ArrayList<>());
                for (Edge e : n.getEdges()) {
                    EdgeRequest er = new EdgeRequest();
                    er.setId(e.getId());
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
            for(ArrayComponent ac : s.getArrays()){
                ArrayRequest ar = new ArrayRequest();
                ar.setId(ac.getId());
                ar.setInternalId(ac.getInternalId());
                ar.setPositionX(ac.getPositionX());
                ar.setPositionY(ac.getPositionY());
                ar.setSize(ac.getSize());
                ar.setArrayElementRequests(new ArrayList<>());
                for(ArrayElement ae: ac.getArrayElements()){
                    ArrayElementRequest aer = new ArrayElementRequest();
                    aer.setId(ae.getId());
                    aer.setColor(ae.getColor());
                    aer.setInternalId(ae.getInternalId());
                    aer.setPositionX(ae.getPositionX());
                    aer.setPositionY(ae.getPositionY());
                    aer.setValue(ae.getValue());
                    ar.getArrayElementRequests().add(aer);
                }
                sr.getArrays().add(ar);
            }
            pr.getSteps().add(sr);
        }
        return ResponseEntity.ok(pr);
    }
}

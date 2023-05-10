package aiss.gitminer.controllers;

import aiss.gitminer.model.Project;
import aiss.gitminer.repositories.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectRepository repository;

    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    // GET http:///localhost:8080/api/projects
    @GetMapping
    public List<Project> findAll(){
        return repository.findAll();
    }

    // GET http://localhost:8080/api/projects/{id}
    @GetMapping("/{id}")
    public Project findOne(@PathVariable String id){
        return repository.findOne(id);
    }

    // POST http://localhost:8080/api/projects
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Project create(@Valid @RequestBody Project project) { return repository.create(project); }


}

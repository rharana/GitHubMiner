package aiss.gitminer.controllers;

import aiss.gitminer.model.Commit;
import aiss.gitminer.repositories.CommitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/commits")
public class CommitController {

    private CommitRepository repository;

    public CommitController(CommitRepository repository) {
        this.repository = repository;
    }

    // GET http:///localhost:8080/api/commits
    @GetMapping
    public List<Commit> findAll(){
        return repository.findAll();
    }

    // GET http:///localhost:8080/api/commit
    @GetMapping
    public Commit findCommit(@PathVariable String id){
        return repository.findOne(id);
    }

    // GET http://localhost:8080/api/commit/{id}
    @GetMapping("/{author_email}")
    public Commit findOne(@PathVariable String author_email){
        return repository.findOne(author_email);
    }

}

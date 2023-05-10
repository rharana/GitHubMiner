package aiss.gitminer.repositories;

import aiss.gitminer.model.Commit;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CommitRepository {

    List<Commit> commits = new ArrayList<>();

    public CommitRepository(){

    }

    public List<Commit> findAll(){
        return commits;
    }

    public Commit findCommit(String id){
        return commits.stream()
                .filter(commit -> commit.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Commit findOne(String author_email){
        return commits.stream()
                .filter(commit -> commit.getAuthorEmail().equals(author_email))
                .findFirst()
                .orElse(null);
    }

}

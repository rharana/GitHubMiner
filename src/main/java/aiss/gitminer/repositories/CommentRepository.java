package aiss.gitminer.repositories;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.Issue;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CommentRepository {

    List<Comment> comments = new ArrayList<>();

    public CommentRepository(){

    }

    public List<Comment> findAll(){ return comments; }

    public Comment findOne(String id){
        return comments.stream()
                .filter(comment -> comment.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


}

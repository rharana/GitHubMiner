package aiss.GitHubMiner.Test;

import aiss.GitHubMiner.models.Comment;
import aiss.GitHubMiner.repositories.CommentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommentRepositoryTest {

    private CommentRepository commentRepository;

    CommentRepositoryTest(){
        this.commentRepository =  new CommentRepository();
    }

    @Test
    @DisplayName("GitLab Fetch Comments")
    void fetchGitHub() {
        Comment[] comments = commentRepository.fetchGitHub("freeCodeCamp", "freeCodeCamp", 50167, "2");
        for(Comment c: comments){
            System.out.println(c);
        }
    }

    @Test
    @DisplayName("GitLab Big Fetch Comments")
    void bigFetchGitHub() {
        Comment[] comments = commentRepository.fetchGitHub("freeCodeCamp", "freeCodeCamp", 50167, "5");
        for(Comment c: comments){
            System.out.println(c);
        }
    }
}
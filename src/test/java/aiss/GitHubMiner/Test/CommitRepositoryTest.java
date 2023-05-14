package aiss.GitHubMiner.Test;

import aiss.GitHubMiner.models.Commit;
import aiss.GitHubMiner.repositories.CommitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommitRepositoryTest {

    private CommitRepository commitRepository;

    CommitRepositoryTest(){
        this.commitRepository =  new CommitRepository();
    }

    @Test
    @DisplayName("GitHub Fetch Commits")
    void fetchGitLab() {
        Commit[] commits = commitRepository.fetchGitHub("freeCodeCamp", "freeCodeCamp", "2", "2");
        for(Commit co: commits){
            System.out.println(co);
        }
    }

    @Test
    @DisplayName("GitHub Big Fetch Commits")
    void bigFetchGitLab() {
        Commit[] commits = commitRepository.fetchGitHub("freeCodeCamp", "freeCodeCamp", "30", "5");
        for(Commit co: commits){
            System.out.println(co);
        }
    }
}
package aiss.GitHubMiner.Test;

import aiss.GitHubMiner.models.Issue;
import aiss.GitHubMiner.repositories.IssueRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {

    private IssueRepository issueRepository;

    IssueRepositoryTest(){
        this.issueRepository =  new IssueRepository();
    }

    @Test
    @DisplayName("GitHub Fetch Issues")
    void fetchGitLab() {
        Issue[] issues = issueRepository.fetchGitHub("freeCodeCamp", "freeCodeCamp", "20", "2");
        for(Issue i: issues){
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("GitHub Big Fetch Issues")
    void bigFetchGitLab() {
        Issue[] issues = issueRepository.fetchGitHub("freeCodeCamp", "freeCodeCamp", "90", "6");
        for(Issue i: issues){
            System.out.println(i);
        }
    }
}
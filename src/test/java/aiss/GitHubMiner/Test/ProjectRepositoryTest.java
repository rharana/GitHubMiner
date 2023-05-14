package aiss.GitHubMiner.Test;

import aiss.GitHubMiner.models.Project;
import aiss.GitHubMiner.repositories.ProjectRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectRepositoryTest {

    private ProjectRepository projectRepository;
    ProjectRepositoryTest(){
        this.projectRepository =  new ProjectRepository();
    }
    @Test
    @DisplayName("GitHub Fetch Project")
    void fetchGitHub() {
        Project project = projectRepository.fetchGitHub("freeCodeCamp", "freeCodeCamp");
        System.out.println(project);
    }
}
package aiss.GitHubMiner.repositories;

import aiss.GitHubMiner.models.Project;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ProjectRepository {
    public final String API_TOKEN = "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";
    public final String API_URL = "https://api.github.com/repos/";
    public final String API_POST_URL = "http://localhost:8080/gitminer/projects";

    //Gets requested Project from GitHub API
    public Project fetchGitHub(String user, String repo) {
        //Sets up headers and authorization
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + API_TOKEN);

        //Setting the GET project GitHub API Call
        String url = API_URL + user + "/" + repo;
        HttpEntity<String> entity = new HttpEntity<String>(url,headers);

        //GET and saving into entity
        ResponseEntity<Project> project = restTemplate.exchange(url, HttpMethod.GET, entity, Project.class);

        //Getting response body
        return project.getBody();
    }

    //From controller, this function is called as soon as project object has been modified to
    //contain all issues, commits, comments and users implied.
    //POST the object to GitLab API on 8080 port
    public void postGitMiner(Project project) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_POST_URL;
        restTemplate.postForObject(url, project, Project.class);
    }
}

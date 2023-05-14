package aiss.GitHubMiner.repositories;

import aiss.GitHubMiner.models.Issue;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class IssueRepository {
    public final String API_TOKEN = "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";
    public final String API_URL = "https://api.github.com/repos/";

    public Issue[] fetchGitHub(String user, String repo, String sinceIssues, String maxPages) {
        //Calculating the date which will be passed to API as parameter using sinceIssues arg
        String date = LocalDate.now().minusDays(Long.parseLong(sinceIssues)).toString();

        //Sets up headers and authorization
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + API_TOKEN);

        //List initialization to save issues from all pages
        List<Issue> allPagesIssues = new ArrayList<>();

        //Loop that iterates through pages until maxPages is reach
        for(Integer i = 1; i <= Integer.parseInt(maxPages); i++) {
            //Setting the GET issues GitHub API Call for each page
            String url = API_URL + user + "/" + repo + "/issues?since=" + date + "&page=" + i.toString();
            HttpEntity<String> entity = new HttpEntity<String>(url, headers);

            //Normal single-page GET and saving into entity
            ResponseEntity<Issue[]> issues = restTemplate.exchange(url, HttpMethod.GET, entity, Issue[].class);

            //Getting body from entity and transforming to list
            List<Issue> pageIssues = Arrays.stream(issues.getBody()).toList();

            //Saving each page content into result List
            allPagesIssues.addAll(pageIssues);
        }
        //List to array conversion
        return allPagesIssues.toArray(new Issue[allPagesIssues.size()]);
    }

}

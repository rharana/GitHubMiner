package aiss.GitHubMiner.repositories;

import aiss.GitHubMiner.models.Commit;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CommitRepository {
    public final String API_TOKEN = "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";
    public final String API_URL = "https://api.github.com/repos/";

    //Gets all requested Commits from GitHub API
    public Commit[] fetchGitHub(String user, String repo, String sinceCommits, String maxPages) {
        //Calculating the date which will be passed to API as parameter using sinceCommits arg
        String date = LocalDate.now().minusDays(Long.parseLong(sinceCommits)).toString();

        //Sets up headers and authorization
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + API_TOKEN);

        //List initialization to save commits from all pages
        List<Commit> allPagesCommits = new ArrayList<>();

        //Loop that iterates through pages until maxPages is reach
        for(Integer i = 1; i <= Integer.parseInt(maxPages); i++)
        {
            //Setting the GET commits GitHub API Call for each page
            String url = API_URL + user + "/" + repo + "/commits?since=" + date + "&page=" + i.toString();

            //Normal single-page GET and saving into entity
            HttpEntity<String> entity = new HttpEntity<String>(url,headers);
            ResponseEntity<Commit[]> commits = restTemplate.exchange(url, HttpMethod.GET, entity, Commit[].class);

            //Getting body from entity and transforming to list
            List<Commit> pageCommits = Arrays.stream(commits.getBody()).toList();

            //Saving each page content into result List
            allPagesCommits.addAll(pageCommits);
        }
        //List to array conversion
        return allPagesCommits.toArray(new Commit[allPagesCommits.size()]);
    }

}

package aiss.GitHubMiner.controllers;

import aiss.GitHubMiner.models.Comment;
import aiss.GitHubMiner.models.Commit;
import aiss.GitHubMiner.models.Issue;
import aiss.GitHubMiner.models.Project;
import aiss.GitHubMiner.repositories.CommentRepository;
import aiss.GitHubMiner.repositories.CommitRepository;
import aiss.GitHubMiner.repositories.IssueRepository;
import aiss.GitHubMiner.repositories.ProjectRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("githubminer")
public class APIController {

    private final ProjectRepository projectRepository;
    private final IssueRepository issueRepository;
    private final CommentRepository commentRepository;
    private final CommitRepository commitRepository;

    public APIController(ProjectRepository projectRepository, IssueRepository issueRepository, CommentRepository commentRepository, CommitRepository commitRepository)
    {
        this.projectRepository = projectRepository;
        this.commentRepository = commentRepository;
        this.commitRepository = commitRepository;
        this.issueRepository = issueRepository;
    }


    //POST http://localhost:8082/githubminer/{user}/{repo}?sinceCommits=X&sinceIssues=Y&maxPages=Z
    @PostMapping("/{user}/{repo}")
    public Project fetchAllData(@PathVariable String user, @PathVariable String repo,
                                @RequestParam(defaultValue = "20") String sinceIssues,
                                @RequestParam(defaultValue = "2") String sinceCommits,
                                @RequestParam(defaultValue = "2") String maxPages)
    {
        //GET single project from GitLab API
        Project project = projectRepository.fetchGitHub(user,repo);

        //GET all requested commits from GitLab API, fetching until maxPage Z is reach and only those created
        // since X days prior to today
        Commit[] commits = commitRepository.fetchGitHub(user, repo, sinceCommits, maxPages);

        //GET all requested issues from GitLab API, fetching until maxPage Z is reach and only those updated
        // since Y days prior to today
        Issue[] issues = issueRepository.fetchGitHub(user, repo, sinceIssues, maxPages);

        //GET comments on each issue fetched right before, and setting them as a property of father issue
        for(Issue i: issues){
            Comment[] comments = commentRepository.fetchGitHub(user,repo , i.getRefId(), maxPages);
            i.setComments(comments);
        }

        //Sets up final project object, ready to be posted on API
        project.setCommits(commits);
        project.setIssues(issues);

        //Posts project to GitMiner API, hosted in 8080 port
        projectRepository.postGitMiner(project);

        //Object sent will be the content of HTTP response
        return project;
    }

}

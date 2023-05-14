package aiss.GitHubMiner.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommitUser {
    @JsonProperty("name")
    private String authorName;
    @JsonProperty("email")
    private String authorEmail;
    @JsonProperty("date")
    private String authoredDate;

    public String getName() {
        return authorName;
    }

    public String getEmail() {
        return authorEmail;
    }

    public String getDate() {
        return authoredDate;
    }

    @Override
    public String toString() {
        return "CommitUser{" +
                "authorName='" + authorName + '\'' +
                ", authorEmail='" + authorEmail + '\'' +
                ", authoredDate='" + authoredDate + '\'' +
                '}';
    }
}

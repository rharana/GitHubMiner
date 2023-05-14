package aiss.GitHubMiner.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Issue {

    @JsonProperty("id")
    private String id;
    @JsonProperty("number")
    private Integer refId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String description;
    @JsonProperty("state")
    private String state;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("closed_at")
    private String closedAt;

    //FIX
    @JsonProperty("labels")
    public void labelsRead(Label[] objectLabels)
    {
        List<String> labelsList = new ArrayList<>();
        for(Label l: objectLabels){
            labelsList.add(l.getName());
        }
        String[] array = labelsList.toArray(new String[labelsList.size()]);
        this.retLabels = array;
    }
    @JsonProperty("retLabels")
    String[] retLabels;
    @JsonProperty("user")
    private User author;

    @JsonProperty("assignee")
    private User assignee;

    @JsonProperty("upvotes")
    private Integer upvotes;
    @JsonProperty("downvotes")
    private Integer downvotes;
    @JsonProperty("reactions")
    public void downUpVotesRead(Reaction reaction)
    {
        this.upvotes = reaction.getUpvotes();
        this.downvotes = reaction.getDownvotes();
    }
    @JsonProperty("url")
    private String webUrl;
    @JsonProperty("commentsRet")
    private Comment[] comments;

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
    public Integer getRefId() {
        return refId;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", refId=" + refId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", closedAt='" + closedAt + '\'' +
                ", retLabels=" + Arrays.toString(retLabels) +
                ", author=" + author +
                ", assignee=" + assignee +
                ", upvotes=" + upvotes +
                ", downvotes=" + downvotes +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }
}

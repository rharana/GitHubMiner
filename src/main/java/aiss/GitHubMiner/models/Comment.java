
package aiss.GitHubMiner.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment {

    @JsonProperty("id")
    private String id;
    @JsonProperty("body")
    private String body;

    @JsonProperty("user")
    private User author;

    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", body='" + body + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}

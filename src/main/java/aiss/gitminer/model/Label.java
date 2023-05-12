package aiss.gitminer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Label {
    @JsonProperty("name")
    public String name;

    public Label() {
    }

    public String getName() {
        return name;
    }

}

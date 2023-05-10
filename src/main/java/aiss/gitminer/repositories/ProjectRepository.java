package aiss.gitminer.repositories;

import aiss.gitminer.model.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProjectRepository {

    List<Project> projects = new ArrayList<>();

    public ProjectRepository(){

    }

    public List<Project> findAll(){ return projects; }

    public Project findOne(String id){
        return projects.stream()
                .filter(project -> project.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Project create(Project project) {
        Project newProject = new Project(
                UUID.randomUUID().toString(),
                project.getName(),
                project.getWebUrl(),
                project.getCommits(),
                project.getIssues());
        projects.add(newProject);
        return newProject;
    }
}

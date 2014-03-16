package erm.model.domain;

import java.util.List;
import java.util.Objects;

/**
 * The DTO used to pass data to and from the web service endpoint
 * @version 1.0
 * @author danieljones
 */
public class Interaction {
    
    private Comment comment;
    private List<Task> tasks;

    public Interaction() {}

    public Interaction(Comment comment, List<Task> tasks) {
        this.comment = comment;
        this.tasks = tasks;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.comment);
        hash = 37 * hash + Objects.hashCode(this.tasks);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Interaction other = (Interaction) obj;
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (!Objects.equals(this.tasks, other.tasks)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Interaction{" + "comment=" + comment + ", tasks=" + tasks + '}';
    }
    
    
    
    
    
}

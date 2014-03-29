package erm.model.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @version 1.0
 * @author danieljones
 */
@XmlRootElement(name = "task")
public class Task implements Serializable {
    
    private long id = 1L;
    private String task;
    private Author author;

    public Task() {}

    public Task(String task, Author author) {
        
        this.task = task;
        this.author = author;
        
    }
   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Task other = (Task) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", task=" + task + ", author=" + author + '}';
    }
    
    
    
}

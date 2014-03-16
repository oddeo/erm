package erm.model.domain;

/**
 * @version 1.0
 * @author danieljones
 */
public class Task {
    
    private long id = 1L;
    private String task;
    private String createdBy;

    public Task() {}

    public Task(String task, String createdBy) {
        
        this.task = task;
        this.createdBy = createdBy;
        
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
        return "Task{" + "id=" + id + ", task=" + task + ", createdBy=" + createdBy + '}';
    }
    
    
    
}

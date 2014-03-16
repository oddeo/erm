
package erm.model.domain;

/**
 * @version 1.0
 * @author danieljones
 */
public class Comment {

    private long id = 1L;
    private String comment;
    private String createdBy;
    
    
    public Comment() {}
    
    public Comment(String comment, String createdBy) {
        
        this.comment = comment;
        this.createdBy = createdBy;
        
    }
    
     /**
     * Get the value of id
     * @return the value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Set the value of id
     * @param id new value of id
     */
    public void setId(long id) {
        this.id = id;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Comment other = (Comment) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id 
                + ", comment=" + comment 
                + ", createdBy=" + createdBy + '}';
    }
    
}

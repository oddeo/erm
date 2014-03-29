
package erm.model.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @version 1.0
 * @author danieljones
 */
@XmlRootElement(name = "Comment")
public class Comment implements Serializable {

    private long id = 1L;
    private String comment;
    private Author author;
    
    
    public Comment() {}
    
    /**
     *
     * @param comment
     * @param author
     */
    public Comment(String comment, Author author) {
        
        this.comment = comment;
        this.author = author;
        
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
    

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
        return "Comment{" + "id=" + id + ", comment=" + comment + ", author=" + author + '}';
    }

    
    
}

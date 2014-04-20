package erm.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @version 1.0
 * @author danieljones
 */
@XmlRootElement(name = "comment")
@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "COMMENT_ID")
    private int id = 0;
    
    private String text;
    
    @Column(name = "AUTHOR_ID")
    private int authorId;
    
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;

    public Comment() {
    }

    /**
     *
     * @param text
     * @param authorId
     * @param employeeId
     */
    public Comment(String text, int authorId, int employeeId) {

        this.text = text;
        this.authorId = authorId;
        this.employeeId = employeeId;

    }

    /**
     *
     * @param id
     * @param text
     * @param authorId
     * @param employeeId
     */
    public Comment(int id, String text, int authorId, int employeeId) {

        this.text = text;
        this.authorId = authorId;
        this.employeeId = employeeId;
        this.id = id;

    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (this.authorId != other.authorId) {
            return false;
        }
        if (this.employeeId != other.employeeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", text=" + text + ", authorId=" + authorId + ", employeeId=" + employeeId + '}';
    }

}

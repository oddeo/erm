package erm.model.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @version 1.0
 * @author danieljones
 */
@XmlRootElement(name = "Author")
public class Author implements Serializable {
    
    private String firstName;
    private String lastName;
    private String authorId;

    public Author() {}

    public Author(String firstName, String lastName, String authorId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.authorId);
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
        final Author other = (Author) obj;
        if (!Objects.equals(this.authorId, other.authorId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Author{" + "firstName=" + firstName + ", lastName=" + lastName + ", authorId=" + authorId + '}';
    }
    
    
    
    
    
}

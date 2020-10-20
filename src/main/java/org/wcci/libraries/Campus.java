package org.wcci.libraries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Campus {
    private String location;
    private String description;
    private String techStack;
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "campus")
    private Collection<Book> books;

    protected Campus(){}

    public Campus(String location, String description, String techStack) {

        this.location = location;
        this.description = description;
        this.techStack = techStack;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getTechStack() {
        return techStack;
    }

    public Long getId() {
        return id;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", techStack='" + techStack + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Campus campus = (Campus) o;

        if (location != null ? !location.equals(campus.location) : campus.location != null) return false;
        if (description != null ? !description.equals(campus.description) : campus.description != null) return false;
        if (techStack != null ? !techStack.equals(campus.techStack) : campus.techStack != null) return false;
        return id != null ? id.equals(campus.id) : campus.id == null;
    }

    @Override
    public int hashCode() {
        int result = location != null ? location.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (techStack != null ? techStack.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}

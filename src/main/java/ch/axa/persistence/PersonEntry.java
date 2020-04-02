package ch.axa.persistence;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Table(name = "person")
@Entity
public class PersonEntry {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int person_id;

    private String firstname;
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "project_fk")
    private ProjectEntry projectEntry;

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int id) {
        this.person_id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public ProjectEntry getProjectEntry() {
        return projectEntry;
    }

    public void setProjectEntry(ProjectEntry projectEntry) {
        this.projectEntry = projectEntry;
    }

    @Override
    public String toString() {
        return "PersonEntry{" +
                "id=" + person_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", projectEntry=" + projectEntry +
                '}';
    }
}

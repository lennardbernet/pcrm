package ch.axa.persistence;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Table(name = "project")
@Entity
public class ProjectEntry {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int project_id;
    private String kuerzel;
    private String title;
    private int standard_kz;

    @OneToMany(mappedBy = "projectEntry")
    private List<PersonEntry> personEntryList;

    public ProjectEntry() {
        this(0, "", "", 0);
    }

    public ProjectEntry(int id, String kuerzel, String titel, int standard_kz) {
        this.project_id = id;
        this.kuerzel = kuerzel;
        this.title = titel;
        this.standard_kz = standard_kz;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titel) {
        this.title = titel;
    }

    public int getStandard_kz() {
        return standard_kz;
    }

    public void setStandard_kz(int standard_kz) {
        this.standard_kz = standard_kz;
    }

    @Override
    public String toString() {
        return "ProjectEntry{" +
                "id=" + project_id +
                ", kuerzel='" + kuerzel + '\'' +
                ", title='" + title + '\'' +
                ", standard_kz=" + standard_kz +
                ", personEntryList=" + personEntryList +
                '}';
    }
}

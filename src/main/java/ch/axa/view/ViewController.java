package ch.axa.view;


import ch.axa.business.PersonService;
import ch.axa.business.ProjectService;
import ch.axa.persistence.PersonEntry;
import ch.axa.persistence.ProjectEntry;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named("viewController")
public class ViewController {

    private int project_id;
    private String title;
    private String kuerzel;

    @EJB
    private ProjectService projectService;

    @EJB
    private PersonService personService;

    public ViewController() {
        projectService = new ProjectService();
        personService = new PersonService();
    }

    public void edit(int id) {
        Optional<ProjectEntry> pe = projectService.getProjectById(id);
        if (pe.isPresent()) {
            this.project_id = pe.get().getProject_id();
            this.title = pe.get().getTitle();
            this.kuerzel = pe.get().getKuerzel();
        }
    }

    public void safeProject() {
        this.project_id = Integer.parseInt(
                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getRequestParameterMap()
                        .get("project_id"));
        ProjectEntry pe = new ProjectEntry();
        pe.setTitle(this.title);
        pe.setKuerzel(this.kuerzel);
        pe.setStandard_kz(0);
        projectService.merge(pe);
    }

    public List<ProjectEntry> getProjectEntries() {
        System.out.println("Project entries");
        List<ProjectEntry> projectEntries = projectService.getProjectEntries();
        return projectEntries;
    }

    public List<PersonEntry> getPersonEntriesByProject(int id) {
        return personService.getPersonEntriesByProject(id);
    }

}

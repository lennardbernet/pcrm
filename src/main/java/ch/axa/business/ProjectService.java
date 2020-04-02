package ch.axa.business;

import ch.axa.persistence.ProjectDAO;
import ch.axa.persistence.ProjectEntry;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class ProjectService {

    @EJB
    private ProjectDAO projectDao;

    public List<ProjectEntry> getProjectEntries() {
        return projectDao.getProjectEntries();
    }

    public Optional<ProjectEntry> getProjectById(int id){return projectDao.getProjectEntries().stream().filter(pe -> pe.getProject_id() == id).findAny();}

    public void merge(ProjectEntry pe){
        projectDao.updateProject(pe);
    }

}

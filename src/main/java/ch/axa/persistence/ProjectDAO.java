package ch.axa.persistence;

import javax.ejb.Singleton;
import javax.persistence.*;
import java.util.List;

@Singleton
public class ProjectDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ProjectEntry> getProjectEntries() {
        TypedQuery<ProjectEntry> query = entityManager.createQuery("select pe from ProjectEntry pe", ProjectEntry.class);
        return query.getResultList();
    }

    public void updateProject(ProjectEntry pe){
        entityManager.merge(pe);
    }

    public void setStandardProject(int id) {
        getProjectEntries().stream().forEach(p -> {
            p.setStandard_kz(p.getProject_id() == id ? 1 : 0);
            entityManager.merge(p);
        });
    }

}

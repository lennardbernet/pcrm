package ch.axa.persistence;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Singleton
public class PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonEntry> getPersonEntriesByProject(int id){
        TypedQuery<PersonEntry> query = entityManager.createQuery("select pe from PersonEntry pe where pe.projectEntry.project_id = "+id, PersonEntry.class);
        return query.getResultList();
    }
}
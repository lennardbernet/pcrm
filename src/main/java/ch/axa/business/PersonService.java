package ch.axa.business;

import ch.axa.persistence.PersonDAO;
import ch.axa.persistence.PersonEntry;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class PersonService {

    @EJB
    PersonDAO personDAO;

    public List<PersonEntry> getPersonEntriesByProject(int id) {
        return personDAO.getPersonEntriesByProject(id);
    }

}

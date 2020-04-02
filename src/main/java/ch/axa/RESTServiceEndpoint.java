package ch.axa;

import ch.axa.persistence.PersonDAO;
import ch.axa.persistence.ProjectDAO;
import ch.axa.persistence.ProjectEntry;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/se")
public class RESTServiceEndpoint {

    @EJB
    ProjectDAO projectDAO;

    @EJB
    PersonDAO personDAO;

    @GET
    @Path("/projects")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjects() {
        return Response.ok(projectDAO.getProjectEntries()).build();
    }



    @GET
    @Path("/projectStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsByProjectId(@QueryParam("id") int id){
        return Response.ok(personDAO.getPersonEntriesByProject(id)).build();
    }

    @POST
    @Path("/updateProject")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateProject(@FormParam("id") int id, @FormParam("kuerzel") String kuerzel, @FormParam("titel") String title,@FormParam("standard") int standard_kz){
        projectDAO.updateProject(new ProjectEntry(id,kuerzel,title,standard_kz));
    }

}
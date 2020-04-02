package ch.axa.login;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Named
@Singleton
@Path("/auth")
public class LoginController {
    /*@Inject
    private AuthenticationService authenticationService;*/

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(Credentials credentials) {
        return Response.status(401).build();
        /*Optional<Token> tokenOptional = authenticationService.authenticateUser(credentials);
        if (tokenOptional.isPresent()) {
            return Response.ok(tokenOptional).build();
        } else {
            return Response.status(401).build();
        }*/
    }

}

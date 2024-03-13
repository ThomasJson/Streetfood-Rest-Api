package fr.tp.resources;

import fr.tp.dto.AppUserDto;
import fr.tp.services.AppUserService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/user")
public class AppUserResource {

    @Inject
    AppUserService appUserService;

    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AppUserDto> getAllAppUsers() {
        return appUserService.getAllAppUsers();
    }

    @GET
    @RolesAllowed({"Admin","User"})
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppUserById(@PathParam("id") UUID id) {
        AppUserDto userDto = appUserService.getAppUserById(id);
        if (userDto != null) {
            return Response.ok(userDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
        }
    }
}
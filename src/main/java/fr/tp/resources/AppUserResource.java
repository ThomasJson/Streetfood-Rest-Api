package fr.tp.resources;

import fr.tp.repositories.AppUserRepository;
import fr.tp.dto.AppUserDto;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class AppUserResource {

    @Inject
    AppUserRepository appUserRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AppUserDto> getAllAppUsers() {
        return AppUserDto.fromEntities(appUserRepository.getAllAppUsers());
    }

}
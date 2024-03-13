/*

package fr.tp.resources;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import fr.tp.services.InitDbService;

@Path("/init")
public class InitDbResource {

    @Inject
    InitDbService initDbService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public Response initDatabase() {
        try {
            initDbService.init();
            return Response.ok("Initialisation de la base de données réussie.").build();

        } catch (Exception e) {
            return Response.serverError().entity("Erreur lors de l'initialisation de la base de données : " + e.getMessage()).build();
        }
    }

}

*/
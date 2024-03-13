package fr.tp.resources;

import fr.tp.entities.ProductEntity;
import fr.tp.models.InsertProductModel;
import fr.tp.services.AdminService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

@Path("/admin")
public class AdminResource {

    @Inject
    AdminService adminService;

    @POST
    @RolesAllowed("Admin")
    @Path("/product/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertProduct(InsertProductModel productToInsert) {

        try {
            ProductEntity product = adminService.insertProduct(productToInsert);
            return Response.ok(product).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }
}
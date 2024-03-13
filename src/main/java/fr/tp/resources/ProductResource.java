package fr.tp.resources;

import fr.tp.dto.ProductDto;
import fr.tp.services.ProductService;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/product")
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GET
    @PermitAll
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") UUID id) {
        ProductDto productDto = productService.getProductById(id);
        if (productDto != null) {
            return Response.ok(productDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Product not found").build();
        }
    }

}
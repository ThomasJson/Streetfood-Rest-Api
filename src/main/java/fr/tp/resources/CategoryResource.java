package fr.tp.resources;

import fr.tp.dto.AccountDto;
import fr.tp.dto.AppUserDto;
import fr.tp.dto.CategoryDto;
import fr.tp.dto.ProductDto;
import fr.tp.entities.AccountEntity;
import fr.tp.entities.CategoryEntity;
import fr.tp.entities.ImageEntity;
import fr.tp.entities.ProductEntity;
import fr.tp.repositories.AccountRepository;

import fr.tp.repositories.CategoryRepository;
import fr.tp.services.AppUserService;
import fr.tp.services.CategoryService;
import fr.tp.utils.RestUtils;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Path("/category")
public class CategoryResource {

    @Inject
    CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoryById(@PathParam("id") UUID id) {
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        if (categoryDto != null) {
            return Response.ok(categoryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Category not found").build();
        }
    }



    @GET
    @Path("/{id}/products")
    public Response getProductsByCategory(@PathParam("id") UUID categoryId, @QueryParam("withImages") @DefaultValue("false") boolean withImages) {
        try {
            List<ProductDto> products = categoryService.getProductsByCategory(categoryId, withImages);
            return Response.ok(products).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred: " + e.getMessage()).build();
        }
    }



}
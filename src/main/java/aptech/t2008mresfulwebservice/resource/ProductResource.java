package aptech.t2008mresfulwebservice.resource;

import aptech.t2008mresfulwebservice.entity.Product;
import aptech.t2008mresfulwebservice.model.MySqlProductModel;
import aptech.t2008mresfulwebservice.repository.ProductModel;

import javax.ws.rs.*;
import java.util.List;

@Path("/products")
@Produces("application/json")
@Consumes("application/json")
public class ProductResource {
    ProductModel productModel;

    public ProductResource(){
        productModel = new MySqlProductModel();
    }

    @GET
    public List<Product> findAll() {
        System.out.println("Hello");
        return productModel.findAll();
    }
    @Path("{id}")
    @GET
    public Product findById ( @PathParam("id") int id){
        return productModel.findById(id);
    }

    @POST
    public Product create(Product product){
        return productModel.save(product);
    }

    @PUT
    @Path("{id}")
    public Product update(@PathParam("id") int id , Product updateProduct){
        return productModel.update(updateProduct , id);
    }
    @DELETE
    @Path("{id}")
    public  boolean delete(@PathParam("id")int id){
        return productModel.delete(id);
    }
}

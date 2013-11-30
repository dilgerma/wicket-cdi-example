package de.effectivetrainings.product;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class ProductProvider {
 
    public ProductProvider(){}
 
    @Produces
    public List<Product> productList(){
 
        Product samba = new Product("Adidas Samba",49.95);
        Product air = new Product("Nike Air",79.95);
        Product balerina = new Product("Balerinas",9.95);
 
        return Arrays.asList(samba, air, balerina);
 
    }
}
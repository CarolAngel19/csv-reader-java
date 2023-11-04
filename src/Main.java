import services.ProductService;
import interfaces.ProductServiceInterface;
import model.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductServiceInterface productService = new ProductService();

        List<Product> productList = productService.getProductList();

        // Imprimir los productos
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}

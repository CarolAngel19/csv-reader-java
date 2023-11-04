package services;

import interfaces.ProductServiceInterface;
import model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements ProductServiceInterface {

    private List<Product> productList = new ArrayList<>();

    public ProductService() {
        loadProductsFromCSV("resources/inventory.csv");
    }

    private void loadProductsFromCSV(String csvFilePath) {
        try {
            File file = new File(csvFilePath);
            Scanner fileScanner = new Scanner(file);
            // Saltar el encabezado del CSV
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] productInfo = line.split(",");
                if (productInfo.length == 6) {
                    String name = productInfo[0];
                    String description = productInfo[1];
                    String category = productInfo[2];
                    String tags = productInfo[3];
                    float price = Float.parseFloat(productInfo[4]);
                    String imageUrl = productInfo[5];
                    Product product = new Product(name, description, category, tags, price, imageUrl);
                    productList.add(product);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getProductList() {
        return productList;
    }
}

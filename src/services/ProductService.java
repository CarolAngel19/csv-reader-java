package services;

import com.opencsv.exceptions.CsvException;
import interfaces.ProductServiceInterface;
import model.Product;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.IOException;


public class ProductService implements ProductServiceInterface {

    private List<Product> productList = new ArrayList<>();

    public ProductService() {
        loadProductsFromCSV("resources/inventory.csv");
    }

    private void loadProductsFromCSV(String csvFilePath) {
        try {
            FileReader fileReader = new FileReader(csvFilePath);
            CSVReader csvReader = new CSVReaderBuilder(fileReader)
                    .withSkipLines(1) // Salta el encabezado del CSV
                    .build();

            List<String[]> records = csvReader.readAll();
            for (String[] productInfo : records) {
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getProductList() {
        return productList;
    }
}

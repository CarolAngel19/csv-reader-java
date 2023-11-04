package model;

public class Product {

    private String name;

    private String description;

    private String category;

    private String tags;

    private float price;

    private String imageUrl;


    public Product(String name, String description, String category, String tags, float price, String imageUrl) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.tags = tags;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product: \n" +
                "Name: " + name + '\n' +
                "Description: " + description + '\n' +
                "Category: " + category + '\n' +
                "Tags: " + tags + '\n' +
                "Price: " + price + '\n' +
                "ImageUrl: " + imageUrl + '\n';
    }

}

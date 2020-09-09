package product;

import java.util.Objects;

public class Product {
    //This is the product class which defines the attributes of the product.
    private String name;
    private double weightInGrams;
    private String image;
    private String reviews;
    private double price;

    public Product() {}
    
    public Product(String name, double weight, String image, String reviews, double price) {
        this.name = name;
        this.weightInGrams = weight;
        this.image = image;
        this.reviews = reviews;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(double weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.getWeightInGrams(), getWeightInGrams()) == 0 &&
                Double.compare(product.getPrice(), getPrice()) == 0 &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getImage(), product.getImage()) &&
                Objects.equals(getReviews(), product.getReviews());
    }

    @Override
    public String toString() {
        return "Product [image=" + image + ", name=" + name + ", price=" + price + ", reviews=" + reviews
                + ", weightInGrams=" + weightInGrams + "]";
    }


}

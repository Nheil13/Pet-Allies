package com.example.petallies.model;

/**
 * CategoryItem represents a model class that holds information about an item within a category.
 * It includes fields such as id (item identifier), imageURL (URL of the item's image), productDescription
 * (description of the item), productPrice (price of the item), and productStocks (stock information).
 */
public class CategoryItem {

    Integer id;                      // Item identifier
    String imageURL;                 // URL of the item's image
    String productDescription;       // Description of the item
    String productPrice;             // Price of the item
    String productStocks;            // Stock information of the item

    /**
     * Constructor for CategoryItem.
     *
     * @param id Item identifier.
     * @param imageURL URL of the item's image.
     * @param productDescription Description of the item.
     * @param productPrice Price of the item.
     * @param productStocks Stock information of the item.
     */
    public CategoryItem(Integer id, String imageURL, String productDescription, String productPrice, String productStocks) {
        this.id = id;
        this.imageURL = imageURL;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productStocks = productStocks;
    }

    /**
     * Getter method for retrieving the item identifier.
     *
     * @return The item identifier.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter method for setting the item identifier.
     *
     * @param id The new item identifier.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter method for retrieving the URL of the item's image.
     *
     * @return The URL of the item's image.
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Setter method for setting the URL of the item's image.
     *
     * @param imageURL The new URL of the item's image.
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Getter method for retrieving the description of the item.
     *
     * @return The description of the item.
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Setter method for setting the description of the item.
     *
     * @param productDescription The new description of the item.
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * Getter method for retrieving the price of the item.
     *
     * @return The price of the item.
     */
    public String getProductPrice() {
        return productPrice;
    }

    /**
     * Setter method for setting the price of the item.
     *
     * @param productPrice The new price of the item.
     */
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * Getter method for retrieving the stock information of the item.
     *
     * @return The stock information of the item.
     */
    public String getProductStocks() {
        return productStocks;
    }

    /**
     * Setter method for setting the stock information of the item.
     *
     * @param stocks The new stock information of the item.
     */
    public void setProductStocks(String stocks) {
        this.productStocks = stocks;
    }
}


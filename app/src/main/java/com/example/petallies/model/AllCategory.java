package com.example.petallies.model;

import java.util.List;

/**
 * AllCategory represents a model class that holds information about a category and its associated list of items.
 * It has fields for categoryTitle (the title of the category) and categoryItemList (a list of CategoryItem objects
 * associated with the category).
 */
public class AllCategory {

    String categoryTitle;           // The title of the category
    List<CategoryItem> categoryItemList;  // List of items associated with the category

    /**
     * Constructor for AllCategory.
     *
     * @param categoryTitle The title of the category.
     * @param categoryItemList List of CategoryItem objects associated with the category.
     */
    public AllCategory(String categoryTitle, List<CategoryItem> categoryItemList){
        this.categoryTitle = categoryTitle;
        this.categoryItemList = categoryItemList;
    }

    /**
     * Getter method for retrieving the list of CategoryItem objects associated with the category.
     *
     * @return The list of CategoryItem objects.
     */
    public List<CategoryItem> getCategoryItemList() {
        return categoryItemList;
    }

    /**
     * Setter method for setting the list of CategoryItem objects associated with the category.
     *
     * @param categoryItemList The new list of CategoryItem objects.
     */
    public void setCategoryItemList(List<CategoryItem> categoryItemList) {
        this.categoryItemList = categoryItemList;
    }

    /**
     * Getter method for retrieving the title of the category.
     *
     * @return The title of the category.
     */
    public String getCategoryTitle() {
        return categoryTitle;
    }

    /**
     * Setter method for setting the title of the category.
     *
     * @param categoryTitle The new title of the category.
     */
    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}


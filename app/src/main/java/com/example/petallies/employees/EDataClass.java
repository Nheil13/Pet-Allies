package com.example.petallies.employees;

public class EDataClass {

    private String eDataName; //Name of the Item
    private String eDataImage; // URL of the image associated with the item
    private String eDataRole; //Role of the Item
    private Boolean eDataAvailable; //Boolean type, allowing it to be either true (data available) or false (data not available).

    /**
     * Getter for eDataName.
     * @return The Name of the item.
     */
    public String geteDataName() {
        return eDataName;
    }

    /**
     * Getter for eDataImage.
     * @return The URL of the image associated with the item.
     */
    public String geteDataImage() {
        return eDataImage;
    }

    /**
     * Getter for eDataRole.
     * @return The Role of the item.
     */
    public String geteDataRole() {
        return eDataRole;
    }


    /**
     * Getter method for retrieving the value of eDataAvailable.
     *
     * @return The current value of eDataAvailable, indicating whether certain data is available (true) or not (false).
     */
    public Boolean geteDataAvailable() {
        return eDataAvailable;
    }

    /**
     * Constructor for AboutUsCategory.
     *
     * @param eDataName The title of the item.
     * @param eDataImage The description of the item.
     * @param eDataRole The language information of the item.
     * @param eDataAvailable The URL of the image associated with the item.
     */
    public EDataClass(String eDataName, String eDataImage, String eDataRole, Boolean eDataAvailable) {
        this.eDataName = eDataName;
        this.eDataImage = eDataImage;
        this.eDataRole = eDataRole;
        this.eDataAvailable = eDataAvailable;
    }
}

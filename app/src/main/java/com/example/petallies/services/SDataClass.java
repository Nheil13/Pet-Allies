package com.example.petallies.services;

public class SDataClass {

    private String sDataTitle; //Title of the Item
    private int sDataDesc; //Description of the Item
    private String sDataLang; // Information of the Item
    private String sDataImage; // URL of the image associated with the item

    /**
     * Getter for dataTitle.
     * @return The title of the item.
     */
    public String getsDataTitle() {
        return sDataTitle;
    }

    /**
     * Getter for dataDesc.
     * @return The description of the item.
     */
    public int getsDataDesc() {
        return sDataDesc;
    }

    /**
     * Getter for dataLang.
     * @return The information of the item.
     */
    public String getsDataLang() {
        return sDataLang;
    }

    /**
     * Getter for dataImage.
     * @return The URL of the image associated with the item.
     */
    public String getsDataImage() {
        return sDataImage;
    }

    /**
     * Constructor for AboutUsCategory.
     *
     * @param sDataTitle The title of the item.
     * @param sDataDesc The description of the item.
     * @param sDataLang The information of the item.
     * @param sDataImage The URL of the image associated with the item.
     */
    public SDataClass(String sDataTitle, int sDataDesc, String sDataLang, String sDataImage) {
        this.sDataTitle = sDataTitle;
        this.sDataDesc = sDataDesc;
        this.sDataLang = sDataLang;
        this.sDataImage = sDataImage;
    }
}

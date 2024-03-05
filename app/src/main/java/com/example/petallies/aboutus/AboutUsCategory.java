package com.example.petallies.aboutus;

public class AboutUsCategory {

    private String dataTitle; // Title of the item
    private int dataDesc; // Description of the item (assuming it's an integer, consider changing to String if it's a text)
    private String dataLang; // information of the item
    private String dataImage; // URL of the image associated with the item

    /**
     * Getter for dataTitle.
     * @return The title of the item.
     */
    public String getDataTitle() {
        return dataTitle;
    }


    /**
     * Setter for dataTitle.
     * @param dataTitle The new title to set.
     */
    public void setDataTitle(String dataTitle) {
        this.dataTitle = dataTitle;
    }

    /**
     * Getter for dataDesc.
     * @return The description of the item.
     */
    public int getDataDesc() {
        return dataDesc;
    }

    /**
     * Setter for dataDesc.
     * @param dataDesc The new description to set.
     */
    public void setDataDesc(int dataDesc) {
        this.dataDesc = dataDesc;
    }

    /**
     * Getter for dataLang.
     * @return The information of the item.
     */
    public String getDataLang() {
        return dataLang;
    }


    /**
     * Setter for dataLang.
     * @param dataLang The new language information to set.
     */
    public void setDataLang(String dataLang) {
        this.dataLang = dataLang;
    }

    /**
     * Getter for dataImage.
     * @return The URL of the image associated with the item.
     */
    public String getDataImage() {
        return dataImage;
    }

    /**
     * Setter for dataImage.
     * @param dataImage The new image URL to set.
     */
    public void setDataImage(String dataImage) {
        this.dataImage = dataImage;
    }

    /**
     * Constructor for AboutUsCategory.
     *
     * @param dataTitle The title of the item.
     * @param dataDesc The description of the item.
     * @param dataLang The language information of the item.
     * @param dataImage The URL of the image associated with the item.
     */

    public AboutUsCategory(String dataTitle, int dataDesc, String dataLang, String dataImage) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataLang = dataLang;
        this.dataImage = dataImage;
    }
}

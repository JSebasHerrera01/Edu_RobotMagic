package com.example.robotmagic;

public class CardNumberItem {
    private String title;
    private String description;
    private String imageName; // Nombre del archivo sin extensión

    public CardNumberItem(String title, String description, String imageName) {
        this.title = title;
        this.description = description;
        this.imageName = imageName;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageName() {
        return imageName;
    }
}

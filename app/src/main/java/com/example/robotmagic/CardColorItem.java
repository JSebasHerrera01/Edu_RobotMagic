package com.example.robotmagic;

// CardColorItem.java
public class CardColorItem {
    private String title;
    private String description;
    private String imageName; // Nombre del archivo sin extensión

    public CardColorItem(String title, String description, String imageName) {
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

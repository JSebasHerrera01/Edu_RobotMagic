package com.example.robotmagic;

public class CardColorEvalueItem {
    private String title;
    private String description, answer1, answer2, answer3;
    private String imageName; // Nombre del archivo sin extensión

    public CardColorEvalueItem(String title, String answer1, String answer2, String Answer3, String imageName) {
        this.title = title;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = Answer3;
        this.imageName = imageName;
    }

    public String getTitle() {
        return title;
    }

    public String getanswer1() {
        return answer1;
    }
    public String getAnswer2() {
        return answer2;
    }
    public String getanswer3() {
        return answer3;
    }

    public String getImageName() {
        return imageName;
    }
}

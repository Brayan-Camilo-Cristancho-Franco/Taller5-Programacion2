package edu.unbosque.WebServicesTutorial.resources.pojos;

public class Notification {

    private String text;

    public Notification(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

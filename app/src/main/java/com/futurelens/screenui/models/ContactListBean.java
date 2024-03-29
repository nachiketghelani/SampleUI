package com.futurelens.screenui.models;

public class ContactListBean {

    int image;
    String name;
    String designation;

    public ContactListBean(int image, String name, String designation) {
        this.image = image;
        this.name = name;
        this.designation = designation;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

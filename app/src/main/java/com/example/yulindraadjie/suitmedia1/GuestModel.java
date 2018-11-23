package com.example.yulindraadjie.suitmedia1;

public class GuestModel {

    private int id;
    private String name;
    private String birthdate;
    private int imgs;

    public GuestModel(){

    }

    public GuestModel(int id, String name, String birthdate, int imgs) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.imgs = imgs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getImgs() {
        return imgs;
    }

    public void setImgs(int imgs) {
        this.imgs = imgs;
    }
}

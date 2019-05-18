package com.example.searchbydatesearchview2;

public class ModelPlayers {

    private String name;
    private String pos;
    private String date;
    private int img;

    public ModelPlayers(String name, String pos, String date, int img) {
        this.name = name;
        this.pos = pos;
        this.date = date;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

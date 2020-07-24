package com.dnteam.medkit.pojo;

public class Country {
    private int imgId;
    private String name;
    private boolean selected;
    private String key;


    public Country(int imgId, String name, String key, boolean selected) {
        this.imgId = imgId;
        this.name = name;
        this.selected = selected;
    }

    public Country(int imgId, String name, String key) {
        this.imgId = imgId;
        this.name = name;
        this.setSelected(false);
    }


    public String getKey() {
        return key;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getImgId() {
        return imgId;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return selected;
    }
}

package com.example.wifiauthentication;


public class dataholder {
    String name, pimage;

    public dataholder(String name,  String image) {
        this.name = name;
        this.pimage = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }
}

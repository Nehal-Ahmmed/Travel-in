package com.example.travelin.domains;

public class categoryDomain {
    private String picpath;
    private String title;

    public categoryDomain(String picpath, String title) {
        this.picpath = picpath;
        this.title = title;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

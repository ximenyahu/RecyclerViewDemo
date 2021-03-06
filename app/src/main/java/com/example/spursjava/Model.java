package com.example.spursjava;

import java.util.Comparator;

public class Model {
    private String title;
    private String description;
    private String profile;

    public Model(String title, String description, String profile, int image) {
        this.title = title;
        this.description = description;
        this.profile = profile;
        this.image = image;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    private int image;
    private boolean isExpand;

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public Model(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static final Comparator<Model> BY_TITLE_ASCENDING = new Comparator<Model>() {
        @Override
        public int compare(Model o1, Model o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    };

    public static final Comparator<Model> BY_TITLE_DESCENDING = new Comparator<Model>() {
        @Override
        public int compare(Model o1, Model o2) {
            return o2.getTitle().compareTo(o1.getTitle());
        }
    };

}

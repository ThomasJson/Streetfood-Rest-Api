package fr.tp.models;

import java.util.UUID;

public class InsertProductModel {

    private String title;
    private String content;
    private String src;
    private String alt;
    private UUID categoryId;

    public InsertProductModel(String title, String content, String src, String alt, UUID categoryId) {
        this.title = title;
        this.content = content;
        this.src = src;
        this.alt = alt;
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }
}

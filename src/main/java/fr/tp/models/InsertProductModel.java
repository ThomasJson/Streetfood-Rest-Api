package fr.tp.models;

import java.math.BigDecimal;
import java.util.UUID;

public class InsertProductModel {

    private String title;
    private String titleTh;
    private String content;
    private String contentTh;
    private BigDecimal price;
    private int stock;
    private boolean isNew;
    private boolean isBestOffer;
    private boolean isBestSeller;
    private String src;
    private String alt;
    private UUID categoryId;

    public InsertProductModel(String title, String titleTh, String content, String contentTh, BigDecimal price, int stock, boolean isNew, boolean isBestOffer, boolean isBestSeller, String src, String alt, UUID categoryId) {
        this.title = title;
        this.titleTh = titleTh;
        this.content = content;
        this.contentTh = contentTh;
        this.price = price;
        this.stock = stock;
        this.isNew = isNew;
        this.isBestSeller = isBestSeller;
        this.isBestOffer = isBestOffer;
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

    public String getTitleTh() {
        return titleTh;
    }

    public void setTitleTh(String titleTh) {
        this.titleTh = titleTh;
    }

    public String getContentTh() {
        return contentTh;
    }

    public void setContentTh(String contentTh) {
        this.contentTh = contentTh;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isBestOffer() {
        return isBestOffer;
    }

    public void setBestOffer(boolean bestOffer) {
        isBestOffer = bestOffer;
    }

    public boolean isBestSeller() {
        return isBestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        isBestSeller = bestSeller;
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

package org.core.domain;

import org.led.simba.product.SubType;

import java.util.Objects;

public class BaseItem {
    private int id;
    private String title;
    private String rate;
    private String feedBack;
    private String order;
    private String shipmentInfo;
    private double price;
    private double discountPrice;
    private String deliveryTime;
    private String deliveryNote;
    private String availableStatus;
    private SubType subType;
    private String productDescriptions;

    public BaseItem() {
    }

    public BaseItem(Integer id, String title, String rate, String feedBack, String order, String shipmentInfo, double price, double discountPrice, String deliveryTime, String deliveryNote, String availableStatus, SubType subType, String productDescriptions) {

        if (Objects.nonNull(id)) {
            this.id = id;
        }
        this.title = title;
        this.rate = rate;
        this.feedBack = feedBack;
        this.order = order;
        this.shipmentInfo = shipmentInfo;
        this.price = price;
        this.discountPrice = discountPrice;
        this.deliveryTime = deliveryTime;
        this.deliveryNote = deliveryNote;
        this.availableStatus = availableStatus;
        this.subType = subType;
        this.productDescriptions = productDescriptions;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getShipmentInfo() {
        return shipmentInfo;
    }

    public void setShipmentInfo(String shipmentInfo) {
        this.shipmentInfo = shipmentInfo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    public String getAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(String availableStatus) {
        this.availableStatus = availableStatus;
    }

    public static enum Type {
        LED, POWER, MAXTRIX,
    }
}

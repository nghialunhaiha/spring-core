package org.core.domain;

import org.led.simba.product.SubType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

import static org.led.simba.user.UserConstants.USER_ID;

public class BaseItem {
    @Id
    @Column(name = USER_ID)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "rate")
    private String rate;

    @Column(name = "feed_back")
    private String feedBack;

    @Column(name = "order")
    private String order;

    @Column(name = "ship_info")
    private String shipmentInfo;

    @Column(name = "price")
    private double price;

    @Column(name = "dcount_price")
    private double discountPrice;

    @Column(name = "delivery_time")
    private String deliveryTime;

    @Column(name = "delivery_note")
    private String deliveryNote;

    @Column(name = "avaiable_stt")
    private String availableStatus;

    @NotNull
    @Column(name = "sub_type")
    private SubType subType;

    @Column(name = "prd_desc")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductDescriptions() {
        return productDescriptions;
    }

    public void setProductDescriptions(String productDescriptions) {
        this.productDescriptions = productDescriptions;
    }

    public SubType getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType;
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

    /**
     * When create each product, subType is required field
     * @return true : not defined type yet.
     */
    public boolean notDefineType() {
        return Objects.isNull(this.subType);
    }

    public static enum Type {
        LED, POWER, MAXTRIX,
    }
}

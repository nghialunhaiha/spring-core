package org.led.simba.product;

import static org.led.simba.user.UserConstants.USER_ID;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = ProductConstant.PRD_TABLE)
public class ProductItem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id = 1;

    @Column(name = "title")
    private String title;

    @Column(name = "rate")
    private String rate;

    @Column(name = "feed_back")
    private String feedBack;

    @Column(name = "order_stt")
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
    private String subType;

    @Column(name = "prd_desc")
    private String productDescriptions;

    @Transient
//    @Column(name = "colors")
//    @ElementCollection(targetClass = String.class)
    private List<String> colors;

    @Column(name = "led_type")
    private LEDType ledType;

    @Column(name = "color_tmp")
    private ColorTemp colorTemp;

    @Column(name = "occasion")
    private String occasion; // living room

    @Column(name = "power_gen")
    private String powerGeneration;

    @Column(name = "led_pm")
    private String ledsPerMeter;

    @Column(name = "avg_life")
    private int averageLife;

    @Column(name = "water_prf")
    private boolean waterProff;

    @Column(name = "vol")
    private int voltage;

    @Column(name = "cl_temp")
    private String colorTemperature;

    @Column(name = "p_source")
    private PowerSource powerSource;

    @Column(name = "md_no")
    private String modelNumber;

    public ProductItem() {
    }

    public ProductItem(int averageLife, List<String> colors, ColorTemp colorTemp, String colorTemperature, String ledsPerMeter, LEDType ledType, String modelNumber, String occasion, String powerGeneration, PowerSource powerSource, int voltage, boolean waterProff) {
        this.averageLife = averageLife;
        this.colors = colors;
        this.colorTemp = colorTemp;
        this.colorTemperature = colorTemperature;
        this.ledsPerMeter = ledsPerMeter;
        this.ledType = ledType;
        this.modelNumber = modelNumber;
        this.occasion = occasion;
        this.powerGeneration = powerGeneration;
        this.powerSource = powerSource;
        this.voltage = voltage;
        this.waterProff = waterProff;
    }

    public enum LEDType {
        LED_5050, LED_5730, LED_F5, LED_F8, LED_LINK,
    }

    public enum ColorTemp {
        T_3000K, T_4500K, T_5000K, T_6000K
    }

    public enum PowerSource {
        AC, DC
    }

    public boolean isWaterProff() {
        return waterProff;
    }

    public void setWaterProff(boolean waterProff) {
        this.waterProff = waterProff;
    }

    public int getAverageLife() {
        return averageLife;
    }

    public void setAverageLife(int averageLife) {
        this.averageLife = averageLife;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public ColorTemp getColorTemp() {
        return colorTemp;
    }

    public void setColorTemp(ColorTemp colorTemp) {
        this.colorTemp = colorTemp;
    }

    public String getColorTemperature() {
        return colorTemperature;
    }

    public void setColorTemperature(String colorTemperature) {
        this.colorTemperature = colorTemperature;
    }

    public String getLedsPerMeter() {
        return ledsPerMeter;
    }

    public void setLedsPerMeter(String ledsPerMeter) {
        this.ledsPerMeter = ledsPerMeter;
    }

    public LEDType getLedType() {
        return ledType;
    }

    public void setLedType(LEDType ledType) {
        this.ledType = ledType;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getPowerGeneration() {
        return powerGeneration;
    }

    public void setPowerGeneration(String powerGeneration) {
        this.powerGeneration = powerGeneration;
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
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

    public SubType getSubType() {
        return SubType.valueOf(subType);
    }

    public void setSubType(SubType subType) {
        this.subType = subType.name();
    }

    public String getProductDescriptions() {
        return productDescriptions;
    }

    public void setProductDescriptions(String productDescriptions) {
        this.productDescriptions = productDescriptions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

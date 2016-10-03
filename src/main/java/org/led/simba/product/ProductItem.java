package org.led.simba.product;

import org.core.domain.BaseItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = ProductConstant.PRD_TABLE)
public class ProductItem extends BaseItem {
    @Column(name = "colors")
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
}

package org.led.simba.product;

import org.core.domain.BaseItem;

import java.util.List;

public class ProductItem extends BaseItem {
    private List<String> colors;
    private LEDType ledType;
    private ColorTemp colorTemp;
    private String occasion; // living room
    private String powerGeneration;
    private String ledsPerMeter;
    private int averageLife;
    private boolean waterProff;
    private int voltage;
    private String colorTemperature;
    private PowerSource powerSource;
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
        LED_5050, LED_5730
    }

    public enum ColorTemp {
        T_3000K, T_4500K, T_5000K, T_6000K
    }

    public enum PowerSource {
        AC, DC
    }


}

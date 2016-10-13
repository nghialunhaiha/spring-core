package org.led.simba.product;

/**
 * Created by NTQ-Admin on 23-09-2016.
 */
public class ProductConstant {
    // redirect
    public static final String PRODUCT_LIST = "/prd-list-page/prd-list";

    public static final String PRD_DETAIL = "/prd-detail/prd-detail";

    public static final String PRD_MGMT = "/mgmt/product/ProductManagement";

    public static final String PRD_TABLE = "PRODUCTITEM";

    // csv
    public static final String[] CSV_PRD_HEADER = { "Title", "Rate", "Feed Back", "Order", "Shipment info", "price",
            "Discount price", "Delivery time", "Delivery note", "Avaiable status", "Subtype", "Product descriptions",
            "colors", "Led type", "Color temp", "Occasion", "Power generation", "Leds per meter", "Average life",
            "Water proff", "voltage", "Color temperature", "Power source", "Model number" };

    public static final String[] CSV_PRD_NAME_MAPPING = { "title", "rate", "feedBack", "order", "shipmentInfo", "price",
            "discountPrice", "deliveryTime", "deliveryNote", "availableStatus", "subType", "productDescriptions",
            "colors", "ledType", "colorTemp", "occasion", "powerGeneration", "ledsPerMeter", "averageLife",
            "waterProff", "voltage", "colorTemperature", "powerSource", "modelNumber" };

}

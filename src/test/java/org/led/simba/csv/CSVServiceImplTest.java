package org.led.simba.csv;

import org.core.json.JsonUTils;
import org.junit.Test;
import org.led.simba.BaseServiceTest;
import org.led.simba.common.CommonConstant;
import org.led.simba.csv.CSVException.CSVError;
import org.led.simba.csv.service.CSVService;
import org.led.simba.product.ProductConstant;
import org.led.simba.product.ProductItem;
import org.led.simba.product.ProductProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CSVServiceImplTest extends BaseServiceTest {
    @Autowired
    private CSVService csvService;

    @Test
    public void importProduct() {
        String pathToFile = BASE_DIR + "/csv/product/improt_product_test.csv";
        List<CSVError> csvErrors = new ArrayList<>();
        ProductProcessor productProcessor = new ProductProcessor();

        List<ProductItem> csvData = csvService.parseFromCSVToBean(ProductConstant.CSV_PRD_HEADER, ProductConstant.CSV_PRD_NAME_MAPPING, pathToFile,
                CommonConstant.DEFAULT_CHARSET, "http", csvErrors, productProcessor.getProccessors(),
                ProductItem.class);
        for (ProductItem item : csvData) {
            System.out.println(JsonUTils.toJson(item));
        }
    }
}

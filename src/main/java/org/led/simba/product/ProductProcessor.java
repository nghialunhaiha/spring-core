package org.led.simba.product;

import org.led.simba.csv.CSVProcessors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nghialun on 12/10/2016.
 */
public class ProductProcessor extends CSVProcessors {

//    public CanBusProcessor[] getProcessors() {
//        LoginIdProcessor loginProcessor = new LoginIdProcessor(true);
//        loginProcessor.wireBean(organizationService, userService);
//
//        final CanBusProcessor[] processors = new CanBusProcessor[] { //
//                new KindProcessor(true), // Kind
//                loginProcessor, // Loginid
//                new DisplayNameProcessor(), // display name
//                new FirstNameProcessor(), // firstname
//                new LastNameProcessor(), // lastName
//                new GenderProcessor(false), // gender
//                new CanbusOptional(), // userIcon
//                new UserPermisisonProcessor(false), // permission
//                new EmployeeIdProcessor(), // employeeId
//                new HireDateProcessor(false), // join Date
//                new BirthDayProcessor(false), // birth
//                new LanguageProcessor(false), // language
//                new CanbusOptional(), // timeZone
//                new PasswordProcessor(), // password
//                new MemoProcessor(), // memo
//                new EmailProcessor(), // email
//        };
//        return processors;
//    }
    public List<CSVProcessors> getProccessors() {
        List<CSVProcessors> processorses = new ArrayList<>();

        return processorses;
    }
}

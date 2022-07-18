package in.armedu.banking.report.rbixbrl.model.rle;

import java.util.List;
import in.armedu.banking.report.rbixbrl.model.rle.*;

public class RLEReportUtil {
    
        public static String retrieveValueForTypeOfSectionAxis(List<TypeOfSectionAxis> fieldList, String type ) {
            TypeOfSectionAxis fieldObj = (TypeOfSectionAxis) fieldList.stream().filter(p -> p.getType().toString().equals(type)).findAny().get();
            return fieldObj.getValue();
        }

    
        public static String retrieveValueForInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis(List<InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis> fieldList, String type ) {
            InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis fieldObj = (InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis) fieldList.stream().filter(p -> p.getType().toString().equals(type)).findAny().get();
            return fieldObj.getValue();
        }

    
    
}

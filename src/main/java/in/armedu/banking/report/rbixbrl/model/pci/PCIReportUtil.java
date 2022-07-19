package in.armedu.banking.report.rbixbrl.model.pci;

import java.util.List;
import in.armedu.banking.report.rbixbrl.model.pci.*;

public class PCIReportUtil {
    
    public static String retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(List<CustomerCreditLimitAxis> fieldList, String TypeOfProblemCreditAndInvestmentCustomerAxis, String type, String subType ) {
        if(fieldList == null ) return "";
        CustomerCreditLimitAxis fieldObj = (CustomerCreditLimitAxis) fieldList.stream().filter(p -> p.getType().toString().equals(type)).findAny().orElse(null);
        if(fieldObj != null) {
            TypeOfProblemCreditAndInvestmentCustomerAxis subFieldObj = (TypeOfProblemCreditAndInvestmentCustomerAxis) fieldObj.getTypeOfProblemCreditAndInvestmentCustomerAxis().stream().filter(p -> p.getType().toString().equals(subType)).findAny().get();
            return subFieldObj.getValue();
        } else {
            return "";
        }
        
    }
    
        public static String retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(List<TypeOfProblemCreditAndInvestmentCustomerAxis> fieldList, String type ) {
            if(fieldList == null) return "";
            TypeOfProblemCreditAndInvestmentCustomerAxis fieldObj = (TypeOfProblemCreditAndInvestmentCustomerAxis) fieldList.stream().filter(p -> p.getType().toString().equals(type)).findAny().orElse(null);
            return fieldObj == null ? "" : fieldObj.getValue();
        }

    
    
}

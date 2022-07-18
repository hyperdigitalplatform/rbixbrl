package in.armedu.banking.report.rbixbrl.model.pci;

import java.util.List;
import in.armedu.banking.report.rbixbrl.model.pci.*;

public class PCIReportUtil {
    
    public static String retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(List<CustomerCreditLimitAxis> fieldList, String TypeOfProblemCreditAndInvestmentCustomerAxis, String type, String subType ) {
        CustomerCreditLimitAxis fieldObj = (CustomerCreditLimitAxis) fieldList.stream().filter(p -> p.getType().toString().equals(type)).findAny().get();
        TypeOfProblemCreditAndInvestmentCustomerAxis subFieldObj = (TypeOfProblemCreditAndInvestmentCustomerAxis) fieldObj.getTypeOfProblemCreditAndInvestmentCustomerAxis().stream().filter(p -> p.getType().toString().equals(subType)).findAny().get();
        return subFieldObj.getValue();
    }
    
        public static String retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(List<TypeOfProblemCreditAndInvestmentCustomerAxis> fieldList, String type ) {
            TypeOfProblemCreditAndInvestmentCustomerAxis fieldObj = (TypeOfProblemCreditAndInvestmentCustomerAxis) fieldList.stream().filter(p -> p.getType().toString().equals(type)).findAny().get();
            return fieldObj.getValue();
        }

    
    
}

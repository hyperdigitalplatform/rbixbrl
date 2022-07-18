package in.armedu.banking.report.rbixbrl.model.pci;

import java.util.List;
import in.armedu.banking.report.rbixbrl.model.pci.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerCreditLimitAxis {
    
    private CustomerCreditLimitAxisEnum type;
    private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis;
    
    
}

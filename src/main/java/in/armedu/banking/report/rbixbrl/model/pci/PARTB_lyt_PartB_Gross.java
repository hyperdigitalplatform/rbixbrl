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
public class PARTB_lyt_PartB_Gross {
    
    
            private String countryCode;
        
            private String branchCode;
        
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfBookValueOfCreditSanctioned;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfMarketValueOfCreditSanctioned;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfProvisionsHeldAtBranch;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfProvisionsHeldAtHeadOffice;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> aggregateAmountOfProvision;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfProvisionRequiredToBeHeldByRegulatoryAuthorities;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfShortFall;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfHeadOfficeSupportFund;
     
}

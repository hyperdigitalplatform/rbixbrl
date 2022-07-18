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
public class PARTA_lyt_PartA_Gross {
    
    
            private String countryCode;
        
            private String branchCode;
        
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> aggregateAmountOfLimitsSanctioned;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfFundedLimitsSanctioned;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfNonFundedLimitsSanctioned;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOutstandingOfCustomerCreditLimitSenctioned;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> securityValue;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfProvisionsHeldAtBranch;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfProvisionsHeldAtHeadOffice;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfInterestSuspense;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> aggregateAmountOfProvisionAndInterestSuspense;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfProvisionRequiredToBeHeldByRegulatoryAuthorities;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfShortFall;
    
        private List<TypeOfProblemCreditAndInvestmentCustomerAxis> amountOfHeadOfficeSupportFund;
     
}

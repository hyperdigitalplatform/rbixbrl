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
public class PARTA_lyt_PartA_Sect2 {
    
    
            private String countryCode;
        
            private String branchCode;
        
        private List<CustomerCreditLimitAxis> aggregateAmountOfLimitsSanctioned;
    
        private List<CustomerCreditLimitAxis> amountOfFundedLimitsSanctioned;
    
        private List<CustomerCreditLimitAxis> amountOfNonFundedLimitsSanctioned;
    
        private List<CustomerCreditLimitAxis> amountOutstandingOfCustomerCreditLimitSenctioned;
    
        private List<CustomerCreditLimitAxis> securityValue;
    
        private List<CustomerCreditLimitAxis> amountOfProvisionsHeldAtBranch;
    
        private List<CustomerCreditLimitAxis> amountOfProvisionsHeldAtHeadOffice;
    
        private List<CustomerCreditLimitAxis> amountOfInterestSuspense;
    
        private List<CustomerCreditLimitAxis> aggregateAmountOfProvisionAndInterestSuspense;
    
        private List<CustomerCreditLimitAxis> amountOfProvisionRequiredToBeHeldByRegulatoryAuthorities;
    
        private List<CustomerCreditLimitAxis> amountOfShortFall;
    
        private List<CustomerCreditLimitAxis> amountOfHeadOfficeSupportFund;
    
        private List<CustomerCreditLimitAxis> developmentsDuringQuarter;
     
}

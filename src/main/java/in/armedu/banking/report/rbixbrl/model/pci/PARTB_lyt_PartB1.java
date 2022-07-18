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
public class PARTB_lyt_PartB1 {
    
    
            private String countryCode;
        
            private String branchCode;
        
            private String nameOfIssuer;
        
            private String issuerGroupName;
        
        private List<CustomerCreditLimitAxis> soverignCharacter;
    
        private List<CustomerCreditLimitAxis> categoryOfBorrower;
    
        private List<CustomerCreditLimitAxis> amountOfBookValueOfCreditSanctioned;
    
        private List<CustomerCreditLimitAxis> amountOfMarketValueOfCreditSanctioned;
    
        private List<CustomerCreditLimitAxis> assetsClassification;
    
        private List<CustomerCreditLimitAxis> amountOfProvisionsHeldAtBranch;
    
        private List<CustomerCreditLimitAxis> amountOfProvisionsHeldAtHeadOffice;
    
        private List<CustomerCreditLimitAxis> aggregateAmountOfProvision;
    
        private List<CustomerCreditLimitAxis> amountOfProvisionRequiredToBeHeldByRegulatoryAuthorities;
    
        private List<CustomerCreditLimitAxis> amountOfShortFall;
    
        private List<CustomerCreditLimitAxis> amountOfHeadOfficeSupportFund;
    
        private List<CustomerCreditLimitAxis> developmentsDuringQuarter;
     
}

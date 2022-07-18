package in.armedu.banking.report.rbixbrl.model.rle;

import java.util.List;
import in.armedu.banking.report.rbixbrl.model.rle.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SectionIII_lyt_1_Section3 {
    
    
            private String countryCode;
        
            private String branchCode;
        
        private List<InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis> investmentsInLocalGovernments;
    
        private List<InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis> investmentsInIndia;
    
        private List<InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis> investmentsInOECDCountries;
    
        private List<InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis> otherInvestments;
    
        private List<InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis> aggregateOfCategoriesOfInvestments;
     
}

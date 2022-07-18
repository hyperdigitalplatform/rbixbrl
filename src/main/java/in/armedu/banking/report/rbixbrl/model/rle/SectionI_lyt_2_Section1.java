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
public class SectionI_lyt_2_Section1 {
    
    
            private String countryCode;
        
            private String branchCode;
        
        private List<TypeOfSectionAxis> aggregateAmountOfLimitsSanctioned;
    
        private List<TypeOfSectionAxis> amountOfFundedLimitsSanctioned;
    
        private List<TypeOfSectionAxis> amountOfNonFundedLimitsSanctioned;
    
        private List<TypeOfSectionAxis> amountOutstanding;
    
        private List<TypeOfSectionAxis> securityValue;
     
}

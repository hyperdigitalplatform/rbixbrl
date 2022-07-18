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
public class SectionII_lyt_1_Section2 {
    
    
            private String countryCode;
        
            private String branchCode;
        
            private String nameOfBorrower;
        
        private List<TypeOfSectionAxis> borrowerGroupName;
    
        private List<TypeOfSectionAxis> registrationNumber;
    
        private List<TypeOfSectionAxis> categoryOfBorrower;
    
        private List<TypeOfSectionAxis> sovereignCharacter;
    
        private List<TypeOfSectionAxis> aggregateAmountOfLimitsSanctioned;
    
        private List<TypeOfSectionAxis> amountOfFundedLimitsSanctioned;
    
        private List<TypeOfSectionAxis> amountOfNonFundedLimitsSanctioned;
    
        private List<TypeOfSectionAxis> amountOutstanding;
    
        private List<TypeOfSectionAxis> securityValue;
    
        private List<TypeOfSectionAxis> assetsClassification;
     
}

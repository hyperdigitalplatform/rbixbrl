package in.armedu.banking.report.rbixbrl.model.cpr;

import in.armedu.banking.report.rbixbrl.model.ItemData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CPRItemData extends ItemData {
    private LargeExposureToIndividualBorrower largeExposuresToIndividualBorrower;
    private LargeExposureToBorrowerGroup largeExposureToBorrowerGroup;    
}

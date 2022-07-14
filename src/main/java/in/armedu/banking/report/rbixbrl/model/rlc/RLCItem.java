package in.armedu.banking.report.rbixbrl.model.rlc;

import in.armedu.banking.report.rbixbrl.model.ItemData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class RLCItem extends ItemData {
 
    private RLCIndividualMember rlcIndividualMember;
    private RLCBorrowerGroupMember rlcBorrowerGroupMember;
    private RLCCounterPartyDomestic rlcCounterPartyDomestic;
    private RLCCounterPartyGlobal rlcCounterPartyGlobal;
    
}

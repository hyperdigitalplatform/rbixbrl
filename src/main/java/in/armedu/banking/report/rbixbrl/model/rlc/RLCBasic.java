package in.armedu.banking.report.rbixbrl.model.rlc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

//RLC Items fields

public class RLCBasic {
    
    private String regionOfBusinessAxis;
    private String largeCreditAxis;
    private String uniqueTransactionCodeAxis;
    private String industryCodeAxis;
    private String industryNameAxis;
    private String leadBankNameAxis;
    private String groupBorrowerCode;
    private String groupAxis;
    private String counterPartyBankNameAxis;
    private String counterPartyBankDomicileAxis;

}

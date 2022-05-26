package in.armedu.banking.report.rbixbrl.model.cpr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ExposureToUnsecure {
    private String outstandingUnsecuredGuarantees;
    private String outstandingUnsecuredAdvances;
    private String totalOutstandingAdvances;
    private String totalUnsecuredOutstanding;

}

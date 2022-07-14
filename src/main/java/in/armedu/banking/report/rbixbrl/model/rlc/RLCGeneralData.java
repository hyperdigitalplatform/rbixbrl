package in.armedu.banking.report.rbixbrl.model.rlc;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class RLCGeneralData extends GeneralData {
    
    //Report Details
    private String returnName;
    private String returnCode;
    private String nameOfReportingInstitution;
    private String bankCode;
    private String address;
    private String reportForTheYearEnded;                //End Date
    private String reportingFrequency;
    private String reportStatus;
    private String whetherNilReporting;
    private String categoriesOfBanks;
    private String returnVersion;
    private String generalRemarks;
    private String reportingPeriodStartDate;               //Start Date
    private String regulatoryCapital;
    private String capitalInfusion;
    private String lastEndDate;             //LastYearEndDate

    //Signatory Details
    private RLCGeneralInfo rlcGeneralInfo;
    private RLCGeneralIndividual rlcGeneralIndividual;
    private RLCGeneralBorrowerGroup rlcGeneralBorrowerGroup;
    private RLCGeneralCounterDomestic rlcGeneralCounterDomestic;
    private RLCGeneralCounterGlobal rlcGeneralCounterGlobal;

}

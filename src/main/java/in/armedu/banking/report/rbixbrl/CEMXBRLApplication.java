package in.armedu.banking.report.rbixbrl;

import java.io.FileWriter;
import java.io.StringWriter;

import in.armedu.banking.report.rbixbrl.core.ReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.core.ReportGenerationFactory;
import in.armedu.banking.report.rbixbrl.core.impl.XBRLReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.model.cem.CEMGeneralData;
import in.armedu.banking.report.rbixbrl.model.cem.CEMReportData;
import in.armedu.banking.report.rbixbrl.model.cem.CEMItemData;

public class CEMXBRLApplication {
    
    public static void main(String[] args) throws Exception {
        CEMReportData data = new CEMReportData();
    
        CEMGeneralData cemGeneralData = new CEMGeneralData();
        cemGeneralData.setReturnName("Report on Country Exposures and Maturity");
        cemGeneralData.setReturnCode("CEM");
        cemGeneralData.setNameOfReportingInstitution("State Bank Of India");
        cemGeneralData.setBankCode("010");
        cemGeneralData.setReportingDate("2019-03-31"); 
        cemGeneralData.setReportingFrequency("Quarterly"); 
        cemGeneralData.setDateOfReport("2019-08-01");          
        cemGeneralData.setReportStatus("Un-Audited");         
        cemGeneralData.setValidationStatus("Validated"); 
        cemGeneralData.setReturnVersion("V1.3");          
        cemGeneralData.setToolName("iFile");
        cemGeneralData.setReportingPeriodStartDate("2019-01-01");

    
        //CEM SignatoryDetails 
        cemGeneralData.setNameOfSignatory("EWIEI");
        cemGeneralData.setDesignationOfSignatory("JHDSOUDUSDUS");
        cemGeneralData.setAuthorisedSignatoryMobileNumber("8538538535");
        cemGeneralData.setAuthorisedSignatoryLandlineNumber("8518518515");
        cemGeneralData.setEMailIDOfAuthorisedReportingOfficial("xjsdfhfds@n.com");
        cemGeneralData.setPlaceOfSignature("dfsdfuiosu");
        cemGeneralData.setDateOfSigning("2019-06-24");
    
    
        data.setGeneralData(cemGeneralData);
    
    
        // CEM Item
    
        CEMItemData cemItemDataInsignificantMember = new CEMItemData();
    
        //Item Data for General Context
        cemItemDataInsignificantMember.setRiskClassificationAxis("InsignificantMember");
        cemItemDataInsignificantMember.setCountryCodeAxis("IN");
        cemItemDataInsignificantMember.setBranchCodeAxis("558");
        cemItemDataInsignificantMember.setExposureCountryCodeAxis("BF");

        //item data for body
        cemItemDataInsignificantMember.setAmountOfCountryExposureBetweenSixMonthMember("4014720000");
        cemItemDataInsignificantMember.setAmountOfCountryExposureOverSixMonthsAndUptoOneYearMember("4026670000");
        cemItemDataInsignificantMember.setAmountOfCountryExposureOverOneYearAndUptoFiveYearMember("4037670000");
        cemItemDataInsignificantMember.setAmountOfCountryExposureOverFiveYearsMember("4048670000");
        cemItemDataInsignificantMember.setAmountOfCountryExposureRiskClassification("16127730000");

        CEMItemData cemItemDataLowRiskMember= new CEMItemData();
    
        //Item Data for General Context
        cemItemDataLowRiskMember.setRiskClassificationAxis("LowRiskMember");
        cemItemDataLowRiskMember.setCountryCodeAxis("IN");
        cemItemDataLowRiskMember.setBranchCodeAxis("558");
        cemItemDataLowRiskMember.setExposureCountryCodeAxis("BF");

        //item data for body
        cemItemDataLowRiskMember.setAmountOfCountryExposureBetweenSixMonthMember("4029440000");
        cemItemDataLowRiskMember.setAmountOfCountryExposureOverSixMonthsAndUptoOneYearMember("4041390000");
        cemItemDataLowRiskMember.setAmountOfCountryExposureOverOneYearAndUptoFiveYearMember("4052390000");
        cemItemDataLowRiskMember.setAmountOfCountryExposureOverFiveYearsMember("4063390000");
        cemItemDataLowRiskMember.setAmountOfCountryExposureRiskClassification("16186610000");

        data.getItemDatas().add(cemItemDataInsignificantMember);
        data.getItemDatas().add(cemItemDataLowRiskMember);
        
        ReportGenerationEngine engine = new XBRLReportGenerationEngine();
        StringWriter sw = engine.execute(ReportGenerationFactory.RBI_CEM_XBRL_REPORT, data);
        FileWriter fw = new FileWriter("reports/cem-instance.xml");
        fw.write(sw.toString());
        fw.close();
            
        }

}

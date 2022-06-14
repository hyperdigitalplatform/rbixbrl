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
        cemGeneralData.setReturnName("Asset Liability Exposure (Overseas)");
        cemGeneralData.setReturnCode("ALO");
        cemGeneralData.setNameOfReportingInstitution("Lead Bank-Others");
        cemGeneralData.setBankCode("444");
        cemGeneralData.setReportingDate("dfgdg"); 
        cemGeneralData.setReportingFrequency("Quarterly"); 
        cemGeneralData.setDateOfReport("2019-08-01");          
        cemGeneralData.setReportStatus("Audited");         
        cemGeneralData.setValidationStatus("Validated"); 
        cemGeneralData.setReturnVersion("V1.3");          
        cemGeneralData.setToolName("dfgdgdgf");
        cemGeneralData.setReportingPeriodStartDate("2019-04-01");

    
        //CEM SignatoryDetails 
        cemGeneralData.setNameOfSignatory("EWIEI");
        cemGeneralData.setDesignationOfSignatory("JHDSOUDUSDUS");
        cemGeneralData.setAuthorisedSignatoryMobileNumber("8538538535");
        cemGeneralData.setAuthorisedSignatoryLandlineNumber("8518518515");
        cemGeneralData.setEMailIDOfAuthorisedReportingOfficial("xjsdfhfds@n.com");
        cemGeneralData.setPlaceOfSignature("dfsdfuiosu");
        cemGeneralData.setDateOfDocumentAuthorisation("2019-06-24");
    
    
        data.setGeneralData(cemGeneralData);
    
    
        // CEM Item
    
        CEMItemData cemItemData = new CEMItemData();
    
        //Item Data for General Context
        cemItemData.setRiskClassificationAxis("InsignificantMember");
        cemItemData.setMaturityPeriodAxis("OverOneYearAndUptoFiveYearMember");
        cemItemData.setCountryCodeAxis("IN");
        cemItemData.setBranchCodeAxis("558");
        cemItemData.setExposureCountryCodeAxis("BF");

        //item data for body
        cemItemData.setAmountOfCountryExposure("4037670000");

        // //Item Data for General Context
        // cemItemData.setRiskClassificationAxis("");
        // cemItemData.setMaturityPeriodAxis("");
        // cemItemData.setCountryCodeAxis("");
        // cemItemData.setBranchCodeAxis("");
        // cemItemData.setExposureCountryCodeAxis("");

        // //item data for body
        // cemItemData.setAmountOfCountryExposure("");

        // //Item Data for General Context
        // cemItemData.setRiskClassificationAxis("");
        // cemItemData.setMaturityPeriodAxis("");
        // cemItemData.setCountryCodeAxis("");
        // cemItemData.setBranchCodeAxis("");
        // cemItemData.setExposureCountryCodeAxis("");

        // //item data for body
        // cemItemData.setAmountOfCountryExposure("");

        // //Item Data for General Context
        // cemItemData.setRiskClassificationAxis("");
        // cemItemData.setMaturityPeriodAxis("");
        // cemItemData.setCountryCodeAxis("");
        // cemItemData.setBranchCodeAxis("");
        // cemItemData.setExposureCountryCodeAxis("");

        // //item data for body
        // cemItemData.setAmountOfCountryExposure("");

        // //Item Data for General Context
        // cemItemData.setRiskClassificationAxis("");
        // cemItemData.setMaturityPeriodAxis("");
        // cemItemData.setCountryCodeAxis("");
        // cemItemData.setBranchCodeAxis("");
        // cemItemData.setExposureCountryCodeAxis("");

        // //item data for body
        // cemItemData.setAmountOfCountryExposure("");

        // //Item Data for General Context
        // cemItemData.setRiskClassificationAxis("");
        // cemItemData.setMaturityPeriodAxis("");
        // cemItemData.setCountryCodeAxis("");
        // cemItemData.setBranchCodeAxis("");
        // cemItemData.setExposureCountryCodeAxis("");

        // //item data for body
        // cemItemData.setAmountOfCountryExposure("");

        // //Item Data for General Context
        // cemItemData.setRiskClassificationAxis("");
        // cemItemData.setMaturityPeriodAxis("");
        // cemItemData.setCountryCodeAxis("");
        // cemItemData.setBranchCodeAxis("");
        // cemItemData.setExposureCountryCodeAxis("");

        // //item data for body
        // cemItemData.setAmountOfCountryExposure("");
                 
        data.getItemDatas().add(aloItemData);

        
        ReportGenerationEngine engine = new XBRLReportGenerationEngine();
        StringWriter sw = engine.execute(ReportGenerationFactory.RBI_CEM_XBRL_REPORT, data);
        FileWriter fw = new FileWriter("file.txt");
        fw.write(sw.toString());
        fw.close();
            
        }

}

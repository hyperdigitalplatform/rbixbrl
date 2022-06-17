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
        cemItemDataLowRiskMember.setExposureCountryCodeAxis("AF");

        //item data for body
        cemItemDataLowRiskMember.setAmountOfCountryExposureBetweenSixMonthMember("4029440000");
        cemItemDataLowRiskMember.setAmountOfCountryExposureOverSixMonthsAndUptoOneYearMember("4041390000");
        cemItemDataLowRiskMember.setAmountOfCountryExposureOverOneYearAndUptoFiveYearMember("4052390000");
        cemItemDataLowRiskMember.setAmountOfCountryExposureOverFiveYearsMember("4063390000");
        cemItemDataLowRiskMember.setAmountOfCountryExposureRiskClassification("16186610000");

        CEMItemData cemItemDataModeratelyLowMember= new CEMItemData();
    
        //Item Data for General Context
        cemItemDataModeratelyLowMember.setRiskClassificationAxis("ModeratelyLowMember");
        cemItemDataModeratelyLowMember.setCountryCodeAxis("IN");
        cemItemDataModeratelyLowMember.setBranchCodeAxis("558");
        cemItemDataModeratelyLowMember.setExposureCountryCodeAxis("BA");

        //item data for body
        cemItemDataModeratelyLowMember.setAmountOfCountryExposureBetweenSixMonthMember("4044160000");
        cemItemDataModeratelyLowMember.setAmountOfCountryExposureOverSixMonthsAndUptoOneYearMember("4056110000");
        cemItemDataModeratelyLowMember.setAmountOfCountryExposureOverOneYearAndUptoFiveYearMember("4067110000");
        cemItemDataModeratelyLowMember.setAmountOfCountryExposureOverFiveYearsMember("4078110000");
        cemItemDataModeratelyLowMember.setAmountOfCountryExposureRiskClassification("16245490000");

        CEMItemData cemItemDataModerateRiskMember= new CEMItemData();
    
        //Item Data for General Context
        cemItemDataModerateRiskMember.setRiskClassificationAxis("ModerateRiskMember");
        cemItemDataModerateRiskMember.setCountryCodeAxis("IN");
        cemItemDataModerateRiskMember.setBranchCodeAxis("558");
        cemItemDataModerateRiskMember.setExposureCountryCodeAxis("AT");

        //item data for body
        cemItemDataModerateRiskMember.setAmountOfCountryExposureBetweenSixMonthMember("4058880000");
        cemItemDataModerateRiskMember.setAmountOfCountryExposureOverSixMonthsAndUptoOneYearMember("4070830000");
        cemItemDataModerateRiskMember.setAmountOfCountryExposureOverOneYearAndUptoFiveYearMember("4081830000");
        cemItemDataModerateRiskMember.setAmountOfCountryExposureOverFiveYearsMember("4092830000");
        cemItemDataModerateRiskMember.setAmountOfCountryExposureRiskClassification("16304370000");

        CEMItemData cemItemDataVeryHighMember= new CEMItemData();
    
        //Item Data for General Context
        cemItemDataVeryHighMember.setRiskClassificationAxis("VeryHighMember");
        cemItemDataVeryHighMember.setCountryCodeAxis("IN");
        cemItemDataVeryHighMember.setBranchCodeAxis("558");
        cemItemDataVeryHighMember.setExposureCountryCodeAxis("DZ");

        //item data for body
        cemItemDataVeryHighMember.setAmountOfCountryExposureBetweenSixMonthMember("4073600000");
        cemItemDataVeryHighMember.setAmountOfCountryExposureOverSixMonthsAndUptoOneYearMember("4085550000");
        cemItemDataVeryHighMember.setAmountOfCountryExposureOverOneYearAndUptoFiveYearMember("4096550000");
        cemItemDataVeryHighMember.setAmountOfCountryExposureOverFiveYearsMember("4107550000");
        cemItemDataVeryHighMember.setAmountOfCountryExposureRiskClassification("16363250000");

        CEMItemData cemItemDataHighRiskMember= new CEMItemData();
    
        //Item Data for General Context
        cemItemDataHighRiskMember.setRiskClassificationAxis("HighRiskMember");
        cemItemDataHighRiskMember.setCountryCodeAxis("AU");
        cemItemDataHighRiskMember.setBranchCodeAxis("138");
        cemItemDataHighRiskMember.setExposureCountryCodeAxis("AF");

        //item data for body
        cemItemDataHighRiskMember.setAmountOfCountryExposureBetweenSixMonthMember("4147990000");
        cemItemDataHighRiskMember.setAmountOfCountryExposureOverSixMonthsAndUptoOneYearMember("4158990000");
        cemItemDataHighRiskMember.setAmountOfCountryExposureOverOneYearAndUptoFiveYearMember("4169990000");
        cemItemDataHighRiskMember.setAmountOfCountryExposureOverFiveYearsMember("4180990000");
        cemItemDataHighRiskMember.setAmountOfCountryExposureRiskClassification("16657960000");

        CEMItemData cemItemDataModeratelyHighMember= new CEMItemData();
    
        //Item Data for General Context
        cemItemDataModeratelyHighMember.setRiskClassificationAxis("ModeratelyHighMember");
        cemItemDataModeratelyHighMember.setCountryCodeAxis("AU");
        cemItemDataModeratelyHighMember.setBranchCodeAxis("138");
        cemItemDataModeratelyHighMember.setExposureCountryCodeAxis("AL");

        //item data for body
        cemItemDataModeratelyHighMember.setAmountOfCountryExposureBetweenSixMonthMember("4162710000");
        cemItemDataModeratelyHighMember.setAmountOfCountryExposureOverSixMonthsAndUptoOneYearMember("4173710000");
        cemItemDataModeratelyHighMember.setAmountOfCountryExposureOverOneYearAndUptoFiveYearMember("4184710000");
        cemItemDataModeratelyHighMember.setAmountOfCountryExposureOverFiveYearsMember("4195710000");
        cemItemDataModeratelyHighMember.setAmountOfCountryExposureRiskClassification("16716840000");

        data.getItemDatas().add(cemItemDataInsignificantMember);
        data.getItemDatas().add(cemItemDataLowRiskMember);
        data.getItemDatas().add(cemItemDataModeratelyLowMember);
        data.getItemDatas().add(cemItemDataModerateRiskMember);
        data.getItemDatas().add(cemItemDataVeryHighMember);
        data.getItemDatas().add(cemItemDataModeratelyHighMember);
                
        ReportGenerationEngine engine = new XBRLReportGenerationEngine();
        StringWriter sw = engine.execute(ReportGenerationFactory.RBI_CEM_XBRL_REPORT, data);
        FileWriter fw = new FileWriter("reports/cem-instance.xml");
        fw.write(sw.toString());
        fw.close();
            
        }

}

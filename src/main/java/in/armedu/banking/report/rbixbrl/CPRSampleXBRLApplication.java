package in.armedu.banking.report.rbixbrl;

import java.io.FileWriter;
import java.io.StringWriter;

import in.armedu.banking.report.rbixbrl.core.ReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.core.ReportGenerationFactory;
import in.armedu.banking.report.rbixbrl.core.impl.XBRLReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.model.cpr.BorrowerGroup;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRGeneralData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRGeneralFinancialForConsolidated;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRReportData;
import in.armedu.banking.report.rbixbrl.model.cpr.CRRAndSLR;
import in.armedu.banking.report.rbixbrl.model.cpr.CapitalMarketExposure;
import in.armedu.banking.report.rbixbrl.model.cpr.ExposureToUnsecure;
import in.armedu.banking.report.rbixbrl.model.cpr.ForexExposure;
import in.armedu.banking.report.rbixbrl.model.cpr.GroupCompany;
import in.armedu.banking.report.rbixbrl.model.cpr.IndividualBorrower;
import in.armedu.banking.report.rbixbrl.model.cpr.LargeExposureToBorrowerGroup;
import in.armedu.banking.report.rbixbrl.model.cpr.LargeExposureToIndividualBorrower;

public class CPRSampleXBRLApplication {
    public static void main(String[] args) throws Exception {
        CPRReportData data = new CPRReportData();
        CPRGeneralData genInfoData = new CPRGeneralData();
        genInfoData.setBankCode("600");
        genInfoData.setInstitutionAddress("Punjab National Bank corporate office dwarka");
        genInfoData.setReportInstitution("Punjab National Bank");
        genInfoData.setReportingFrequency("HalfYearly");
        genInfoData.setReturnCode("ROS");
        genInfoData.setReturnName("Report on Subsidiaries");
        genInfoData.setReturnVersion("v1.2");
        genInfoData.setStartDate("2021-04-01");
        genInfoData.setEndDate("2021-09-30");
        genInfoData.setDateOfReport("2021-09-30");
        genInfoData.setReportForTheYearEnded("2018-03-31");
        genInfoData.setValidationStatus("validated");
        // set CPRGeneralFinancialForConsolidated
        CPRGeneralFinancialForConsolidated cprGFForConslidated = new CPRGeneralFinancialForConsolidated();
        cprGFForConslidated.setAssets("12935763752000");
        genInfoData.setFinancialForConsolidated(cprGFForConslidated);
        
        
        CPRItemData cprItemData = new CPRItemData();
        // changes are done to add amountfunded and amount nonfunded
        LargeExposureToIndividualBorrower individualBorrower = new LargeExposureToIndividualBorrower();
        LargeExposureToBorrowerGroup borrowerGroup = new LargeExposureToBorrowerGroup();
        IndividualBorrower ib = new IndividualBorrower();
        ib.setPanNumber("AAACF0365N");
        ib.setBorrowerName("FOOD CORPORATION OF INDIA");
        ib.setIndustryCode("51201");
        ib.setIndustryName("Wholesale Food Procurement");
        ib.setSector("10-Public-central government");
        ib.setAmountFunded("142500000000");
        ib.setAmountNonFunded("0");
        ib.setExposureAsPercToCapitalFunds("0.1586");
        individualBorrower.getIndividualBorrowers().add(ib);
        IndividualBorrower ib2 = new IndividualBorrower();
        ib2.setPanNumber("AAACT4053B");
        ib2.setBorrowerName("THE COTTON CORPORATION OF INDIA LIMITED");
        ib2.setIndustryCode("51401");
        ib2.setIndustryName("Wholesale Cotton");
        ib2.setSector("10-Public-central government");
        ib2.setAmountFunded("111000000000");
        ib2.setAmountNonFunded("0");
        ib2.setExposureAsPercToCapitalFunds("0.1235");
        individualBorrower.getIndividualBorrowers().add(ib2);
        individualBorrower.setTotalAmountFunded("1475662873000");
        individualBorrower.setTotalAmountNonFunded("30765676000");
        individualBorrower.setTotalExposureAsPercToCapitalFunds(".16762");
        cprItemData.setLargeExposuresToIndividualBorrower(individualBorrower);
        
        BorrowerGroup bg = new BorrowerGroup();
        bg.setBorrowerGroupName("NTPC");
        GroupCompany gc = new GroupCompany();
        gc.setGroupCompanyName("NTPC LIMITED");
        gc.setAmountFunded("66602138000");
        gc.setAmountNonFunded("0");
        gc.setExposureAsPercToCapitalFunds("0.0741");
        bg.getGroupCompanies().add(gc);
        GroupCompany gc1 = new GroupCompany();
        gc1.setGroupCompanyName("HINDUSTAN URVARAK & RASAYAN LIMITED");
        gc1.setAmountFunded("29639788000");
        gc1.setAmountNonFunded("1000000");
        gc1.setExposureAsPercToCapitalFunds(".0330");
        bg.getGroupCompanies().add(gc1);
        bg.setTotalAmountFunded("116020092000");
        bg.setTotalAmountNonFunded("190172000");
        bg.setTotalExposureAsPercToCapitalFunds("0.1294");
        borrowerGroup.getBorrowerGroups().add(bg);
        //cprItemData.setLargeExposureToBorrowerGroup(borrowerGroup);
        BorrowerGroup bg1 = new BorrowerGroup();
        bg1.setBorrowerGroupName("ONGC");
        GroupCompany agc = new GroupCompany();
        agc.setGroupCompanyName("ONGC PETRO ADDITIONS LIMITED");
        agc.setAmountFunded("19566867000");
        agc.setAmountNonFunded("0");
        agc.setExposureAsPercToCapitalFunds(".0218");
        bg1.getGroupCompanies().add(agc);
        GroupCompany agc1 = new GroupCompany();
        agc1.setGroupCompanyName("ONGC VIDESH LIMITED");
        agc1.setAmountFunded("14103700000");
        agc1.setAmountNonFunded("0");
        agc1.setExposureAsPercToCapitalFunds("0.0157");
        bg1.getGroupCompanies().add(agc1);
        bg1.setTotalAmountFunded("55237775000");
        bg1.setTotalAmountNonFunded("3078200000");
        bg1.setTotalExposureAsPercToCapitalFunds("0.0649");
        
        borrowerGroup.getBorrowerGroups().add(bg1);
        borrowerGroup.setTotalAmountFunded("1649747541000");
        borrowerGroup.setTotalAmountNonFunded("51806128000");
        borrowerGroup.setTotalExposureAsPercToCapitalFunds("0.18935");
        cprItemData.setLargeExposureToBorrowerGroup(borrowerGroup);
        // set forex exposure
        ForexExposure forexEx = new ForexExposure();
        forexEx.setOpenPosition("1012666000");
        genInfoData.setForexExposure(forexEx);
        // capital market exposure
        CapitalMarketExposure capitalMarketEx = new CapitalMarketExposure();
        capitalMarketEx.setAdvances("33842872000");
        capitalMarketEx.setFundBased("30553272000");
        capitalMarketEx.setNonFundBased("3289600000");
        capitalMarketEx.setEquityInvestment("38719200000");
        capitalMarketEx.setTotalExposure("72562072000");
        capitalMarketEx.setEquityInvestmentPerc("0");
        capitalMarketEx.setNetWorth("0");
        genInfoData.setCapitalMarketExposure(capitalMarketEx);
        // exposure to capital market
        ExposureToUnsecure exToUnsecure = new ExposureToUnsecure();
        exToUnsecure.setOutstandingUnsecuredGuarantees("257919300000");
        exToUnsecure.setOutstandingUnsecuredAdvances("2155909844000");
        exToUnsecure.setTotalOutstandingAdvances("7444318987000");
        exToUnsecure.setTotalUnsecuredOutstanding("0.3243");
        genInfoData.setExposureToUnsecure(exToUnsecure);
        
        // CRR and SLR
        CRRAndSLR crrAndSLR = new CRRAndSLR();
        crrAndSLR.setCashFundEligibleForCRR("464852500000");
        crrAndSLR.setLiquidAssetsEligibleForSLR("1303857400000");
        crrAndSLR.setPercCRR("0.04");
        crrAndSLR.setPercSLR(".3054");
        genInfoData.setCrrAndSLR(crrAndSLR);
        // set data
        data.setGeneralData(genInfoData);
        data.getItemDatas().add(cprItemData);
        ReportGenerationEngine engine = new XBRLReportGenerationEngine();
        StringWriter sw = engine.execute(ReportGenerationFactory.RBI_CPR_XBRL_REPORT, data);
        FileWriter fw = new FileWriter("file.txt");
        fw.write(sw.toString());
        fw.close();

        
    }
    
}

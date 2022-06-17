package in.armedu.banking.report.rbixbrl;

import java.io.FileWriter;
import java.io.StringWriter;

import in.armedu.banking.report.rbixbrl.core.ReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.core.ReportGenerationFactory;
import in.armedu.banking.report.rbixbrl.core.impl.XBRLReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.model.alo.ALOGeneralData;
import in.armedu.banking.report.rbixbrl.model.alo.ALOReportData;
import in.armedu.banking.report.rbixbrl.model.alo.ALOItemData;


public class ALOXBRLApplication {
public static void main(String[] args) throws Exception {
    ALOReportData data = new ALOReportData();

    ALOGeneralData aloGeneralData = new ALOGeneralData();
    aloGeneralData.setReturnName("Asset Liability Exposure (Overseas)");
    aloGeneralData.setReturnCode("ALO");
    aloGeneralData.setNameOfReportingInstitution("Lead Bank-Others");
    aloGeneralData.setBankCode("444");
    aloGeneralData.setAddress("dfgdg");
    aloGeneralData.setDateOfQuarterEnded("2019-06-30");   
    aloGeneralData.setReportingFrequency("Quarterly"); 
    aloGeneralData.setDateOfReport("2019-08-01");          
    aloGeneralData.setReportStatus("Audited");     
    aloGeneralData.setDateOfAudit("2019-07-04");           
    aloGeneralData.setValidationStatus("Validated"); 
    aloGeneralData.setReturnVersion("V1.3");          
    aloGeneralData.setGeneralRemarks("dfgdgdgf");
    aloGeneralData.setReportingPeriodStartDate("2019-04-01");

    aloGeneralData.setDocumentaryCreditsCommitted("10376960000");
    aloGeneralData.setDocumentaryCreditsCommittedIssuedOnClientAccount("5181120000");
    aloGeneralData.setDocumentaryCreditsCommittedIssuedOnBanksAccount("5195840000");
    aloGeneralData.setPaymentGuaranteesOrAcceptances("5210560000");
    aloGeneralData.setPerformanceGuaranteesIssued("5225280000");
    aloGeneralData.setLoanCommitments("5240000000");
    aloGeneralData.setOffBalanceSheetExposures("26052800000");
    aloGeneralData.setOutstandingForexContracts("5193070000");
    aloGeneralData.setOutstandingInterestRateSwaps("5207790000");
    aloGeneralData.setForwardRateAgreements("5222510000");
    aloGeneralData.setOtherFutureAndForwardContracts("5237230000");
    aloGeneralData.setCurrencyOptionsBought("5251950000");
    aloGeneralData.setCurrencyOptionsWritten("5266670000");
    aloGeneralData.setOtherOffBalanceSheetExposure("5281390000");
    aloGeneralData.setAggregateOffBalanceSheetExposures("36660610000");

           //ALOSignatoryDetails 
    aloGeneralData.setNameOfSignatory("sdafasf");
    aloGeneralData.setDesignationOfSignatory("dsfsdf");
    aloGeneralData.setAuthorisedSignatoryMobileNumber("1234678915");
    aloGeneralData.setAuthorisedSignatoryLandlineNumber("1213455555");
    aloGeneralData.setEMailIDOfAuthorisedReportingOfficial("fsfads@sdf.com");
    aloGeneralData.setPlaceOfSignature("fsafd");
    aloGeneralData.setDateOfDocumentAuthorisation("2019-07-24");


    data.setGeneralData(aloGeneralData);


    // ALO Item

    ALOItemData aloItemData = new ALOItemData();

     //Item Data for General Context
     //aloItemData.setReportingPeriodAxis("OneToTwentyEightDaysMember");
    //  aloItemData.setDetailsOfAccountsWithBranchesAxis("AccountsWithOtherBranchesMember");
    //  aloItemData.setPeriodOfPendingReconcilliationAxis("OverThreeMonthsAndUptoSixMonthsMember");
     aloItemData.setCountryCodeAxis("IN");
     aloItemData.setBranchCodeAxis("548");
 
     //Item Data for General Body
     aloItemData.setCashAndBalancesWithCentralBanks("4504000000");
     aloItemData.setInvestmentsInSecurities("18163200000");
     aloItemData.setInvestmentsInLocalGovernments("4518720000");
     aloItemData.setInvestmentsInIndia("4533440000");
     aloItemData.setInvestmentsInOECDCountries("4548160000");
     aloItemData.setOtherInvestments("4562880000");
     aloItemData.setInterBranchPlacementsOrDeposits("13776960000");
     aloItemData.setInterBranchPlacementsOrDepositsWithBranchesInSameForeignCentre("4577600000");
     aloItemData.setInterBranchPlacementsOrDepositsWithBranchesInOtherForeignCentre("4592320000");
     aloItemData.setInterBranchPlacementsOrDepositsWithIndiaBranches("4607040000");
     aloItemData.setInterBankPlacementsOrDeposits("9258240000");
     aloItemData.setInterBankPlacementsOrDepositsInCurrentAccounts("4621760000");
     aloItemData.setInterBankPlacementsInOtherDeposits("4636480000");
     aloItemData.setGrossCustomerCredit("61613760000");
     aloItemData.setLoansOrOverdrafts("56785920000");
     aloItemData.setLoansAgainstDepositsOrSecuritiesHeldIn("4651200000");
     aloItemData.setLoansAgainstLCOrLOCByHeadOffice("4665920000");
     aloItemData.setLoansToIndianPSU("18810880000");
     aloItemData.setShortTermFacilitiesByBank("4680640000");
     aloItemData.setBankerAcceptanceFacilities("4695360000");
     aloItemData.setSyndicatedLoans("4710080000");
     aloItemData.setOtherLoansToIndianPSU("4724800000");
     aloItemData.setOtherIndiaRelatedFundedExposures("4739520000");
     aloItemData.setSovereignLoans("9523200000");
     aloItemData.setLoansToProblemCountries("4754240000");
     aloItemData.setOtherSovereignLoans("4768960000");
     aloItemData.setRealEstateExposures("4783680000");
     aloItemData.setCommercialLoans("4798400000");
     aloItemData.setOtherLoans("4813120000");
     aloItemData.setBillsPurchasedAndDiscounted("4827840000");
     aloItemData.setNettingItems("9699840000");
     aloItemData.setProvisions("4842560000");
     aloItemData.setInterestSuspense("4857280000");
     aloItemData.setNetCustomerCredit("51913920000");
     aloItemData.setAccumulatedLosses("4872000000");
     aloItemData.setOtherAssets("4886720000");
     aloItemData.setAggregateAssets("107375040000");
     aloItemData.setHeadOfficeFunds("19694080000");
     aloItemData.setAssignedCapital("4901440000");
     aloItemData.setSupportFunds("4916160000");
     aloItemData.setEarningsRetained("4930880000");
     aloItemData.setOtherFunds("4945600000");
     aloItemData.setCustomerDeposits("9935360000");
     aloItemData.setCustomerDepositsInCurrentAccounts("4960320000");
     aloItemData.setCustomerDepositsInOtherAccounts("4975040000");
     aloItemData.setInterBranchBorrowingsOrDeposits("15013440000");
     aloItemData.setInterBranchBorrowingsOrDepositsWithBranchesInSameForeign("4989760000");
     aloItemData.setInterBranchBorrowingsOrDepositswithBranchesInOtherForeign("5004480000");
     aloItemData.setInterBranchBorrowingsOrDepositsWithIndiaBranches("5019200000");
     aloItemData.setInterBankBorrowings("10082560000");
     aloItemData.setInterBankBorrowingsInCurrentAccount("5033920000");
     aloItemData.setInterBankBorrowingsInOtherDeposits("5048640000");
     aloItemData.setOtherDebtInstruments("5063360000");
     aloItemData.setOtherLiabilities("10170880000");
     aloItemData.setGeneralProvision("5078080000");
     aloItemData.setMiscellaneousLiabilities("5092800000");
     aloItemData.setAggregateLiabilities("69959680000");
     aloItemData.setAggregateCapital("37415360000");
     aloItemData.setAggregateForwardRateAgreements("5107520000");
     aloItemData.setSwaps("5122240000");
     aloItemData.setFutures("5136960000");
     aloItemData.setOptions("5151680000");
     aloItemData.setOtherProducts("5166400000");
     aloItemData.setAggregateOtherProducts("25684800000");
     aloItemData.setNetGap("63100160000");
     aloItemData.setCumulativeGap("63100160000");
     aloItemData.setNetGapAsPercentageOfAggregateAssets("0.5877");
     aloItemData.setDebitNumberOfEntriesInAccount("17");
     aloItemData.setDebitAmountOfEntriesInAccount("5205020000");
     aloItemData.setCreditNumberOfEntriesInAccount("45");
     aloItemData.setCreditAmountOfEntriesInAccount("5216970000");
             
       data.getItemDatas().add(aloItemData);

     
        ReportGenerationEngine engine = new XBRLReportGenerationEngine();
        StringWriter sw = engine.execute(ReportGenerationFactory.RBI_ALO_XBRL_REPORT, data);
        FileWriter fw = new FileWriter("reports/alo-instance.xml");
        fw.write(sw.toString());
        fw.close();
        
    }
    
}


package in.armedu.banking.report.rbixbrl.part.ros.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.AreaOfOperationOfRelatedPartyItemTypeROS;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.PureItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;
import org.xbrl.dtr.type.non_numeric.DomainItemType;
import org.xbrl.dtr.type.numeric.PercentItemType;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.ros.ROSGeneralInfoData;
import in.armedu.banking.report.rbixbrl.model.ros.ROSItem;
import in.armedu.banking.report.rbixbrl.part.BodyIntf;
import in.armedu.banking.report.rbixbrl.util.CommonFns;


public class ROSBody implements BodyIntf {

    @Override
    public List<Object> getReportBodyItem(List<Context> contexts, GeneralData generalData) {
        // TODO Auto-generated method stub
        return null;
    }

    


    @Override
    public List<Object> getReportBodyItem(List<Context> contexts, List<Unit> units, GeneralData generalData,   ItemData itemData) {
                
        ROSGeneralInfoData generalInfoData = (ROSGeneralInfoData) generalData;
        ROSItem rosItem = (ROSItem) itemData;

        return getReportBodyItemOnlyForFromToAndASOF(contexts.get(0), contexts.get(1), contexts.get(2), contexts.get(3), units.get(0), units.get(1), generalInfoData, rosItem);
    }


    public List<Object> getReportBodyItemOnlyForFromToAndASOF(Context fromToContext, Context asOfContext, Context bookValueContext, Context marketValueContext, Unit unitINR, Unit pureUnit, ROSGeneralInfoData generalInfoData, ROSItem rosItem) {
           
        List<Object> bodyItems = new ArrayList<Object>();
        

        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
        

        // create subsidiary category
        DomainItemType domainItemType = new DomainItemType();
        domainItemType.setContextRef(fromToContext);
        domainItemType.setValue(rosItem.getSubsidiaryInfo().getCategory());
        JAXBElement<DomainItemType> subsidiaryCategory = rbiObjectFactory.createSubsidiaryJointVentureAssociateMember(domainItemType);
        bodyItems.add(subsidiaryCategory);
        
        // create AreaOfOperationOfRelatedParty
        AreaOfOperationOfRelatedPartyItemTypeROS relatedPartyType = new AreaOfOperationOfRelatedPartyItemTypeROS();
        relatedPartyType.setContextRef(fromToContext);
        relatedPartyType.setValue(rosItem.getSubsidiaryInfo().getAreaOfOperations());
        JAXBElement<AreaOfOperationOfRelatedPartyItemTypeROS> relatedParty = rbiObjectFactory.createAreaOfOperationOfRelatedParty(relatedPartyType);
        bodyItems.add(relatedParty);
        // create SubsidiaryAssociateJointVentureCode
        StringItemType ventureCodeType = new StringItemType();
        ventureCodeType.setContextRef(fromToContext);
        ventureCodeType.setValue(rosItem.getSubsidiaryInfo().getSubsidiaryCode());
        JAXBElement<StringItemType> ventureCode = rbiObjectFactory.createSubsidiaryAssociateJointVentureCode(ventureCodeType);      
        bodyItems.add(ventureCode);

        //Create SubsidiaryAssociateJointVentureName

        StringItemType ventureNameType = new StringItemType();
        ventureNameType.setContextRef(fromToContext);
        ventureNameType.setValue(rosItem.getSubsidiaryInfo().getSubsidiaryName());
        JAXBElement<StringItemType> jointVentureName = rbiObjectFactory.createSubsidiaryAssociateJointVentureName(ventureNameType);
        bodyItems.add(jointVentureName);


        //Create AcitivityName
        StringItemType rosActivityNameType = new StringItemType();
        rosActivityNameType.setContextRef(fromToContext);
        rosActivityNameType.setValue(rosItem.getSubsidiaryInfo().getActivityName());
        JAXBElement<StringItemType> activityName = rbiObjectFactory.createActivityName(rosActivityNameType);
        bodyItems.add(activityName);

        //Create Part A partAFinancialParameters
        //Create Part A AggregateAssets
        MonetaryItemType aggregateAssetsType = new MonetaryItemType();
        aggregateAssetsType.setContextRef(asOfContext);
        aggregateAssetsType.setUnitRef(unitINR);
        aggregateAssetsType.setDecimals( String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getTotalAssets() ) )  );
        aggregateAssetsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getTotalAssets()));
        JAXBElement<MonetaryItemType> aggregateAssets = rbiObjectFactory.createAggregateAssets(aggregateAssetsType);
        bodyItems.add(aggregateAssets);
        // create capitalfund
        MonetaryItemType capitalFundType = new MonetaryItemType();
        capitalFundType.setContextRef(asOfContext);
        capitalFundType.setUnitRef(unitINR);
        capitalFundType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getCapitalFunds() ) )  );
        capitalFundType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getCapitalFunds()));
        JAXBElement<MonetaryItemType> capitalFund = rbiObjectFactory.createCapitalFund(capitalFundType);
        bodyItems.add(capitalFund);
        // create minimumCapitalPrescribedByRegulators
        MonetaryItemType minCapitalPrescribedByRegulatorType = new MonetaryItemType();
        minCapitalPrescribedByRegulatorType.setContextRef(asOfContext);
        minCapitalPrescribedByRegulatorType.setUnitRef(unitINR);
        minCapitalPrescribedByRegulatorType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getMinPrescribedCapital() ) )  );
        minCapitalPrescribedByRegulatorType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getMinPrescribedCapital()));
        JAXBElement<MonetaryItemType> minCapitalPrescribedByRegulator = rbiObjectFactory.createMinimumCapitalPrescribedByRegulators(minCapitalPrescribedByRegulatorType);
        bodyItems.add(minCapitalPrescribedByRegulator);

        // create MinimumCapitalAdequacyRatioPrescribedByRegulators
        PercentItemType minimumCapitalAdequacyRatioPrescribedByRegulatorsType = new PercentItemType();
        minimumCapitalAdequacyRatioPrescribedByRegulatorsType.setContextRef(asOfContext);
        minimumCapitalAdequacyRatioPrescribedByRegulatorsType.setUnitRef(pureUnit);
        minimumCapitalAdequacyRatioPrescribedByRegulatorsType.setDecimals("2");
        minimumCapitalAdequacyRatioPrescribedByRegulatorsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getMinPrescribedCapitalPercentage()));
        JAXBElement<PercentItemType> minimumCapitalAdequacyRatioPrescribedByRegulators = rbiObjectFactory.createMinimumCapitalAdequacyRatioPrescribedByRegulators(minimumCapitalAdequacyRatioPrescribedByRegulatorsType);
        bodyItems.add(minimumCapitalAdequacyRatioPrescribedByRegulators);
        // create CapitalAdequacyRatio
        PercentItemType capitalAdequacyRatioType = new PercentItemType();
        capitalAdequacyRatioType.setContextRef(asOfContext);
        capitalAdequacyRatioType.setUnitRef(pureUnit);
        capitalAdequacyRatioType.setDecimals("2");
        capitalAdequacyRatioType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getCapitalAdequacyRatio()));
        JAXBElement<PercentItemType> capitalAdequacyRatio = rbiObjectFactory.createCapitalAdequacyRatio(capitalAdequacyRatioType);
        bodyItems.add(capitalAdequacyRatio);
        // create NotionalCapitalFunds
        MonetaryItemType notionalCapitalFundsType = new MonetaryItemType();
        notionalCapitalFundsType.setContextRef(asOfContext);
        notionalCapitalFundsType.setUnitRef(unitINR);
        notionalCapitalFundsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getNotionalCapitalFunds() ) )  );
        notionalCapitalFundsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getNotionalCapitalFunds()));
        JAXBElement<MonetaryItemType> notionalCapitalFunds = rbiObjectFactory.createNotionalCapitalFunds(notionalCapitalFundsType);
        bodyItems.add(notionalCapitalFunds);
        // create RiskWeightedAssets
        MonetaryItemType riskWeightedAssetsType = new MonetaryItemType();
        riskWeightedAssetsType.setContextRef(asOfContext);
        riskWeightedAssetsType.setUnitRef(unitINR);
        riskWeightedAssetsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getRiskWeightedAssets() ) )  );
        riskWeightedAssetsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getRiskWeightedAssets()));
        JAXBElement<MonetaryItemType> riskWeightedAssets = rbiObjectFactory.createRiskWeightedAssets(riskWeightedAssetsType);
        bodyItems.add(riskWeightedAssets);
        // create NotionalCapitalAdequacyRatio
        PercentItemType notionalCapitalAdequacyRatioType = new PercentItemType();
        notionalCapitalAdequacyRatioType.setContextRef(asOfContext);
        notionalCapitalAdequacyRatioType.setUnitRef(pureUnit);
        notionalCapitalAdequacyRatioType.setDecimals("2");
        notionalCapitalAdequacyRatioType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getCapitalAdequacyRatio()));
        JAXBElement<PercentItemType> notionalCapitalAdequacyRatio = rbiObjectFactory.createNotionalCapitalAdequacyRatio(notionalCapitalAdequacyRatioType);
        bodyItems.add(notionalCapitalAdequacyRatio);
        // create CapitalAndReserves
        MonetaryItemType capitalAndReservesType = new MonetaryItemType();
        capitalAndReservesType.setContextRef(asOfContext);
        capitalAndReservesType.setUnitRef(unitINR);
        capitalAndReservesType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getCapitalAndReservesAsInTheBalanceSheet() ) )  );
        capitalAndReservesType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getCapitalAndReservesAsInTheBalanceSheet()));
        JAXBElement<MonetaryItemType> capitalAndReserves = rbiObjectFactory.createCapitalAndReserves(capitalAndReservesType);
        bodyItems.add(capitalAndReserves);        
        // create Deposits
        MonetaryItemType depositsType = new MonetaryItemType();
        depositsType.setContextRef(asOfContext);
        depositsType.setUnitRef(unitINR);
        depositsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getTotalDeposits() ) )  );
        depositsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getTotalDeposits()));
        JAXBElement<MonetaryItemType> deposits = rbiObjectFactory.createDeposits(depositsType);
        bodyItems.add(deposits);        
        // create Borrowings
        MonetaryItemType borrowingsType = new MonetaryItemType();
        borrowingsType.setContextRef(asOfContext);
        borrowingsType.setUnitRef(unitINR);
        borrowingsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getTotalBorrowings() ) )  );
        borrowingsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getTotalBorrowings()));
        JAXBElement<MonetaryItemType> borrowings = rbiObjectFactory.createBorrowings(borrowingsType);
        bodyItems.add(borrowings);        
        // create ProfitLossBeforeTax
        MonetaryItemType profitLossBeforeTaxType = new MonetaryItemType();
        profitLossBeforeTaxType.setContextRef(fromToContext);
        profitLossBeforeTaxType.setUnitRef(unitINR);
        profitLossBeforeTaxType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getProfitBeforeTax() ) )  );
        profitLossBeforeTaxType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getProfitBeforeTax()));
        JAXBElement<MonetaryItemType> profitLossBeforeTax = rbiObjectFactory.createProfitLossBeforeTax(profitLossBeforeTaxType);
        bodyItems.add(profitLossBeforeTax);        
        // create NetProfitLossAfterTax
        MonetaryItemType netProfitLossAfterTaxType = new MonetaryItemType();
        netProfitLossAfterTaxType.setContextRef(fromToContext);
        netProfitLossAfterTaxType.setUnitRef(unitINR);
        netProfitLossAfterTaxType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getProfitAfterTaxOrReturn() ) )  );
        netProfitLossAfterTaxType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getProfitAfterTaxOrReturn()));
        JAXBElement<MonetaryItemType> netProfitLossAfterTax = rbiObjectFactory.createNetProfitLossAfterTax(netProfitLossAfterTaxType);
        bodyItems.add(netProfitLossAfterTax);        

        // create SurplusLossOnProfitAndLossAccountCarriedForward
        MonetaryItemType surplusLossOnProfitAndLossAccountCarriedForwardType = new MonetaryItemType();
        surplusLossOnProfitAndLossAccountCarriedForwardType.setContextRef(fromToContext);
        surplusLossOnProfitAndLossAccountCarriedForwardType.setUnitRef(unitINR);
        surplusLossOnProfitAndLossAccountCarriedForwardType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getSurplusOrLossOnProfitAndLossACCarriedForward() ) )  );
        surplusLossOnProfitAndLossAccountCarriedForwardType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getSurplusOrLossOnProfitAndLossACCarriedForward()));
        JAXBElement<MonetaryItemType> surplusLossOnProfitAndLossAccountCarriedForward = rbiObjectFactory.createSurplusLossOnProfitAndLossAccountCarriedForward(surplusLossOnProfitAndLossAccountCarriedForwardType);
        bodyItems.add(surplusLossOnProfitAndLossAccountCarriedForward);        
        // create ReturnOnAssets
        PercentItemType returnOnAssetsType = new PercentItemType();
        returnOnAssetsType.setContextRef(fromToContext);
        returnOnAssetsType.setUnitRef(pureUnit);
        returnOnAssetsType.setDecimals("2");
        returnOnAssetsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getReturnOnAssets()));
        JAXBElement<PercentItemType> returnOnAssets = rbiObjectFactory.createReturnOnAssets(returnOnAssetsType);
        bodyItems.add(returnOnAssets);
        // create ReturnOnEquity
        PercentItemType ReturnOnEquityType = new PercentItemType();
        ReturnOnEquityType.setContextRef(fromToContext);
        ReturnOnEquityType.setUnitRef(pureUnit);
        ReturnOnEquityType.setDecimals("2");
        ReturnOnEquityType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getReturnOnEquity()));
        JAXBElement<PercentItemType> ReturnOnEquity = rbiObjectFactory.createReturnOnEquity(ReturnOnEquityType);
        bodyItems.add(ReturnOnEquity);
        // create DividendPaid
        MonetaryItemType dividendPaidType = new MonetaryItemType();
        dividendPaidType.setContextRef(asOfContext);
        dividendPaidType.setUnitRef(unitINR);
        dividendPaidType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getTotalDividendsPaid() ) )  );
        dividendPaidType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getTotalDividendsPaid()));
        JAXBElement<MonetaryItemType> dividendPaid = rbiObjectFactory.createDividendPaid(dividendPaidType);
        bodyItems.add(dividendPaid);
        // create LoansAdvancesGross
        MonetaryItemType loansAdvancesGrossType = new MonetaryItemType();
        loansAdvancesGrossType.setContextRef(asOfContext);
        loansAdvancesGrossType.setUnitRef(unitINR);
        loansAdvancesGrossType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getLoansAndAdvancesGross() ) )  );
        loansAdvancesGrossType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getLoansAndAdvancesGross()));
        JAXBElement<MonetaryItemType> loansAdvancesGross = rbiObjectFactory.createLoansAdvancesGross(loansAdvancesGrossType);
        bodyItems.add(loansAdvancesGross);
        // create NonPerformingLoansGross
        MonetaryItemType nonPerformingLoansGrossType = new MonetaryItemType();
        nonPerformingLoansGrossType.setContextRef(asOfContext);
        nonPerformingLoansGrossType.setUnitRef(unitINR);
        nonPerformingLoansGrossType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getNonPerformingLoansGross() ) )  );
        nonPerformingLoansGrossType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getNonPerformingLoansGross()));
        JAXBElement<MonetaryItemType> nonPerformingLoansGross = rbiObjectFactory.createNonPerformingLoansGross(nonPerformingLoansGrossType);
        bodyItems.add(nonPerformingLoansGross);
        // create ProvisionsHeldAgainstNonPerformingLoans
        MonetaryItemType provisionsHeldAgainstNonPerformingLoansType = new MonetaryItemType();
        provisionsHeldAgainstNonPerformingLoansType.setContextRef(fromToContext);
        provisionsHeldAgainstNonPerformingLoansType.setUnitRef(unitINR);
        provisionsHeldAgainstNonPerformingLoansType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getProvisionsHeldAgainstNonPerformingLoans() ) )  );
        provisionsHeldAgainstNonPerformingLoansType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getProvisionsHeldAgainstNonPerformingLoans()));
        JAXBElement<MonetaryItemType> provisionsHeldAgainstNonPerformingLoans = rbiObjectFactory.createProvisionsHeldAgainstNonPerformingLoans(provisionsHeldAgainstNonPerformingLoansType);
        bodyItems.add(provisionsHeldAgainstNonPerformingLoans);
        // create ProvisionsRequiredAgainstNonPerformingLoans
        MonetaryItemType provisionsRequiredAgainstNonPerformingLoansType = new MonetaryItemType();
        provisionsRequiredAgainstNonPerformingLoansType.setContextRef(fromToContext);
        provisionsRequiredAgainstNonPerformingLoansType.setUnitRef(unitINR);
        provisionsRequiredAgainstNonPerformingLoansType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getProvisionsRequiredAgainstNonPerformingLoans() ) )  );
        provisionsRequiredAgainstNonPerformingLoansType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getProvisionsRequiredAgainstNonPerformingLoans()));
        JAXBElement<MonetaryItemType> provisionsRequiredAgainstNonPerformingLoans = rbiObjectFactory.createProvisionsRequiredAgainstNonPerformingLoans(provisionsRequiredAgainstNonPerformingLoansType);
        bodyItems.add(provisionsRequiredAgainstNonPerformingLoans);
        // create Investments for BookValue
        MonetaryItemType investmentsBookValueType = new MonetaryItemType();
        investmentsBookValueType.setContextRef(bookValueContext);
        investmentsBookValueType.setUnitRef(unitINR);
        investmentsBookValueType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getTotalInvestmentBookValue() ) )  );
        investmentsBookValueType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getTotalInvestmentBookValue()));
        JAXBElement<MonetaryItemType> investmentsBookValue = rbiObjectFactory.createInvestments(investmentsBookValueType);
        bodyItems.add(investmentsBookValue);
        // create Investments for MarketValue
        MonetaryItemType investmentsMarketValueType = new MonetaryItemType();
        investmentsMarketValueType.setContextRef(marketValueContext);
        investmentsMarketValueType.setUnitRef(unitINR);
        investmentsMarketValueType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getTotalInvestmentMarketValue() ) )  );
        investmentsMarketValueType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getTotalInvestmentMarketValue()));
        JAXBElement<MonetaryItemType> investmentsMarketValue = rbiObjectFactory.createInvestments(investmentsMarketValueType);
        bodyItems.add(investmentsMarketValue);
        // create NonPerformingInvestments
        MonetaryItemType nonPerformingInvestmentsType = new MonetaryItemType();
        nonPerformingInvestmentsType.setContextRef(asOfContext);
        nonPerformingInvestmentsType.setUnitRef(unitINR);
        nonPerformingInvestmentsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getNonPerformingInvestments() ) )  );
        nonPerformingInvestmentsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getNonPerformingInvestments()));
        JAXBElement<MonetaryItemType> nonPerformingInvestments = rbiObjectFactory.createNonPerformingInvestments(nonPerformingInvestmentsType);
        bodyItems.add(nonPerformingInvestments);
        // create ProvisionsHeldAgainstNonPerformingInvestments
        MonetaryItemType provisionsHeldAgainstNonPerformingInvestmentsType = new MonetaryItemType();
        provisionsHeldAgainstNonPerformingInvestmentsType.setContextRef(fromToContext);
        provisionsHeldAgainstNonPerformingInvestmentsType.setUnitRef(unitINR);
        provisionsHeldAgainstNonPerformingInvestmentsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getProvisionsHeldAgainstNonPerformingInvestments() ) )  );
        provisionsHeldAgainstNonPerformingInvestmentsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getProvisionsHeldAgainstNonPerformingInvestments()));
        JAXBElement<MonetaryItemType> provisionsHeldAgainstNonPerformingInvestments = rbiObjectFactory.createProvisionsHeldAgainstNonPerformingInvestments(provisionsHeldAgainstNonPerformingInvestmentsType);
        bodyItems.add(provisionsHeldAgainstNonPerformingInvestments);
        // create ProvisionsRequiredAgainstNonPerformingInvestments
        MonetaryItemType provisionsRequiredAgainstNonPerformingInvestmentsType = new MonetaryItemType();
        provisionsRequiredAgainstNonPerformingInvestmentsType.setContextRef(fromToContext);
        provisionsRequiredAgainstNonPerformingInvestmentsType.setUnitRef(unitINR);
        provisionsRequiredAgainstNonPerformingInvestmentsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getProvisionsRequiredAgainstNonPerformingInvestments() ) )  );
        provisionsRequiredAgainstNonPerformingInvestmentsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getProvisionsRequiredAgainstNonPerformingInvestments()));
        JAXBElement<MonetaryItemType> provisionsRequiredAgainstNonPerformingInvestments = rbiObjectFactory.createProvisionsRequiredAgainstNonPerformingInvestments(provisionsRequiredAgainstNonPerformingInvestmentsType);
        bodyItems.add(provisionsRequiredAgainstNonPerformingInvestments);
        // create OffBalanceSheetExposuresContingentLiabilities
        MonetaryItemType offBalanceSheetExposuresContingentLiabilitiesType = new MonetaryItemType();
        offBalanceSheetExposuresContingentLiabilitiesType.setContextRef(asOfContext);
        offBalanceSheetExposuresContingentLiabilitiesType.setUnitRef(unitINR);
        offBalanceSheetExposuresContingentLiabilitiesType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getContingentLiabilitiesOrOffBalanceSheetExposures() ) )  );
        offBalanceSheetExposuresContingentLiabilitiesType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getContingentLiabilitiesOrOffBalanceSheetExposures()));
        JAXBElement<MonetaryItemType> offBalanceSheetExposuresContingentLiabilities = rbiObjectFactory.createOffBalanceSheetExposuresContingentLiabilities(offBalanceSheetExposuresContingentLiabilitiesType);
        bodyItems.add(offBalanceSheetExposuresContingentLiabilities);
        // create NumberOfCounterparties
        PureItemType numberOfCounterpartiesType = new PureItemType();
        numberOfCounterpartiesType.setContextRef(fromToContext);
        numberOfCounterpartiesType.setUnitRef(unitINR);
        numberOfCounterpartiesType.setDecimals("INF");
        numberOfCounterpartiesType.setValue(new BigDecimal(rosItem.getPartBExposureAndOwnership().getNoOfCounterparties()));
        JAXBElement<PureItemType> numberOfCounterparties = rbiObjectFactory.createNumberOfCounterparties(numberOfCounterpartiesType);
        bodyItems.add(numberOfCounterparties);
        // create AggregateExposureAmount
        MonetaryItemType aggregateExposureAmountType = new MonetaryItemType();
        aggregateExposureAmountType.setContextRef(asOfContext);
        aggregateExposureAmountType.setUnitRef(unitINR);
        aggregateExposureAmountType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartBExposureAndOwnership().getAggregateExposureAmount() ) )  );
        aggregateExposureAmountType.setValue(new BigDecimal(rosItem.getPartBExposureAndOwnership().getAggregateExposureAmount()));
        JAXBElement<MonetaryItemType> aggregateExposureAmount = rbiObjectFactory.createAggregateExposureAmount(aggregateExposureAmountType);
        bodyItems.add(aggregateExposureAmount);
        // create AggregateExposurePercentageOfCapitalFunds
        PercentItemType aggregateExposurePercentageOfCapitalFundsType = new PercentItemType();
        aggregateExposurePercentageOfCapitalFundsType.setContextRef(asOfContext);
        aggregateExposurePercentageOfCapitalFundsType.setUnitRef(pureUnit);
        aggregateExposurePercentageOfCapitalFundsType.setDecimals("4");
        aggregateExposurePercentageOfCapitalFundsType.setValue(new BigDecimal(rosItem.getPartBExposureAndOwnership().getAggregateExposurePercentage()));
        JAXBElement<PercentItemType> aggregateExposurePercentageOfCapitalFunds = rbiObjectFactory.createAggregateExposurePercentageOfCapitalFunds(aggregateExposurePercentageOfCapitalFundsType);
        bodyItems.add(aggregateExposurePercentageOfCapitalFunds);
        
        // create InvestmentInCapitalByParentCompany
        MonetaryItemType investmentInCapitalByParentCompanyType = new MonetaryItemType();
        investmentInCapitalByParentCompanyType.setContextRef(asOfContext);
        investmentInCapitalByParentCompanyType.setUnitRef(unitINR);
        investmentInCapitalByParentCompanyType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartBExposureAndOwnership().getInvestmentInCapitalByParentBank() ) )  );
        investmentInCapitalByParentCompanyType.setValue(new BigDecimal(rosItem.getPartBExposureAndOwnership().getInvestmentInCapitalByParentBank()));
        JAXBElement<MonetaryItemType> investmentInCapitalByParentCompany = rbiObjectFactory.createInvestmentInCapitalByParentCompany(investmentInCapitalByParentCompanyType);
        bodyItems.add(investmentInCapitalByParentCompany);
        // create PercentageOfSharesHeldByParentBank
        PercentItemType percentageOfSharesHeldByParentBankType = new PercentItemType();
        percentageOfSharesHeldByParentBankType.setContextRef(asOfContext);
        percentageOfSharesHeldByParentBankType.setUnitRef(pureUnit);
        percentageOfSharesHeldByParentBankType.setDecimals("2");
        percentageOfSharesHeldByParentBankType.setValue(new BigDecimal(rosItem.getPartBExposureAndOwnership().getSharesHeldByParentBank()));
        JAXBElement<PercentItemType> percentageOfSharesHeldByParentBank = rbiObjectFactory.createPercentageOfSharesHeldByParentBank(percentageOfSharesHeldByParentBankType);
        bodyItems.add(percentageOfSharesHeldByParentBank);
        
        // create PercentageOfCapitalHeldByParentBankIncludingTierIICapital
        PercentItemType percentageOfCapitalHeldByParentBankIncludingTierIICapitalType = new PercentItemType();
        percentageOfCapitalHeldByParentBankIncludingTierIICapitalType.setContextRef(asOfContext);
        percentageOfCapitalHeldByParentBankIncludingTierIICapitalType.setUnitRef(pureUnit);
        percentageOfCapitalHeldByParentBankIncludingTierIICapitalType.setDecimals("2");
        percentageOfCapitalHeldByParentBankIncludingTierIICapitalType.setValue(new BigDecimal(rosItem.getPartBExposureAndOwnership().getTotalCapitalHeldByParentBank()));
        JAXBElement<PercentItemType> percentageOfCapitalHeldByParentBankIncludingTierIICapital = rbiObjectFactory.createPercentageOfCapitalHeldByParentBankIncludingTierIICapital(percentageOfCapitalHeldByParentBankIncludingTierIICapitalType);
        bodyItems.add(percentageOfCapitalHeldByParentBankIncludingTierIICapital);
        
        return bodyItems;
    }

}

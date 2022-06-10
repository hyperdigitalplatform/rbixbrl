package in.armedu.banking.report.rbixbrl.part.ros.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;


public class ROSBody implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData) {
        return null;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData, ItemData itemData) 
    {
        
        List<Object> bodyItems = new ArrayList<Object>();
        
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        ROSGeneralInfoData generalInfoData = (ROSGeneralInfoData) generalData;
        ROSItem rosItem = (ROSItem) itemData;

        Context fromToContext = contexts.get(ROSUtil.FROMTO);
        Context asOfContext = contexts.get(ROSUtil.ASOF);
        Context fromtocontextsubsidiary = contexts.get(ROSUtil.FROMTOCONTEXTSUBSIDIARY);
        Context asofcontextsubsidiary = contexts.get(ROSUtil.ASOFCONTEXTSUBSIDIARY);
        Context asofbookvaluemember = contexts.get(ROSUtil.ASOFBOOKVALUEMEMBER);
        Context asofmarketvaluemember = contexts.get(ROSUtil.ASOFMARKETVALUEMEMBER);
        Unit currency = units.get(ROSUtil.CURRENCY);
        Unit percentage = units.get(ROSUtil.PERCENTAGE);


        // create subsidiary category
        DomainItemType domainItemType = new DomainItemType();
        domainItemType.setContextRef(fromtocontextsubsidiary);
        domainItemType.setValue(rosItem.getSubsidiaryInfo().getCategory());
        JAXBElement<DomainItemType> subsidiaryCategory = rbiObjectFactory.createSubsidiaryJointVentureAssociateMember(domainItemType);
        bodyItems.add(subsidiaryCategory);
        
        // create AreaOfOperationOfRelatedParty
        AreaOfOperationOfRelatedPartyItemTypeROS relatedPartyType = new AreaOfOperationOfRelatedPartyItemTypeROS();
        relatedPartyType.setContextRef(fromtocontextsubsidiary);
        relatedPartyType.setValue(rosItem.getSubsidiaryInfo().getAreaOfOperations());
        JAXBElement<AreaOfOperationOfRelatedPartyItemTypeROS> relatedParty = rbiObjectFactory.createAreaOfOperationOfRelatedParty(relatedPartyType);
        bodyItems.add(relatedParty);

        // create SubsidiaryAssociateJointVentureCode
        StringItemType ventureCodeType = new StringItemType();
        ventureCodeType.setContextRef(fromtocontextsubsidiary);
        ventureCodeType.setValue(rosItem.getSubsidiaryInfo().getSubsidiaryCode());
        JAXBElement<StringItemType> ventureCode = rbiObjectFactory.createSubsidiaryAssociateJointVentureCode(ventureCodeType);      
        bodyItems.add(ventureCode);

        //Create SubsidiaryAssociateJointVentureName
        StringItemType ventureNameType = new StringItemType();
        ventureNameType.setContextRef(fromtocontextsubsidiary);
        ventureNameType.setValue(rosItem.getSubsidiaryInfo().getSubsidiaryName());
        JAXBElement<StringItemType> jointVentureName = rbiObjectFactory.createSubsidiaryAssociateJointVentureName(ventureNameType);
        bodyItems.add(jointVentureName);

        //Create AcitivityName
        StringItemType rosActivityNameType = new StringItemType();
        rosActivityNameType.setContextRef(fromtocontextsubsidiary);
        rosActivityNameType.setValue(rosItem.getSubsidiaryInfo().getActivityName());
        JAXBElement<StringItemType> activityName = rbiObjectFactory.createActivityName(rosActivityNameType);
        bodyItems.add(activityName);

        //Create Part A partAFinancialParameters
        //Create Part A AggregateAssets
        MonetaryItemType aggregateAssetsType = new MonetaryItemType();
        aggregateAssetsType.setContextRef(asofcontextsubsidiary);
        aggregateAssetsType.setUnitRef(currency);
        aggregateAssetsType.setDecimals( String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getTotalAssets() ) )  );
        aggregateAssetsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getTotalAssets()));
        JAXBElement<MonetaryItemType> aggregateAssets = rbiObjectFactory.createAggregateAssets(aggregateAssetsType);
        bodyItems.add(aggregateAssets);

        // create capitalfund
        MonetaryItemType capitalFundType = new MonetaryItemType();
        capitalFundType.setContextRef(asofcontextsubsidiary);
        capitalFundType.setUnitRef(currency);
        capitalFundType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getCapitalFunds() ) )  );
        capitalFundType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getCapitalFunds()));
        JAXBElement<MonetaryItemType> capitalFund = rbiObjectFactory.createCapitalFund(capitalFundType);
        bodyItems.add(capitalFund);

        // create minimumCapitalPrescribedByRegulators
        MonetaryItemType minCapitalPrescribedByRegulatorType = new MonetaryItemType();
        minCapitalPrescribedByRegulatorType.setContextRef(asofcontextsubsidiary);
        minCapitalPrescribedByRegulatorType.setUnitRef(currency);
        minCapitalPrescribedByRegulatorType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getMinPrescribedCapital() ) )  );
        minCapitalPrescribedByRegulatorType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getMinPrescribedCapital()));
        JAXBElement<MonetaryItemType> minCapitalPrescribedByRegulator = rbiObjectFactory.createMinimumCapitalPrescribedByRegulators(minCapitalPrescribedByRegulatorType);
        bodyItems.add(minCapitalPrescribedByRegulator);

        // create MinimumCapitalAdequacyRatioPrescribedByRegulators
        PercentItemType minimumCapitalAdequacyRatioPrescribedByRegulatorsType = new PercentItemType();
        minimumCapitalAdequacyRatioPrescribedByRegulatorsType.setContextRef(asofcontextsubsidiary);
        minimumCapitalAdequacyRatioPrescribedByRegulatorsType.setUnitRef(percentage);
        minimumCapitalAdequacyRatioPrescribedByRegulatorsType.setDecimals("2");
        minimumCapitalAdequacyRatioPrescribedByRegulatorsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getMinPrescribedCapitalPercentage()));
        JAXBElement<PercentItemType> minimumCapitalAdequacyRatioPrescribedByRegulators = rbiObjectFactory.createMinimumCapitalAdequacyRatioPrescribedByRegulators(minimumCapitalAdequacyRatioPrescribedByRegulatorsType);
        bodyItems.add(minimumCapitalAdequacyRatioPrescribedByRegulators);

        // create CapitalAdequacyRatio
        PercentItemType capitalAdequacyRatioType = new PercentItemType();
        capitalAdequacyRatioType.setContextRef(asofcontextsubsidiary);
        capitalAdequacyRatioType.setUnitRef(percentage);
        capitalAdequacyRatioType.setDecimals("2");
        capitalAdequacyRatioType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getCapitalAdequacyRatio()));
        JAXBElement<PercentItemType> capitalAdequacyRatio = rbiObjectFactory.createCapitalAdequacyRatio(capitalAdequacyRatioType);
        bodyItems.add(capitalAdequacyRatio);

        // create NotionalCapitalFunds
        MonetaryItemType notionalCapitalFundsType = new MonetaryItemType();
        notionalCapitalFundsType.setContextRef(asofcontextsubsidiary);
        notionalCapitalFundsType.setUnitRef(currency);
        notionalCapitalFundsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getNotionalCapitalFunds() ) )  );
        notionalCapitalFundsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getNotionalCapitalFunds()));
        JAXBElement<MonetaryItemType> notionalCapitalFunds = rbiObjectFactory.createNotionalCapitalFunds(notionalCapitalFundsType);
        bodyItems.add(notionalCapitalFunds);

        // create RiskWeightedAssets
        MonetaryItemType riskWeightedAssetsType = new MonetaryItemType();
        riskWeightedAssetsType.setContextRef(asofcontextsubsidiary);
        riskWeightedAssetsType.setUnitRef(currency);
        riskWeightedAssetsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getRiskWeightedAssets() ) )  );
        riskWeightedAssetsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getRiskWeightedAssets()));
        JAXBElement<MonetaryItemType> riskWeightedAssets = rbiObjectFactory.createRiskWeightedAssets(riskWeightedAssetsType);
        bodyItems.add(riskWeightedAssets);

        // create NotionalCapitalAdequacyRatio
        PercentItemType notionalCapitalAdequacyRatioType = new PercentItemType();
        notionalCapitalAdequacyRatioType.setContextRef(asofcontextsubsidiary);
        notionalCapitalAdequacyRatioType.setUnitRef(percentage);
        notionalCapitalAdequacyRatioType.setDecimals("2");
        notionalCapitalAdequacyRatioType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getCapitalAdequacyRatio()));
        JAXBElement<PercentItemType> notionalCapitalAdequacyRatio = rbiObjectFactory.createNotionalCapitalAdequacyRatio(notionalCapitalAdequacyRatioType);
        bodyItems.add(notionalCapitalAdequacyRatio);

        // create CapitalAndReserves
        MonetaryItemType capitalAndReservesType = new MonetaryItemType();
        capitalAndReservesType.setContextRef(asofcontextsubsidiary);
        capitalAndReservesType.setUnitRef(currency);
        capitalAndReservesType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getCapitalAndReservesAsInTheBalanceSheet() ) )  );
        capitalAndReservesType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getCapitalAndReservesAsInTheBalanceSheet()));
        JAXBElement<MonetaryItemType> capitalAndReserves = rbiObjectFactory.createCapitalAndReserves(capitalAndReservesType);
        bodyItems.add(capitalAndReserves);        

        // create Deposits
        MonetaryItemType depositsType = new MonetaryItemType();
        depositsType.setContextRef(asofcontextsubsidiary);
        depositsType.setUnitRef(currency);
        depositsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getTotalDeposits() ) )  );
        depositsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getTotalDeposits()));
        JAXBElement<MonetaryItemType> deposits = rbiObjectFactory.createDeposits(depositsType);
        bodyItems.add(deposits);      

        // create Borrowings
        MonetaryItemType borrowingsType = new MonetaryItemType();
        borrowingsType.setContextRef(asofcontextsubsidiary);
        borrowingsType.setUnitRef(currency);
        borrowingsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getTotalBorrowings() ) )  );
        borrowingsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getTotalBorrowings()));
        JAXBElement<MonetaryItemType> borrowings = rbiObjectFactory.createBorrowings(borrowingsType);
        bodyItems.add(borrowings);        

        // create ProfitLossBeforeTax
        MonetaryItemType profitLossBeforeTaxType = new MonetaryItemType();
        profitLossBeforeTaxType.setContextRef(fromtocontextsubsidiary);
        profitLossBeforeTaxType.setUnitRef(currency);
        profitLossBeforeTaxType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getProfitBeforeTax() ) )  );
        profitLossBeforeTaxType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getProfitBeforeTax()));
        JAXBElement<MonetaryItemType> profitLossBeforeTax = rbiObjectFactory.createProfitLossBeforeTax(profitLossBeforeTaxType);
        bodyItems.add(profitLossBeforeTax);        

        // create NetProfitLossAfterTax
        MonetaryItemType netProfitLossAfterTaxType = new MonetaryItemType();
        netProfitLossAfterTaxType.setContextRef(fromtocontextsubsidiary);
        netProfitLossAfterTaxType.setUnitRef(currency);
        netProfitLossAfterTaxType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getProfitAfterTaxOrReturn() ) )  );
        netProfitLossAfterTaxType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getProfitAfterTaxOrReturn()));
        JAXBElement<MonetaryItemType> netProfitLossAfterTax = rbiObjectFactory.createNetProfitLossAfterTax(netProfitLossAfterTaxType);
        bodyItems.add(netProfitLossAfterTax);        

        // create SurplusLossOnProfitAndLossAccountCarriedForward
        MonetaryItemType surplusLossOnProfitAndLossAccountCarriedForwardType = new MonetaryItemType();
        surplusLossOnProfitAndLossAccountCarriedForwardType.setContextRef(fromtocontextsubsidiary);
        surplusLossOnProfitAndLossAccountCarriedForwardType.setUnitRef(currency);
        surplusLossOnProfitAndLossAccountCarriedForwardType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getSurplusOrLossOnProfitAndLossACCarriedForward() ) )  );
        surplusLossOnProfitAndLossAccountCarriedForwardType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getSurplusOrLossOnProfitAndLossACCarriedForward()));
        JAXBElement<MonetaryItemType> surplusLossOnProfitAndLossAccountCarriedForward = rbiObjectFactory.createSurplusLossOnProfitAndLossAccountCarriedForward(surplusLossOnProfitAndLossAccountCarriedForwardType);
        bodyItems.add(surplusLossOnProfitAndLossAccountCarriedForward);      

        // create ReturnOnAssets
        PercentItemType returnOnAssetsType = new PercentItemType();
        returnOnAssetsType.setContextRef(fromtocontextsubsidiary);
        returnOnAssetsType.setUnitRef(percentage);
        returnOnAssetsType.setDecimals("2");
        returnOnAssetsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getReturnOnAssets()));
        JAXBElement<PercentItemType> returnOnAssets = rbiObjectFactory.createReturnOnAssets(returnOnAssetsType);
        bodyItems.add(returnOnAssets);

        // create ReturnOnEquity
        PercentItemType ReturnOnEquityType = new PercentItemType();
        ReturnOnEquityType.setContextRef(fromtocontextsubsidiary);
        ReturnOnEquityType.setUnitRef(percentage);
        ReturnOnEquityType.setDecimals("2");
        ReturnOnEquityType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getReturnOnEquity()));
        JAXBElement<PercentItemType> ReturnOnEquity = rbiObjectFactory.createReturnOnEquity(ReturnOnEquityType);
        bodyItems.add(ReturnOnEquity);

        // create DividendPaid
        MonetaryItemType dividendPaidType = new MonetaryItemType();
        dividendPaidType.setContextRef(asofcontextsubsidiary);
        dividendPaidType.setUnitRef(currency);
        dividendPaidType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getTotalDividendsPaid() ) )  );
        dividendPaidType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getTotalDividendsPaid()));
        JAXBElement<MonetaryItemType> dividendPaid = rbiObjectFactory.createDividendPaid(dividendPaidType);
        bodyItems.add(dividendPaid);

        // create LoansAdvancesGross
        MonetaryItemType loansAdvancesGrossType = new MonetaryItemType();
        loansAdvancesGrossType.setContextRef(asofcontextsubsidiary);
        loansAdvancesGrossType.setUnitRef(currency);
        loansAdvancesGrossType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getLoansAndAdvancesGross() ) )  );
        loansAdvancesGrossType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getLoansAndAdvancesGross()));
        JAXBElement<MonetaryItemType> loansAdvancesGross = rbiObjectFactory.createLoansAdvancesGross(loansAdvancesGrossType);
        bodyItems.add(loansAdvancesGross);

        // create NonPerformingLoansGross
        MonetaryItemType nonPerformingLoansGrossType = new MonetaryItemType();
        nonPerformingLoansGrossType.setContextRef(asofcontextsubsidiary);
        nonPerformingLoansGrossType.setUnitRef(currency);
        nonPerformingLoansGrossType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getNonPerformingLoansGross() ) )  );
        nonPerformingLoansGrossType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getNonPerformingLoansGross()));
        JAXBElement<MonetaryItemType> nonPerformingLoansGross = rbiObjectFactory.createNonPerformingLoansGross(nonPerformingLoansGrossType);
        bodyItems.add(nonPerformingLoansGross);

        // create ProvisionsHeldAgainstNonPerformingLoans
        MonetaryItemType provisionsHeldAgainstNonPerformingLoansType = new MonetaryItemType();
        provisionsHeldAgainstNonPerformingLoansType.setContextRef(fromtocontextsubsidiary);
        provisionsHeldAgainstNonPerformingLoansType.setUnitRef(currency);
        provisionsHeldAgainstNonPerformingLoansType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getProvisionsHeldAgainstNonPerformingLoans() ) )  );
        provisionsHeldAgainstNonPerformingLoansType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getProvisionsHeldAgainstNonPerformingLoans()));
        JAXBElement<MonetaryItemType> provisionsHeldAgainstNonPerformingLoans = rbiObjectFactory.createProvisionsHeldAgainstNonPerformingLoans(provisionsHeldAgainstNonPerformingLoansType);
        bodyItems.add(provisionsHeldAgainstNonPerformingLoans);

        // create ProvisionsRequiredAgainstNonPerformingLoans
        MonetaryItemType provisionsRequiredAgainstNonPerformingLoansType = new MonetaryItemType();
        provisionsRequiredAgainstNonPerformingLoansType.setContextRef(fromtocontextsubsidiary);
        provisionsRequiredAgainstNonPerformingLoansType.setUnitRef(currency);
        provisionsRequiredAgainstNonPerformingLoansType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getProvisionsRequiredAgainstNonPerformingLoans() ) )  );
        provisionsRequiredAgainstNonPerformingLoansType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getProvisionsRequiredAgainstNonPerformingLoans()));
        JAXBElement<MonetaryItemType> provisionsRequiredAgainstNonPerformingLoans = rbiObjectFactory.createProvisionsRequiredAgainstNonPerformingLoans(provisionsRequiredAgainstNonPerformingLoansType);
        bodyItems.add(provisionsRequiredAgainstNonPerformingLoans);

        // create Investments for BookValue
        MonetaryItemType investmentsBookValueType = new MonetaryItemType();
        investmentsBookValueType.setContextRef(asofcontextsubsidiary);
        investmentsBookValueType.setUnitRef(currency);
        investmentsBookValueType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getTotalInvestmentBookValue() ) )  );
        investmentsBookValueType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getTotalInvestmentBookValue()));
        JAXBElement<MonetaryItemType> investmentsBookValue = rbiObjectFactory.createInvestments(investmentsBookValueType);
        bodyItems.add(investmentsBookValue);

        // create Investments for MarketValue
        MonetaryItemType investmentsMarketValueType = new MonetaryItemType();
        investmentsMarketValueType.setContextRef(asofcontextsubsidiary);
        investmentsMarketValueType.setUnitRef(currency);
        investmentsMarketValueType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getTotalInvestmentMarketValue() ) )  );
        investmentsMarketValueType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getTotalInvestmentMarketValue()));
        JAXBElement<MonetaryItemType> investmentsMarketValue = rbiObjectFactory.createInvestments(investmentsMarketValueType);
        bodyItems.add(investmentsMarketValue);

        // create NonPerformingInvestments
        MonetaryItemType nonPerformingInvestmentsType = new MonetaryItemType();
        nonPerformingInvestmentsType.setContextRef(asofcontextsubsidiary);
        nonPerformingInvestmentsType.setUnitRef(currency);
        nonPerformingInvestmentsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getNonPerformingInvestments() ) )  );
        nonPerformingInvestmentsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getNonPerformingInvestments()));
        JAXBElement<MonetaryItemType> nonPerformingInvestments = rbiObjectFactory.createNonPerformingInvestments(nonPerformingInvestmentsType);
        bodyItems.add(nonPerformingInvestments);

        // create ProvisionsHeldAgainstNonPerformingInvestments
        MonetaryItemType provisionsHeldAgainstNonPerformingInvestmentsType = new MonetaryItemType();
        provisionsHeldAgainstNonPerformingInvestmentsType.setContextRef(fromtocontextsubsidiary);
        provisionsHeldAgainstNonPerformingInvestmentsType.setUnitRef(currency);
        provisionsHeldAgainstNonPerformingInvestmentsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getProvisionsHeldAgainstNonPerformingInvestments() ) )  );
        provisionsHeldAgainstNonPerformingInvestmentsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getProvisionsHeldAgainstNonPerformingInvestments()));
        JAXBElement<MonetaryItemType> provisionsHeldAgainstNonPerformingInvestments = rbiObjectFactory.createProvisionsHeldAgainstNonPerformingInvestments(provisionsHeldAgainstNonPerformingInvestmentsType);
        bodyItems.add(provisionsHeldAgainstNonPerformingInvestments);

        // create ProvisionsRequiredAgainstNonPerformingInvestments
        MonetaryItemType provisionsRequiredAgainstNonPerformingInvestmentsType = new MonetaryItemType();
        provisionsRequiredAgainstNonPerformingInvestmentsType.setContextRef(fromtocontextsubsidiary);
        provisionsRequiredAgainstNonPerformingInvestmentsType.setUnitRef(currency);
        provisionsRequiredAgainstNonPerformingInvestmentsType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getProvisionsRequiredAgainstNonPerformingInvestments() ) )  );
        provisionsRequiredAgainstNonPerformingInvestmentsType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getProvisionsRequiredAgainstNonPerformingInvestments()));
        JAXBElement<MonetaryItemType> provisionsRequiredAgainstNonPerformingInvestments = rbiObjectFactory.createProvisionsRequiredAgainstNonPerformingInvestments(provisionsRequiredAgainstNonPerformingInvestmentsType);
        bodyItems.add(provisionsRequiredAgainstNonPerformingInvestments);

        // create OffBalanceSheetExposuresContingentLiabilities
        MonetaryItemType offBalanceSheetExposuresContingentLiabilitiesType = new MonetaryItemType();
        offBalanceSheetExposuresContingentLiabilitiesType.setContextRef(asofcontextsubsidiary);
        offBalanceSheetExposuresContingentLiabilitiesType.setUnitRef(currency);
        offBalanceSheetExposuresContingentLiabilitiesType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartAFinancialParameters().getContingentLiabilitiesOrOffBalanceSheetExposures() ) )  );
        offBalanceSheetExposuresContingentLiabilitiesType.setValue(new BigDecimal(rosItem.getPartAFinancialParameters().getContingentLiabilitiesOrOffBalanceSheetExposures()));
        JAXBElement<MonetaryItemType> offBalanceSheetExposuresContingentLiabilities = rbiObjectFactory.createOffBalanceSheetExposuresContingentLiabilities(offBalanceSheetExposuresContingentLiabilitiesType);
        bodyItems.add(offBalanceSheetExposuresContingentLiabilities);

        // create NumberOfCounterparties
        PureItemType numberOfCounterpartiesType = new PureItemType();
        numberOfCounterpartiesType.setContextRef(fromtocontextsubsidiary);
        numberOfCounterpartiesType.setUnitRef(currency);
        numberOfCounterpartiesType.setDecimals("INF");
        numberOfCounterpartiesType.setValue(new BigDecimal(rosItem.getPartBExposureAndOwnership().getNoOfCounterparties()));
        JAXBElement<PureItemType> numberOfCounterparties = rbiObjectFactory.createNumberOfCounterparties(numberOfCounterpartiesType);
        bodyItems.add(numberOfCounterparties);

        // create AggregateExposureAmount
        MonetaryItemType aggregateExposureAmountType = new MonetaryItemType();
        aggregateExposureAmountType.setContextRef(asofcontextsubsidiary);
        aggregateExposureAmountType.setUnitRef(currency);
        aggregateExposureAmountType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartBExposureAndOwnership().getAggregateExposureAmount() ) )  );
        aggregateExposureAmountType.setValue(new BigDecimal(rosItem.getPartBExposureAndOwnership().getAggregateExposureAmount()));
        JAXBElement<MonetaryItemType> aggregateExposureAmount = rbiObjectFactory.createAggregateExposureAmount(aggregateExposureAmountType);
        bodyItems.add(aggregateExposureAmount);

        // create AggregateExposurePercentageOfCapitalFunds
        PercentItemType aggregateExposurePercentageOfCapitalFundsType = new PercentItemType();
        aggregateExposurePercentageOfCapitalFundsType.setContextRef(asofcontextsubsidiary);
        aggregateExposurePercentageOfCapitalFundsType.setUnitRef(percentage);
        aggregateExposurePercentageOfCapitalFundsType.setDecimals("4");
        aggregateExposurePercentageOfCapitalFundsType.setValue(new BigDecimal(rosItem.getPartBExposureAndOwnership().getAggregateExposurePercentage()));
        JAXBElement<PercentItemType> aggregateExposurePercentageOfCapitalFunds = rbiObjectFactory.createAggregateExposurePercentageOfCapitalFunds(aggregateExposurePercentageOfCapitalFundsType);
        bodyItems.add(aggregateExposurePercentageOfCapitalFunds);
        
        // create InvestmentInCapitalByParentCompany
        MonetaryItemType investmentInCapitalByParentCompanyType = new MonetaryItemType();
        investmentInCapitalByParentCompanyType.setContextRef(asofcontextsubsidiary);
        investmentInCapitalByParentCompanyType.setUnitRef(currency);
        investmentInCapitalByParentCompanyType.setDecimals(String.format("%s", CommonFns.getDecimals(rosItem.getPartBExposureAndOwnership().getInvestmentInCapitalByParentBank() ) )  );
        investmentInCapitalByParentCompanyType.setValue(new BigDecimal(rosItem.getPartBExposureAndOwnership().getInvestmentInCapitalByParentBank()));
        JAXBElement<MonetaryItemType> investmentInCapitalByParentCompany = rbiObjectFactory.createInvestmentInCapitalByParentCompany(investmentInCapitalByParentCompanyType);
        bodyItems.add(investmentInCapitalByParentCompany);

        // create PercentageOfSharesHeldByParentBank
        PercentItemType percentageOfSharesHeldByParentBankType = new PercentItemType();
        percentageOfSharesHeldByParentBankType.setContextRef(asofcontextsubsidiary);
        percentageOfSharesHeldByParentBankType.setUnitRef(percentage);
        percentageOfSharesHeldByParentBankType.setDecimals("2");
        percentageOfSharesHeldByParentBankType.setValue(new BigDecimal(rosItem.getPartBExposureAndOwnership().getSharesHeldByParentBank()));
        JAXBElement<PercentItemType> percentageOfSharesHeldByParentBank = rbiObjectFactory.createPercentageOfSharesHeldByParentBank(percentageOfSharesHeldByParentBankType);
        bodyItems.add(percentageOfSharesHeldByParentBank);
        
        // create PercentageOfCapitalHeldByParentBankIncludingTierIICapital
        PercentItemType percentageOfCapitalHeldByParentBankIncludingTierIICapitalType = new PercentItemType();
        percentageOfCapitalHeldByParentBankIncludingTierIICapitalType.setContextRef(asofcontextsubsidiary);
        percentageOfCapitalHeldByParentBankIncludingTierIICapitalType.setUnitRef(percentage);
        percentageOfCapitalHeldByParentBankIncludingTierIICapitalType.setDecimals("2");
        percentageOfCapitalHeldByParentBankIncludingTierIICapitalType.setValue(new BigDecimal(rosItem.getPartBExposureAndOwnership().getTotalCapitalHeldByParentBank()));
        JAXBElement<PercentItemType> percentageOfCapitalHeldByParentBankIncludingTierIICapital = rbiObjectFactory.createPercentageOfCapitalHeldByParentBankIncludingTierIICapital(percentageOfCapitalHeldByParentBankIncludingTierIICapitalType);
        bodyItems.add(percentageOfCapitalHeldByParentBankIncludingTierIICapital);
        
        return bodyItems;
    }

}

package in.armedu.banking.report.rbixbrl.part.cpr.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl.dtr.type.numeric.PercentItemType;


import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class CPRGeneralExtraBody implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
        
        // TODO add general items related to cpr report
        List<Object> generalItems = new ArrayList<Object>();
        Context fromToContext = contexts.get(CPRUtil.FROMTO);
        Context asOfContext = contexts.get(CPRUtil.ASOF);
        Context asOfBookValue = contexts.get(CPRUtil.ASOFBOOKVALUEMEMBER);
        Context asOfMarketValue = contexts.get(CPRUtil.ASOFMARKETVALUEMEMBER);
        Unit currency = units.get(CPRUtil.CURRENCY);
        Unit percentage = units.get(CPRUtil.PERCENTAGE);
        CPRGeneralData cprGeneralData = (CPRGeneralData) generalData;
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
        
        // TODO add remaining fields that are report level
        
        // create Assets
        MonetaryItemType assetsType = new MonetaryItemType();
        assetsType.setContextRef(asOfContext);
        assetsType.setUnitRef(currency);
        assetsType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getAsset()) )  );
        assetsType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getAsset()));
        JAXBElement<MonetaryItemType> assets = rbiObjectFactory.createAssets(assetsType);
        generalItems.add(assets);

        // create CapitalAndReserves
        MonetaryItemType capitalAndReservesType = new MonetaryItemType();
        capitalAndReservesType.setContextRef(asOfContext);
        capitalAndReservesType.setUnitRef(currency);
        capitalAndReservesType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getCapitalAndReserves()) )  );
        capitalAndReservesType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getCapitalAndReserves()));
        JAXBElement<MonetaryItemType> capitalAndReserves = rbiObjectFactory.createCapitalAndReserves(capitalAndReservesType);
        generalItems.add(capitalAndReserves);

        // create RegulatoryCapitalActualOrNotionalAfterNettingForConsolidation
        MonetaryItemType rcanancType = new MonetaryItemType();
        rcanancType.setContextRef(asOfContext);
        rcanancType.setUnitRef(currency);
        rcanancType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getRegulatoryCapitalActualOrNotionalAfterNettingForConsolidation()) )  );
        rcanancType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getRegulatoryCapitalActualOrNotionalAfterNettingForConsolidation()));
        JAXBElement<MonetaryItemType> rcananc = rbiObjectFactory.createRegulatoryCapitalActualOrNotionalAfterNettingForConsolidation(rcanancType);
        generalItems.add(rcananc);

        // create RiskWeightedAssetsActualOrNotional
        MonetaryItemType riskWeightedAssetsActualOrNotionalType = new MonetaryItemType();
        riskWeightedAssetsActualOrNotionalType.setContextRef(asOfContext);
        riskWeightedAssetsActualOrNotionalType.setUnitRef(currency);
        riskWeightedAssetsActualOrNotionalType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getRiskWeightedAssetsActualOrNotional()) )  );
        riskWeightedAssetsActualOrNotionalType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getRiskWeightedAssetsActualOrNotional()));
        JAXBElement<MonetaryItemType> riskWeightedAssetsActualOrNotional = rbiObjectFactory.createRiskWeightedAssetsActualOrNotional(riskWeightedAssetsActualOrNotionalType);
        generalItems.add(riskWeightedAssetsActualOrNotional);

        // create CapitalAdequacyRatioPercentActualOrNotional
        PercentItemType capitalAdequacyRatioType = new PercentItemType();
        capitalAdequacyRatioType.setContextRef(asOfContext);
        capitalAdequacyRatioType.setUnitRef(percentage);
        capitalAdequacyRatioType.setDecimals("4");
        capitalAdequacyRatioType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getCapitalAdequacyRatioPercentActualOrNotional()));
        JAXBElement<PercentItemType> capitalAdequacyRatio = rbiObjectFactory.createCapitalAdequacyRatioPercentActualOrNotional(capitalAdequacyRatioType);
        generalItems.add(capitalAdequacyRatio);

        // create AggregateDeposits
        MonetaryItemType aggregateDepositsType = new MonetaryItemType();
        aggregateDepositsType.setContextRef(asOfContext);
        aggregateDepositsType.setUnitRef(currency);
        aggregateDepositsType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getAggregateDeposit()) )  );
        aggregateDepositsType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getAggregateDeposit()));
        JAXBElement<MonetaryItemType> aggregateDeposits = rbiObjectFactory.createAggregateDeposits(aggregateDepositsType);
        generalItems.add(aggregateDeposits);

        // create AggregateBorrowings
        MonetaryItemType aggregateBorrowingsType = new MonetaryItemType();
        aggregateBorrowingsType.setContextRef(asOfContext);
        aggregateBorrowingsType.setUnitRef(currency);
        aggregateBorrowingsType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getAggregateBorrowing()) )  );
        aggregateBorrowingsType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getAggregateBorrowing()));
        JAXBElement<MonetaryItemType> aggregateBorrowings = rbiObjectFactory.createAggregateBorrowings(aggregateBorrowingsType);
        generalItems.add(aggregateBorrowings);

        // create GrossAdvances
        MonetaryItemType grossAdvancesType = new MonetaryItemType();
        grossAdvancesType.setContextRef(asOfContext);
        grossAdvancesType.setUnitRef(currency);
        grossAdvancesType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getGrossAdvances()) )  );
        grossAdvancesType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getGrossAdvances()));
        JAXBElement<MonetaryItemType> grossAdvances = rbiObjectFactory.createGrossAdvances(grossAdvancesType);
        generalItems.add(grossAdvances);

        // create GrossNonPerformingAssets
        MonetaryItemType grossNonPerformingAssetsType = new MonetaryItemType();
        grossNonPerformingAssetsType.setContextRef(asOfContext);
        grossNonPerformingAssetsType.setUnitRef(currency);
        grossNonPerformingAssetsType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getGrossNonPerformingAssets()) )  );
        grossNonPerformingAssetsType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getGrossNonPerformingAssets()));
        JAXBElement<MonetaryItemType> grossNonPerformingAssets = rbiObjectFactory.createGrossNonPerformingAssets(grossNonPerformingAssetsType);
        generalItems.add(grossNonPerformingAssets);

        // create Investments Book Value
        MonetaryItemType investmentsBookValueType = new MonetaryItemType();
        investmentsBookValueType.setContextRef(asOfContext);
        investmentsBookValueType.setUnitRef(currency);
        investmentsBookValueType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getInvestmentsBookValueMember())));
        investmentsBookValueType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getInvestmentsBookValueMember()));
        JAXBElement<MonetaryItemType> investmentsBookValue = rbiObjectFactory.createInvestments(investmentsBookValueType);
        generalItems.add(investmentsBookValue);

        // create Investments Market Value
        MonetaryItemType investmentsMarketValueType = new MonetaryItemType();
        investmentsMarketValueType.setContextRef(asOfContext);
        investmentsMarketValueType.setUnitRef(currency);
        investmentsMarketValueType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getInvestmentsMarketValueMember()) )  );
        investmentsMarketValueType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getInvestmentsMarketValueMember()));
        JAXBElement<MonetaryItemType> investmentsMarketValue = rbiObjectFactory.createInvestments(investmentsMarketValueType);
        generalItems.add(investmentsMarketValue);

        // create NonPerformingInvestments
        MonetaryItemType nonPerformingInvestmentType = new MonetaryItemType();
        nonPerformingInvestmentType.setContextRef(asOfContext);
        nonPerformingInvestmentType.setUnitRef(currency);
        nonPerformingInvestmentType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getNonPerformingInvestment())));
        nonPerformingInvestmentType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getNonPerformingInvestment()));
        JAXBElement<MonetaryItemType> nonPerformingInvestment = rbiObjectFactory.createNonPerformingInvestments(nonPerformingInvestmentType);
        generalItems.add(nonPerformingInvestment);

        // create NonPerformingAssetsIncludingNonPerformingAdvancesAndInvestments
        MonetaryItemType nonPerformingAssetsType = new MonetaryItemType();
        nonPerformingAssetsType.setContextRef(asOfContext);
        nonPerformingAssetsType.setUnitRef(currency);
        nonPerformingAssetsType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getNonPerformingAssetsIncludingNonPerformingAdvancesAndInvestment()) )  );
        nonPerformingAssetsType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getNonPerformingAssetsIncludingNonPerformingAdvancesAndInvestment()));
        JAXBElement<MonetaryItemType> nonPerformingAssets = rbiObjectFactory.createNonPerformingAssetsIncludingNonPerformingAdvancesAndInvestments(nonPerformingAssetsType);
        generalItems.add(nonPerformingAssets);

        // create ProvisionsHeldForNonPerformingAdvances
        MonetaryItemType provisionsHeldForAdvancesType = new MonetaryItemType();
        provisionsHeldForAdvancesType.setContextRef(asOfContext);
        provisionsHeldForAdvancesType.setUnitRef(currency);
        provisionsHeldForAdvancesType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getProvisionsHeldForNonPerformingAdvances()) )  );
        provisionsHeldForAdvancesType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getProvisionsHeldForNonPerformingAdvances()));
        JAXBElement<MonetaryItemType> provisionsHeldForAdvances = rbiObjectFactory.createProvisionsHeldForNonPerformingAdvances(provisionsHeldForAdvancesType);
        generalItems.add(provisionsHeldForAdvances);

        // create ProvisionsHeldForNonPerformingInvestments
        MonetaryItemType provisionsHeldForInvestmentsType = new MonetaryItemType();
        provisionsHeldForInvestmentsType.setContextRef(asOfContext);
        provisionsHeldForInvestmentsType.setUnitRef(currency);
        provisionsHeldForInvestmentsType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getProvisionsHeldForNonPerformingInvestments()) )  );
        provisionsHeldForInvestmentsType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getProvisionsHeldForNonPerformingInvestments()));
        JAXBElement<MonetaryItemType> provisionsHeldForInvestments = rbiObjectFactory.createProvisionsHeldForNonPerformingInvestments(provisionsHeldForInvestmentsType);
        generalItems.add(provisionsHeldForInvestments);

        // create ProfitLossBeforeTax
        MonetaryItemType profitLossBeforeTaxType = new MonetaryItemType();
        profitLossBeforeTaxType.setContextRef(asOfContext);
        profitLossBeforeTaxType.setUnitRef(currency);
        profitLossBeforeTaxType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getProfitLossBeforeTax()) )  );
        profitLossBeforeTaxType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getProfitLossBeforeTax()));
        JAXBElement<MonetaryItemType> profitLossBeforeTax = rbiObjectFactory.createProfitLossBeforeTax(profitLossBeforeTaxType);
        generalItems.add(profitLossBeforeTax);

        // create NetProfitLossAfterTax
        MonetaryItemType netProfitLossAfterTaxType = new MonetaryItemType();
        netProfitLossAfterTaxType.setContextRef(asOfContext);
        netProfitLossAfterTaxType.setUnitRef(currency);
        netProfitLossAfterTaxType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getNetProfitLossTax()) )  );
        netProfitLossAfterTaxType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getNetProfitLossTax()));
        JAXBElement<MonetaryItemType> netProfitLossAfterTax = rbiObjectFactory.createNetProfitLossAfterTax(netProfitLossAfterTaxType);
        generalItems.add(netProfitLossAfterTax);

        // create ReturnOnAssets
        PercentItemType ReturnOnAssetsType = new PercentItemType();
        ReturnOnAssetsType.setContextRef(asOfContext);
        ReturnOnAssetsType.setUnitRef(percentage);
        ReturnOnAssetsType.setDecimals("4");
        ReturnOnAssetsType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getReturnOnAssets()));
        JAXBElement<PercentItemType> ReturnOnAssets = rbiObjectFactory.createReturnOnAssets(ReturnOnAssetsType);
        generalItems.add(ReturnOnAssets);

        // create ReturnOnEquity
        PercentItemType returnOnEquityType = new PercentItemType();
        returnOnEquityType.setContextRef(asOfContext);
        returnOnEquityType.setUnitRef(percentage);
        returnOnEquityType.setDecimals("4");
        returnOnEquityType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getReturnOnEquity()));
        JAXBElement<PercentItemType> returnOnEquity = rbiObjectFactory.createReturnOnEquity(returnOnEquityType);
        generalItems.add(returnOnEquity);

        // create ContingentLiabilities
        MonetaryItemType contingentLiabilitiesType = new MonetaryItemType();
        contingentLiabilitiesType.setContextRef(asOfContext);
        contingentLiabilitiesType.setUnitRef(currency);
        contingentLiabilitiesType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getContingentLiabilitie()) )  );
        contingentLiabilitiesType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getContingentLiabilitie()));
        JAXBElement<MonetaryItemType> contingentLiabilities = rbiObjectFactory.createContingentLiabilities(contingentLiabilitiesType);
        generalItems.add(contingentLiabilities);

        // create DividendPaid
        MonetaryItemType dividendPaidType = new MonetaryItemType();
        dividendPaidType.setContextRef(asOfContext);
        dividendPaidType.setUnitRef(currency);
        dividendPaidType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getFinancialForConsolidated().getDividendPaid()) )  );
        dividendPaidType.setValue(new BigDecimal(cprGeneralData.getFinancialForConsolidated().getDividendPaid()));
        JAXBElement<MonetaryItemType> dividendPaid = rbiObjectFactory.createDividendPaid(dividendPaidType);
        generalItems.add(dividendPaid);
        
        return generalItems;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalInfoData, ItemData rosItem) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
package in.armedu.banking.report.rbixbrl.part.cpr.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ValidationStatusItemType;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;
import org.xbrl.dtr.type.numeric.PercentItemType;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.part.BodyIntf;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class CPRGeneralOtherBody implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
        // TODO add general items related to cpr report
        List<Object> generalItems = new ArrayList<Object>();
        Context fromToContext = contexts.get(CPRUtil.FROMTO);
        Context asOfContext = contexts.get(CPRUtil.ASOF);
        Context asOfFund = contexts.get(CPRUtil.ASOFFUNDEDMEMBER);
        Context asOfNonFund = contexts.get(CPRUtil.ASOFNONFUNDEDMEMBER);

        Context asOfBookValue = contexts.get(CPRUtil.ASOFBOOKVALUEMEMBER);
        Context asOfMarketValue = contexts.get(CPRUtil.ASOFMARKETVALUEMEMBER);
        Unit currency = units.get(CPRUtil.CURRENCY);
        Unit percentage = units.get(CPRUtil.PERCENTAGE);
        CPRGeneralData cprGeneralData = (CPRGeneralData) generalData;
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
        // create return name
        StringItemType returnNameValue = new StringItemType();
        returnNameValue.setContextRef(fromToContext);
        returnNameValue.setValue(cprGeneralData.getReturnName());
        JAXBElement<StringItemType> returnName = rbiObjectFactory.createReturnName(returnNameValue);
        generalItems.add(returnName);
        
        // TODO add remaining fields that are report level
        

        // create OvernightOpenPositionLimitForConsolidatedBank
        MonetaryItemType overnightOpenPositionLimitForConsolidatedBankType = new MonetaryItemType();
        overnightOpenPositionLimitForConsolidatedBankType.setContextRef(asOfContext);
        overnightOpenPositionLimitForConsolidatedBankType.setUnitRef(currency);
        overnightOpenPositionLimitForConsolidatedBankType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getForexExposure().getOpenPosition())));
        overnightOpenPositionLimitForConsolidatedBankType.setValue(new BigDecimal(cprGeneralData.getForexExposure().getOpenPosition()));
        JAXBElement<MonetaryItemType> overnightOpenPositionLimitForConsolidatedBank = rbiObjectFactory.createOvernightOpenPositionLimitForConsolidatedBank(overnightOpenPositionLimitForConsolidatedBankType);
        generalItems.add(overnightOpenPositionLimitForConsolidatedBank);
        
        // exposure to capital market to consolidated bank
        // create LoansAndAdvancesToCapitalMarket
        MonetaryItemType loansAndAdvancesToCapitalMarketTypeAdvances = new MonetaryItemType();
        loansAndAdvancesToCapitalMarketTypeAdvances.setContextRef(asOfContext);
        loansAndAdvancesToCapitalMarketTypeAdvances.setUnitRef(currency);
        loansAndAdvancesToCapitalMarketTypeAdvances.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getCapitalMarketExposure().getAdvances())));
        loansAndAdvancesToCapitalMarketTypeAdvances.setValue(new BigDecimal(cprGeneralData.getCapitalMarketExposure().getAdvances()));
        JAXBElement<MonetaryItemType> loansAndAdvancesToCapitalMarketAdvances = rbiObjectFactory.createLoansAndAdvancesToCapitalMarket(loansAndAdvancesToCapitalMarketTypeAdvances);
        generalItems.add(loansAndAdvancesToCapitalMarketAdvances);

        MonetaryItemType loansAndAdvancesToCapitalMarketTypeFund = new MonetaryItemType();
        loansAndAdvancesToCapitalMarketTypeFund.setContextRef(asOfFund);
        loansAndAdvancesToCapitalMarketTypeFund.setUnitRef(currency);
        loansAndAdvancesToCapitalMarketTypeFund.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getCapitalMarketExposure().getFundBased())));
        loansAndAdvancesToCapitalMarketTypeFund.setValue(new BigDecimal(cprGeneralData.getCapitalMarketExposure().getFundBased()));
        JAXBElement<MonetaryItemType> loansAndAdvancesToCapitalMarketFund = rbiObjectFactory.createLoansAndAdvancesToCapitalMarket(loansAndAdvancesToCapitalMarketTypeFund);
        generalItems.add(loansAndAdvancesToCapitalMarketFund);
        MonetaryItemType loansAndAdvancesToCapitalMarketTypeNonFund = new MonetaryItemType();
        loansAndAdvancesToCapitalMarketTypeNonFund.setContextRef(asOfNonFund);
        loansAndAdvancesToCapitalMarketTypeNonFund.setUnitRef(currency);
        loansAndAdvancesToCapitalMarketTypeNonFund.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getCapitalMarketExposure().getNonFundBased())));
        loansAndAdvancesToCapitalMarketTypeNonFund.setValue(new BigDecimal(cprGeneralData.getCapitalMarketExposure().getNonFundBased()));
        JAXBElement<MonetaryItemType> loansAndAdvancesToCapitalMarketNonFund = rbiObjectFactory.createLoansAndAdvancesToCapitalMarket(loansAndAdvancesToCapitalMarketTypeNonFund);
        generalItems.add(loansAndAdvancesToCapitalMarketNonFund);
        // create EquityInvestmentInCapitalMarket
        MonetaryItemType equityInvestmentInCapitalMarketType = new MonetaryItemType();
        equityInvestmentInCapitalMarketType.setContextRef(asOfContext);
        equityInvestmentInCapitalMarketType.setUnitRef(currency);
        equityInvestmentInCapitalMarketType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getCapitalMarketExposure().getEquityInvestment())));
        equityInvestmentInCapitalMarketType.setValue(new BigDecimal(cprGeneralData.getCapitalMarketExposure().getEquityInvestment()));
        JAXBElement<MonetaryItemType> equityInvestmentInCapitalMarket = rbiObjectFactory.createEquityInvestmentInCapitalMarket(equityInvestmentInCapitalMarketType);
        generalItems.add(equityInvestmentInCapitalMarket);
        // create AggregateCapitalMarketExposure
        MonetaryItemType aggregateCapitalMarketExposureType = new MonetaryItemType();
        aggregateCapitalMarketExposureType.setContextRef(asOfContext);
        aggregateCapitalMarketExposureType.setUnitRef(currency);
        aggregateCapitalMarketExposureType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getCapitalMarketExposure().getTotalExposure())));
        aggregateCapitalMarketExposureType.setValue(new BigDecimal(cprGeneralData.getCapitalMarketExposure().getTotalExposure()));
        JAXBElement<MonetaryItemType> aggregateCapitalMarketExposure = rbiObjectFactory.createAggregateCapitalMarketExposure(aggregateCapitalMarketExposureType);
        generalItems.add(aggregateCapitalMarketExposure);
        // create AggregateCapitalMarketExposureAsAPercentageOfAggregateOnBalanceSheetAssetsOfConsolidatedBankExcludingIntangibleAssetsAndAccumulatedLosses 
        PercentItemType aggregateCapitalMarketExposureAsAPercentageOfAggregateOnBalanceSheetAssetsOfConsolidatedBankExcludingIntangibleAssetsAndAccumulatedLossesType = new PercentItemType();
        aggregateCapitalMarketExposureAsAPercentageOfAggregateOnBalanceSheetAssetsOfConsolidatedBankExcludingIntangibleAssetsAndAccumulatedLossesType.setContextRef(fromToContext);
        aggregateCapitalMarketExposureAsAPercentageOfAggregateOnBalanceSheetAssetsOfConsolidatedBankExcludingIntangibleAssetsAndAccumulatedLossesType.setUnitRef(percentage);
        aggregateCapitalMarketExposureAsAPercentageOfAggregateOnBalanceSheetAssetsOfConsolidatedBankExcludingIntangibleAssetsAndAccumulatedLossesType.setDecimals(CommonFns.getPrecisions(cprGeneralData.getCapitalMarketExposure().getEquityInvestmentPerc()));
        aggregateCapitalMarketExposureAsAPercentageOfAggregateOnBalanceSheetAssetsOfConsolidatedBankExcludingIntangibleAssetsAndAccumulatedLossesType.setValue(new BigDecimal(cprGeneralData.getCapitalMarketExposure().getEquityInvestmentPerc()));
        JAXBElement<PercentItemType>  aggregateCapitalMarketExposureInPerc = rbiObjectFactory.createAggregateCapitalMarketExposureAsAPercentageOfAggregateOnBalanceSheetAssetsOfConsolidatedBankExcludingIntangibleAssetsAndAccumulatedLosses(aggregateCapitalMarketExposureAsAPercentageOfAggregateOnBalanceSheetAssetsOfConsolidatedBankExcludingIntangibleAssetsAndAccumulatedLossesType);
        generalItems.add(aggregateCapitalMarketExposureInPerc);
        // create EquityInvestmentInCapitalMarketAsAPercentageOfNetWorth 
        PercentItemType equityInvestmentInCapitalMarketAsAPercentageOfNetWorthType = new PercentItemType();
        equityInvestmentInCapitalMarketAsAPercentageOfNetWorthType.setContextRef(fromToContext);
        equityInvestmentInCapitalMarketAsAPercentageOfNetWorthType.setUnitRef(percentage);
        equityInvestmentInCapitalMarketAsAPercentageOfNetWorthType.setDecimals(CommonFns.getPrecisions(cprGeneralData.getCapitalMarketExposure().getNetWorth()));
        equityInvestmentInCapitalMarketAsAPercentageOfNetWorthType.setValue(new BigDecimal(cprGeneralData.getCapitalMarketExposure().getNetWorth()));
        JAXBElement<PercentItemType>  equityInvestmentInCapitalMarketAsAPercentageOfNetWorth = rbiObjectFactory.createEquityInvestmentInCapitalMarketAsAPercentageOfNetWorth(equityInvestmentInCapitalMarketAsAPercentageOfNetWorthType);
        generalItems.add(equityInvestmentInCapitalMarketAsAPercentageOfNetWorth);
        // create OutstandingUnsecuredGuarantees
        MonetaryItemType outstandingUnsecuredGuaranteesType = new MonetaryItemType();
        outstandingUnsecuredGuaranteesType.setContextRef(asOfContext);
        outstandingUnsecuredGuaranteesType.setUnitRef(currency);
        outstandingUnsecuredGuaranteesType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getExposureToUnsecure().getOutstandingUnsecuredGuarantees())));
        outstandingUnsecuredGuaranteesType.setValue(new BigDecimal(cprGeneralData.getExposureToUnsecure().getOutstandingUnsecuredGuarantees()));
        JAXBElement<MonetaryItemType> outstandingUnsecuredGuarantees = rbiObjectFactory.createOutstandingUnsecuredGuarantees(outstandingUnsecuredGuaranteesType);
        generalItems.add(outstandingUnsecuredGuarantees);
        // create OutstandingUnsecuredAdvances
        MonetaryItemType outstandingUnsecuredAdvancesType = new MonetaryItemType();
        outstandingUnsecuredAdvancesType.setContextRef(asOfContext);
        outstandingUnsecuredAdvancesType.setUnitRef(currency);
        outstandingUnsecuredAdvancesType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getExposureToUnsecure().getOutstandingUnsecuredAdvances())));
        outstandingUnsecuredAdvancesType.setValue(new BigDecimal(cprGeneralData.getExposureToUnsecure().getOutstandingUnsecuredAdvances()));
        JAXBElement<MonetaryItemType> outstandingUnsecuredAdvances = rbiObjectFactory.createOutstandingUnsecuredAdvances(outstandingUnsecuredAdvancesType);
        generalItems.add(outstandingUnsecuredAdvances);
        // create OutstandingUnsecuredAdvances
        MonetaryItemType outstandingAdvancesType = new MonetaryItemType();
        outstandingAdvancesType.setContextRef(asOfContext);
        outstandingAdvancesType.setUnitRef(currency);
        outstandingAdvancesType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getExposureToUnsecure().getTotalOutstandingAdvances())));
        outstandingAdvancesType.setValue(new BigDecimal(cprGeneralData.getExposureToUnsecure().getTotalOutstandingAdvances()));
        JAXBElement<MonetaryItemType> outstandingAdvances = rbiObjectFactory.createOutstandingAdvances(outstandingAdvancesType);
        generalItems.add(outstandingAdvances);
        // create BanksOutstandingUnsecuredGuaranteesPlusTotalOutstandingUnsecuredAdvancesAsAPercentageOfTotalOutstandingAdvances 
        PercentItemType banksOutstandingUnsecuredGuaranteesPlusTotalOutstandingUnsecuredAdvancesAsAPercentageOfTotalOutstandingAdvancesType = new PercentItemType();
        banksOutstandingUnsecuredGuaranteesPlusTotalOutstandingUnsecuredAdvancesAsAPercentageOfTotalOutstandingAdvancesType.setContextRef(asOfContext);
        banksOutstandingUnsecuredGuaranteesPlusTotalOutstandingUnsecuredAdvancesAsAPercentageOfTotalOutstandingAdvancesType.setUnitRef(percentage);
        banksOutstandingUnsecuredGuaranteesPlusTotalOutstandingUnsecuredAdvancesAsAPercentageOfTotalOutstandingAdvancesType.setDecimals(CommonFns.getPrecisions(cprGeneralData.getExposureToUnsecure().getTotalUnsecuredOutstanding()));
        banksOutstandingUnsecuredGuaranteesPlusTotalOutstandingUnsecuredAdvancesAsAPercentageOfTotalOutstandingAdvancesType.setValue(new BigDecimal(cprGeneralData.getExposureToUnsecure().getTotalUnsecuredOutstanding()));
        JAXBElement<PercentItemType>  banksOutstandingUnsecuredGuaranteesPlusTotalOutstandingUnsecuredAdvancesAsAPercentageOfTotalOutstandingAdvances = rbiObjectFactory.createBanksOutstandingUnsecuredGuaranteesPlusTotalOutstandingUnsecuredAdvancesAsAPercentageOfTotalOutstandingAdvances(banksOutstandingUnsecuredGuaranteesPlusTotalOutstandingUnsecuredAdvancesAsAPercentageOfTotalOutstandingAdvancesType);
        generalItems.add(banksOutstandingUnsecuredGuaranteesPlusTotalOutstandingUnsecuredAdvancesAsAPercentageOfTotalOutstandingAdvances);
        // create CashFundsForConsolidatedBankEligibleForCRRPurpose
        MonetaryItemType cashFundsForConsolidatedBankEligibleForCRRPurposeType = new MonetaryItemType();
        cashFundsForConsolidatedBankEligibleForCRRPurposeType.setContextRef(asOfContext);
        cashFundsForConsolidatedBankEligibleForCRRPurposeType.setUnitRef(currency);
        cashFundsForConsolidatedBankEligibleForCRRPurposeType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getCrrAndSLR().getCashFundEligibleForCRR())));
        cashFundsForConsolidatedBankEligibleForCRRPurposeType.setValue(new BigDecimal(cprGeneralData.getCrrAndSLR().getCashFundEligibleForCRR()));
        JAXBElement<MonetaryItemType> cashFundsForConsolidatedBankEligibleForCRRPurpose = rbiObjectFactory.createCashFundsForConsolidatedBankEligibleForCRRPurpose(cashFundsForConsolidatedBankEligibleForCRRPurposeType);
        generalItems.add(cashFundsForConsolidatedBankEligibleForCRRPurpose);
        // create LiquidAssetsForConsolidatedBankEligibleForSLRPurpose
        MonetaryItemType liquidAssetsForConsolidatedBankEligibleForSLRPurposeType = new MonetaryItemType();
        liquidAssetsForConsolidatedBankEligibleForSLRPurposeType.setContextRef(asOfContext);
        liquidAssetsForConsolidatedBankEligibleForSLRPurposeType.setUnitRef(currency);
        liquidAssetsForConsolidatedBankEligibleForSLRPurposeType.setDecimals(String.format("%s", CommonFns.getDecimals(cprGeneralData.getCrrAndSLR().getLiquidAssetsEligibleForSLR())));
        liquidAssetsForConsolidatedBankEligibleForSLRPurposeType.setValue(new BigDecimal(cprGeneralData.getCrrAndSLR().getLiquidAssetsEligibleForSLR()));
        JAXBElement<MonetaryItemType> liquidAssetsForConsolidatedBankEligibleForSLRPurpose = rbiObjectFactory.createLiquidAssetsForConsolidatedBankEligibleForSLRPurpose(liquidAssetsForConsolidatedBankEligibleForSLRPurposeType);
        generalItems.add(liquidAssetsForConsolidatedBankEligibleForSLRPurpose);
        // create CRRPercentForConsolidatedBank 
        PercentItemType cRRPercentForConsolidatedBankType = new PercentItemType();
        cRRPercentForConsolidatedBankType.setContextRef(asOfContext);
        cRRPercentForConsolidatedBankType.setUnitRef(percentage);
        cRRPercentForConsolidatedBankType.setDecimals(CommonFns.getPrecisions(cprGeneralData.getCrrAndSLR().getPercCRR()));
        cRRPercentForConsolidatedBankType.setValue(new BigDecimal(cprGeneralData.getCrrAndSLR().getPercCRR()));
        JAXBElement<PercentItemType>  cRRPercentForConsolidatedBank = rbiObjectFactory.createCRRPercentForConsolidatedBank(cRRPercentForConsolidatedBankType);
        generalItems.add(cRRPercentForConsolidatedBank);
        // create SLRPercentForConsolidatedBank 
        PercentItemType sLRPercentForConsolidatedBankType = new PercentItemType();
        sLRPercentForConsolidatedBankType.setContextRef(asOfContext);
        sLRPercentForConsolidatedBankType.setUnitRef(percentage);
        sLRPercentForConsolidatedBankType.setDecimals(CommonFns.getPrecisions(cprGeneralData.getCrrAndSLR().getPercSLR()));
        sLRPercentForConsolidatedBankType.setValue(new BigDecimal(cprGeneralData.getCrrAndSLR().getPercSLR()));
        JAXBElement<PercentItemType>  sLRPercentForConsolidatedBank = rbiObjectFactory.createSLRPercentForConsolidatedBank(sLRPercentForConsolidatedBankType);
        generalItems.add(sLRPercentForConsolidatedBank);

        return generalItems;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalInfoData, ItemData rosItem) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
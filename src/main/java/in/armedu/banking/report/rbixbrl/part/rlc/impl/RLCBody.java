package in.armedu.banking.report.rbixbrl.part.rlc.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.JAXBElement;
import java.math.BigDecimal;


import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.IntegerItemType;
import org.xbrl.dtr.type.numeric.PercentItemType;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.SectorCodeItemType;
import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.PermanentAccountNumberItemType;
import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.BankingArrangementItemType;
import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.AssetsClassificationRLCItemType;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCItem;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class RLCBody  implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData) {
        return null;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData, ItemData itemData) {

        RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;
        RLCItem rlcItem = (RLCItem) itemData;

        List<Object> bodyItems = new ArrayList<Object>();
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        Context fromToContext = contexts.get(RLCUtil.FROMTO);
        Context asOfContext = contexts.get(RLCUtil.ASOF);
        Unit currency = units.get(RLCUtil.CURRENCY);
        Unit percentage = units.get(RLCUtil.PERCENTAGE);
        
        Context fromtoglobalindividualmember = contexts.get(RLCUtil.FROMTOGLOBALINDIVIDUALMEMBER);
        Context asofglobalindividualmember = contexts.get(RLCUtil.ASOFGLOBALINDIVIDUALMEMBER);

        if(rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis() == "GlobalMember" &&
        rlcItem.getRlcBasicInfo().getLargeCreditAxis() == "IndividualBorrowersMember")
        {

    // create permanentAccountNumberOfCustomerOrBorrower
    PermanentAccountNumberItemType permanentAccountNumberOfCustomerOrBorrowerValue = new PermanentAccountNumberItemType();
    permanentAccountNumberOfCustomerOrBorrowerValue.setContextRef(fromtoglobalindividualmember);
    permanentAccountNumberOfCustomerOrBorrowerValue.setValue(rlcItem.getRlcBorrowerMember().getPermanentAccountNumberOfCustomerOrBorrower());
    JAXBElement<PermanentAccountNumberItemType> permanentAccountNumberOfCustomerOrBorrower = rbiObjectFactory.createPermanentAccountNumberOfCustomerOrBorrower(permanentAccountNumberOfCustomerOrBorrowerValue);
    bodyItems.add(permanentAccountNumberOfCustomerOrBorrower);

    // create customerName
    StringItemType customerNameValue = new StringItemType();
    customerNameValue.setContextRef(fromtoglobalindividualmember);
    customerNameValue.setValue(rlcItem.getRlcBorrowerMember().getCustomerName());
    JAXBElement<StringItemType> customerName = rbiObjectFactory.createCustomerName(customerNameValue);
    bodyItems.add(customerName);   

    // create sectorCode
    SectorCodeItemType sectorCodeValue = new SectorCodeItemType();
    sectorCodeValue.setContextRef(fromtoglobalindividualmember);
    sectorCodeValue.setValue(rlcItem.getRlcBorrowerMember().getSectorCode());
    JAXBElement<SectorCodeItemType> sectorCode = rbiObjectFactory.createSectorCode(sectorCodeValue);
    bodyItems.add(sectorCode);

    // create bankingArrangement
    BankingArrangementItemType bankingArrangementValue = new BankingArrangementItemType();
    bankingArrangementValue.setContextRef(fromtoglobalindividualmember);
    bankingArrangementValue.setValue(rlcItem.getRlcBorrowerMember().getBankingArrangement());
    JAXBElement<BankingArrangementItemType> bankingArrangement = rbiObjectFactory.createBankingArrangement(bankingArrangementValue);
    bodyItems.add(bankingArrangement);

    // create internalRating
    StringItemType internalRatingValue = new StringItemType();
    internalRatingValue.setContextRef(asofglobalindividualmember);
    internalRatingValue.setValue(rlcItem.getRlcBorrowerMember().getInternalRating());
    JAXBElement<StringItemType> internalRating = rbiObjectFactory.createInternalRating(internalRatingValue);
    bodyItems.add(internalRating);

    // create ExternalRating
    StringItemType externalRatingValue = new StringItemType();
    externalRatingValue.setContextRef(fromtoglobalindividualmember);
    externalRatingValue.setValue(rlcItem.getRlcBorrowerMember().getExternalRating());
    JAXBElement<StringItemType> externalRating = rbiObjectFactory.createExternalRating(externalRatingValue);
    bodyItems.add(externalRating);

    // create assetClassificationRLC
    AssetsClassificationRLCItemType assetClassificationRLCValue = new AssetsClassificationRLCItemType();
    assetClassificationRLCValue.setContextRef(fromtoglobalindividualmember);
    assetClassificationRLCValue.setValue(rlcItem.getRlcBorrowerMember().getAssetClassificationRLC());
    JAXBElement<AssetsClassificationRLCItemType> assetClassificationRLC = rbiObjectFactory.createAssetClassificationRLC(assetClassificationRLCValue);
    bodyItems.add(assetClassificationRLC);

    // create limitSanctionedForFundedExposure
    MonetaryItemType limitSanctionedForFundedExposureValue = new MonetaryItemType();
    limitSanctionedForFundedExposureValue.setContextRef(asofglobalindividualmember);    
    limitSanctionedForFundedExposureValue.setUnitRef(currency);
    limitSanctionedForFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getLimitSanctionedForFundedExposure())));
    limitSanctionedForFundedExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getLimitSanctionedForFundedExposure()));
    JAXBElement<MonetaryItemType> limitSanctionedForFundedExposure = rbiObjectFactory.createLimitSanctionedForFundedExposure(limitSanctionedForFundedExposureValue);
    bodyItems.add(limitSanctionedForFundedExposure);

    // create amountOutstandingForFundedExposure
    MonetaryItemType amountOutstandingForFundedExposureValue = new MonetaryItemType();
    amountOutstandingForFundedExposureValue.setContextRef(asofglobalindividualmember); 
    amountOutstandingForFundedExposureValue.setUnitRef(currency);
    amountOutstandingForFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAmountOutstandingForFundedExposure())));
    amountOutstandingForFundedExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAmountOutstandingForFundedExposure()));
    JAXBElement<MonetaryItemType> amountOutstandingForFundedExposure = rbiObjectFactory.createAmountOutstandingForFundedExposure(amountOutstandingForFundedExposureValue);
    bodyItems.add(amountOutstandingForFundedExposure);

    // create amountEligibleForNettingFromFundedExposure
    MonetaryItemType amountEligibleForNettingFromFundedExposureValue = new MonetaryItemType();
    amountEligibleForNettingFromFundedExposureValue.setContextRef(asofglobalindividualmember);
    amountEligibleForNettingFromFundedExposureValue.setUnitRef(currency);
    amountEligibleForNettingFromFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAmountEligibleForNettingFromFundedExposure())));
    amountEligibleForNettingFromFundedExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAmountEligibleForNettingFromFundedExposure()));
    JAXBElement<MonetaryItemType> amountEligibleForNettingFromFundedExposure = rbiObjectFactory.createAmountEligibleForNettingFromFundedExposure(amountEligibleForNettingFromFundedExposureValue);
    bodyItems.add(amountEligibleForNettingFromFundedExposure);

    // create amountOfFundedExposure
    MonetaryItemType amountOfFundedExposureValue = new MonetaryItemType();
    amountOfFundedExposureValue.setContextRef(asofglobalindividualmember);
    amountOfFundedExposureValue.setUnitRef(currency);
    amountOfFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAmountOfFundedExposure())));
    amountOfFundedExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAmountOfFundedExposure()));
    JAXBElement<MonetaryItemType> amountOfFundedExposure = rbiObjectFactory.createAmountOfFundedExposure(amountOfFundedExposureValue);
    bodyItems.add(amountOfFundedExposure);

    // create LimitSanctionedForNonFundedExposure
    MonetaryItemType limitSanctionedForNonFundedExposureValue = new MonetaryItemType();
    limitSanctionedForNonFundedExposureValue.setContextRef(asofglobalindividualmember);
    limitSanctionedForNonFundedExposureValue.setUnitRef(currency);
    limitSanctionedForNonFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getLimitSanctionedForNonFundedExposure())));
    limitSanctionedForNonFundedExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getLimitSanctionedForNonFundedExposure()));
    JAXBElement<MonetaryItemType> limitSanctionedForNonFundedExposure = rbiObjectFactory.createLimitSanctionedForNonFundedExposure(limitSanctionedForNonFundedExposureValue);
    bodyItems.add(limitSanctionedForNonFundedExposure);

    // create amountOutstandingForNonFundedExposure
    MonetaryItemType amountOutstandingForNonFundedExposureValue = new MonetaryItemType();
    amountOutstandingForNonFundedExposureValue.setContextRef(asofglobalindividualmember);    
    amountOutstandingForNonFundedExposureValue.setUnitRef(currency);
    amountOutstandingForNonFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAmountOutstandingForNonFundedExposure())));
    amountOutstandingForNonFundedExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAmountOutstandingForNonFundedExposure()));
    JAXBElement<MonetaryItemType> amountOutstandingForNonFundedExposure = rbiObjectFactory.createAmountOutstandingForNonFundedExposure(amountOutstandingForNonFundedExposureValue);
    bodyItems.add(amountOutstandingForNonFundedExposure);

    // create amountOfNonFundedExposure
    MonetaryItemType amountOfNonFundedExposureValue = new MonetaryItemType();
    amountOfNonFundedExposureValue.setContextRef(asofglobalindividualmember);   
    amountOfNonFundedExposureValue.setUnitRef(currency);
    amountOfNonFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAmountOfNonFundedExposure())));
    amountOfNonFundedExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAmountOfNonFundedExposure()));
    JAXBElement<MonetaryItemType> amountOfNonFundedExposure = rbiObjectFactory.createAmountOfNonFundedExposure(amountOfNonFundedExposureValue);
    bodyItems.add(amountOfNonFundedExposure);

    // create aggregateLimitSanctioned
    MonetaryItemType aggregateLimitSanctionedValue = new MonetaryItemType();
    aggregateLimitSanctionedValue.setContextRef(asofglobalindividualmember);   
    aggregateLimitSanctionedValue.setUnitRef(currency);
    aggregateLimitSanctionedValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAggregateLimitSanctioned())));
    aggregateLimitSanctionedValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAggregateLimitSanctioned()));
    JAXBElement<MonetaryItemType> aggregateLimitSanctioned = rbiObjectFactory.createAggregateLimitSanctioned(aggregateLimitSanctionedValue);
    bodyItems.add(aggregateLimitSanctioned);

    // create aggregateAmountOutstanding
    MonetaryItemType aggregateAmountOutstandingValue = new MonetaryItemType();
    aggregateAmountOutstandingValue.setContextRef(asofglobalindividualmember);
    aggregateAmountOutstandingValue.setUnitRef(currency);
    aggregateAmountOutstandingValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAggregateAmountOutstanding())));
    aggregateAmountOutstandingValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAggregateAmountOutstanding()));
    JAXBElement<MonetaryItemType> aggregateAmountOutstanding = rbiObjectFactory.createAggregateAmountOutstanding(aggregateAmountOutstandingValue);
    bodyItems.add(aggregateAmountOutstanding);

    // create aggregateCreditExposure
    MonetaryItemType aggregateCreditExposureValue = new MonetaryItemType();
    aggregateCreditExposureValue.setContextRef(asofglobalindividualmember);
    aggregateCreditExposureValue.setUnitRef(currency);
    aggregateCreditExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAggregateCreditExposure())));
    aggregateCreditExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAggregateCreditExposure()));
    JAXBElement<MonetaryItemType> aggregateCreditExposure = rbiObjectFactory.createAggregateCreditExposure(aggregateCreditExposureValue);
    bodyItems.add(aggregateCreditExposure);

    // create aggregateCreditExposureAsPercentageOfCapitalFunds
    PercentItemType aggregateCreditExposureAsPercentageOfCapitalFundsValue = new PercentItemType();
    aggregateCreditExposureAsPercentageOfCapitalFundsValue.setContextRef(fromtoglobalindividualmember);
    aggregateCreditExposureAsPercentageOfCapitalFundsValue.setUnitRef(percentage);
    aggregateCreditExposureAsPercentageOfCapitalFundsValue.setDecimals("1");
    aggregateCreditExposureAsPercentageOfCapitalFundsValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAggregateCreditExposureAsPercentageOfCapitalFunds()));
    JAXBElement<PercentItemType> aggregateCreditExposureAsPercentageOfCapitalFunds = rbiObjectFactory.createAggregateCreditExposureAsPercentageOfCapitalFunds(aggregateCreditExposureAsPercentageOfCapitalFundsValue);
    bodyItems.add(aggregateCreditExposureAsPercentageOfCapitalFunds);

    // create aggregateInvestmentExposure
    MonetaryItemType aggregateInvestmentExposureValue = new MonetaryItemType();
    aggregateInvestmentExposureValue.setContextRef(asofglobalindividualmember);
    aggregateInvestmentExposureValue.setUnitRef(currency);
    aggregateInvestmentExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAggregateInvestmentExposure())));
    aggregateInvestmentExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAggregateInvestmentExposure()));
    JAXBElement<MonetaryItemType> aggregateInvestmentExposure = rbiObjectFactory.createAggregateInvestmentExposure(aggregateInvestmentExposureValue);
    bodyItems.add(aggregateInvestmentExposure);

    // create aggregateExposure
    MonetaryItemType aggregateExposureValue = new MonetaryItemType();
    aggregateExposureValue.setContextRef(asofglobalindividualmember);
    aggregateExposureValue.setUnitRef(currency);
    aggregateExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAggregateExposure())));
    aggregateExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAggregateExposure()));
    JAXBElement<MonetaryItemType> aggregateExposure = rbiObjectFactory.createAggregateExposure(aggregateExposureValue);
    bodyItems.add(aggregateExposure);

    // create aggregateExposureAsPercentageOfCapitalFunds
    PercentItemType aggregateExposureAsPercentageOfCapitalFundsValue = new PercentItemType();
    aggregateExposureAsPercentageOfCapitalFundsValue.setContextRef(asofglobalindividualmember);
    aggregateExposureAsPercentageOfCapitalFundsValue.setUnitRef(percentage);
    aggregateExposureAsPercentageOfCapitalFundsValue.setDecimals("1");
    aggregateExposureAsPercentageOfCapitalFundsValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAggregateExposureAsPercentageOfCapitalFunds()));
    JAXBElement<PercentItemType> aggregateExposureAsPercentageOfCapitalFunds = rbiObjectFactory.createAggregateExposureAsPercentageOfCapitalFunds(aggregateExposureAsPercentageOfCapitalFundsValue);
    bodyItems.add(aggregateExposureAsPercentageOfCapitalFunds);
}

    return bodyItems;
        
    }
    
}
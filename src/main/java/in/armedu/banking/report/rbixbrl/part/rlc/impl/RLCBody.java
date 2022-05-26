package in.armedu.banking.report.rbixbrl.part.rlc.impl;

import java.util.List;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.part.BodyIntf;

public class RLCBody  implements BodyIntf {

    @Override
    public List<Object> getReportBodyItem(List<Context> contexts, GeneralData rlcGeneralData) {
       // TODO Auto-generated method stub
       return null;
    }

    @Override
    public List<Object> getReportBodyItem(List<Context> contexts, List<Unit> units, GeneralData generalData, ItemData itemData) {
                
        // RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;
        // RLCItem rlcItem = (RLCItem) itemData;

        // return getReportBodyItemOnlyForFromToAndASOF(contexts.get(0), contexts.get(1), contexts.get(2),
        // contexts.get(3), contexts.get(4), contexts.get(5), contexts.get(6), contexts.get(7), contexts.get(8),
        // contexts.get(9), contexts.get(10), contexts.get(11), contexts.get(12), contexts.get(13),
        // contexts.get(14), contexts.get(15), contexts.get(16), contexts.get(17), contexts.get(18), 
        // contexts.get(19), contexts.get(20), contexts.get(21), contexts.get(22), contexts.get(23),
        // contexts.get(24), contexts.get(25), contexts.get(26), contexts.get(27), contexts.get(28),
        // contexts.get(29), units.get(0), units.get(1), rlcGeneralData, rlcItem);
        return null;
    }
/*
    public List<Object> getReportBodyItemOnlyForFromToAndASOF(Context fromToRlcSet1, Context asOfRlcSet1,
    Context fromToRlcSet2, Context asOfRlcSet2,Context fromToRlcSet3, Context asOfRlcSet3, Context fromToRlcSet4,
    Context asOfRlcSet4, Context fromToRlcSet5, Context asOfRlcSet5, Context fromToRlcSet6, Context asOfRlcSet6,
    Context fromToRlcSet7, Context asOfRlcSet7, Context fromToRlcSet8, Context asOfRlcSet8, Context fromToRlcSet9,
    Context asOfRlcSet9, Context fromToRlcSet10, Context asOfRlcSet10, Context fromToRlcSet11, Context asOfRlcSet11,
    Context asOfRlcSet12, Context fromToRlcSet12, Context asOfRlcSet13, Context fromToRlcSet13, Context asOfRlcSet14,
    Context fromToRlcSet14, Context asOfRlcSet15, Context fromToRlcSet15, Context asOfRlcSet16, Context fromToRlcSet16,
    Context asOfRlcSet17, Context fromToRlcSet17, Context asOfRlcSet18, Context fromToRlcSet18, Context asOfRlcSet19, 
    Context fromToRlcSet19, Context asOfRlcSet20, Context fromToRlcSet20, Context asOfRlcSet21, Context fromToRlcSet21,
    Context asOfRlcSet22, Context fromToRlcSet22, Context asOfRlcSet23, Context fromToRlcSet23, Context asOfRlcSet24,
    Context fromToRlcSet24, Context asOfRlcSet25, Context fromToRlcSet25, Context asOfRlcSet26, Context fromToRlcSet26, 
    Context asOfRlcSet27, Context fromToRlcSet27, Context asOfRlcSet28, Context fromToRlcSet28, Context asOfRlcSet29,
    Context fromToRlcSet29, Context asOfRlcSet30, Context fromToRlcSet30, Unit unitINR, Unit pureUnit, 
    RLCGeneralData rlcGeneralData, RLCItem rlcItem) {
           
        List<Object> bodyItems = new ArrayList<Object>();

        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();


    }
    @Override
    public List<Object> getReportBodyItem(List<Context> contexts, List<Unit> units, GeneralData rlcGeneralData,
            ItemData rlcItem) {

    // create permanentAccountNumberOfCustomerOrBorrower
    PermanentAccountNumberItemType permanentAccountNumberOfCustomerOrBorrowerValue = new PermanentAccountNumberItemType();
    permanentAccountNumberOfCustomerOrBorrowerValue.setContextRef(fromToContext);
    permanentAccountNumberOfCustomerOrBorrowerValue.setValue(rlcItem.getRLCBorrowerMember().getPermanentAccountNumberOfCustomerOrBorrower());
    JAXBElement<PermanentAccountNumberItemType> permanentAccountNumberOfCustomerOrBorrower = rbiObjectFactory.createSubsidiaryJointVentureAssociateMember(permanentAccountNumberOfCustomerOrBorrowerValue);
    bodyItems.add(permanentAccountNumberOfCustomerOrBorrower);

    // create customerName
    StringItemType customerNameValue = new StringItemType();
    customerNameValue.setContextRef(fromToContext);
    customerNameValue.setValue(rlcItem.getRLCBorrowerMember().getCustomerName());
    JAXBElement<StringItemType> customerName = rbiObjectFactory.createCustomerName(customerNameValue);
    bodyItems.add(customerName);   

    // create sectorCode
    SectorCodeItemType sectorCodeValue = new SectorCodeItemType();
    sectorCodeValue.setContextRef(fromToContext);
    sectorCodeValue.setValue(rlcItem.getRLCBorrowerMember().getSectorCode());
    JAXBElement<SectorCodeItemType> sectorCode = rbiObjectFactory.createSectorCode(sectorCodeValue);
    bodyItems.add(sectorCode);

    // create bankingArrangement
    BankingArrangementItemType bankingArrangementValue = new BankingArrangementItemType();
    bankingArrangementValue.setContextRef(fromToContext);
    bankingArrangementValue.setValue(rlcItem.getRLCBorrowerMember().getBankingArrangement());
    JAXBElement<BankingArrangementItemType> bankingArrangement = rbiObjectFactory.createBankingArrangement(bankingArrangementValue);
    bodyItems.add(bankingArrangement);

    // create internalRating
    StringItemType internalRatingValue = new StringItemType();
    internalRatingValue.setContextRef(fromToContext);
    internalRatingValue.setValue(rlcItem.getRLCBorrowerMember().getInternalRating());
    JAXBElement<StringItemType> internalRating = rbiObjectFactory.createInternalRating(internalRatingValue);
    bodyItems.add(internalRating);

    // create ExternalRating
    StringItemType externalRatingValue = new StringItemType();
    externalRatingValue.setContextRef(fromToContext);
    externalRatingValue.setValue(rlcItem.getRLCBorrowerMember().getExternalRating());
    JAXBElement<StringItemType> externalRating = rbiObjectFactory.createExternalRating(externalRatingValue);
    bodyItems.add(externalRating);

    // create assetClassificationRLC
    AssetsClassificationRLCItemType assetClassificationRLCValue = new AssetsClassificationRLCItemType();
    assetClassificationRLCValue.setContextRef(fromToContext);
    assetClassificationRLCValue.setValue(rlcItem.getRLCBorrowerMember().getAssetClassificationRLC());
    JAXBElement<AssetsClassificationRLCItemType> assetClassificationRLC = rbiObjectFactory.createAssetClassificationRLC(assetClassificationRLCValue);
    bodyItems.add(assetClassificationRLC);

    // create 
    MonetaryItemType limitSanctionedForFundedExposureValue = new MonetaryItemType();
    limitSanctionedForFundedExposureValue.setContextRef(fromToContext);
    limitSanctionedForFundedExposureValue.setValue(rlcItem.getRLCBorrowerMember().getLimitSanctionedForFundedExposure());
    JAXBElement<MonetaryItemType> limitSanctionedForFundedExposure = rbiObjectFactory.createLimitSanctionedForFundedExposure(limitSanctionedForFundedExposureValue);
    bodyItems.add(limitSanctionedForFundedExposure);

    // create amountOutstandingForFundedExposure
    MonetaryItemType amountOutstandingForFundedExposureValue = new MonetaryItemType();
    amountOutstandingForFundedExposureValue.setContextRef(fromToContext);
    amountOutstandingForFundedExposureValue.setValue(rlcItem.getRLCBorrowerMember().getAmountOutstandingForFundedExposure());
    JAXBElement<MonetaryItemType> amountOutstandingForFundedExposure = rbiObjectFactory.createAmountOutstandingForFundedExposure(amountOutstandingForFundedExposureValue);
    bodyItems.add(amountOutstandingForFundedExposure);

    // create amountEligibleForNettingFromFundedExposure
    MonetaryItemType amountEligibleForNettingFromFundedExposureValue = new MonetaryItemType();
    amountEligibleForNettingFromFundedExposureValue.setContextRef(fromToContext);
    amountEligibleForNettingFromFundedExposureValue.setValue(rlcItem.getRLCBorrowerMember().getAmountEligibleForNettingFromFundedExposure());
    JAXBElement<MonetaryItemType> amountEligibleForNettingFromFundedExposure = rbiObjectFactory.createAmountEligibleForNettingFromFundedExposure(amountEligibleForNettingFromFundedExposureValue);
    bodyItems.add(amountEligibleForNettingFromFundedExposure);

    // create amountOfFundedExposure
    MonetaryItemType amountOfFundedExposureValue = new MonetaryItemType();
    amountOfFundedExposureValue.setContextRef(fromToContext);
    amountOfFundedExposureValue.setValue(rlcItem.getRLCBorrowerMember().getAmountOfFundedExposure());
    JAXBElement<MonetaryItemType> amountOfFundedExposure = rbiObjectFactory.createAmountOfFundedExposure(amountOfFundedExposureValue);
    bodyItems.add(amountOfFundedExposure);

    // create LimitSanctionedForNonFundedExposure
    MonetaryItemType limitSanctionedForNonFundedExposureValue = new MonetaryItemType();
    limitSanctionedForNonFundedExposureValue.setContextRef(fromToContext);
    limitSanctionedForNonFundedExposureValue.setValue(rlcItem.getRLCBorrowerMember().getLimitSanctionedForNonFundedExposure());
    JAXBElement<MonetaryItemType> limitSanctionedForNonFundedExposure = rbiObjectFactory.createLimitSanctionedForNonFundedExposure(limitSanctionedForNonFundedExposureValue);
    bodyItems.add(limitSanctionedForNonFundedExposure);

    // create amountOutstandingForNonFundedExposure
    MonetaryItemType amountOutstandingForNonFundedExposureValue = new MonetaryItemType();
    amountOutstandingForNonFundedExposureValue.setContextRef(fromToContext);
    amountOutstandingForNonFundedExposureValue.setValue(rlcItem.getRLCBorrowerMember().getAmountOutstandingForNonFundedExposure());
    JAXBElement<MonetaryItemType> amountOutstandingForNonFundedExposure = rbiObjectFactory.createAmountOutstandingForNonFundedExposure(amountOutstandingForNonFundedExposureValue);
    bodyItems.add(amountOutstandingForNonFundedExposure);

    // create amountOfNonFundedExposure
    MonetaryItemType amountOfNonFundedExposureValue = new MonetaryItemType();
    amountOfNonFundedExposureValue.setContextRef(fromToContext);
    amountOfNonFundedExposureValue.setValue(rlcItem.getRLCBorrowerMember().getAmountOfNonFundedExposure());
    JAXBElement<MonetaryItemType> amountOfNonFundedExposure = rbiObjectFactory.createAmountOfNonFundedExposure(amountOfNonFundedExposureValue);
    bodyItems.add(amountOfNonFundedExposure);

    // create aggregateLimitSanctioned
    MonetaryItemType aggregateLimitSanctionedValue = new MonetaryItemType();
    aggregateLimitSanctionedValue.setContextRef(fromToContext);
    aggregateLimitSanctionedValue.setValue(rlcItem.getRLCBorrowerMember().getAggregateLimitSanctioned());
    JAXBElement<MonetaryItemType> aggregateLimitSanctioned = rbiObjectFactory.createAggregateLimitSanctioned(aggregateLimitSanctionedValue);
    bodyItems.add(aggregateLimitSanctioned);

    // create aggregateAmountOutstanding
    MonetaryItemType aggregateAmountOutstandingValue = new MonetaryItemType();
    aggregateAmountOutstandingValue.setContextRef(fromToContext);
    aggregateAmountOutstandingValue.setValue(rlcItem.getRLCBorrowerMember().getAggregateAmountOutstanding());
    JAXBElement<MonetaryItemType> aggregateAmountOutstanding = rbiObjectFactory.createAggregateAmountOutstanding(aggregateAmountOutstandingValue);
    bodyItems.add(aggregateAmountOutstanding);

    // create aggregateCreditExposure
    MonetaryItemType aggregateCreditExposureValue = new MonetaryItemType();
    aggregateCreditExposureValue.setContextRef(fromToContext);
    aggregateCreditExposureValue.setValue(rlcItem.getRLCBorrowerMember().getAggregateCreditExposure());
    JAXBElement<MonetaryItemType> aggregateCreditExposure = rbiObjectFactory.createAggregateCreditExposure(aggregateCreditExposureValue);
    bodyItems.add(aggregateCreditExposure);

    // create aggregateCreditExposureAsPercentageOfCapitalFunds
    PercentItemType aggregateCreditExposureAsPercentageOfCapitalFundsValue = new PercentItemType();
    aggregateCreditExposureAsPercentageOfCapitalFundsValue.setContextRef(fromToContext);
    aggregateCreditExposureAsPercentageOfCapitalFundsValue.setValue(rlcItem.getRLCBorrowerMember().getAggregateCreditExposureAsPercentageOfCapitalFunds());
    JAXBElement<PercentItemType> aggregateCreditExposureAsPercentageOfCapitalFunds = rbiObjectFactory.createAggregateCreditExposureAsPercentageOfCapitalFunds(aggregateCreditExposureAsPercentageOfCapitalFundsValue);
    bodyItems.add(aggregateCreditExposureAsPercentageOfCapitalFunds);

    // create aggregateInvestmentExposure
    MonetaryItemType aggregateInvestmentExposureValue = new MonetaryItemType();
    aggregateInvestmentExposureValue.setContextRef(fromToContext);
    aggregateInvestmentExposureValue.setValue(rlcItem.getRLCBorrowerMember().getAggregateInvestmentExposure());
    JAXBElement<MonetaryItemType> aggregateInvestmentExposure = rbiObjectFactory.createAggregateInvestmentExposure(aggregateInvestmentExposureValue);
    bodyItems.add(aggregateInvestmentExposure);

    // create aggregateExposureAsPercentageOfCapitalFunds
    PercentItemType aggregateExposureAsPercentageOfCapitalFundsValue = new PercentItemType();
    aggregateExposureAsPercentageOfCapitalFundsValue.setContextRef(fromToContext);
    aggregateExposureAsPercentageOfCapitalFundsValue.setValue(rlcItem.getRLCBorrowerMember().getAggregateExposureAsPercentageOfCapitalFunds());
    JAXBElement<PercentItemType> aggregateExposureAsPercentageOfCapitalFunds = rbiObjectFactory.createAggregateExposureAsPercentageOfCapitalFunds(aggregateExposureAsPercentageOfCapitalFundsValue);
    bodyItems.add(aggregateExposureAsPercentageOfCapitalFunds);

//***************************************************************************************************************


*/
    }
    


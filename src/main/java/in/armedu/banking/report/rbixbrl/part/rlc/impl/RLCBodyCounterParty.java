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

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCItem;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class RLCBodyCounterParty  implements BodyInterface {

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
        
        Unit currency = units.get(RLCUtil.CURRENCY);
        Unit percentage = units.get(RLCUtil.PERCENTAGE);

        if(rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis() == "DomesticMember" &&
        rlcItem.getRlcBasicInfo().getLargeCreditAxis() == "CounterPartyBankMember")
        {

        Context fromtodomesticcounterparty = contexts.get(RLCUtil.FROMTODOMESTICCOUNTERPARTY);
        Context asofdomesticcounterparty = contexts.get(RLCUtil.ASOFDOMESTICCOUNTERPARTY);

 
    // create amountOfFundedExposure
    MonetaryItemType amountOfFundedExposureValue = new MonetaryItemType();
    amountOfFundedExposureValue.setContextRef(asofdomesticcounterparty);
    amountOfFundedExposureValue.setUnitRef(currency);
    amountOfFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAmountOfFundedExposure())));
    amountOfFundedExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAmountOfFundedExposure()));
    JAXBElement<MonetaryItemType> amountOfFundedExposure = rbiObjectFactory.createAmountOfFundedExposure(amountOfFundedExposureValue);
    bodyItems.add(amountOfFundedExposure);

    // create amountOfNonFundedExposure
    MonetaryItemType amountOfNonFundedExposureValue = new MonetaryItemType();
    amountOfNonFundedExposureValue.setContextRef(asofdomesticcounterparty);   
    amountOfNonFundedExposureValue.setUnitRef(currency);
    amountOfNonFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAmountOfNonFundedExposure())));
    amountOfNonFundedExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAmountOfNonFundedExposure()));
    JAXBElement<MonetaryItemType> amountOfNonFundedExposure = rbiObjectFactory.createAmountOfNonFundedExposure(amountOfNonFundedExposureValue);
    bodyItems.add(amountOfNonFundedExposure);

    // create aggregateCreditExposure
    MonetaryItemType aggregateCreditExposureValue = new MonetaryItemType();
    aggregateCreditExposureValue.setContextRef(asofdomesticcounterparty);
    aggregateCreditExposureValue.setUnitRef(currency);
    aggregateCreditExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAggregateCreditExposure())));
    aggregateCreditExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAggregateCreditExposure()));
    JAXBElement<MonetaryItemType> aggregateCreditExposure = rbiObjectFactory.createAggregateCreditExposure(aggregateCreditExposureValue);
    bodyItems.add(aggregateCreditExposure);
    
    // create aggregateCreditExposureAsPercentageOfCapitalFunds
    PercentItemType aggregateCreditExposureAsPercentageOfCapitalFundsValue = new PercentItemType();
    aggregateCreditExposureAsPercentageOfCapitalFundsValue.setContextRef(fromtodomesticcounterparty);
    aggregateCreditExposureAsPercentageOfCapitalFundsValue.setUnitRef(percentage);
    aggregateCreditExposureAsPercentageOfCapitalFundsValue.setDecimals("1");
    aggregateCreditExposureAsPercentageOfCapitalFundsValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAggregateCreditExposureAsPercentageOfCapitalFunds()));
    JAXBElement<PercentItemType> aggregateCreditExposureAsPercentageOfCapitalFunds = rbiObjectFactory.createAggregateCreditExposureAsPercentageOfCapitalFunds(aggregateCreditExposureAsPercentageOfCapitalFundsValue);
    bodyItems.add(aggregateCreditExposureAsPercentageOfCapitalFunds);

}

if(rlcItem.getRlcBasicInfo().getRegionOfBusinessAxis() == "GlobalMember" &&
rlcItem.getRlcBasicInfo().getLargeCreditAxis() == "CounterPartyBankMember")
{

Context fromtoglobalcounterparty = contexts.get(RLCUtil.FROMTOGLOBALCOUNTERPARTY);
Context asofglobalcounterparty = contexts.get(RLCUtil.ASOFGLOBALCOUNTERPARTY);


// create amountOfFundedExposure
MonetaryItemType amountOfFundedExposureValue = new MonetaryItemType();
amountOfFundedExposureValue.setContextRef(asofglobalcounterparty);
amountOfFundedExposureValue.setUnitRef(currency);
amountOfFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAmountOfFundedExposure())));
amountOfFundedExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAmountOfFundedExposure()));
JAXBElement<MonetaryItemType> amountOfFundedExposure = rbiObjectFactory.createAmountOfFundedExposure(amountOfFundedExposureValue);
bodyItems.add(amountOfFundedExposure);

// create amountOfNonFundedExposure
MonetaryItemType amountOfNonFundedExposureValue = new MonetaryItemType();
amountOfNonFundedExposureValue.setContextRef(asofglobalcounterparty);   
amountOfNonFundedExposureValue.setUnitRef(currency);
amountOfNonFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAmountOfNonFundedExposure())));
amountOfNonFundedExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAmountOfNonFundedExposure()));
JAXBElement<MonetaryItemType> amountOfNonFundedExposure = rbiObjectFactory.createAmountOfNonFundedExposure(amountOfNonFundedExposureValue);
bodyItems.add(amountOfNonFundedExposure);

// create aggregateCreditExposure
MonetaryItemType aggregateCreditExposureValue = new MonetaryItemType();
aggregateCreditExposureValue.setContextRef(asofglobalcounterparty);
aggregateCreditExposureValue.setUnitRef(currency);
aggregateCreditExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcBorrowerMember().getAggregateCreditExposure())));
aggregateCreditExposureValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAggregateCreditExposure()));
JAXBElement<MonetaryItemType> aggregateCreditExposure = rbiObjectFactory.createAggregateCreditExposure(aggregateCreditExposureValue);
bodyItems.add(aggregateCreditExposure);

// create aggregateCreditExposureAsPercentageOfCapitalFunds
PercentItemType aggregateCreditExposureAsPercentageOfCapitalFundsValue = new PercentItemType();
aggregateCreditExposureAsPercentageOfCapitalFundsValue.setContextRef(fromtoglobalcounterparty);
aggregateCreditExposureAsPercentageOfCapitalFundsValue.setUnitRef(percentage);
aggregateCreditExposureAsPercentageOfCapitalFundsValue.setDecimals("1");
aggregateCreditExposureAsPercentageOfCapitalFundsValue.setValue(new BigDecimal(rlcItem.getRlcBorrowerMember().getAggregateCreditExposureAsPercentageOfCapitalFunds()));
JAXBElement<PercentItemType> aggregateCreditExposureAsPercentageOfCapitalFunds = rbiObjectFactory.createAggregateCreditExposureAsPercentageOfCapitalFunds(aggregateCreditExposureAsPercentageOfCapitalFundsValue);
bodyItems.add(aggregateCreditExposureAsPercentageOfCapitalFunds);

}

    return bodyItems;

    }
    
}
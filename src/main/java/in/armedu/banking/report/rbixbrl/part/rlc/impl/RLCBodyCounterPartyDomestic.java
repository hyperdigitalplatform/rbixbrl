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

public class RLCBodyCounterPartyDomestic  implements BodyInterface {

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

        Context fromtodomesticcounterparty = contexts.get(RLCUtil.FROMTODOMESTICCOUNTERPARTY);
        Context asofdomesticcounterparty = contexts.get(RLCUtil.ASOFDOMESTICCOUNTERPARTY);

    
        // create amountOfFundedExposure
        MonetaryItemType amountOfFundedExposureValue = new MonetaryItemType();
        amountOfFundedExposureValue.setContextRef(asofdomesticcounterparty);
        amountOfFundedExposureValue.setUnitRef(currency);
        amountOfFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcCounterPartyDomestic().getAmountOfFundedExposure())));
        amountOfFundedExposureValue.setValue(new BigDecimal(rlcItem.getRlcCounterPartyDomestic().getAmountOfFundedExposure()));
        JAXBElement<MonetaryItemType> amountOfFundedExposure = rbiObjectFactory.createAmountOfFundedExposure(amountOfFundedExposureValue);
        bodyItems.add(amountOfFundedExposure);

        // create amountOfNonFundedExposure
        MonetaryItemType amountOfNonFundedExposureValue = new MonetaryItemType();
        amountOfNonFundedExposureValue.setContextRef(asofdomesticcounterparty);   
        amountOfNonFundedExposureValue.setUnitRef(currency);
        amountOfNonFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcCounterPartyDomestic().getAmountOfNonFundedExposure())));
        amountOfNonFundedExposureValue.setValue(new BigDecimal(rlcItem.getRlcCounterPartyDomestic().getAmountOfNonFundedExposure()));
        JAXBElement<MonetaryItemType> amountOfNonFundedExposure = rbiObjectFactory.createAmountOfNonFundedExposure(amountOfNonFundedExposureValue);
        bodyItems.add(amountOfNonFundedExposure);

        // create aggregateCreditExposure
        MonetaryItemType aggregateCreditExposureValue = new MonetaryItemType();
        aggregateCreditExposureValue.setContextRef(asofdomesticcounterparty);
        aggregateCreditExposureValue.setUnitRef(currency);
        aggregateCreditExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcItem.getRlcCounterPartyDomestic().getAggregateCreditExposure())));
        aggregateCreditExposureValue.setValue(new BigDecimal(rlcItem.getRlcCounterPartyDomestic().getAggregateCreditExposure()));
        JAXBElement<MonetaryItemType> aggregateCreditExposure = rbiObjectFactory.createAggregateCreditExposure(aggregateCreditExposureValue);
        bodyItems.add(aggregateCreditExposure);
        
        // create AggregateExposureAsPercentageOfCapitalFunds
        PercentItemType aggregateExposureAsPercentageOfCapitalFundsValue = new PercentItemType();
        aggregateExposureAsPercentageOfCapitalFundsValue.setContextRef(fromtodomesticcounterparty);
        aggregateExposureAsPercentageOfCapitalFundsValue.setUnitRef(percentage);
        aggregateExposureAsPercentageOfCapitalFundsValue.setDecimals("1");
        aggregateExposureAsPercentageOfCapitalFundsValue.setValue(new BigDecimal(rlcItem.getRlcCounterPartyDomestic().getAggregateExposureAsPercentageOfCapitalFunds()));
        JAXBElement<PercentItemType> aggregateExposureAsPercentageOfCapitalFunds = rbiObjectFactory.createAggregateExposureAsPercentageOfCapitalFunds(aggregateExposureAsPercentageOfCapitalFundsValue);
        bodyItems.add(aggregateExposureAsPercentageOfCapitalFunds);

   
    return bodyItems;

    }
    
}
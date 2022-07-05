package in.armedu.banking.report.rbixbrl.part.rlc.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import java.util.List;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.IntegerItemType;
import org.xbrl.dtr.type.numeric.PercentItemType;

import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCUnit;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;


public class RLCGeneralCounterParty implements BodyInterface {
     
    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
       
        // TODO add general items related to RLC report
        List<Object> generalItems = new ArrayList<Object>();
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        Context fromtoonlydomesticcounterparty = contexts.get(RLCUtil.FROMTOONLYDOMESTICCOUNTERPARTY);
        Context asofonlydomesticcounterparty = contexts.get(RLCUtil.ASOFONLYDOMESTICCOUNTERPARTY);
        Context fromtoonlyglobalcounterparty = contexts.get(RLCUtil.FROMTOONLYGLOBALCOUNTERPARTY);
        Context asofonlyglobalcounterparty = contexts.get(RLCUtil.ASOFONLYGLOBALCOUNTERPARTY);
        Unit currency = units.get(RLCUtil.CURRENCY);
        Unit percentage = units.get(RLCUtil.PERCENTAGE);
        
        RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;
        
        
        // General Body for Counter Party Domestic Member
        // create amountOfFundedExposure
        MonetaryItemType amountOfFundedExposureDomesticValue = new MonetaryItemType();
        amountOfFundedExposureDomesticValue.setContextRef(asofonlydomesticcounterparty);
        amountOfFundedExposureDomesticValue.setUnitRef(currency);
        amountOfFundedExposureDomesticValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralCounterDomestic().getAmountOfFundedExposure())));
        amountOfFundedExposureDomesticValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralCounterDomestic().getAmountOfFundedExposure()));
        JAXBElement<MonetaryItemType> amountOfFundedExposure = rbiObjectFactory.createAmountOfFundedExposure(amountOfFundedExposureDomesticValue);
        generalItems.add(amountOfFundedExposure);

        // create amountOfNonFundedExposure
        MonetaryItemType amountOfNonFundedExposureDomesticValue = new MonetaryItemType();
        amountOfNonFundedExposureDomesticValue.setContextRef(asofonlydomesticcounterparty);   
        amountOfNonFundedExposureDomesticValue.setUnitRef(currency);
        amountOfNonFundedExposureDomesticValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralCounterDomestic().getAmountOfNonFundedExposure())));
        amountOfNonFundedExposureDomesticValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralCounterDomestic().getAmountOfNonFundedExposure()));
        JAXBElement<MonetaryItemType> amountOfNonFundedExposure = rbiObjectFactory.createAmountOfNonFundedExposure(amountOfNonFundedExposureDomesticValue);
        generalItems.add(amountOfNonFundedExposure);

        // create aggregateCreditExposure
        MonetaryItemType aggregateCreditExposureDomesticValue = new MonetaryItemType();
        aggregateCreditExposureDomesticValue.setContextRef(asofonlydomesticcounterparty);
        aggregateCreditExposureDomesticValue.setUnitRef(currency);
        aggregateCreditExposureDomesticValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralCounterDomestic().getAggregateCreditExposure())));
        aggregateCreditExposureDomesticValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralCounterDomestic().getAggregateCreditExposure()));
        JAXBElement<MonetaryItemType> aggregateCreditExposure = rbiObjectFactory.createAggregateCreditExposure(aggregateCreditExposureDomesticValue);
        generalItems.add(aggregateCreditExposure);
        
        // create AggregateExposureAsPercentageOfCapitalFunds
        PercentItemType aggregateExposureAsPercentageOfCapitalFundsDomesticValue = new PercentItemType();
        aggregateExposureAsPercentageOfCapitalFundsDomesticValue.setContextRef(fromtoonlydomesticcounterparty);
        aggregateExposureAsPercentageOfCapitalFundsDomesticValue.setUnitRef(percentage);
        aggregateExposureAsPercentageOfCapitalFundsDomesticValue.setDecimals("1");
        aggregateExposureAsPercentageOfCapitalFundsDomesticValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralCounterDomestic().getAggregateExposureAsPercentageOfCapitalFunds()));
        JAXBElement<PercentItemType> aggregateExposureAsPercentageOfCapitalFunds = rbiObjectFactory.createAggregateExposureAsPercentageOfCapitalFunds(aggregateExposureAsPercentageOfCapitalFundsDomesticValue);
        generalItems.add(aggregateExposureAsPercentageOfCapitalFunds);
        
        
        // General Body for Counter Party Global Member
        // create amountOfFundedExposure
        MonetaryItemType amountOfFundedExposureGlobalValue = new MonetaryItemType();
        amountOfFundedExposureGlobalValue.setContextRef(asofonlyglobalcounterparty);
        amountOfFundedExposureGlobalValue.setUnitRef(currency);
        amountOfFundedExposureGlobalValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralCounterGlobal().getAmountOfFundedExposure())));
        amountOfFundedExposureGlobalValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralCounterGlobal().getAmountOfFundedExposure()));
        JAXBElement<MonetaryItemType> amountOfFundedExposureGlobal = rbiObjectFactory.createAmountOfFundedExposure(amountOfFundedExposureGlobalValue);
        generalItems.add(amountOfFundedExposureGlobal);

        // create amountOfNonFundedExposure
        MonetaryItemType amountOfNonFundedExposureGlobalValue = new MonetaryItemType();
        amountOfNonFundedExposureGlobalValue.setContextRef(asofonlyglobalcounterparty);   
        amountOfNonFundedExposureGlobalValue.setUnitRef(currency);
        amountOfNonFundedExposureGlobalValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralCounterGlobal().getAmountOfNonFundedExposure())));
        amountOfNonFundedExposureGlobalValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralCounterGlobal().getAmountOfNonFundedExposure()));
        JAXBElement<MonetaryItemType> amountOfNonFundedExposureGlobal = rbiObjectFactory.createAmountOfNonFundedExposure(amountOfNonFundedExposureGlobalValue);
        generalItems.add(amountOfNonFundedExposureGlobal);

        // create aggregateCreditExposure
        MonetaryItemType aggregateCreditExposureGlobalValue = new MonetaryItemType();
        aggregateCreditExposureGlobalValue.setContextRef(asofonlyglobalcounterparty);
        aggregateCreditExposureGlobalValue.setUnitRef(currency);
        aggregateCreditExposureGlobalValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralCounterGlobal().getAggregateCreditExposure())));
        aggregateCreditExposureGlobalValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralCounterGlobal().getAggregateCreditExposure()));
        JAXBElement<MonetaryItemType> aggregateCreditExposureGlobal = rbiObjectFactory.createAggregateCreditExposure(aggregateCreditExposureGlobalValue);
        generalItems.add(aggregateCreditExposureGlobal);
        
        // create AggregateExposureAsPercentageOfCapitalFunds
        PercentItemType aggregateExposureAsPercentageOfCapitalFundsGlobalValue = new PercentItemType();
        aggregateExposureAsPercentageOfCapitalFundsGlobalValue.setContextRef(fromtoonlyglobalcounterparty);
        aggregateExposureAsPercentageOfCapitalFundsGlobalValue.setUnitRef(percentage);
        aggregateExposureAsPercentageOfCapitalFundsGlobalValue.setDecimals("1");
        aggregateExposureAsPercentageOfCapitalFundsGlobalValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralCounterGlobal().getAggregateExposureAsPercentageOfCapitalFunds()));
        JAXBElement<PercentItemType> aggregateExposureAsPercentageOfCapitalFundsGlobal = rbiObjectFactory.createAggregateExposureAsPercentageOfCapitalFunds(aggregateExposureAsPercentageOfCapitalFundsGlobalValue);
        generalItems.add(aggregateExposureAsPercentageOfCapitalFundsGlobal);


        return generalItems;
        
    }

   
    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalInfoData, ItemData rosItem) {
        //TODO Auto-generated method stub
        return null;
    }

    
}


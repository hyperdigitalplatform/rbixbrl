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
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.List;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.IntegerItemType;
import org.xbrl.dtr.type.numeric.PercentItemType;

import org.xbrl.dtr.type.non_numeric.TextBlockItemType;


import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCUnit;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;


public class RLCGeneralBodyIndividual implements BodyInterface {
     
    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
       
        // TODO add general items related to RLC report
        List<Object> generalItems = new ArrayList<Object>();
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        Context fromtoonlyglobalindividualmember = contexts.get(RLCUtil.FROMTOONLYGLOBALINDIVIDUALMEMBER);
        Context asofonlyglobalindividualmember = contexts.get(RLCUtil.ASOFONLYGLOBALINDIVIDUALMEMBER);
        Unit currency = units.get(RLCUtil.CURRENCY);
        Unit percentage = units.get(RLCUtil.PERCENTAGE);
        RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;
    

        // General Body for Individual Global Member
        // create limitSanctionedForFundedExposure
        MonetaryItemType limitSanctionedForFundedExposureValue = new MonetaryItemType();
        limitSanctionedForFundedExposureValue.setContextRef(asofonlyglobalindividualmember);    
        limitSanctionedForFundedExposureValue.setUnitRef(currency);
        limitSanctionedForFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralIndividual().getLimitSanctionedForFundedExposure())));
        limitSanctionedForFundedExposureValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getLimitSanctionedForFundedExposure()));
        JAXBElement<MonetaryItemType> limitSanctionedForFundedExposure = rbiObjectFactory.createLimitSanctionedForFundedExposure(limitSanctionedForFundedExposureValue);
        generalItems.add(limitSanctionedForFundedExposure);

        // create amountOutstandingForFundedExposure
        MonetaryItemType amountOutstandingForFundedExposureValue = new MonetaryItemType();
        amountOutstandingForFundedExposureValue.setContextRef(asofonlyglobalindividualmember); 
        amountOutstandingForFundedExposureValue.setUnitRef(currency);
        amountOutstandingForFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralIndividual().getAmountOutstandingForFundedExposure())));
        amountOutstandingForFundedExposureValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getAmountOutstandingForFundedExposure()));
        JAXBElement<MonetaryItemType> amountOutstandingForFundedExposure = rbiObjectFactory.createAmountOutstandingForFundedExposure(amountOutstandingForFundedExposureValue);
        generalItems.add(amountOutstandingForFundedExposure);

        // create amountEligibleForNettingFromFundedExposure
        MonetaryItemType amountEligibleForNettingFromFundedExposureValue = new MonetaryItemType();
        amountEligibleForNettingFromFundedExposureValue.setContextRef(asofonlyglobalindividualmember);
        amountEligibleForNettingFromFundedExposureValue.setUnitRef(currency);
        amountEligibleForNettingFromFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralIndividual().getAmountEligibleForNettingFromFundedExposure())));
        amountEligibleForNettingFromFundedExposureValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getAmountEligibleForNettingFromFundedExposure()));
        JAXBElement<MonetaryItemType> amountEligibleForNettingFromFundedExposure = rbiObjectFactory.createAmountEligibleForNettingFromFundedExposure(amountEligibleForNettingFromFundedExposureValue);
        generalItems.add(amountEligibleForNettingFromFundedExposure);

        // create amountOfFundedExposure
        MonetaryItemType amountOfFundedExposureValue = new MonetaryItemType();
        amountOfFundedExposureValue.setContextRef(asofonlyglobalindividualmember);
        amountOfFundedExposureValue.setUnitRef(currency);
        amountOfFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralIndividual().getAmountOfFundedExposure())));
        amountOfFundedExposureValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getAmountOfFundedExposure()));
        JAXBElement<MonetaryItemType> amountOfFundedExposure = rbiObjectFactory.createAmountOfFundedExposure(amountOfFundedExposureValue);
        generalItems.add(amountOfFundedExposure);

        // create LimitSanctionedForNonFundedExposure
        MonetaryItemType limitSanctionedForNonFundedExposureValue = new MonetaryItemType();
        limitSanctionedForNonFundedExposureValue.setContextRef(asofonlyglobalindividualmember);
        limitSanctionedForNonFundedExposureValue.setUnitRef(currency);
        limitSanctionedForNonFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralIndividual().getLimitSanctionedForNonFundedExposure())));
        limitSanctionedForNonFundedExposureValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getLimitSanctionedForNonFundedExposure()));
        JAXBElement<MonetaryItemType> limitSanctionedForNonFundedExposure = rbiObjectFactory.createLimitSanctionedForNonFundedExposure(limitSanctionedForNonFundedExposureValue);
        generalItems.add(limitSanctionedForNonFundedExposure);

        // create amountOutstandingForNonFundedExposure
        MonetaryItemType amountOutstandingForNonFundedExposureValue = new MonetaryItemType();
        amountOutstandingForNonFundedExposureValue.setContextRef(asofonlyglobalindividualmember);    
        amountOutstandingForNonFundedExposureValue.setUnitRef(currency);
        amountOutstandingForNonFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralIndividual().getAmountOutstandingForNonFundedExposure())));
        amountOutstandingForNonFundedExposureValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getAmountOutstandingForNonFundedExposure()));
        JAXBElement<MonetaryItemType> amountOutstandingForNonFundedExposure = rbiObjectFactory.createAmountOutstandingForNonFundedExposure(amountOutstandingForNonFundedExposureValue);
        generalItems.add(amountOutstandingForNonFundedExposure);

        // create amountOfNonFundedExposure
        MonetaryItemType amountOfNonFundedExposureValue = new MonetaryItemType();
        amountOfNonFundedExposureValue.setContextRef(asofonlyglobalindividualmember);   
        amountOfNonFundedExposureValue.setUnitRef(currency);
        amountOfNonFundedExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralIndividual().getAmountOfNonFundedExposure())));
        amountOfNonFundedExposureValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getAmountOfNonFundedExposure()));
        JAXBElement<MonetaryItemType> amountOfNonFundedExposure = rbiObjectFactory.createAmountOfNonFundedExposure(amountOfNonFundedExposureValue);
        generalItems.add(amountOfNonFundedExposure);

        // create aggregateLimitSanctioned
        MonetaryItemType aggregateLimitSanctionedValue = new MonetaryItemType();
        aggregateLimitSanctionedValue.setContextRef(asofonlyglobalindividualmember);   
        aggregateLimitSanctionedValue.setUnitRef(currency);
        aggregateLimitSanctionedValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralIndividual().getAggregateLimitSanctioned())));
        aggregateLimitSanctionedValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getAggregateLimitSanctioned()));
        JAXBElement<MonetaryItemType> aggregateLimitSanctioned = rbiObjectFactory.createAggregateLimitSanctioned(aggregateLimitSanctionedValue);
        generalItems.add(aggregateLimitSanctioned);

        // create aggregateAmountOutstanding
        MonetaryItemType aggregateAmountOutstandingValue = new MonetaryItemType();
        aggregateAmountOutstandingValue.setContextRef(asofonlyglobalindividualmember);
        aggregateAmountOutstandingValue.setUnitRef(currency);
        aggregateAmountOutstandingValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralIndividual().getAggregateAmountOutstanding())));
        aggregateAmountOutstandingValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getAggregateAmountOutstanding()));
        JAXBElement<MonetaryItemType> aggregateAmountOutstanding = rbiObjectFactory.createAggregateAmountOutstanding(aggregateAmountOutstandingValue);
        generalItems.add(aggregateAmountOutstanding);

        // create aggregateCreditExposure
        MonetaryItemType aggregateCreditExposureValue = new MonetaryItemType();
        aggregateCreditExposureValue.setContextRef(asofonlyglobalindividualmember);
        aggregateCreditExposureValue.setUnitRef(currency);
        aggregateCreditExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralIndividual().getAggregateCreditExposure())));
        aggregateCreditExposureValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getAggregateCreditExposure()));
        JAXBElement<MonetaryItemType> aggregateCreditExposure = rbiObjectFactory.createAggregateCreditExposure(aggregateCreditExposureValue);
        generalItems.add(aggregateCreditExposure);

        // create aggregateCreditExposureAsPercentageOfCapitalFunds
        PercentItemType aggregateCreditExposureAsPercentageOfCapitalFundsValue = new PercentItemType();
        aggregateCreditExposureAsPercentageOfCapitalFundsValue.setContextRef(fromtoonlyglobalindividualmember);
        aggregateCreditExposureAsPercentageOfCapitalFundsValue.setUnitRef(percentage);
        aggregateCreditExposureAsPercentageOfCapitalFundsValue.setDecimals("1");
        aggregateCreditExposureAsPercentageOfCapitalFundsValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getAggregateCreditExposureAsPercentageOfCapitalFunds()));
        JAXBElement<PercentItemType> aggregateCreditExposureAsPercentageOfCapitalFunds = rbiObjectFactory.createAggregateCreditExposureAsPercentageOfCapitalFunds(aggregateCreditExposureAsPercentageOfCapitalFundsValue);
        generalItems.add(aggregateCreditExposureAsPercentageOfCapitalFunds);

        // create aggregateInvestmentExposure
        MonetaryItemType aggregateInvestmentExposureValue = new MonetaryItemType();
        aggregateInvestmentExposureValue.setContextRef(asofonlyglobalindividualmember);
        aggregateInvestmentExposureValue.setUnitRef(currency);
        aggregateInvestmentExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralIndividual().getAggregateInvestmentExposure())));
        aggregateInvestmentExposureValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getAggregateInvestmentExposure()));
        JAXBElement<MonetaryItemType> aggregateInvestmentExposure = rbiObjectFactory.createAggregateInvestmentExposure(aggregateInvestmentExposureValue);
        generalItems.add(aggregateInvestmentExposure);

        // create aggregateExposure
        MonetaryItemType aggregateExposureValue = new MonetaryItemType();
        aggregateExposureValue.setContextRef(asofonlyglobalindividualmember);
        aggregateExposureValue.setUnitRef(currency);
        aggregateExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRlcGeneralIndividual().getAggregateExposure())));
        aggregateExposureValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getAggregateExposure()));
        JAXBElement<MonetaryItemType> aggregateExposure = rbiObjectFactory.createAggregateExposure(aggregateExposureValue);
        generalItems.add(aggregateExposure);

        // create aggregateExposureAsPercentageOfCapitalFunds
        PercentItemType aggregateExposureAsPercentageOfCapitalFundsValue = new PercentItemType();
        aggregateExposureAsPercentageOfCapitalFundsValue.setContextRef(fromtoonlyglobalindividualmember);
        aggregateExposureAsPercentageOfCapitalFundsValue.setUnitRef(percentage);
        aggregateExposureAsPercentageOfCapitalFundsValue.setDecimals("1");
        aggregateExposureAsPercentageOfCapitalFundsValue.setValue(new BigDecimal(rlcGeneralData.getRlcGeneralIndividual().getAggregateExposureAsPercentageOfCapitalFunds()));
        JAXBElement<PercentItemType> aggregateExposureAsPercentageOfCapitalFunds = rbiObjectFactory.createAggregateExposureAsPercentageOfCapitalFunds(aggregateExposureAsPercentageOfCapitalFundsValue);
        generalItems.add(aggregateExposureAsPercentageOfCapitalFunds);
        
        return generalItems;
        
    }

   
    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalInfoData, ItemData rosItem) {
        //TODO Auto-generated method stub
        return null;
    }

    
}

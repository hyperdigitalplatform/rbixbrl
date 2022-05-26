package in.armedu.banking.report.rbixbrl.part.cpr.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.SectorItemType;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.Unit;
import org.xbrl.dtr.type.numeric.PercentItemType;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRGeneralData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.IndividualBorrower;
import in.armedu.banking.report.rbixbrl.model.cpr.LargeExposureToIndividualBorrower;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.part.BodyIntf;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class CPRBodyForTotalIndividual implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData) {
        return null;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData, ItemData itemData) {
        CPRGeneralData cprGeneralData = (CPRGeneralData) generalData;
        LargeExposureToIndividualBorrower totalIndividualBorrower = (LargeExposureToIndividualBorrower) itemData;
        
        List<Object> bodyItems = new ArrayList<Object>();
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
        // create SectorCode
        Context asOfFundedMember = contexts.get(CPRUtil.ASOFFUNDEDMEMBERINDIVIDUALBORROWER);
        Context asOfNonFundedMember = contexts.get(CPRUtil.ASOFNONFUNDEDMEMBERINDIVIDUALBORROWER);
        Context fromToContextWithIndividual = contexts.get(CPRUtil.FROMTOINDIVIDUALBORROWER);
        Unit currency = units.get(CPRUtil.CURRENCY);
        Unit percentage = units.get(CPRUtil.PERCENTAGE);
        

        // create total exposureamount for fundedmember
        MonetaryItemType exposureAmountTypeForFunded = new MonetaryItemType();
        exposureAmountTypeForFunded.setContextRef(asOfFundedMember);
        exposureAmountTypeForFunded.setUnitRef(currency);
        exposureAmountTypeForFunded.setDecimals(String.format("%s", CommonFns.getDecimals(totalIndividualBorrower.getTotalAmountFunded())));
        exposureAmountTypeForFunded.setValue(new BigDecimal(totalIndividualBorrower.getTotalAmountFunded()));
        JAXBElement<MonetaryItemType> exposureAmountForFunded = rbiObjectFactory.createExposureAmount(exposureAmountTypeForFunded);
        bodyItems.add(exposureAmountForFunded);
        
        // create exposureamount for nonfundedmember
        MonetaryItemType exposureAmountTypeForNonFunded = new MonetaryItemType();
        exposureAmountTypeForNonFunded.setContextRef(asOfNonFundedMember);
        exposureAmountTypeForNonFunded.setUnitRef(currency);
        exposureAmountTypeForNonFunded.setDecimals(String.format("%s", CommonFns.getDecimals(totalIndividualBorrower.getTotalAmountNonFunded())));
        exposureAmountTypeForNonFunded.setValue(new BigDecimal(totalIndividualBorrower.getTotalAmountNonFunded()));
        JAXBElement<MonetaryItemType> exposureAmountForNonFunded = rbiObjectFactory.createExposureAmount(exposureAmountTypeForNonFunded);
        bodyItems.add(exposureAmountForNonFunded);
        
        // create ExposuresAsPercentToCapitalFunds 
        PercentItemType exposuresAsPercentToCapitalFundsType = new PercentItemType();
        exposuresAsPercentToCapitalFundsType.setContextRef(fromToContextWithIndividual);
        exposuresAsPercentToCapitalFundsType.setUnitRef(percentage);
        exposuresAsPercentToCapitalFundsType.setDecimals(CommonFns.getPrecisions(totalIndividualBorrower.getTotalExposureAsPercToCapitalFunds()));
        exposuresAsPercentToCapitalFundsType.setValue(new BigDecimal(totalIndividualBorrower.getTotalExposureAsPercToCapitalFunds()));
        JAXBElement<PercentItemType>  exposuresAsPercentToCapitalFunds = rbiObjectFactory.createExposuresAsPercentToCapitalFunds(exposuresAsPercentToCapitalFundsType);
        bodyItems.add(exposuresAsPercentToCapitalFunds);

        return bodyItems;
    }    
    
}
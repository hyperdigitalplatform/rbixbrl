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
import in.armedu.banking.report.rbixbrl.model.cpr.LargeExposureToBorrowerGroup;
import in.armedu.banking.report.rbixbrl.model.cpr.LargeExposureToIndividualBorrower;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.part.BodyIntf;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class CPRBodyForTotalGroup implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData) {
        return null;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData, ItemData itemData) {
        CPRGeneralData cprGeneralData = (CPRGeneralData) generalData;
        LargeExposureToBorrowerGroup totalBorrowerGroup = (LargeExposureToBorrowerGroup) itemData;
        
        List<Object> bodyItems = new ArrayList<Object>();
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
        // create SectorCode
        Context asOfFundedMemberForGroup = contexts.get(CPRUtil.ASOFFUNDEDMEMBERBORROWERGROUP);
        Context asOfNonFundedMemberForGroup = contexts.get(CPRUtil.ASOFNONFUNDEDMEMBERBORROWERGROUP);
        Context fromToContextForGroup = contexts.get(CPRUtil.FROMTOBORROWERGROUP);
        Unit currency = units.get(CPRUtil.CURRENCY);
        Unit percentage = units.get(CPRUtil.PERCENTAGE);
        

        // create total exposureamount for fundedmember
        MonetaryItemType exposureAmountTypeForFunded = new MonetaryItemType();
        exposureAmountTypeForFunded.setContextRef(asOfFundedMemberForGroup);
        exposureAmountTypeForFunded.setUnitRef(currency);
        exposureAmountTypeForFunded.setDecimals(String.format("%s", CommonFns.getDecimals(totalBorrowerGroup.getTotalAmountFunded())));
        exposureAmountTypeForFunded.setValue(new BigDecimal(totalBorrowerGroup.getTotalAmountFunded()));
        JAXBElement<MonetaryItemType> exposureAmountForFunded = rbiObjectFactory.createExposureAmount(exposureAmountTypeForFunded);
        bodyItems.add(exposureAmountForFunded);
        
        // create exposureamount for nonfundedmember
        MonetaryItemType exposureAmountTypeForNonFunded = new MonetaryItemType();
        exposureAmountTypeForNonFunded.setContextRef(asOfNonFundedMemberForGroup);
        exposureAmountTypeForNonFunded.setUnitRef(currency);
        exposureAmountTypeForNonFunded.setDecimals(String.format("%s", CommonFns.getDecimals(totalBorrowerGroup.getTotalAmountNonFunded())));
        exposureAmountTypeForNonFunded.setValue(new BigDecimal(totalBorrowerGroup.getTotalAmountNonFunded()));
        JAXBElement<MonetaryItemType> exposureAmountForNonFunded = rbiObjectFactory.createExposureAmount(exposureAmountTypeForNonFunded);
        bodyItems.add(exposureAmountForNonFunded);
        
        // create ExposuresAsPercentToCapitalFunds 
        PercentItemType exposuresAsPercentToCapitalFundsType = new PercentItemType();
        exposuresAsPercentToCapitalFundsType.setContextRef(fromToContextForGroup);
        exposuresAsPercentToCapitalFundsType.setUnitRef(percentage);
        exposuresAsPercentToCapitalFundsType.setDecimals(CommonFns.getPrecisions(totalBorrowerGroup.getTotalExposureAsPercToCapitalFunds()));
        exposuresAsPercentToCapitalFundsType.setValue(new BigDecimal(totalBorrowerGroup.getTotalExposureAsPercToCapitalFunds()));
        JAXBElement<PercentItemType>  exposuresAsPercentToCapitalFunds = rbiObjectFactory.createExposuresAsPercentToCapitalFunds(exposuresAsPercentToCapitalFundsType);
        bodyItems.add(exposuresAsPercentToCapitalFunds);

        return bodyItems;
    }    
    
}
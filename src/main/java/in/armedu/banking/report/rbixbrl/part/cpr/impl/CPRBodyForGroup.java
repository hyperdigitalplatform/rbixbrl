package in.armedu.banking.report.rbixbrl.part.cpr.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.Unit;
import org.xbrl.dtr.type.numeric.PercentItemType;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.BorrowerGroup;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class CPRBodyForGroup implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData) {
        return null;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData, ItemData itemData) {
        CPRGeneralData cprGeneralData = (CPRGeneralData) generalData;
        BorrowerGroup borrowerGroup = (BorrowerGroup) itemData;
        
        List<Object> bodyItems = new ArrayList<Object>();
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
        // create SectorCode
        Context asOfFundedWithBorrowerGroupAndGroupCompany = contexts.get(CPRUtil.ASOFFUNDEDWITHBORROWERGROUPANDGROUPCOMPANY);
        Context asOfNonFundedWithBorrowerGroupAndGroupCompany = contexts.get(CPRUtil.ASOFNONFUNDEDWITHBORROWERGROUPANDGROUPCOMPANY);
        Context fromToWithBorrowerGroupAndGroupCompany = contexts.get(CPRUtil.FROMTOWITHBORROWERGROUPANDGROUPCOMPANY);
        Context asOfFundedWithBorrowerGroup = contexts.get(CPRUtil.ASOFFUNDEDWITHBORROWERGROUP);
        Context asOfNonFundedWithBorrowerGroup = contexts.get(CPRUtil.ASOFNONFUNDEDWITHBORROWERGROUP);
        Context fromToWithBorrowerGroup = contexts.get(CPRUtil.FROMTOBORROWERGROUP);
        
        Unit currency = units.get(CPRUtil.CURRENCY);
        Unit percentage = units.get(CPRUtil.PERCENTAGE);
        
        borrowerGroup.getGroupCompanies().forEach(groupCompany -> {
            // create exposureamount for fundedmember
            MonetaryItemType exposureAmountTypeForFunded = new MonetaryItemType();
            exposureAmountTypeForFunded.setContextRef(asOfFundedWithBorrowerGroupAndGroupCompany);
            exposureAmountTypeForFunded.setUnitRef(currency);
            exposureAmountTypeForFunded.setDecimals(String.format("%s", CommonFns.getDecimals(groupCompany.getAmountFunded())));
            exposureAmountTypeForFunded.setValue(new BigDecimal(groupCompany.getAmountFunded()));
            JAXBElement<MonetaryItemType> exposureAmountForFunded = rbiObjectFactory.createExposureAmount(exposureAmountTypeForFunded);
            bodyItems.add(exposureAmountForFunded);

            // create exposureamount for nonfundedmember
            MonetaryItemType exposureAmountTypeForNonFunded = new MonetaryItemType();
            exposureAmountTypeForNonFunded.setContextRef(asOfNonFundedWithBorrowerGroupAndGroupCompany);
            exposureAmountTypeForNonFunded.setUnitRef(currency);
            exposureAmountTypeForNonFunded.setDecimals(String.format("%s", CommonFns.getDecimals(groupCompany.getAmountNonFunded())));
            exposureAmountTypeForNonFunded.setValue(new BigDecimal(groupCompany.getAmountNonFunded()));
            JAXBElement<MonetaryItemType> exposureAmountForNonFunded = rbiObjectFactory.createExposureAmount(exposureAmountTypeForNonFunded);
            bodyItems.add(exposureAmountForNonFunded);

            // create ExposuresAsPercentToCapitalFunds 
            PercentItemType exposuresAsPercentToCapitalFundsType = new PercentItemType();
            exposuresAsPercentToCapitalFundsType.setContextRef(fromToWithBorrowerGroupAndGroupCompany);
            exposuresAsPercentToCapitalFundsType.setUnitRef(percentage);
            exposuresAsPercentToCapitalFundsType.setDecimals(CommonFns.getPrecisions(groupCompany.getExposureAsPercToCapitalFunds()));
            exposuresAsPercentToCapitalFundsType.setValue(new BigDecimal(groupCompany.getExposureAsPercToCapitalFunds()));
            JAXBElement<PercentItemType>  exposuresAsPercentToCapitalFunds = rbiObjectFactory.createExposuresAsPercentToCapitalFunds(exposuresAsPercentToCapitalFundsType);
            bodyItems.add(exposuresAsPercentToCapitalFunds);

        });

        // create exposureamount for fundedmember
        MonetaryItemType totalExposureAmountTypeForFunded = new MonetaryItemType();
        totalExposureAmountTypeForFunded.setContextRef(asOfFundedWithBorrowerGroup);
        totalExposureAmountTypeForFunded.setUnitRef(currency);
        totalExposureAmountTypeForFunded.setDecimals(String.format("%s", CommonFns.getDecimals(borrowerGroup.getTotalAmountFunded())));
        totalExposureAmountTypeForFunded.setValue(new BigDecimal(borrowerGroup.getTotalAmountFunded()));
        JAXBElement<MonetaryItemType> totalExposureAmountForFunded = rbiObjectFactory.createExposureAmount(totalExposureAmountTypeForFunded);
        bodyItems.add(totalExposureAmountForFunded);

        // create exposureamount for nonfundedmember
        MonetaryItemType totalExposureAmountTypeForNonFunded = new MonetaryItemType();
        totalExposureAmountTypeForNonFunded.setContextRef(asOfNonFundedWithBorrowerGroup);
        totalExposureAmountTypeForNonFunded.setUnitRef(currency);
        totalExposureAmountTypeForNonFunded.setDecimals(String.format("%s", CommonFns.getDecimals(borrowerGroup.getTotalAmountNonFunded())));
        totalExposureAmountTypeForNonFunded.setValue(new BigDecimal(borrowerGroup.getTotalAmountNonFunded()));
        JAXBElement<MonetaryItemType> totalExposureAmountForNonFunded = rbiObjectFactory.createExposureAmount(totalExposureAmountTypeForNonFunded);
        bodyItems.add(totalExposureAmountForNonFunded);

        // create ExposuresAsPercentToCapitalFunds 
        PercentItemType totalExposuresAsPercentToCapitalFundsType = new PercentItemType();
        totalExposuresAsPercentToCapitalFundsType.setContextRef(fromToWithBorrowerGroup);
        totalExposuresAsPercentToCapitalFundsType.setUnitRef(percentage);
        totalExposuresAsPercentToCapitalFundsType.setDecimals(CommonFns.getPrecisions(borrowerGroup.getTotalExposureAsPercToCapitalFunds()));
        totalExposuresAsPercentToCapitalFundsType.setValue(new BigDecimal(borrowerGroup.getTotalExposureAsPercToCapitalFunds()));
        JAXBElement<PercentItemType>  totalExposuresAsPercentToCapitalFunds = rbiObjectFactory.createExposuresAsPercentToCapitalFunds(totalExposuresAsPercentToCapitalFundsType);
        bodyItems.add(totalExposuresAsPercentToCapitalFunds);

        return bodyItems;
    }    
    
}
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
import in.armedu.banking.report.rbixbrl.model.cpr.IndividualBorrower;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class CPRBodyForIndividual implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData) {
        return null;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData, ItemData itemData) {
        CPRGeneralData cprGeneralData = (CPRGeneralData) generalData;
        IndividualBorrower individualBorrower = (IndividualBorrower) itemData;
        
        List<Object> bodyItems = new ArrayList<Object>();
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
        // create SectorCode
        Context fromToContextWOIndividual = contexts.get(CPRUtil.FROMTOITEMWOINDIVIDUAL);
        Context asOfContextFundedIndividualBorrower = contexts.get(CPRUtil.ASOFITEMFORFUNDEDINDIVIDUAL);
        Context asOfContextNonFundedIndividualBorrower = contexts.get(CPRUtil.ASOFITEMFORNONFUNDEDINDIVIDUAL);
        Context fromToContextWithIndividual = contexts.get(CPRUtil.FROMTOFORITEMWITHINDIVIDUAL);
        Context asOfBookValue = contexts.get(CPRUtil.ASOFBOOKVALUEMEMBER);
        Context asOfMarketValue = contexts.get(CPRUtil.ASOFMARKETVALUEMEMBER);
        Unit currency = units.get(CPRUtil.CURRENCY);
        Unit percentage = units.get(CPRUtil.PERCENTAGE);
        

        SectorItemType sectorType = new SectorItemType();
        sectorType.setContextRef(fromToContextWOIndividual);
        sectorType.setValue(individualBorrower.getSector());
        JAXBElement<SectorItemType> sectorCode = rbiObjectFactory.createSector(sectorType);
        bodyItems.add(sectorCode);
        
        // create exposureamount for fundedmember
        MonetaryItemType exposureAmountTypeForFunded = new MonetaryItemType();
        exposureAmountTypeForFunded.setContextRef(asOfContextFundedIndividualBorrower);
        exposureAmountTypeForFunded.setUnitRef(currency);
        exposureAmountTypeForFunded.setDecimals(String.format("%s", CommonFns.getDecimals(individualBorrower.getAmountFunded())));
        exposureAmountTypeForFunded.setValue(new BigDecimal(individualBorrower.getAmountFunded()));
        JAXBElement<MonetaryItemType> exposureAmountForFunded = rbiObjectFactory.createExposureAmount(exposureAmountTypeForFunded);
        bodyItems.add(exposureAmountForFunded);
        
        // create exposureamount for nonfundedmember
        MonetaryItemType exposureAmountTypeForNonFunded = new MonetaryItemType();
        exposureAmountTypeForNonFunded.setContextRef(asOfContextNonFundedIndividualBorrower);
        exposureAmountTypeForNonFunded.setUnitRef(currency);
        exposureAmountTypeForNonFunded.setDecimals(String.format("%s", CommonFns.getDecimals(individualBorrower.getAmountNonFunded())));
        exposureAmountTypeForNonFunded.setValue(new BigDecimal(individualBorrower.getAmountNonFunded()));
        JAXBElement<MonetaryItemType> exposureAmountForNonFunded = rbiObjectFactory.createExposureAmount(exposureAmountTypeForNonFunded);
        bodyItems.add(exposureAmountForNonFunded);
        
        // create ExposuresAsPercentToCapitalFunds 
        PercentItemType exposuresAsPercentToCapitalFundsType = new PercentItemType();
        exposuresAsPercentToCapitalFundsType.setContextRef(fromToContextWithIndividual);
        exposuresAsPercentToCapitalFundsType.setUnitRef(percentage);
        exposuresAsPercentToCapitalFundsType.setDecimals(CommonFns.getPrecisions(individualBorrower.getExposureAsPercToCapitalFunds()));
        exposuresAsPercentToCapitalFundsType.setValue(new BigDecimal(individualBorrower.getExposureAsPercToCapitalFunds()));
        JAXBElement<PercentItemType>  exposuresAsPercentToCapitalFunds = rbiObjectFactory.createExposuresAsPercentToCapitalFunds(exposuresAsPercentToCapitalFundsType);
        bodyItems.add(exposuresAsPercentToCapitalFunds);

        return bodyItems;
    }    
    
}
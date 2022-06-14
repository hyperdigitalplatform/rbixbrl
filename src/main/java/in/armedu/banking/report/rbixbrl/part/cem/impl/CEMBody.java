package in.armedu.banking.report.rbixbrl.part.cem.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.JAXBElement;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.IntegerItemType;
import org.xbrl.dtr.type.numeric.PercentItemType;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.cem.CEMItemData;
import in.armedu.banking.report.rbixbrl.model.cem.CEMGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class CEMBody  implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData) {
        return null;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData, ItemData itemData) {

        CEMGeneralData cemGeneralData = (CEMGeneralData) generalData;
        CEMItemData cemItem = (CEMItemData) itemData;

        List<Object> bodyItems = new ArrayList<Object>();
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        Context fromToContext = contexts.get(CEMUtil.FROMTO);
        Context asOfContext = contexts.get(CEMUtil.ASOF);
        Unit currency = units.get(CEMUtil.CURRENCY);
        Unit percentage = units.get(CEMUtil.PERCENTAGE);
        Context asofbetweensixmonthmember = contexts.get(CEMUtil.ASOFBETWEENSIXMONTHMEMBER);
        Context asofoversixmonthsanduptooneyearmember = contexts.get(CEMUtil.ASOFOVERSIXMONTHSANDUPTOONEYEARMEMBER);
        Context asofoveroneyearanduptofiveyearmember = contexts.get(CEMUtil.ASOFOVERONEYEARANDUPTOFIVEYEARMEMBER);
        Context asofoverfiveyearsmember = contexts.get(CEMUtil.ASOFOVERFIVEYEARSMEMBER);
        Context asofriskclassification = contexts.get(CEMUtil.ASOFRISKCLASSIFICATION);


///     For Account with members
        // create AmountOfCountryExposureBetweenSixMonthMember
        MonetaryItemType amountOfCountryExposureBetweenSixMonthMemberValue = new MonetaryItemType();
        amountOfCountryExposureBetweenSixMonthMemberValue.setContextRef(asofbetweensixmonthmember);  
        amountOfCountryExposureBetweenSixMonthMemberValue.setUnitRef(currency);
        amountOfCountryExposureBetweenSixMonthMemberValue.setDecimals(String.format("%s", CommonFns.getDecimals(cemItem.getAmountOfCountryExposureBetweenSixMonthMember())));
        amountOfCountryExposureBetweenSixMonthMemberValue.setValue(new BigDecimal(cemItem.getAmountOfCountryExposureBetweenSixMonthMember()));
        JAXBElement<MonetaryItemType> amountOfCountryExposureBetweenSixMonthMember = rbiObjectFactory.createAmountOfCountryExposure(amountOfCountryExposureBetweenSixMonthMemberValue);
        bodyItems.add(amountOfCountryExposureBetweenSixMonthMember);

        // create AmountOfCountryExposureOverSixMonthsAndUptoOneYearMember
        MonetaryItemType amountOfCountryExposureOverSixMonthsAndUptoOneYearMemberValue = new MonetaryItemType();
        amountOfCountryExposureOverSixMonthsAndUptoOneYearMemberValue.setContextRef(asofoversixmonthsanduptooneyearmember);  
        amountOfCountryExposureOverSixMonthsAndUptoOneYearMemberValue.setUnitRef(currency);
        amountOfCountryExposureOverSixMonthsAndUptoOneYearMemberValue.setDecimals(String.format("%s", CommonFns.getDecimals(cemItem.getAmountOfCountryExposureOverSixMonthsAndUptoOneYearMember())));
        amountOfCountryExposureOverSixMonthsAndUptoOneYearMemberValue.setValue(new BigDecimal(cemItem.getAmountOfCountryExposureOverSixMonthsAndUptoOneYearMember()));
        JAXBElement<MonetaryItemType> amountOfCountryExposureOverSixMonthsAndUptoOneYearMember = rbiObjectFactory.createAmountOfCountryExposure(amountOfCountryExposureOverSixMonthsAndUptoOneYearMemberValue);
        bodyItems.add(amountOfCountryExposureOverSixMonthsAndUptoOneYearMember);

        // create AmountOfCountryExposureOverOneYearAndUptoFiveYearMember
        MonetaryItemType amountOfCountryExposureOverOneYearAndUptoFiveYearMemberValue = new MonetaryItemType();
        amountOfCountryExposureOverOneYearAndUptoFiveYearMemberValue.setContextRef(asofoveroneyearanduptofiveyearmember);  
        amountOfCountryExposureOverOneYearAndUptoFiveYearMemberValue.setUnitRef(currency);
        amountOfCountryExposureOverOneYearAndUptoFiveYearMemberValue.setDecimals(String.format("%s", CommonFns.getDecimals(cemItem.getAmountOfCountryExposureOverOneYearAndUptoFiveYearMember())));
        amountOfCountryExposureOverOneYearAndUptoFiveYearMemberValue.setValue(new BigDecimal(cemItem.getAmountOfCountryExposureOverOneYearAndUptoFiveYearMember()));
        JAXBElement<MonetaryItemType> amountOfCountryExposureOverOneYearAndUptoFiveYearMember = rbiObjectFactory.createAmountOfCountryExposure(amountOfCountryExposureOverOneYearAndUptoFiveYearMemberValue);
        bodyItems.add(amountOfCountryExposureOverOneYearAndUptoFiveYearMember);

        // create AmountOfCountryExposureOverFiveYearsMember
        MonetaryItemType amountOfCountryExposureOverFiveYearsMemberValue = new MonetaryItemType();
        amountOfCountryExposureOverFiveYearsMemberValue.setContextRef(asofoverfiveyearsmember);  
        amountOfCountryExposureOverFiveYearsMemberValue.setUnitRef(currency);
        amountOfCountryExposureOverFiveYearsMemberValue.setDecimals(String.format("%s", CommonFns.getDecimals(cemItem.getAmountOfCountryExposureOverFiveYearsMember())));
        amountOfCountryExposureOverFiveYearsMemberValue.setValue(new BigDecimal(cemItem.getAmountOfCountryExposureOverFiveYearsMember()));
        JAXBElement<MonetaryItemType> amountOfCountryExposureOverFiveYearsMember = rbiObjectFactory.createAmountOfCountryExposure(amountOfCountryExposureOverFiveYearsMemberValue);
        bodyItems.add(amountOfCountryExposureOverFiveYearsMember);

        // create amountOfCountryExposureRiskClassification
        MonetaryItemType amountOfCountryExposureRiskClassificationValue = new MonetaryItemType();
        amountOfCountryExposureRiskClassificationValue.setContextRef(asofriskclassification);  
        amountOfCountryExposureRiskClassificationValue.setUnitRef(currency);
        amountOfCountryExposureRiskClassificationValue.setDecimals(String.format("%s", CommonFns.getDecimals(cemItem.getAmountOfCountryExposureRiskClassification())));
        amountOfCountryExposureRiskClassificationValue.setValue(new BigDecimal(cemItem.getAmountOfCountryExposureRiskClassification()));
        JAXBElement<MonetaryItemType> amountOfCountryExposureRiskClassification = rbiObjectFactory.createAmountOfCountryExposure(amountOfCountryExposureRiskClassificationValue);
        bodyItems.add(amountOfCountryExposureRiskClassification);


        return bodyItems;
            
        }
    
}
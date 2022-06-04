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

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ValidationStatusItemType;
import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ReportStatusItemType;
import org.xbrl._2003.instance.BooleanItemType;
import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.CategoriesOfBanks;
import java.util.List;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.IntegerItemType;

import org.xbrl.dtr.type.non_numeric.TextBlockItemType;


import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCUnit;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;


public class RLCGeneralBodyExtra implements BodyInterface {
     
    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
       
        // TODO add general items related to RLC report
        List<Object> generalItems = new ArrayList<Object>();
        Context fromToContext = contexts.get(RLCUtil.FROMTO);
        Context asOfContext = contexts.get(RLCUtil.ASOF);
        Unit unitINR = units.get(RLCUtil.CURRENCY);
        Unit pureUnit = units.get(RLCUtil.PERCENTAGE);
        RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;
        
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        ////Signatory Details
        // create NameOfSignatory
        StringItemType nameOfSignatoryValue = new StringItemType();
        nameOfSignatoryValue.setContextRef(fromToContext);
        nameOfSignatoryValue.setValue(rlcGeneralData.getRlcGeneralInfo().getNameOfSignatory());
        JAXBElement<StringItemType> nameOfSignatory = rbiObjectFactory.createNameOfSignatory(nameOfSignatoryValue);
        generalItems.add(nameOfSignatory);

        // create DesignationOfSignatory
        StringItemType designationOfSignatoryValue = new StringItemType();
        designationOfSignatoryValue.setContextRef(fromToContext);
        designationOfSignatoryValue.setValue(rlcGeneralData.getRlcGeneralInfo().getDesignationOfSignatory());
        JAXBElement<StringItemType> designationOfSignatory = rbiObjectFactory.createDesignationOfSignatory(designationOfSignatoryValue);
        generalItems.add(designationOfSignatory);

        // create AuthorisedSignatoryMobileNumber
        IntegerItemType authorisedSignatoryMobileNumberValue = new IntegerItemType();
        authorisedSignatoryMobileNumberValue.setContextRef(fromToContext);
        authorisedSignatoryMobileNumberValue.setUnitRef(pureUnit);
        authorisedSignatoryMobileNumberValue.setDecimals("INF");
        authorisedSignatoryMobileNumberValue.setValue(new BigInteger(rlcGeneralData.getRlcGeneralInfo().getAuthorisedSignatoryMobileNumber()));
        JAXBElement<IntegerItemType> authorisedSignatoryMobileNumber = rbiObjectFactory.createAuthorisedSignatoryMobileNumber(authorisedSignatoryMobileNumberValue);
        generalItems.add(authorisedSignatoryMobileNumber);

        // create AuthorisedSignatoryLandlineNumber
        IntegerItemType authorisedSignatoryLandlineNumberValue = new IntegerItemType();
        authorisedSignatoryLandlineNumberValue.setContextRef(fromToContext);
        authorisedSignatoryLandlineNumberValue.setUnitRef(pureUnit);
        authorisedSignatoryLandlineNumberValue.setDecimals("INF");
        authorisedSignatoryLandlineNumberValue.setValue(new BigInteger(rlcGeneralData.getRlcGeneralInfo().getAuthorisedSignatoryLandlineNumber()));
        JAXBElement<IntegerItemType> authorisedSignatoryLandlineNumber = rbiObjectFactory.createAuthorisedSignatoryLandlineNumber(authorisedSignatoryLandlineNumberValue);
        generalItems.add(authorisedSignatoryLandlineNumber);

        // create EMailIDOfAuthorisedReportingOfficial
        StringItemType eMailIDOfAuthorisedReportingOfficialValue = new StringItemType();
        eMailIDOfAuthorisedReportingOfficialValue.setContextRef(fromToContext);
        eMailIDOfAuthorisedReportingOfficialValue.setValue(rlcGeneralData.getRlcGeneralInfo().getEMailIDOfAuthorisedReportingOfficial());
        JAXBElement<StringItemType> eMailIDOfAuthorisedReportingOfficial = rbiObjectFactory.createEMailIDOfAuthorisedReportingOfficial(eMailIDOfAuthorisedReportingOfficialValue);
        generalItems.add(eMailIDOfAuthorisedReportingOfficial);
        
        return generalItems;
        
    }

   
    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalInfoData, ItemData rosItem) {
        //TODO Auto-generated method stub
        return null;
    }

    
}
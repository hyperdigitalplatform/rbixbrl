package in.armedu.banking.report.rbixbrl.part.alo.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigInteger;
import org.xbrl._2003.instance.IntegerItemType;

import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ValidationStatusItemType;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.DateTimeItemType;
import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ReportStatusItemType;
import org.xbrl.dtr.type.non_numeric.TextBlockItemType;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.alo.ALOGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;

public class ALOSignatoryDetails implements BodyInterface    {
    
    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
        
        ALOGeneralData aloGeneralData = (ALOGeneralData) generalData;
        List<Object> generalItems = new ArrayList<Object>();
        Context fromToContext = contexts.get(ALOUtil.FROMTO);
        Context asOfContext = contexts.get(ALOUtil.ASOF);

        Unit currency = units.get(ALOUtil.CURRENCY);
        Unit percentage = units.get(ALOUtil.PERCENTAGE);
     

        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        // create NameOfSignatory
        StringItemType nameOfSignatoryValue = new StringItemType();
        nameOfSignatoryValue.setContextRef(fromToContext);
        nameOfSignatoryValue.setValue(aloGeneralData.getNameOfSignatory());
        JAXBElement<StringItemType> nameOfSignatory = rbiObjectFactory.createNameOfSignatory(nameOfSignatoryValue);
        generalItems.add(nameOfSignatory);

        // create DesignationOfSignatory
        StringItemType designationOfSignatoryValue = new StringItemType();
        designationOfSignatoryValue.setContextRef(fromToContext);
        designationOfSignatoryValue.setValue(aloGeneralData.getDesignationOfSignatory());
        JAXBElement<StringItemType> designationOfSignatory = rbiObjectFactory.createDesignationOfSignatory(designationOfSignatoryValue);
        generalItems.add(designationOfSignatory);

        // create AuthorisedSignatoryMobileNumber
        IntegerItemType authorisedSignatoryMobileNumberValue = new IntegerItemType();
        authorisedSignatoryMobileNumberValue.setContextRef(fromToContext); 
        authorisedSignatoryMobileNumberValue.setDecimals("INF");
        authorisedSignatoryMobileNumberValue.setUnitRef(percentage);
        authorisedSignatoryMobileNumberValue.setValue(new BigInteger(aloGeneralData.getAuthorisedSignatoryMobileNumber()));
        JAXBElement<IntegerItemType> authorisedSignatoryMobileNumber = rbiObjectFactory.createAuthorisedSignatoryMobileNumber(authorisedSignatoryMobileNumberValue);
        generalItems.add(authorisedSignatoryMobileNumber);

        // create AuthorisedSignatoryLandlineNumber
        IntegerItemType authorisedSignatoryLandlineNumberValue = new IntegerItemType();
        authorisedSignatoryLandlineNumberValue.setContextRef(fromToContext); 
        authorisedSignatoryLandlineNumberValue.setDecimals("INF");
        authorisedSignatoryLandlineNumberValue.setUnitRef(percentage);
        authorisedSignatoryLandlineNumberValue.setValue(new BigInteger(aloGeneralData.getAuthorisedSignatoryLandlineNumber()));
        JAXBElement<IntegerItemType> authorisedSignatoryLandlineNumber = rbiObjectFactory.createAuthorisedSignatoryLandlineNumber(authorisedSignatoryLandlineNumberValue);
        generalItems.add(authorisedSignatoryLandlineNumber);

        // create EMailIDOfAuthorisedReportingOfficial
        StringItemType eMailIDOfAuthorisedReportingOfficialValue = new StringItemType();
        eMailIDOfAuthorisedReportingOfficialValue.setContextRef(asOfContext);
        eMailIDOfAuthorisedReportingOfficialValue.setValue(aloGeneralData.getEMailIDOfAuthorisedReportingOfficial());
        JAXBElement<StringItemType> eMailIDOfAuthorisedReportingOfficial = rbiObjectFactory.createEMailIDOfAuthorisedReportingOfficial(eMailIDOfAuthorisedReportingOfficialValue);
        generalItems.add(eMailIDOfAuthorisedReportingOfficial);

        // create PlaceOfSignature
        StringItemType placeOfSignatureValue = new StringItemType();
        placeOfSignatureValue.setContextRef(fromToContext);
        placeOfSignatureValue.setValue(aloGeneralData.getPlaceOfSignature());
        JAXBElement<StringItemType> placeOfSignature = rbiObjectFactory.createPlaceOfSignature(placeOfSignatureValue);
        generalItems.add(placeOfSignature);

        // create DateOfDocumentAuthorisation
        DateTimeItemType dateOfDocumentAuthorisationValue = new DateTimeItemType();
        dateOfDocumentAuthorisationValue.setContextRef(asOfContext);
        dateOfDocumentAuthorisationValue.setValue(aloGeneralData.getDateOfDocumentAuthorisation());
        JAXBElement<DateTimeItemType> dateOfDocumentAuthorisation = rbiObjectFactory.createDateOfDocumentAuthorisation(dateOfDocumentAuthorisationValue);
        generalItems.add(dateOfDocumentAuthorisation);

        
        return generalItems;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalInfoData, ItemData rosItem) {
        // TODO Auto-generated method stub
        return null;
    }


}

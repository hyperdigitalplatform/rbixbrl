package in.armedu.banking.report.rbixbrl.part.cem.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigInteger;
import org.xbrl._2003.instance.IntegerItemType;

import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.cem.CEMGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;

public class CEMSignatoryDetails implements BodyInterface    {
    
    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
        
        CEMGeneralData cemGeneralData = (CEMGeneralData) generalData;
        List<Object> generalItems = new ArrayList<Object>();
        Context fromToContext = contexts.get(CEMUtil.FROMTO);
        Context asOfContext = contexts.get(CEMUtil.ASOF);

        Unit currency = units.get(CEMUtil.CURRENCY);
        Unit percentage = units.get(CEMUtil.PERCENTAGE);
     
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        // create NameOfSignatory
        StringItemType nameOfSignatoryValue = new StringItemType();
        nameOfSignatoryValue.setContextRef(fromToContext);
        nameOfSignatoryValue.setValue(cemGeneralData.getNameOfSignatory());
        JAXBElement<StringItemType> nameOfSignatory = rbiObjectFactory.createNameOfSignatory(nameOfSignatoryValue);
        generalItems.add(nameOfSignatory);

        // create DesignationOfSignatory
        StringItemType designationOfSignatoryValue = new StringItemType();
        designationOfSignatoryValue.setContextRef(fromToContext);
        designationOfSignatoryValue.setValue(cemGeneralData.getDesignationOfSignatory());
        JAXBElement<StringItemType> designationOfSignatory = rbiObjectFactory.createDesignationOfSignatory(designationOfSignatoryValue);
        generalItems.add(designationOfSignatory);

        // create AuthorisedSignatoryMobileNumber
        IntegerItemType authorisedSignatoryMobileNumberValue = new IntegerItemType();
        authorisedSignatoryMobileNumberValue.setContextRef(fromToContext); 
        authorisedSignatoryMobileNumberValue.setDecimals("INF");
        authorisedSignatoryMobileNumberValue.setUnitRef(percentage);
        authorisedSignatoryMobileNumberValue.setValue(new BigInteger(cemGeneralData.getAuthorisedSignatoryMobileNumber()));
        JAXBElement<IntegerItemType> authorisedSignatoryMobileNumber = rbiObjectFactory.createAuthorisedSignatoryMobileNumber(authorisedSignatoryMobileNumberValue);
        generalItems.add(authorisedSignatoryMobileNumber);

        // create AuthorisedSignatoryLandlineNumber
        IntegerItemType authorisedSignatoryLandlineNumberValue = new IntegerItemType();
        authorisedSignatoryLandlineNumberValue.setContextRef(fromToContext); 
        authorisedSignatoryLandlineNumberValue.setDecimals("INF");
        authorisedSignatoryLandlineNumberValue.setUnitRef(percentage);
        authorisedSignatoryLandlineNumberValue.setValue(new BigInteger(cemGeneralData.getAuthorisedSignatoryLandlineNumber()));
        JAXBElement<IntegerItemType> authorisedSignatoryLandlineNumber = rbiObjectFactory.createAuthorisedSignatoryLandlineNumber(authorisedSignatoryLandlineNumberValue);
        generalItems.add(authorisedSignatoryLandlineNumber);

        // create EMailIDOfAuthorisedReportingOfficial
        StringItemType eMailIDOfAuthorisedReportingOfficialValue = new StringItemType();
        eMailIDOfAuthorisedReportingOfficialValue.setContextRef(asOfContext);
        eMailIDOfAuthorisedReportingOfficialValue.setValue(cemGeneralData.getEMailIDOfAuthorisedReportingOfficial());
        JAXBElement<StringItemType> eMailIDOfAuthorisedReportingOfficial = rbiObjectFactory.createEMailIDOfAuthorisedReportingOfficial(eMailIDOfAuthorisedReportingOfficialValue);
        generalItems.add(eMailIDOfAuthorisedReportingOfficial);

        // create PlaceOfSignature
        StringItemType placeOfSignatureValue = new StringItemType();
        placeOfSignatureValue.setContextRef(fromToContext);
        placeOfSignatureValue.setValue(cemGeneralData.getPlaceOfSignature());
        JAXBElement<StringItemType> placeOfSignature = rbiObjectFactory.createPlaceOfSignature(placeOfSignatureValue);
        generalItems.add(placeOfSignature);

        // create DateOfSigning
        DateItemType dateOfSigningValue = new DateItemType();
        dateOfSigningValue.setContextRef(asOfContext);
        dateOfSigningValue.setValue(CEMUtil.toXMLGeo(cemGeneralData.getDateOfSigning()));
        JAXBElement<DateItemType> dateOfSigning = rbiObjectFactory.createDateOfSigning(dateOfSigningValue);
        generalItems.add(dateOfSigning);

        
        return generalItems;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalInfoData, ItemData rosItem) {
        // TODO Auto-generated method stub
        return null;
    }


}

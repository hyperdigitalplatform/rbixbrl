package in.armedu.banking.report.rbixbrl.part.fmr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.math.BigInteger;

import javax.xml.bind.JAXBElement;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ReportStatusItemType;
import org.xbrl._2003.instance.BooleanItemType;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.IntegerItemType;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.fmr.FMRGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;

public class FMRGeneralBodyForAuthorizedReport implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
        List<Object> generalItems = new ArrayList<Object>();
        Context fromToContext = contexts.get(FMRUtil.FROMTO);
   
        FMRGeneralData fmrGeneralData = (FMRGeneralData) generalData;
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        // create NameOfAuthorisedReportingOfficial
        StringItemType nameOfAuthorisedReportingOfficialType = new StringItemType();
        nameOfAuthorisedReportingOfficialType.setContextRef(fromToContext);
        nameOfAuthorisedReportingOfficialType.setValue(fmrGeneralData.getAuthorizedReporting().getNameOfAuthorisedReportingOfficial());
        JAXBElement<StringItemType> nameOfAuthorisedReportingOfficial = rbiObjectFactory.createNameOfAuthorisedReportingOfficial(nameOfAuthorisedReportingOfficialType);
        generalItems.add(nameOfAuthorisedReportingOfficial);

        // create NameOfPersonCountersigned
        StringItemType nameOfPersonCountersignedType = new StringItemType();
        nameOfPersonCountersignedType.setContextRef(fromToContext);
        nameOfPersonCountersignedType.setValue(fmrGeneralData.getAuthorizedReporting().getNameOfPersonCountersigned());
        JAXBElement<StringItemType> nameOfPersonCountersigned = rbiObjectFactory.createNameOfPersonCountersigned(nameOfPersonCountersignedType);
        generalItems.add(nameOfPersonCountersigned);

        // create DesignationOfAuthorisedReportingOfficial
        StringItemType designationOfAuthorisedReportingOfficialType = new StringItemType();
        designationOfAuthorisedReportingOfficialType.setContextRef(fromToContext);
        designationOfAuthorisedReportingOfficialType.setValue(fmrGeneralData.getAuthorizedReporting().getDesignationOfAuthorisedReportingOfficial());
        JAXBElement<StringItemType> designationOfAuthorisedReportingOfficial = rbiObjectFactory.createDesignationOfAuthorisedReportingOfficial(designationOfAuthorisedReportingOfficialType);
        generalItems.add(designationOfAuthorisedReportingOfficial);

        // create DesignationOfPersonCountersigned
        StringItemType designationOfPersonCountersignedType = new StringItemType();
        designationOfPersonCountersignedType.setContextRef(fromToContext);
        designationOfPersonCountersignedType.setValue(fmrGeneralData.getAuthorizedReporting().getDesignationOfPersonCountersigned());
        JAXBElement<StringItemType> designationOfPersonCountersigned = rbiObjectFactory.createDesignationOfPersonCountersigned(designationOfPersonCountersignedType);
        generalItems.add(designationOfPersonCountersigned);

        // create EMailIDOfAuthorisedReportingOfficial
        StringItemType eMailIDOfAuthorisedReportingOfficialType = new StringItemType();
        eMailIDOfAuthorisedReportingOfficialType.setContextRef(fromToContext);
        eMailIDOfAuthorisedReportingOfficialType.setValue(fmrGeneralData.getAuthorizedReporting().getEMailIDOfAuthorisedReportingOfficial());
        JAXBElement<StringItemType> eMailIDOfAuthorisedReportingOfficial = rbiObjectFactory.createEMailIDOfAuthorisedReportingOfficial(eMailIDOfAuthorisedReportingOfficialType);
        generalItems.add(eMailIDOfAuthorisedReportingOfficial);

       // create EMailIDOfPersonCountersigned
        StringItemType eMailIDOfPersonCountersignedType = new StringItemType();
        eMailIDOfPersonCountersignedType.setContextRef(fromToContext);
        eMailIDOfPersonCountersignedType.setValue(fmrGeneralData.getAuthorizedReporting().getEMailIDOfPersonCountersigned());
        JAXBElement<StringItemType> eMailIDOfPersonCountersigned = rbiObjectFactory.createEMailIDOfPersonCountersigned(eMailIDOfPersonCountersignedType);
        generalItems.add(eMailIDOfPersonCountersigned);

        // create OfficeTelephoneNumberOfAuthorisedReportingOfficial
        IntegerItemType officeTelephoneNumberOfAuthorisedReportingOfficialType = new IntegerItemType();
        officeTelephoneNumberOfAuthorisedReportingOfficialType.setContextRef(fromToContext);
        officeTelephoneNumberOfAuthorisedReportingOfficialType.setValue(new BigInteger(fmrGeneralData.getAuthorizedReporting().getOfficeTelephoneNumberOfAuthorisedReportingOfficial()));
        JAXBElement<IntegerItemType> officeTelephoneNumberOfAuthorisedReportingOfficial = rbiObjectFactory.createOfficeTelephoneNumberOfAuthorisedReportingOfficial(officeTelephoneNumberOfAuthorisedReportingOfficialType);
        generalItems.add(officeTelephoneNumberOfAuthorisedReportingOfficial);

        // create OfficeTelephoneNumberOfPersonCountersigned
        IntegerItemType officeTelephoneNumberOfPersonCountersignedType = new IntegerItemType();
        officeTelephoneNumberOfPersonCountersignedType.setContextRef(fromToContext);
        officeTelephoneNumberOfPersonCountersignedType.setValue(new BigInteger(fmrGeneralData.getAuthorizedReporting().getOfficeTelephoneNumberOfPersonCountersigned()));
        JAXBElement<IntegerItemType> officeTelephoneNumberOfPersonCountersigned = rbiObjectFactory.createOfficeTelephoneNumberOfPersonCountersigned(officeTelephoneNumberOfPersonCountersignedType);
        generalItems.add(officeTelephoneNumberOfPersonCountersigned);

        // create ResidenceTelephoneNumberOfAuthorisedReportingOfficial
        IntegerItemType residenceTelephoneNumberOfAuthorisedReportingOfficialType = new IntegerItemType();
        residenceTelephoneNumberOfAuthorisedReportingOfficialType.setContextRef(fromToContext);
        residenceTelephoneNumberOfAuthorisedReportingOfficialType.setValue(new BigInteger(fmrGeneralData.getAuthorizedReporting().getResidenceTelephoneNumberOfAuthorisedReportingOfficial()));
        JAXBElement<IntegerItemType> residenceTelephoneNumberOfAuthorisedReportingOfficial = rbiObjectFactory.createResidenceTelephoneNumberOfAuthorisedReportingOfficial(residenceTelephoneNumberOfAuthorisedReportingOfficialType);
        generalItems.add(residenceTelephoneNumberOfAuthorisedReportingOfficial);

        // create ResidenceTelephoneNumberOfPersonCountersigned
        IntegerItemType residenceTelephoneNumberOfPersonCountersignedType = new IntegerItemType();
        residenceTelephoneNumberOfPersonCountersignedType.setContextRef(fromToContext);
        residenceTelephoneNumberOfPersonCountersignedType.setValue(new BigInteger(fmrGeneralData.getAuthorizedReporting().getResidenceTelephoneNumberOfPersonCountersigned()));
        JAXBElement<IntegerItemType> residenceTelephoneNumberOfPersonCountersigned = rbiObjectFactory.createResidenceTelephoneNumberOfPersonCountersigned(residenceTelephoneNumberOfPersonCountersignedType);
        generalItems.add(residenceTelephoneNumberOfPersonCountersigned);

        // create FaxNumberOfAuthorisedReportingOfficial
        IntegerItemType faxNumberOfAuthorisedReportingOfficialType = new IntegerItemType();
        faxNumberOfAuthorisedReportingOfficialType.setContextRef(fromToContext);
        faxNumberOfAuthorisedReportingOfficialType.setValue(new BigInteger(fmrGeneralData.getAuthorizedReporting().getFaxNumberOfAuthorisedReportingOfficial()));
        JAXBElement<IntegerItemType> faxNumberOfAuthorisedReportingOfficial = rbiObjectFactory.createFaxNumberOfAuthorisedReportingOfficial(faxNumberOfAuthorisedReportingOfficialType);
        generalItems.add(faxNumberOfAuthorisedReportingOfficial);

        // create FaxNumberOfPersonCountersigned
        IntegerItemType faxNumberOfPersonCountersignedType = new IntegerItemType();
        faxNumberOfPersonCountersignedType.setContextRef(fromToContext);
        faxNumberOfPersonCountersignedType.setValue(new BigInteger(fmrGeneralData.getAuthorizedReporting().getFaxNumberOfPersonCountersigned()));
        JAXBElement<IntegerItemType> faxNumberOfPersonCountersigned = rbiObjectFactory.createFaxNumberOfPersonCountersigned(faxNumberOfPersonCountersignedType);
        generalItems.add(faxNumberOfPersonCountersigned);

        // create PlaceOfSigningByAuthorisedReportingOfficial
        StringItemType placeOfSigningByAuthorisedReportingOfficialType = new StringItemType();
        placeOfSigningByAuthorisedReportingOfficialType.setContextRef(fromToContext);
        placeOfSigningByAuthorisedReportingOfficialType.setValue(fmrGeneralData.getAuthorizedReporting().getPlaceOfSigningByAuthorisedReportingOfficial());
        JAXBElement<StringItemType> placeOfSigningByAuthorisedReportingOfficial = rbiObjectFactory.createPlaceOfSigningByAuthorisedReportingOfficial(placeOfSigningByAuthorisedReportingOfficialType);
        generalItems.add(placeOfSigningByAuthorisedReportingOfficial);

        // create PlaceOfSigningByPersonCountersigned
        StringItemType placeOfSigningByPersonCountersignedType = new StringItemType();
        placeOfSigningByPersonCountersignedType.setContextRef(fromToContext);
        placeOfSigningByPersonCountersignedType.setValue(fmrGeneralData.getAuthorizedReporting().getPlaceOfSigningByPersonCountersigned());
        JAXBElement<StringItemType> placeOfSigningByPersonCountersigned = rbiObjectFactory.createPlaceOfSigningByPersonCountersigned(placeOfSigningByPersonCountersignedType);
        generalItems.add(placeOfSigningByPersonCountersigned);

        // create DateOfSigningByAuthorisedReportingOfficial
        DateItemType dateOfSigningByAuthorisedReportingOfficialType = new DateItemType();
        dateOfSigningByAuthorisedReportingOfficialType.setContextRef(fromToContext);
        dateOfSigningByAuthorisedReportingOfficialType.setValue(FMRUtil.toXMLGeo(fmrGeneralData.getAuthorizedReporting().getDateOfSigningByAuthorisedReportingOfficial()));
        JAXBElement<DateItemType> dateOfSigningByAuthorisedReportingOfficial = rbiObjectFactory.createDateOfSigningByAuthorisedReportingOfficial(dateOfSigningByAuthorisedReportingOfficialType);
        generalItems.add(dateOfSigningByAuthorisedReportingOfficial);

        // create DateOfSigningByPersonCountersigned
        DateItemType dateOfSigningByPersonCountersignedType = new DateItemType();
        dateOfSigningByPersonCountersignedType.setContextRef(fromToContext);
        dateOfSigningByPersonCountersignedType.setValue(FMRUtil.toXMLGeo(fmrGeneralData.getAuthorizedReporting().getDateOfSigningByPersonCountersigned()));
        JAXBElement<DateItemType> dateOfSigningByPersonCountersigned = rbiObjectFactory.createDateOfSigningByPersonCountersigned(dateOfSigningByPersonCountersignedType);
        generalItems.add(dateOfSigningByPersonCountersigned);
        
        return generalItems;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalInfoData, ItemData rosItem) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
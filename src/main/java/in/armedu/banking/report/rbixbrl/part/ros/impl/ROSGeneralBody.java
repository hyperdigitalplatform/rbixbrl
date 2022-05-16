package in.armedu.banking.report.rbixbrl.part.ros.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ValidationStatusItemType;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.ros.ROSGeneralInfoData;
import in.armedu.banking.report.rbixbrl.part.BodyIntf;


public class ROSGeneralBody implements BodyIntf {


    @Override
    public List<Object> getReportBodyItem(List<Context> contexts, GeneralData generalData) {
        ROSGeneralInfoData generalInfoData = (ROSGeneralInfoData) generalData;

        return getReportBodyItemOnlyForFromToAndASOF(contexts.get(0), contexts.get(1), generalInfoData);
    }
    
    
    public List<Object> getReportBodyItemOnlyForFromToAndASOF(Context fromToContext, Context asOfContext, ROSGeneralInfoData generalInfoData) {
        List<Object> generalItems = new ArrayList<Object>();

        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
        // create return name
        StringItemType returnNameValue = new StringItemType();
        returnNameValue.setContextRef(fromToContext);
        
        returnNameValue.setValue(generalInfoData.getReturnName());
        JAXBElement<StringItemType> returnName = rbiObjectFactory.createReturnName(returnNameValue);
        generalItems.add(returnName);
        // create return code
        StringItemType returnCodeValue = new StringItemType();
        returnCodeValue.setContextRef(fromToContext);
        returnCodeValue.setValue(generalInfoData.getReturnCode());
        JAXBElement<StringItemType> returnCode = rbiObjectFactory.createReturnCode(returnCodeValue);
        generalItems.add(returnCode);
        // create NameOfReportingInstitution
        StringItemType nameOfReportingInstitutionValue = new StringItemType();
        nameOfReportingInstitutionValue.setContextRef(fromToContext);
        nameOfReportingInstitutionValue.setValue(generalInfoData.getReportInstitution());
        JAXBElement<StringItemType> nameOfReportingInstitution = rbiObjectFactory.createNameOfReportingInstitution(nameOfReportingInstitutionValue);
        generalItems.add(nameOfReportingInstitution);
        // create bankCodeValue
        StringItemType bankCodeValue = new StringItemType();
        bankCodeValue.setContextRef(asOfContext);
        bankCodeValue.setValue(generalInfoData.getBankCode());
        JAXBElement<StringItemType> bankCode = rbiObjectFactory.createBankCode(bankCodeValue);
        generalItems.add(bankCode);
        // create AddressOfReportingInstitution
        StringItemType addressOfReportingInstitutionValue = new StringItemType();
        addressOfReportingInstitutionValue.setContextRef(fromToContext);
        addressOfReportingInstitutionValue.setValue(generalInfoData.getInstitutionAddress());
        JAXBElement<StringItemType> addressOfReportingInstitution = rbiObjectFactory.createAddressOfReportingInstitution(addressOfReportingInstitutionValue);
        generalItems.add(addressOfReportingInstitution);
        // create ReportingFrequency
        StringItemType reportingFrequencyValue = new StringItemType();
        reportingFrequencyValue.setContextRef(fromToContext);
        reportingFrequencyValue.setValue(generalInfoData.getReportingFrequency());
        JAXBElement<StringItemType> reportingFrequency = rbiObjectFactory.createReportingFrequency(reportingFrequencyValue);
        generalItems.add(reportingFrequency);
        // create ReportForTheYearEnded
        // TODO : verify the value ??
        DateItemType reportForTheYearEndedValue = new DateItemType();
        reportForTheYearEndedValue.setContextRef(fromToContext);
        reportForTheYearEndedValue.setValue(toXMLGeo(generalInfoData.getDateOfReport()));
        JAXBElement<DateItemType> reportForTheYearEnded = rbiObjectFactory.createReportForTheYearEnded(reportForTheYearEndedValue);
        generalItems.add(reportForTheYearEnded);
        // create DateOfReport
        DateItemType dateOfReportValue = new DateItemType();
        dateOfReportValue.setContextRef(asOfContext);
        dateOfReportValue.setValue(toXMLGeo(generalInfoData.getDateOfReport()));
        JAXBElement<DateItemType> dateOfReport = rbiObjectFactory.createDateOfReport(dateOfReportValue);
        generalItems.add(dateOfReport);
        // create ValidationStatus
        ValidationStatusItemType validationStatusValue = new ValidationStatusItemType();
        validationStatusValue.setContextRef(fromToContext);
        validationStatusValue.setValue(generalInfoData.getValidationStatus());
        JAXBElement<ValidationStatusItemType> validationStatus = rbiObjectFactory.createValidationStatus(validationStatusValue);
        generalItems.add(validationStatus);
        // create ReturnVersion
        StringItemType returnVersionValue = new StringItemType();
        returnVersionValue.setContextRef(fromToContext);
        returnVersionValue.setValue(generalInfoData.getReturnVersion());
        JAXBElement<StringItemType> returnVersion = rbiObjectFactory.createReturnVersion(returnVersionValue);
        generalItems.add(returnVersion);
        // create ReportingPeriodStartDate
        DateItemType reportingPeriodStartDateValue = new DateItemType();
        reportingPeriodStartDateValue.setContextRef(asOfContext);
        reportingPeriodStartDateValue.setValue(toXMLGeo(generalInfoData.getStartDate()));
        JAXBElement<DateItemType> reportingPeriodStartDate = rbiObjectFactory.createReportingPeriodStartDate(reportingPeriodStartDateValue);
        generalItems.add(reportingPeriodStartDate);
        
        return generalItems;
    }

    private XMLGregorianCalendar toXMLGeo(String dateInStr){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        XMLGregorianCalendar xmlGregCal = null;
        try {
            Date date = format.parse(dateInStr);
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);
            xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            xmlGregCal.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
        return xmlGregCal;
    }

    @Override
    public List<Object> getReportBodyItem(List<Context> contexts, List<Unit> units, GeneralData generalData, ItemData itemData) {
        // TODO Auto-generated method stub
        return null;
    }


}

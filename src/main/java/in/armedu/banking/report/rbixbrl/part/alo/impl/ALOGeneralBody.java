package in.armedu.banking.report.rbixbrl.part.alo.impl;

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

public class ALOGeneralBody implements BodyInterface    {
    
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

        // create return name
        StringItemType returnNameValue = new StringItemType();
        returnNameValue.setContextRef(fromToContext);
        returnNameValue.setValue(aloGeneralData.getReturnName());
        JAXBElement<StringItemType> returnName = rbiObjectFactory.createReturnName(returnNameValue);
        generalItems.add(returnName);

        // create return code
        StringItemType returnCodeValue = new StringItemType();
        returnCodeValue.setContextRef(fromToContext);
        returnCodeValue.setValue(aloGeneralData.getReturnCode());
        JAXBElement<StringItemType> returnCode = rbiObjectFactory.createReturnCode(returnCodeValue);
        generalItems.add(returnCode);

        // create NameOfReportingInstitution
        StringItemType nameOfReportingInstitutionValue = new StringItemType();
        nameOfReportingInstitutionValue.setContextRef(fromToContext);
        nameOfReportingInstitutionValue.setValue(aloGeneralData.getNameOfReportingInstitution());
        JAXBElement<StringItemType> nameOfReportingInstitution = rbiObjectFactory.createNameOfReportingInstitution(nameOfReportingInstitutionValue);
        generalItems.add(nameOfReportingInstitution);

        // create bankCodeValue
        StringItemType bankCodeValue = new StringItemType();
        bankCodeValue.setContextRef(asOfContext);
        bankCodeValue.setValue(aloGeneralData.getBankCode());
        JAXBElement<StringItemType> bankCode = rbiObjectFactory.createBankCode(bankCodeValue);
        generalItems.add(bankCode);

        // create address
        StringItemType addressValue = new StringItemType();
        addressValue.setContextRef(fromToContext);
        addressValue.setValue(aloGeneralData.getAddress());
        JAXBElement<StringItemType> address = rbiObjectFactory.createAddress(addressValue);
        generalItems.add(address);

        // create DateOfQuarterEnded
        DateTimeItemType dateOfQuarterEndedValue = new DateTimeItemType();
        dateOfQuarterEndedValue.setContextRef(asOfContext);
        dateOfQuarterEndedValue.setValue(aloGeneralData.getDateOfQuarterEnded());
        JAXBElement<DateTimeItemType> dateOfQuarterEnded = rbiObjectFactory.createDateOfQuarterEnded(dateOfQuarterEndedValue);
        generalItems.add(dateOfQuarterEnded);

        // create ReportingFrequency
        StringItemType reportingFrequencyValue = new StringItemType();
        reportingFrequencyValue.setContextRef(fromToContext);
        reportingFrequencyValue.setValue(aloGeneralData.getReportingFrequency());
        JAXBElement<StringItemType> reportingFrequency = rbiObjectFactory.createReportingFrequency(reportingFrequencyValue);
        generalItems.add(reportingFrequency);

        // create DateOfReport
        DateItemType dateOfReportValue = new DateItemType();
        dateOfReportValue.setContextRef(asOfContext);
        dateOfReportValue.setValue(ALOUtil.toXMLGeo(aloGeneralData.getDateOfReport()));
        JAXBElement<DateItemType> dateOfReport = rbiObjectFactory.createDateOfReport(dateOfReportValue);
        generalItems.add(dateOfReport);

        // create ReportStatus
        ReportStatusItemType reportStatusValue = new ReportStatusItemType();
        reportStatusValue.setContextRef(fromToContext);
        reportStatusValue.setValue(aloGeneralData.getReportStatus());
        JAXBElement<ReportStatusItemType> reportStatus = rbiObjectFactory.createReportStatus(reportStatusValue);
        generalItems.add(reportStatus);

        // create DateOfAudit
        DateItemType dateOfAuditValue = new DateItemType();
        dateOfAuditValue.setContextRef(asOfContext);
        dateOfAuditValue.setValue(ALOUtil.toXMLGeo(aloGeneralData.getDateOfAudit()));
        JAXBElement<DateItemType> dateOfAudit = rbiObjectFactory.createDateOfAudit(dateOfAuditValue);
        generalItems.add(dateOfAudit);

        // create ValidationStatus
        ValidationStatusItemType validationStatusValue = new ValidationStatusItemType();
        validationStatusValue.setContextRef(fromToContext);
        validationStatusValue.setValue(aloGeneralData.getValidationStatus());
        JAXBElement<ValidationStatusItemType> validationStatus = rbiObjectFactory.createValidationStatus(validationStatusValue);
        generalItems.add(validationStatus);

        // create ReturnVersion
        StringItemType returnVersionValue = new StringItemType();
        returnVersionValue.setContextRef(fromToContext);
        returnVersionValue.setValue(aloGeneralData.getReturnVersion());
        JAXBElement<StringItemType> returnVersion = rbiObjectFactory.createReturnVersion(returnVersionValue);
        generalItems.add(returnVersion);

        // create GeneralRemarks
        TextBlockItemType generalRemarksValue = new TextBlockItemType();
        generalRemarksValue.setContextRef(fromToContext);
        generalRemarksValue.setValue(aloGeneralData.getGeneralRemarks());
        JAXBElement<TextBlockItemType> generalRemarks = rbiObjectFactory.createGeneralRemarks(generalRemarksValue);
        generalItems.add(generalRemarks);

        // create ReportingPeriodStartDate
        DateItemType reportingPeriodStartDateValue = new DateItemType();
        reportingPeriodStartDateValue.setContextRef(asOfContext);
        reportingPeriodStartDateValue.setValue(ALOUtil.toXMLGeo(aloGeneralData.getReportingPeriodStartDate()));
        JAXBElement<DateItemType> reportingPeriodStartDate = rbiObjectFactory.createReportingPeriodStartDate(reportingPeriodStartDateValue);
        generalItems.add(reportingPeriodStartDate);
        
        return generalItems;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalInfoData, ItemData rosItem) {
        // TODO Auto-generated method stub
        return null;
    }


}

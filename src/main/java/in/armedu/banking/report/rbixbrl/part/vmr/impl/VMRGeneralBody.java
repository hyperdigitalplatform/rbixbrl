package in.armedu.banking.report.rbixbrl.part.vmr.impl;

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
import in.armedu.banking.report.rbixbrl.model.vmr.VMRGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;

public class VMRGeneralBody implements BodyInterface    {
    
    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
        
        VMRGeneralData vmrGeneralData = (VMRGeneralData) generalData;
        List<Object> generalItems = new ArrayList<Object>();
        Context fromToContext = contexts.get(VMRUtil.FROMTO);
        Context asOfContext = contexts.get(VMRUtil.ASOF);

        Unit percentage = units.get(VMRUtil.PERCENTAGE);
     

        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        // create NameOfReportingInstitution
        StringItemType nameOfReportingInstitutionValue = new StringItemType();
        nameOfReportingInstitutionValue.setContextRef(fromToContext);
        nameOfReportingInstitutionValue.setValue(vmrGeneralData.getNameOfReportingInstitution());
        JAXBElement<StringItemType> nameOfReportingInstitution = rbiObjectFactory.createNameOfReportingInstitution(nameOfReportingInstitutionValue);
        generalItems.add(nameOfReportingInstitution);

        // create DateOfQuarterEnded
        DateTimeItemType dateOfQuarterEndedValue = new DateTimeItemType();
        dateOfQuarterEndedValue.setContextRef(asOfContext);
        dateOfQuarterEndedValue.setValue(vmrGeneralData.getDateOfQuarterEnded());
        JAXBElement<DateTimeItemType> dateOfQuarterEnded = rbiObjectFactory.createDateOfQuarterEnded(dateOfQuarterEndedValue);
        generalItems.add(dateOfQuarterEnded);

        // create DateOfSubmission
        DateItemType dateOfSubmissionValue = new DateItemType();
        dateOfSubmissionValue.setContextRef(asOfContext);
        dateOfSubmissionValue.setValue(VMRUtil.toXMLGeo(vmrGeneralData.getDateOfSubmission()));
        JAXBElement<DateItemType> dateOfSubmission = rbiObjectFactory.createDateOfSubmission(dateOfSubmissionValue);
        generalItems.add(dateOfSubmission);

        // create return name
        StringItemType returnNameValue = new StringItemType();
        returnNameValue.setContextRef(fromToContext);
        returnNameValue.setValue(vmrGeneralData.getReturnName());
        JAXBElement<StringItemType> returnName = rbiObjectFactory.createReturnName(returnNameValue);
        generalItems.add(returnName);

        // create return code
        StringItemType returnCodeValue = new StringItemType();
        returnCodeValue.setContextRef(fromToContext);
        returnCodeValue.setValue(vmrGeneralData.getReturnCode());
        JAXBElement<StringItemType> returnCode = rbiObjectFactory.createReturnCode(returnCodeValue);
        generalItems.add(returnCode);

        // create bankCodeValue
        StringItemType bankCodeValue = new StringItemType();
        bankCodeValue.setContextRef(asOfContext);
        bankCodeValue.setValue(vmrGeneralData.getBankCode());
        JAXBElement<StringItemType> bankCode = rbiObjectFactory.createBankCode(bankCodeValue);
        generalItems.add(bankCode);
       
        // create ReportingPeriodStartDate
        DateItemType reportingPeriodStartDateValue = new DateItemType();
        reportingPeriodStartDateValue.setContextRef(asOfContext);
        reportingPeriodStartDateValue.setValue(VMRUtil.toXMLGeo(vmrGeneralData.getReportingPeriodStartDate()));
        JAXBElement<DateItemType> reportingPeriodStartDate = rbiObjectFactory.createReportingPeriodStartDate(reportingPeriodStartDateValue);
        generalItems.add(reportingPeriodStartDate);

        // create ReportingFrequency
        StringItemType reportingFrequencyValue = new StringItemType();
        reportingFrequencyValue.setContextRef(fromToContext);
        reportingFrequencyValue.setValue(vmrGeneralData.getReportingFrequency());
        JAXBElement<StringItemType> reportingFrequency = rbiObjectFactory.createReportingFrequency(reportingFrequencyValue);
        generalItems.add(reportingFrequency);

        // create ReturnVersion
        StringItemType returnVersionValue = new StringItemType();
        returnVersionValue.setContextRef(fromToContext);
        returnVersionValue.setValue(vmrGeneralData.getReturnVersion());
        JAXBElement<StringItemType> returnVersion = rbiObjectFactory.createReturnVersion(returnVersionValue);
        generalItems.add(returnVersion);
        
        return generalItems;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalInfoData, ItemData rosItem) {
        // TODO Auto-generated method stub
        return null;
    }


}

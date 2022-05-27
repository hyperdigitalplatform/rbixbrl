package in.armedu.banking.report.rbixbrl.part.cpr.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ValidationStatusItemType;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.part.BodyIntf;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class CPRGeneralBody implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
        // TODO add general items related to cpr report
        List<Object> generalItems = new ArrayList<Object>();
        Context fromToContext = contexts.get(CPRUtil.FROMTO);
        Context asOfContext = contexts.get(CPRUtil.ASOF);
        Context asOfBookValue = contexts.get(CPRUtil.ASOFBOOKVALUEMEMBER);
        Context asOfMarketValue = contexts.get(CPRUtil.ASOFMARKETVALUEMEMBER);
        Unit currency = units.get(CPRUtil.CURRENCY);
        Unit percentage = units.get(CPRUtil.PERCENTAGE);
        CPRGeneralData cprGeneralData = (CPRGeneralData) generalData;
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
        // create return name
        StringItemType returnNameValue = new StringItemType();
        returnNameValue.setContextRef(fromToContext);
        returnNameValue.setValue(cprGeneralData.getReturnName());
        JAXBElement<StringItemType> returnName = rbiObjectFactory.createReturnName(returnNameValue);
        generalItems.add(returnName);
        // create return code
        StringItemType returnCodeValue = new StringItemType();
        returnCodeValue.setContextRef(fromToContext);
        returnCodeValue.setValue(cprGeneralData.getReturnCode());
        JAXBElement<StringItemType> returnCode = rbiObjectFactory.createReturnCode(returnCodeValue);
        generalItems.add(returnCode);
        // create NameOfReportingInstitution
        StringItemType nameOfReportingInstitutionValue = new StringItemType();
        nameOfReportingInstitutionValue.setContextRef(fromToContext);
        nameOfReportingInstitutionValue.setValue(cprGeneralData.getReportInstitution());
        JAXBElement<StringItemType> nameOfReportingInstitution = rbiObjectFactory.createNameOfReportingInstitution(nameOfReportingInstitutionValue);
        generalItems.add(nameOfReportingInstitution);
        // create bankCodeValue
        StringItemType bankCodeValue = new StringItemType();
        bankCodeValue.setContextRef(asOfContext);
        bankCodeValue.setValue(cprGeneralData.getBankCode());
        JAXBElement<StringItemType> bankCode = rbiObjectFactory.createBankCode(bankCodeValue);
        generalItems.add(bankCode);
        // create AddressOfReportingInstitution
        StringItemType addressOfReportingInstitutionValue = new StringItemType();
        addressOfReportingInstitutionValue.setContextRef(fromToContext);
        addressOfReportingInstitutionValue.setValue(cprGeneralData.getInstitutionAddress());
        JAXBElement<StringItemType> addressOfReportingInstitution = rbiObjectFactory.createAddressOfReportingInstitution(addressOfReportingInstitutionValue);
        generalItems.add(addressOfReportingInstitution);
        // create ReportingFrequency
        StringItemType reportingFrequencyValue = new StringItemType();
        reportingFrequencyValue.setContextRef(fromToContext);
        reportingFrequencyValue.setValue(cprGeneralData.getReportingFrequency());
        JAXBElement<StringItemType> reportingFrequency = rbiObjectFactory.createReportingFrequency(reportingFrequencyValue);
        generalItems.add(reportingFrequency);
        // create ReportForTheYearEnded
        // TODO : verify the value ??
        DateItemType reportForTheYearEndedValue = new DateItemType();
        reportForTheYearEndedValue.setContextRef(fromToContext);
        reportForTheYearEndedValue.setValue(CPRUtil.toXMLGeo(cprGeneralData.getDateOfReport()));
        JAXBElement<DateItemType> reportForTheYearEnded = rbiObjectFactory.createReportForTheYearEnded(reportForTheYearEndedValue);
        generalItems.add(reportForTheYearEnded);
        // create DateOfReport
        DateItemType dateOfReportValue = new DateItemType();
        dateOfReportValue.setContextRef(asOfContext);
        dateOfReportValue.setValue(CPRUtil.toXMLGeo(cprGeneralData.getDateOfReport()));
        JAXBElement<DateItemType> dateOfReport = rbiObjectFactory.createDateOfReport(dateOfReportValue);
        generalItems.add(dateOfReport);
        // create ValidationStatus
        ValidationStatusItemType validationStatusValue = new ValidationStatusItemType();
        validationStatusValue.setContextRef(fromToContext);
        validationStatusValue.setValue(cprGeneralData.getValidationStatus());
        JAXBElement<ValidationStatusItemType> validationStatus = rbiObjectFactory.createValidationStatus(validationStatusValue);
        generalItems.add(validationStatus);
        // create ReturnVersion
        StringItemType returnVersionValue = new StringItemType();
        returnVersionValue.setContextRef(fromToContext);
        returnVersionValue.setValue(cprGeneralData.getReturnVersion());
        JAXBElement<StringItemType> returnVersion = rbiObjectFactory.createReturnVersion(returnVersionValue);
        generalItems.add(returnVersion);
        // create ReportingPeriodStartDate
        DateItemType reportingPeriodStartDateValue = new DateItemType();
        reportingPeriodStartDateValue.setContextRef(asOfContext);
        reportingPeriodStartDateValue.setValue(CPRUtil.toXMLGeo(cprGeneralData.getStartDate()));
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
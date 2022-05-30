package in.armedu.banking.report.rbixbrl.part.fmr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ReportStatusItemType;
import org.xbrl._2003.instance.BooleanItemType;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.fmr.FMRGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;

public class FMRGeneralBody implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
        // TODO add general items related to cpr report
        List<Object> generalItems = new ArrayList<Object>();
        Context fromToContext = contexts.get(FMRUtil.FROMTO);
        Context asOfContext = contexts.get(FMRUtil.ASOF);
        FMRGeneralData fmrGeneralData = (FMRGeneralData) generalData;
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
        // create return name
        StringItemType returnNameValue = new StringItemType();
        returnNameValue.setContextRef(fromToContext);
        returnNameValue.setValue(fmrGeneralData.getReturnName());
        JAXBElement<StringItemType> returnName = rbiObjectFactory.createReturnName(returnNameValue);
        generalItems.add(returnName);
        // create return code
        StringItemType returnCodeValue = new StringItemType();
        returnCodeValue.setContextRef(fromToContext);
        returnCodeValue.setValue(fmrGeneralData.getReturnCode());
        JAXBElement<StringItemType> returnCode = rbiObjectFactory.createReturnCode(returnCodeValue);
        generalItems.add(returnCode);
        // create NameOfReportingInstitution
        StringItemType nameOfReportingInstitutionValue = new StringItemType();
        nameOfReportingInstitutionValue.setContextRef(fromToContext);
        nameOfReportingInstitutionValue.setValue(fmrGeneralData.getReportInstitution());
        JAXBElement<StringItemType> nameOfReportingInstitution = rbiObjectFactory.createNameOfReportingInstitution(nameOfReportingInstitutionValue);
        generalItems.add(nameOfReportingInstitution);
        // create bankCodeValue
        StringItemType bankCodeValue = new StringItemType();
        bankCodeValue.setContextRef(asOfContext);
        bankCodeValue.setValue(fmrGeneralData.getBankCode());
        JAXBElement<StringItemType> bankCode = rbiObjectFactory.createBankCode(bankCodeValue);
        generalItems.add(bankCode);
        
        // create RegionalOfficeName
        StringItemType addressOfReportingInstitutionValue = new StringItemType();
        addressOfReportingInstitutionValue.setContextRef(fromToContext);
        addressOfReportingInstitutionValue.setValue(fmrGeneralData.getInstitutionAddress());
        JAXBElement<StringItemType> addressOfReportingInstitution = rbiObjectFactory.createRegionalOfficeName(addressOfReportingInstitutionValue);
        generalItems.add(addressOfReportingInstitution);
        // create QuarterEndDate
        // TODO : verify the value ??
        DateItemType reportForTheYearEndedValue = new DateItemType();
        reportForTheYearEndedValue.setContextRef(fromToContext);
        reportForTheYearEndedValue.setValue(FMRUtil.toXMLGeo(fmrGeneralData.getQuarterEndDate()));
        JAXBElement<DateItemType> reportForTheYearEnded = rbiObjectFactory.createQuarterEndDate(reportForTheYearEndedValue);
        generalItems.add(reportForTheYearEnded);
        // create DateOfSubmission
        DateItemType dateOfReportValue = new DateItemType();
        dateOfReportValue.setContextRef(asOfContext);
        dateOfReportValue.setValue(FMRUtil.toXMLGeo(fmrGeneralData.getDateOfSubmission()));
        JAXBElement<DateItemType> dateOfReport = rbiObjectFactory.createDateOfSubmission(dateOfReportValue);
        generalItems.add(dateOfReport);
        
        // create ReportingFrequency
        StringItemType reportingFrequencyValue = new StringItemType();
        reportingFrequencyValue.setContextRef(fromToContext);
        reportingFrequencyValue.setValue(fmrGeneralData.getReportingFrequency());
        JAXBElement<StringItemType> reportingFrequency = rbiObjectFactory.createReportingFrequency(reportingFrequencyValue);
        generalItems.add(reportingFrequency);
        // create ReturnVersion
        StringItemType returnVersionValue = new StringItemType();
        returnVersionValue.setContextRef(fromToContext);
        returnVersionValue.setValue(fmrGeneralData.getReturnVersion());
        JAXBElement<StringItemType> returnVersion = rbiObjectFactory.createReturnVersion(returnVersionValue);
        generalItems.add(returnVersion);
        
        // create WhetherNilReporting
        BooleanItemType whetherNilReportingType = new BooleanItemType();
        whetherNilReportingType.setContextRef(fromToContext);
        whetherNilReportingType.setValue(Boolean.valueOf(fmrGeneralData.getWhetherNilReporting()));
        JAXBElement<BooleanItemType> whetherNilReporting = rbiObjectFactory.createWhetherNilReporting(whetherNilReportingType);
        generalItems.add(whetherNilReporting);

        // create ReportStatus
        ReportStatusItemType reportStatusItemType = new ReportStatusItemType();
        reportStatusItemType.setContextRef(fromToContext);
        reportStatusItemType.setValue(fmrGeneralData.getReportStatus());
        JAXBElement<ReportStatusItemType> reportStatusItem = rbiObjectFactory.createReportStatus(reportStatusItemType);
        generalItems.add(reportStatusItem);
        // create ReportingPeriodStartDate
        DateItemType reportingPeriodStartDateValue = new DateItemType();
        reportingPeriodStartDateValue.setContextRef(asOfContext);
        reportingPeriodStartDateValue.setValue(FMRUtil.toXMLGeo(fmrGeneralData.getReportingPeriodStartDate()));
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
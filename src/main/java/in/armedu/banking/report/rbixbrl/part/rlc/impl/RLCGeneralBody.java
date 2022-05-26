package in.armedu.banking.report.rbixbrl.part.rlc.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
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

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
import in.armedu.banking.report.rbixbrl.part.rlc.impl.RLCUnit;
import in.armedu.banking.report.rbixbrl.part.BodyIntf;
import in.armedu.banking.report.rbixbrl.util.CommonFns;


public class RLCGeneralBody implements BodyIntf {

    @Override
    public List<Object> getReportBodyItem(List<Context> contexts, GeneralData generalData) {
        RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;

        return getReportBodyItemOnlyForFromToAndASOF(contexts.get(0), contexts.get(1), 
        contexts.get(2), contexts.get(3), rlcGeneralData);
 
    }

    public List<Object> getReportBodyItemOnlyForFromToAndASOF(Context fromToContext, Context asOfContext,
    Context asOfContext2, Context fromToContext2, RLCGeneralData rlcGeneralData)
     { 
        List<Object> generalItems = new ArrayList<Object>();
        
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        // create return Name
        StringItemType returnNameValue = new StringItemType();
        returnNameValue.setContextRef(fromToContext);
        returnNameValue.setValue(rlcGeneralData.getReturnName());
        JAXBElement<StringItemType> returnName = rbiObjectFactory.createReturnName(returnNameValue);
        generalItems.add(returnName);

        // create return code
        StringItemType returnCodeValue = new StringItemType();
        returnCodeValue.setContextRef(fromToContext);
        returnCodeValue.setValue(rlcGeneralData.getReturnCode());
        JAXBElement<StringItemType> returnCode = rbiObjectFactory.createReturnCode(returnCodeValue);
        generalItems.add(returnCode);

        // create NameOfReportingInstitution
        StringItemType nameOfReportingInstitutionValue = new StringItemType();
        nameOfReportingInstitutionValue.setContextRef(fromToContext);
        nameOfReportingInstitutionValue.setValue(rlcGeneralData.getNameOfReportingInstitution());
        JAXBElement<StringItemType> nameOfReportingInstitution = rbiObjectFactory.createNameOfReportingInstitution(nameOfReportingInstitutionValue);
        generalItems.add(nameOfReportingInstitution);

        // create bankCodeValue
        StringItemType bankCodeValue = new StringItemType();
        bankCodeValue.setContextRef(asOfContext);
        bankCodeValue.setValue(rlcGeneralData.getBankCode());
        JAXBElement<StringItemType> bankCode = rbiObjectFactory.createBankCode(bankCodeValue);
        generalItems.add(bankCode);

        // create Address
        StringItemType addressValue = new StringItemType();
        addressValue.setContextRef(fromToContext);
        addressValue.setValue(rlcGeneralData.getAddress());
        JAXBElement<StringItemType> address = rbiObjectFactory.createAddress(addressValue);
        generalItems.add(address);

        // create ReportForTheYearEnded
        DateItemType reportForTheYearEndedValue = new DateItemType();
        reportForTheYearEndedValue.setContextRef(fromToContext);
        reportForTheYearEndedValue.setValue(toXMLGeo(rlcGeneralData.getEndDate()));
        JAXBElement<DateItemType> reportForTheYearEnd = rbiObjectFactory.createReportForTheYearEnded(reportForTheYearEndedValue);
        generalItems.add(reportForTheYearEnd);

        // create ReportingFrequency
        StringItemType reportingFrequencyValue = new StringItemType();
        reportingFrequencyValue.setContextRef(fromToContext);
        reportingFrequencyValue.setValue(rlcGeneralData.getReportingFrequency());
        JAXBElement<StringItemType> reportingFrequency = rbiObjectFactory.createReportingFrequency(reportingFrequencyValue);
        generalItems.add(reportingFrequency);

        // create ReportStatus
        ReportStatusItemType reportStatusValue = new ReportStatusItemType();
        reportStatusValue.setContextRef(fromToContext);
        reportStatusValue.setValue(rlcGeneralData.getReportStatus());
        JAXBElement<ReportStatusItemType> reportStatus = rbiObjectFactory.createReportStatus(reportStatusValue);
        generalItems.add(reportStatus);

        // create WhetherNilReporting
        BooleanItemType whetherNilReportingValue = new BooleanItemType();
        whetherNilReportingValue.setContextRef(fromToContext);
        whetherNilReportingValue.setValue(Boolean.parseBoolean(rlcGeneralData.getWhetherNilReporting()));
        JAXBElement<BooleanItemType> whetherNilReporting = rbiObjectFactory.createWhetherNilReporting(whetherNilReportingValue);
        generalItems.add(whetherNilReporting);

        // create CategoriesOfBanks
        CategoriesOfBanks categoriesOfBanksValue = new CategoriesOfBanks();
        categoriesOfBanksValue.setContextRef(fromToContext);
        categoriesOfBanksValue.setValue(rlcGeneralData.getCategoriesOfBanks());
        JAXBElement<CategoriesOfBanks> categoriesOfBanks = rbiObjectFactory.createCategoriesOfBanks(categoriesOfBanksValue);
        generalItems.add(categoriesOfBanks);

        // create ReturnVersion
        StringItemType returnVersionValue = new StringItemType();
        returnVersionValue.setContextRef(fromToContext);
        returnVersionValue.setValue(rlcGeneralData.getReturnVersion());
        JAXBElement<StringItemType> returnVersion = rbiObjectFactory.createReturnVersion(returnVersionValue);
        generalItems.add(returnVersion);

        // create GeneralRemarks
        TextBlockItemType generalRemarksValue = new TextBlockItemType();
        generalRemarksValue.setContextRef(fromToContext);
        generalRemarksValue.setValue(rlcGeneralData.getGeneralRemarks());
        JAXBElement<TextBlockItemType> generalRemarks = rbiObjectFactory.createGeneralRemarks(generalRemarksValue);
        generalItems.add(generalRemarks);

        // create ReportingPeriodStartDate
        DateItemType reportingPeriodStartDateValue = new DateItemType();
        reportingPeriodStartDateValue.setContextRef(asOfContext);
        reportingPeriodStartDateValue.setValue(toXMLGeo(rlcGeneralData.getStartDate()));
        JAXBElement<DateItemType> reportingPeriodStartDate = rbiObjectFactory.createReportingPeriodStartDate(reportingPeriodStartDateValue);
        generalItems.add(reportingPeriodStartDate);

        // create RegulatoryCapital
        MonetaryItemType regulatoryCapitalValue = new MonetaryItemType();
        regulatoryCapitalValue.setContextRef(asOfContext);
        regulatoryCapitalValue.setUnitRef(unitINR);
        regulatoryCapitalValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getRegulatoryCapital())));
        regulatoryCapitalValue.setValue(new BigDecimal(rlcGeneralData.getRegulatoryCapital()));
        JAXBElement<MonetaryItemType> regulatoryCapital = rbiObjectFactory.createRegulatoryCapital(regulatoryCapitalValue);
        generalItems.add(regulatoryCapital);

        // create CapitalInfusion
        MonetaryItemType capitalInfusionValue = new MonetaryItemType();
        capitalInfusionValue.setContextRef(fromToContext);
        capitalInfusionValue.setUnitRef(unitINR);
        capitalInfusionValue.setDecimals(String.format("%s", CommonFns.getDecimals(rlcGeneralData.getCapitalInfusion())));
        capitalInfusionValue.setValue(new BigDecimal(rlcGeneralData.getCapitalInfusion()));
        JAXBElement<MonetaryItemType> capitalInfusion = rbiObjectFactory.createCapitalInfusion(capitalInfusionValue);
        generalItems.add(capitalInfusion);

        ////Signatory Details
        // create NameOfSignatory
        StringItemType nameOfSignatoryValue = new StringItemType();
        nameOfSignatoryValue.setContextRef(fromToContext);
        nameOfSignatoryValue.setValue(rlcGeneralData.getNameOfSignatory());
        JAXBElement<StringItemType> nameOfSignatory = rbiObjectFactory.createNameOfSignatory(nameOfSignatoryValue);
        generalItems.add(returnVersion);

        // create DesignationOfSignatory
        StringItemType designationOfSignatoryValue = new StringItemType();
        designationOfSignatoryValue.setContextRef(fromToContext);
        designationOfSignatoryValue.setValue(rlcGeneralData.getDesignationOfSignatory());
        JAXBElement<StringItemType> designationOfSignatory = rbiObjectFactory.createDesignationOfSignatory(designationOfSignatoryValue);
        generalItems.add(designationOfSignatory);

        // create AuthorisedSignatoryMobileNumber
        IntegerItemType authorisedSignatoryMobileNumberValue = new IntegerItemType();
        authorisedSignatoryMobileNumberValue.setContextRef(fromToContext);
        authorisedSignatoryMobileNumberValue.setUnitRef(pureUnit);
        authorisedSignatoryMobileNumberValue.setDecimals("INF");
        authorisedSignatoryMobileNumberValue.setValue(new BigInteger(rlcGeneralData.getAuthorisedSignatoryMobileNumber()));
        JAXBElement<IntegerItemType> authorisedSignatoryMobileNumber = rbiObjectFactory.createAuthorisedSignatoryMobileNumber(authorisedSignatoryMobileNumberValue);
        generalItems.add(authorisedSignatoryMobileNumber);

        // create AuthorisedSignatoryLandlineNumber
        IntegerItemType authorisedSignatoryLandlineNumberValue = new IntegerItemType();
        authorisedSignatoryLandlineNumberValue.setContextRef(fromToContext);
        authorisedSignatoryLandlineNumberValue.setUnitRef(pureUnit);
        authorisedSignatoryLandlineNumberValue.setDecimals("INF");
        authorisedSignatoryLandlineNumberValue.setValue(new BigInteger(rlcGeneralData.getAuthorisedSignatoryLandlineNumber()));
        JAXBElement<IntegerItemType> authorisedSignatoryLandlineNumber = rbiObjectFactory.createAuthorisedSignatoryLandlineNumber(authorisedSignatoryLandlineNumberValue);
        generalItems.add(authorisedSignatoryLandlineNumber);

        // create EMailIDOfAuthorisedReportingOfficial
        StringItemType eMailIDOfAuthorisedReportingOfficialValue = new StringItemType();
        eMailIDOfAuthorisedReportingOfficialValue.setContextRef(fromToContext);
        eMailIDOfAuthorisedReportingOfficialValue.setValue(rlcGeneralData.getEMailIDOfAuthorisedReportingOfficial());
        JAXBElement<StringItemType> eMailIDOfAuthorisedReportingOfficial = rbiObjectFactory.createEMailIDOfAuthorisedReportingOfficial(eMailIDOfAuthorisedReportingOfficialValue);
        generalItems.add(eMailIDOfAuthorisedReportingOfficial);
        
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
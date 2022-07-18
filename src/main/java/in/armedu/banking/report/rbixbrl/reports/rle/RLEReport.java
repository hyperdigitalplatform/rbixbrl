package in.armedu.banking.report.rbixbrl.reports.rle;



import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ContextEntityType;
import org.xbrl._2003.instance.ContextEntityType.Identifier;
import org.xbrl._2006.xbrldi.ExplicitMember;
import org.xbrl._2006.xbrldi.TypedMember;
import org.xbrl._2003.instance.ContextPeriodType;
import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.Xbrl;
import org.xbrl._2003.xlink.SimpleType;
// generic import classes
import java.io.StringWriter;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import in.armedu.banking.report.rbixbrl.util.DefaultNamespacePrefixMapper;
import lombok.Setter;

// import model class
import in.armedu.banking.report.rbixbrl.model.rle.*;

// add xbrl data type and inerface
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;
import in.armedu.banking.report.rbixbrl.util.CommonFns;
import in.armedu.banking.report.rbixbrl.model.ReportData;

// add data type 

import org.xbrl._2003.instance.StringItemType;

import org.xbrl._2003.instance.DateTimeItemType;

import org.xbrl._2003.instance.DateItemType;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ReportStatusItemType;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ValidationStatusItemType;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.CategoryStatusItemType;

import org.xbrl._2003.instance.MonetaryItemType;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.AssetsClassificationItemType;


@Setter
public class RLEReport implements XBRLReportIntf {
    private org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory instancObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
    
    
    @Override
    public StringWriter generateReport(ReportData reportData){
        JAXBContext jc;
        Marshaller m;
        // TODO should be generated dynamically
        RLEReportData mainReportData = (RLEReportData) reportData;

        try {
            jc = JAXBContext.newInstance(ObjectFactory.class,
            org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ObjectFactory.class,
            org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory.class,
            org.rbi.in_rbi_rep_par.ObjectFactory.class,
            org.xbrl._2003.xlink.ObjectFactory.class,
            org.xbrl._2003.instance.ObjectFactory.class,
            org.xbrl._2006.xbrldi.ObjectFactory.class,
            org.xbrl._2003.linkbase.ObjectFactory.class,
            org.xbrl._2005.xbrldt.ObjectFactory.class,
            org.xbrl.dtr.type.non_numeric.ObjectFactory.class,
            org.xbrl.dtr.type.numeric.ObjectFactory.class);

            m = jc.createMarshaller();
            StringWriter writer = new StringWriter();
            Xbrl xbrl = new org.xbrl._2003.instance.ObjectFactory().createXbrl();
            
            m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DefaultNamespacePrefixMapper());
            org.xbrl._2003.xlink.ObjectFactory xlinkObjectFactory = new org.xbrl._2003.xlink.ObjectFactory();
            SimpleType simpleType = xlinkObjectFactory.createSimpleType();
            simpleType.setType("simple");
            // TODO should be changed to specific xsd related to report rle
            simpleType.setHref("../schemas/alo/in-rbi-rle.xsd");
            xbrl.getSchemaRef().add(simpleType);
            xbrl.getOtherAttributes().put(new QName("xml:lang"), "en");
           
            
            // context identifiers and body elements
            List<String> contextIdentifiers = new ArrayList<String>();
            List<Context> contextElements = new ArrayList<Context>();
            List<Object> bodyElements = new ArrayList<Object>();
            List<String> unitIdentifiers = new ArrayList<String>();
            List<Unit> unitElements = new ArrayList<Unit>();
           
            //Unit unitObj = null;
            //RLEReportData rLEReportData = new RLEReportData();
            // print values           
    

            // TODO : create proper context with loop and element
            // initiatilize data class and allow to be set 
            //private RLEReportData rLEReportData = new RLEReportData();
            // retrieve bankcode, startdate, enddate and perioddate
            String bankCode = mainReportData.getBankCode();
            String startDate = mainReportData.getStartDate();
            String endDate = mainReportData.getEndDate();
            String periodDate = mainReportData.getPeriodDate();

             
            
            // create variable for subclass GeneralInformation_Lyt_Page1 if any typeMembers then List or Single
            GeneralInformation_Lyt_Page1 generalInformation_Lyt_Page1 = mainReportData.getGeneralInformation_Lyt_Page1();
            
            
            {
            // create xbrl report element
            GeneralInformation_Lyt_Page1 field = generalInformation_Lyt_Page1;
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - ReturnName
            
            
                Context generalInformation_Lyt_Page1ReturnNameContext1 = RLEReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1ReturnNameContext1.getId())) {
                contextElements.add(generalInformation_Lyt_Page1ReturnNameContext1);
                contextIdentifiers.add(generalInformation_Lyt_Page1ReturnNameContext1.getId());
            }
            
            
            // create element JAXB Element

            StringItemType returnNameValue = new StringItemType();
            returnNameValue.setContextRef(generalInformation_Lyt_Page1ReturnNameContext1);
            
                    returnNameValue.setValue(field.getReturnName());        
                    
            
            
            JAXBElement<StringItemType> returnNameElement = instancObjectFactory.createReturnName(returnNameValue);
            bodyElements.add(returnNameElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - ReturnCode
            
            
                Context generalInformation_Lyt_Page1ReturnCodeContext2 = RLEReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1ReturnCodeContext2.getId())) {
                contextElements.add(generalInformation_Lyt_Page1ReturnCodeContext2);
                contextIdentifiers.add(generalInformation_Lyt_Page1ReturnCodeContext2.getId());
            }
            
            
            // create element JAXB Element

            StringItemType returnCodeValue = new StringItemType();
            returnCodeValue.setContextRef(generalInformation_Lyt_Page1ReturnCodeContext2);
            
                    returnCodeValue.setValue(field.getReturnCode());        
                    
            
            
            JAXBElement<StringItemType> returnCodeElement = instancObjectFactory.createReturnCode(returnCodeValue);
            bodyElements.add(returnCodeElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - NameOfReportingInstitution
            
            
                Context generalInformation_Lyt_Page1NameOfReportingInstitutionContext3 = RLEReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1NameOfReportingInstitutionContext3.getId())) {
                contextElements.add(generalInformation_Lyt_Page1NameOfReportingInstitutionContext3);
                contextIdentifiers.add(generalInformation_Lyt_Page1NameOfReportingInstitutionContext3.getId());
            }
            
            
            // create element JAXB Element

            StringItemType nameOfReportingInstitutionValue = new StringItemType();
            nameOfReportingInstitutionValue.setContextRef(generalInformation_Lyt_Page1NameOfReportingInstitutionContext3);
            
                    nameOfReportingInstitutionValue.setValue(field.getNameOfReportingInstitution());        
                    
            
            
            JAXBElement<StringItemType> nameOfReportingInstitutionElement = instancObjectFactory.createNameOfReportingInstitution(nameOfReportingInstitutionValue);
            bodyElements.add(nameOfReportingInstitutionElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - BankCode
            
            
            Context generalInformation_Lyt_Page1BankCodeContext4 = RLEReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1BankCodeContext4.getId())) {
                contextElements.add(generalInformation_Lyt_Page1BankCodeContext4);
                contextIdentifiers.add(generalInformation_Lyt_Page1BankCodeContext4.getId());
            }
            
            
            // create element JAXB Element

            StringItemType bankCodeValue = new StringItemType();
            bankCodeValue.setContextRef(generalInformation_Lyt_Page1BankCodeContext4);
            
                    bankCodeValue.setValue(field.getBankCode());        
                    
            
            
            JAXBElement<StringItemType> bankCodeElement = instancObjectFactory.createBankCode(bankCodeValue);
            bodyElements.add(bankCodeElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - DateOfQuarterEnded
            
            
            Context generalInformation_Lyt_Page1DateOfQuarterEndedContext5 = RLEReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1DateOfQuarterEndedContext5.getId())) {
                contextElements.add(generalInformation_Lyt_Page1DateOfQuarterEndedContext5);
                contextIdentifiers.add(generalInformation_Lyt_Page1DateOfQuarterEndedContext5.getId());
            }
            
            
            // create element JAXB Element

            DateTimeItemType dateOfQuarterEndedValue = new DateTimeItemType();
            dateOfQuarterEndedValue.setContextRef(generalInformation_Lyt_Page1DateOfQuarterEndedContext5);
            
                    dateOfQuarterEndedValue.setValue(field.getDateOfQuarterEnded());        
                    
            
            
            JAXBElement<DateTimeItemType> dateOfQuarterEndedElement = instancObjectFactory.createDateOfQuarterEnded(dateOfQuarterEndedValue);
            bodyElements.add(dateOfQuarterEndedElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - ReportingFrequency
            
            
                Context generalInformation_Lyt_Page1ReportingFrequencyContext6 = RLEReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1ReportingFrequencyContext6.getId())) {
                contextElements.add(generalInformation_Lyt_Page1ReportingFrequencyContext6);
                contextIdentifiers.add(generalInformation_Lyt_Page1ReportingFrequencyContext6.getId());
            }
            
            
            // create element JAXB Element

            StringItemType reportingFrequencyValue = new StringItemType();
            reportingFrequencyValue.setContextRef(generalInformation_Lyt_Page1ReportingFrequencyContext6);
            
                    reportingFrequencyValue.setValue(field.getReportingFrequency());        
                    
            
            
            JAXBElement<StringItemType> reportingFrequencyElement = instancObjectFactory.createReportingFrequency(reportingFrequencyValue);
            bodyElements.add(reportingFrequencyElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - DateOfReport
            
            
            Context generalInformation_Lyt_Page1DateOfReportContext7 = RLEReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1DateOfReportContext7.getId())) {
                contextElements.add(generalInformation_Lyt_Page1DateOfReportContext7);
                contextIdentifiers.add(generalInformation_Lyt_Page1DateOfReportContext7.getId());
            }
            
            
            // create element JAXB Element

            DateItemType dateOfReportValue = new DateItemType();
            dateOfReportValue.setContextRef(generalInformation_Lyt_Page1DateOfReportContext7);
            
            dateOfReportValue.setValue(RLEReportContextUtil.toXMLGeo(field.getDateOfReport()));
            
            
            
            JAXBElement<DateItemType> dateOfReportElement = instancObjectFactory.createDateOfReport(dateOfReportValue);
            bodyElements.add(dateOfReportElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - ReportStatus
            
            
                Context generalInformation_Lyt_Page1ReportStatusContext8 = RLEReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1ReportStatusContext8.getId())) {
                contextElements.add(generalInformation_Lyt_Page1ReportStatusContext8);
                contextIdentifiers.add(generalInformation_Lyt_Page1ReportStatusContext8.getId());
            }
            
            
            // create element JAXB Element

            ReportStatusItemType reportStatusValue = new ReportStatusItemType();
            reportStatusValue.setContextRef(generalInformation_Lyt_Page1ReportStatusContext8);
            
                    reportStatusValue.setValue(field.getReportStatus());        
                    
            
            
            JAXBElement<ReportStatusItemType> reportStatusElement = instancObjectFactory.createReportStatus(reportStatusValue);
            bodyElements.add(reportStatusElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - DateOfAudit
            
            
            Context generalInformation_Lyt_Page1DateOfAuditContext9 = RLEReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1DateOfAuditContext9.getId())) {
                contextElements.add(generalInformation_Lyt_Page1DateOfAuditContext9);
                contextIdentifiers.add(generalInformation_Lyt_Page1DateOfAuditContext9.getId());
            }
            
            
            // create element JAXB Element

            DateItemType dateOfAuditValue = new DateItemType();
            dateOfAuditValue.setContextRef(generalInformation_Lyt_Page1DateOfAuditContext9);
            
            dateOfAuditValue.setValue(RLEReportContextUtil.toXMLGeo(field.getDateOfAudit()));
            
            
            
            JAXBElement<DateItemType> dateOfAuditElement = instancObjectFactory.createDateOfAudit(dateOfAuditValue);
            bodyElements.add(dateOfAuditElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - ValidationStatus
            
            
                Context generalInformation_Lyt_Page1ValidationStatusContext10 = RLEReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1ValidationStatusContext10.getId())) {
                contextElements.add(generalInformation_Lyt_Page1ValidationStatusContext10);
                contextIdentifiers.add(generalInformation_Lyt_Page1ValidationStatusContext10.getId());
            }
            
            
            // create element JAXB Element

            ValidationStatusItemType validationStatusValue = new ValidationStatusItemType();
            validationStatusValue.setContextRef(generalInformation_Lyt_Page1ValidationStatusContext10);
            
                    validationStatusValue.setValue(field.getValidationStatus());        
                    
            
            
            JAXBElement<ValidationStatusItemType> validationStatusElement = instancObjectFactory.createValidationStatus(validationStatusValue);
            bodyElements.add(validationStatusElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - ReturnVersion
            
            
                Context generalInformation_Lyt_Page1ReturnVersionContext11 = RLEReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1ReturnVersionContext11.getId())) {
                contextElements.add(generalInformation_Lyt_Page1ReturnVersionContext11);
                contextIdentifiers.add(generalInformation_Lyt_Page1ReturnVersionContext11.getId());
            }
            
            
            // create element JAXB Element

            StringItemType returnVersionValue = new StringItemType();
            returnVersionValue.setContextRef(generalInformation_Lyt_Page1ReturnVersionContext11);
            
                    returnVersionValue.setValue(field.getReturnVersion());        
                    
            
            
            JAXBElement<StringItemType> returnVersionElement = instancObjectFactory.createReturnVersion(returnVersionValue);
            bodyElements.add(returnVersionElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - ReportingPeriodStartDate
            
            
            Context generalInformation_Lyt_Page1ReportingPeriodStartDateContext12 = RLEReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1ReportingPeriodStartDateContext12.getId())) {
                contextElements.add(generalInformation_Lyt_Page1ReportingPeriodStartDateContext12);
                contextIdentifiers.add(generalInformation_Lyt_Page1ReportingPeriodStartDateContext12.getId());
            }
            
            
            // create element JAXB Element

            DateItemType reportingPeriodStartDateValue = new DateItemType();
            reportingPeriodStartDateValue.setContextRef(generalInformation_Lyt_Page1ReportingPeriodStartDateContext12);
            
            reportingPeriodStartDateValue.setValue(RLEReportContextUtil.toXMLGeo(field.getReportingPeriodStartDate()));
            
            
            
            JAXBElement<DateItemType> reportingPeriodStartDateElement = instancObjectFactory.createReportingPeriodStartDate(reportingPeriodStartDateValue);
            bodyElements.add(reportingPeriodStartDateElement);

            
            
            




            
            
            
            // end xbrl report element   


        }

            
            


            // with typemembers which requires multiple type member record
            

            
            // create variable for subclass SectionI_lyt_1_Section1 if any typeMembers then List or Single
            List<SectionI_lyt_1_Section1> sectionI_lyt_1_Section1 = mainReportData.getSectionI_lyt_1_Section1();
            
            


            // with typemembers which requires multiple type member record
            
            sectionI_lyt_1_Section1.forEach((field)->{
            // crate variable loop  for type member
            
                // crate variable for type member CountryCode
                String countryCode = field.getCountryCode();
            
                // crate variable for type member BranchCode
                String branchCode = field.getBranchCode();
            
                // crate variable for type member NameOfBorrower
                String nameOfBorrower = field.getNameOfBorrower();
            
            // end create variable loop for type member

            // create xbrl report element
            
            // start create element for report of SectionI_lyt_1_Section1
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - BorrowerGroupName
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue15 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getBorrowerGroupName(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisMap14 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisMap14.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                        Context explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisContext13 = RLEReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisMap14 );
                        
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisContext13.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisContext13);
                        contextIdentifiers.add(explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisContext13.getId());
                    }
                    
                    // create element JAXB Element

                    StringItemType explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType17 = new StringItemType();
                    explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType17.setContextRef(explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisContext13);
                    
                    explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType17.setValue(explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue15);
                    
                    
                    JAXBElement<StringItemType> explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement16 = instancObjectFactory.createBorrowerGroupName(explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType17);
                    bodyElements.add(explictMember1SectionI_lyt_1_Section1BorrowerGroupNameTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement16);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionI_lyt_1_Section1
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - RegistrationNumber
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue20 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getRegistrationNumber(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisMap19 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisMap19.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                        Context explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisContext18 = RLEReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisMap19 );
                        
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisContext18.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisContext18);
                        contextIdentifiers.add(explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisContext18.getId());
                    }
                    
                    // create element JAXB Element

                    StringItemType explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType22 = new StringItemType();
                    explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType22.setContextRef(explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisContext18);
                    
                    explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType22.setValue(explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue20);
                    
                    
                    JAXBElement<StringItemType> explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement21 = instancObjectFactory.createRegistrationNumber(explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType22);
                    bodyElements.add(explictMember1SectionI_lyt_1_Section1RegistrationNumberTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement21);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionI_lyt_1_Section1
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - CategoryOfBorrower
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue25 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getCategoryOfBorrower(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisMap24 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisMap24.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                        Context explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisContext23 = RLEReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisMap24 );
                        
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisContext23.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisContext23);
                        contextIdentifiers.add(explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisContext23.getId());
                    }
                    
                    // create element JAXB Element

                    CategoryStatusItemType explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType27 = new CategoryStatusItemType();
                    explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType27.setContextRef(explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisContext23);
                    
                    explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType27.setValue(explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue25);
                    
                    
                    JAXBElement<CategoryStatusItemType> explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement26 = instancObjectFactory.createCategoryOfBorrower(explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType27);
                    bodyElements.add(explictMember1SectionI_lyt_1_Section1CategoryOfBorrowerTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement26);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionI_lyt_1_Section1
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - SovereignCharacter
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue30 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getSovereignCharacter(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisMap29 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisMap29.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                        Context explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisContext28 = RLEReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisMap29 );
                        
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisContext28.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisContext28);
                        contextIdentifiers.add(explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisContext28.getId());
                    }
                    
                    // create element JAXB Element

                    StringItemType explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType32 = new StringItemType();
                    explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType32.setContextRef(explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisContext28);
                    
                    explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType32.setValue(explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue30);
                    
                    
                    JAXBElement<StringItemType> explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement31 = instancObjectFactory.createSovereignCharacter(explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType32);
                    bodyElements.add(explictMember1SectionI_lyt_1_Section1SovereignCharacterTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement31);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionI_lyt_1_Section1
            // create unit if not empty
            
                
                Unit USD33 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD33 == null){
                    USD33 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD33.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD33.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD33);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AggregateAmountOfLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue36 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAggregateAmountOfLimitsSanctioned(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisMap35 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisMap35.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                    Context explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext34 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisMap35 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext34.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext34);
                        contextIdentifiers.add(explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext34.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType38 = new MonetaryItemType();
                    explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType38.setContextRef(explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext34);
                    
                    explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType38.setUnitRef(USD33);
                    explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType38.setDecimals(CommonFns.getDecimals(explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue36, "1000000"));
                    explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType38.setValue(new BigDecimal(explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue36));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement37 = instancObjectFactory.createAggregateAmountOfLimitsSanctioned(explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType38);
                    bodyElements.add(explictMember1SectionI_lyt_1_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement37);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionI_lyt_1_Section1
            // create unit if not empty
            
                
                Unit USD39 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD39 == null){
                    USD39 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD39.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD39.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD39);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AmountOfFundedLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue42 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAmountOfFundedLimitsSanctioned(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisMap41 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisMap41.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                    Context explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext40 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisMap41 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext40.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext40);
                        contextIdentifiers.add(explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext40.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType44 = new MonetaryItemType();
                    explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType44.setContextRef(explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext40);
                    
                    explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType44.setUnitRef(USD39);
                    explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType44.setDecimals(CommonFns.getDecimals(explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue42, "1000000"));
                    explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType44.setValue(new BigDecimal(explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue42));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement43 = instancObjectFactory.createAmountOfFundedLimitsSanctioned(explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType44);
                    bodyElements.add(explictMember1SectionI_lyt_1_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement43);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionI_lyt_1_Section1
            // create unit if not empty
            
                
                Unit USD45 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD45 == null){
                    USD45 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD45.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD45.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD45);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AmountOfNonFundedLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue48 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAmountOfNonFundedLimitsSanctioned(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisMap47 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisMap47.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                    Context explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext46 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisMap47 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext46.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext46);
                        contextIdentifiers.add(explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext46.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType50 = new MonetaryItemType();
                    explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType50.setContextRef(explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext46);
                    
                    explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType50.setUnitRef(USD45);
                    explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType50.setDecimals(CommonFns.getDecimals(explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue48, "1000000"));
                    explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType50.setValue(new BigDecimal(explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue48));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement49 = instancObjectFactory.createAmountOfNonFundedLimitsSanctioned(explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType50);
                    bodyElements.add(explictMember1SectionI_lyt_1_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement49);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionI_lyt_1_Section1
            // create unit if not empty
            
                
                Unit USD51 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD51 == null){
                    USD51 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD51.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD51.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD51);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AmountOutstanding
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue54 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAmountOutstanding(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisMap53 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisMap53.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                    Context explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisContext52 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisMap53 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisContext52.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisContext52);
                        contextIdentifiers.add(explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisContext52.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType56 = new MonetaryItemType();
                    explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType56.setContextRef(explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisContext52);
                    
                    explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType56.setUnitRef(USD51);
                    explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType56.setDecimals(CommonFns.getDecimals(explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue54, "1000000"));
                    explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType56.setValue(new BigDecimal(explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue54));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement55 = instancObjectFactory.createAmountOutstanding(explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType56);
                    bodyElements.add(explictMember1SectionI_lyt_1_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement55);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionI_lyt_1_Section1
            // create unit if not empty
            
                
                Unit USD57 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD57 == null){
                    USD57 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD57.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD57.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD57);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - SecurityValue
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue60 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getSecurityValue(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisMap59 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisMap59.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                    Context explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisContext58 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisMap59 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisContext58.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisContext58);
                        contextIdentifiers.add(explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisContext58.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType62 = new MonetaryItemType();
                    explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType62.setContextRef(explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisContext58);
                    
                    explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType62.setUnitRef(USD57);
                    explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType62.setDecimals(CommonFns.getDecimals(explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue60, "1000000"));
                    explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType62.setValue(new BigDecimal(explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue60));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement61 = instancObjectFactory.createSecurityValue(explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType62);
                    bodyElements.add(explictMember1SectionI_lyt_1_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement61);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionI_lyt_1_Section1
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AssetsClassification
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue65 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAssetsClassification(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisMap64 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisMap64.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                    Context explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisContext63 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisMap64 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisContext63.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisContext63);
                        contextIdentifiers.add(explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisContext63.getId());
                    }
                    
                    // create element JAXB Element

                    AssetsClassificationItemType explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType67 = new AssetsClassificationItemType();
                    explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType67.setContextRef(explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisContext63);
                    
                    explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType67.setValue(explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue65);
                    
                    
                    JAXBElement<AssetsClassificationItemType> explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement66 = instancObjectFactory.createAssetsClassification(explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType67);
                    bodyElements.add(explictMember1SectionI_lyt_1_Section1AssetsClassificationTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement66);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            
            // end xbrl report element           

            

            });
            

            
            // create variable for subclass SectionI_lyt_2_Section1 if any typeMembers then List or Single
            List<SectionI_lyt_2_Section1> sectionI_lyt_2_Section1 = mainReportData.getSectionI_lyt_2_Section1();
            
            


            // with typemembers which requires multiple type member record
            
            sectionI_lyt_2_Section1.forEach((field)->{
            // crate variable loop  for type member
            
                // crate variable for type member CountryCode
                String countryCode = field.getCountryCode();
            
                // crate variable for type member BranchCode
                String branchCode = field.getBranchCode();
            
            // end create variable loop for type member

            // create xbrl report element
            
            // start create element for report of SectionI_lyt_2_Section1
            // create unit if not empty
            
                
                Unit USD68 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD68 == null){
                    USD68 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD68.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD68.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD68);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AggregateAmountOfLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue71 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAggregateAmountOfLimitsSanctioned(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisMap70 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisMap70.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                    Context explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext69 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisMap70 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext69.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext69);
                        contextIdentifiers.add(explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext69.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType73 = new MonetaryItemType();
                    explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType73.setContextRef(explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext69);
                    
                    explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType73.setUnitRef(USD68);
                    explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType73.setDecimals(CommonFns.getDecimals(explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue71, "1000000"));
                    explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType73.setValue(new BigDecimal(explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue71));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement72 = instancObjectFactory.createAggregateAmountOfLimitsSanctioned(explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType73);
                    bodyElements.add(explictMember1SectionI_lyt_2_Section1AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement72);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionI_lyt_2_Section1
            // create unit if not empty
            
                
                Unit USD74 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD74 == null){
                    USD74 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD74.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD74.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD74);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AmountOfFundedLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue77 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAmountOfFundedLimitsSanctioned(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisMap76 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisMap76.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                    Context explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext75 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisMap76 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext75.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext75);
                        contextIdentifiers.add(explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext75.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType79 = new MonetaryItemType();
                    explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType79.setContextRef(explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext75);
                    
                    explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType79.setUnitRef(USD74);
                    explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType79.setDecimals(CommonFns.getDecimals(explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue77, "1000000"));
                    explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType79.setValue(new BigDecimal(explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue77));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement78 = instancObjectFactory.createAmountOfFundedLimitsSanctioned(explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType79);
                    bodyElements.add(explictMember1SectionI_lyt_2_Section1AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement78);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionI_lyt_2_Section1
            // create unit if not empty
            
                
                Unit USD80 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD80 == null){
                    USD80 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD80.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD80.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD80);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AmountOfNonFundedLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue83 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAmountOfNonFundedLimitsSanctioned(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisMap82 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisMap82.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                    Context explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext81 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisMap82 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext81.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext81);
                        contextIdentifiers.add(explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext81.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType85 = new MonetaryItemType();
                    explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType85.setContextRef(explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext81);
                    
                    explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType85.setUnitRef(USD80);
                    explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType85.setDecimals(CommonFns.getDecimals(explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue83, "1000000"));
                    explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType85.setValue(new BigDecimal(explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue83));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement84 = instancObjectFactory.createAmountOfNonFundedLimitsSanctioned(explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType85);
                    bodyElements.add(explictMember1SectionI_lyt_2_Section1AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement84);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionI_lyt_2_Section1
            // create unit if not empty
            
                
                Unit USD86 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD86 == null){
                    USD86 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD86.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD86.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD86);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AmountOutstanding
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue89 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAmountOutstanding(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisMap88 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisMap88.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                    Context explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisContext87 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisMap88 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisContext87.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisContext87);
                        contextIdentifiers.add(explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisContext87.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType91 = new MonetaryItemType();
                    explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType91.setContextRef(explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisContext87);
                    
                    explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType91.setUnitRef(USD86);
                    explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType91.setDecimals(CommonFns.getDecimals(explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue89, "1000000"));
                    explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType91.setValue(new BigDecimal(explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue89));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement90 = instancObjectFactory.createAmountOutstanding(explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType91);
                    bodyElements.add(explictMember1SectionI_lyt_2_Section1AmountOutstandingTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement90);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionI_lyt_2_Section1
            // create unit if not empty
            
                
                Unit USD92 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD92 == null){
                    USD92 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD92.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD92.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD92);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - SecurityValue
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue95 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getSecurityValue(), "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");
                    
                    

                    Map explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisMap94 = new HashMap<String, String>();
                    explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisMap94.put("TypeOfSectionAxis", "ListOfAccountsOfUSDollarFiveMillionAndAboveMember");                
                    
                    Context explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisContext93 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisMap94 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisContext93.getId())) {
                        contextElements.add(explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisContext93);
                        contextIdentifiers.add(explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisContext93.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType97 = new MonetaryItemType();
                    explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType97.setContextRef(explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisContext93);
                    
                    explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType97.setUnitRef(USD92);
                    explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType97.setDecimals(CommonFns.getDecimals(explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue95, "1000000"));
                    explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType97.setValue(new BigDecimal(explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberValue95));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement96 = instancObjectFactory.createSecurityValue(explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberDataType97);
                    bodyElements.add(explictMember1SectionI_lyt_2_Section1SecurityValueTypeOfSectionAxisListOfAccountsOfUSDollarFiveMillionAndAboveMemberElement96);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            
            // end xbrl report element           

            

            });
            

            
            // create variable for subclass SectionII_lyt_1_Section2 if any typeMembers then List or Single
            List<SectionII_lyt_1_Section2> sectionII_lyt_1_Section2 = mainReportData.getSectionII_lyt_1_Section2();
            
            


            // with typemembers which requires multiple type member record
            
            sectionII_lyt_1_Section2.forEach((field)->{
            // crate variable loop  for type member
            
                // crate variable for type member CountryCode
                String countryCode = field.getCountryCode();
            
                // crate variable for type member BranchCode
                String branchCode = field.getBranchCode();
            
                // crate variable for type member NameOfBorrower
                String nameOfBorrower = field.getNameOfBorrower();
            
            // end create variable loop for type member

            // create xbrl report element
            
            // start create element for report of SectionII_lyt_1_Section2
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - BorrowerGroupName
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue100 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getBorrowerGroupName(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisMap99 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisMap99.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                        Context explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisContext98 = RLEReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisMap99 );
                        
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisContext98.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisContext98);
                        contextIdentifiers.add(explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisContext98.getId());
                    }
                    
                    // create element JAXB Element

                    StringItemType explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType102 = new StringItemType();
                    explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType102.setContextRef(explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisContext98);
                    
                    explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType102.setValue(explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue100);
                    
                    
                    JAXBElement<StringItemType> explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement101 = instancObjectFactory.createBorrowerGroupName(explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType102);
                    bodyElements.add(explictMember1SectionII_lyt_1_Section2BorrowerGroupNameTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement101);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionII_lyt_1_Section2
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - RegistrationNumber
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue105 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getRegistrationNumber(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisMap104 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisMap104.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                        Context explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisContext103 = RLEReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisMap104 );
                        
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisContext103.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisContext103);
                        contextIdentifiers.add(explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisContext103.getId());
                    }
                    
                    // create element JAXB Element

                    StringItemType explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType107 = new StringItemType();
                    explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType107.setContextRef(explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisContext103);
                    
                    explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType107.setValue(explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue105);
                    
                    
                    JAXBElement<StringItemType> explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement106 = instancObjectFactory.createRegistrationNumber(explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType107);
                    bodyElements.add(explictMember1SectionII_lyt_1_Section2RegistrationNumberTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement106);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionII_lyt_1_Section2
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - CategoryOfBorrower
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue110 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getCategoryOfBorrower(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisMap109 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisMap109.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                        Context explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisContext108 = RLEReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisMap109 );
                        
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisContext108.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisContext108);
                        contextIdentifiers.add(explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisContext108.getId());
                    }
                    
                    // create element JAXB Element

                    CategoryStatusItemType explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType112 = new CategoryStatusItemType();
                    explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType112.setContextRef(explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisContext108);
                    
                    explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType112.setValue(explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue110);
                    
                    
                    JAXBElement<CategoryStatusItemType> explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement111 = instancObjectFactory.createCategoryOfBorrower(explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType112);
                    bodyElements.add(explictMember1SectionII_lyt_1_Section2CategoryOfBorrowerTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement111);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionII_lyt_1_Section2
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - SovereignCharacter
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue115 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getSovereignCharacter(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisMap114 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisMap114.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                        Context explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisContext113 = RLEReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisMap114 );
                        
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisContext113.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisContext113);
                        contextIdentifiers.add(explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisContext113.getId());
                    }
                    
                    // create element JAXB Element

                    StringItemType explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType117 = new StringItemType();
                    explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType117.setContextRef(explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisContext113);
                    
                    explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType117.setValue(explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue115);
                    
                    
                    JAXBElement<StringItemType> explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement116 = instancObjectFactory.createSovereignCharacter(explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType117);
                    bodyElements.add(explictMember1SectionII_lyt_1_Section2SovereignCharacterTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement116);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionII_lyt_1_Section2
            // create unit if not empty
            
                
                Unit USD118 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD118 == null){
                    USD118 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD118.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD118.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD118);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AggregateAmountOfLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue121 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAggregateAmountOfLimitsSanctioned(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisMap120 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisMap120.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                    Context explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext119 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisMap120 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext119.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext119);
                        contextIdentifiers.add(explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext119.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType123 = new MonetaryItemType();
                    explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType123.setContextRef(explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext119);
                    
                    explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType123.setUnitRef(USD118);
                    explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType123.setDecimals(CommonFns.getDecimals(explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue121, "1000000"));
                    explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType123.setValue(new BigDecimal(explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue121));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement122 = instancObjectFactory.createAggregateAmountOfLimitsSanctioned(explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType123);
                    bodyElements.add(explictMember1SectionII_lyt_1_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement122);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionII_lyt_1_Section2
            // create unit if not empty
            
                
                Unit USD124 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD124 == null){
                    USD124 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD124.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD124.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD124);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AmountOfFundedLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue127 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAmountOfFundedLimitsSanctioned(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisMap126 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisMap126.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                    Context explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext125 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisMap126 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext125.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext125);
                        contextIdentifiers.add(explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext125.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType129 = new MonetaryItemType();
                    explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType129.setContextRef(explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext125);
                    
                    explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType129.setUnitRef(USD124);
                    explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType129.setDecimals(CommonFns.getDecimals(explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue127, "1000000"));
                    explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType129.setValue(new BigDecimal(explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue127));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement128 = instancObjectFactory.createAmountOfFundedLimitsSanctioned(explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType129);
                    bodyElements.add(explictMember1SectionII_lyt_1_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement128);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionII_lyt_1_Section2
            // create unit if not empty
            
                
                Unit USD130 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD130 == null){
                    USD130 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD130.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD130.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD130);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AmountOfNonFundedLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue133 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAmountOfNonFundedLimitsSanctioned(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisMap132 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisMap132.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                    Context explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext131 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisMap132 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext131.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext131);
                        contextIdentifiers.add(explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext131.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType135 = new MonetaryItemType();
                    explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType135.setContextRef(explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext131);
                    
                    explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType135.setUnitRef(USD130);
                    explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType135.setDecimals(CommonFns.getDecimals(explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue133, "1000000"));
                    explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType135.setValue(new BigDecimal(explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue133));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement134 = instancObjectFactory.createAmountOfNonFundedLimitsSanctioned(explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType135);
                    bodyElements.add(explictMember1SectionII_lyt_1_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement134);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionII_lyt_1_Section2
            // create unit if not empty
            
                
                Unit USD136 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD136 == null){
                    USD136 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD136.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD136.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD136);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AmountOutstanding
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue139 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAmountOutstanding(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisMap138 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisMap138.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                    Context explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisContext137 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisMap138 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisContext137.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisContext137);
                        contextIdentifiers.add(explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisContext137.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType141 = new MonetaryItemType();
                    explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType141.setContextRef(explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisContext137);
                    
                    explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType141.setUnitRef(USD136);
                    explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType141.setDecimals(CommonFns.getDecimals(explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue139, "1000000"));
                    explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType141.setValue(new BigDecimal(explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue139));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement140 = instancObjectFactory.createAmountOutstanding(explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType141);
                    bodyElements.add(explictMember1SectionII_lyt_1_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement140);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionII_lyt_1_Section2
            // create unit if not empty
            
                
                Unit USD142 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD142 == null){
                    USD142 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD142.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD142.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD142);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - SecurityValue
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue145 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getSecurityValue(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisMap144 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisMap144.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                    Context explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisContext143 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisMap144 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisContext143.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisContext143);
                        contextIdentifiers.add(explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisContext143.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType147 = new MonetaryItemType();
                    explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType147.setContextRef(explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisContext143);
                    
                    explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType147.setUnitRef(USD142);
                    explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType147.setDecimals(CommonFns.getDecimals(explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue145, "1000000"));
                    explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType147.setValue(new BigDecimal(explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue145));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement146 = instancObjectFactory.createSecurityValue(explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType147);
                    bodyElements.add(explictMember1SectionII_lyt_1_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement146);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionII_lyt_1_Section2
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AssetsClassification
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue150 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAssetsClassification(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisMap149 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisMap149.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                    Context explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisContext148 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower,  explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisMap149 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisContext148.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisContext148);
                        contextIdentifiers.add(explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisContext148.getId());
                    }
                    
                    // create element JAXB Element

                    AssetsClassificationItemType explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType152 = new AssetsClassificationItemType();
                    explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType152.setContextRef(explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisContext148);
                    
                    explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType152.setValue(explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue150);
                    
                    
                    JAXBElement<AssetsClassificationItemType> explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement151 = instancObjectFactory.createAssetsClassification(explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType152);
                    bodyElements.add(explictMember1SectionII_lyt_1_Section2AssetsClassificationTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement151);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            
            // end xbrl report element           

            

            });
            

            
            // create variable for subclass SectionII_lyt_2_Section2 if any typeMembers then List or Single
            List<SectionII_lyt_2_Section2> sectionII_lyt_2_Section2 = mainReportData.getSectionII_lyt_2_Section2();
            
            


            // with typemembers which requires multiple type member record
            
            sectionII_lyt_2_Section2.forEach((field)->{
            // crate variable loop  for type member
            
                // crate variable for type member CountryCode
                String countryCode = field.getCountryCode();
            
                // crate variable for type member BranchCode
                String branchCode = field.getBranchCode();
            
            // end create variable loop for type member

            // create xbrl report element
            
            // start create element for report of SectionII_lyt_2_Section2
            // create unit if not empty
            
                
                Unit USD153 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD153 == null){
                    USD153 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD153.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD153.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD153);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AggregateAmountOfLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue156 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAggregateAmountOfLimitsSanctioned(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisMap155 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisMap155.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                    Context explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext154 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisMap155 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext154.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext154);
                        contextIdentifiers.add(explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext154.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType158 = new MonetaryItemType();
                    explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType158.setContextRef(explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisContext154);
                    
                    explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType158.setUnitRef(USD153);
                    explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType158.setDecimals(CommonFns.getDecimals(explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue156, "1000000"));
                    explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType158.setValue(new BigDecimal(explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue156));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement157 = instancObjectFactory.createAggregateAmountOfLimitsSanctioned(explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType158);
                    bodyElements.add(explictMember1SectionII_lyt_2_Section2AggregateAmountOfLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement157);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionII_lyt_2_Section2
            // create unit if not empty
            
                
                Unit USD159 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD159 == null){
                    USD159 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD159.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD159.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD159);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AmountOfFundedLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue162 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAmountOfFundedLimitsSanctioned(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisMap161 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisMap161.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                    Context explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext160 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisMap161 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext160.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext160);
                        contextIdentifiers.add(explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext160.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType164 = new MonetaryItemType();
                    explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType164.setContextRef(explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisContext160);
                    
                    explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType164.setUnitRef(USD159);
                    explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType164.setDecimals(CommonFns.getDecimals(explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue162, "1000000"));
                    explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType164.setValue(new BigDecimal(explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue162));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement163 = instancObjectFactory.createAmountOfFundedLimitsSanctioned(explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType164);
                    bodyElements.add(explictMember1SectionII_lyt_2_Section2AmountOfFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement163);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionII_lyt_2_Section2
            // create unit if not empty
            
                
                Unit USD165 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD165 == null){
                    USD165 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD165.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD165.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD165);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AmountOfNonFundedLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue168 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAmountOfNonFundedLimitsSanctioned(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisMap167 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisMap167.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                    Context explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext166 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisMap167 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext166.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext166);
                        contextIdentifiers.add(explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext166.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType170 = new MonetaryItemType();
                    explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType170.setContextRef(explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisContext166);
                    
                    explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType170.setUnitRef(USD165);
                    explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType170.setDecimals(CommonFns.getDecimals(explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue168, "1000000"));
                    explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType170.setValue(new BigDecimal(explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue168));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement169 = instancObjectFactory.createAmountOfNonFundedLimitsSanctioned(explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType170);
                    bodyElements.add(explictMember1SectionII_lyt_2_Section2AmountOfNonFundedLimitsSanctionedTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement169);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionII_lyt_2_Section2
            // create unit if not empty
            
                
                Unit USD171 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD171 == null){
                    USD171 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD171.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD171.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD171);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - AmountOutstanding
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue174 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getAmountOutstanding(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisMap173 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisMap173.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                    Context explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisContext172 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisMap173 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisContext172.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisContext172);
                        contextIdentifiers.add(explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisContext172.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType176 = new MonetaryItemType();
                    explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType176.setContextRef(explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisContext172);
                    
                    explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType176.setUnitRef(USD171);
                    explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType176.setDecimals(CommonFns.getDecimals(explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue174, "1000000"));
                    explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType176.setValue(new BigDecimal(explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue174));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement175 = instancObjectFactory.createAmountOutstanding(explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType176);
                    bodyElements.add(explictMember1SectionII_lyt_2_Section2AmountOutstandingTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement175);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            // start create element for report of SectionII_lyt_2_Section2
            // create unit if not empty
            
                
                Unit USD177 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD177 == null){
                    USD177 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD177.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD177.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD177);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfSectionAxis - SecurityValue
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue180 = RLEReportUtil.retrieveValueForTypeOfSectionAxis(field.getSecurityValue(), "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");
                    
                    

                    Map explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisMap179 = new HashMap<String, String>();
                    explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisMap179.put("TypeOfSectionAxis", "ListOfAccountsBetweenUSDollarOneToFiveMillionMember");                
                    
                    Context explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisContext178 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisMap179 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisContext178.getId())) {
                        contextElements.add(explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisContext178);
                        contextIdentifiers.add(explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisContext178.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType182 = new MonetaryItemType();
                    explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType182.setContextRef(explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisContext178);
                    
                    explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType182.setUnitRef(USD177);
                    explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType182.setDecimals(CommonFns.getDecimals(explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue180, "1000000"));
                    explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType182.setValue(new BigDecimal(explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberValue180));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement181 = instancObjectFactory.createSecurityValue(explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberDataType182);
                    bodyElements.add(explictMember1SectionII_lyt_2_Section2SecurityValueTypeOfSectionAxisListOfAccountsBetweenUSDollarOneToFiveMillionMemberElement181);
                    
                    
            
            
                // crate variable for explicit member TypeOfSectionAxis
                //private List<TypeOfSectionAxis> typeOfSectionAxis = field.getTypeOfSectionAxis();
                

            




            
            
            
            // end xbrl report element           

            

            });
            

            
            // create variable for subclass SectionIII_lyt_1_Section3 if any typeMembers then List or Single
            List<SectionIII_lyt_1_Section3> sectionIII_lyt_1_Section3 = mainReportData.getSectionIII_lyt_1_Section3();
            
            


            // with typemembers which requires multiple type member record
            
            sectionIII_lyt_1_Section3.forEach((field)->{
            // crate variable loop  for type member
            
                // crate variable for type member CountryCode
                String countryCode = field.getCountryCode();
            
                // crate variable for type member BranchCode
                String branchCode = field.getBranchCode();
            
            // end create variable loop for type member

            // create xbrl report element
            
            // start create element for report of SectionIII_lyt_1_Section3
            // create unit if not empty
            
                
                Unit USD183 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD183 == null){
                    USD183 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD183.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD183.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD183);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis - InvestmentsInLocalGovernments
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue186 = RLEReportUtil.retrieveValueForInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis(field.getInvestmentsInLocalGovernments(), "InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMember");
                    
                    

                    Map explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap185 = new HashMap<String, String>();
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap185.put("InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis", "InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMember");                
                    
                    Context explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext184 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap185 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext184.getId())) {
                        contextElements.add(explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext184);
                        contextIdentifiers.add(explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext184.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType188 = new MonetaryItemType();
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType188.setContextRef(explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext184);
                    
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType188.setUnitRef(USD183);
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType188.setDecimals(CommonFns.getDecimals(explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue186, "1000000"));
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType188.setValue(new BigDecimal(explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue186));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberElement187 = instancObjectFactory.createInvestmentsInLocalGovernments(explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType188);
                    bodyElements.add(explictMember1SectionIII_lyt_1_Section3InvestmentsInLocalGovernmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberElement187);
                    
                    
            
            
                // crate variable for explicit member InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis
                //private List<InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis> investmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis = field.getInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis();
                

            




            
            
            // start create element for report of SectionIII_lyt_1_Section3
            // create unit if not empty
            
                
                Unit USD189 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD189 == null){
                    USD189 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD189.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD189.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD189);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis - InvestmentsInIndia
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue192 = RLEReportUtil.retrieveValueForInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis(field.getInvestmentsInIndia(), "InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMember");
                    
                    

                    Map explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap191 = new HashMap<String, String>();
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap191.put("InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis", "InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMember");                
                    
                    Context explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext190 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap191 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext190.getId())) {
                        contextElements.add(explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext190);
                        contextIdentifiers.add(explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext190.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType194 = new MonetaryItemType();
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType194.setContextRef(explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext190);
                    
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType194.setUnitRef(USD189);
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType194.setDecimals(CommonFns.getDecimals(explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue192, "1000000"));
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType194.setValue(new BigDecimal(explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue192));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberElement193 = instancObjectFactory.createInvestmentsInIndia(explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType194);
                    bodyElements.add(explictMember1SectionIII_lyt_1_Section3InvestmentsInIndiaInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberElement193);
                    
                    
            
            
                // crate variable for explicit member InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis
                //private List<InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis> investmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis = field.getInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis();
                

            




            
            
            // start create element for report of SectionIII_lyt_1_Section3
            // create unit if not empty
            
                
                Unit USD195 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD195 == null){
                    USD195 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD195.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD195.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD195);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis - InvestmentsInOECDCountries
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue198 = RLEReportUtil.retrieveValueForInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis(field.getInvestmentsInOECDCountries(), "InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMember");
                    
                    

                    Map explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap197 = new HashMap<String, String>();
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap197.put("InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis", "InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMember");                
                    
                    Context explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext196 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap197 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext196.getId())) {
                        contextElements.add(explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext196);
                        contextIdentifiers.add(explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext196.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType200 = new MonetaryItemType();
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType200.setContextRef(explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext196);
                    
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType200.setUnitRef(USD195);
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType200.setDecimals(CommonFns.getDecimals(explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue198, "1000000"));
                    explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType200.setValue(new BigDecimal(explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue198));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberElement199 = instancObjectFactory.createInvestmentsInOECDCountries(explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType200);
                    bodyElements.add(explictMember1SectionIII_lyt_1_Section3InvestmentsInOECDCountriesInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberElement199);
                    
                    
            
            
                // crate variable for explicit member InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis
                //private List<InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis> investmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis = field.getInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis();
                

            




            
            
            // start create element for report of SectionIII_lyt_1_Section3
            // create unit if not empty
            
                
                Unit USD201 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD201 == null){
                    USD201 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD201.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD201.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD201);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis - OtherInvestments
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue204 = RLEReportUtil.retrieveValueForInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis(field.getOtherInvestments(), "InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMember");
                    
                    

                    Map explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap203 = new HashMap<String, String>();
                    explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap203.put("InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis", "InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMember");                
                    
                    Context explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext202 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap203 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext202.getId())) {
                        contextElements.add(explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext202);
                        contextIdentifiers.add(explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext202.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType206 = new MonetaryItemType();
                    explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType206.setContextRef(explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext202);
                    
                    explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType206.setUnitRef(USD201);
                    explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType206.setDecimals(CommonFns.getDecimals(explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue204, "1000000"));
                    explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType206.setValue(new BigDecimal(explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue204));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberElement205 = instancObjectFactory.createOtherInvestments(explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType206);
                    bodyElements.add(explictMember1SectionIII_lyt_1_Section3OtherInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberElement205);
                    
                    
            
            
                // crate variable for explicit member InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis
                //private List<InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis> investmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis = field.getInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis();
                

            




            
            
            // start create element for report of SectionIII_lyt_1_Section3
            // create unit if not empty
            
                
                Unit USD207 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD207 == null){
                    USD207 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD207.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD207.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD207);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis - AggregateOfCategoriesOfInvestments
            
            
            
            
                    // create value for element
                    
                        String explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue210 = RLEReportUtil.retrieveValueForInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis(field.getAggregateOfCategoriesOfInvestments(), "InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMember");
                    
                    

                    Map explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap209 = new HashMap<String, String>();
                    explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap209.put("InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis", "InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMember");                
                    
                    Context explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext208 = RLEReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisMap209 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext208.getId())) {
                        contextElements.add(explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext208);
                        contextIdentifiers.add(explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext208.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType212 = new MonetaryItemType();
                    explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType212.setContextRef(explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisContext208);
                    
                    explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType212.setUnitRef(USD207);
                    explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType212.setDecimals(CommonFns.getDecimals(explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue210, "1000000"));
                    explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType212.setValue(new BigDecimal(explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberValue210));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberElement211 = instancObjectFactory.createAggregateOfCategoriesOfInvestments(explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberDataType212);
                    bodyElements.add(explictMember1SectionIII_lyt_1_Section3AggregateOfCategoriesOfInvestmentsInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxisInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionMemberElement211);
                    
                    
            
            
                // crate variable for explicit member InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis
                //private List<InvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis> investmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis = field.getInvestmentsDuringTheQuarterMoreThanUSDollarOneMillionAxis();
                

            




            
            
            
            // end xbrl report element           

            

            });
            

            
            // end contexts loop
            // add contexts to xbrl
            contextElements.forEach(ce->{
                xbrl.getItemOrTupleOrContext().add(ce);
            });
            unitElements.forEach(u->{
                xbrl.getItemOrTupleOrContext().add(u);
            });
            
            bodyElements.forEach(be->{
                xbrl.getItemOrTupleOrContext().add(be);
            });
            m.marshal(xbrl, writer);
            System.out.println("");
            System.out.println(writer.toString());
            System.out.println("");
            return writer;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}


package in.armedu.banking.report.rbixbrl.reports.pci;



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
import in.armedu.banking.report.rbixbrl.model.pci.*;

// add xbrl data type and inerface
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;
import in.armedu.banking.report.rbixbrl.util.CommonFns;
import in.armedu.banking.report.rbixbrl.model.ReportData;

// add data type 

import org.xbrl._2003.instance.StringItemType;

import org.xbrl._2003.instance.DateItemType;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ReportStatusItemType;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ValidationStatusItemType;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.CategoryStatusItemType;

import org.xbrl._2003.instance.MonetaryItemType;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.AssetsClassificationItemType;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.AssetsClassificationHostCountryItemType;

import org.xbrl._2003.instance.IntegerItemType;


@Setter
public class PCIReport implements XBRLReportIntf {
    private org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory instancObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
    
    
    @Override
    public StringWriter generateReport(ReportData reportData){
        JAXBContext jc;
        Marshaller m;
        // TODO should be generated dynamically
        PCIReportData mainReportData = (PCIReportData) reportData;

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
            // TODO should be changed to specific xsd related to report pci
            simpleType.setHref("../schemas/alo/in-rbi-pci.xsd");
            xbrl.getSchemaRef().add(simpleType);
            xbrl.getOtherAttributes().put(new QName("xml:lang"), "en");
           
            
            // context identifiers and body elements
            List<String> contextIdentifiers = new ArrayList<String>();
            List<Context> contextElements = new ArrayList<Context>();
            List<Object> bodyElements = new ArrayList<Object>();
            List<String> unitIdentifiers = new ArrayList<String>();
            List<Unit> unitElements = new ArrayList<Unit>();
           
            //Unit unitObj = null;
            //PCIReportData pCIReportData = new PCIReportData();
            // print values           
    

            // TODO : create proper context with loop and element
            // initiatilize data class and allow to be set 
            //private PCIReportData pCIReportData = new PCIReportData();
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
            
            
                Context generalInformation_Lyt_Page1ReturnNameContext1 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
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
            
            
                Context generalInformation_Lyt_Page1ReturnCodeContext2 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
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
            
            
                Context generalInformation_Lyt_Page1NameOfReportingInstitutionContext3 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
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
            
            
            Context generalInformation_Lyt_Page1BankCodeContext4 = PCIReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
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
            // - ReportForTheYearEnded
            
            
                Context generalInformation_Lyt_Page1ReportForTheYearEndedContext5 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1ReportForTheYearEndedContext5.getId())) {
                contextElements.add(generalInformation_Lyt_Page1ReportForTheYearEndedContext5);
                contextIdentifiers.add(generalInformation_Lyt_Page1ReportForTheYearEndedContext5.getId());
            }
            
            
            // create element JAXB Element

            DateItemType reportForTheYearEndedValue = new DateItemType();
            reportForTheYearEndedValue.setContextRef(generalInformation_Lyt_Page1ReportForTheYearEndedContext5);
            
            reportForTheYearEndedValue.setValue(PCIReportContextUtil.toXMLGeo(field.getReportForTheYearEnded()));
            
            
            
            JAXBElement<DateItemType> reportForTheYearEndedElement = instancObjectFactory.createReportForTheYearEnded(reportForTheYearEndedValue);
            bodyElements.add(reportForTheYearEndedElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - ReportingFrequency
            
            
                Context generalInformation_Lyt_Page1ReportingFrequencyContext6 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
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
            
            
            Context generalInformation_Lyt_Page1DateOfReportContext7 = PCIReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1DateOfReportContext7.getId())) {
                contextElements.add(generalInformation_Lyt_Page1DateOfReportContext7);
                contextIdentifiers.add(generalInformation_Lyt_Page1DateOfReportContext7.getId());
            }
            
            
            // create element JAXB Element

            DateItemType dateOfReportValue = new DateItemType();
            dateOfReportValue.setContextRef(generalInformation_Lyt_Page1DateOfReportContext7);
            
            dateOfReportValue.setValue(PCIReportContextUtil.toXMLGeo(field.getDateOfReport()));
            
            
            
            JAXBElement<DateItemType> dateOfReportElement = instancObjectFactory.createDateOfReport(dateOfReportValue);
            bodyElements.add(dateOfReportElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - ReportStatus
            
            
                Context generalInformation_Lyt_Page1ReportStatusContext8 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
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
            
            
            Context generalInformation_Lyt_Page1DateOfAuditContext9 = PCIReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1DateOfAuditContext9.getId())) {
                contextElements.add(generalInformation_Lyt_Page1DateOfAuditContext9);
                contextIdentifiers.add(generalInformation_Lyt_Page1DateOfAuditContext9.getId());
            }
            
            
            // create element JAXB Element

            DateItemType dateOfAuditValue = new DateItemType();
            dateOfAuditValue.setContextRef(generalInformation_Lyt_Page1DateOfAuditContext9);
            
            dateOfAuditValue.setValue(PCIReportContextUtil.toXMLGeo(field.getDateOfAudit()));
            
            
            
            JAXBElement<DateItemType> dateOfAuditElement = instancObjectFactory.createDateOfAudit(dateOfAuditValue);
            bodyElements.add(dateOfAuditElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - ValidationStatus
            
            
                Context generalInformation_Lyt_Page1ValidationStatusContext10 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
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
            // - ToolName
            
            
                Context generalInformation_Lyt_Page1ToolNameContext11 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1ToolNameContext11.getId())) {
                contextElements.add(generalInformation_Lyt_Page1ToolNameContext11);
                contextIdentifiers.add(generalInformation_Lyt_Page1ToolNameContext11.getId());
            }
            
            
            // create element JAXB Element

            StringItemType toolNameValue = new StringItemType();
            toolNameValue.setContextRef(generalInformation_Lyt_Page1ToolNameContext11);
            
                    toolNameValue.setValue(field.getToolName());        
                    
            
            
            JAXBElement<StringItemType> toolNameElement = instancObjectFactory.createToolName(toolNameValue);
            bodyElements.add(toolNameElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - ReturnVersion
            
            
                Context generalInformation_Lyt_Page1ReturnVersionContext12 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1ReturnVersionContext12.getId())) {
                contextElements.add(generalInformation_Lyt_Page1ReturnVersionContext12);
                contextIdentifiers.add(generalInformation_Lyt_Page1ReturnVersionContext12.getId());
            }
            
            
            // create element JAXB Element

            StringItemType returnVersionValue = new StringItemType();
            returnVersionValue.setContextRef(generalInformation_Lyt_Page1ReturnVersionContext12);
            
                    returnVersionValue.setValue(field.getReturnVersion());        
                    
            
            
            JAXBElement<StringItemType> returnVersionElement = instancObjectFactory.createReturnVersion(returnVersionValue);
            bodyElements.add(returnVersionElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_Lyt_Page1
            // create context for none explict member
            // TODO: remove once done
            // - ReportingPeriodStartDate
            
            
            Context generalInformation_Lyt_Page1ReportingPeriodStartDateContext13 = PCIReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(generalInformation_Lyt_Page1ReportingPeriodStartDateContext13.getId())) {
                contextElements.add(generalInformation_Lyt_Page1ReportingPeriodStartDateContext13);
                contextIdentifiers.add(generalInformation_Lyt_Page1ReportingPeriodStartDateContext13.getId());
            }
            
            
            // create element JAXB Element

            DateItemType reportingPeriodStartDateValue = new DateItemType();
            reportingPeriodStartDateValue.setContextRef(generalInformation_Lyt_Page1ReportingPeriodStartDateContext13);
            
            reportingPeriodStartDateValue.setValue(PCIReportContextUtil.toXMLGeo(field.getReportingPeriodStartDate()));
            
            
            
            JAXBElement<DateItemType> reportingPeriodStartDateElement = instancObjectFactory.createReportingPeriodStartDate(reportingPeriodStartDateValue);
            bodyElements.add(reportingPeriodStartDateElement);

            
            
            




            
            
            
            // end xbrl report element   


        }

            
            


            // with typemembers which requires multiple type member record
            

            
            // create variable for subclass PARTA_lyt_PartA if any typeMembers then List or Single
            List<PARTA_lyt_PartA> pARTA_lyt_PartA = mainReportData.getPARTA_lyt_PartA();
            
            


            // with typemembers which requires multiple type member record
            
            pARTA_lyt_PartA.forEach((field)->{
            // crate variable loop  for type member
            
                // crate variable for type member CountryCode
                String countryCode = field.getCountryCode();
            
                // crate variable for type member BranchCode
                String branchCode = field.getBranchCode();
            
                // crate variable for type member NameOfBorrower
                String nameOfBorrower = field.getNameOfBorrower();
            
                // crate variable for type member BorrowerGroupName
                String borrowerGroupName = field.getBorrowerGroupName();
            
                // crate variable for type member IndustryCode
                String industryCode = field.getIndustryCode();
            
            // end create variable loop for type member

            // create xbrl report element
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - SoverignCharacter
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberValue16 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getSoverignCharacter(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberValue16 != null && !"".equals(explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberValue16)) {
                    

                Map explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberMap15 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberMap15.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberMap15.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                        Context explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberContext14 = PCIReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberMap15 );
                        
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberContext14.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberContext14);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberContext14.getId());
                }

                        // create element JAXB Element

                        StringItemType explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberDataType18 = new StringItemType();
                        explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberDataType18.setContextRef(explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberContext14);
                        
                        explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberDataType18.setValue(explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberValue16);
                        
                        JAXBElement<StringItemType> explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberElement17 = instancObjectFactory.createSoverignCharacter(explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberDataType18);
                        bodyElements.add(explictMember2PARTA_lyt_PartASoverignCharacterMoreThanUSD2MillionMemberProblemCreditMemberElement17);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - CategoryOfBorrower
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberValue21 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getCategoryOfBorrower(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberValue21 != null && !"".equals(explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberValue21)) {
                    

                Map explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberMap20 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberMap20.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberMap20.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                        Context explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberContext19 = PCIReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberMap20 );
                        
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberContext19.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberContext19);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberContext19.getId());
                }

                        // create element JAXB Element

                        CategoryStatusItemType explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberDataType23 = new CategoryStatusItemType();
                        explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberDataType23.setContextRef(explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberContext19);
                        
                        explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberDataType23.setValue(explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberValue21);
                        
                        JAXBElement<CategoryStatusItemType> explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberElement22 = instancObjectFactory.createCategoryOfBorrower(explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberDataType23);
                        bodyElements.add(explictMember2PARTA_lyt_PartACategoryOfBorrowerMoreThanUSD2MillionMemberProblemCreditMemberElement22);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
                
                Unit USD24 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD24 == null){
                    USD24 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD24.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD24.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD24);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AggregateAmountOfLimitsSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue27 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAggregateAmountOfLimitsSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue27 != null && !"".equals(explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue27)) {
                    

                Map explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap26 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap26.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap26.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext25 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap26 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext25.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext25);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext25.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType29 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType29.setContextRef(explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext25);
                        
                        explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType29.setUnitRef(USD24);
                        explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType29.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue27, "1000000"));
                        explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType29.setValue(new BigDecimal(explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue27));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberElement28 = instancObjectFactory.createAggregateAmountOfLimitsSanctioned(explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType29);
                        bodyElements.add(explictMember2PARTA_lyt_PartAAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberElement28);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
                
                Unit USD30 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD30 == null){
                    USD30 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD30.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD30.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD30);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfFundedLimitsSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue33 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfFundedLimitsSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue33 != null && !"".equals(explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue33)) {
                    

                Map explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap32 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap32.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap32.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext31 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap32 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext31.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext31);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext31.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType35 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType35.setContextRef(explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext31);
                        
                        explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType35.setUnitRef(USD30);
                        explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType35.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue33, "1000000"));
                        explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType35.setValue(new BigDecimal(explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue33));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberElement34 = instancObjectFactory.createAmountOfFundedLimitsSanctioned(explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType35);
                        bodyElements.add(explictMember2PARTA_lyt_PartAAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberElement34);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
                
                Unit USD36 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD36 == null){
                    USD36 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD36.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD36.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD36);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfNonFundedLimitsSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue39 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfNonFundedLimitsSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue39 != null && !"".equals(explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue39)) {
                    

                Map explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap38 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap38.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap38.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext37 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap38 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext37.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext37);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext37.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType41 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType41.setContextRef(explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext37);
                        
                        explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType41.setUnitRef(USD36);
                        explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType41.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue39, "1000000"));
                        explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType41.setValue(new BigDecimal(explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue39));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberElement40 = instancObjectFactory.createAmountOfNonFundedLimitsSanctioned(explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType41);
                        bodyElements.add(explictMember2PARTA_lyt_PartAAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberElement40);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
                
                Unit USD42 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD42 == null){
                    USD42 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD42.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD42.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD42);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOutstandingOfCustomerCreditLimitSenctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberValue45 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOutstandingOfCustomerCreditLimitSenctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberValue45 != null && !"".equals(explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberValue45)) {
                    

                Map explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberMap44 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberMap44.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberMap44.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberContext43 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberMap44 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberContext43.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberContext43);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberContext43.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType47 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType47.setContextRef(explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberContext43);
                        
                        explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType47.setUnitRef(USD42);
                        explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType47.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberValue45, "1000000"));
                        explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType47.setValue(new BigDecimal(explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberValue45));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberElement46 = instancObjectFactory.createAmountOutstandingOfCustomerCreditLimitSenctioned(explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType47);
                        bodyElements.add(explictMember2PARTA_lyt_PartAAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberElement46);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
                
                Unit USD48 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD48 == null){
                    USD48 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD48.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD48.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD48);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - SecurityValue
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberValue51 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getSecurityValue(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberValue51 != null && !"".equals(explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberValue51)) {
                    

                Map explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberMap50 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberMap50.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberMap50.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberContext49 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberMap50 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberContext49.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberContext49);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberContext49.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberDataType53 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberDataType53.setContextRef(explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberContext49);
                        
                        explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberDataType53.setUnitRef(USD48);
                        explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberDataType53.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberValue51, "1000000"));
                        explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberDataType53.setValue(new BigDecimal(explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberValue51));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberElement52 = instancObjectFactory.createSecurityValue(explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberDataType53);
                        bodyElements.add(explictMember2PARTA_lyt_PartASecurityValueMoreThanUSD2MillionMemberProblemCreditMemberElement52);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AssetsClassification
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberValue56 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAssetsClassification(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberValue56 != null && !"".equals(explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberValue56)) {
                    

                Map explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberMap55 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberMap55.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberMap55.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberContext54 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberMap55 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberContext54.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberContext54);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberContext54.getId());
                }

                        // create element JAXB Element

                        AssetsClassificationItemType explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberDataType58 = new AssetsClassificationItemType();
                        explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberDataType58.setContextRef(explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberContext54);
                        
                        explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberDataType58.setValue(explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberValue56);
                        
                        JAXBElement<AssetsClassificationItemType> explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberElement57 = instancObjectFactory.createAssetsClassification(explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberDataType58);
                        bodyElements.add(explictMember2PARTA_lyt_PartAAssetsClassificationMoreThanUSD2MillionMemberProblemCreditMemberElement57);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AssetsClassificationHostCountry
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberValue61 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAssetsClassificationHostCountry(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberValue61 != null && !"".equals(explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberValue61)) {
                    

                Map explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberMap60 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberMap60.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberMap60.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberContext59 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberMap60 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberContext59.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberContext59);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberContext59.getId());
                }

                        // create element JAXB Element

                        AssetsClassificationHostCountryItemType explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberDataType63 = new AssetsClassificationHostCountryItemType();
                        explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberDataType63.setContextRef(explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberContext59);
                        
                        explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberDataType63.setValue(explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberValue61);
                        
                        JAXBElement<AssetsClassificationHostCountryItemType> explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberElement62 = instancObjectFactory.createAssetsClassificationHostCountry(explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberDataType63);
                        bodyElements.add(explictMember2PARTA_lyt_PartAAssetsClassificationHostCountryMoreThanUSD2MillionMemberProblemCreditMemberElement62);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
                
                Unit USD64 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD64 == null){
                    USD64 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD64.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD64.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD64);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtBranch
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberValue67 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtBranch(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberValue67 != null && !"".equals(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberValue67)) {
                    

                Map explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberMap66 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberMap66.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberMap66.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberContext65 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberMap66 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberContext65.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberContext65);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberContext65.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberDataType69 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberDataType69.setContextRef(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberContext65);
                        
                        explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberDataType69.setUnitRef(USD64);
                        explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberDataType69.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberValue67, "1000000"));
                        explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberDataType69.setValue(new BigDecimal(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberValue67));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberElement68 = instancObjectFactory.createAmountOfProvisionsHeldAtBranch(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberDataType69);
                        bodyElements.add(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberElement68);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
                
                Unit USD70 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD70 == null){
                    USD70 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD70.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD70.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD70);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtHeadOffice
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberValue73 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtHeadOffice(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberValue73 != null && !"".equals(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberValue73)) {
                    

                Map explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberMap72 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberMap72.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberMap72.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberContext71 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberMap72 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberContext71.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberContext71);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberContext71.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberDataType75 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberDataType75.setContextRef(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberContext71);
                        
                        explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberDataType75.setUnitRef(USD70);
                        explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberDataType75.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberValue73, "1000000"));
                        explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberDataType75.setValue(new BigDecimal(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberValue73));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberElement74 = instancObjectFactory.createAmountOfProvisionsHeldAtHeadOffice(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberDataType75);
                        bodyElements.add(explictMember2PARTA_lyt_PartAAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberElement74);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
                
                Unit USD76 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD76 == null){
                    USD76 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD76.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD76.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD76);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfInterestSuspense
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue79 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfInterestSuspense(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue79 != null && !"".equals(explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue79)) {
                    

                Map explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap78 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap78.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap78.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext77 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap78 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext77.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext77);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext77.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType81 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType81.setContextRef(explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext77);
                        
                        explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType81.setUnitRef(USD76);
                        explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType81.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue79, "1000000"));
                        explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType81.setValue(new BigDecimal(explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue79));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberElement80 = instancObjectFactory.createAmountOfInterestSuspense(explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType81);
                        bodyElements.add(explictMember2PARTA_lyt_PartAAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberElement80);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
                
                Unit USD82 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD82 == null){
                    USD82 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD82.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD82.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD82);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AggregateAmountOfProvisionAndInterestSuspense
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue85 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAggregateAmountOfProvisionAndInterestSuspense(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue85 != null && !"".equals(explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue85)) {
                    

                Map explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap84 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap84.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap84.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext83 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap84 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext83.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext83);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext83.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType87 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType87.setContextRef(explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext83);
                        
                        explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType87.setUnitRef(USD82);
                        explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType87.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue85, "1000000"));
                        explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType87.setValue(new BigDecimal(explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue85));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberElement86 = instancObjectFactory.createAggregateAmountOfProvisionAndInterestSuspense(explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType87);
                        bodyElements.add(explictMember2PARTA_lyt_PartAAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberElement86);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
                
                Unit USD88 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD88 == null){
                    USD88 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD88.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD88.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD88);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberValue91 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberValue91 != null && !"".equals(explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberValue91)) {
                    

                Map explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberMap90 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberMap90.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberMap90.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberContext89 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberMap90 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberContext89.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberContext89);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberContext89.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberDataType93 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberDataType93.setContextRef(explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberContext89);
                        
                        explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberDataType93.setUnitRef(USD88);
                        explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberDataType93.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberValue91, "1000000"));
                        explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberDataType93.setValue(new BigDecimal(explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberValue91));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberElement92 = instancObjectFactory.createAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberDataType93);
                        bodyElements.add(explictMember2PARTA_lyt_PartAAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberElement92);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
                
                Unit USD94 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD94 == null){
                    USD94 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD94.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD94.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD94);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfShortFall
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberValue97 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfShortFall(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberValue97 != null && !"".equals(explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberValue97)) {
                    

                Map explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberMap96 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberMap96.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberMap96.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberContext95 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberMap96 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberContext95.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberContext95);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberContext95.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberDataType99 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberDataType99.setContextRef(explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberContext95);
                        
                        explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberDataType99.setUnitRef(USD94);
                        explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberDataType99.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberValue97, "1000000"));
                        explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberDataType99.setValue(new BigDecimal(explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberValue97));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberElement98 = instancObjectFactory.createAmountOfShortFall(explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberDataType99);
                        bodyElements.add(explictMember2PARTA_lyt_PartAAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberElement98);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
                
                Unit USD100 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD100 == null){
                    USD100 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD100.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD100.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD100);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfHeadOfficeSupportFund
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberValue103 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfHeadOfficeSupportFund(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberValue103 != null && !"".equals(explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberValue103)) {
                    

                Map explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberMap102 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberMap102.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberMap102.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberContext101 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberMap102 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberContext101.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberContext101);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberContext101.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberDataType105 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberDataType105.setContextRef(explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberContext101);
                        
                        explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberDataType105.setUnitRef(USD100);
                        explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberDataType105.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberValue103, "1000000"));
                        explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberDataType105.setValue(new BigDecimal(explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberValue103));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberElement104 = instancObjectFactory.createAmountOfHeadOfficeSupportFund(explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberDataType105);
                        bodyElements.add(explictMember2PARTA_lyt_PartAAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberElement104);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - DevelopmentsDuringQuarter
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberValue108 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getDevelopmentsDuringQuarter(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberValue108 != null && !"".equals(explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberValue108)) {
                    

                Map explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberMap107 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberMap107.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberMap107.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                        Context explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberContext106 = PCIReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode,  explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberMap107 );
                        
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberContext106.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberContext106);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberContext106.getId());
                }

                        // create element JAXB Element

                        StringItemType explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberDataType110 = new StringItemType();
                        explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberDataType110.setContextRef(explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberContext106);
                        
                        explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberDataType110.setValue(explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberValue108);
                        
                        JAXBElement<StringItemType> explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberElement109 = instancObjectFactory.createDevelopmentsDuringQuarter(explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberDataType110);
                        bodyElements.add(explictMember2PARTA_lyt_PartADevelopmentsDuringQuarterMoreThanUSD2MillionMemberProblemCreditMemberElement109);
                    }
                    
            
            
                
                
            




            
            
            
            // end xbrl report element           

            

            });
            

            
            // create variable for subclass PARTA_lyt_PartA_Total if any typeMembers then List or Single
            List<PARTA_lyt_PartA_Total> pARTA_lyt_PartA_Total = mainReportData.getPARTA_lyt_PartA_Total();
            
            


            // with typemembers which requires multiple type member record
            
            pARTA_lyt_PartA_Total.forEach((field)->{
            // crate variable loop  for type member
            
                // crate variable for type member CountryCode
                String countryCode = field.getCountryCode();
            
                // crate variable for type member BranchCode
                String branchCode = field.getBranchCode();
            
            // end create variable loop for type member

            // create xbrl report element
            
            // start create element for report of PARTA_lyt_PartA_Total
            // create unit if not empty
            
                
                Unit USD111 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD111 == null){
                    USD111 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD111.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD111.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD111);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AggregateAmountOfLimitsSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue114 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAggregateAmountOfLimitsSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue114 != null && !"".equals(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue114)) {
                    

                Map explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap113 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap113.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap113.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext112 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap113 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext112.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext112);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext112.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType116 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType116.setContextRef(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext112);
                        
                        explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType116.setUnitRef(USD111);
                        explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType116.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue114, "1000000"));
                        explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType116.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue114));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberElement115 = instancObjectFactory.createAggregateAmountOfLimitsSanctioned(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType116);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberElement115);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Total
            // create unit if not empty
            
                
                Unit USD117 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD117 == null){
                    USD117 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD117.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD117.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD117);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfFundedLimitsSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue120 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfFundedLimitsSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue120 != null && !"".equals(explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue120)) {
                    

                Map explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap119 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap119.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap119.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext118 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap119 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext118.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext118);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext118.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType122 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType122.setContextRef(explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext118);
                        
                        explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType122.setUnitRef(USD117);
                        explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType122.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue120, "1000000"));
                        explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType122.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue120));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberElement121 = instancObjectFactory.createAmountOfFundedLimitsSanctioned(explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType122);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberElement121);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Total
            // create unit if not empty
            
                
                Unit USD123 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD123 == null){
                    USD123 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD123.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD123.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD123);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfNonFundedLimitsSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue126 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfNonFundedLimitsSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue126 != null && !"".equals(explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue126)) {
                    

                Map explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap125 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap125.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap125.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext124 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberMap125 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext124.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext124);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext124.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType128 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType128.setContextRef(explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberContext124);
                        
                        explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType128.setUnitRef(USD123);
                        explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType128.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue126, "1000000"));
                        explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType128.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberValue126));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberElement127 = instancObjectFactory.createAmountOfNonFundedLimitsSanctioned(explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType128);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfNonFundedLimitsSanctionedMoreThanUSD2MillionMemberProblemCreditMemberElement127);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Total
            // create unit if not empty
            
                
                Unit USD129 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD129 == null){
                    USD129 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD129.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD129.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD129);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOutstandingOfCustomerCreditLimitSenctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberValue132 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOutstandingOfCustomerCreditLimitSenctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberValue132 != null && !"".equals(explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberValue132)) {
                    

                Map explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberMap131 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberMap131.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberMap131.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberContext130 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberMap131 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberContext130.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberContext130);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberContext130.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType134 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType134.setContextRef(explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberContext130);
                        
                        explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType134.setUnitRef(USD129);
                        explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType134.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberValue132, "1000000"));
                        explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType134.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberValue132));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberElement133 = instancObjectFactory.createAmountOutstandingOfCustomerCreditLimitSenctioned(explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberDataType134);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOutstandingOfCustomerCreditLimitSenctionedMoreThanUSD2MillionMemberProblemCreditMemberElement133);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Total
            // create unit if not empty
            
                
                Unit USD135 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD135 == null){
                    USD135 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD135.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD135.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD135);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - SecurityValue
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberValue138 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getSecurityValue(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberValue138 != null && !"".equals(explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberValue138)) {
                    

                Map explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberMap137 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberMap137.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberMap137.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberContext136 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberMap137 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberContext136.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberContext136);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberContext136.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberDataType140 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberDataType140.setContextRef(explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberContext136);
                        
                        explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberDataType140.setUnitRef(USD135);
                        explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberDataType140.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberValue138, "1000000"));
                        explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberDataType140.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberValue138));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberElement139 = instancObjectFactory.createSecurityValue(explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberDataType140);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_TotalSecurityValueMoreThanUSD2MillionMemberProblemCreditMemberElement139);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Total
            // create unit if not empty
            
                
                Unit USD141 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD141 == null){
                    USD141 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD141.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD141.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD141);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtBranch
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberValue144 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtBranch(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberValue144 != null && !"".equals(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberValue144)) {
                    

                Map explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberMap143 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberMap143.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberMap143.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberContext142 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberMap143 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberContext142.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberContext142);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberContext142.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberDataType146 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberDataType146.setContextRef(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberContext142);
                        
                        explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberDataType146.setUnitRef(USD141);
                        explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberDataType146.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberValue144, "1000000"));
                        explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberDataType146.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberValue144));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberElement145 = instancObjectFactory.createAmountOfProvisionsHeldAtBranch(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberDataType146);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtBranchMoreThanUSD2MillionMemberProblemCreditMemberElement145);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Total
            // create unit if not empty
            
                
                Unit USD147 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD147 == null){
                    USD147 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD147.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD147.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD147);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtHeadOffice
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberValue150 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtHeadOffice(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberValue150 != null && !"".equals(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberValue150)) {
                    

                Map explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberMap149 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberMap149.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberMap149.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberContext148 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberMap149 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberContext148.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberContext148);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberContext148.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberDataType152 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberDataType152.setContextRef(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberContext148);
                        
                        explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberDataType152.setUnitRef(USD147);
                        explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberDataType152.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberValue150, "1000000"));
                        explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberDataType152.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberValue150));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberElement151 = instancObjectFactory.createAmountOfProvisionsHeldAtHeadOffice(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberDataType152);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD2MillionMemberProblemCreditMemberElement151);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Total
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
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfInterestSuspense
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue156 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfInterestSuspense(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue156 != null && !"".equals(explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue156)) {
                    

                Map explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap155 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap155.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap155.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext154 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap155 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext154.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext154);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext154.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType158 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType158.setContextRef(explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext154);
                        
                        explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType158.setUnitRef(USD153);
                        explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType158.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue156, "1000000"));
                        explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType158.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue156));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberElement157 = instancObjectFactory.createAmountOfInterestSuspense(explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType158);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberElement157);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Total
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
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AggregateAmountOfProvisionAndInterestSuspense
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue162 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAggregateAmountOfProvisionAndInterestSuspense(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue162 != null && !"".equals(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue162)) {
                    

                Map explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap161 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap161.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap161.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext160 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberMap161 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext160.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext160);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext160.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType164 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType164.setContextRef(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberContext160);
                        
                        explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType164.setUnitRef(USD159);
                        explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType164.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue162, "1000000"));
                        explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType164.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberValue162));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberElement163 = instancObjectFactory.createAggregateAmountOfProvisionAndInterestSuspense(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberDataType164);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_TotalAggregateAmountOfProvisionAndInterestSuspenseMoreThanUSD2MillionMemberProblemCreditMemberElement163);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Total
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
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberValue168 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberValue168 != null && !"".equals(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberValue168)) {
                    

                Map explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberMap167 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberMap167.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberMap167.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberContext166 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberMap167 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberContext166.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberContext166);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberContext166.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberDataType170 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberDataType170.setContextRef(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberContext166);
                        
                        explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberDataType170.setUnitRef(USD165);
                        explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberDataType170.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberValue168, "1000000"));
                        explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberDataType170.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberValue168));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberElement169 = instancObjectFactory.createAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberDataType170);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD2MillionMemberProblemCreditMemberElement169);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Total
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
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfShortFall
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberValue174 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfShortFall(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberValue174 != null && !"".equals(explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberValue174)) {
                    

                Map explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberMap173 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberMap173.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberMap173.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberContext172 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberMap173 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberContext172.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberContext172);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberContext172.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberDataType176 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberDataType176.setContextRef(explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberContext172);
                        
                        explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberDataType176.setUnitRef(USD171);
                        explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberDataType176.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberValue174, "1000000"));
                        explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberDataType176.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberValue174));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberElement175 = instancObjectFactory.createAmountOfShortFall(explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberDataType176);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfShortFallMoreThanUSD2MillionMemberProblemCreditMemberElement175);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Total
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
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfHeadOfficeSupportFund
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberValue180 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfHeadOfficeSupportFund(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberValue180 != null && !"".equals(explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberValue180)) {
                    

                Map explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberMap179 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberMap179.put("CustomerCreditLimitAxis", "MoreThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberMap179.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberContext178 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberMap179 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberContext178.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberContext178);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberContext178.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberDataType182 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberDataType182.setContextRef(explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberContext178);
                        
                        explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberDataType182.setUnitRef(USD177);
                        explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberDataType182.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberValue180, "1000000"));
                        explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberDataType182.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberValue180));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberElement181 = instancObjectFactory.createAmountOfHeadOfficeSupportFund(explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberDataType182);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_TotalAmountOfHeadOfficeSupportFundMoreThanUSD2MillionMemberProblemCreditMemberElement181);
                    }
                    
            
            
                
                
            




            
            
            
            // end xbrl report element           

            

            });
            

            
            // create variable for subclass PARTA_lyt_PartA_Sect2 if any typeMembers then List or Single
            List<PARTA_lyt_PartA_Sect2> pARTA_lyt_PartA_Sect2 = mainReportData.getPARTA_lyt_PartA_Sect2();
            
            


            // with typemembers which requires multiple type member record
            
            pARTA_lyt_PartA_Sect2.forEach((field)->{
            // crate variable loop  for type member
            
                // crate variable for type member CountryCode
                String countryCode = field.getCountryCode();
            
                // crate variable for type member BranchCode
                String branchCode = field.getBranchCode();
            
            // end create variable loop for type member

            // create xbrl report element
            
            // start create element for report of PARTA_lyt_PartA_Sect2
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
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AggregateAmountOfLimitsSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue186 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAggregateAmountOfLimitsSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue186 != null && !"".equals(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue186)) {
                    

                Map explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberMap185 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberMap185.put("CustomerCreditLimitAxis", "LessThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberMap185.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext184 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberMap185 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext184.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext184);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext184.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType188 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType188.setContextRef(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext184);
                        
                        explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType188.setUnitRef(USD183);
                        explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType188.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue186, "1000000"));
                        explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType188.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue186));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberElement187 = instancObjectFactory.createAggregateAmountOfLimitsSanctioned(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType188);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberElement187);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Sect2
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
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfFundedLimitsSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue192 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfFundedLimitsSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue192 != null && !"".equals(explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue192)) {
                    

                Map explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberMap191 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberMap191.put("CustomerCreditLimitAxis", "LessThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberMap191.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext190 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberMap191 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext190.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext190);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext190.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType194 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType194.setContextRef(explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext190);
                        
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType194.setUnitRef(USD189);
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType194.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue192, "1000000"));
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType194.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue192));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberElement193 = instancObjectFactory.createAmountOfFundedLimitsSanctioned(explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType194);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberElement193);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Sect2
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
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfNonFundedLimitsSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue198 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfNonFundedLimitsSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue198 != null && !"".equals(explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue198)) {
                    

                Map explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberMap197 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberMap197.put("CustomerCreditLimitAxis", "LessThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberMap197.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext196 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberMap197 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext196.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext196);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext196.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType200 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType200.setContextRef(explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberContext196);
                        
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType200.setUnitRef(USD195);
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType200.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue198, "1000000"));
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType200.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberValue198));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberElement199 = instancObjectFactory.createAmountOfNonFundedLimitsSanctioned(explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberDataType200);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfNonFundedLimitsSanctionedLessThanUSD2MillionMemberProblemCreditMemberElement199);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Sect2
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
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOutstandingOfCustomerCreditLimitSenctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberValue204 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOutstandingOfCustomerCreditLimitSenctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberValue204 != null && !"".equals(explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberValue204)) {
                    

                Map explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberMap203 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberMap203.put("CustomerCreditLimitAxis", "LessThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberMap203.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberContext202 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberMap203 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberContext202.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberContext202);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberContext202.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberDataType206 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberDataType206.setContextRef(explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberContext202);
                        
                        explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberDataType206.setUnitRef(USD201);
                        explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberDataType206.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberValue204, "1000000"));
                        explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberDataType206.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberValue204));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberElement205 = instancObjectFactory.createAmountOutstandingOfCustomerCreditLimitSenctioned(explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberDataType206);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOutstandingOfCustomerCreditLimitSenctionedLessThanUSD2MillionMemberProblemCreditMemberElement205);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Sect2
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
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - SecurityValue
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberValue210 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getSecurityValue(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberValue210 != null && !"".equals(explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberValue210)) {
                    

                Map explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberMap209 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberMap209.put("CustomerCreditLimitAxis", "LessThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberMap209.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberContext208 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberMap209 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberContext208.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberContext208);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberContext208.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberDataType212 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberDataType212.setContextRef(explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberContext208);
                        
                        explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberDataType212.setUnitRef(USD207);
                        explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberDataType212.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberValue210, "1000000"));
                        explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberDataType212.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberValue210));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberElement211 = instancObjectFactory.createSecurityValue(explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberDataType212);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_Sect2SecurityValueLessThanUSD2MillionMemberProblemCreditMemberElement211);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Sect2
            // create unit if not empty
            
                
                Unit USD213 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD213 == null){
                    USD213 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD213.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD213.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD213);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtBranch
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberValue216 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtBranch(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberValue216 != null && !"".equals(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberValue216)) {
                    

                Map explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberMap215 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberMap215.put("CustomerCreditLimitAxis", "LessThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberMap215.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberContext214 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberMap215 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberContext214.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberContext214);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberContext214.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberDataType218 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberDataType218.setContextRef(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberContext214);
                        
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberDataType218.setUnitRef(USD213);
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberDataType218.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberValue216, "1000000"));
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberDataType218.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberValue216));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberElement217 = instancObjectFactory.createAmountOfProvisionsHeldAtBranch(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberDataType218);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD2MillionMemberProblemCreditMemberElement217);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Sect2
            // create unit if not empty
            
                
                Unit USD219 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD219 == null){
                    USD219 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD219.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD219.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD219);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtHeadOffice
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberValue222 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtHeadOffice(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberValue222 != null && !"".equals(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberValue222)) {
                    

                Map explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberMap221 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberMap221.put("CustomerCreditLimitAxis", "LessThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberMap221.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberContext220 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberMap221 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberContext220.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberContext220);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberContext220.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberDataType224 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberDataType224.setContextRef(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberContext220);
                        
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberDataType224.setUnitRef(USD219);
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberDataType224.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberValue222, "1000000"));
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberDataType224.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberValue222));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberElement223 = instancObjectFactory.createAmountOfProvisionsHeldAtHeadOffice(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberDataType224);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD2MillionMemberProblemCreditMemberElement223);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Sect2
            // create unit if not empty
            
                
                Unit USD225 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD225 == null){
                    USD225 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD225.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD225.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD225);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfInterestSuspense
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberValue228 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfInterestSuspense(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberValue228 != null && !"".equals(explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberValue228)) {
                    

                Map explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberMap227 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberMap227.put("CustomerCreditLimitAxis", "LessThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberMap227.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberContext226 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberMap227 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberContext226.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberContext226);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberContext226.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberDataType230 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberDataType230.setContextRef(explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberContext226);
                        
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberDataType230.setUnitRef(USD225);
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberDataType230.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberValue228, "1000000"));
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberDataType230.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberValue228));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberElement229 = instancObjectFactory.createAmountOfInterestSuspense(explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberDataType230);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberElement229);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Sect2
            // create unit if not empty
            
                
                Unit USD231 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD231 == null){
                    USD231 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD231.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD231.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD231);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AggregateAmountOfProvisionAndInterestSuspense
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberValue234 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAggregateAmountOfProvisionAndInterestSuspense(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberValue234 != null && !"".equals(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberValue234)) {
                    

                Map explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberMap233 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberMap233.put("CustomerCreditLimitAxis", "LessThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberMap233.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberContext232 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberMap233 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberContext232.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberContext232);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberContext232.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberDataType236 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberDataType236.setContextRef(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberContext232);
                        
                        explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberDataType236.setUnitRef(USD231);
                        explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberDataType236.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberValue234, "1000000"));
                        explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberDataType236.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberValue234));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberElement235 = instancObjectFactory.createAggregateAmountOfProvisionAndInterestSuspense(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberDataType236);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_Sect2AggregateAmountOfProvisionAndInterestSuspenseLessThanUSD2MillionMemberProblemCreditMemberElement235);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Sect2
            // create unit if not empty
            
                
                Unit USD237 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD237 == null){
                    USD237 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD237.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD237.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD237);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberValue240 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberValue240 != null && !"".equals(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberValue240)) {
                    

                Map explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberMap239 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberMap239.put("CustomerCreditLimitAxis", "LessThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberMap239.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberContext238 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberMap239 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberContext238.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberContext238);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberContext238.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberDataType242 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberDataType242.setContextRef(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberContext238);
                        
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberDataType242.setUnitRef(USD237);
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberDataType242.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberValue240, "1000000"));
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberDataType242.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberValue240));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberElement241 = instancObjectFactory.createAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberDataType242);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD2MillionMemberProblemCreditMemberElement241);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Sect2
            // create unit if not empty
            
                
                Unit USD243 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD243 == null){
                    USD243 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD243.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD243.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD243);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfShortFall
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberValue246 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfShortFall(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberValue246 != null && !"".equals(explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberValue246)) {
                    

                Map explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberMap245 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberMap245.put("CustomerCreditLimitAxis", "LessThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberMap245.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberContext244 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberMap245 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberContext244.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberContext244);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberContext244.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberDataType248 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberDataType248.setContextRef(explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberContext244);
                        
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberDataType248.setUnitRef(USD243);
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberDataType248.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberValue246, "1000000"));
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberDataType248.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberValue246));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberElement247 = instancObjectFactory.createAmountOfShortFall(explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberDataType248);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfShortFallLessThanUSD2MillionMemberProblemCreditMemberElement247);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Sect2
            // create unit if not empty
            
                
                Unit USD249 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD249 == null){
                    USD249 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD249.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD249.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD249);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfHeadOfficeSupportFund
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberValue252 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfHeadOfficeSupportFund(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberValue252 != null && !"".equals(explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberValue252)) {
                    

                Map explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberMap251 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberMap251.put("CustomerCreditLimitAxis", "LessThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberMap251.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                    Context explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberContext250 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberMap251 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberContext250.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberContext250);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberContext250.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberDataType254 = new MonetaryItemType();
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberDataType254.setContextRef(explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberContext250);
                        
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberDataType254.setUnitRef(USD249);
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberDataType254.setDecimals(CommonFns.getDecimals(explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberValue252, "1000000"));
                        explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberDataType254.setValue(new BigDecimal(explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberValue252));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberElement253 = instancObjectFactory.createAmountOfHeadOfficeSupportFund(explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberDataType254);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_Sect2AmountOfHeadOfficeSupportFundLessThanUSD2MillionMemberProblemCreditMemberElement253);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTA_lyt_PartA_Sect2
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - DevelopmentsDuringQuarter
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberValue257 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getDevelopmentsDuringQuarter(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD2MillionMember", "ProblemCreditMember");
                    if(explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberValue257 != null && !"".equals(explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberValue257)) {
                    

                Map explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberMap256 = new HashMap<String, String>();
                explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberMap256.put("CustomerCreditLimitAxis", "LessThanUSD2MillionMember");                
                explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberMap256.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                // create context object
                
                        Context explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberContext255 = PCIReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode,  explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberMap256 );
                        
                if(!contextIdentifiers.contains(explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberContext255.getId())) {
                    contextElements.add(explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberContext255);
                    contextIdentifiers.add(explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberContext255.getId());
                }

                        // create element JAXB Element

                        StringItemType explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberDataType259 = new StringItemType();
                        explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberDataType259.setContextRef(explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberContext255);
                        
                        explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberDataType259.setValue(explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberValue257);
                        
                        JAXBElement<StringItemType> explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberElement258 = instancObjectFactory.createDevelopmentsDuringQuarter(explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberDataType259);
                        bodyElements.add(explictMember2PARTA_lyt_PartA_Sect2DevelopmentsDuringQuarterLessThanUSD2MillionMemberProblemCreditMemberElement258);
                    }
                    
            
            
                
                
            




            
            
            
            // end xbrl report element           

            

            });
            

            
            // create variable for subclass PARTA_lyt_PartA_Gross if any typeMembers then List or Single
            List<PARTA_lyt_PartA_Gross> pARTA_lyt_PartA_Gross = mainReportData.getPARTA_lyt_PartA_Gross();
            
            


            // with typemembers which requires multiple type member record
            
            pARTA_lyt_PartA_Gross.forEach((field)->{
            // crate variable loop  for type member
            
                // crate variable for type member CountryCode
                String countryCode = field.getCountryCode();
            
                // crate variable for type member BranchCode
                String branchCode = field.getBranchCode();
            
            // end create variable loop for type member

            // create xbrl report element
            
            // start create element for report of PARTA_lyt_PartA_Gross
            // create unit if not empty
            
                
                Unit USD260 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD260 == null){
                    USD260 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD260.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD260.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD260);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AggregateAmountOfLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue263 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAggregateAmountOfLimitsSanctioned(), "ProblemCreditMember");
                        if(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue263 != null && !"".equals(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue263)) {
                        
                    

                    Map explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap262 = new HashMap<String, String>();
                    explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap262.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                    Context explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext261 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap262 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext261.getId())) {
                        contextElements.add(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext261);
                        contextIdentifiers.add(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext261.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType265 = new MonetaryItemType();
                    explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType265.setContextRef(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext261);
                    
                    explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType265.setUnitRef(USD260);
                    explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType265.setDecimals(CommonFns.getDecimals(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue263, "1000000"));
                    explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType265.setValue(new BigDecimal(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue263));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement264 = instancObjectFactory.createAggregateAmountOfLimitsSanctioned(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType265);
                    bodyElements.add(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement264);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTA_lyt_PartA_Gross
            // create unit if not empty
            
                
                Unit USD266 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD266 == null){
                    USD266 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD266.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD266.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD266);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfFundedLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue269 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfFundedLimitsSanctioned(), "ProblemCreditMember");
                        if(explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue269 != null && !"".equals(explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue269)) {
                        
                    

                    Map explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap268 = new HashMap<String, String>();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap268.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                    Context explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext267 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap268 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext267.getId())) {
                        contextElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext267);
                        contextIdentifiers.add(explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext267.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType271 = new MonetaryItemType();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType271.setContextRef(explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext267);
                    
                    explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType271.setUnitRef(USD266);
                    explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType271.setDecimals(CommonFns.getDecimals(explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue269, "1000000"));
                    explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType271.setValue(new BigDecimal(explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue269));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement270 = instancObjectFactory.createAmountOfFundedLimitsSanctioned(explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType271);
                    bodyElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement270);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTA_lyt_PartA_Gross
            // create unit if not empty
            
                
                Unit USD272 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD272 == null){
                    USD272 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD272.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD272.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD272);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfNonFundedLimitsSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue275 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfNonFundedLimitsSanctioned(), "ProblemCreditMember");
                        if(explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue275 != null && !"".equals(explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue275)) {
                        
                    

                    Map explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap274 = new HashMap<String, String>();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap274.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                    Context explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext273 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap274 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext273.getId())) {
                        contextElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext273);
                        contextIdentifiers.add(explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext273.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType277 = new MonetaryItemType();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType277.setContextRef(explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext273);
                    
                    explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType277.setUnitRef(USD272);
                    explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType277.setDecimals(CommonFns.getDecimals(explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue275, "1000000"));
                    explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType277.setValue(new BigDecimal(explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue275));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement276 = instancObjectFactory.createAmountOfNonFundedLimitsSanctioned(explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType277);
                    bodyElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfNonFundedLimitsSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement276);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTA_lyt_PartA_Gross
            // create unit if not empty
            
                
                Unit USD278 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD278 == null){
                    USD278 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD278.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD278.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD278);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOutstandingOfCustomerCreditLimitSenctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue281 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOutstandingOfCustomerCreditLimitSenctioned(), "ProblemCreditMember");
                        if(explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue281 != null && !"".equals(explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue281)) {
                        
                    

                    Map explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap280 = new HashMap<String, String>();
                    explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap280.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                    Context explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext279 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap280 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext279.getId())) {
                        contextElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext279);
                        contextIdentifiers.add(explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext279.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType283 = new MonetaryItemType();
                    explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType283.setContextRef(explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext279);
                    
                    explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType283.setUnitRef(USD278);
                    explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType283.setDecimals(CommonFns.getDecimals(explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue281, "1000000"));
                    explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType283.setValue(new BigDecimal(explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue281));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement282 = instancObjectFactory.createAmountOutstandingOfCustomerCreditLimitSenctioned(explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType283);
                    bodyElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOutstandingOfCustomerCreditLimitSenctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement282);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTA_lyt_PartA_Gross
            // create unit if not empty
            
                
                Unit USD284 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD284 == null){
                    USD284 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD284.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD284.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD284);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - SecurityValue
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue287 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getSecurityValue(), "ProblemCreditMember");
                        if(explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue287 != null && !"".equals(explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue287)) {
                        
                    

                    Map explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisMap286 = new HashMap<String, String>();
                    explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisMap286.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                    Context explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisContext285 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisMap286 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisContext285.getId())) {
                        contextElements.add(explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisContext285);
                        contextIdentifiers.add(explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisContext285.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType289 = new MonetaryItemType();
                    explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType289.setContextRef(explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisContext285);
                    
                    explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType289.setUnitRef(USD284);
                    explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType289.setDecimals(CommonFns.getDecimals(explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue287, "1000000"));
                    explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType289.setValue(new BigDecimal(explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue287));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement288 = instancObjectFactory.createSecurityValue(explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType289);
                    bodyElements.add(explictMember1PARTA_lyt_PartA_GrossSecurityValueTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement288);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTA_lyt_PartA_Gross
            // create unit if not empty
            
                
                Unit USD290 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD290 == null){
                    USD290 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD290.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD290.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD290);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtBranch
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue293 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtBranch(), "ProblemCreditMember");
                        if(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue293 != null && !"".equals(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue293)) {
                        
                    

                    Map explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisMap292 = new HashMap<String, String>();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisMap292.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                    Context explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisContext291 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisMap292 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisContext291.getId())) {
                        contextElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisContext291);
                        contextIdentifiers.add(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisContext291.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType295 = new MonetaryItemType();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType295.setContextRef(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisContext291);
                    
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType295.setUnitRef(USD290);
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType295.setDecimals(CommonFns.getDecimals(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue293, "1000000"));
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType295.setValue(new BigDecimal(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue293));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement294 = instancObjectFactory.createAmountOfProvisionsHeldAtBranch(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType295);
                    bodyElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement294);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTA_lyt_PartA_Gross
            // create unit if not empty
            
                
                Unit USD296 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD296 == null){
                    USD296 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD296.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD296.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD296);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtHeadOffice
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue299 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtHeadOffice(), "ProblemCreditMember");
                        if(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue299 != null && !"".equals(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue299)) {
                        
                    

                    Map explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisMap298 = new HashMap<String, String>();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisMap298.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                    Context explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisContext297 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisMap298 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisContext297.getId())) {
                        contextElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisContext297);
                        contextIdentifiers.add(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisContext297.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType301 = new MonetaryItemType();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType301.setContextRef(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisContext297);
                    
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType301.setUnitRef(USD296);
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType301.setDecimals(CommonFns.getDecimals(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue299, "1000000"));
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType301.setValue(new BigDecimal(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue299));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement300 = instancObjectFactory.createAmountOfProvisionsHeldAtHeadOffice(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType301);
                    bodyElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement300);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTA_lyt_PartA_Gross
            // create unit if not empty
            
                
                Unit USD302 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD302 == null){
                    USD302 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD302.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD302.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD302);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfInterestSuspense
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue305 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfInterestSuspense(), "ProblemCreditMember");
                        if(explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue305 != null && !"".equals(explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue305)) {
                        
                    

                    Map explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisMap304 = new HashMap<String, String>();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisMap304.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                    Context explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisContext303 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisMap304 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisContext303.getId())) {
                        contextElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisContext303);
                        contextIdentifiers.add(explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisContext303.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType307 = new MonetaryItemType();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType307.setContextRef(explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisContext303);
                    
                    explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType307.setUnitRef(USD302);
                    explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType307.setDecimals(CommonFns.getDecimals(explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue305, "1000000"));
                    explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType307.setValue(new BigDecimal(explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue305));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement306 = instancObjectFactory.createAmountOfInterestSuspense(explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType307);
                    bodyElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement306);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTA_lyt_PartA_Gross
            // create unit if not empty
            
                
                Unit USD308 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD308 == null){
                    USD308 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD308.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD308.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD308);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AggregateAmountOfProvisionAndInterestSuspense
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue311 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAggregateAmountOfProvisionAndInterestSuspense(), "ProblemCreditMember");
                        if(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue311 != null && !"".equals(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue311)) {
                        
                    

                    Map explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisMap310 = new HashMap<String, String>();
                    explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisMap310.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                    Context explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisContext309 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisMap310 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisContext309.getId())) {
                        contextElements.add(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisContext309);
                        contextIdentifiers.add(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisContext309.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType313 = new MonetaryItemType();
                    explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType313.setContextRef(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisContext309);
                    
                    explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType313.setUnitRef(USD308);
                    explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType313.setDecimals(CommonFns.getDecimals(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue311, "1000000"));
                    explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType313.setValue(new BigDecimal(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue311));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement312 = instancObjectFactory.createAggregateAmountOfProvisionAndInterestSuspense(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType313);
                    bodyElements.add(explictMember1PARTA_lyt_PartA_GrossAggregateAmountOfProvisionAndInterestSuspenseTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement312);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTA_lyt_PartA_Gross
            // create unit if not empty
            
                
                Unit USD314 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD314 == null){
                    USD314 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD314.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD314.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD314);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue317 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(), "ProblemCreditMember");
                        if(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue317 != null && !"".equals(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue317)) {
                        
                    

                    Map explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisMap316 = new HashMap<String, String>();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisMap316.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                    Context explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisContext315 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisMap316 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisContext315.getId())) {
                        contextElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisContext315);
                        contextIdentifiers.add(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisContext315.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType319 = new MonetaryItemType();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType319.setContextRef(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisContext315);
                    
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType319.setUnitRef(USD314);
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType319.setDecimals(CommonFns.getDecimals(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue317, "1000000"));
                    explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType319.setValue(new BigDecimal(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue317));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement318 = instancObjectFactory.createAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType319);
                    bodyElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement318);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTA_lyt_PartA_Gross
            // create unit if not empty
            
                
                Unit USD320 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD320 == null){
                    USD320 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD320.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD320.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD320);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfShortFall
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue323 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfShortFall(), "ProblemCreditMember");
                        if(explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue323 != null && !"".equals(explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue323)) {
                        
                    

                    Map explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisMap322 = new HashMap<String, String>();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisMap322.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                    Context explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisContext321 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisMap322 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisContext321.getId())) {
                        contextElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisContext321);
                        contextIdentifiers.add(explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisContext321.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType325 = new MonetaryItemType();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType325.setContextRef(explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisContext321);
                    
                    explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType325.setUnitRef(USD320);
                    explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType325.setDecimals(CommonFns.getDecimals(explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue323, "1000000"));
                    explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType325.setValue(new BigDecimal(explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue323));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement324 = instancObjectFactory.createAmountOfShortFall(explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType325);
                    bodyElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement324);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTA_lyt_PartA_Gross
            // create unit if not empty
            
                
                Unit USD326 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD326 == null){
                    USD326 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD326.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD326.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD326);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfHeadOfficeSupportFund
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue329 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfHeadOfficeSupportFund(), "ProblemCreditMember");
                        if(explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue329 != null && !"".equals(explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue329)) {
                        
                    

                    Map explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisMap328 = new HashMap<String, String>();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisMap328.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemCreditMember");                
                    
                    Context explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisContext327 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisMap328 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisContext327.getId())) {
                        contextElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisContext327);
                        contextIdentifiers.add(explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisContext327.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType331 = new MonetaryItemType();
                    explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType331.setContextRef(explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisContext327);
                    
                    explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType331.setUnitRef(USD326);
                    explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType331.setDecimals(CommonFns.getDecimals(explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue329, "1000000"));
                    explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType331.setValue(new BigDecimal(explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberValue329));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement330 = instancObjectFactory.createAmountOfHeadOfficeSupportFund(explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberDataType331);
                    bodyElements.add(explictMember1PARTA_lyt_PartA_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemCreditMemberElement330);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            
            // end xbrl report element           

            

            });
            

            
            // create variable for subclass PARTB_lyt_PartB1 if any typeMembers then List or Single
            List<PARTB_lyt_PartB1> pARTB_lyt_PartB1 = mainReportData.getPARTB_lyt_PartB1();
            
            


            // with typemembers which requires multiple type member record
            
            pARTB_lyt_PartB1.forEach((field)->{
            // crate variable loop  for type member
            
                // crate variable for type member CountryCode
                String countryCode = field.getCountryCode();
            
                // crate variable for type member BranchCode
                String branchCode = field.getBranchCode();
            
                // crate variable for type member NameOfIssuer
                String nameOfIssuer = field.getNameOfIssuer();
            
                // crate variable for type member IssuerGroupName
                String issuerGroupName = field.getIssuerGroupName();
            
            // end create variable loop for type member

            // create xbrl report element
            
            // start create element for report of PARTB_lyt_PartB1
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - SoverignCharacter
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberValue334 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getSoverignCharacter(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberValue334 != null && !"".equals(explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberValue334)) {
                    

                Map explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberMap333 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberMap333.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberMap333.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                        Context explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberContext332 = PCIReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfIssuer, issuerGroupName,  explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberMap333 );
                        
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberContext332.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberContext332);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberContext332.getId());
                }

                        // create element JAXB Element

                        StringItemType explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType336 = new StringItemType();
                        explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType336.setContextRef(explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberContext332);
                        
                        explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType336.setValue(explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberValue334);
                        
                        JAXBElement<StringItemType> explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberElement335 = instancObjectFactory.createSoverignCharacter(explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType336);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1SoverignCharacterMoreThanUSD1MiliionMemberProblemInvestmentMemberElement335);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - CategoryOfBorrower
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberValue339 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getCategoryOfBorrower(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberValue339 != null && !"".equals(explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberValue339)) {
                    

                Map explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberMap338 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberMap338.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberMap338.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                        Context explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberContext337 = PCIReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfIssuer, issuerGroupName,  explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberMap338 );
                        
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberContext337.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberContext337);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberContext337.getId());
                }

                        // create element JAXB Element

                        CategoryStatusItemType explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType341 = new CategoryStatusItemType();
                        explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType341.setContextRef(explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberContext337);
                        
                        explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType341.setValue(explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberValue339);
                        
                        JAXBElement<CategoryStatusItemType> explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberElement340 = instancObjectFactory.createCategoryOfBorrower(explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType341);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1CategoryOfBorrowerMoreThanUSD1MiliionMemberProblemInvestmentMemberElement340);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1
            // create unit if not empty
            
                
                Unit USD342 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD342 == null){
                    USD342 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD342.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD342.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD342);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfBookValueOfCreditSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue345 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfBookValueOfCreditSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue345 != null && !"".equals(explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue345)) {
                    

                Map explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap344 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap344.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap344.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext343 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfIssuer, issuerGroupName,  explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap344 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext343.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext343);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext343.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType347 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType347.setContextRef(explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext343);
                        
                        explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType347.setUnitRef(USD342);
                        explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType347.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue345, "1000000"));
                        explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType347.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue345));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberElement346 = instancObjectFactory.createAmountOfBookValueOfCreditSanctioned(explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType347);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1AmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberElement346);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1
            // create unit if not empty
            
                
                Unit USD348 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD348 == null){
                    USD348 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD348.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD348.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD348);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfMarketValueOfCreditSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue351 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfMarketValueOfCreditSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue351 != null && !"".equals(explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue351)) {
                    

                Map explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap350 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap350.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap350.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext349 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfIssuer, issuerGroupName,  explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap350 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext349.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext349);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext349.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType353 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType353.setContextRef(explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext349);
                        
                        explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType353.setUnitRef(USD348);
                        explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType353.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue351, "1000000"));
                        explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType353.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue351));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberElement352 = instancObjectFactory.createAmountOfMarketValueOfCreditSanctioned(explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType353);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1AmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberElement352);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AssetsClassification
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberValue356 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAssetsClassification(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberValue356 != null && !"".equals(explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberValue356)) {
                    

                Map explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberMap355 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberMap355.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberMap355.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberContext354 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfIssuer, issuerGroupName,  explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberMap355 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberContext354.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberContext354);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberContext354.getId());
                }

                        // create element JAXB Element

                        AssetsClassificationItemType explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType358 = new AssetsClassificationItemType();
                        explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType358.setContextRef(explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberContext354);
                        
                        explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType358.setValue(explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberValue356);
                        
                        JAXBElement<AssetsClassificationItemType> explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberElement357 = instancObjectFactory.createAssetsClassification(explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType358);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1AssetsClassificationMoreThanUSD1MiliionMemberProblemInvestmentMemberElement357);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1
            // create unit if not empty
            
                
                Unit USD359 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD359 == null){
                    USD359 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD359.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD359.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD359);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtBranch
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberValue362 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtBranch(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberValue362 != null && !"".equals(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberValue362)) {
                    

                Map explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberMap361 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberMap361.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberMap361.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberContext360 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfIssuer, issuerGroupName,  explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberMap361 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberContext360.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberContext360);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberContext360.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType364 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType364.setContextRef(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberContext360);
                        
                        explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType364.setUnitRef(USD359);
                        explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType364.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberValue362, "1000000"));
                        explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType364.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberValue362));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberElement363 = instancObjectFactory.createAmountOfProvisionsHeldAtBranch(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType364);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberElement363);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1
            // create unit if not empty
            
                
                Unit USD365 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD365 == null){
                    USD365 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD365.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD365.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD365);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtHeadOffice
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberValue368 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtHeadOffice(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberValue368 != null && !"".equals(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberValue368)) {
                    

                Map explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberMap367 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberMap367.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberMap367.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberContext366 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfIssuer, issuerGroupName,  explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberMap367 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberContext366.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberContext366);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberContext366.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType370 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType370.setContextRef(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberContext366);
                        
                        explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType370.setUnitRef(USD365);
                        explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType370.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberValue368, "1000000"));
                        explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType370.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberValue368));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberElement369 = instancObjectFactory.createAmountOfProvisionsHeldAtHeadOffice(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType370);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1AmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberElement369);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1
            // create unit if not empty
            
                
                Unit USD371 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD371 == null){
                    USD371 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD371.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD371.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD371);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AggregateAmountOfProvision
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberValue374 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAggregateAmountOfProvision(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberValue374 != null && !"".equals(explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberValue374)) {
                    

                Map explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberMap373 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberMap373.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberMap373.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberContext372 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfIssuer, issuerGroupName,  explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberMap373 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberContext372.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberContext372);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberContext372.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType376 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType376.setContextRef(explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberContext372);
                        
                        explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType376.setUnitRef(USD371);
                        explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType376.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberValue374, "1000000"));
                        explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType376.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberValue374));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberElement375 = instancObjectFactory.createAggregateAmountOfProvision(explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType376);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1AggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberElement375);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1
            // create unit if not empty
            
                
                Unit USD377 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD377 == null){
                    USD377 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD377.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD377.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD377);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberValue380 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberValue380 != null && !"".equals(explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberValue380)) {
                    

                Map explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberMap379 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberMap379.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberMap379.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberContext378 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfIssuer, issuerGroupName,  explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberMap379 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberContext378.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberContext378);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberContext378.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType382 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType382.setContextRef(explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberContext378);
                        
                        explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType382.setUnitRef(USD377);
                        explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType382.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberValue380, "1000000"));
                        explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType382.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberValue380));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberElement381 = instancObjectFactory.createAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType382);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberElement381);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1
            // create unit if not empty
            
                
                Unit USD383 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD383 == null){
                    USD383 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD383.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD383.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD383);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfShortFall
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberValue386 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfShortFall(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberValue386 != null && !"".equals(explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberValue386)) {
                    

                Map explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberMap385 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberMap385.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberMap385.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberContext384 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfIssuer, issuerGroupName,  explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberMap385 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberContext384.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberContext384);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberContext384.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType388 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType388.setContextRef(explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberContext384);
                        
                        explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType388.setUnitRef(USD383);
                        explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType388.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberValue386, "1000000"));
                        explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType388.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberValue386));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberElement387 = instancObjectFactory.createAmountOfShortFall(explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType388);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1AmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberElement387);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1
            // create unit if not empty
            
                
                Unit USD389 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD389 == null){
                    USD389 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD389.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD389.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD389);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfHeadOfficeSupportFund
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberValue392 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfHeadOfficeSupportFund(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberValue392 != null && !"".equals(explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberValue392)) {
                    

                Map explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberMap391 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberMap391.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberMap391.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberContext390 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode, nameOfIssuer, issuerGroupName,  explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberMap391 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberContext390.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberContext390);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberContext390.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType394 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType394.setContextRef(explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberContext390);
                        
                        explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType394.setUnitRef(USD389);
                        explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType394.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberValue392, "1000000"));
                        explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType394.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberValue392));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberElement393 = instancObjectFactory.createAmountOfHeadOfficeSupportFund(explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType394);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1AmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberElement393);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - DevelopmentsDuringQuarter
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberValue397 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getDevelopmentsDuringQuarter(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberValue397 != null && !"".equals(explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberValue397)) {
                    

                Map explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberMap396 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberMap396.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberMap396.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                        Context explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberContext395 = PCIReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode, nameOfIssuer, issuerGroupName,  explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberMap396 );
                        
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberContext395.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberContext395);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberContext395.getId());
                }

                        // create element JAXB Element

                        StringItemType explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType399 = new StringItemType();
                        explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType399.setContextRef(explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberContext395);
                        
                        explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType399.setValue(explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberValue397);
                        
                        JAXBElement<StringItemType> explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberElement398 = instancObjectFactory.createDevelopmentsDuringQuarter(explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType399);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1DevelopmentsDuringQuarterMoreThanUSD1MiliionMemberProblemInvestmentMemberElement398);
                    }
                    
            
            
                
                
            




            
            
            
            // end xbrl report element           

            

            });
            

            
            // create variable for subclass PARTB_lyt_PartB1_total if any typeMembers then List or Single
            List<PARTB_lyt_PartB1_total> pARTB_lyt_PartB1_total = mainReportData.getPARTB_lyt_PartB1_total();
            
            


            // with typemembers which requires multiple type member record
            
            pARTB_lyt_PartB1_total.forEach((field)->{
            // crate variable loop  for type member
            
                // crate variable for type member CountryCode
                String countryCode = field.getCountryCode();
            
                // crate variable for type member BranchCode
                String branchCode = field.getBranchCode();
            
            // end create variable loop for type member

            // create xbrl report element
            
            // start create element for report of PARTB_lyt_PartB1_total
            // create unit if not empty
            
                
                Unit USD400 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD400 == null){
                    USD400 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD400.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD400.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD400);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfBookValueOfCreditSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue403 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfBookValueOfCreditSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue403 != null && !"".equals(explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue403)) {
                    

                Map explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap402 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap402.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap402.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext401 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap402 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext401.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext401);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext401.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType405 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType405.setContextRef(explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext401);
                        
                        explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType405.setUnitRef(USD400);
                        explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType405.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue403, "1000000"));
                        explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType405.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue403));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberElement404 = instancObjectFactory.createAmountOfBookValueOfCreditSanctioned(explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType405);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfBookValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberElement404);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_total
            // create unit if not empty
            
                
                Unit USD406 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD406 == null){
                    USD406 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD406.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD406.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD406);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfMarketValueOfCreditSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue409 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfMarketValueOfCreditSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue409 != null && !"".equals(explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue409)) {
                    

                Map explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap408 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap408.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap408.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext407 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberMap408 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext407.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext407);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext407.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType411 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType411.setContextRef(explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberContext407);
                        
                        explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType411.setUnitRef(USD406);
                        explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType411.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue409, "1000000"));
                        explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType411.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberValue409));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberElement410 = instancObjectFactory.createAmountOfMarketValueOfCreditSanctioned(explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType411);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfMarketValueOfCreditSanctionedMoreThanUSD1MiliionMemberProblemInvestmentMemberElement410);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_total
            // create unit if not empty
            
                
                Unit USD412 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD412 == null){
                    USD412 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD412.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD412.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD412);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtBranch
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberValue415 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtBranch(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberValue415 != null && !"".equals(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberValue415)) {
                    

                Map explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberMap414 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberMap414.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberMap414.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberContext413 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberMap414 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberContext413.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberContext413);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberContext413.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType417 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType417.setContextRef(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberContext413);
                        
                        explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType417.setUnitRef(USD412);
                        explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType417.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberValue415, "1000000"));
                        explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType417.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberValue415));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberElement416 = instancObjectFactory.createAmountOfProvisionsHeldAtBranch(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType417);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtBranchMoreThanUSD1MiliionMemberProblemInvestmentMemberElement416);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_total
            // create unit if not empty
            
                
                Unit USD418 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD418 == null){
                    USD418 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD418.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD418.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD418);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtHeadOffice
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberValue421 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtHeadOffice(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberValue421 != null && !"".equals(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberValue421)) {
                    

                Map explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberMap420 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberMap420.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberMap420.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberContext419 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberMap420 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberContext419.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberContext419);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberContext419.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType423 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType423.setContextRef(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberContext419);
                        
                        explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType423.setUnitRef(USD418);
                        explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType423.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberValue421, "1000000"));
                        explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType423.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberValue421));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberElement422 = instancObjectFactory.createAmountOfProvisionsHeldAtHeadOffice(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType423);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionsHeldAtHeadOfficeMoreThanUSD1MiliionMemberProblemInvestmentMemberElement422);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_total
            // create unit if not empty
            
                
                Unit USD424 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD424 == null){
                    USD424 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD424.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD424.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD424);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AggregateAmountOfProvision
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberValue427 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAggregateAmountOfProvision(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberValue427 != null && !"".equals(explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberValue427)) {
                    

                Map explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberMap426 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberMap426.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberMap426.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberContext425 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberMap426 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberContext425.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberContext425);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberContext425.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType429 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType429.setContextRef(explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberContext425);
                        
                        explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType429.setUnitRef(USD424);
                        explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType429.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberValue427, "1000000"));
                        explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType429.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberValue427));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberElement428 = instancObjectFactory.createAggregateAmountOfProvision(explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType429);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_totalAggregateAmountOfProvisionMoreThanUSD1MiliionMemberProblemInvestmentMemberElement428);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_total
            // create unit if not empty
            
                
                Unit USD430 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD430 == null){
                    USD430 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD430.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD430.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD430);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberValue433 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberValue433 != null && !"".equals(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberValue433)) {
                    

                Map explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberMap432 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberMap432.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberMap432.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberContext431 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberMap432 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberContext431.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberContext431);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberContext431.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType435 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType435.setContextRef(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberContext431);
                        
                        explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType435.setUnitRef(USD430);
                        explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType435.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberValue433, "1000000"));
                        explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType435.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberValue433));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberElement434 = instancObjectFactory.createAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType435);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesMoreThanUSD1MiliionMemberProblemInvestmentMemberElement434);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_total
            // create unit if not empty
            
                
                Unit USD436 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD436 == null){
                    USD436 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD436.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD436.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD436);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfShortFall
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberValue439 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfShortFall(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberValue439 != null && !"".equals(explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberValue439)) {
                    

                Map explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberMap438 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberMap438.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberMap438.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberContext437 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberMap438 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberContext437.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberContext437);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberContext437.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType441 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType441.setContextRef(explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberContext437);
                        
                        explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType441.setUnitRef(USD436);
                        explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType441.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberValue439, "1000000"));
                        explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType441.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberValue439));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberElement440 = instancObjectFactory.createAmountOfShortFall(explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType441);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfShortFallMoreThanUSD1MiliionMemberProblemInvestmentMemberElement440);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_total
            // create unit if not empty
            
                
                Unit USD442 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD442 == null){
                    USD442 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD442.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD442.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD442);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfHeadOfficeSupportFund
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberValue445 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfHeadOfficeSupportFund(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "MoreThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberValue445 != null && !"".equals(explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberValue445)) {
                    

                Map explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberMap444 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberMap444.put("CustomerCreditLimitAxis", "MoreThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberMap444.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberContext443 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberMap444 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberContext443.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberContext443);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberContext443.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType447 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType447.setContextRef(explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberContext443);
                        
                        explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType447.setUnitRef(USD442);
                        explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType447.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberValue445, "1000000"));
                        explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType447.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberValue445));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberElement446 = instancObjectFactory.createAmountOfHeadOfficeSupportFund(explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberDataType447);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_totalAmountOfHeadOfficeSupportFundMoreThanUSD1MiliionMemberProblemInvestmentMemberElement446);
                    }
                    
            
            
                
                
            




            
            
            
            // end xbrl report element           

            

            });
            

            
            // create variable for subclass PARTB_lyt_PartB1_Sect2 if any typeMembers then List or Single
            List<PARTB_lyt_PartB1_Sect2> pARTB_lyt_PartB1_Sect2 = mainReportData.getPARTB_lyt_PartB1_Sect2();
            
            


            // with typemembers which requires multiple type member record
            
            pARTB_lyt_PartB1_Sect2.forEach((field)->{
            // crate variable loop  for type member
            
                // crate variable for type member CountryCode
                String countryCode = field.getCountryCode();
            
                // crate variable for type member BranchCode
                String branchCode = field.getBranchCode();
            
            // end create variable loop for type member

            // create xbrl report element
            
            // start create element for report of PARTB_lyt_PartB1_Sect2
            // create unit if not empty
            
                
                Unit USD448 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD448 == null){
                    USD448 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD448.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD448.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD448);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfBookValueOfCreditSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberValue451 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfBookValueOfCreditSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberValue451 != null && !"".equals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberValue451)) {
                    

                Map explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberMap450 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberMap450.put("CustomerCreditLimitAxis", "LessThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberMap450.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberContext449 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberMap450 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberContext449.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberContext449);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberContext449.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberDataType453 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberDataType453.setContextRef(explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberContext449);
                        
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberDataType453.setUnitRef(USD448);
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberDataType453.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberValue451, "1000000"));
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberDataType453.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberValue451));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberElement452 = instancObjectFactory.createAmountOfBookValueOfCreditSanctioned(explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberDataType453);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfBookValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberElement452);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_Sect2
            // create unit if not empty
            
                
                Unit USD454 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD454 == null){
                    USD454 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD454.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD454.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD454);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfMarketValueOfCreditSanctioned
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberValue457 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfMarketValueOfCreditSanctioned(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberValue457 != null && !"".equals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberValue457)) {
                    

                Map explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberMap456 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberMap456.put("CustomerCreditLimitAxis", "LessThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberMap456.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberContext455 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberMap456 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberContext455.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberContext455);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberContext455.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberDataType459 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberDataType459.setContextRef(explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberContext455);
                        
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberDataType459.setUnitRef(USD454);
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberDataType459.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberValue457, "1000000"));
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberDataType459.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberValue457));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberElement458 = instancObjectFactory.createAmountOfMarketValueOfCreditSanctioned(explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberDataType459);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfMarketValueOfCreditSanctionedLessThanUSD1MiliionMemberProblemInvestmentMemberElement458);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_Sect2
            // create unit if not empty
            
                
                Unit USD460 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD460 == null){
                    USD460 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD460.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD460.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD460);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtBranch
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberValue463 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtBranch(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberValue463 != null && !"".equals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberValue463)) {
                    

                Map explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberMap462 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberMap462.put("CustomerCreditLimitAxis", "LessThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberMap462.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberContext461 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberMap462 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberContext461.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberContext461);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberContext461.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberDataType465 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberDataType465.setContextRef(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberContext461);
                        
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberDataType465.setUnitRef(USD460);
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberDataType465.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberValue463, "1000000"));
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberDataType465.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberValue463));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberElement464 = instancObjectFactory.createAmountOfProvisionsHeldAtBranch(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberDataType465);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtBranchLessThanUSD1MiliionMemberProblemInvestmentMemberElement464);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_Sect2
            // create unit if not empty
            
                
                Unit USD466 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD466 == null){
                    USD466 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD466.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD466.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD466);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtHeadOffice
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberValue469 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtHeadOffice(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberValue469 != null && !"".equals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberValue469)) {
                    

                Map explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberMap468 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberMap468.put("CustomerCreditLimitAxis", "LessThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberMap468.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberContext467 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberMap468 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberContext467.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberContext467);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberContext467.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberDataType471 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberDataType471.setContextRef(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberContext467);
                        
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberDataType471.setUnitRef(USD466);
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberDataType471.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberValue469, "1000000"));
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberDataType471.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberValue469));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberElement470 = instancObjectFactory.createAmountOfProvisionsHeldAtHeadOffice(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberDataType471);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionsHeldAtHeadOfficeLessThanUSD1MiliionMemberProblemInvestmentMemberElement470);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_Sect2
            // create unit if not empty
            
                
                Unit USD472 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD472 == null){
                    USD472 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD472.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD472.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD472);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AggregateAmountOfProvision
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberValue475 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAggregateAmountOfProvision(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberValue475 != null && !"".equals(explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberValue475)) {
                    

                Map explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberMap474 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberMap474.put("CustomerCreditLimitAxis", "LessThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberMap474.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberContext473 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberMap474 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberContext473.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberContext473);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberContext473.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberDataType477 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberDataType477.setContextRef(explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberContext473);
                        
                        explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberDataType477.setUnitRef(USD472);
                        explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberDataType477.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberValue475, "1000000"));
                        explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberDataType477.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberValue475));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberElement476 = instancObjectFactory.createAggregateAmountOfProvision(explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberDataType477);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_Sect2AggregateAmountOfProvisionLessThanUSD1MiliionMemberProblemInvestmentMemberElement476);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_Sect2
            // create unit if not empty
            
                
                Unit USD478 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD478 == null){
                    USD478 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD478.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD478.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD478);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberValue481 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberValue481 != null && !"".equals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberValue481)) {
                    

                Map explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberMap480 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberMap480.put("CustomerCreditLimitAxis", "LessThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberMap480.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberContext479 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberMap480 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberContext479.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberContext479);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberContext479.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberDataType483 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberDataType483.setContextRef(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberContext479);
                        
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberDataType483.setUnitRef(USD478);
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberDataType483.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberValue481, "1000000"));
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberDataType483.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberValue481));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberElement482 = instancObjectFactory.createAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberDataType483);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesLessThanUSD1MiliionMemberProblemInvestmentMemberElement482);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_Sect2
            // create unit if not empty
            
                
                Unit USD484 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD484 == null){
                    USD484 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD484.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD484.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD484);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfShortFall
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberValue487 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfShortFall(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberValue487 != null && !"".equals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberValue487)) {
                    

                Map explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberMap486 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberMap486.put("CustomerCreditLimitAxis", "LessThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberMap486.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberContext485 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberMap486 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberContext485.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberContext485);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberContext485.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberDataType489 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberDataType489.setContextRef(explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberContext485);
                        
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberDataType489.setUnitRef(USD484);
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberDataType489.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberValue487, "1000000"));
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberDataType489.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberValue487));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberElement488 = instancObjectFactory.createAmountOfShortFall(explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberDataType489);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfShortFallLessThanUSD1MiliionMemberProblemInvestmentMemberElement488);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_Sect2
            // create unit if not empty
            
                
                Unit USD490 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD490 == null){
                    USD490 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD490.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD490.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD490);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfHeadOfficeSupportFund
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberValue493 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfHeadOfficeSupportFund(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberValue493 != null && !"".equals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberValue493)) {
                    

                Map explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberMap492 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberMap492.put("CustomerCreditLimitAxis", "LessThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberMap492.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                    Context explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberContext491 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberMap492 );
                        
                    
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberContext491.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberContext491);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberContext491.getId());
                }

                        // create element JAXB Element

                        MonetaryItemType explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberDataType495 = new MonetaryItemType();
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberDataType495.setContextRef(explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberContext491);
                        
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberDataType495.setUnitRef(USD490);
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberDataType495.setDecimals(CommonFns.getDecimals(explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberValue493, "1000000"));
                        explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberDataType495.setValue(new BigDecimal(explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberValue493));
                        
                        JAXBElement<MonetaryItemType> explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberElement494 = instancObjectFactory.createAmountOfHeadOfficeSupportFund(explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberDataType495);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_Sect2AmountOfHeadOfficeSupportFundLessThanUSD1MiliionMemberProblemInvestmentMemberElement494);
                    }
                    
            
            
                
                
            




            
            
            // start create element for report of PARTB_lyt_PartB1_Sect2
            // create unit if not empty
            
            // create context for none explict member
            // TODO: remove once done
            //CustomerCreditLimitAxis,TypeOfProblemCreditAndInvestmentCustomerAxis - DevelopmentsDuringQuarter
            
            
            
            // loop first explict member
            
            // loop second explict member
                

                // create value for element
                
                    String explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberValue498 = PCIReportUtil.retrieveValueForCustomerCreditLimitAxisTypeOfProblemCreditAndInvestmentCustomerAxis(field.getDevelopmentsDuringQuarter(), "TypeOfProblemCreditAndInvestmentCustomerAxis" , "LessThanUSD1MiliionMember", "ProblemInvestmentMember");
                    if(explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberValue498 != null && !"".equals(explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberValue498)) {
                    

                Map explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberMap497 = new HashMap<String, String>();
                explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberMap497.put("CustomerCreditLimitAxis", "LessThanUSD1MiliionMember");                
                explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberMap497.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                // create context object
                
                        Context explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberContext496 = PCIReportContextUtil.createFromToContextWithMembers( bankCode, startDate, endDate, countryCode, branchCode,  explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberMap497 );
                        
                if(!contextIdentifiers.contains(explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberContext496.getId())) {
                    contextElements.add(explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberContext496);
                    contextIdentifiers.add(explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberContext496.getId());
                }

                        // create element JAXB Element

                        StringItemType explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberDataType500 = new StringItemType();
                        explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberDataType500.setContextRef(explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberContext496);
                        
                        explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberDataType500.setValue(explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberValue498);
                        
                        JAXBElement<StringItemType> explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberElement499 = instancObjectFactory.createDevelopmentsDuringQuarter(explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberDataType500);
                        bodyElements.add(explictMember2PARTB_lyt_PartB1_Sect2DevelopmentsDuringQuarterLessThanUSD1MiliionMemberProblemInvestmentMemberElement499);
                    }
                    
            
            
                
                
            




            
            
            
            // end xbrl report element           

            

            });
            

            
            // create variable for subclass PARTB_lyt_PartB_Gross if any typeMembers then List or Single
            List<PARTB_lyt_PartB_Gross> pARTB_lyt_PartB_Gross = mainReportData.getPARTB_lyt_PartB_Gross();
            
            


            // with typemembers which requires multiple type member record
            
            pARTB_lyt_PartB_Gross.forEach((field)->{
            // crate variable loop  for type member
            
                // crate variable for type member CountryCode
                String countryCode = field.getCountryCode();
            
                // crate variable for type member BranchCode
                String branchCode = field.getBranchCode();
            
            // end create variable loop for type member

            // create xbrl report element
            
            // start create element for report of PARTB_lyt_PartB_Gross
            // create unit if not empty
            
                
                Unit USD501 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD501 == null){
                    USD501 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD501.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD501.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD501);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfBookValueOfCreditSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue504 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfBookValueOfCreditSanctioned(), "ProblemInvestmentMember");
                        if(explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue504 != null && !"".equals(explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue504)) {
                        
                    

                    Map explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap503 = new HashMap<String, String>();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap503.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                    Context explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext502 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap503 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext502.getId())) {
                        contextElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext502);
                        contextIdentifiers.add(explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext502.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType506 = new MonetaryItemType();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType506.setContextRef(explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext502);
                    
                    explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType506.setUnitRef(USD501);
                    explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType506.setDecimals(CommonFns.getDecimals(explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue504, "1000000"));
                    explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType506.setValue(new BigDecimal(explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue504));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement505 = instancObjectFactory.createAmountOfBookValueOfCreditSanctioned(explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType506);
                    bodyElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfBookValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement505);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTB_lyt_PartB_Gross
            // create unit if not empty
            
                
                Unit USD507 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD507 == null){
                    USD507 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD507.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD507.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD507);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfMarketValueOfCreditSanctioned
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue510 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfMarketValueOfCreditSanctioned(), "ProblemInvestmentMember");
                        if(explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue510 != null && !"".equals(explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue510)) {
                        
                    

                    Map explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap509 = new HashMap<String, String>();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap509.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                    Context explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext508 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisMap509 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext508.getId())) {
                        contextElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext508);
                        contextIdentifiers.add(explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext508.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType512 = new MonetaryItemType();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType512.setContextRef(explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisContext508);
                    
                    explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType512.setUnitRef(USD507);
                    explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType512.setDecimals(CommonFns.getDecimals(explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue510, "1000000"));
                    explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType512.setValue(new BigDecimal(explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue510));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement511 = instancObjectFactory.createAmountOfMarketValueOfCreditSanctioned(explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType512);
                    bodyElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfMarketValueOfCreditSanctionedTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement511);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTB_lyt_PartB_Gross
            // create unit if not empty
            
                
                Unit USD513 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD513 == null){
                    USD513 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD513.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD513.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD513);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtBranch
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue516 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtBranch(), "ProblemInvestmentMember");
                        if(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue516 != null && !"".equals(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue516)) {
                        
                    

                    Map explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisMap515 = new HashMap<String, String>();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisMap515.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                    Context explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisContext514 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisMap515 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisContext514.getId())) {
                        contextElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisContext514);
                        contextIdentifiers.add(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisContext514.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType518 = new MonetaryItemType();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType518.setContextRef(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisContext514);
                    
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType518.setUnitRef(USD513);
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType518.setDecimals(CommonFns.getDecimals(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue516, "1000000"));
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType518.setValue(new BigDecimal(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue516));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement517 = instancObjectFactory.createAmountOfProvisionsHeldAtBranch(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType518);
                    bodyElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtBranchTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement517);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTB_lyt_PartB_Gross
            // create unit if not empty
            
                
                Unit USD519 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD519 == null){
                    USD519 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD519.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD519.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD519);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionsHeldAtHeadOffice
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue522 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionsHeldAtHeadOffice(), "ProblemInvestmentMember");
                        if(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue522 != null && !"".equals(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue522)) {
                        
                    

                    Map explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisMap521 = new HashMap<String, String>();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisMap521.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                    Context explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisContext520 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisMap521 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisContext520.getId())) {
                        contextElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisContext520);
                        contextIdentifiers.add(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisContext520.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType524 = new MonetaryItemType();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType524.setContextRef(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisContext520);
                    
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType524.setUnitRef(USD519);
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType524.setDecimals(CommonFns.getDecimals(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue522, "1000000"));
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType524.setValue(new BigDecimal(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue522));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement523 = instancObjectFactory.createAmountOfProvisionsHeldAtHeadOffice(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType524);
                    bodyElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionsHeldAtHeadOfficeTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement523);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTB_lyt_PartB_Gross
            // create unit if not empty
            
                
                Unit USD525 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD525 == null){
                    USD525 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD525.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD525.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD525);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AggregateAmountOfProvision
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue528 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAggregateAmountOfProvision(), "ProblemInvestmentMember");
                        if(explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue528 != null && !"".equals(explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue528)) {
                        
                    

                    Map explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisMap527 = new HashMap<String, String>();
                    explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisMap527.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                    Context explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisContext526 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisMap527 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisContext526.getId())) {
                        contextElements.add(explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisContext526);
                        contextIdentifiers.add(explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisContext526.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType530 = new MonetaryItemType();
                    explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType530.setContextRef(explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisContext526);
                    
                    explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType530.setUnitRef(USD525);
                    explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType530.setDecimals(CommonFns.getDecimals(explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue528, "1000000"));
                    explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType530.setValue(new BigDecimal(explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue528));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement529 = instancObjectFactory.createAggregateAmountOfProvision(explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType530);
                    bodyElements.add(explictMember1PARTB_lyt_PartB_GrossAggregateAmountOfProvisionTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement529);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTB_lyt_PartB_Gross
            // create unit if not empty
            
                
                Unit USD531 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD531 == null){
                    USD531 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD531.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD531.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD531);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue534 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(), "ProblemInvestmentMember");
                        if(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue534 != null && !"".equals(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue534)) {
                        
                    

                    Map explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisMap533 = new HashMap<String, String>();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisMap533.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                    Context explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisContext532 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisMap533 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisContext532.getId())) {
                        contextElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisContext532);
                        contextIdentifiers.add(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisContext532.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType536 = new MonetaryItemType();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType536.setContextRef(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisContext532);
                    
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType536.setUnitRef(USD531);
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType536.setDecimals(CommonFns.getDecimals(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue534, "1000000"));
                    explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType536.setValue(new BigDecimal(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue534));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement535 = instancObjectFactory.createAmountOfProvisionRequiredToBeHeldByRegulatoryAuthorities(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType536);
                    bodyElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfProvisionRequiredToBeHeldByRegulatoryAuthoritiesTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement535);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTB_lyt_PartB_Gross
            // create unit if not empty
            
                
                Unit USD537 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD537 == null){
                    USD537 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD537.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD537.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD537);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfShortFall
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue540 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfShortFall(), "ProblemInvestmentMember");
                        if(explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue540 != null && !"".equals(explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue540)) {
                        
                    

                    Map explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisMap539 = new HashMap<String, String>();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisMap539.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                    Context explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisContext538 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisMap539 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisContext538.getId())) {
                        contextElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisContext538);
                        contextIdentifiers.add(explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisContext538.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType542 = new MonetaryItemType();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType542.setContextRef(explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisContext538);
                    
                    explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType542.setUnitRef(USD537);
                    explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType542.setDecimals(CommonFns.getDecimals(explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue540, "1000000"));
                    explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType542.setValue(new BigDecimal(explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue540));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement541 = instancObjectFactory.createAmountOfShortFall(explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType542);
                    bodyElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfShortFallTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement541);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            // start create element for report of PARTB_lyt_PartB_Gross
            // create unit if not empty
            
                
                Unit USD543 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("USD")).findAny().orElse(null);
                //unitObj = option.isPresent()? option.get() : null;
                if(USD543 == null){
                    USD543 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                    USD543.setId("USD");
                    QName unitMeasureValue = new QName("iso4217:USD");
                    USD543.getMeasure().add(unitMeasureValue);
                    unitElements.add(USD543);
                }
                
            // create context for none explict member
            // TODO: remove once done
            //TypeOfProblemCreditAndInvestmentCustomerAxis - AmountOfHeadOfficeSupportFund
            
            
            
            
                    // create value for element
                    
                        String explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue546 = PCIReportUtil.retrieveValueForTypeOfProblemCreditAndInvestmentCustomerAxis(field.getAmountOfHeadOfficeSupportFund(), "ProblemInvestmentMember");
                        if(explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue546 != null && !"".equals(explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue546)) {
                        
                    

                    Map explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisMap545 = new HashMap<String, String>();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisMap545.put("TypeOfProblemCreditAndInvestmentCustomerAxis", "ProblemInvestmentMember");                
                    
                    Context explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisContext544 = PCIReportContextUtil.createAsOfContextWithMembers( bankCode, periodDate, countryCode, branchCode,  explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisMap545 );
                        
                    
                    if(!contextIdentifiers.contains(explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisContext544.getId())) {
                        contextElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisContext544);
                        contextIdentifiers.add(explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisContext544.getId());
                    }
                    
                    // create element JAXB Element

                    MonetaryItemType explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType548 = new MonetaryItemType();
                    explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType548.setContextRef(explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisContext544);
                    
                    explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType548.setUnitRef(USD543);
                    explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType548.setDecimals(CommonFns.getDecimals(explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue546, "1000000"));
                    explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType548.setValue(new BigDecimal(explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberValue546));
                    
                    
                    JAXBElement<MonetaryItemType> explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement547 = instancObjectFactory.createAmountOfHeadOfficeSupportFund(explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberDataType548);
                    bodyElements.add(explictMember1PARTB_lyt_PartB_GrossAmountOfHeadOfficeSupportFundTypeOfProblemCreditAndInvestmentCustomerAxisProblemInvestmentMemberElement547);
                    }
                    
            
            
                // crate variable for explicit member TypeOfProblemCreditAndInvestmentCustomerAxis
                //private List<TypeOfProblemCreditAndInvestmentCustomerAxis> typeOfProblemCreditAndInvestmentCustomerAxis = field.getTypeOfProblemCreditAndInvestmentCustomerAxis();
                

            




            
            
            
            // end xbrl report element           

            

            });
            

            
            // create variable for subclass AuthorisedSignatory_Signatory if any typeMembers then List or Single
            AuthorisedSignatory_Signatory authorisedSignatory_Signatory = mainReportData.getAuthorisedSignatory_Signatory();
            
            
            {
            // create xbrl report element
            AuthorisedSignatory_Signatory field = authorisedSignatory_Signatory;
            
            // create unit if not empty
            
            // start create element for report of AuthorisedSignatory_Signatory
            // create context for none explict member
            // TODO: remove once done
            // - NameOfSignatory
            
            
                Context authorisedSignatory_SignatoryNameOfSignatoryContext549 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(authorisedSignatory_SignatoryNameOfSignatoryContext549.getId())) {
                contextElements.add(authorisedSignatory_SignatoryNameOfSignatoryContext549);
                contextIdentifiers.add(authorisedSignatory_SignatoryNameOfSignatoryContext549.getId());
            }
            
            
            // create element JAXB Element

            StringItemType nameOfSignatoryValue = new StringItemType();
            nameOfSignatoryValue.setContextRef(authorisedSignatory_SignatoryNameOfSignatoryContext549);
            
                    nameOfSignatoryValue.setValue(field.getNameOfSignatory());        
                    
            
            
            JAXBElement<StringItemType> nameOfSignatoryElement = instancObjectFactory.createNameOfSignatory(nameOfSignatoryValue);
            bodyElements.add(nameOfSignatoryElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of AuthorisedSignatory_Signatory
            // create context for none explict member
            // TODO: remove once done
            // - DesignationOfSignatory
            
            
                Context authorisedSignatory_SignatoryDesignationOfSignatoryContext550 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(authorisedSignatory_SignatoryDesignationOfSignatoryContext550.getId())) {
                contextElements.add(authorisedSignatory_SignatoryDesignationOfSignatoryContext550);
                contextIdentifiers.add(authorisedSignatory_SignatoryDesignationOfSignatoryContext550.getId());
            }
            
            
            // create element JAXB Element

            StringItemType designationOfSignatoryValue = new StringItemType();
            designationOfSignatoryValue.setContextRef(authorisedSignatory_SignatoryDesignationOfSignatoryContext550);
            
                    designationOfSignatoryValue.setValue(field.getDesignationOfSignatory());        
                    
            
            
            JAXBElement<StringItemType> designationOfSignatoryElement = instancObjectFactory.createDesignationOfSignatory(designationOfSignatoryValue);
            bodyElements.add(designationOfSignatoryElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit pure551 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("PURE")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(pure551 == null){
                pure551 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                pure551.setId("PURE");
                QName unitMeasureValue = new QName("xbrli:pure");
                pure551.getMeasure().add(unitMeasureValue);
                unitElements.add(pure551);
            }
            
            // start create element for report of AuthorisedSignatory_Signatory
            // create context for none explict member
            // TODO: remove once done
            // - AuthorisedSignatoryMobileNumber
            
            
                Context authorisedSignatory_SignatoryAuthorisedSignatoryMobileNumberContext552 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(authorisedSignatory_SignatoryAuthorisedSignatoryMobileNumberContext552.getId())) {
                contextElements.add(authorisedSignatory_SignatoryAuthorisedSignatoryMobileNumberContext552);
                contextIdentifiers.add(authorisedSignatory_SignatoryAuthorisedSignatoryMobileNumberContext552.getId());
            }
            
            
            // create element JAXB Element

            IntegerItemType authorisedSignatoryMobileNumberValue = new IntegerItemType();
            authorisedSignatoryMobileNumberValue.setContextRef(authorisedSignatory_SignatoryAuthorisedSignatoryMobileNumberContext552);
            
            authorisedSignatoryMobileNumberValue.setUnitRef(pure551);
            authorisedSignatoryMobileNumberValue.setDecimals("INF");
            authorisedSignatoryMobileNumberValue.setValue(new BigInteger(field.getAuthorisedSignatoryMobileNumber()));
            
            
            
            JAXBElement<IntegerItemType> authorisedSignatoryMobileNumberElement = instancObjectFactory.createAuthorisedSignatoryMobileNumber(authorisedSignatoryMobileNumberValue);
            bodyElements.add(authorisedSignatoryMobileNumberElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit pure553 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("PURE")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(pure553 == null){
                pure553 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                pure553.setId("PURE");
                QName unitMeasureValue = new QName("xbrli:pure");
                pure553.getMeasure().add(unitMeasureValue);
                unitElements.add(pure553);
            }
            
            // start create element for report of AuthorisedSignatory_Signatory
            // create context for none explict member
            // TODO: remove once done
            // - AuthorisedSignatoryLandlineNumber
            
            
                Context authorisedSignatory_SignatoryAuthorisedSignatoryLandlineNumberContext554 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(authorisedSignatory_SignatoryAuthorisedSignatoryLandlineNumberContext554.getId())) {
                contextElements.add(authorisedSignatory_SignatoryAuthorisedSignatoryLandlineNumberContext554);
                contextIdentifiers.add(authorisedSignatory_SignatoryAuthorisedSignatoryLandlineNumberContext554.getId());
            }
            
            
            // create element JAXB Element

            IntegerItemType authorisedSignatoryLandlineNumberValue = new IntegerItemType();
            authorisedSignatoryLandlineNumberValue.setContextRef(authorisedSignatory_SignatoryAuthorisedSignatoryLandlineNumberContext554);
            
            authorisedSignatoryLandlineNumberValue.setUnitRef(pure553);
            authorisedSignatoryLandlineNumberValue.setDecimals("INF");
            authorisedSignatoryLandlineNumberValue.setValue(new BigInteger(field.getAuthorisedSignatoryLandlineNumber()));
            
            
            
            JAXBElement<IntegerItemType> authorisedSignatoryLandlineNumberElement = instancObjectFactory.createAuthorisedSignatoryLandlineNumber(authorisedSignatoryLandlineNumberValue);
            bodyElements.add(authorisedSignatoryLandlineNumberElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of AuthorisedSignatory_Signatory
            // create context for none explict member
            // TODO: remove once done
            // - EMailIDOfAuthorisedReportingOfficial
            
            
                Context authorisedSignatory_SignatoryEMailIDOfAuthorisedReportingOfficialContext555 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(authorisedSignatory_SignatoryEMailIDOfAuthorisedReportingOfficialContext555.getId())) {
                contextElements.add(authorisedSignatory_SignatoryEMailIDOfAuthorisedReportingOfficialContext555);
                contextIdentifiers.add(authorisedSignatory_SignatoryEMailIDOfAuthorisedReportingOfficialContext555.getId());
            }
            
            
            // create element JAXB Element

            StringItemType eMailIDOfAuthorisedReportingOfficialValue = new StringItemType();
            eMailIDOfAuthorisedReportingOfficialValue.setContextRef(authorisedSignatory_SignatoryEMailIDOfAuthorisedReportingOfficialContext555);
            
                    eMailIDOfAuthorisedReportingOfficialValue.setValue(field.getEMailIDOfAuthorisedReportingOfficial());        
                    
            
            
            JAXBElement<StringItemType> eMailIDOfAuthorisedReportingOfficialElement = instancObjectFactory.createEMailIDOfAuthorisedReportingOfficial(eMailIDOfAuthorisedReportingOfficialValue);
            bodyElements.add(eMailIDOfAuthorisedReportingOfficialElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of AuthorisedSignatory_Signatory
            // create context for none explict member
            // TODO: remove once done
            // - PlaceOfSignature
            
            
                Context authorisedSignatory_SignatoryPlaceOfSignatureContext556 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(authorisedSignatory_SignatoryPlaceOfSignatureContext556.getId())) {
                contextElements.add(authorisedSignatory_SignatoryPlaceOfSignatureContext556);
                contextIdentifiers.add(authorisedSignatory_SignatoryPlaceOfSignatureContext556.getId());
            }
            
            
            // create element JAXB Element

            StringItemType placeOfSignatureValue = new StringItemType();
            placeOfSignatureValue.setContextRef(authorisedSignatory_SignatoryPlaceOfSignatureContext556);
            
                    placeOfSignatureValue.setValue(field.getPlaceOfSignature());        
                    
            
            
            JAXBElement<StringItemType> placeOfSignatureElement = instancObjectFactory.createPlaceOfSignature(placeOfSignatureValue);
            bodyElements.add(placeOfSignatureElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of AuthorisedSignatory_Signatory
            // create context for none explict member
            // TODO: remove once done
            // - DateOfSigning
            
            
                Context authorisedSignatory_SignatoryDateOfSigningContext557 = PCIReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(authorisedSignatory_SignatoryDateOfSigningContext557.getId())) {
                contextElements.add(authorisedSignatory_SignatoryDateOfSigningContext557);
                contextIdentifiers.add(authorisedSignatory_SignatoryDateOfSigningContext557.getId());
            }
            
            
            // create element JAXB Element

            DateItemType dateOfSigningValue = new DateItemType();
            dateOfSigningValue.setContextRef(authorisedSignatory_SignatoryDateOfSigningContext557);
            
            dateOfSigningValue.setValue(PCIReportContextUtil.toXMLGeo(field.getDateOfSigning()));
            
            
            
            JAXBElement<DateItemType> dateOfSigningElement = instancObjectFactory.createDateOfSigning(dateOfSigningValue);
            bodyElements.add(dateOfSigningElement);

            
            
            




            
            
            
            // end xbrl report element   


        }

            
            


            // with typemembers which requires multiple type member record
            

            
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


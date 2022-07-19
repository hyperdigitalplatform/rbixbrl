package in.armedu.banking.report.rbixbrl.reports.formx;



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
import in.armedu.banking.report.rbixbrl.model.formx.*;

// add xbrl data type and inerface
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;
import in.armedu.banking.report.rbixbrl.util.CommonFns;
import in.armedu.banking.report.rbixbrl.model.ReportData;

// add data type 

import org.xbrl._2003.instance.StringItemType;

import org.xbrl._2003.instance.MonetaryItemType;

import org.xbrl._2003.instance.PureItemType;

import org.xbrl._2003.instance.DateItemType;


@Setter
public class FORMXReport implements XBRLReportIntf {
    private org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory instancObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
    
    
    @Override
    public StringWriter generateReport(ReportData reportData){
        JAXBContext jc;
        Marshaller m;
        // TODO should be generated dynamically
        FORMXReportData mainReportData = (FORMXReportData) reportData;

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
            // TODO should be changed to specific xsd related to report formx
            simpleType.setHref("../schemas/alo/in-rbi-formx.xsd");
            xbrl.getSchemaRef().add(simpleType);
            xbrl.getOtherAttributes().put(new QName("xml:lang"), "en");
           
            
            // context identifiers and body elements
            List<String> contextIdentifiers = new ArrayList<String>();
            List<Context> contextElements = new ArrayList<Context>();
            List<Object> bodyElements = new ArrayList<Object>();
            List<String> unitIdentifiers = new ArrayList<String>();
            List<Unit> unitElements = new ArrayList<Unit>();
           
            //Unit unitObj = null;
            //FORMXReportData fORMXReportData = new FORMXReportData();
            // print values           
    

            // TODO : create proper context with loop and element
            // initiatilize data class and allow to be set 
            //private FORMXReportData fORMXReportData = new FORMXReportData();
            // retrieve bankcode, startdate, enddate and perioddate
            String bankCode = mainReportData.getBankCode();
            String startDate = mainReportData.getStartDate();
            String endDate = mainReportData.getEndDate();
            String periodDate = mainReportData.getPeriodDate();

             
            
            // create variable for subclass GeneralInformation_GenInfo if any typeMembers then List or Single
            GeneralInformation_GenInfo generalInformation_GenInfo = mainReportData.getGeneralInformation_GenInfo();
            
            
            {
            // create xbrl report element
            GeneralInformation_GenInfo field = generalInformation_GenInfo;
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_GenInfo
            // create context for none explict member
            // TODO: remove once done
            // - ReturnName
            
            
                Context generalInformation_GenInfoReturnNameContext1 = FORMXReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_GenInfoReturnNameContext1.getId())) {
                contextElements.add(generalInformation_GenInfoReturnNameContext1);
                contextIdentifiers.add(generalInformation_GenInfoReturnNameContext1.getId());
            }
            
            
            // create element JAXB Element

            StringItemType returnNameValue = new StringItemType();
            returnNameValue.setContextRef(generalInformation_GenInfoReturnNameContext1);
            
                    returnNameValue.setValue(field.getReturnName());        
                    
            
            
            JAXBElement<StringItemType> returnNameElement = instancObjectFactory.createReturnName(returnNameValue);
            bodyElements.add(returnNameElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_GenInfo
            // create context for none explict member
            // TODO: remove once done
            // - ReturnCode
            
            
                Context generalInformation_GenInfoReturnCodeContext2 = FORMXReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_GenInfoReturnCodeContext2.getId())) {
                contextElements.add(generalInformation_GenInfoReturnCodeContext2);
                contextIdentifiers.add(generalInformation_GenInfoReturnCodeContext2.getId());
            }
            
            
            // create element JAXB Element

            StringItemType returnCodeValue = new StringItemType();
            returnCodeValue.setContextRef(generalInformation_GenInfoReturnCodeContext2);
            
                    returnCodeValue.setValue(field.getReturnCode());        
                    
            
            
            JAXBElement<StringItemType> returnCodeElement = instancObjectFactory.createReturnCode(returnCodeValue);
            bodyElements.add(returnCodeElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_GenInfo
            // create context for none explict member
            // TODO: remove once done
            // - NameOfReportingInstitution
            
            
                Context generalInformation_GenInfoNameOfReportingInstitutionContext3 = FORMXReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_GenInfoNameOfReportingInstitutionContext3.getId())) {
                contextElements.add(generalInformation_GenInfoNameOfReportingInstitutionContext3);
                contextIdentifiers.add(generalInformation_GenInfoNameOfReportingInstitutionContext3.getId());
            }
            
            
            // create element JAXB Element

            StringItemType nameOfReportingInstitutionValue = new StringItemType();
            nameOfReportingInstitutionValue.setContextRef(generalInformation_GenInfoNameOfReportingInstitutionContext3);
            
                    nameOfReportingInstitutionValue.setValue(field.getNameOfReportingInstitution());        
                    
            
            
            JAXBElement<StringItemType> nameOfReportingInstitutionElement = instancObjectFactory.createNameOfReportingInstitution(nameOfReportingInstitutionValue);
            bodyElements.add(nameOfReportingInstitutionElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_GenInfo
            // create context for none explict member
            // TODO: remove once done
            // - BankCode
            
            
            Context generalInformation_GenInfoBankCodeContext4 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(generalInformation_GenInfoBankCodeContext4.getId())) {
                contextElements.add(generalInformation_GenInfoBankCodeContext4);
                contextIdentifiers.add(generalInformation_GenInfoBankCodeContext4.getId());
            }
            
            
            // create element JAXB Element

            StringItemType bankCodeValue = new StringItemType();
            bankCodeValue.setContextRef(generalInformation_GenInfoBankCodeContext4);
            
                    bankCodeValue.setValue(field.getBankCode());        
                    
            
            
            JAXBElement<StringItemType> bankCodeElement = instancObjectFactory.createBankCode(bankCodeValue);
            bodyElements.add(bankCodeElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_GenInfo
            // create context for none explict member
            // TODO: remove once done
            // - ReportingPeriodStartDate
            
            
            Context generalInformation_GenInfoReportingPeriodStartDateContext5 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(generalInformation_GenInfoReportingPeriodStartDateContext5.getId())) {
                contextElements.add(generalInformation_GenInfoReportingPeriodStartDateContext5);
                contextIdentifiers.add(generalInformation_GenInfoReportingPeriodStartDateContext5.getId());
            }
            
            
            // create element JAXB Element

            StringItemType reportingPeriodStartDateValue = new StringItemType();
            reportingPeriodStartDateValue.setContextRef(generalInformation_GenInfoReportingPeriodStartDateContext5);
            
                    reportingPeriodStartDateValue.setValue(field.getReportingPeriodStartDate());        
                    
            
            
            JAXBElement<StringItemType> reportingPeriodStartDateElement = instancObjectFactory.createReportingPeriodStartDate(reportingPeriodStartDateValue);
            bodyElements.add(reportingPeriodStartDateElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_GenInfo
            // create context for none explict member
            // TODO: remove once done
            // - ReportingPeriodEndDate
            
            
            Context generalInformation_GenInfoReportingPeriodEndDateContext6 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(generalInformation_GenInfoReportingPeriodEndDateContext6.getId())) {
                contextElements.add(generalInformation_GenInfoReportingPeriodEndDateContext6);
                contextIdentifiers.add(generalInformation_GenInfoReportingPeriodEndDateContext6.getId());
            }
            
            
            // create element JAXB Element

            StringItemType reportingPeriodEndDateValue = new StringItemType();
            reportingPeriodEndDateValue.setContextRef(generalInformation_GenInfoReportingPeriodEndDateContext6);
            
                    reportingPeriodEndDateValue.setValue(field.getReportingPeriodEndDate());        
                    
            
            
            JAXBElement<StringItemType> reportingPeriodEndDateElement = instancObjectFactory.createReportingPeriodEndDate(reportingPeriodEndDateValue);
            bodyElements.add(reportingPeriodEndDateElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_GenInfo
            // create context for none explict member
            // TODO: remove once done
            // - ReportingFrequency
            
            
                Context generalInformation_GenInfoReportingFrequencyContext7 = FORMXReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_GenInfoReportingFrequencyContext7.getId())) {
                contextElements.add(generalInformation_GenInfoReportingFrequencyContext7);
                contextIdentifiers.add(generalInformation_GenInfoReportingFrequencyContext7.getId());
            }
            
            
            // create element JAXB Element

            StringItemType reportingFrequencyValue = new StringItemType();
            reportingFrequencyValue.setContextRef(generalInformation_GenInfoReportingFrequencyContext7);
            
                    reportingFrequencyValue.setValue(field.getReportingFrequency());        
                    
            
            
            JAXBElement<StringItemType> reportingFrequencyElement = instancObjectFactory.createReportingFrequency(reportingFrequencyValue);
            bodyElements.add(reportingFrequencyElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of GeneralInformation_GenInfo
            // create context for none explict member
            // TODO: remove once done
            // - ReturnVersion
            
            
                Context generalInformation_GenInfoReturnVersionContext8 = FORMXReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(generalInformation_GenInfoReturnVersionContext8.getId())) {
                contextElements.add(generalInformation_GenInfoReturnVersionContext8);
                contextIdentifiers.add(generalInformation_GenInfoReturnVersionContext8.getId());
            }
            
            
            // create element JAXB Element

            StringItemType returnVersionValue = new StringItemType();
            returnVersionValue.setContextRef(generalInformation_GenInfoReturnVersionContext8);
            
                    returnVersionValue.setValue(field.getReturnVersion());        
                    
            
            
            JAXBElement<StringItemType> returnVersionElement = instancObjectFactory.createReturnVersion(returnVersionValue);
            bodyElements.add(returnVersionElement);

            
            
            




            
            
            
            // end xbrl report element   


        }

            
            


            // with typemembers which requires multiple type member record
            

            
            // create variable for subclass PartI_PartI if any typeMembers then List or Single
            PartI_PartI partI_PartI = mainReportData.getPartI_PartI();
            
            
            {
            // create xbrl report element
            PartI_PartI field = partI_PartI;
            
            // create unit if not empty
            
                
            Unit INR9 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR9 == null){
                INR9 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR9.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR9.getMeasure().add(unitMeasureValue);
                unitElements.add(INR9);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - PaidupEquityShareCapital
            
            
            Context partI_PartIPaidupEquityShareCapitalContext10 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIPaidupEquityShareCapitalContext10.getId())) {
                contextElements.add(partI_PartIPaidupEquityShareCapitalContext10);
                contextIdentifiers.add(partI_PartIPaidupEquityShareCapitalContext10.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType paidupEquityShareCapitalValue = new MonetaryItemType();
            paidupEquityShareCapitalValue.setContextRef(partI_PartIPaidupEquityShareCapitalContext10);
            
            paidupEquityShareCapitalValue.setUnitRef(INR9);
            paidupEquityShareCapitalValue.setDecimals(CommonFns.getDecimals(field.getPaidupEquityShareCapital(), "1000"));
            paidupEquityShareCapitalValue.setValue(new BigDecimal(field.getPaidupEquityShareCapital()));
            
            
            
            JAXBElement<MonetaryItemType> paidupEquityShareCapitalElement = instancObjectFactory.createPaidupEquityShareCapital(paidupEquityShareCapitalValue);
            bodyElements.add(paidupEquityShareCapitalElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR11 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR11 == null){
                INR11 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR11.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR11.getMeasure().add(unitMeasureValue);
                unitElements.add(INR11);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - ReservesSurplus
            
            
            Context partI_PartIReservesSurplusContext12 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIReservesSurplusContext12.getId())) {
                contextElements.add(partI_PartIReservesSurplusContext12);
                contextIdentifiers.add(partI_PartIReservesSurplusContext12.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType reservesSurplusValue = new MonetaryItemType();
            reservesSurplusValue.setContextRef(partI_PartIReservesSurplusContext12);
            
            reservesSurplusValue.setUnitRef(INR11);
            reservesSurplusValue.setDecimals(CommonFns.getDecimals(field.getReservesSurplus(), "1000"));
            reservesSurplusValue.setValue(new BigDecimal(field.getReservesSurplus()));
            
            
            
            JAXBElement<MonetaryItemType> reservesSurplusElement = instancObjectFactory.createReservesSurplus(reservesSurplusValue);
            bodyElements.add(reservesSurplusElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR13 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR13 == null){
                INR13 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR13.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR13.getMeasure().add(unitMeasureValue);
                unitElements.add(INR13);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - ReserveFund
            
            
            Context partI_PartIReserveFundContext14 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIReserveFundContext14.getId())) {
                contextElements.add(partI_PartIReserveFundContext14);
                contextIdentifiers.add(partI_PartIReserveFundContext14.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType reserveFundValue = new MonetaryItemType();
            reserveFundValue.setContextRef(partI_PartIReserveFundContext14);
            
            reserveFundValue.setUnitRef(INR13);
            reserveFundValue.setDecimals(CommonFns.getDecimals(field.getReserveFund(), "1000"));
            reserveFundValue.setValue(new BigDecimal(field.getReserveFund()));
            
            
            
            JAXBElement<MonetaryItemType> reserveFundElement = instancObjectFactory.createReserveFund(reserveFundValue);
            bodyElements.add(reserveFundElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR15 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR15 == null){
                INR15 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR15.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR15.getMeasure().add(unitMeasureValue);
                unitElements.add(INR15);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - OtherReserves
            
            
            Context partI_PartIOtherReservesContext16 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIOtherReservesContext16.getId())) {
                contextElements.add(partI_PartIOtherReservesContext16);
                contextIdentifiers.add(partI_PartIOtherReservesContext16.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType otherReservesValue = new MonetaryItemType();
            otherReservesValue.setContextRef(partI_PartIOtherReservesContext16);
            
            otherReservesValue.setUnitRef(INR15);
            otherReservesValue.setDecimals(CommonFns.getDecimals(field.getOtherReserves(), "1000"));
            otherReservesValue.setValue(new BigDecimal(field.getOtherReserves()));
            
            
            
            JAXBElement<MonetaryItemType> otherReservesElement = instancObjectFactory.createOtherReserves(otherReservesValue);
            bodyElements.add(otherReservesElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR17 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR17 == null){
                INR17 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR17.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR17.getMeasure().add(unitMeasureValue);
                unitElements.add(INR17);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - SecuritiesPremium
            
            
            Context partI_PartISecuritiesPremiumContext18 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartISecuritiesPremiumContext18.getId())) {
                contextElements.add(partI_PartISecuritiesPremiumContext18);
                contextIdentifiers.add(partI_PartISecuritiesPremiumContext18.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType securitiesPremiumValue = new MonetaryItemType();
            securitiesPremiumValue.setContextRef(partI_PartISecuritiesPremiumContext18);
            
            securitiesPremiumValue.setUnitRef(INR17);
            securitiesPremiumValue.setDecimals(CommonFns.getDecimals(field.getSecuritiesPremium(), "1000"));
            securitiesPremiumValue.setValue(new BigDecimal(field.getSecuritiesPremium()));
            
            
            
            JAXBElement<MonetaryItemType> securitiesPremiumElement = instancObjectFactory.createSecuritiesPremium(securitiesPremiumValue);
            bodyElements.add(securitiesPremiumElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR19 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR19 == null){
                INR19 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR19.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR19.getMeasure().add(unitMeasureValue);
                unitElements.add(INR19);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - Deposits
            
            
            Context partI_PartIDepositsContext20 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIDepositsContext20.getId())) {
                contextElements.add(partI_PartIDepositsContext20);
                contextIdentifiers.add(partI_PartIDepositsContext20.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType depositsValue = new MonetaryItemType();
            depositsValue.setContextRef(partI_PartIDepositsContext20);
            
            depositsValue.setUnitRef(INR19);
            depositsValue.setDecimals(CommonFns.getDecimals(field.getDeposits(), "1000"));
            depositsValue.setValue(new BigDecimal(field.getDeposits()));
            
            
            
            JAXBElement<MonetaryItemType> depositsElement = instancObjectFactory.createDeposits(depositsValue);
            bodyElements.add(depositsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR21 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR21 == null){
                INR21 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR21.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR21.getMeasure().add(unitMeasureValue);
                unitElements.add(INR21);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - CurrentDeposits
            
            
            Context partI_PartICurrentDepositsContext22 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartICurrentDepositsContext22.getId())) {
                contextElements.add(partI_PartICurrentDepositsContext22);
                contextIdentifiers.add(partI_PartICurrentDepositsContext22.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType currentDepositsValue = new MonetaryItemType();
            currentDepositsValue.setContextRef(partI_PartICurrentDepositsContext22);
            
            currentDepositsValue.setUnitRef(INR21);
            currentDepositsValue.setDecimals(CommonFns.getDecimals(field.getCurrentDeposits(), "1000"));
            currentDepositsValue.setValue(new BigDecimal(field.getCurrentDeposits()));
            
            
            
            JAXBElement<MonetaryItemType> currentDepositsElement = instancObjectFactory.createCurrentDeposits(currentDepositsValue);
            bodyElements.add(currentDepositsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR23 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR23 == null){
                INR23 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR23.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR23.getMeasure().add(unitMeasureValue);
                unitElements.add(INR23);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - CurrentDepositsFromBanks
            
            
            Context partI_PartICurrentDepositsFromBanksContext24 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartICurrentDepositsFromBanksContext24.getId())) {
                contextElements.add(partI_PartICurrentDepositsFromBanksContext24);
                contextIdentifiers.add(partI_PartICurrentDepositsFromBanksContext24.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType currentDepositsFromBanksValue = new MonetaryItemType();
            currentDepositsFromBanksValue.setContextRef(partI_PartICurrentDepositsFromBanksContext24);
            
            currentDepositsFromBanksValue.setUnitRef(INR23);
            currentDepositsFromBanksValue.setDecimals(CommonFns.getDecimals(field.getCurrentDepositsFromBanks(), "1000"));
            currentDepositsFromBanksValue.setValue(new BigDecimal(field.getCurrentDepositsFromBanks()));
            
            
            
            JAXBElement<MonetaryItemType> currentDepositsFromBanksElement = instancObjectFactory.createCurrentDepositsFromBanks(currentDepositsFromBanksValue);
            bodyElements.add(currentDepositsFromBanksElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR25 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR25 == null){
                INR25 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR25.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR25.getMeasure().add(unitMeasureValue);
                unitElements.add(INR25);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - CurrentDepositsFromOthers
            
            
            Context partI_PartICurrentDepositsFromOthersContext26 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartICurrentDepositsFromOthersContext26.getId())) {
                contextElements.add(partI_PartICurrentDepositsFromOthersContext26);
                contextIdentifiers.add(partI_PartICurrentDepositsFromOthersContext26.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType currentDepositsFromOthersValue = new MonetaryItemType();
            currentDepositsFromOthersValue.setContextRef(partI_PartICurrentDepositsFromOthersContext26);
            
            currentDepositsFromOthersValue.setUnitRef(INR25);
            currentDepositsFromOthersValue.setDecimals(CommonFns.getDecimals(field.getCurrentDepositsFromOthers(), "1000"));
            currentDepositsFromOthersValue.setValue(new BigDecimal(field.getCurrentDepositsFromOthers()));
            
            
            
            JAXBElement<MonetaryItemType> currentDepositsFromOthersElement = instancObjectFactory.createCurrentDepositsFromOthers(currentDepositsFromOthersValue);
            bodyElements.add(currentDepositsFromOthersElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR27 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR27 == null){
                INR27 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR27.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR27.getMeasure().add(unitMeasureValue);
                unitElements.add(INR27);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - SavingsBankDeposits
            
            
            Context partI_PartISavingsBankDepositsContext28 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartISavingsBankDepositsContext28.getId())) {
                contextElements.add(partI_PartISavingsBankDepositsContext28);
                contextIdentifiers.add(partI_PartISavingsBankDepositsContext28.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType savingsBankDepositsValue = new MonetaryItemType();
            savingsBankDepositsValue.setContextRef(partI_PartISavingsBankDepositsContext28);
            
            savingsBankDepositsValue.setUnitRef(INR27);
            savingsBankDepositsValue.setDecimals(CommonFns.getDecimals(field.getSavingsBankDeposits(), "1000"));
            savingsBankDepositsValue.setValue(new BigDecimal(field.getSavingsBankDeposits()));
            
            
            
            JAXBElement<MonetaryItemType> savingsBankDepositsElement = instancObjectFactory.createSavingsBankDeposits(savingsBankDepositsValue);
            bodyElements.add(savingsBankDepositsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR29 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR29 == null){
                INR29 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR29.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR29.getMeasure().add(unitMeasureValue);
                unitElements.add(INR29);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - TermDeposits
            
            
            Context partI_PartITermDepositsContext30 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartITermDepositsContext30.getId())) {
                contextElements.add(partI_PartITermDepositsContext30);
                contextIdentifiers.add(partI_PartITermDepositsContext30.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType termDepositsValue = new MonetaryItemType();
            termDepositsValue.setContextRef(partI_PartITermDepositsContext30);
            
            termDepositsValue.setUnitRef(INR29);
            termDepositsValue.setDecimals(CommonFns.getDecimals(field.getTermDeposits(), "1000"));
            termDepositsValue.setValue(new BigDecimal(field.getTermDeposits()));
            
            
            
            JAXBElement<MonetaryItemType> termDepositsElement = instancObjectFactory.createTermDeposits(termDepositsValue);
            bodyElements.add(termDepositsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR31 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR31 == null){
                INR31 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR31.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR31.getMeasure().add(unitMeasureValue);
                unitElements.add(INR31);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - TermDepositsFromBanks
            
            
            Context partI_PartITermDepositsFromBanksContext32 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartITermDepositsFromBanksContext32.getId())) {
                contextElements.add(partI_PartITermDepositsFromBanksContext32);
                contextIdentifiers.add(partI_PartITermDepositsFromBanksContext32.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType termDepositsFromBanksValue = new MonetaryItemType();
            termDepositsFromBanksValue.setContextRef(partI_PartITermDepositsFromBanksContext32);
            
            termDepositsFromBanksValue.setUnitRef(INR31);
            termDepositsFromBanksValue.setDecimals(CommonFns.getDecimals(field.getTermDepositsFromBanks(), "1000"));
            termDepositsFromBanksValue.setValue(new BigDecimal(field.getTermDepositsFromBanks()));
            
            
            
            JAXBElement<MonetaryItemType> termDepositsFromBanksElement = instancObjectFactory.createTermDepositsFromBanks(termDepositsFromBanksValue);
            bodyElements.add(termDepositsFromBanksElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR33 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR33 == null){
                INR33 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR33.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR33.getMeasure().add(unitMeasureValue);
                unitElements.add(INR33);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - TermDepositsFromOthers
            
            
            Context partI_PartITermDepositsFromOthersContext34 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartITermDepositsFromOthersContext34.getId())) {
                contextElements.add(partI_PartITermDepositsFromOthersContext34);
                contextIdentifiers.add(partI_PartITermDepositsFromOthersContext34.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType termDepositsFromOthersValue = new MonetaryItemType();
            termDepositsFromOthersValue.setContextRef(partI_PartITermDepositsFromOthersContext34);
            
            termDepositsFromOthersValue.setUnitRef(INR33);
            termDepositsFromOthersValue.setDecimals(CommonFns.getDecimals(field.getTermDepositsFromOthers(), "1000"));
            termDepositsFromOthersValue.setValue(new BigDecimal(field.getTermDepositsFromOthers()));
            
            
            
            JAXBElement<MonetaryItemType> termDepositsFromOthersElement = instancObjectFactory.createTermDepositsFromOthers(termDepositsFromOthersValue);
            bodyElements.add(termDepositsFromOthersElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR35 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR35 == null){
                INR35 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR35.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR35.getMeasure().add(unitMeasureValue);
                unitElements.add(INR35);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - Borrowings
            
            
            Context partI_PartIBorrowingsContext36 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsContext36.getId())) {
                contextElements.add(partI_PartIBorrowingsContext36);
                contextIdentifiers.add(partI_PartIBorrowingsContext36.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsValue = new MonetaryItemType();
            borrowingsValue.setContextRef(partI_PartIBorrowingsContext36);
            
            borrowingsValue.setUnitRef(INR35);
            borrowingsValue.setDecimals(CommonFns.getDecimals(field.getBorrowings(), "1000"));
            borrowingsValue.setValue(new BigDecimal(field.getBorrowings()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsElement = instancObjectFactory.createBorrowings(borrowingsValue);
            bodyElements.add(borrowingsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR37 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR37 == null){
                INR37 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR37.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR37.getMeasure().add(unitMeasureValue);
                unitElements.add(INR37);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BorrowingsBanksInIndia
            
            
            Context partI_PartIBorrowingsBanksInIndiaContext38 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsBanksInIndiaContext38.getId())) {
                contextElements.add(partI_PartIBorrowingsBanksInIndiaContext38);
                contextIdentifiers.add(partI_PartIBorrowingsBanksInIndiaContext38.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsBanksInIndiaValue = new MonetaryItemType();
            borrowingsBanksInIndiaValue.setContextRef(partI_PartIBorrowingsBanksInIndiaContext38);
            
            borrowingsBanksInIndiaValue.setUnitRef(INR37);
            borrowingsBanksInIndiaValue.setDecimals(CommonFns.getDecimals(field.getBorrowingsBanksInIndia(), "1000"));
            borrowingsBanksInIndiaValue.setValue(new BigDecimal(field.getBorrowingsBanksInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsBanksInIndiaElement = instancObjectFactory.createBorrowingsBanksInIndia(borrowingsBanksInIndiaValue);
            bodyElements.add(borrowingsBanksInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR39 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR39 == null){
                INR39 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR39.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR39.getMeasure().add(unitMeasureValue);
                unitElements.add(INR39);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BorrowingsReserveBankOfIndia
            
            
            Context partI_PartIBorrowingsReserveBankOfIndiaContext40 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsReserveBankOfIndiaContext40.getId())) {
                contextElements.add(partI_PartIBorrowingsReserveBankOfIndiaContext40);
                contextIdentifiers.add(partI_PartIBorrowingsReserveBankOfIndiaContext40.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsReserveBankOfIndiaValue = new MonetaryItemType();
            borrowingsReserveBankOfIndiaValue.setContextRef(partI_PartIBorrowingsReserveBankOfIndiaContext40);
            
            borrowingsReserveBankOfIndiaValue.setUnitRef(INR39);
            borrowingsReserveBankOfIndiaValue.setDecimals(CommonFns.getDecimals(field.getBorrowingsReserveBankOfIndia(), "1000"));
            borrowingsReserveBankOfIndiaValue.setValue(new BigDecimal(field.getBorrowingsReserveBankOfIndia()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsReserveBankOfIndiaElement = instancObjectFactory.createBorrowingsReserveBankOfIndia(borrowingsReserveBankOfIndiaValue);
            bodyElements.add(borrowingsReserveBankOfIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR41 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR41 == null){
                INR41 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR41.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR41.getMeasure().add(unitMeasureValue);
                unitElements.add(INR41);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BorrowingsStateBankOfIndia
            
            
            Context partI_PartIBorrowingsStateBankOfIndiaContext42 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsStateBankOfIndiaContext42.getId())) {
                contextElements.add(partI_PartIBorrowingsStateBankOfIndiaContext42);
                contextIdentifiers.add(partI_PartIBorrowingsStateBankOfIndiaContext42.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsStateBankOfIndiaValue = new MonetaryItemType();
            borrowingsStateBankOfIndiaValue.setContextRef(partI_PartIBorrowingsStateBankOfIndiaContext42);
            
            borrowingsStateBankOfIndiaValue.setUnitRef(INR41);
            borrowingsStateBankOfIndiaValue.setDecimals(CommonFns.getDecimals(field.getBorrowingsStateBankOfIndia(), "1000"));
            borrowingsStateBankOfIndiaValue.setValue(new BigDecimal(field.getBorrowingsStateBankOfIndia()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsStateBankOfIndiaElement = instancObjectFactory.createBorrowingsStateBankOfIndia(borrowingsStateBankOfIndiaValue);
            bodyElements.add(borrowingsStateBankOfIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR43 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR43 == null){
                INR43 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR43.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR43.getMeasure().add(unitMeasureValue);
                unitElements.add(INR43);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BorrowingsSubsidiariesStateBankOfIndia
            
            
            Context partI_PartIBorrowingsSubsidiariesStateBankOfIndiaContext44 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsSubsidiariesStateBankOfIndiaContext44.getId())) {
                contextElements.add(partI_PartIBorrowingsSubsidiariesStateBankOfIndiaContext44);
                contextIdentifiers.add(partI_PartIBorrowingsSubsidiariesStateBankOfIndiaContext44.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsSubsidiariesStateBankOfIndiaValue = new MonetaryItemType();
            borrowingsSubsidiariesStateBankOfIndiaValue.setContextRef(partI_PartIBorrowingsSubsidiariesStateBankOfIndiaContext44);
            
            borrowingsSubsidiariesStateBankOfIndiaValue.setUnitRef(INR43);
            borrowingsSubsidiariesStateBankOfIndiaValue.setDecimals(CommonFns.getDecimals(field.getBorrowingsSubsidiariesStateBankOfIndia(), "1000"));
            borrowingsSubsidiariesStateBankOfIndiaValue.setValue(new BigDecimal(field.getBorrowingsSubsidiariesStateBankOfIndia()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsSubsidiariesStateBankOfIndiaElement = instancObjectFactory.createBorrowingsSubsidiariesStateBankOfIndia(borrowingsSubsidiariesStateBankOfIndiaValue);
            bodyElements.add(borrowingsSubsidiariesStateBankOfIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR45 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR45 == null){
                INR45 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR45.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR45.getMeasure().add(unitMeasureValue);
                unitElements.add(INR45);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BorrowingsOtherCommercialBanks
            
            
            Context partI_PartIBorrowingsOtherCommercialBanksContext46 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsOtherCommercialBanksContext46.getId())) {
                contextElements.add(partI_PartIBorrowingsOtherCommercialBanksContext46);
                contextIdentifiers.add(partI_PartIBorrowingsOtherCommercialBanksContext46.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsOtherCommercialBanksValue = new MonetaryItemType();
            borrowingsOtherCommercialBanksValue.setContextRef(partI_PartIBorrowingsOtherCommercialBanksContext46);
            
            borrowingsOtherCommercialBanksValue.setUnitRef(INR45);
            borrowingsOtherCommercialBanksValue.setDecimals(CommonFns.getDecimals(field.getBorrowingsOtherCommercialBanks(), "1000"));
            borrowingsOtherCommercialBanksValue.setValue(new BigDecimal(field.getBorrowingsOtherCommercialBanks()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsOtherCommercialBanksElement = instancObjectFactory.createBorrowingsOtherCommercialBanks(borrowingsOtherCommercialBanksValue);
            bodyElements.add(borrowingsOtherCommercialBanksElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR47 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR47 == null){
                INR47 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR47.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR47.getMeasure().add(unitMeasureValue);
                unitElements.add(INR47);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BorrowingsCooperativeBanks
            
            
            Context partI_PartIBorrowingsCooperativeBanksContext48 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsCooperativeBanksContext48.getId())) {
                contextElements.add(partI_PartIBorrowingsCooperativeBanksContext48);
                contextIdentifiers.add(partI_PartIBorrowingsCooperativeBanksContext48.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsCooperativeBanksValue = new MonetaryItemType();
            borrowingsCooperativeBanksValue.setContextRef(partI_PartIBorrowingsCooperativeBanksContext48);
            
            borrowingsCooperativeBanksValue.setUnitRef(INR47);
            borrowingsCooperativeBanksValue.setDecimals(CommonFns.getDecimals(field.getBorrowingsCooperativeBanks(), "1000"));
            borrowingsCooperativeBanksValue.setValue(new BigDecimal(field.getBorrowingsCooperativeBanks()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsCooperativeBanksElement = instancObjectFactory.createBorrowingsCooperativeBanks(borrowingsCooperativeBanksValue);
            bodyElements.add(borrowingsCooperativeBanksElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR49 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR49 == null){
                INR49 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR49.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR49.getMeasure().add(unitMeasureValue);
                unitElements.add(INR49);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BorrowingsBanksOutsideIndia
            
            
            Context partI_PartIBorrowingsBanksOutsideIndiaContext50 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsBanksOutsideIndiaContext50.getId())) {
                contextElements.add(partI_PartIBorrowingsBanksOutsideIndiaContext50);
                contextIdentifiers.add(partI_PartIBorrowingsBanksOutsideIndiaContext50.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsBanksOutsideIndiaValue = new MonetaryItemType();
            borrowingsBanksOutsideIndiaValue.setContextRef(partI_PartIBorrowingsBanksOutsideIndiaContext50);
            
            borrowingsBanksOutsideIndiaValue.setUnitRef(INR49);
            borrowingsBanksOutsideIndiaValue.setDecimals(CommonFns.getDecimals(field.getBorrowingsBanksOutsideIndia(), "1000"));
            borrowingsBanksOutsideIndiaValue.setValue(new BigDecimal(field.getBorrowingsBanksOutsideIndia()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsBanksOutsideIndiaElement = instancObjectFactory.createBorrowingsBanksOutsideIndia(borrowingsBanksOutsideIndiaValue);
            bodyElements.add(borrowingsBanksOutsideIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR51 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR51 == null){
                INR51 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR51.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR51.getMeasure().add(unitMeasureValue);
                unitElements.add(INR51);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BorrowingsFinancialInstitutionsInIndia
            
            
            Context partI_PartIBorrowingsFinancialInstitutionsInIndiaContext52 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsFinancialInstitutionsInIndiaContext52.getId())) {
                contextElements.add(partI_PartIBorrowingsFinancialInstitutionsInIndiaContext52);
                contextIdentifiers.add(partI_PartIBorrowingsFinancialInstitutionsInIndiaContext52.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsFinancialInstitutionsInIndiaValue = new MonetaryItemType();
            borrowingsFinancialInstitutionsInIndiaValue.setContextRef(partI_PartIBorrowingsFinancialInstitutionsInIndiaContext52);
            
            borrowingsFinancialInstitutionsInIndiaValue.setUnitRef(INR51);
            borrowingsFinancialInstitutionsInIndiaValue.setDecimals(CommonFns.getDecimals(field.getBorrowingsFinancialInstitutionsInIndia(), "1000"));
            borrowingsFinancialInstitutionsInIndiaValue.setValue(new BigDecimal(field.getBorrowingsFinancialInstitutionsInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsFinancialInstitutionsInIndiaElement = instancObjectFactory.createBorrowingsFinancialInstitutionsInIndia(borrowingsFinancialInstitutionsInIndiaValue);
            bodyElements.add(borrowingsFinancialInstitutionsInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR53 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR53 == null){
                INR53 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR53.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR53.getMeasure().add(unitMeasureValue);
                unitElements.add(INR53);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BorrowingsIndustrialDevelopmentBankOfIndia
            
            
            Context partI_PartIBorrowingsIndustrialDevelopmentBankOfIndiaContext54 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsIndustrialDevelopmentBankOfIndiaContext54.getId())) {
                contextElements.add(partI_PartIBorrowingsIndustrialDevelopmentBankOfIndiaContext54);
                contextIdentifiers.add(partI_PartIBorrowingsIndustrialDevelopmentBankOfIndiaContext54.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsIndustrialDevelopmentBankOfIndiaValue = new MonetaryItemType();
            borrowingsIndustrialDevelopmentBankOfIndiaValue.setContextRef(partI_PartIBorrowingsIndustrialDevelopmentBankOfIndiaContext54);
            
            borrowingsIndustrialDevelopmentBankOfIndiaValue.setUnitRef(INR53);
            borrowingsIndustrialDevelopmentBankOfIndiaValue.setDecimals(CommonFns.getDecimals(field.getBorrowingsIndustrialDevelopmentBankOfIndia(), "1000"));
            borrowingsIndustrialDevelopmentBankOfIndiaValue.setValue(new BigDecimal(field.getBorrowingsIndustrialDevelopmentBankOfIndia()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsIndustrialDevelopmentBankOfIndiaElement = instancObjectFactory.createBorrowingsIndustrialDevelopmentBankOfIndia(borrowingsIndustrialDevelopmentBankOfIndiaValue);
            bodyElements.add(borrowingsIndustrialDevelopmentBankOfIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR55 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR55 == null){
                INR55 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR55.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR55.getMeasure().add(unitMeasureValue);
                unitElements.add(INR55);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BorrowingsNationalBankForAgriculturalAndRuralDevelopment
            
            
            Context partI_PartIBorrowingsNationalBankForAgriculturalAndRuralDevelopmentContext56 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsNationalBankForAgriculturalAndRuralDevelopmentContext56.getId())) {
                contextElements.add(partI_PartIBorrowingsNationalBankForAgriculturalAndRuralDevelopmentContext56);
                contextIdentifiers.add(partI_PartIBorrowingsNationalBankForAgriculturalAndRuralDevelopmentContext56.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsNationalBankForAgriculturalAndRuralDevelopmentValue = new MonetaryItemType();
            borrowingsNationalBankForAgriculturalAndRuralDevelopmentValue.setContextRef(partI_PartIBorrowingsNationalBankForAgriculturalAndRuralDevelopmentContext56);
            
            borrowingsNationalBankForAgriculturalAndRuralDevelopmentValue.setUnitRef(INR55);
            borrowingsNationalBankForAgriculturalAndRuralDevelopmentValue.setDecimals(CommonFns.getDecimals(field.getBorrowingsNationalBankForAgriculturalAndRuralDevelopment(), "1000"));
            borrowingsNationalBankForAgriculturalAndRuralDevelopmentValue.setValue(new BigDecimal(field.getBorrowingsNationalBankForAgriculturalAndRuralDevelopment()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsNationalBankForAgriculturalAndRuralDevelopmentElement = instancObjectFactory.createBorrowingsNationalBankForAgriculturalAndRuralDevelopment(borrowingsNationalBankForAgriculturalAndRuralDevelopmentValue);
            bodyElements.add(borrowingsNationalBankForAgriculturalAndRuralDevelopmentElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR57 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR57 == null){
                INR57 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR57.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR57.getMeasure().add(unitMeasureValue);
                unitElements.add(INR57);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BorrowingsEximBankOfIndia
            
            
            Context partI_PartIBorrowingsEximBankOfIndiaContext58 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsEximBankOfIndiaContext58.getId())) {
                contextElements.add(partI_PartIBorrowingsEximBankOfIndiaContext58);
                contextIdentifiers.add(partI_PartIBorrowingsEximBankOfIndiaContext58.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsEximBankOfIndiaValue = new MonetaryItemType();
            borrowingsEximBankOfIndiaValue.setContextRef(partI_PartIBorrowingsEximBankOfIndiaContext58);
            
            borrowingsEximBankOfIndiaValue.setUnitRef(INR57);
            borrowingsEximBankOfIndiaValue.setDecimals(CommonFns.getDecimals(field.getBorrowingsEximBankOfIndia(), "1000"));
            borrowingsEximBankOfIndiaValue.setValue(new BigDecimal(field.getBorrowingsEximBankOfIndia()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsEximBankOfIndiaElement = instancObjectFactory.createBorrowingsEximBankOfIndia(borrowingsEximBankOfIndiaValue);
            bodyElements.add(borrowingsEximBankOfIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR59 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR59 == null){
                INR59 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR59.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR59.getMeasure().add(unitMeasureValue);
                unitElements.add(INR59);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BorrowingsOtherFinancialInstitutions
            
            
            Context partI_PartIBorrowingsOtherFinancialInstitutionsContext60 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsOtherFinancialInstitutionsContext60.getId())) {
                contextElements.add(partI_PartIBorrowingsOtherFinancialInstitutionsContext60);
                contextIdentifiers.add(partI_PartIBorrowingsOtherFinancialInstitutionsContext60.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsOtherFinancialInstitutionsValue = new MonetaryItemType();
            borrowingsOtherFinancialInstitutionsValue.setContextRef(partI_PartIBorrowingsOtherFinancialInstitutionsContext60);
            
            borrowingsOtherFinancialInstitutionsValue.setUnitRef(INR59);
            borrowingsOtherFinancialInstitutionsValue.setDecimals(CommonFns.getDecimals(field.getBorrowingsOtherFinancialInstitutions(), "1000"));
            borrowingsOtherFinancialInstitutionsValue.setValue(new BigDecimal(field.getBorrowingsOtherFinancialInstitutions()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsOtherFinancialInstitutionsElement = instancObjectFactory.createBorrowingsOtherFinancialInstitutions(borrowingsOtherFinancialInstitutionsValue);
            bodyElements.add(borrowingsOtherFinancialInstitutionsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR61 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR61 == null){
                INR61 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR61.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR61.getMeasure().add(unitMeasureValue);
                unitElements.add(INR61);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BorrowingsFinancialInstitutionsOutsideIndia
            
            
            Context partI_PartIBorrowingsFinancialInstitutionsOutsideIndiaContext62 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBorrowingsFinancialInstitutionsOutsideIndiaContext62.getId())) {
                contextElements.add(partI_PartIBorrowingsFinancialInstitutionsOutsideIndiaContext62);
                contextIdentifiers.add(partI_PartIBorrowingsFinancialInstitutionsOutsideIndiaContext62.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType borrowingsFinancialInstitutionsOutsideIndiaValue = new MonetaryItemType();
            borrowingsFinancialInstitutionsOutsideIndiaValue.setContextRef(partI_PartIBorrowingsFinancialInstitutionsOutsideIndiaContext62);
            
            borrowingsFinancialInstitutionsOutsideIndiaValue.setUnitRef(INR61);
            borrowingsFinancialInstitutionsOutsideIndiaValue.setDecimals(CommonFns.getDecimals(field.getBorrowingsFinancialInstitutionsOutsideIndia(), "1000"));
            borrowingsFinancialInstitutionsOutsideIndiaValue.setValue(new BigDecimal(field.getBorrowingsFinancialInstitutionsOutsideIndia()));
            
            
            
            JAXBElement<MonetaryItemType> borrowingsFinancialInstitutionsOutsideIndiaElement = instancObjectFactory.createBorrowingsFinancialInstitutionsOutsideIndia(borrowingsFinancialInstitutionsOutsideIndiaValue);
            bodyElements.add(borrowingsFinancialInstitutionsOutsideIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR63 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR63 == null){
                INR63 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR63.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR63.getMeasure().add(unitMeasureValue);
                unitElements.add(INR63);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - OtherLiabilitiesIncludingProvisions
            
            
            Context partI_PartIOtherLiabilitiesIncludingProvisionsContext64 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIOtherLiabilitiesIncludingProvisionsContext64.getId())) {
                contextElements.add(partI_PartIOtherLiabilitiesIncludingProvisionsContext64);
                contextIdentifiers.add(partI_PartIOtherLiabilitiesIncludingProvisionsContext64.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType otherLiabilitiesIncludingProvisionsValue = new MonetaryItemType();
            otherLiabilitiesIncludingProvisionsValue.setContextRef(partI_PartIOtherLiabilitiesIncludingProvisionsContext64);
            
            otherLiabilitiesIncludingProvisionsValue.setUnitRef(INR63);
            otherLiabilitiesIncludingProvisionsValue.setDecimals(CommonFns.getDecimals(field.getOtherLiabilitiesIncludingProvisions(), "1000"));
            otherLiabilitiesIncludingProvisionsValue.setValue(new BigDecimal(field.getOtherLiabilitiesIncludingProvisions()));
            
            
            
            JAXBElement<MonetaryItemType> otherLiabilitiesIncludingProvisionsElement = instancObjectFactory.createOtherLiabilitiesIncludingProvisions(otherLiabilitiesIncludingProvisionsValue);
            bodyElements.add(otherLiabilitiesIncludingProvisionsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR65 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR65 == null){
                INR65 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR65.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR65.getMeasure().add(unitMeasureValue);
                unitElements.add(INR65);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BillsPayableInIndia
            
            
            Context partI_PartIBillsPayableInIndiaContext66 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBillsPayableInIndiaContext66.getId())) {
                contextElements.add(partI_PartIBillsPayableInIndiaContext66);
                contextIdentifiers.add(partI_PartIBillsPayableInIndiaContext66.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType billsPayableInIndiaValue = new MonetaryItemType();
            billsPayableInIndiaValue.setContextRef(partI_PartIBillsPayableInIndiaContext66);
            
            billsPayableInIndiaValue.setUnitRef(INR65);
            billsPayableInIndiaValue.setDecimals(CommonFns.getDecimals(field.getBillsPayableInIndia(), "1000"));
            billsPayableInIndiaValue.setValue(new BigDecimal(field.getBillsPayableInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> billsPayableInIndiaElement = instancObjectFactory.createBillsPayableInIndia(billsPayableInIndiaValue);
            bodyElements.add(billsPayableInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR67 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR67 == null){
                INR67 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR67.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR67.getMeasure().add(unitMeasureValue);
                unitElements.add(INR67);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BillsPayableInIndiaDrawnIndianOffice
            
            
            Context partI_PartIBillsPayableInIndiaDrawnIndianOfficeContext68 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBillsPayableInIndiaDrawnIndianOfficeContext68.getId())) {
                contextElements.add(partI_PartIBillsPayableInIndiaDrawnIndianOfficeContext68);
                contextIdentifiers.add(partI_PartIBillsPayableInIndiaDrawnIndianOfficeContext68.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType billsPayableInIndiaDrawnIndianOfficeValue = new MonetaryItemType();
            billsPayableInIndiaDrawnIndianOfficeValue.setContextRef(partI_PartIBillsPayableInIndiaDrawnIndianOfficeContext68);
            
            billsPayableInIndiaDrawnIndianOfficeValue.setUnitRef(INR67);
            billsPayableInIndiaDrawnIndianOfficeValue.setDecimals(CommonFns.getDecimals(field.getBillsPayableInIndiaDrawnIndianOffice(), "1000"));
            billsPayableInIndiaDrawnIndianOfficeValue.setValue(new BigDecimal(field.getBillsPayableInIndiaDrawnIndianOffice()));
            
            
            
            JAXBElement<MonetaryItemType> billsPayableInIndiaDrawnIndianOfficeElement = instancObjectFactory.createBillsPayableInIndiaDrawnIndianOffice(billsPayableInIndiaDrawnIndianOfficeValue);
            bodyElements.add(billsPayableInIndiaDrawnIndianOfficeElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR69 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR69 == null){
                INR69 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR69.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR69.getMeasure().add(unitMeasureValue);
                unitElements.add(INR69);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BillsPayableInIndiaDrawnForeignOffice
            
            
            Context partI_PartIBillsPayableInIndiaDrawnForeignOfficeContext70 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBillsPayableInIndiaDrawnForeignOfficeContext70.getId())) {
                contextElements.add(partI_PartIBillsPayableInIndiaDrawnForeignOfficeContext70);
                contextIdentifiers.add(partI_PartIBillsPayableInIndiaDrawnForeignOfficeContext70.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType billsPayableInIndiaDrawnForeignOfficeValue = new MonetaryItemType();
            billsPayableInIndiaDrawnForeignOfficeValue.setContextRef(partI_PartIBillsPayableInIndiaDrawnForeignOfficeContext70);
            
            billsPayableInIndiaDrawnForeignOfficeValue.setUnitRef(INR69);
            billsPayableInIndiaDrawnForeignOfficeValue.setDecimals(CommonFns.getDecimals(field.getBillsPayableInIndiaDrawnForeignOffice(), "1000"));
            billsPayableInIndiaDrawnForeignOfficeValue.setValue(new BigDecimal(field.getBillsPayableInIndiaDrawnForeignOffice()));
            
            
            
            JAXBElement<MonetaryItemType> billsPayableInIndiaDrawnForeignOfficeElement = instancObjectFactory.createBillsPayableInIndiaDrawnForeignOffice(billsPayableInIndiaDrawnForeignOfficeValue);
            bodyElements.add(billsPayableInIndiaDrawnForeignOfficeElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR71 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR71 == null){
                INR71 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR71.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR71.getMeasure().add(unitMeasureValue);
                unitElements.add(INR71);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - BillsPayableOutsideIndia
            
            
            Context partI_PartIBillsPayableOutsideIndiaContext72 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIBillsPayableOutsideIndiaContext72.getId())) {
                contextElements.add(partI_PartIBillsPayableOutsideIndiaContext72);
                contextIdentifiers.add(partI_PartIBillsPayableOutsideIndiaContext72.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType billsPayableOutsideIndiaValue = new MonetaryItemType();
            billsPayableOutsideIndiaValue.setContextRef(partI_PartIBillsPayableOutsideIndiaContext72);
            
            billsPayableOutsideIndiaValue.setUnitRef(INR71);
            billsPayableOutsideIndiaValue.setDecimals(CommonFns.getDecimals(field.getBillsPayableOutsideIndia(), "1000"));
            billsPayableOutsideIndiaValue.setValue(new BigDecimal(field.getBillsPayableOutsideIndia()));
            
            
            
            JAXBElement<MonetaryItemType> billsPayableOutsideIndiaElement = instancObjectFactory.createBillsPayableOutsideIndia(billsPayableOutsideIndiaValue);
            bodyElements.add(billsPayableOutsideIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR73 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR73 == null){
                INR73 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR73.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR73.getMeasure().add(unitMeasureValue);
                unitElements.add(INR73);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - CallReceivedInAdvance
            
            
            Context partI_PartICallReceivedInAdvanceContext74 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartICallReceivedInAdvanceContext74.getId())) {
                contextElements.add(partI_PartICallReceivedInAdvanceContext74);
                contextIdentifiers.add(partI_PartICallReceivedInAdvanceContext74.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType callReceivedInAdvanceValue = new MonetaryItemType();
            callReceivedInAdvanceValue.setContextRef(partI_PartICallReceivedInAdvanceContext74);
            
            callReceivedInAdvanceValue.setUnitRef(INR73);
            callReceivedInAdvanceValue.setDecimals(CommonFns.getDecimals(field.getCallReceivedInAdvance(), "1000"));
            callReceivedInAdvanceValue.setValue(new BigDecimal(field.getCallReceivedInAdvance()));
            
            
            
            JAXBElement<MonetaryItemType> callReceivedInAdvanceElement = instancObjectFactory.createCallReceivedInAdvance(callReceivedInAdvanceValue);
            bodyElements.add(callReceivedInAdvanceElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR75 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR75 == null){
                INR75 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR75.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR75.getMeasure().add(unitMeasureValue);
                unitElements.add(INR75);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - MiscellaneousLiabilities
            
            
            Context partI_PartIMiscellaneousLiabilitiesContext76 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIMiscellaneousLiabilitiesContext76.getId())) {
                contextElements.add(partI_PartIMiscellaneousLiabilitiesContext76);
                contextIdentifiers.add(partI_PartIMiscellaneousLiabilitiesContext76.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType miscellaneousLiabilitiesValue = new MonetaryItemType();
            miscellaneousLiabilitiesValue.setContextRef(partI_PartIMiscellaneousLiabilitiesContext76);
            
            miscellaneousLiabilitiesValue.setUnitRef(INR75);
            miscellaneousLiabilitiesValue.setDecimals(CommonFns.getDecimals(field.getMiscellaneousLiabilities(), "1000"));
            miscellaneousLiabilitiesValue.setValue(new BigDecimal(field.getMiscellaneousLiabilities()));
            
            
            
            JAXBElement<MonetaryItemType> miscellaneousLiabilitiesElement = instancObjectFactory.createMiscellaneousLiabilities(miscellaneousLiabilitiesValue);
            bodyElements.add(miscellaneousLiabilitiesElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR77 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR77 == null){
                INR77 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR77.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR77.getMeasure().add(unitMeasureValue);
                unitElements.add(INR77);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - InterOfficeAdjustmentsLiabilities
            
            
            Context partI_PartIInterOfficeAdjustmentsLiabilitiesContext78 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIInterOfficeAdjustmentsLiabilitiesContext78.getId())) {
                contextElements.add(partI_PartIInterOfficeAdjustmentsLiabilitiesContext78);
                contextIdentifiers.add(partI_PartIInterOfficeAdjustmentsLiabilitiesContext78.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType interOfficeAdjustmentsLiabilitiesValue = new MonetaryItemType();
            interOfficeAdjustmentsLiabilitiesValue.setContextRef(partI_PartIInterOfficeAdjustmentsLiabilitiesContext78);
            
            interOfficeAdjustmentsLiabilitiesValue.setUnitRef(INR77);
            interOfficeAdjustmentsLiabilitiesValue.setDecimals(CommonFns.getDecimals(field.getInterOfficeAdjustmentsLiabilities(), "1000"));
            interOfficeAdjustmentsLiabilitiesValue.setValue(new BigDecimal(field.getInterOfficeAdjustmentsLiabilities()));
            
            
            
            JAXBElement<MonetaryItemType> interOfficeAdjustmentsLiabilitiesElement = instancObjectFactory.createInterOfficeAdjustmentsLiabilities(interOfficeAdjustmentsLiabilitiesValue);
            bodyElements.add(interOfficeAdjustmentsLiabilitiesElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR79 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR79 == null){
                INR79 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR79.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR79.getMeasure().add(unitMeasureValue);
                unitElements.add(INR79);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - InterOfficeAdjustmentsLiabilitiesWithOfficesInIndia
            
            
            Context partI_PartIInterOfficeAdjustmentsLiabilitiesWithOfficesInIndiaContext80 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIInterOfficeAdjustmentsLiabilitiesWithOfficesInIndiaContext80.getId())) {
                contextElements.add(partI_PartIInterOfficeAdjustmentsLiabilitiesWithOfficesInIndiaContext80);
                contextIdentifiers.add(partI_PartIInterOfficeAdjustmentsLiabilitiesWithOfficesInIndiaContext80.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType interOfficeAdjustmentsLiabilitiesWithOfficesInIndiaValue = new MonetaryItemType();
            interOfficeAdjustmentsLiabilitiesWithOfficesInIndiaValue.setContextRef(partI_PartIInterOfficeAdjustmentsLiabilitiesWithOfficesInIndiaContext80);
            
            interOfficeAdjustmentsLiabilitiesWithOfficesInIndiaValue.setUnitRef(INR79);
            interOfficeAdjustmentsLiabilitiesWithOfficesInIndiaValue.setDecimals(CommonFns.getDecimals(field.getInterOfficeAdjustmentsLiabilitiesWithOfficesInIndia(), "1000"));
            interOfficeAdjustmentsLiabilitiesWithOfficesInIndiaValue.setValue(new BigDecimal(field.getInterOfficeAdjustmentsLiabilitiesWithOfficesInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> interOfficeAdjustmentsLiabilitiesWithOfficesInIndiaElement = instancObjectFactory.createInterOfficeAdjustmentsLiabilitiesWithOfficesInIndia(interOfficeAdjustmentsLiabilitiesWithOfficesInIndiaValue);
            bodyElements.add(interOfficeAdjustmentsLiabilitiesWithOfficesInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR81 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR81 == null){
                INR81 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR81.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR81.getMeasure().add(unitMeasureValue);
                unitElements.add(INR81);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - InterOfficeAdjustmentLiabilitiesWithOfficesOutsideIndia
            
            
            Context partI_PartIInterOfficeAdjustmentLiabilitiesWithOfficesOutsideIndiaContext82 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIInterOfficeAdjustmentLiabilitiesWithOfficesOutsideIndiaContext82.getId())) {
                contextElements.add(partI_PartIInterOfficeAdjustmentLiabilitiesWithOfficesOutsideIndiaContext82);
                contextIdentifiers.add(partI_PartIInterOfficeAdjustmentLiabilitiesWithOfficesOutsideIndiaContext82.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType interOfficeAdjustmentLiabilitiesWithOfficesOutsideIndiaValue = new MonetaryItemType();
            interOfficeAdjustmentLiabilitiesWithOfficesOutsideIndiaValue.setContextRef(partI_PartIInterOfficeAdjustmentLiabilitiesWithOfficesOutsideIndiaContext82);
            
            interOfficeAdjustmentLiabilitiesWithOfficesOutsideIndiaValue.setUnitRef(INR81);
            interOfficeAdjustmentLiabilitiesWithOfficesOutsideIndiaValue.setDecimals(CommonFns.getDecimals(field.getInterOfficeAdjustmentLiabilitiesWithOfficesOutsideIndia(), "1000"));
            interOfficeAdjustmentLiabilitiesWithOfficesOutsideIndiaValue.setValue(new BigDecimal(field.getInterOfficeAdjustmentLiabilitiesWithOfficesOutsideIndia()));
            
            
            
            JAXBElement<MonetaryItemType> interOfficeAdjustmentLiabilitiesWithOfficesOutsideIndiaElement = instancObjectFactory.createInterOfficeAdjustmentLiabilitiesWithOfficesOutsideIndia(interOfficeAdjustmentLiabilitiesWithOfficesOutsideIndiaValue);
            bodyElements.add(interOfficeAdjustmentLiabilitiesWithOfficesOutsideIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR83 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR83 == null){
                INR83 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR83.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR83.getMeasure().add(unitMeasureValue);
                unitElements.add(INR83);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - DemandAndTimeLiabilitiesInIndia
            
            
            Context partI_PartIDemandAndTimeLiabilitiesInIndiaContext84 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIDemandAndTimeLiabilitiesInIndiaContext84.getId())) {
                contextElements.add(partI_PartIDemandAndTimeLiabilitiesInIndiaContext84);
                contextIdentifiers.add(partI_PartIDemandAndTimeLiabilitiesInIndiaContext84.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType demandAndTimeLiabilitiesInIndiaValue = new MonetaryItemType();
            demandAndTimeLiabilitiesInIndiaValue.setContextRef(partI_PartIDemandAndTimeLiabilitiesInIndiaContext84);
            
            demandAndTimeLiabilitiesInIndiaValue.setUnitRef(INR83);
            demandAndTimeLiabilitiesInIndiaValue.setDecimals(CommonFns.getDecimals(field.getDemandAndTimeLiabilitiesInIndia(), "1000"));
            demandAndTimeLiabilitiesInIndiaValue.setValue(new BigDecimal(field.getDemandAndTimeLiabilitiesInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> demandAndTimeLiabilitiesInIndiaElement = instancObjectFactory.createDemandAndTimeLiabilitiesInIndia(demandAndTimeLiabilitiesInIndiaValue);
            bodyElements.add(demandAndTimeLiabilitiesInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR85 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR85 == null){
                INR85 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR85.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR85.getMeasure().add(unitMeasureValue);
                unitElements.add(INR85);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - ProfitLossAccount
            
            
            Context partI_PartIProfitLossAccountContext86 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartIProfitLossAccountContext86.getId())) {
                contextElements.add(partI_PartIProfitLossAccountContext86);
                contextIdentifiers.add(partI_PartIProfitLossAccountContext86.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType profitLossAccountValue = new MonetaryItemType();
            profitLossAccountValue.setContextRef(partI_PartIProfitLossAccountContext86);
            
            profitLossAccountValue.setUnitRef(INR85);
            profitLossAccountValue.setDecimals(CommonFns.getDecimals(field.getProfitLossAccount(), "1000"));
            profitLossAccountValue.setValue(new BigDecimal(field.getProfitLossAccount()));
            
            
            
            JAXBElement<MonetaryItemType> profitLossAccountElement = instancObjectFactory.createProfitLossAccount(profitLossAccountValue);
            bodyElements.add(profitLossAccountElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR87 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR87 == null){
                INR87 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR87.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR87.getMeasure().add(unitMeasureValue);
                unitElements.add(INR87);
            }
            
            // start create element for report of PartI_PartI
            // create context for none explict member
            // TODO: remove once done
            // - LiabilitiesInIndia
            
            
            Context partI_PartILiabilitiesInIndiaContext88 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_PartILiabilitiesInIndiaContext88.getId())) {
                contextElements.add(partI_PartILiabilitiesInIndiaContext88);
                contextIdentifiers.add(partI_PartILiabilitiesInIndiaContext88.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType liabilitiesInIndiaValue = new MonetaryItemType();
            liabilitiesInIndiaValue.setContextRef(partI_PartILiabilitiesInIndiaContext88);
            
            liabilitiesInIndiaValue.setUnitRef(INR87);
            liabilitiesInIndiaValue.setDecimals(CommonFns.getDecimals(field.getLiabilitiesInIndia(), "1000"));
            liabilitiesInIndiaValue.setValue(new BigDecimal(field.getLiabilitiesInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> liabilitiesInIndiaElement = instancObjectFactory.createLiabilitiesInIndia(liabilitiesInIndiaValue);
            bodyElements.add(liabilitiesInIndiaElement);

            
            
            




            
            
            
            // end xbrl report element   


        }

            
            


            // with typemembers which requires multiple type member record
            

            
            // create variable for subclass PartI_Layout1 if any typeMembers then List or Single
            PartI_Layout1 partI_Layout1 = mainReportData.getPartI_Layout1();
            
            
            {
            // create xbrl report element
            PartI_Layout1 field = partI_Layout1;
            
            // create unit if not empty
            
                
            Unit INR89 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR89 == null){
                INR89 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR89.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR89.getMeasure().add(unitMeasureValue);
                unitElements.add(INR89);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - CashHand
            
            
            Context partI_Layout1CashHandContext90 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1CashHandContext90.getId())) {
                contextElements.add(partI_Layout1CashHandContext90);
                contextIdentifiers.add(partI_Layout1CashHandContext90.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType cashHandValue = new MonetaryItemType();
            cashHandValue.setContextRef(partI_Layout1CashHandContext90);
            
            cashHandValue.setUnitRef(INR89);
            cashHandValue.setDecimals(CommonFns.getDecimals(field.getCashHand(), "1000"));
            cashHandValue.setValue(new BigDecimal(field.getCashHand()));
            
            
            
            JAXBElement<MonetaryItemType> cashHandElement = instancObjectFactory.createCashHand(cashHandValue);
            bodyElements.add(cashHandElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR91 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR91 == null){
                INR91 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR91.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR91.getMeasure().add(unitMeasureValue);
                unitElements.add(INR91);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - BalancesWithReserveBankOfIndia
            
            
            Context partI_Layout1BalancesWithReserveBankOfIndiaContext92 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1BalancesWithReserveBankOfIndiaContext92.getId())) {
                contextElements.add(partI_Layout1BalancesWithReserveBankOfIndiaContext92);
                contextIdentifiers.add(partI_Layout1BalancesWithReserveBankOfIndiaContext92.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType balancesWithReserveBankOfIndiaValue = new MonetaryItemType();
            balancesWithReserveBankOfIndiaValue.setContextRef(partI_Layout1BalancesWithReserveBankOfIndiaContext92);
            
            balancesWithReserveBankOfIndiaValue.setUnitRef(INR91);
            balancesWithReserveBankOfIndiaValue.setDecimals(CommonFns.getDecimals(field.getBalancesWithReserveBankOfIndia(), "1000"));
            balancesWithReserveBankOfIndiaValue.setValue(new BigDecimal(field.getBalancesWithReserveBankOfIndia()));
            
            
            
            JAXBElement<MonetaryItemType> balancesWithReserveBankOfIndiaElement = instancObjectFactory.createBalancesWithReserveBankOfIndia(balancesWithReserveBankOfIndiaValue);
            bodyElements.add(balancesWithReserveBankOfIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR93 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR93 == null){
                INR93 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR93.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR93.getMeasure().add(unitMeasureValue);
                unitElements.add(INR93);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - BalancesWithOtherBanksInIndiaCurrentAccount
            
            
            Context partI_Layout1BalancesWithOtherBanksInIndiaCurrentAccountContext94 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1BalancesWithOtherBanksInIndiaCurrentAccountContext94.getId())) {
                contextElements.add(partI_Layout1BalancesWithOtherBanksInIndiaCurrentAccountContext94);
                contextIdentifiers.add(partI_Layout1BalancesWithOtherBanksInIndiaCurrentAccountContext94.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType balancesWithOtherBanksInIndiaCurrentAccountValue = new MonetaryItemType();
            balancesWithOtherBanksInIndiaCurrentAccountValue.setContextRef(partI_Layout1BalancesWithOtherBanksInIndiaCurrentAccountContext94);
            
            balancesWithOtherBanksInIndiaCurrentAccountValue.setUnitRef(INR93);
            balancesWithOtherBanksInIndiaCurrentAccountValue.setDecimals(CommonFns.getDecimals(field.getBalancesWithOtherBanksInIndiaCurrentAccount(), "1000"));
            balancesWithOtherBanksInIndiaCurrentAccountValue.setValue(new BigDecimal(field.getBalancesWithOtherBanksInIndiaCurrentAccount()));
            
            
            
            JAXBElement<MonetaryItemType> balancesWithOtherBanksInIndiaCurrentAccountElement = instancObjectFactory.createBalancesWithOtherBanksInIndiaCurrentAccount(balancesWithOtherBanksInIndiaCurrentAccountValue);
            bodyElements.add(balancesWithOtherBanksInIndiaCurrentAccountElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR95 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR95 == null){
                INR95 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR95.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR95.getMeasure().add(unitMeasureValue);
                unitElements.add(INR95);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - BalancesWithStateBankOfIndiaCurrentAccount
            
            
            Context partI_Layout1BalancesWithStateBankOfIndiaCurrentAccountContext96 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1BalancesWithStateBankOfIndiaCurrentAccountContext96.getId())) {
                contextElements.add(partI_Layout1BalancesWithStateBankOfIndiaCurrentAccountContext96);
                contextIdentifiers.add(partI_Layout1BalancesWithStateBankOfIndiaCurrentAccountContext96.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType balancesWithStateBankOfIndiaCurrentAccountValue = new MonetaryItemType();
            balancesWithStateBankOfIndiaCurrentAccountValue.setContextRef(partI_Layout1BalancesWithStateBankOfIndiaCurrentAccountContext96);
            
            balancesWithStateBankOfIndiaCurrentAccountValue.setUnitRef(INR95);
            balancesWithStateBankOfIndiaCurrentAccountValue.setDecimals(CommonFns.getDecimals(field.getBalancesWithStateBankOfIndiaCurrentAccount(), "1000"));
            balancesWithStateBankOfIndiaCurrentAccountValue.setValue(new BigDecimal(field.getBalancesWithStateBankOfIndiaCurrentAccount()));
            
            
            
            JAXBElement<MonetaryItemType> balancesWithStateBankOfIndiaCurrentAccountElement = instancObjectFactory.createBalancesWithStateBankOfIndiaCurrentAccount(balancesWithStateBankOfIndiaCurrentAccountValue);
            bodyElements.add(balancesWithStateBankOfIndiaCurrentAccountElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR97 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR97 == null){
                INR97 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR97.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR97.getMeasure().add(unitMeasureValue);
                unitElements.add(INR97);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - BalancesWithSubsidiariesStateBankOfIndiaCurrentAccount
            
            
            Context partI_Layout1BalancesWithSubsidiariesStateBankOfIndiaCurrentAccountContext98 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1BalancesWithSubsidiariesStateBankOfIndiaCurrentAccountContext98.getId())) {
                contextElements.add(partI_Layout1BalancesWithSubsidiariesStateBankOfIndiaCurrentAccountContext98);
                contextIdentifiers.add(partI_Layout1BalancesWithSubsidiariesStateBankOfIndiaCurrentAccountContext98.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType balancesWithSubsidiariesStateBankOfIndiaCurrentAccountValue = new MonetaryItemType();
            balancesWithSubsidiariesStateBankOfIndiaCurrentAccountValue.setContextRef(partI_Layout1BalancesWithSubsidiariesStateBankOfIndiaCurrentAccountContext98);
            
            balancesWithSubsidiariesStateBankOfIndiaCurrentAccountValue.setUnitRef(INR97);
            balancesWithSubsidiariesStateBankOfIndiaCurrentAccountValue.setDecimals(CommonFns.getDecimals(field.getBalancesWithSubsidiariesStateBankOfIndiaCurrentAccount(), "1000"));
            balancesWithSubsidiariesStateBankOfIndiaCurrentAccountValue.setValue(new BigDecimal(field.getBalancesWithSubsidiariesStateBankOfIndiaCurrentAccount()));
            
            
            
            JAXBElement<MonetaryItemType> balancesWithSubsidiariesStateBankOfIndiaCurrentAccountElement = instancObjectFactory.createBalancesWithSubsidiariesStateBankOfIndiaCurrentAccount(balancesWithSubsidiariesStateBankOfIndiaCurrentAccountValue);
            bodyElements.add(balancesWithSubsidiariesStateBankOfIndiaCurrentAccountElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR99 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR99 == null){
                INR99 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR99.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR99.getMeasure().add(unitMeasureValue);
                unitElements.add(INR99);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - BalancesWithOtherCommercialBanksCurrentAccount
            
            
            Context partI_Layout1BalancesWithOtherCommercialBanksCurrentAccountContext100 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1BalancesWithOtherCommercialBanksCurrentAccountContext100.getId())) {
                contextElements.add(partI_Layout1BalancesWithOtherCommercialBanksCurrentAccountContext100);
                contextIdentifiers.add(partI_Layout1BalancesWithOtherCommercialBanksCurrentAccountContext100.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType balancesWithOtherCommercialBanksCurrentAccountValue = new MonetaryItemType();
            balancesWithOtherCommercialBanksCurrentAccountValue.setContextRef(partI_Layout1BalancesWithOtherCommercialBanksCurrentAccountContext100);
            
            balancesWithOtherCommercialBanksCurrentAccountValue.setUnitRef(INR99);
            balancesWithOtherCommercialBanksCurrentAccountValue.setDecimals(CommonFns.getDecimals(field.getBalancesWithOtherCommercialBanksCurrentAccount(), "1000"));
            balancesWithOtherCommercialBanksCurrentAccountValue.setValue(new BigDecimal(field.getBalancesWithOtherCommercialBanksCurrentAccount()));
            
            
            
            JAXBElement<MonetaryItemType> balancesWithOtherCommercialBanksCurrentAccountElement = instancObjectFactory.createBalancesWithOtherCommercialBanksCurrentAccount(balancesWithOtherCommercialBanksCurrentAccountValue);
            bodyElements.add(balancesWithOtherCommercialBanksCurrentAccountElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR101 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR101 == null){
                INR101 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR101.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR101.getMeasure().add(unitMeasureValue);
                unitElements.add(INR101);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - BalancesWithCooperativeBanksCurrentAccount
            
            
            Context partI_Layout1BalancesWithCooperativeBanksCurrentAccountContext102 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1BalancesWithCooperativeBanksCurrentAccountContext102.getId())) {
                contextElements.add(partI_Layout1BalancesWithCooperativeBanksCurrentAccountContext102);
                contextIdentifiers.add(partI_Layout1BalancesWithCooperativeBanksCurrentAccountContext102.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType balancesWithCooperativeBanksCurrentAccountValue = new MonetaryItemType();
            balancesWithCooperativeBanksCurrentAccountValue.setContextRef(partI_Layout1BalancesWithCooperativeBanksCurrentAccountContext102);
            
            balancesWithCooperativeBanksCurrentAccountValue.setUnitRef(INR101);
            balancesWithCooperativeBanksCurrentAccountValue.setDecimals(CommonFns.getDecimals(field.getBalancesWithCooperativeBanksCurrentAccount(), "1000"));
            balancesWithCooperativeBanksCurrentAccountValue.setValue(new BigDecimal(field.getBalancesWithCooperativeBanksCurrentAccount()));
            
            
            
            JAXBElement<MonetaryItemType> balancesWithCooperativeBanksCurrentAccountElement = instancObjectFactory.createBalancesWithCooperativeBanksCurrentAccount(balancesWithCooperativeBanksCurrentAccountValue);
            bodyElements.add(balancesWithCooperativeBanksCurrentAccountElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR103 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR103 == null){
                INR103 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR103.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR103.getMeasure().add(unitMeasureValue);
                unitElements.add(INR103);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - MoneyAtCallShortNoticeInIndia
            
            
            Context partI_Layout1MoneyAtCallShortNoticeInIndiaContext104 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1MoneyAtCallShortNoticeInIndiaContext104.getId())) {
                contextElements.add(partI_Layout1MoneyAtCallShortNoticeInIndiaContext104);
                contextIdentifiers.add(partI_Layout1MoneyAtCallShortNoticeInIndiaContext104.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType moneyAtCallShortNoticeInIndiaValue = new MonetaryItemType();
            moneyAtCallShortNoticeInIndiaValue.setContextRef(partI_Layout1MoneyAtCallShortNoticeInIndiaContext104);
            
            moneyAtCallShortNoticeInIndiaValue.setUnitRef(INR103);
            moneyAtCallShortNoticeInIndiaValue.setDecimals(CommonFns.getDecimals(field.getMoneyAtCallShortNoticeInIndia(), "1000"));
            moneyAtCallShortNoticeInIndiaValue.setValue(new BigDecimal(field.getMoneyAtCallShortNoticeInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> moneyAtCallShortNoticeInIndiaElement = instancObjectFactory.createMoneyAtCallShortNoticeInIndia(moneyAtCallShortNoticeInIndiaValue);
            bodyElements.add(moneyAtCallShortNoticeInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR105 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR105 == null){
                INR105 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR105.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR105.getMeasure().add(unitMeasureValue);
                unitElements.add(INR105);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - MoneyAtCallShortNoticeInIndiaWithCommercialBanks
            
            
            Context partI_Layout1MoneyAtCallShortNoticeInIndiaWithCommercialBanksContext106 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1MoneyAtCallShortNoticeInIndiaWithCommercialBanksContext106.getId())) {
                contextElements.add(partI_Layout1MoneyAtCallShortNoticeInIndiaWithCommercialBanksContext106);
                contextIdentifiers.add(partI_Layout1MoneyAtCallShortNoticeInIndiaWithCommercialBanksContext106.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType moneyAtCallShortNoticeInIndiaWithCommercialBanksValue = new MonetaryItemType();
            moneyAtCallShortNoticeInIndiaWithCommercialBanksValue.setContextRef(partI_Layout1MoneyAtCallShortNoticeInIndiaWithCommercialBanksContext106);
            
            moneyAtCallShortNoticeInIndiaWithCommercialBanksValue.setUnitRef(INR105);
            moneyAtCallShortNoticeInIndiaWithCommercialBanksValue.setDecimals(CommonFns.getDecimals(field.getMoneyAtCallShortNoticeInIndiaWithCommercialBanks(), "1000"));
            moneyAtCallShortNoticeInIndiaWithCommercialBanksValue.setValue(new BigDecimal(field.getMoneyAtCallShortNoticeInIndiaWithCommercialBanks()));
            
            
            
            JAXBElement<MonetaryItemType> moneyAtCallShortNoticeInIndiaWithCommercialBanksElement = instancObjectFactory.createMoneyAtCallShortNoticeInIndiaWithCommercialBanks(moneyAtCallShortNoticeInIndiaWithCommercialBanksValue);
            bodyElements.add(moneyAtCallShortNoticeInIndiaWithCommercialBanksElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR107 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR107 == null){
                INR107 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR107.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR107.getMeasure().add(unitMeasureValue);
                unitElements.add(INR107);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - MoneyAtCallShortNoticeInIndiaWithCooperativeBanks
            
            
            Context partI_Layout1MoneyAtCallShortNoticeInIndiaWithCooperativeBanksContext108 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1MoneyAtCallShortNoticeInIndiaWithCooperativeBanksContext108.getId())) {
                contextElements.add(partI_Layout1MoneyAtCallShortNoticeInIndiaWithCooperativeBanksContext108);
                contextIdentifiers.add(partI_Layout1MoneyAtCallShortNoticeInIndiaWithCooperativeBanksContext108.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType moneyAtCallShortNoticeInIndiaWithCooperativeBanksValue = new MonetaryItemType();
            moneyAtCallShortNoticeInIndiaWithCooperativeBanksValue.setContextRef(partI_Layout1MoneyAtCallShortNoticeInIndiaWithCooperativeBanksContext108);
            
            moneyAtCallShortNoticeInIndiaWithCooperativeBanksValue.setUnitRef(INR107);
            moneyAtCallShortNoticeInIndiaWithCooperativeBanksValue.setDecimals(CommonFns.getDecimals(field.getMoneyAtCallShortNoticeInIndiaWithCooperativeBanks(), "1000"));
            moneyAtCallShortNoticeInIndiaWithCooperativeBanksValue.setValue(new BigDecimal(field.getMoneyAtCallShortNoticeInIndiaWithCooperativeBanks()));
            
            
            
            JAXBElement<MonetaryItemType> moneyAtCallShortNoticeInIndiaWithCooperativeBanksElement = instancObjectFactory.createMoneyAtCallShortNoticeInIndiaWithCooperativeBanks(moneyAtCallShortNoticeInIndiaWithCooperativeBanksValue);
            bodyElements.add(moneyAtCallShortNoticeInIndiaWithCooperativeBanksElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR109 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR109 == null){
                INR109 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR109.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR109.getMeasure().add(unitMeasureValue);
                unitElements.add(INR109);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - MoneyAtCallShortNoticeInIndiaOtherInstitutions
            
            
            Context partI_Layout1MoneyAtCallShortNoticeInIndiaOtherInstitutionsContext110 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1MoneyAtCallShortNoticeInIndiaOtherInstitutionsContext110.getId())) {
                contextElements.add(partI_Layout1MoneyAtCallShortNoticeInIndiaOtherInstitutionsContext110);
                contextIdentifiers.add(partI_Layout1MoneyAtCallShortNoticeInIndiaOtherInstitutionsContext110.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType moneyAtCallShortNoticeInIndiaOtherInstitutionsValue = new MonetaryItemType();
            moneyAtCallShortNoticeInIndiaOtherInstitutionsValue.setContextRef(partI_Layout1MoneyAtCallShortNoticeInIndiaOtherInstitutionsContext110);
            
            moneyAtCallShortNoticeInIndiaOtherInstitutionsValue.setUnitRef(INR109);
            moneyAtCallShortNoticeInIndiaOtherInstitutionsValue.setDecimals(CommonFns.getDecimals(field.getMoneyAtCallShortNoticeInIndiaOtherInstitutions(), "1000"));
            moneyAtCallShortNoticeInIndiaOtherInstitutionsValue.setValue(new BigDecimal(field.getMoneyAtCallShortNoticeInIndiaOtherInstitutions()));
            
            
            
            JAXBElement<MonetaryItemType> moneyAtCallShortNoticeInIndiaOtherInstitutionsElement = instancObjectFactory.createMoneyAtCallShortNoticeInIndiaOtherInstitutions(moneyAtCallShortNoticeInIndiaOtherInstitutionsValue);
            bodyElements.add(moneyAtCallShortNoticeInIndiaOtherInstitutionsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR111 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR111 == null){
                INR111 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR111.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR111.getMeasure().add(unitMeasureValue);
                unitElements.add(INR111);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - InvestmentsNet
            
            
            Context partI_Layout1InvestmentsNetContext112 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1InvestmentsNetContext112.getId())) {
                contextElements.add(partI_Layout1InvestmentsNetContext112);
                contextIdentifiers.add(partI_Layout1InvestmentsNetContext112.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType investmentsNetValue = new MonetaryItemType();
            investmentsNetValue.setContextRef(partI_Layout1InvestmentsNetContext112);
            
            investmentsNetValue.setUnitRef(INR111);
            investmentsNetValue.setDecimals(CommonFns.getDecimals(field.getInvestmentsNet(), "1000"));
            investmentsNetValue.setValue(new BigDecimal(field.getInvestmentsNet()));
            
            
            
            JAXBElement<MonetaryItemType> investmentsNetElement = instancObjectFactory.createInvestmentsNet(investmentsNetValue);
            bodyElements.add(investmentsNetElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR113 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR113 == null){
                INR113 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR113.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR113.getMeasure().add(unitMeasureValue);
                unitElements.add(INR113);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - InvestmentsTreasuryBillsInIndia
            
            
            Context partI_Layout1InvestmentsTreasuryBillsInIndiaContext114 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1InvestmentsTreasuryBillsInIndiaContext114.getId())) {
                contextElements.add(partI_Layout1InvestmentsTreasuryBillsInIndiaContext114);
                contextIdentifiers.add(partI_Layout1InvestmentsTreasuryBillsInIndiaContext114.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType investmentsTreasuryBillsInIndiaValue = new MonetaryItemType();
            investmentsTreasuryBillsInIndiaValue.setContextRef(partI_Layout1InvestmentsTreasuryBillsInIndiaContext114);
            
            investmentsTreasuryBillsInIndiaValue.setUnitRef(INR113);
            investmentsTreasuryBillsInIndiaValue.setDecimals(CommonFns.getDecimals(field.getInvestmentsTreasuryBillsInIndia(), "1000"));
            investmentsTreasuryBillsInIndiaValue.setValue(new BigDecimal(field.getInvestmentsTreasuryBillsInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> investmentsTreasuryBillsInIndiaElement = instancObjectFactory.createInvestmentsTreasuryBillsInIndia(investmentsTreasuryBillsInIndiaValue);
            bodyElements.add(investmentsTreasuryBillsInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR115 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR115 == null){
                INR115 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR115.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR115.getMeasure().add(unitMeasureValue);
                unitElements.add(INR115);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - InvestmentsOtherCentralGovernmentSecuritiesInIndia
            
            
            Context partI_Layout1InvestmentsOtherCentralGovernmentSecuritiesInIndiaContext116 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1InvestmentsOtherCentralGovernmentSecuritiesInIndiaContext116.getId())) {
                contextElements.add(partI_Layout1InvestmentsOtherCentralGovernmentSecuritiesInIndiaContext116);
                contextIdentifiers.add(partI_Layout1InvestmentsOtherCentralGovernmentSecuritiesInIndiaContext116.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType investmentsOtherCentralGovernmentSecuritiesInIndiaValue = new MonetaryItemType();
            investmentsOtherCentralGovernmentSecuritiesInIndiaValue.setContextRef(partI_Layout1InvestmentsOtherCentralGovernmentSecuritiesInIndiaContext116);
            
            investmentsOtherCentralGovernmentSecuritiesInIndiaValue.setUnitRef(INR115);
            investmentsOtherCentralGovernmentSecuritiesInIndiaValue.setDecimals(CommonFns.getDecimals(field.getInvestmentsOtherCentralGovernmentSecuritiesInIndia(), "1000"));
            investmentsOtherCentralGovernmentSecuritiesInIndiaValue.setValue(new BigDecimal(field.getInvestmentsOtherCentralGovernmentSecuritiesInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> investmentsOtherCentralGovernmentSecuritiesInIndiaElement = instancObjectFactory.createInvestmentsOtherCentralGovernmentSecuritiesInIndia(investmentsOtherCentralGovernmentSecuritiesInIndiaValue);
            bodyElements.add(investmentsOtherCentralGovernmentSecuritiesInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR117 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR117 == null){
                INR117 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR117.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR117.getMeasure().add(unitMeasureValue);
                unitElements.add(INR117);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - InvestmentsStateGovernmentSecuritiesInIndia
            
            
            Context partI_Layout1InvestmentsStateGovernmentSecuritiesInIndiaContext118 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1InvestmentsStateGovernmentSecuritiesInIndiaContext118.getId())) {
                contextElements.add(partI_Layout1InvestmentsStateGovernmentSecuritiesInIndiaContext118);
                contextIdentifiers.add(partI_Layout1InvestmentsStateGovernmentSecuritiesInIndiaContext118.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType investmentsStateGovernmentSecuritiesInIndiaValue = new MonetaryItemType();
            investmentsStateGovernmentSecuritiesInIndiaValue.setContextRef(partI_Layout1InvestmentsStateGovernmentSecuritiesInIndiaContext118);
            
            investmentsStateGovernmentSecuritiesInIndiaValue.setUnitRef(INR117);
            investmentsStateGovernmentSecuritiesInIndiaValue.setDecimals(CommonFns.getDecimals(field.getInvestmentsStateGovernmentSecuritiesInIndia(), "1000"));
            investmentsStateGovernmentSecuritiesInIndiaValue.setValue(new BigDecimal(field.getInvestmentsStateGovernmentSecuritiesInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> investmentsStateGovernmentSecuritiesInIndiaElement = instancObjectFactory.createInvestmentsStateGovernmentSecuritiesInIndia(investmentsStateGovernmentSecuritiesInIndiaValue);
            bodyElements.add(investmentsStateGovernmentSecuritiesInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR119 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR119 == null){
                INR119 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR119.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR119.getMeasure().add(unitMeasureValue);
                unitElements.add(INR119);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - InvestmentOtherApprovedSecuritiesInIndia
            
            
            Context partI_Layout1InvestmentOtherApprovedSecuritiesInIndiaContext120 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1InvestmentOtherApprovedSecuritiesInIndiaContext120.getId())) {
                contextElements.add(partI_Layout1InvestmentOtherApprovedSecuritiesInIndiaContext120);
                contextIdentifiers.add(partI_Layout1InvestmentOtherApprovedSecuritiesInIndiaContext120.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType investmentOtherApprovedSecuritiesInIndiaValue = new MonetaryItemType();
            investmentOtherApprovedSecuritiesInIndiaValue.setContextRef(partI_Layout1InvestmentOtherApprovedSecuritiesInIndiaContext120);
            
            investmentOtherApprovedSecuritiesInIndiaValue.setUnitRef(INR119);
            investmentOtherApprovedSecuritiesInIndiaValue.setDecimals(CommonFns.getDecimals(field.getInvestmentOtherApprovedSecuritiesInIndia(), "1000"));
            investmentOtherApprovedSecuritiesInIndiaValue.setValue(new BigDecimal(field.getInvestmentOtherApprovedSecuritiesInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> investmentOtherApprovedSecuritiesInIndiaElement = instancObjectFactory.createInvestmentOtherApprovedSecuritiesInIndia(investmentOtherApprovedSecuritiesInIndiaValue);
            bodyElements.add(investmentOtherApprovedSecuritiesInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR121 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR121 == null){
                INR121 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR121.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR121.getMeasure().add(unitMeasureValue);
                unitElements.add(INR121);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - InvestmentSharesDebenturesInIndia
            
            
            Context partI_Layout1InvestmentSharesDebenturesInIndiaContext122 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1InvestmentSharesDebenturesInIndiaContext122.getId())) {
                contextElements.add(partI_Layout1InvestmentSharesDebenturesInIndiaContext122);
                contextIdentifiers.add(partI_Layout1InvestmentSharesDebenturesInIndiaContext122.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType investmentSharesDebenturesInIndiaValue = new MonetaryItemType();
            investmentSharesDebenturesInIndiaValue.setContextRef(partI_Layout1InvestmentSharesDebenturesInIndiaContext122);
            
            investmentSharesDebenturesInIndiaValue.setUnitRef(INR121);
            investmentSharesDebenturesInIndiaValue.setDecimals(CommonFns.getDecimals(field.getInvestmentSharesDebenturesInIndia(), "1000"));
            investmentSharesDebenturesInIndiaValue.setValue(new BigDecimal(field.getInvestmentSharesDebenturesInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> investmentSharesDebenturesInIndiaElement = instancObjectFactory.createInvestmentSharesDebenturesInIndia(investmentSharesDebenturesInIndiaValue);
            bodyElements.add(investmentSharesDebenturesInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR123 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR123 == null){
                INR123 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR123.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR123.getMeasure().add(unitMeasureValue);
                unitElements.add(INR123);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - InvestmentFixedDepositsWithBanksInIndia
            
            
            Context partI_Layout1InvestmentFixedDepositsWithBanksInIndiaContext124 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1InvestmentFixedDepositsWithBanksInIndiaContext124.getId())) {
                contextElements.add(partI_Layout1InvestmentFixedDepositsWithBanksInIndiaContext124);
                contextIdentifiers.add(partI_Layout1InvestmentFixedDepositsWithBanksInIndiaContext124.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType investmentFixedDepositsWithBanksInIndiaValue = new MonetaryItemType();
            investmentFixedDepositsWithBanksInIndiaValue.setContextRef(partI_Layout1InvestmentFixedDepositsWithBanksInIndiaContext124);
            
            investmentFixedDepositsWithBanksInIndiaValue.setUnitRef(INR123);
            investmentFixedDepositsWithBanksInIndiaValue.setDecimals(CommonFns.getDecimals(field.getInvestmentFixedDepositsWithBanksInIndia(), "1000"));
            investmentFixedDepositsWithBanksInIndiaValue.setValue(new BigDecimal(field.getInvestmentFixedDepositsWithBanksInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> investmentFixedDepositsWithBanksInIndiaElement = instancObjectFactory.createInvestmentFixedDepositsWithBanksInIndia(investmentFixedDepositsWithBanksInIndiaValue);
            bodyElements.add(investmentFixedDepositsWithBanksInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR125 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR125 == null){
                INR125 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR125.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR125.getMeasure().add(unitMeasureValue);
                unitElements.add(INR125);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - OtherInvestmentsInIndia
            
            
            Context partI_Layout1OtherInvestmentsInIndiaContext126 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1OtherInvestmentsInIndiaContext126.getId())) {
                contextElements.add(partI_Layout1OtherInvestmentsInIndiaContext126);
                contextIdentifiers.add(partI_Layout1OtherInvestmentsInIndiaContext126.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType otherInvestmentsInIndiaValue = new MonetaryItemType();
            otherInvestmentsInIndiaValue.setContextRef(partI_Layout1OtherInvestmentsInIndiaContext126);
            
            otherInvestmentsInIndiaValue.setUnitRef(INR125);
            otherInvestmentsInIndiaValue.setDecimals(CommonFns.getDecimals(field.getOtherInvestmentsInIndia(), "1000"));
            otherInvestmentsInIndiaValue.setValue(new BigDecimal(field.getOtherInvestmentsInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> otherInvestmentsInIndiaElement = instancObjectFactory.createOtherInvestmentsInIndia(otherInvestmentsInIndiaValue);
            bodyElements.add(otherInvestmentsInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR127 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR127 == null){
                INR127 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR127.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR127.getMeasure().add(unitMeasureValue);
                unitElements.add(INR127);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - BillsPurchasedDiscounted
            
            
            Context partI_Layout1BillsPurchasedDiscountedContext128 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1BillsPurchasedDiscountedContext128.getId())) {
                contextElements.add(partI_Layout1BillsPurchasedDiscountedContext128);
                contextIdentifiers.add(partI_Layout1BillsPurchasedDiscountedContext128.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType billsPurchasedDiscountedValue = new MonetaryItemType();
            billsPurchasedDiscountedValue.setContextRef(partI_Layout1BillsPurchasedDiscountedContext128);
            
            billsPurchasedDiscountedValue.setUnitRef(INR127);
            billsPurchasedDiscountedValue.setDecimals(CommonFns.getDecimals(field.getBillsPurchasedDiscounted(), "1000"));
            billsPurchasedDiscountedValue.setValue(new BigDecimal(field.getBillsPurchasedDiscounted()));
            
            
            
            JAXBElement<MonetaryItemType> billsPurchasedDiscountedElement = instancObjectFactory.createBillsPurchasedDiscounted(billsPurchasedDiscountedValue);
            bodyElements.add(billsPurchasedDiscountedElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR129 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR129 == null){
                INR129 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR129.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR129.getMeasure().add(unitMeasureValue);
                unitElements.add(INR129);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - InlandBillsPurchasedDiscounted
            
            
            Context partI_Layout1InlandBillsPurchasedDiscountedContext130 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1InlandBillsPurchasedDiscountedContext130.getId())) {
                contextElements.add(partI_Layout1InlandBillsPurchasedDiscountedContext130);
                contextIdentifiers.add(partI_Layout1InlandBillsPurchasedDiscountedContext130.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType inlandBillsPurchasedDiscountedValue = new MonetaryItemType();
            inlandBillsPurchasedDiscountedValue.setContextRef(partI_Layout1InlandBillsPurchasedDiscountedContext130);
            
            inlandBillsPurchasedDiscountedValue.setUnitRef(INR129);
            inlandBillsPurchasedDiscountedValue.setDecimals(CommonFns.getDecimals(field.getInlandBillsPurchasedDiscounted(), "1000"));
            inlandBillsPurchasedDiscountedValue.setValue(new BigDecimal(field.getInlandBillsPurchasedDiscounted()));
            
            
            
            JAXBElement<MonetaryItemType> inlandBillsPurchasedDiscountedElement = instancObjectFactory.createInlandBillsPurchasedDiscounted(inlandBillsPurchasedDiscountedValue);
            bodyElements.add(inlandBillsPurchasedDiscountedElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR131 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR131 == null){
                INR131 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR131.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR131.getMeasure().add(unitMeasureValue);
                unitElements.add(INR131);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - ForeignBillsPurchasedDiscounted
            
            
            Context partI_Layout1ForeignBillsPurchasedDiscountedContext132 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1ForeignBillsPurchasedDiscountedContext132.getId())) {
                contextElements.add(partI_Layout1ForeignBillsPurchasedDiscountedContext132);
                contextIdentifiers.add(partI_Layout1ForeignBillsPurchasedDiscountedContext132.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType foreignBillsPurchasedDiscountedValue = new MonetaryItemType();
            foreignBillsPurchasedDiscountedValue.setContextRef(partI_Layout1ForeignBillsPurchasedDiscountedContext132);
            
            foreignBillsPurchasedDiscountedValue.setUnitRef(INR131);
            foreignBillsPurchasedDiscountedValue.setDecimals(CommonFns.getDecimals(field.getForeignBillsPurchasedDiscounted(), "1000"));
            foreignBillsPurchasedDiscountedValue.setValue(new BigDecimal(field.getForeignBillsPurchasedDiscounted()));
            
            
            
            JAXBElement<MonetaryItemType> foreignBillsPurchasedDiscountedElement = instancObjectFactory.createForeignBillsPurchasedDiscounted(foreignBillsPurchasedDiscountedValue);
            bodyElements.add(foreignBillsPurchasedDiscountedElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR133 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR133 == null){
                INR133 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR133.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR133.getMeasure().add(unitMeasureValue);
                unitElements.add(INR133);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - ExportBillsDrawnInIndia
            
            
            Context partI_Layout1ExportBillsDrawnInIndiaContext134 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1ExportBillsDrawnInIndiaContext134.getId())) {
                contextElements.add(partI_Layout1ExportBillsDrawnInIndiaContext134);
                contextIdentifiers.add(partI_Layout1ExportBillsDrawnInIndiaContext134.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType exportBillsDrawnInIndiaValue = new MonetaryItemType();
            exportBillsDrawnInIndiaValue.setContextRef(partI_Layout1ExportBillsDrawnInIndiaContext134);
            
            exportBillsDrawnInIndiaValue.setUnitRef(INR133);
            exportBillsDrawnInIndiaValue.setDecimals(CommonFns.getDecimals(field.getExportBillsDrawnInIndia(), "1000"));
            exportBillsDrawnInIndiaValue.setValue(new BigDecimal(field.getExportBillsDrawnInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> exportBillsDrawnInIndiaElement = instancObjectFactory.createExportBillsDrawnInIndia(exportBillsDrawnInIndiaValue);
            bodyElements.add(exportBillsDrawnInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR135 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR135 == null){
                INR135 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR135.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR135.getMeasure().add(unitMeasureValue);
                unitElements.add(INR135);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - ImportBillsDrawnPayableInIndia
            
            
            Context partI_Layout1ImportBillsDrawnPayableInIndiaContext136 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1ImportBillsDrawnPayableInIndiaContext136.getId())) {
                contextElements.add(partI_Layout1ImportBillsDrawnPayableInIndiaContext136);
                contextIdentifiers.add(partI_Layout1ImportBillsDrawnPayableInIndiaContext136.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType importBillsDrawnPayableInIndiaValue = new MonetaryItemType();
            importBillsDrawnPayableInIndiaValue.setContextRef(partI_Layout1ImportBillsDrawnPayableInIndiaContext136);
            
            importBillsDrawnPayableInIndiaValue.setUnitRef(INR135);
            importBillsDrawnPayableInIndiaValue.setDecimals(CommonFns.getDecimals(field.getImportBillsDrawnPayableInIndia(), "1000"));
            importBillsDrawnPayableInIndiaValue.setValue(new BigDecimal(field.getImportBillsDrawnPayableInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> importBillsDrawnPayableInIndiaElement = instancObjectFactory.createImportBillsDrawnPayableInIndia(importBillsDrawnPayableInIndiaValue);
            bodyElements.add(importBillsDrawnPayableInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR137 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR137 == null){
                INR137 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR137.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR137.getMeasure().add(unitMeasureValue);
                unitElements.add(INR137);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - OtherForeignBillsPurchasedDiscounted
            
            
            Context partI_Layout1OtherForeignBillsPurchasedDiscountedContext138 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1OtherForeignBillsPurchasedDiscountedContext138.getId())) {
                contextElements.add(partI_Layout1OtherForeignBillsPurchasedDiscountedContext138);
                contextIdentifiers.add(partI_Layout1OtherForeignBillsPurchasedDiscountedContext138.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType otherForeignBillsPurchasedDiscountedValue = new MonetaryItemType();
            otherForeignBillsPurchasedDiscountedValue.setContextRef(partI_Layout1OtherForeignBillsPurchasedDiscountedContext138);
            
            otherForeignBillsPurchasedDiscountedValue.setUnitRef(INR137);
            otherForeignBillsPurchasedDiscountedValue.setDecimals(CommonFns.getDecimals(field.getOtherForeignBillsPurchasedDiscounted(), "1000"));
            otherForeignBillsPurchasedDiscountedValue.setValue(new BigDecimal(field.getOtherForeignBillsPurchasedDiscounted()));
            
            
            
            JAXBElement<MonetaryItemType> otherForeignBillsPurchasedDiscountedElement = instancObjectFactory.createOtherForeignBillsPurchasedDiscounted(otherForeignBillsPurchasedDiscountedValue);
            bodyElements.add(otherForeignBillsPurchasedDiscountedElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR139 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR139 == null){
                INR139 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR139.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR139.getMeasure().add(unitMeasureValue);
                unitElements.add(INR139);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - OtherForeignBillsPurchasedDiscountedPayableInIndia
            
            
            Context partI_Layout1OtherForeignBillsPurchasedDiscountedPayableInIndiaContext140 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1OtherForeignBillsPurchasedDiscountedPayableInIndiaContext140.getId())) {
                contextElements.add(partI_Layout1OtherForeignBillsPurchasedDiscountedPayableInIndiaContext140);
                contextIdentifiers.add(partI_Layout1OtherForeignBillsPurchasedDiscountedPayableInIndiaContext140.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType otherForeignBillsPurchasedDiscountedPayableInIndiaValue = new MonetaryItemType();
            otherForeignBillsPurchasedDiscountedPayableInIndiaValue.setContextRef(partI_Layout1OtherForeignBillsPurchasedDiscountedPayableInIndiaContext140);
            
            otherForeignBillsPurchasedDiscountedPayableInIndiaValue.setUnitRef(INR139);
            otherForeignBillsPurchasedDiscountedPayableInIndiaValue.setDecimals(CommonFns.getDecimals(field.getOtherForeignBillsPurchasedDiscountedPayableInIndia(), "1000"));
            otherForeignBillsPurchasedDiscountedPayableInIndiaValue.setValue(new BigDecimal(field.getOtherForeignBillsPurchasedDiscountedPayableInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> otherForeignBillsPurchasedDiscountedPayableInIndiaElement = instancObjectFactory.createOtherForeignBillsPurchasedDiscountedPayableInIndia(otherForeignBillsPurchasedDiscountedPayableInIndiaValue);
            bodyElements.add(otherForeignBillsPurchasedDiscountedPayableInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR141 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR141 == null){
                INR141 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR141.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR141.getMeasure().add(unitMeasureValue);
                unitElements.add(INR141);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - OtherForeignBillsPurchasedDiscountedPayableOutsideIndia
            
            
            Context partI_Layout1OtherForeignBillsPurchasedDiscountedPayableOutsideIndiaContext142 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1OtherForeignBillsPurchasedDiscountedPayableOutsideIndiaContext142.getId())) {
                contextElements.add(partI_Layout1OtherForeignBillsPurchasedDiscountedPayableOutsideIndiaContext142);
                contextIdentifiers.add(partI_Layout1OtherForeignBillsPurchasedDiscountedPayableOutsideIndiaContext142.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType otherForeignBillsPurchasedDiscountedPayableOutsideIndiaValue = new MonetaryItemType();
            otherForeignBillsPurchasedDiscountedPayableOutsideIndiaValue.setContextRef(partI_Layout1OtherForeignBillsPurchasedDiscountedPayableOutsideIndiaContext142);
            
            otherForeignBillsPurchasedDiscountedPayableOutsideIndiaValue.setUnitRef(INR141);
            otherForeignBillsPurchasedDiscountedPayableOutsideIndiaValue.setDecimals(CommonFns.getDecimals(field.getOtherForeignBillsPurchasedDiscountedPayableOutsideIndia(), "1000"));
            otherForeignBillsPurchasedDiscountedPayableOutsideIndiaValue.setValue(new BigDecimal(field.getOtherForeignBillsPurchasedDiscountedPayableOutsideIndia()));
            
            
            
            JAXBElement<MonetaryItemType> otherForeignBillsPurchasedDiscountedPayableOutsideIndiaElement = instancObjectFactory.createOtherForeignBillsPurchasedDiscountedPayableOutsideIndia(otherForeignBillsPurchasedDiscountedPayableOutsideIndiaValue);
            bodyElements.add(otherForeignBillsPurchasedDiscountedPayableOutsideIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR143 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR143 == null){
                INR143 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR143.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR143.getMeasure().add(unitMeasureValue);
                unitElements.add(INR143);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - LoansAdvances
            
            
            Context partI_Layout1LoansAdvancesContext144 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1LoansAdvancesContext144.getId())) {
                contextElements.add(partI_Layout1LoansAdvancesContext144);
                contextIdentifiers.add(partI_Layout1LoansAdvancesContext144.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType loansAdvancesValue = new MonetaryItemType();
            loansAdvancesValue.setContextRef(partI_Layout1LoansAdvancesContext144);
            
            loansAdvancesValue.setUnitRef(INR143);
            loansAdvancesValue.setDecimals(CommonFns.getDecimals(field.getLoansAdvances(), "1000"));
            loansAdvancesValue.setValue(new BigDecimal(field.getLoansAdvances()));
            
            
            
            JAXBElement<MonetaryItemType> loansAdvancesElement = instancObjectFactory.createLoansAdvances(loansAdvancesValue);
            bodyElements.add(loansAdvancesElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR145 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR145 == null){
                INR145 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR145.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR145.getMeasure().add(unitMeasureValue);
                unitElements.add(INR145);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - LoansAdvancesDueOthers
            
            
            Context partI_Layout1LoansAdvancesDueOthersContext146 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1LoansAdvancesDueOthersContext146.getId())) {
                contextElements.add(partI_Layout1LoansAdvancesDueOthersContext146);
                contextIdentifiers.add(partI_Layout1LoansAdvancesDueOthersContext146.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType loansAdvancesDueOthersValue = new MonetaryItemType();
            loansAdvancesDueOthersValue.setContextRef(partI_Layout1LoansAdvancesDueOthersContext146);
            
            loansAdvancesDueOthersValue.setUnitRef(INR145);
            loansAdvancesDueOthersValue.setDecimals(CommonFns.getDecimals(field.getLoansAdvancesDueOthers(), "1000"));
            loansAdvancesDueOthersValue.setValue(new BigDecimal(field.getLoansAdvancesDueOthers()));
            
            
            
            JAXBElement<MonetaryItemType> loansAdvancesDueOthersElement = instancObjectFactory.createLoansAdvancesDueOthers(loansAdvancesDueOthersValue);
            bodyElements.add(loansAdvancesDueOthersElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR147 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR147 == null){
                INR147 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR147.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR147.getMeasure().add(unitMeasureValue);
                unitElements.add(INR147);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - LoansAdvancesDueBanks
            
            
            Context partI_Layout1LoansAdvancesDueBanksContext148 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1LoansAdvancesDueBanksContext148.getId())) {
                contextElements.add(partI_Layout1LoansAdvancesDueBanksContext148);
                contextIdentifiers.add(partI_Layout1LoansAdvancesDueBanksContext148.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType loansAdvancesDueBanksValue = new MonetaryItemType();
            loansAdvancesDueBanksValue.setContextRef(partI_Layout1LoansAdvancesDueBanksContext148);
            
            loansAdvancesDueBanksValue.setUnitRef(INR147);
            loansAdvancesDueBanksValue.setDecimals(CommonFns.getDecimals(field.getLoansAdvancesDueBanks(), "1000"));
            loansAdvancesDueBanksValue.setValue(new BigDecimal(field.getLoansAdvancesDueBanks()));
            
            
            
            JAXBElement<MonetaryItemType> loansAdvancesDueBanksElement = instancObjectFactory.createLoansAdvancesDueBanks(loansAdvancesDueBanksValue);
            bodyElements.add(loansAdvancesDueBanksElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR149 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR149 == null){
                INR149 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR149.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR149.getMeasure().add(unitMeasureValue);
                unitElements.add(INR149);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - LoansAdvancesDueCooperativeBanksInIndia
            
            
            Context partI_Layout1LoansAdvancesDueCooperativeBanksInIndiaContext150 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1LoansAdvancesDueCooperativeBanksInIndiaContext150.getId())) {
                contextElements.add(partI_Layout1LoansAdvancesDueCooperativeBanksInIndiaContext150);
                contextIdentifiers.add(partI_Layout1LoansAdvancesDueCooperativeBanksInIndiaContext150.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType loansAdvancesDueCooperativeBanksInIndiaValue = new MonetaryItemType();
            loansAdvancesDueCooperativeBanksInIndiaValue.setContextRef(partI_Layout1LoansAdvancesDueCooperativeBanksInIndiaContext150);
            
            loansAdvancesDueCooperativeBanksInIndiaValue.setUnitRef(INR149);
            loansAdvancesDueCooperativeBanksInIndiaValue.setDecimals(CommonFns.getDecimals(field.getLoansAdvancesDueCooperativeBanksInIndia(), "1000"));
            loansAdvancesDueCooperativeBanksInIndiaValue.setValue(new BigDecimal(field.getLoansAdvancesDueCooperativeBanksInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> loansAdvancesDueCooperativeBanksInIndiaElement = instancObjectFactory.createLoansAdvancesDueCooperativeBanksInIndia(loansAdvancesDueCooperativeBanksInIndiaValue);
            bodyElements.add(loansAdvancesDueCooperativeBanksInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR151 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR151 == null){
                INR151 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR151.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR151.getMeasure().add(unitMeasureValue);
                unitElements.add(INR151);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - LoansAdvancesDueCommercialBanksInIndia
            
            
            Context partI_Layout1LoansAdvancesDueCommercialBanksInIndiaContext152 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1LoansAdvancesDueCommercialBanksInIndiaContext152.getId())) {
                contextElements.add(partI_Layout1LoansAdvancesDueCommercialBanksInIndiaContext152);
                contextIdentifiers.add(partI_Layout1LoansAdvancesDueCommercialBanksInIndiaContext152.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType loansAdvancesDueCommercialBanksInIndiaValue = new MonetaryItemType();
            loansAdvancesDueCommercialBanksInIndiaValue.setContextRef(partI_Layout1LoansAdvancesDueCommercialBanksInIndiaContext152);
            
            loansAdvancesDueCommercialBanksInIndiaValue.setUnitRef(INR151);
            loansAdvancesDueCommercialBanksInIndiaValue.setDecimals(CommonFns.getDecimals(field.getLoansAdvancesDueCommercialBanksInIndia(), "1000"));
            loansAdvancesDueCommercialBanksInIndiaValue.setValue(new BigDecimal(field.getLoansAdvancesDueCommercialBanksInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> loansAdvancesDueCommercialBanksInIndiaElement = instancObjectFactory.createLoansAdvancesDueCommercialBanksInIndia(loansAdvancesDueCommercialBanksInIndiaValue);
            bodyElements.add(loansAdvancesDueCommercialBanksInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR153 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR153 == null){
                INR153 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR153.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR153.getMeasure().add(unitMeasureValue);
                unitElements.add(INR153);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - LoansAdvancesDueBanksOutsideIndia
            
            
            Context partI_Layout1LoansAdvancesDueBanksOutsideIndiaContext154 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1LoansAdvancesDueBanksOutsideIndiaContext154.getId())) {
                contextElements.add(partI_Layout1LoansAdvancesDueBanksOutsideIndiaContext154);
                contextIdentifiers.add(partI_Layout1LoansAdvancesDueBanksOutsideIndiaContext154.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType loansAdvancesDueBanksOutsideIndiaValue = new MonetaryItemType();
            loansAdvancesDueBanksOutsideIndiaValue.setContextRef(partI_Layout1LoansAdvancesDueBanksOutsideIndiaContext154);
            
            loansAdvancesDueBanksOutsideIndiaValue.setUnitRef(INR153);
            loansAdvancesDueBanksOutsideIndiaValue.setDecimals(CommonFns.getDecimals(field.getLoansAdvancesDueBanksOutsideIndia(), "1000"));
            loansAdvancesDueBanksOutsideIndiaValue.setValue(new BigDecimal(field.getLoansAdvancesDueBanksOutsideIndia()));
            
            
            
            JAXBElement<MonetaryItemType> loansAdvancesDueBanksOutsideIndiaElement = instancObjectFactory.createLoansAdvancesDueBanksOutsideIndia(loansAdvancesDueBanksOutsideIndiaValue);
            bodyElements.add(loansAdvancesDueBanksOutsideIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR155 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR155 == null){
                INR155 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR155.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR155.getMeasure().add(unitMeasureValue);
                unitElements.add(INR155);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - FixedAssets
            
            
            Context partI_Layout1FixedAssetsContext156 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1FixedAssetsContext156.getId())) {
                contextElements.add(partI_Layout1FixedAssetsContext156);
                contextIdentifiers.add(partI_Layout1FixedAssetsContext156.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType fixedAssetsValue = new MonetaryItemType();
            fixedAssetsValue.setContextRef(partI_Layout1FixedAssetsContext156);
            
            fixedAssetsValue.setUnitRef(INR155);
            fixedAssetsValue.setDecimals(CommonFns.getDecimals(field.getFixedAssets(), "1000"));
            fixedAssetsValue.setValue(new BigDecimal(field.getFixedAssets()));
            
            
            
            JAXBElement<MonetaryItemType> fixedAssetsElement = instancObjectFactory.createFixedAssets(fixedAssetsValue);
            bodyElements.add(fixedAssetsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR157 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR157 == null){
                INR157 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR157.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR157.getMeasure().add(unitMeasureValue);
                unitElements.add(INR157);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - InterOfficeAdjustmentsAssets
            
            
            Context partI_Layout1InterOfficeAdjustmentsAssetsContext158 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1InterOfficeAdjustmentsAssetsContext158.getId())) {
                contextElements.add(partI_Layout1InterOfficeAdjustmentsAssetsContext158);
                contextIdentifiers.add(partI_Layout1InterOfficeAdjustmentsAssetsContext158.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType interOfficeAdjustmentsAssetsValue = new MonetaryItemType();
            interOfficeAdjustmentsAssetsValue.setContextRef(partI_Layout1InterOfficeAdjustmentsAssetsContext158);
            
            interOfficeAdjustmentsAssetsValue.setUnitRef(INR157);
            interOfficeAdjustmentsAssetsValue.setDecimals(CommonFns.getDecimals(field.getInterOfficeAdjustmentsAssets(), "1000"));
            interOfficeAdjustmentsAssetsValue.setValue(new BigDecimal(field.getInterOfficeAdjustmentsAssets()));
            
            
            
            JAXBElement<MonetaryItemType> interOfficeAdjustmentsAssetsElement = instancObjectFactory.createInterOfficeAdjustmentsAssets(interOfficeAdjustmentsAssetsValue);
            bodyElements.add(interOfficeAdjustmentsAssetsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR159 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR159 == null){
                INR159 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR159.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR159.getMeasure().add(unitMeasureValue);
                unitElements.add(INR159);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - InterOfficeAdjustmentsAssetsWithOfficesInIndia
            
            
            Context partI_Layout1InterOfficeAdjustmentsAssetsWithOfficesInIndiaContext160 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1InterOfficeAdjustmentsAssetsWithOfficesInIndiaContext160.getId())) {
                contextElements.add(partI_Layout1InterOfficeAdjustmentsAssetsWithOfficesInIndiaContext160);
                contextIdentifiers.add(partI_Layout1InterOfficeAdjustmentsAssetsWithOfficesInIndiaContext160.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType interOfficeAdjustmentsAssetsWithOfficesInIndiaValue = new MonetaryItemType();
            interOfficeAdjustmentsAssetsWithOfficesInIndiaValue.setContextRef(partI_Layout1InterOfficeAdjustmentsAssetsWithOfficesInIndiaContext160);
            
            interOfficeAdjustmentsAssetsWithOfficesInIndiaValue.setUnitRef(INR159);
            interOfficeAdjustmentsAssetsWithOfficesInIndiaValue.setDecimals(CommonFns.getDecimals(field.getInterOfficeAdjustmentsAssetsWithOfficesInIndia(), "1000"));
            interOfficeAdjustmentsAssetsWithOfficesInIndiaValue.setValue(new BigDecimal(field.getInterOfficeAdjustmentsAssetsWithOfficesInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> interOfficeAdjustmentsAssetsWithOfficesInIndiaElement = instancObjectFactory.createInterOfficeAdjustmentsAssetsWithOfficesInIndia(interOfficeAdjustmentsAssetsWithOfficesInIndiaValue);
            bodyElements.add(interOfficeAdjustmentsAssetsWithOfficesInIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR161 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR161 == null){
                INR161 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR161.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR161.getMeasure().add(unitMeasureValue);
                unitElements.add(INR161);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - InterOfficeAdjustmentsAssetsWithOfficesOutsideIndia
            
            
            Context partI_Layout1InterOfficeAdjustmentsAssetsWithOfficesOutsideIndiaContext162 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1InterOfficeAdjustmentsAssetsWithOfficesOutsideIndiaContext162.getId())) {
                contextElements.add(partI_Layout1InterOfficeAdjustmentsAssetsWithOfficesOutsideIndiaContext162);
                contextIdentifiers.add(partI_Layout1InterOfficeAdjustmentsAssetsWithOfficesOutsideIndiaContext162.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType interOfficeAdjustmentsAssetsWithOfficesOutsideIndiaValue = new MonetaryItemType();
            interOfficeAdjustmentsAssetsWithOfficesOutsideIndiaValue.setContextRef(partI_Layout1InterOfficeAdjustmentsAssetsWithOfficesOutsideIndiaContext162);
            
            interOfficeAdjustmentsAssetsWithOfficesOutsideIndiaValue.setUnitRef(INR161);
            interOfficeAdjustmentsAssetsWithOfficesOutsideIndiaValue.setDecimals(CommonFns.getDecimals(field.getInterOfficeAdjustmentsAssetsWithOfficesOutsideIndia(), "1000"));
            interOfficeAdjustmentsAssetsWithOfficesOutsideIndiaValue.setValue(new BigDecimal(field.getInterOfficeAdjustmentsAssetsWithOfficesOutsideIndia()));
            
            
            
            JAXBElement<MonetaryItemType> interOfficeAdjustmentsAssetsWithOfficesOutsideIndiaElement = instancObjectFactory.createInterOfficeAdjustmentsAssetsWithOfficesOutsideIndia(interOfficeAdjustmentsAssetsWithOfficesOutsideIndiaValue);
            bodyElements.add(interOfficeAdjustmentsAssetsWithOfficesOutsideIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR163 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR163 == null){
                INR163 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR163.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR163.getMeasure().add(unitMeasureValue);
                unitElements.add(INR163);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - CapitalisedExpenses
            
            
            Context partI_Layout1CapitalisedExpensesContext164 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1CapitalisedExpensesContext164.getId())) {
                contextElements.add(partI_Layout1CapitalisedExpensesContext164);
                contextIdentifiers.add(partI_Layout1CapitalisedExpensesContext164.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType capitalisedExpensesValue = new MonetaryItemType();
            capitalisedExpensesValue.setContextRef(partI_Layout1CapitalisedExpensesContext164);
            
            capitalisedExpensesValue.setUnitRef(INR163);
            capitalisedExpensesValue.setDecimals(CommonFns.getDecimals(field.getCapitalisedExpenses(), "1000"));
            capitalisedExpensesValue.setValue(new BigDecimal(field.getCapitalisedExpenses()));
            
            
            
            JAXBElement<MonetaryItemType> capitalisedExpensesElement = instancObjectFactory.createCapitalisedExpenses(capitalisedExpensesValue);
            bodyElements.add(capitalisedExpensesElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR165 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR165 == null){
                INR165 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR165.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR165.getMeasure().add(unitMeasureValue);
                unitElements.add(INR165);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - NonBankingAssetsAcquiredForClaims
            
            
            Context partI_Layout1NonBankingAssetsAcquiredForClaimsContext166 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1NonBankingAssetsAcquiredForClaimsContext166.getId())) {
                contextElements.add(partI_Layout1NonBankingAssetsAcquiredForClaimsContext166);
                contextIdentifiers.add(partI_Layout1NonBankingAssetsAcquiredForClaimsContext166.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType nonBankingAssetsAcquiredForClaimsValue = new MonetaryItemType();
            nonBankingAssetsAcquiredForClaimsValue.setContextRef(partI_Layout1NonBankingAssetsAcquiredForClaimsContext166);
            
            nonBankingAssetsAcquiredForClaimsValue.setUnitRef(INR165);
            nonBankingAssetsAcquiredForClaimsValue.setDecimals(CommonFns.getDecimals(field.getNonBankingAssetsAcquiredForClaims(), "1000"));
            nonBankingAssetsAcquiredForClaimsValue.setValue(new BigDecimal(field.getNonBankingAssetsAcquiredForClaims()));
            
            
            
            JAXBElement<MonetaryItemType> nonBankingAssetsAcquiredForClaimsElement = instancObjectFactory.createNonBankingAssetsAcquiredForClaims(nonBankingAssetsAcquiredForClaimsValue);
            bodyElements.add(nonBankingAssetsAcquiredForClaimsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR167 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR167 == null){
                INR167 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR167.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR167.getMeasure().add(unitMeasureValue);
                unitElements.add(INR167);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - OtherTangibleAssets
            
            
            Context partI_Layout1OtherTangibleAssetsContext168 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1OtherTangibleAssetsContext168.getId())) {
                contextElements.add(partI_Layout1OtherTangibleAssetsContext168);
                contextIdentifiers.add(partI_Layout1OtherTangibleAssetsContext168.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType otherTangibleAssetsValue = new MonetaryItemType();
            otherTangibleAssetsValue.setContextRef(partI_Layout1OtherTangibleAssetsContext168);
            
            otherTangibleAssetsValue.setUnitRef(INR167);
            otherTangibleAssetsValue.setDecimals(CommonFns.getDecimals(field.getOtherTangibleAssets(), "1000"));
            otherTangibleAssetsValue.setValue(new BigDecimal(field.getOtherTangibleAssets()));
            
            
            
            JAXBElement<MonetaryItemType> otherTangibleAssetsElement = instancObjectFactory.createOtherTangibleAssets(otherTangibleAssetsValue);
            bodyElements.add(otherTangibleAssetsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR169 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR169 == null){
                INR169 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR169.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR169.getMeasure().add(unitMeasureValue);
                unitElements.add(INR169);
            }
            
            // start create element for report of PartI_Layout1
            // create context for none explict member
            // TODO: remove once done
            // - AssetsInIndia
            
            
            Context partI_Layout1AssetsInIndiaContext170 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partI_Layout1AssetsInIndiaContext170.getId())) {
                contextElements.add(partI_Layout1AssetsInIndiaContext170);
                contextIdentifiers.add(partI_Layout1AssetsInIndiaContext170.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType assetsInIndiaValue = new MonetaryItemType();
            assetsInIndiaValue.setContextRef(partI_Layout1AssetsInIndiaContext170);
            
            assetsInIndiaValue.setUnitRef(INR169);
            assetsInIndiaValue.setDecimals(CommonFns.getDecimals(field.getAssetsInIndia(), "1000"));
            assetsInIndiaValue.setValue(new BigDecimal(field.getAssetsInIndia()));
            
            
            
            JAXBElement<MonetaryItemType> assetsInIndiaElement = instancObjectFactory.createAssetsInIndia(assetsInIndiaValue);
            bodyElements.add(assetsInIndiaElement);

            
            
            




            
            
            
            // end xbrl report element   


        }

            
            


            // with typemembers which requires multiple type member record
            

            
            // create variable for subclass PartII_PartII if any typeMembers then List or Single
            PartII_PartII partII_PartII = mainReportData.getPartII_PartII();
            
            
            {
            // create xbrl report element
            PartII_PartII field = partII_PartII;
            
            // create unit if not empty
            
                
            Unit INR171 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR171 == null){
                INR171 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR171.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR171.getMeasure().add(unitMeasureValue);
                unitElements.add(INR171);
            }
            
            // start create element for report of PartII_PartII
            // create context for none explict member
            // TODO: remove once done
            // - SecuredAdvances
            
            
            Context partII_PartIISecuredAdvancesContext172 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partII_PartIISecuredAdvancesContext172.getId())) {
                contextElements.add(partII_PartIISecuredAdvancesContext172);
                contextIdentifiers.add(partII_PartIISecuredAdvancesContext172.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType securedAdvancesValue = new MonetaryItemType();
            securedAdvancesValue.setContextRef(partII_PartIISecuredAdvancesContext172);
            
            securedAdvancesValue.setUnitRef(INR171);
            securedAdvancesValue.setDecimals(CommonFns.getDecimals(field.getSecuredAdvances(), "1000"));
            securedAdvancesValue.setValue(new BigDecimal(field.getSecuredAdvances()));
            
            
            
            JAXBElement<MonetaryItemType> securedAdvancesElement = instancObjectFactory.createSecuredAdvances(securedAdvancesValue);
            bodyElements.add(securedAdvancesElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR173 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR173 == null){
                INR173 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR173.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR173.getMeasure().add(unitMeasureValue);
                unitElements.add(INR173);
            }
            
            // start create element for report of PartII_PartII
            // create context for none explict member
            // TODO: remove once done
            // - UnsecuredAdvances
            
            
            Context partII_PartIIUnsecuredAdvancesContext174 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partII_PartIIUnsecuredAdvancesContext174.getId())) {
                contextElements.add(partII_PartIIUnsecuredAdvancesContext174);
                contextIdentifiers.add(partII_PartIIUnsecuredAdvancesContext174.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType unsecuredAdvancesValue = new MonetaryItemType();
            unsecuredAdvancesValue.setContextRef(partII_PartIIUnsecuredAdvancesContext174);
            
            unsecuredAdvancesValue.setUnitRef(INR173);
            unsecuredAdvancesValue.setDecimals(CommonFns.getDecimals(field.getUnsecuredAdvances(), "1000"));
            unsecuredAdvancesValue.setValue(new BigDecimal(field.getUnsecuredAdvances()));
            
            
            
            JAXBElement<MonetaryItemType> unsecuredAdvancesElement = instancObjectFactory.createUnsecuredAdvances(unsecuredAdvancesValue);
            bodyElements.add(unsecuredAdvancesElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR175 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR175 == null){
                INR175 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR175.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR175.getMeasure().add(unitMeasureValue);
                unitElements.add(INR175);
            }
            
            // start create element for report of PartII_PartII
            // create context for none explict member
            // TODO: remove once done
            // - Advances
            
            
            Context partII_PartIIAdvancesContext176 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partII_PartIIAdvancesContext176.getId())) {
                contextElements.add(partII_PartIIAdvancesContext176);
                contextIdentifiers.add(partII_PartIIAdvancesContext176.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType advancesValue = new MonetaryItemType();
            advancesValue.setContextRef(partII_PartIIAdvancesContext176);
            
            advancesValue.setUnitRef(INR175);
            advancesValue.setDecimals(CommonFns.getDecimals(field.getAdvances(), "1000"));
            advancesValue.setValue(new BigDecimal(field.getAdvances()));
            
            
            
            JAXBElement<MonetaryItemType> advancesElement = instancObjectFactory.createAdvances(advancesValue);
            bodyElements.add(advancesElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit pure177 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("PURE")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(pure177 == null){
                pure177 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                pure177.setId("PURE");
                QName unitMeasureValue = new QName("xbrli:pure");
                pure177.getMeasure().add(unitMeasureValue);
                unitElements.add(pure177);
            }
            
            // start create element for report of PartII_PartII
            // create context for none explict member
            // TODO: remove once done
            // - PercentageOfCleanAdvances
            
            
            Context partII_PartIIPercentageOfCleanAdvancesContext178 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partII_PartIIPercentageOfCleanAdvancesContext178.getId())) {
                contextElements.add(partII_PartIIPercentageOfCleanAdvancesContext178);
                contextIdentifiers.add(partII_PartIIPercentageOfCleanAdvancesContext178.getId());
            }
            
            
            // create element JAXB Element

            PureItemType percentageOfCleanAdvancesValue = new PureItemType();
            percentageOfCleanAdvancesValue.setContextRef(partII_PartIIPercentageOfCleanAdvancesContext178);
            
            percentageOfCleanAdvancesValue.setUnitRef(pure177);
            percentageOfCleanAdvancesValue.setDecimals("INF");
            percentageOfCleanAdvancesValue.setValue(new BigInteger(field.getPercentageOfCleanAdvances()));
            
            
            
            JAXBElement<PureItemType> percentageOfCleanAdvancesElement = instancObjectFactory.createPercentageOfCleanAdvances(percentageOfCleanAdvancesValue);
            bodyElements.add(percentageOfCleanAdvancesElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR179 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR179 == null){
                INR179 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR179.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR179.getMeasure().add(unitMeasureValue);
                unitElements.add(INR179);
            }
            
            // start create element for report of PartII_PartII
            // create context for none explict member
            // TODO: remove once done
            // - Deposits
            
            
            Context partII_PartIIDepositsContext180 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partII_PartIIDepositsContext180.getId())) {
                contextElements.add(partII_PartIIDepositsContext180);
                contextIdentifiers.add(partII_PartIIDepositsContext180.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType depositsValue = new MonetaryItemType();
            depositsValue.setContextRef(partII_PartIIDepositsContext180);
            
            depositsValue.setUnitRef(INR179);
            depositsValue.setDecimals(CommonFns.getDecimals(field.getDeposits(), "1000"));
            depositsValue.setValue(new BigDecimal(field.getDeposits()));
            
            
            
            JAXBElement<MonetaryItemType> depositsElement = instancObjectFactory.createDeposits(depositsValue);
            bodyElements.add(depositsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit pure181 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("PURE")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(pure181 == null){
                pure181 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                pure181.setId("PURE");
                QName unitMeasureValue = new QName("xbrli:pure");
                pure181.getMeasure().add(unitMeasureValue);
                unitElements.add(pure181);
            }
            
            // start create element for report of PartII_PartII
            // create context for none explict member
            // TODO: remove once done
            // - PercentageOfAdvancesToDeposits
            
            
            Context partII_PartIIPercentageOfAdvancesToDepositsContext182 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partII_PartIIPercentageOfAdvancesToDepositsContext182.getId())) {
                contextElements.add(partII_PartIIPercentageOfAdvancesToDepositsContext182);
                contextIdentifiers.add(partII_PartIIPercentageOfAdvancesToDepositsContext182.getId());
            }
            
            
            // create element JAXB Element

            PureItemType percentageOfAdvancesToDepositsValue = new PureItemType();
            percentageOfAdvancesToDepositsValue.setContextRef(partII_PartIIPercentageOfAdvancesToDepositsContext182);
            
            percentageOfAdvancesToDepositsValue.setUnitRef(pure181);
            percentageOfAdvancesToDepositsValue.setDecimals("INF");
            percentageOfAdvancesToDepositsValue.setValue(new BigInteger(field.getPercentageOfAdvancesToDeposits()));
            
            
            
            JAXBElement<PureItemType> percentageOfAdvancesToDepositsElement = instancObjectFactory.createPercentageOfAdvancesToDeposits(percentageOfAdvancesToDepositsValue);
            bodyElements.add(percentageOfAdvancesToDepositsElement);

            
            
            




            
            
            
            // end xbrl report element   


        }

            
            


            // with typemembers which requires multiple type member record
            

            
            // create variable for subclass PartIII_PartIII if any typeMembers then List or Single
            PartIII_PartIII partIII_PartIII = mainReportData.getPartIII_PartIII();
            
            
            {
            // create xbrl report element
            PartIII_PartIII field = partIII_PartIII;
            
            // create unit if not empty
            
                
            Unit INR183 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR183 == null){
                INR183 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR183.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR183.getMeasure().add(unitMeasureValue);
                unitElements.add(INR183);
            }
            
            // start create element for report of PartIII_PartIII
            // create context for none explict member
            // TODO: remove once done
            // - NetDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptions
            
            
            Context partIII_PartIIINetDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptionsContext184 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partIII_PartIIINetDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptionsContext184.getId())) {
                contextElements.add(partIII_PartIIINetDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptionsContext184);
                contextIdentifiers.add(partIII_PartIIINetDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptionsContext184.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType netDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptionsValue = new MonetaryItemType();
            netDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptionsValue.setContextRef(partIII_PartIIINetDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptionsContext184);
            
            netDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptionsValue.setUnitRef(INR183);
            netDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptionsValue.setDecimals(CommonFns.getDecimals(field.getNetDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptions(), "1000"));
            netDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptionsValue.setValue(new BigDecimal(field.getNetDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptions()));
            
            
            
            JAXBElement<MonetaryItemType> netDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptionsElement = instancObjectFactory.createNetDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptions(netDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptionsValue);
            bodyElements.add(netDemandTimeLiabilitiesAfterDeductionOfZeroReservePrescriptionsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR185 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR185 == null){
                INR185 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR185.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR185.getMeasure().add(unitMeasureValue);
                unitElements.add(INR185);
            }
            
            // start create element for report of PartIII_PartIII
            // create context for none explict member
            // TODO: remove once done
            // - MinimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationAct
            
            
            Context partIII_PartIIIMinimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationActContext186 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partIII_PartIIIMinimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationActContext186.getId())) {
                contextElements.add(partIII_PartIIIMinimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationActContext186);
                contextIdentifiers.add(partIII_PartIIIMinimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationActContext186.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType minimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationActValue = new MonetaryItemType();
            minimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationActValue.setContextRef(partIII_PartIIIMinimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationActContext186);
            
            minimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationActValue.setUnitRef(INR185);
            minimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationActValue.setDecimals(CommonFns.getDecimals(field.getMinimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationAct(), "1000"));
            minimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationActValue.setValue(new BigDecimal(field.getMinimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationAct()));
            
            
            
            JAXBElement<MonetaryItemType> minimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationActElement = instancObjectFactory.createMinimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationAct(minimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationActValue);
            bodyElements.add(minimumAssetsAcquiredInIndiaUnderSection25OfBankingRegulationActElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR187 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR187 == null){
                INR187 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR187.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR187.getMeasure().add(unitMeasureValue);
                unitElements.add(INR187);
            }
            
            // start create element for report of PartIII_PartIII
            // create context for none explict member
            // TODO: remove once done
            // - TotalAssets
            
            
            Context partIII_PartIIITotalAssetsContext188 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partIII_PartIIITotalAssetsContext188.getId())) {
                contextElements.add(partIII_PartIIITotalAssetsContext188);
                contextIdentifiers.add(partIII_PartIIITotalAssetsContext188.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType totalAssetsValue = new MonetaryItemType();
            totalAssetsValue.setContextRef(partIII_PartIIITotalAssetsContext188);
            
            totalAssetsValue.setUnitRef(INR187);
            totalAssetsValue.setDecimals(CommonFns.getDecimals(field.getTotalAssets(), "1000"));
            totalAssetsValue.setValue(new BigDecimal(field.getTotalAssets()));
            
            
            
            JAXBElement<MonetaryItemType> totalAssetsElement = instancObjectFactory.createTotalAssets(totalAssetsValue);
            bodyElements.add(totalAssetsElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR189 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR189 == null){
                INR189 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR189.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR189.getMeasure().add(unitMeasureValue);
                unitElements.add(INR189);
            }
            
            // start create element for report of PartIII_PartIII
            // create context for none explict member
            // TODO: remove once done
            // - AssetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpenses
            
            
            Context partIII_PartIIIAssetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpensesContext190 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partIII_PartIIIAssetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpensesContext190.getId())) {
                contextElements.add(partIII_PartIIIAssetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpensesContext190);
                contextIdentifiers.add(partIII_PartIIIAssetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpensesContext190.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType assetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpensesValue = new MonetaryItemType();
            assetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpensesValue.setContextRef(partIII_PartIIIAssetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpensesContext190);
            
            assetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpensesValue.setUnitRef(INR189);
            assetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpensesValue.setDecimals(CommonFns.getDecimals(field.getAssetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpenses(), "1000"));
            assetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpensesValue.setValue(new BigDecimal(field.getAssetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpenses()));
            
            
            
            JAXBElement<MonetaryItemType> assetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpensesElement = instancObjectFactory.createAssetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpenses(assetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpensesValue);
            bodyElements.add(assetsInIndiaExcludingInterOfficeAdjustmentsAndCapitalisedExpensesElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR191 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR191 == null){
                INR191 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR191.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR191.getMeasure().add(unitMeasureValue);
                unitElements.add(INR191);
            }
            
            // start create element for report of PartIII_PartIII
            // create context for none explict member
            // TODO: remove once done
            // - SecuritiesApprovedUnderSection25OfBankingRegulationAct
            
            
            Context partIII_PartIIISecuritiesApprovedUnderSection25OfBankingRegulationActContext192 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(partIII_PartIIISecuritiesApprovedUnderSection25OfBankingRegulationActContext192.getId())) {
                contextElements.add(partIII_PartIIISecuritiesApprovedUnderSection25OfBankingRegulationActContext192);
                contextIdentifiers.add(partIII_PartIIISecuritiesApprovedUnderSection25OfBankingRegulationActContext192.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType securitiesApprovedUnderSection25OfBankingRegulationActValue = new MonetaryItemType();
            securitiesApprovedUnderSection25OfBankingRegulationActValue.setContextRef(partIII_PartIIISecuritiesApprovedUnderSection25OfBankingRegulationActContext192);
            
            securitiesApprovedUnderSection25OfBankingRegulationActValue.setUnitRef(INR191);
            securitiesApprovedUnderSection25OfBankingRegulationActValue.setDecimals(CommonFns.getDecimals(field.getSecuritiesApprovedUnderSection25OfBankingRegulationAct(), "1000"));
            securitiesApprovedUnderSection25OfBankingRegulationActValue.setValue(new BigDecimal(field.getSecuritiesApprovedUnderSection25OfBankingRegulationAct()));
            
            
            
            JAXBElement<MonetaryItemType> securitiesApprovedUnderSection25OfBankingRegulationActElement = instancObjectFactory.createSecuritiesApprovedUnderSection25OfBankingRegulationAct(securitiesApprovedUnderSection25OfBankingRegulationActValue);
            bodyElements.add(securitiesApprovedUnderSection25OfBankingRegulationActElement);

            
            
            




            
            
            
            // end xbrl report element   


        }

            
            


            // with typemembers which requires multiple type member record
            

            
            // create variable for subclass ForeignliabilitiesAndassets_Foreignliabilitiesassets if any typeMembers then List or Single
            ForeignliabilitiesAndassets_Foreignliabilitiesassets foreignliabilitiesAndassets_Foreignliabilitiesassets = mainReportData.getForeignliabilitiesAndassets_Foreignliabilitiesassets();
            
            
            {
            // create xbrl report element
            ForeignliabilitiesAndassets_Foreignliabilitiesassets field = foreignliabilitiesAndassets_Foreignliabilitiesassets;
            
            // create unit if not empty
            
                
            Unit INR193 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR193 == null){
                INR193 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR193.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR193.getMeasure().add(unitMeasureValue);
                unitElements.add(INR193);
            }
            
            // start create element for report of ForeignliabilitiesAndassets_Foreignliabilitiesassets
            // create context for none explict member
            // TODO: remove once done
            // - BalancesHeldAbroad
            
            
            Context foreignliabilitiesAndassets_ForeignliabilitiesassetsBalancesHeldAbroadContext194 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(foreignliabilitiesAndassets_ForeignliabilitiesassetsBalancesHeldAbroadContext194.getId())) {
                contextElements.add(foreignliabilitiesAndassets_ForeignliabilitiesassetsBalancesHeldAbroadContext194);
                contextIdentifiers.add(foreignliabilitiesAndassets_ForeignliabilitiesassetsBalancesHeldAbroadContext194.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType balancesHeldAbroadValue = new MonetaryItemType();
            balancesHeldAbroadValue.setContextRef(foreignliabilitiesAndassets_ForeignliabilitiesassetsBalancesHeldAbroadContext194);
            
            balancesHeldAbroadValue.setUnitRef(INR193);
            balancesHeldAbroadValue.setDecimals(CommonFns.getDecimals(field.getBalancesHeldAbroad(), "1000"));
            balancesHeldAbroadValue.setValue(new BigDecimal(field.getBalancesHeldAbroad()));
            
            
            
            JAXBElement<MonetaryItemType> balancesHeldAbroadElement = instancObjectFactory.createBalancesHeldAbroad(balancesHeldAbroadValue);
            bodyElements.add(balancesHeldAbroadElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR195 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR195 == null){
                INR195 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR195.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR195.getMeasure().add(unitMeasureValue);
                unitElements.add(INR195);
            }
            
            // start create element for report of ForeignliabilitiesAndassets_Foreignliabilitiesassets
            // create context for none explict member
            // TODO: remove once done
            // - InvestmentsHeldAbroad
            
            
            Context foreignliabilitiesAndassets_ForeignliabilitiesassetsInvestmentsHeldAbroadContext196 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(foreignliabilitiesAndassets_ForeignliabilitiesassetsInvestmentsHeldAbroadContext196.getId())) {
                contextElements.add(foreignliabilitiesAndassets_ForeignliabilitiesassetsInvestmentsHeldAbroadContext196);
                contextIdentifiers.add(foreignliabilitiesAndassets_ForeignliabilitiesassetsInvestmentsHeldAbroadContext196.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType investmentsHeldAbroadValue = new MonetaryItemType();
            investmentsHeldAbroadValue.setContextRef(foreignliabilitiesAndassets_ForeignliabilitiesassetsInvestmentsHeldAbroadContext196);
            
            investmentsHeldAbroadValue.setUnitRef(INR195);
            investmentsHeldAbroadValue.setDecimals(CommonFns.getDecimals(field.getInvestmentsHeldAbroad(), "1000"));
            investmentsHeldAbroadValue.setValue(new BigDecimal(field.getInvestmentsHeldAbroad()));
            
            
            
            JAXBElement<MonetaryItemType> investmentsHeldAbroadElement = instancObjectFactory.createInvestmentsHeldAbroad(investmentsHeldAbroadValue);
            bodyElements.add(investmentsHeldAbroadElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR197 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR197 == null){
                INR197 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR197.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR197.getMeasure().add(unitMeasureValue);
                unitElements.add(INR197);
            }
            
            // start create element for report of ForeignliabilitiesAndassets_Foreignliabilitiesassets
            // create context for none explict member
            // TODO: remove once done
            // - OtherForeignBillsPurchasedAndDiscountedOutsideIndia
            
            
            Context foreignliabilitiesAndassets_ForeignliabilitiesassetsOtherForeignBillsPurchasedAndDiscountedOutsideIndiaContext198 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(foreignliabilitiesAndassets_ForeignliabilitiesassetsOtherForeignBillsPurchasedAndDiscountedOutsideIndiaContext198.getId())) {
                contextElements.add(foreignliabilitiesAndassets_ForeignliabilitiesassetsOtherForeignBillsPurchasedAndDiscountedOutsideIndiaContext198);
                contextIdentifiers.add(foreignliabilitiesAndassets_ForeignliabilitiesassetsOtherForeignBillsPurchasedAndDiscountedOutsideIndiaContext198.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType otherForeignBillsPurchasedAndDiscountedOutsideIndiaValue = new MonetaryItemType();
            otherForeignBillsPurchasedAndDiscountedOutsideIndiaValue.setContextRef(foreignliabilitiesAndassets_ForeignliabilitiesassetsOtherForeignBillsPurchasedAndDiscountedOutsideIndiaContext198);
            
            otherForeignBillsPurchasedAndDiscountedOutsideIndiaValue.setUnitRef(INR197);
            otherForeignBillsPurchasedAndDiscountedOutsideIndiaValue.setDecimals(CommonFns.getDecimals(field.getOtherForeignBillsPurchasedAndDiscountedOutsideIndia(), "1000"));
            otherForeignBillsPurchasedAndDiscountedOutsideIndiaValue.setValue(new BigDecimal(field.getOtherForeignBillsPurchasedAndDiscountedOutsideIndia()));
            
            
            
            JAXBElement<MonetaryItemType> otherForeignBillsPurchasedAndDiscountedOutsideIndiaElement = instancObjectFactory.createOtherForeignBillsPurchasedAndDiscountedOutsideIndia(otherForeignBillsPurchasedAndDiscountedOutsideIndiaValue);
            bodyElements.add(otherForeignBillsPurchasedAndDiscountedOutsideIndiaElement);

            
            
            




            
            
            // create unit if not empty
            
                
            Unit INR199 = unitElements.stream().filter(u -> u.getId().equalsIgnoreCase("INR")).findAny().orElse(null);
            //unitObj = option.isPresent()? option.get() : null;
            if(INR199 == null){
                INR199 = new org.xbrl._2003.instance.ObjectFactory().createUnit();
                INR199.setId("INR");
                QName unitMeasureValue = new QName("iso4217:INR");
                INR199.getMeasure().add(unitMeasureValue);
                unitElements.add(INR199);
            }
            
            // start create element for report of ForeignliabilitiesAndassets_Foreignliabilitiesassets
            // create context for none explict member
            // TODO: remove once done
            // - OtherAssetsHeldOutsideIndia
            
            
            Context foreignliabilitiesAndassets_ForeignliabilitiesassetsOtherAssetsHeldOutsideIndiaContext200 = FORMXReportContextUtil.createAsOfContext( bankCode, periodDate  );
                
            
            if(!contextIdentifiers.contains(foreignliabilitiesAndassets_ForeignliabilitiesassetsOtherAssetsHeldOutsideIndiaContext200.getId())) {
                contextElements.add(foreignliabilitiesAndassets_ForeignliabilitiesassetsOtherAssetsHeldOutsideIndiaContext200);
                contextIdentifiers.add(foreignliabilitiesAndassets_ForeignliabilitiesassetsOtherAssetsHeldOutsideIndiaContext200.getId());
            }
            
            
            // create element JAXB Element

            MonetaryItemType otherAssetsHeldOutsideIndiaValue = new MonetaryItemType();
            otherAssetsHeldOutsideIndiaValue.setContextRef(foreignliabilitiesAndassets_ForeignliabilitiesassetsOtherAssetsHeldOutsideIndiaContext200);
            
            otherAssetsHeldOutsideIndiaValue.setUnitRef(INR199);
            otherAssetsHeldOutsideIndiaValue.setDecimals(CommonFns.getDecimals(field.getOtherAssetsHeldOutsideIndia(), "1000"));
            otherAssetsHeldOutsideIndiaValue.setValue(new BigDecimal(field.getOtherAssetsHeldOutsideIndia()));
            
            
            
            JAXBElement<MonetaryItemType> otherAssetsHeldOutsideIndiaElement = instancObjectFactory.createOtherAssetsHeldOutsideIndia(otherAssetsHeldOutsideIndiaValue);
            bodyElements.add(otherAssetsHeldOutsideIndiaElement);

            
            
            




            
            
            
            // end xbrl report element   


        }

            
            


            // with typemembers which requires multiple type member record
            

            
            // create variable for subclass Signatory_Signatory if any typeMembers then List or Single
            Signatory_Signatory signatory_Signatory = mainReportData.getSignatory_Signatory();
            
            
            {
            // create xbrl report element
            Signatory_Signatory field = signatory_Signatory;
            
            // create unit if not empty
            
            // start create element for report of Signatory_Signatory
            // create context for none explict member
            // TODO: remove once done
            // - PlaceOfSignature
            
            
                Context signatory_SignatoryPlaceOfSignatureContext201 = FORMXReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(signatory_SignatoryPlaceOfSignatureContext201.getId())) {
                contextElements.add(signatory_SignatoryPlaceOfSignatureContext201);
                contextIdentifiers.add(signatory_SignatoryPlaceOfSignatureContext201.getId());
            }
            
            
            // create element JAXB Element

            StringItemType placeOfSignatureValue = new StringItemType();
            placeOfSignatureValue.setContextRef(signatory_SignatoryPlaceOfSignatureContext201);
            
                    placeOfSignatureValue.setValue(field.getPlaceOfSignature());        
                    
            
            
            JAXBElement<StringItemType> placeOfSignatureElement = instancObjectFactory.createPlaceOfSignature(placeOfSignatureValue);
            bodyElements.add(placeOfSignatureElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of Signatory_Signatory
            // create context for none explict member
            // TODO: remove once done
            // - Signature
            
            
                Context signatory_SignatorySignatureContext202 = FORMXReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(signatory_SignatorySignatureContext202.getId())) {
                contextElements.add(signatory_SignatorySignatureContext202);
                contextIdentifiers.add(signatory_SignatorySignatureContext202.getId());
            }
            
            
            // create element JAXB Element

            StringItemType signatureValue = new StringItemType();
            signatureValue.setContextRef(signatory_SignatorySignatureContext202);
            
                    signatureValue.setValue(field.getSignature());        
                    
            
            
            JAXBElement<StringItemType> signatureElement = instancObjectFactory.createSignature(signatureValue);
            bodyElements.add(signatureElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of Signatory_Signatory
            // create context for none explict member
            // TODO: remove once done
            // - DateOfSignature
            
            
                Context signatory_SignatoryDateOfSignatureContext203 = FORMXReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(signatory_SignatoryDateOfSignatureContext203.getId())) {
                contextElements.add(signatory_SignatoryDateOfSignatureContext203);
                contextIdentifiers.add(signatory_SignatoryDateOfSignatureContext203.getId());
            }
            
            
            // create element JAXB Element

            DateItemType dateOfSignatureValue = new DateItemType();
            dateOfSignatureValue.setContextRef(signatory_SignatoryDateOfSignatureContext203);
            
            dateOfSignatureValue.setValue(FORMXReportContextUtil.toXMLGeo(field.getDateOfSignature()));
            
            
            
            JAXBElement<DateItemType> dateOfSignatureElement = instancObjectFactory.createDateOfSignature(dateOfSignatureValue);
            bodyElements.add(dateOfSignatureElement);

            
            
            




            
            
            // create unit if not empty
            
            // start create element for report of Signatory_Signatory
            // create context for none explict member
            // TODO: remove once done
            // - DesignationOfSignatory
            
            
                Context signatory_SignatoryDesignationOfSignatoryContext204 = FORMXReportContextUtil.createFromToContext( bankCode, startDate, endDate  );
                
            if(!contextIdentifiers.contains(signatory_SignatoryDesignationOfSignatoryContext204.getId())) {
                contextElements.add(signatory_SignatoryDesignationOfSignatoryContext204);
                contextIdentifiers.add(signatory_SignatoryDesignationOfSignatoryContext204.getId());
            }
            
            
            // create element JAXB Element

            StringItemType designationOfSignatoryValue = new StringItemType();
            designationOfSignatoryValue.setContextRef(signatory_SignatoryDesignationOfSignatoryContext204);
            
                    designationOfSignatoryValue.setValue(field.getDesignationOfSignatory());        
                    
            
            
            JAXBElement<StringItemType> designationOfSignatoryElement = instancObjectFactory.createDesignationOfSignatory(designationOfSignatoryValue);
            bodyElements.add(designationOfSignatoryElement);

            
            
            




            
            
            
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


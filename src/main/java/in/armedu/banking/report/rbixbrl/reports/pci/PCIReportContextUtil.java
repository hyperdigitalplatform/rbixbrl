package in.armedu.banking.report.rbixbrl.reports.pci;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ContextEntityType;
import org.xbrl._2003.instance.ContextPeriodType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.ContextEntityType.Identifier;
import org.xbrl._2006.xbrldi.ExplicitMember;
import org.xbrl._2006.xbrldi.TypedMember;

import in.armedu.banking.report.rbixbrl.util.ContextUtil;

public class PCIReportContextUtil {
    
    
    public static final String CURRENCY = "currency";
    public static final String PERCENTAGE = "percentage";

    public static XMLGregorianCalendar toXMLGeo(String dateInStr){
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

    public static Context createFromToContext(String bankCode, String startDate, String endDate){
        return createFromToContext(bankCode, startDate, endDate, null);
    }
    public static Context createAsOfContext(String bankCode, String reportDate){
        return createAsOfContext( bankCode,  reportDate,  null);
    }

    public static Context createFromToContext(String bankCode, String startDate, String endDate, String contextRefFromTo){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        ContextEntityType contextEntityType = xbrlObjectFactory.createContextEntityType();
        Identifier identifier = xbrlObjectFactory.createContextEntityTypeIdentifier();
        identifier.setScheme("http://www.rbi.gov.in/000/2010-12-31");
        // set entity identifier aka bank code
        identifier.setValue(bankCode);
        contextEntityType.setIdentifier(identifier);
        // create fromto context
        Context fromToContext = xbrlObjectFactory.createContext();
        if(contextRefFromTo == null || contextRefFromTo.isEmpty())
            contextRefFromTo = ContextUtil.getIdForFromTo("fromto", startDate, endDate, Collections.emptyList());

        fromToContext.setId(contextRefFromTo);
        ContextPeriodType period = xbrlObjectFactory.createContextPeriodType();
        period.setStartDate(startDate);
        period.setEndDate(endDate);
        fromToContext.setEntity(contextEntityType);
        fromToContext.setPeriod(period);
        return fromToContext;
    }

    public static Context createAsOfContext(String bankCode, String reportDate, String contextRefAsOf){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        ContextEntityType contextEntityType = xbrlObjectFactory.createContextEntityType();
        Identifier identifier = xbrlObjectFactory.createContextEntityTypeIdentifier();
        identifier.setScheme("http://www.rbi.gov.in/000/2010-12-31");
        // set entity identifier aka bank code
        identifier.setValue(bankCode);
        contextEntityType.setIdentifier(identifier);
        // create fromto context
        Context asOfContext = xbrlObjectFactory.createContext();
        if(contextRefAsOf == null || contextRefAsOf.isEmpty())
            contextRefAsOf = ContextUtil.getIdForAsOf("asof", reportDate, Collections.emptyList());
        asOfContext.setId(contextRefAsOf);
        ContextPeriodType periodInstant = xbrlObjectFactory.createContextPeriodType();
        periodInstant.setInstant(reportDate);
        asOfContext.setEntity(contextEntityType);
        asOfContext.setPeriod(periodInstant);
        return asOfContext;
    }

    
    
    public static Context createFromToContextWithMembers(String bankCode, String startDate, String endDate, String countryCode,String branchCode,String nameOfBorrower,String borrowerGroupName,String industryCode, Map<String, String> emMap ){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefFromToForBorrowerString = ContextUtil.getIdForFromTo("fromto", startDate, endDate, emMap.values()  ,countryCode  ,branchCode  ,nameOfBorrower  ,borrowerGroupName  ,industryCode  );
        Context context = createFromToContext(bankCode, startDate, endDate, contextRefFromToForBorrowerString);
        
        // create segement
        org.xbrl._2003.instance.Segment segFundedMember = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitMembers(emMap);
        List<TypedMember> typeMembers = createTypedMembers( countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode); 
        segFundedMember.getAny().addAll(explicitMembers);
        segFundedMember.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segFundedMember);
        return context;
    }

    public static Context createAsOfContextWithMembers(String bankCode, String reportDate,  String countryCode, String branchCode, String nameOfBorrower, String borrowerGroupName, String industryCode, Map<String, String> emMap ){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefAsOfFundTypeString = ContextUtil.getIdForAsOf("asof", reportDate, emMap.values() ,countryCode,branchCode,nameOfBorrower,borrowerGroupName,industryCode);
        Context context = createAsOfContext(bankCode, reportDate, contextRefAsOfFundTypeString);
        
        // create segement
        org.xbrl._2003.instance.Segment segFundedMember = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitMembers(emMap);
        List<TypedMember> typeMembers = createTypedMembers( countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode); 
        segFundedMember.getAny().addAll(explicitMembers);
        segFundedMember.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segFundedMember);
        
        return context;

    }
    
    public static List<TypedMember> createTypedMembers(String countryCode  , String branchCode  , String nameOfBorrower  , String borrowerGroupName  , String industryCode ) {
        List<TypedMember> typedMembers = new ArrayList<TypedMember>();
        

        if(countryCode != null && !countryCode.isEmpty()){
            StringItemType countryCodeAxis = new StringItemType();
            countryCodeAxis.setValue(countryCode);
            TypedMember typedMemberForCountryCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForCountryCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CountryCodeAxis"));
            typedMemberForCountryCode.setAny(new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory()
                                            .createCountryCodeAxis(countryCodeAxis));
            typedMembers.add(typedMemberForCountryCode);
        }
        

        if(branchCode != null && !branchCode.isEmpty()){
            StringItemType branchCodeAxis = new StringItemType();
            branchCodeAxis.setValue(branchCode);
            TypedMember typedMemberForBranchCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForBranchCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "BranchCodeAxis"));
            typedMemberForBranchCode.setAny(new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory()
                                            .createBranchCodeAxis(branchCodeAxis));
            typedMembers.add(typedMemberForBranchCode);
        }
        

        if(nameOfBorrower != null && !nameOfBorrower.isEmpty()){
            StringItemType nameOfBorrowerAxis = new StringItemType();
            nameOfBorrowerAxis.setValue(nameOfBorrower);
            TypedMember typedMemberForNameOfBorrower = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForNameOfBorrower.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "NameOfBorrowerAxis"));
            typedMemberForNameOfBorrower.setAny(new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory()
                                            .createNameOfBorrowerAxis(nameOfBorrowerAxis));
            typedMembers.add(typedMemberForNameOfBorrower);
        }
        

        if(borrowerGroupName != null && !borrowerGroupName.isEmpty()){
            StringItemType borrowerGroupNameAxis = new StringItemType();
            borrowerGroupNameAxis.setValue(borrowerGroupName);
            TypedMember typedMemberForBorrowerGroupName = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForBorrowerGroupName.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "BorrowerGroupNameAxis"));
            typedMemberForBorrowerGroupName.setAny(new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory()
                                            .createBorrowerGroupNameAxis(borrowerGroupNameAxis));
            typedMembers.add(typedMemberForBorrowerGroupName);
        }
        

        if(industryCode != null && !industryCode.isEmpty()){
            StringItemType industryCodeAxis = new StringItemType();
            industryCodeAxis.setValue(industryCode);
            TypedMember typedMemberForIndustryCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForIndustryCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
            typedMemberForIndustryCode.setAny(new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory()
                                            .createIndustryCodeAxis(industryCodeAxis));
            typedMembers.add(typedMemberForIndustryCode);
        }
        
        return typedMembers;
    }
    
    
    public static Context createFromToContextWithMembers(String bankCode, String startDate, String endDate, String countryCode,String branchCode, Map<String, String> emMap ){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefFromToForBorrowerString = ContextUtil.getIdForFromTo("fromto", startDate, endDate, emMap.values()  ,countryCode  ,branchCode  );
        Context context = createFromToContext(bankCode, startDate, endDate, contextRefFromToForBorrowerString);
        
        // create segement
        org.xbrl._2003.instance.Segment segFundedMember = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitMembers(emMap);
        List<TypedMember> typeMembers = createTypedMembers( countryCode, branchCode); 
        segFundedMember.getAny().addAll(explicitMembers);
        segFundedMember.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segFundedMember);
        return context;
    }

    public static Context createAsOfContextWithMembers(String bankCode, String reportDate,  String countryCode, String branchCode, Map<String, String> emMap ){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefAsOfFundTypeString = ContextUtil.getIdForAsOf("asof", reportDate, emMap.values() ,countryCode,branchCode);
        Context context = createAsOfContext(bankCode, reportDate, contextRefAsOfFundTypeString);
        
        // create segement
        org.xbrl._2003.instance.Segment segFundedMember = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitMembers(emMap);
        List<TypedMember> typeMembers = createTypedMembers( countryCode, branchCode); 
        segFundedMember.getAny().addAll(explicitMembers);
        segFundedMember.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segFundedMember);
        
        return context;

    }
    
    public static List<TypedMember> createTypedMembers(String countryCode  , String branchCode ) {
        List<TypedMember> typedMembers = new ArrayList<TypedMember>();
        

        if(countryCode != null && !countryCode.isEmpty()){
            StringItemType countryCodeAxis = new StringItemType();
            countryCodeAxis.setValue(countryCode);
            TypedMember typedMemberForCountryCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForCountryCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CountryCodeAxis"));
            typedMemberForCountryCode.setAny(new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory()
                                            .createCountryCodeAxis(countryCodeAxis));
            typedMembers.add(typedMemberForCountryCode);
        }
        

        if(branchCode != null && !branchCode.isEmpty()){
            StringItemType branchCodeAxis = new StringItemType();
            branchCodeAxis.setValue(branchCode);
            TypedMember typedMemberForBranchCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForBranchCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "BranchCodeAxis"));
            typedMemberForBranchCode.setAny(new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory()
                                            .createBranchCodeAxis(branchCodeAxis));
            typedMembers.add(typedMemberForBranchCode);
        }
        
        return typedMembers;
    }
    
    
    public static Context createFromToContextWithMembers(String bankCode, String startDate, String endDate, String countryCode,String branchCode,String nameOfIssuer,String issuerGroupName, Map<String, String> emMap ){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefFromToForBorrowerString = ContextUtil.getIdForFromTo("fromto", startDate, endDate, emMap.values()  ,countryCode  ,branchCode  ,nameOfIssuer  ,issuerGroupName  );
        Context context = createFromToContext(bankCode, startDate, endDate, contextRefFromToForBorrowerString);
        
        // create segement
        org.xbrl._2003.instance.Segment segFundedMember = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitMembers(emMap);
        List<TypedMember> typeMembers = createTypedMembers( countryCode, branchCode, nameOfIssuer, issuerGroupName); 
        segFundedMember.getAny().addAll(explicitMembers);
        segFundedMember.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segFundedMember);
        return context;
    }

    public static Context createAsOfContextWithMembers(String bankCode, String reportDate,  String countryCode, String branchCode, String nameOfIssuer, String issuerGroupName, Map<String, String> emMap ){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String contextRefAsOfFundTypeString = ContextUtil.getIdForAsOf("asof", reportDate, emMap.values() ,countryCode,branchCode,nameOfIssuer,issuerGroupName);
        Context context = createAsOfContext(bankCode, reportDate, contextRefAsOfFundTypeString);
        
        // create segement
        org.xbrl._2003.instance.Segment segFundedMember = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitMembers(emMap);
        List<TypedMember> typeMembers = createTypedMembers( countryCode, branchCode, nameOfIssuer, issuerGroupName); 
        segFundedMember.getAny().addAll(explicitMembers);
        segFundedMember.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segFundedMember);
        
        return context;

    }
    
    public static List<TypedMember> createTypedMembers(String countryCode  , String branchCode  , String nameOfIssuer  , String issuerGroupName ) {
        List<TypedMember> typedMembers = new ArrayList<TypedMember>();
        

        if(countryCode != null && !countryCode.isEmpty()){
            StringItemType countryCodeAxis = new StringItemType();
            countryCodeAxis.setValue(countryCode);
            TypedMember typedMemberForCountryCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForCountryCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CountryCodeAxis"));
            typedMemberForCountryCode.setAny(new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory()
                                            .createCountryCodeAxis(countryCodeAxis));
            typedMembers.add(typedMemberForCountryCode);
        }
        

        if(branchCode != null && !branchCode.isEmpty()){
            StringItemType branchCodeAxis = new StringItemType();
            branchCodeAxis.setValue(branchCode);
            TypedMember typedMemberForBranchCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForBranchCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "BranchCodeAxis"));
            typedMemberForBranchCode.setAny(new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory()
                                            .createBranchCodeAxis(branchCodeAxis));
            typedMembers.add(typedMemberForBranchCode);
        }
        

        if(nameOfIssuer != null && !nameOfIssuer.isEmpty()){
            StringItemType nameOfIssuerAxis = new StringItemType();
            nameOfIssuerAxis.setValue(nameOfIssuer);
            TypedMember typedMemberForNameOfIssuer = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForNameOfIssuer.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "NameOfIssuerAxis"));
            typedMemberForNameOfIssuer.setAny(new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory()
                                            .createNameOfIssuerAxis(nameOfIssuerAxis));
            typedMembers.add(typedMemberForNameOfIssuer);
        }
        

        if(issuerGroupName != null && !issuerGroupName.isEmpty()){
            StringItemType issuerGroupNameAxis = new StringItemType();
            issuerGroupNameAxis.setValue(issuerGroupName);
            TypedMember typedMemberForIssuerGroupName = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForIssuerGroupName.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IssuerGroupNameAxis"));
            typedMemberForIssuerGroupName.setAny(new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory()
                                            .createIssuerGroupNameAxis(issuerGroupNameAxis));
            typedMembers.add(typedMemberForIssuerGroupName);
        }
        
        return typedMembers;
    }
    

    public static List<ExplicitMember> createExplicitMembers(Map<String, String> emMap) {
        List<ExplicitMember> explicitMembers = new ArrayList<ExplicitMember>();
        emMap.forEach((type, value)->{
            ExplicitMember explicitMemberForExposureType = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberForExposureType.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", type));
            explicitMemberForExposureType.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", value));
            explicitMembers.add(explicitMemberForExposureType);
        });        
        return explicitMembers;
    }
    
}

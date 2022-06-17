package in.armedu.banking.report.rbixbrl.part.pci.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ContextEntityType;
import org.xbrl._2003.instance.ContextEntityType.Identifier;
import org.xbrl._2006.xbrldi.ExplicitMember;
import org.xbrl._2006.xbrldi.TypedMember;
import org.xbrl._2003.instance.ContextPeriodType;
import org.xbrl._2003.instance.ObjectFactory;

import in.armedu.banking.report.rbixbrl.util.AsOfContext;
import in.armedu.banking.report.rbixbrl.util.FromToContext;

public class PCIUtil {


    public static final String FROMTO = "fromtocontext";
    public static final String ASOF = "asofcontext";

    public static final String FROMTOMORETHANUSD2MILLIONMEMBER = "fromtomorethanusd2millionmember";
    public static final String ASOFMORETHANUSD2MILLIONMEMBER = "asofmorethanusd2millionmember";
    public static final String ASOFMORETHANUSD2MPROBLEMCREDITMEMBER = "asofmorethanusd2mproblemcreditmember";

    public static final String FROMTOLESSTHANUSD2MILLIONMEMBER = "fromtolessthanusd2millionmember";
    public static final String ASOFLESSTHANUSD2MILLIONMEMBER = "asoflessthanusd2millionmember";
    public static final String ASOFTYPEOFPROBLEMCREDITANDINVESTMENTCUSTOMER = "asoftypeofproblemcreditandinvestmentcustomer";

    public static final String FROMTOMORETHANUSD1MILIIONMEMBER = "fromtomorethanusd1miliionmember";
    public static final String ASOFMORETHANUSD1MILIIONMEMBER = "asofmorethanusd1miliionmember";

    public static final String FROMTOLESSTHANUSD1MILIIONMEMBER = "fromtolessthanusd1miliionmember";
    public static final String ASOFLESSTHANUSD1MILIIONMEMBER = "asoflessthanusd1miliionmember";

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
            contextRefFromTo = FromToContext.getId("fromto", startDate,  endDate);

        fromToContext.setId(contextRefFromTo);
        ContextPeriodType period = xbrlObjectFactory.createContextPeriodType();
        period.setStartDate(startDate);
        period.setEndDate(endDate);
        fromToContext.setEntity(contextEntityType);
        fromToContext.setPeriod(period);
        return fromToContext;
    }

    public static Context createAsOfContext(String bankCode, String endDate, String contextRefAsOf){
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
            contextRefAsOf = AsOfContext.getId("asof", endDate);
        asOfContext.setId(contextRefAsOf);
        ContextPeriodType periodInstant = xbrlObjectFactory.createContextPeriodType();
        periodInstant.setInstant(endDate);
        asOfContext.setEntity(contextEntityType);
        asOfContext.setPeriod(periodInstant);
        return asOfContext;
    }

    // create fromToMoreThanUSD2MillionMember
    public static Context createFromToContextMoreThanUSD2MillionMember(String bankCode, String startDate, String endDate, 
    String customerCreditLimit, String typeOfProblemCreditAndInvestmentCustomer, String countryCode, String branchCode,
     String nameOfBorrower, String borrowerGroupName, String industryCode){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String fromToContextMoreThanUSD2MillionMember = FromToContext.getId("fromto", startDate, endDate, customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer,
    countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode );
    Context context = createFromToContext(bankCode, startDate, endDate, fromToContextMoreThanUSD2MillionMember);
    
    // create segement
    org.xbrl._2003.instance.Segment segMoreThanUSD2MillionMember = xbrlObjectFactory.createSegment();
    List<ExplicitMember> explicitMembers = createExplicitMembers(customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer);
    List<TypedMember> typeMembers = createTypedMembers(countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode, null, null); 
    segMoreThanUSD2MillionMember.getAny().addAll(explicitMembers);
    segMoreThanUSD2MillionMember.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segMoreThanUSD2MillionMember);
    return context;
    }

    // create asOfMoreThanUSD2MillionMember
    public static Context createAsOfContextMoreThanUSD2MillionMember(String bankCode, String endDate, String customerCreditLimit,
    String typeOfProblemCreditAndInvestmentCustomer, String countryCode, String branchCode,
     String nameOfBorrower, String borrowerGroupName, String industryCode){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String asOfContextMoreThanUSD2MillionMember = AsOfContext.getId("asOf", endDate, customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer,
    countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode );
    Context context = createAsOfContext(bankCode, endDate, asOfContextMoreThanUSD2MillionMember);
    
    // create segement
    org.xbrl._2003.instance.Segment segMoreThanUSD2MillionMember = xbrlObjectFactory.createSegment();
    List<ExplicitMember> explicitMembers = createExplicitMembers(customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer);
    List<TypedMember> typeMembers = createTypedMembers(countryCode, branchCode, nameOfBorrower, borrowerGroupName, industryCode, null, null); 
    segMoreThanUSD2MillionMember.getAny().addAll(explicitMembers);
    segMoreThanUSD2MillionMember.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segMoreThanUSD2MillionMember);
    return context;
    }

    // create fromToLessThanUSD2MillionMember
    public static Context createFromToContextLessThanUSD2MillionMember(String bankCode, String startDate, String endDate, 
    String customerCreditLimit, String typeOfProblemCreditAndInvestmentCustomer, String countryCode, String branchCode){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String fromToContextLessThanUSD2MillionMember = FromToContext.getId("fromto", startDate, endDate, customerCreditLimit,
    typeOfProblemCreditAndInvestmentCustomer, countryCode, branchCode);
    Context context = createFromToContext(bankCode, startDate, endDate, fromToContextLessThanUSD2MillionMember);
    
    // create segement
    org.xbrl._2003.instance.Segment segLessThanUSD2MillionMember = xbrlObjectFactory.createSegment();
    List<ExplicitMember> explicitMembers = createExplicitMembers(customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer);
    List<TypedMember> typeMembers = createTypedMembers(countryCode, branchCode, null, null, null, null, null); 
    segLessThanUSD2MillionMember.getAny().addAll(explicitMembers);
    segLessThanUSD2MillionMember.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segLessThanUSD2MillionMember);
    return context;
    }

    // create asOfLessThanUSD2MillionMember
    public static Context createAsOfContextLessThanUSD2MillionMember(String bankCode, String endDate, String customerCreditLimit,
    String typeOfProblemCreditAndInvestmentCustomer, String countryCode, String branchCode ){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String asOfContextLessThanUSD2MillionMember = AsOfContext.getId("asOf", endDate, customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer,
    countryCode, branchCode );
    Context context = createAsOfContext(bankCode, endDate, asOfContextLessThanUSD2MillionMember);
    
    // create segement
    org.xbrl._2003.instance.Segment segLessThanUSD2MillionMember = xbrlObjectFactory.createSegment();
    List<ExplicitMember> explicitMembers = createExplicitMembers(customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer);
    List<TypedMember> typeMembers = createTypedMembers(countryCode, branchCode, null, null, null, null, null); 
    segLessThanUSD2MillionMember.getAny().addAll(explicitMembers);
    segLessThanUSD2MillionMember.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segLessThanUSD2MillionMember);
    return context;
    }

    // create fromToMoreThanUSD1MiliionMember
    public static Context createFromToContextMoreThanUSD1MiliionMember(String bankCode, String startDate, String endDate, 
    String customerCreditLimit, String typeOfProblemCreditAndInvestmentCustomer, String countryCode, String branchCode,
     String nameOfIssuer, String issuerGroupName){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String fromToContextMoreThanUSD1MiliionMember = FromToContext.getId("fromto", startDate, endDate, customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer,
    countryCode, branchCode, nameOfIssuer, issuerGroupName );
    Context context = createFromToContext(bankCode, startDate, endDate, fromToContextMoreThanUSD1MiliionMember);
    
    // create segement
    org.xbrl._2003.instance.Segment segMoreThanUSD1MiliionMember = xbrlObjectFactory.createSegment();
    List<ExplicitMember> explicitMembers = createExplicitMembers(customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer);
    List<TypedMember> typeMembers = createTypedMembers(countryCode, branchCode, null, null, null, nameOfIssuer, issuerGroupName ); 
    segMoreThanUSD1MiliionMember.getAny().addAll(explicitMembers);
    segMoreThanUSD1MiliionMember.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segMoreThanUSD1MiliionMember);
    return context;
    }

    // create asOfMoreThanUSD1MiliionMember
    public static Context createAsOfContextMoreThanUSD1MiliionMember(String bankCode, String endDate, String customerCreditLimit,
    String typeOfProblemCreditAndInvestmentCustomer, String countryCode, String branchCode,
     String nameOfIssuer, String issuerGroupName ){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String asOfContextMoreThanUSD1MiliionMember = AsOfContext.getId("asOf", endDate, customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer,
    countryCode, branchCode, nameOfIssuer, issuerGroupName );
    Context context = createAsOfContext(bankCode, endDate, asOfContextMoreThanUSD1MiliionMember);
    
    // create segement
    org.xbrl._2003.instance.Segment segMoreThanUSD1MiliionMember = xbrlObjectFactory.createSegment();
    List<ExplicitMember> explicitMembers = createExplicitMembers(customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer);
    List<TypedMember> typeMembers = createTypedMembers(countryCode, branchCode, null, null, null, nameOfIssuer, issuerGroupName ); 
    segMoreThanUSD1MiliionMember.getAny().addAll(explicitMembers);
    segMoreThanUSD1MiliionMember.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segMoreThanUSD1MiliionMember);
    return context;
    }


    // create fromToLessThanUSD1MiliionMember
    public static Context createFromToContextLessThanUSD1MiliionMember(String bankCode, String startDate, String endDate, 
    String customerCreditLimit, String typeOfProblemCreditAndInvestmentCustomer, String countryCode, String branchCode){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String fromToContextLessThanUSD1MiliionMember = FromToContext.getId("fromto", startDate, endDate, customerCreditLimit,
    typeOfProblemCreditAndInvestmentCustomer, countryCode, branchCode);
    Context context = createFromToContext(bankCode, startDate, endDate, fromToContextLessThanUSD1MiliionMember);
    
    // create segement
    org.xbrl._2003.instance.Segment segLessThanUSD1MiliionMember = xbrlObjectFactory.createSegment();
    List<ExplicitMember> explicitMembers = createExplicitMembers(customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer);
    List<TypedMember> typeMembers = createTypedMembers(countryCode, branchCode, null, null, null, null, null ); 
    segLessThanUSD1MiliionMember.getAny().addAll(explicitMembers);
    segLessThanUSD1MiliionMember.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segLessThanUSD1MiliionMember);
    return context;
    }

    // create asOfLessThanUSD1MiliionMember
    public static Context createAsOfContextLessThanUSD1MiliionMember(String bankCode, String endDate, String customerCreditLimit,
    String typeOfProblemCreditAndInvestmentCustomer, String countryCode, String branchCode ){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String asOfContextLessThanUSD1MiliionMember = AsOfContext.getId("asOf", endDate, customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer,
    countryCode, branchCode );
    Context context = createAsOfContext(bankCode, endDate, asOfContextLessThanUSD1MiliionMember);
    
    // create segement
    org.xbrl._2003.instance.Segment segLessThanUSD1MiliionMember = xbrlObjectFactory.createSegment();
    List<ExplicitMember> explicitMembers = createExplicitMembers(customerCreditLimit, typeOfProblemCreditAndInvestmentCustomer);
    List<TypedMember> typeMembers = createTypedMembers(countryCode, branchCode, null, null, null, null, null ); 
    segLessThanUSD1MiliionMember.getAny().addAll(explicitMembers);
    segLessThanUSD1MiliionMember.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segLessThanUSD1MiliionMember);
    return context;
    }


     // create explicit members
     public static List<ExplicitMember> createExplicitMembers(String customerCreditLimit, String typeOfProblemCreditAndInvestmentCustomer) {
        List<ExplicitMember> explicitMembers = new ArrayList<ExplicitMember>();

        if(customerCreditLimit != null && !customerCreditLimit.isEmpty()){
            ExplicitMember explicitMemberForCustomerCreditLimit = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberForCustomerCreditLimit.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CustomerCreditLimitAxis"));
            explicitMemberForCustomerCreditLimit.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", customerCreditLimit));
            explicitMembers.add(explicitMemberForCustomerCreditLimit);
        }
        if(typeOfProblemCreditAndInvestmentCustomer != null && !typeOfProblemCreditAndInvestmentCustomer.isEmpty()){
            ExplicitMember explicitMemberForTypeOfProblemCreditAndInvestmentCustomer = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberForTypeOfProblemCreditAndInvestmentCustomer.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "TypeOfProblemCreditAndInvestmentCustomerAxis"));
            explicitMemberForTypeOfProblemCreditAndInvestmentCustomer.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", typeOfProblemCreditAndInvestmentCustomer));
            explicitMembers.add(explicitMemberForTypeOfProblemCreditAndInvestmentCustomer);
        }
        return explicitMembers;
    }

    // create typed members
    public static List<TypedMember> createTypedMembers(String countryCode, String branchCode, String nameOfBorrower,
     String borrowerGroupName, String industryCode, String nameOfIssuer, String issuerGroupName ) {
        List<TypedMember> typedMembers = new ArrayList<TypedMember>();
       
        if(countryCode != null && !countryCode.isEmpty()){
            TypedMember typedMemberForCountryCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForCountryCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "CountryCodeAxis"));
            typedMemberForCountryCode.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createCountryCodeDomain(countryCode));
            typedMembers.add(typedMemberForCountryCode);
        }
        if(branchCode != null && !branchCode.isEmpty()){
            TypedMember typedMemberForBranchCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForBranchCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "BranchCodeAxis"));
            typedMemberForBranchCode.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createBranchCodeDomain(branchCode));
            typedMembers.add(typedMemberForBranchCode);
        }
        if(nameOfBorrower != null && !nameOfBorrower.isEmpty()){
            TypedMember typedMemberForNameOfBorrower = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForNameOfBorrower.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "NameOfBorrowerAxis"));
            typedMemberForNameOfBorrower.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createNameOfBorrowerDomain(nameOfBorrower));
            typedMembers.add(typedMemberForNameOfBorrower);
        }
        if(borrowerGroupName != null && !borrowerGroupName.isEmpty()){
            TypedMember typedMemberForBorrowerGroupName = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForBorrowerGroupName.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "BorrowerGroupNameAxis"));
            typedMemberForBorrowerGroupName.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createNameOfBorrowerGroupDomain(borrowerGroupName));
            typedMembers.add(typedMemberForBorrowerGroupName);
        }
        if(industryCode != null && !industryCode.isEmpty()){
            TypedMember typedMemberForIndustryCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForIndustryCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IndustryCodeAxis"));
            typedMemberForIndustryCode.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createIndustryCodeDomain(industryCode));
            typedMembers.add(typedMemberForIndustryCode);
        }
        if(nameOfIssuer != null && !nameOfIssuer.isEmpty()){
            TypedMember typedMemberForNameOfIssuer = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForNameOfIssuer.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "NameOfIssuerAxis"));
            typedMemberForNameOfIssuer.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createNameOfIssuerDomain(nameOfIssuer));
            typedMembers.add(typedMemberForNameOfIssuer);
        }        
        if(issuerGroupName != null && !issuerGroupName.isEmpty()){
            TypedMember typedMemberForIssuerGroupName = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForIssuerGroupName.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "IssuerGroupNameAxis"));
            typedMemberForIssuerGroupName.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createIssuerGroupNameDomain(issuerGroupName));
            typedMembers.add(typedMemberForIssuerGroupName);
        }

        return typedMembers;
    }


}
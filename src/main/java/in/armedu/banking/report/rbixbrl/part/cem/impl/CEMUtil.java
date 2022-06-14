package in.armedu.banking.report.rbixbrl.part.cem.impl;

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

public class CEMUtil {

    public static final String FROMTO = "fromtocontext";
    public static final String ASOF = "asofcontext";

    public static final String ASOFBETWEENSIXMONTHMEMBER = "asofbetweensixmonthmember";
    public static final String ASOFOVERSIXMONTHSANDUPTOONEYEARMEMBER = "asofoversixmonthsanduptooneyearmember";
    public static final String ASOFOVERONEYEARANDUPTOFIVEYEARMEMBER = "asofoveroneyearanduptofiveyearmember";
    public static final String ASOFOVERFIVEYEARSMEMBER = "asofoverfiveyearsmember";
    public static final String ASOFRISKCLASSIFICATION = "asofriskclassification";

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

    // create asOfMembers
    public static Context createAsOfContextForMembers(String bankCode, String endDate, String riskClassification,
    String maturityPeriod, String countryCode, String branchCode, String exposureCountryCode){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String asofContextMembers = AsOfContext.getId("asof", endDate, riskClassification, 
    maturityPeriod, countryCode, branchCode, exposureCountryCode );
    Context context = createAsOfContext(bankCode, endDate, asofContextMembers);
    
    // create segement
    org.xbrl._2003.instance.Segment segMembers = xbrlObjectFactory.createSegment();
    List<ExplicitMember> explicitMembers = createExplicitMembers(riskClassification, maturityPeriod);
    List<TypedMember> typeMembers = createTypedMembers(countryCode, branchCode, exposureCountryCode); 
    segMembers.getAny().addAll(explicitMembers);
    segMembers.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segMembers);
    return context;
    }


    // create asOf  RiskClassification
    public static Context createAsOfRiskClassification(String bankCode, String endDate, 
    String riskClassification, String countryCode, String branchCode, String exposureCountryCode){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String asofContextMembers = AsOfContext.getId("asof", endDate, riskClassification, 
    countryCode, branchCode, exposureCountryCode );
    Context context = createAsOfContext(bankCode, endDate, asofContextMembers);
    
    // create segement
    org.xbrl._2003.instance.Segment segMembers = xbrlObjectFactory.createSegment();
    List<ExplicitMember> explicitMembers = createExplicitMembers(riskClassification, null);
    List<TypedMember> typeMembers = createTypedMembers(countryCode, branchCode, exposureCountryCode); 
    segMembers.getAny().addAll(explicitMembers);
    segMembers.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segMembers);
    return context;
    }

     // create explicit members
     public static List<ExplicitMember> createExplicitMembers(String riskClassification, String maturityPeriod) {
        List<ExplicitMember> explicitMembers = new ArrayList<ExplicitMember>();

        if(riskClassification != null && !riskClassification.isEmpty()){
            ExplicitMember explicitMemberForRiskClassification = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberForRiskClassification.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "RiskClassificationAxis"));
            explicitMemberForRiskClassification.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", riskClassification));
            explicitMembers.add(explicitMemberForRiskClassification);
        }
        if(maturityPeriod != null && !maturityPeriod.isEmpty()){
            ExplicitMember explicitMemberForMaturityPeriod = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberForMaturityPeriod.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "MaturityPeriodAxis"));
            explicitMemberForMaturityPeriod.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", maturityPeriod));
            explicitMembers.add(explicitMemberForMaturityPeriod);
        }
        return explicitMembers;
    }

    // create typed members
    public static List<TypedMember> createTypedMembers(String countryCode, String branchCode, String exposureCountryCode) {
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
        if(exposureCountryCode != null && !exposureCountryCode.isEmpty()){
            TypedMember typedMemberForExposureCountryCode = new org.xbrl._2006.xbrldi.ObjectFactory().createTypedMember();
            typedMemberForExposureCountryCode.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "ExposureCountryCodeAxis"));
            typedMemberForExposureCountryCode.setAny(new org.rbi.in_rbi_rep_par.ObjectFactory()
                                            .createCountryCodeDomain(exposureCountryCode));
            typedMembers.add(typedMemberForExposureCountryCode);
        }
    
        return typedMembers;
    }


}

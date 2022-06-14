package in.armedu.banking.report.rbixbrl.part.alo.impl;

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

public class ALOUtil {
 
    public static final String FROMTO = "fromtocontext";
    public static final String ASOF = "asofcontext";

    public static final String ASOFONETOTWENTYEIGHTDAYSMEMBER = "asofonetotwentyeightdaysmember";
    public static final String ASOFTWENTYNINEDAYSANDUPTOTHREEMONTHSMEMBER = "asoftwentyninedaysanduptothreemonthsmember";
    public static final String ASOFOVERTHREEMONTHSANDUPTOSIXMONTHSMEMBER = "asofoverthreemonthsanduptosixmonthsmember";
    public static final String ASOFOVERSIXMONTHSANDUPTOONEYEARMEMBER = "asofoversixmonthsanduptooneyearmember";
    public static final String ASOFOVERONEYEARUPTOANDTHREEYEARMEMBER = "asofoveroneyearuptoandthreeyearmember";
    public static final String ASOFOVERTHREEYEARSANDUPTOFIVEYEARMEMBER = "asofoverthreeyearsanduptofiveyearmember";
    public static final String ASOFOVERFIVEYEARSMEMBER = "asofoverfiveyearsmember";
    public static final String ASOFNONSENSITIVEMEMBER = "asofnonsensitivemember";
    public static final String ASOFREPORTINGPERIOD = "asofreportingperiod";

    public static final String ASOFACCOUNTWITHMEMBER = "asofaccountwithmember";

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

    // create asOfReportingPeriod typedmembers
    public static Context createAsOfContextForTypedMembers(String bankCode, String endDate, String countryCode, String branchCode){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String asofContextTypedMembers = AsOfContext.getId("asof", endDate, countryCode, branchCode );
        Context context = createAsOfContext(bankCode, endDate, asofContextTypedMembers);
        
        // create segement
        org.xbrl._2003.instance.Segment segTypedMembers = xbrlObjectFactory.createSegment();
        List<TypedMember> typeMembers = createTypedMembers(countryCode, branchCode); 
        segTypedMembers.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segTypedMembers);
        return context;
        }


    // create asOfReportingPeriod within bank members
    public static Context createAsOfContextForReportingPeriod(String bankCode, String endDate, String reportingPeriod, String countryCode, String branchCode){
    ObjectFactory xbrlObjectFactory = new ObjectFactory();
    String asofContextReportingPeriod = AsOfContext.getId("asof", endDate, reportingPeriod, countryCode, branchCode );
    Context context = createAsOfContext(bankCode, endDate, asofContextReportingPeriod);
    
    // create segement
    org.xbrl._2003.instance.Segment segReportingPeriod = xbrlObjectFactory.createSegment();
    List<ExplicitMember> explicitMembers = createExplicitMembersReportingPeriod(reportingPeriod);
    List<TypedMember> typeMembers = createTypedMembers(countryCode, branchCode); 
    segReportingPeriod.getAny().addAll(explicitMembers);
    segReportingPeriod.getAny().addAll(typeMembers);
    
    context.getEntity().setSegment(segReportingPeriod);
    return context;
    }


    // create asOfDetailsOfAccount AccountsWithOtherBranchesMember
    public static Context createAsOfContextForAccountWithMember(String bankCode, String endDate, String detailsOfAccounts, String periodOfReconcilliation, String countryCode, String branchCode){
        ObjectFactory xbrlObjectFactory = new ObjectFactory();
        String asofContextDetailsOfAccount = AsOfContext.getId("asof", endDate, detailsOfAccounts, periodOfReconcilliation, countryCode, branchCode );
        Context context = createAsOfContext(bankCode, endDate, asofContextDetailsOfAccount);
        
        // create segement
        org.xbrl._2003.instance.Segment segDetailsOfAccount = xbrlObjectFactory.createSegment();
        List<ExplicitMember> explicitMembers = createExplicitMembersAccountMembers(detailsOfAccounts, periodOfReconcilliation);
        List<TypedMember> typeMembers = createTypedMembers(countryCode, branchCode); 
        segDetailsOfAccount.getAny().addAll(explicitMembers);
        segDetailsOfAccount.getAny().addAll(typeMembers);
        
        context.getEntity().setSegment(segDetailsOfAccount);
        return context;
        }

    // create explicit members for reporting period
    public static List<ExplicitMember> createExplicitMembersReportingPeriod(String reportingPeriod) {
        List<ExplicitMember> explicitMembers = new ArrayList<ExplicitMember>();

        if(reportingPeriod != null && !reportingPeriod.isEmpty()){
            ExplicitMember explicitMemberForReportingPeriod = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberForReportingPeriod.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "ReportingPeriodAxis"));
            explicitMemberForReportingPeriod.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", reportingPeriod));
            explicitMembers.add(explicitMemberForReportingPeriod);
        }
        return explicitMembers;
    }

     // create explicit members forAccount with Members
     public static List<ExplicitMember> createExplicitMembersAccountMembers(String detailsOfAccounts, String periodOfReconcilliation) {
        List<ExplicitMember> explicitMembers = new ArrayList<ExplicitMember>();

        if(detailsOfAccounts != null && !detailsOfAccounts.isEmpty()){
            ExplicitMember explicitMemberForDetailsOfAccounts = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberForDetailsOfAccounts.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "DetailsOfAccountsWithBranchesAxis"));
            explicitMemberForDetailsOfAccounts.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", detailsOfAccounts));
            explicitMembers.add(explicitMemberForDetailsOfAccounts);
        }
        if(periodOfReconcilliation != null && !periodOfReconcilliation.isEmpty()){
            ExplicitMember explicitMemberForPeriodOfReconcilliation = new org.xbrl._2006.xbrldi.ObjectFactory().createExplicitMember();
            explicitMemberForPeriodOfReconcilliation.setDimension(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", "PeriodOfPendingReconcilliationAxis"));
            explicitMemberForPeriodOfReconcilliation.setValue(new QName("http://www.rbi.org/in/xbrl/2012-04-25/rbi", periodOfReconcilliation));
            explicitMembers.add(explicitMemberForPeriodOfReconcilliation);
        }
        return explicitMembers;
    }

    // create typed members
    public static List<TypedMember> createTypedMembers(String countryCode, String branchCode) {
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
    
        return typedMembers;
    }

}

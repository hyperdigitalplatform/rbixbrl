package in.armedu.banking.report.rbixbrl.part.cpr.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ContextEntityType;
import org.xbrl._2003.instance.ContextPeriodType;
import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.ContextEntityType.Identifier;
import org.xbrl._2006.xbrldi.ExplicitMember;
import org.xbrl._2006.xbrldi.TypedMember;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRGeneralData;
import in.armedu.banking.report.rbixbrl.model.cpr.CPRItemData;
import in.armedu.banking.report.rbixbrl.model.cpr.IndividualBorrower;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;
import in.armedu.banking.report.rbixbrl.part.ContextIntf;
import in.armedu.banking.report.rbixbrl.util.AsOfContext;
import in.armedu.banking.report.rbixbrl.util.FromToContext;

public class CPRIndividualContext implements ContextInterface {
    private ObjectFactory xbrlObjectFactory = new ObjectFactory();
    
    @Override
    public Map<String, Context> getContext(GeneralData generalData) {
        
        return null;
    }

    @Override
    public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {
        CPRGeneralData cprGeneralData = (CPRGeneralData) generalData;
        IndividualBorrower individualBorrower = (IndividualBorrower) itemData;
        Map<String, Context> itemContexts = new HashMap<String, Context>();
        // create context for individual borrower
        Context fromToContextForItemWithoutIndividual = CPRUtil.createFromToContextForBorrower(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), individualBorrower.getPanNumber(), individualBorrower.getBorrowerName(), individualBorrower.getIndustryCode(), individualBorrower.getIndustryName());
        itemContexts.put(CPRUtil.FROMTOITEMWOINDIVIDUAL ,fromToContextForItemWithoutIndividual);
        Context asOfContextForFundedForIndividual = CPRUtil.createAsOfContextForIndividualBorrower(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "FundedMember", individualBorrower.getPanNumber(), individualBorrower.getBorrowerName(), individualBorrower.getIndustryCode(), individualBorrower.getIndustryName());
        itemContexts.put(CPRUtil.ASOFITEMFORFUNDEDINDIVIDUAL ,asOfContextForFundedForIndividual);
        Context asOfContextForNonFundedForIndividual = CPRUtil.createAsOfContextForIndividualBorrower(cprGeneralData.getBankCode(), cprGeneralData.getDateOfReport(), "NonFundedMember", individualBorrower.getPanNumber(), individualBorrower.getBorrowerName(), individualBorrower.getIndustryCode(), individualBorrower.getIndustryName());
        itemContexts.put(CPRUtil.ASOFITEMFORNONFUNDEDINDIVIDUAL ,asOfContextForNonFundedForIndividual);
        Context fromToContextForItemForIndividual = CPRUtil.createFromToContextForIndividualBorrower(cprGeneralData.getBankCode(), cprGeneralData.getStartDate(), cprGeneralData.getEndDate(), individualBorrower.getPanNumber(), individualBorrower.getBorrowerName(), individualBorrower.getIndustryCode(), individualBorrower.getIndustryName());
        itemContexts.put(CPRUtil.FROMTOFORITEMWITHINDIVIDUAL ,fromToContextForItemForIndividual);
        
        return itemContexts;
    }

    
}
    
package in.armedu.banking.report.rbixbrl.part.pci.impl;

import java.util.HashMap;
import java.util.Map;

import org.xbrl._2003.instance.Context;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.pci.PCIGeneralData;
import in.armedu.banking.report.rbixbrl.model.pci.PCIItemData;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;

public class PCIGeneralContext implements ContextInterface  {
    

    @Override
    public Map<String, Context> getContext(GeneralData generalData) {
    PCIGeneralData pciGeneralData = (PCIGeneralData) generalData;
    Map<String, Context> contexts = new HashMap<String, Context>();

    // create fromto context
    Context fromToContext = PCIUtil.createFromToContext(pciGeneralData.getBankCode(), pciGeneralData.getReportingPeriodStartDate(), pciGeneralData.getReportForTheYearEnded(), null);
    contexts.put(PCIUtil.FROMTO, fromToContext);

    // create asof context
    Context asOfContext = PCIUtil.createAsOfContext(pciGeneralData.getBankCode(), pciGeneralData.getReportForTheYearEnded(), null);
    contexts.put(PCIUtil.ASOF , asOfContext);


    return contexts;
}

@Override
public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {
    PCIGeneralData pciGeneralData = (PCIGeneralData) generalData;
    PCIItemData pciItemData = (PCIItemData) itemData;
    Map<String, Context> contexts = new HashMap<String, Context>();

    // create fromto context MoreThanUSD2MillionMember
    Context fromToContextMoreThanUSD2MillionMember = PCIUtil.createFromToContextMoreThanUSD2MillionMember(pciGeneralData.getBankCode(), pciGeneralData.getReportingPeriodStartDate(), pciGeneralData.getReportForTheYearEnded(),
    pciItemData.getCustomerCreditLimitAxis(), pciItemData.getTypeOfProblemCreditAndInvestmentCustomerAxis(), pciItemData.getCountryCodeAxis(), pciItemData.getBranchCodeAxis(), pciItemData.getNameOfBorrowerAxis(),
    pciItemData.getBorrowerGroupNameAxis(), pciItemData.getIndustryCodeAxis() );
    contexts.put(PCIUtil.FROMTOMORETHANUSD2MILLIONMEMBER , fromToContextMoreThanUSD2MillionMember);

    // create asof context MoreThanUSD2MillionMember
    Context asofContextMoreThanUSD2MillionMember = PCIUtil.createAsOfContextMoreThanUSD2MillionMember( pciGeneralData.getBankCode(), pciGeneralData.getReportForTheYearEnded(), "MoreThanUSD2MillionMember", 
    pciItemData.getTypeOfProblemCreditAndInvestmentCustomerAxis(), pciItemData.getCountryCodeAxis(), pciItemData.getBranchCodeAxis(), pciItemData.getNameOfBorrowerAxis(), pciItemData.getBorrowerGroupNameAxis(), pciItemData.getIndustryCodeAxis());
    contexts.put(PCIUtil.ASOFMORETHANUSD2MILLIONMEMBER , asofContextMoreThanUSD2MillionMember);

    // create asof context MoreThanUSD2MillionMember ProblemCreditMember
    Context asofContextMoreThanUSD2MProblemCreditMember = PCIUtil.createAsOfContextMoreThanUSD2MillionMember( pciGeneralData.getBankCode(), pciGeneralData.getReportForTheYearEnded(), "MoreThanUSD2MillionMember", 
    pciItemData.getTypeOfProblemCreditAndInvestmentCustomerAxis(), pciItemData.getCountryCodeAxis(), pciItemData.getBranchCodeAxis(), null, null, null);
    contexts.put(PCIUtil.ASOFMORETHANUSD2MPROBLEMCREDITMEMBER , asofContextMoreThanUSD2MProblemCreditMember);
   
    // create fromto context LessThanUSD2MillionMember
    Context fromToContextLessThanUSD2MillionMember = PCIUtil.createFromToContextLessThanUSD2MillionMember(pciGeneralData.getBankCode(), pciGeneralData.getReportingPeriodStartDate(), pciGeneralData.getReportForTheYearEnded(),
    "LessThanUSD2MillionMember", pciItemData.getTypeOfProblemCreditAndInvestmentCustomerAxis(), pciItemData.getCountryCodeAxis(), pciItemData.getBranchCodeAxis());
    contexts.put(PCIUtil.FROMTOLESSTHANUSD2MILLIONMEMBER , fromToContextLessThanUSD2MillionMember);

    // create asof context LessThanUSD2MillionMember
    Context asofContextLessThanUSD2MillionMember = PCIUtil.createAsOfContextLessThanUSD2MillionMember( pciGeneralData.getBankCode(), pciGeneralData.getReportForTheYearEnded(), "LessThanUSD2MillionMember", 
    pciItemData.getTypeOfProblemCreditAndInvestmentCustomerAxis(), pciItemData.getCountryCodeAxis(), pciItemData.getBranchCodeAxis());
    contexts.put(PCIUtil.ASOFLESSTHANUSD2MILLIONMEMBER , asofContextLessThanUSD2MillionMember);
   
    // create fromto context MoreThanUSD1MiliionMember
    Context fromToContextMoreThanUSD1MiliionMember = PCIUtil.createFromToContextMoreThanUSD1MiliionMember(pciGeneralData.getBankCode(), pciGeneralData.getReportingPeriodStartDate(), pciGeneralData.getReportForTheYearEnded(),
    "MoreThanUSD1MiliionMember", pciItemData.getTypeOfProblemCreditAndInvestmentCustomerAxis(), pciItemData.getCountryCodeAxis(), pciItemData.getBranchCodeAxis(),  pciItemData.getNameOfIssuerAxis(), pciItemData.getIssuerGroupNameAxis());
    contexts.put(PCIUtil.FROMTOMORETHANUSD1MILIIONMEMBER , fromToContextMoreThanUSD1MiliionMember);

    // create asof context MoreThanUSD1MiliionMember
    Context asofContextMoreThanUSD1MiliionMember = PCIUtil.createAsOfContextMoreThanUSD1MiliionMember( pciGeneralData.getBankCode(), pciGeneralData.getReportForTheYearEnded(), "MoreThanUSD1MiliionMember", 
    pciItemData.getTypeOfProblemCreditAndInvestmentCustomerAxis(), pciItemData.getCountryCodeAxis(), pciItemData.getBranchCodeAxis(), pciItemData.getNameOfIssuerAxis(), pciItemData.getIssuerGroupNameAxis());
    contexts.put(PCIUtil.ASOFMORETHANUSD1MILIIONMEMBER , asofContextMoreThanUSD1MiliionMember);
 
    // create fromto context LessThanUSD1MiliionMember
    Context fromToContextLessThanUSD1MiliionMember = PCIUtil.createFromToContextLessThanUSD1MiliionMember(pciGeneralData.getBankCode(), pciGeneralData.getReportingPeriodStartDate(), pciGeneralData.getReportForTheYearEnded(),
    "LessThanUSD1MiliionMember", pciItemData.getTypeOfProblemCreditAndInvestmentCustomerAxis(), pciItemData.getCountryCodeAxis(), pciItemData.getBranchCodeAxis() );
    contexts.put(PCIUtil.FROMTOLESSTHANUSD1MILIIONMEMBER , fromToContextLessThanUSD1MiliionMember);

    // create asof context LessThanUSD1MiliionMember
    Context asofContextLessThanUSD1MiliionMember = PCIUtil.createAsOfContextLessThanUSD1MiliionMember( pciGeneralData.getBankCode(), pciGeneralData.getReportForTheYearEnded(), "LessThanUSD1MiliionMember", 
    pciItemData.getTypeOfProblemCreditAndInvestmentCustomerAxis(), pciItemData.getCountryCodeAxis(), pciItemData.getBranchCodeAxis());
    contexts.put(PCIUtil.ASOFLESSTHANUSD1MILIIONMEMBER , asofContextLessThanUSD1MiliionMember);
   

    // create asof context TypeOfProblemCreditAndInvestmentCustomer
    Context asofContextTypeOfProblemCreditAndInvestmentCustomer = PCIUtil.createAsOfContextLessThanUSD2MillionMember( pciGeneralData.getBankCode(), pciGeneralData.getReportForTheYearEnded(), 
    null, pciItemData.getTypeOfProblemCreditAndInvestmentCustomerAxis(), pciItemData.getCountryCodeAxis(), pciItemData.getBranchCodeAxis());
    contexts.put(PCIUtil.ASOFTYPEOFPROBLEMCREDITANDINVESTMENTCUSTOMER , asofContextTypeOfProblemCreditAndInvestmentCustomer);
    
    return contexts;

    }

}

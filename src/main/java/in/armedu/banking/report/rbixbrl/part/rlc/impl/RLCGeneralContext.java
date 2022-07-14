package in.armedu.banking.report.rbixbrl.part.rlc.impl;

import java.util.HashMap;
import java.util.Map;

import org.xbrl._2003.instance.Context;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
import in.armedu.banking.report.rbixbrl.model.rlc.RLCItem;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;

public class RLCGeneralContext implements ContextInterface {

    
    @Override
    public Map<String, Context> getContext(GeneralData generalData) {
    RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;
    Map<String, Context> contexts = new HashMap<String, Context>();

    // create fromto context
    Context fromToContext = RLCUtil.createFromToContext(rlcGeneralData.getBankCode(), rlcGeneralData.getReportingPeriodStartDate(), rlcGeneralData.getReportForTheYearEnded(), null);
    contexts.put(RLCUtil.FROMTO, fromToContext);

    // create asof context
    Context asOfContext = RLCUtil.createAsOfContext(rlcGeneralData.getBankCode(), rlcGeneralData.getReportForTheYearEnded(), null);
    contexts.put(RLCUtil.ASOF , asOfContext);

    // create end asof context
    Context asOfLastDateContext = RLCUtil.createAsOfEndDateContext(rlcGeneralData.getBankCode(), rlcGeneralData.getLastEndDate(), null);
    contexts.put(RLCUtil.ASOFLASTDATE , asOfLastDateContext);

    // create fromTo only IndividualGlobal
    Context fromToOnlyForIndividualGlobal = RLCUtil.createFromToContextForIndividualGlobal(rlcGeneralData.getBankCode(), rlcGeneralData.getReportingPeriodStartDate(), rlcGeneralData.getReportForTheYearEnded(), "GlobalMember", "IndividualBorrowersMember", null, null, null, null );
    contexts.put(RLCUtil.FROMTOONLYGLOBALINDIVIDUALMEMBER , fromToOnlyForIndividualGlobal);

    // create asof only IndividualGlobal
    Context asOfOnlyForIndividualGlobal = RLCUtil.createAsOfContextIndividualGlobal(rlcGeneralData.getBankCode(), rlcGeneralData.getReportForTheYearEnded(), "GlobalMember", "IndividualBorrowersMember", null, null, null, null );
    contexts.put(RLCUtil.ASOFONLYGLOBALINDIVIDUALMEMBER , asOfOnlyForIndividualGlobal);

    // create context for fromto only CounterParty Domestic
    Context fromToOnlyForCounterPartyDomestic = RLCUtil.createFromToContextForCounterParty(rlcGeneralData.getBankCode(), rlcGeneralData.getReportingPeriodStartDate(), rlcGeneralData.getReportForTheYearEnded(), "CounterPartyBankMember", "DomesticMember", null, null, null, null);
    contexts.put(RLCUtil.FROMTOONLYDOMESTICCOUNTERPARTY ,fromToOnlyForCounterPartyDomestic);

    // create context for asOf only CounterParty Domestic
    Context asOfOnlyForCounterPartyDomestic = RLCUtil.createAsOfContextCounterParty(rlcGeneralData.getBankCode(), rlcGeneralData.getReportForTheYearEnded(), "CounterPartyBankMember", "DomesticMember", null, null, null, null);
    contexts.put(RLCUtil.ASOFONLYDOMESTICCOUNTERPARTY ,asOfOnlyForCounterPartyDomestic);

    // create asof only BorrowerGroupGlobal
    Context asOfOnlyForBorrowerGroupGlobal = RLCUtil.createAsOfContextBorrowerGroupGlobal(rlcGeneralData.getBankCode(), rlcGeneralData.getReportForTheYearEnded(), "BorrowerGroupMember", "GlobalMember", null, null, null, null, null, null);
    contexts.put(RLCUtil.ASOFONLYGLOBALBORROWERGROUP , asOfOnlyForBorrowerGroupGlobal);

    // create context for fromto CounterParty Domestic
    Context fromToContextForCounterPartyDomestic = RLCUtil.createFromToContextForCounterParty(rlcGeneralData.getBankCode(), rlcGeneralData.getReportingPeriodStartDate(), rlcGeneralData.getReportForTheYearEnded(), "CounterPartyBankMember", "DomesticMember", null, null, null, null );
    contexts.put(RLCUtil.FROMTODOMESTICCOUNTERPARTY ,fromToContextForCounterPartyDomestic);

    // create context for fromto only CounterParty Global
    Context fromToOnlyForCounterPartyGlobal = RLCUtil.createFromToContextForCounterParty(rlcGeneralData.getBankCode(), rlcGeneralData.getReportingPeriodStartDate(), rlcGeneralData.getReportForTheYearEnded(), "CounterPartyBankMember", null, "GlobalMember",  null, null, null );
    contexts.put(RLCUtil.FROMTOONLYGLOBALCOUNTERPARTY , fromToOnlyForCounterPartyGlobal);

    // create context for asOf only CounterParty Global
    Context asOfOnlyCounterPartyGlobal = RLCUtil.createAsOfContextCounterParty(rlcGeneralData.getBankCode(), rlcGeneralData.getReportForTheYearEnded(), "CounterPartyBankMember", null, "GlobalMember", null, null, null );
    contexts.put(RLCUtil.ASOFONLYGLOBALCOUNTERPARTY , asOfOnlyCounterPartyGlobal);


    return contexts;
}

@Override
public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {
    RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;
    RLCItem rlcItemData = (RLCItem) itemData;
    Map<String, Context> itemContexts = new HashMap<String, Context>();

    // create context for fromto IndividualGlobal
    Context fromToContextForIndividualGlobal = RLCUtil.createFromToContextForIndividualGlobal(rlcGeneralData.getBankCode(), rlcGeneralData.getReportingPeriodStartDate(), rlcGeneralData.getReportForTheYearEnded(), "GlobalMember", "IndividualBorrowersMember", rlcItemData.getRlcIndividualMember().getUniqueTransactionCodeAxis(), 
    rlcItemData.getRlcIndividualMember().getIndustryCodeAxis(), rlcItemData.getRlcIndividualMember().getIndustryNameAxis(), rlcItemData.getRlcIndividualMember().getLeadBankNameAxis());
    itemContexts.put(RLCUtil.FROMTOGLOBALINDIVIDUALMEMBER ,fromToContextForIndividualGlobal);

    // create context for asof IndividualGlobal
    Context asOfContextForIndividualGlobal = RLCUtil.createAsOfContextIndividualGlobal(rlcGeneralData.getBankCode(), rlcGeneralData.getReportForTheYearEnded(), "GlobalMember", "IndividualBorrowersMember", rlcItemData.getRlcIndividualMember().getUniqueTransactionCodeAxis(), 
    rlcItemData.getRlcIndividualMember().getIndustryCodeAxis(), rlcItemData.getRlcIndividualMember().getIndustryNameAxis(), rlcItemData.getRlcIndividualMember().getLeadBankNameAxis());
    itemContexts.put(RLCUtil.ASOFGLOBALINDIVIDUALMEMBER , asOfContextForIndividualGlobal);

    // create context for fromto Borrower Group Global
    Context fromToContextForBorrowerGroupGlobal = RLCUtil.createFromToContextForBorrowerGroupGlobal(rlcGeneralData.getBankCode(), rlcGeneralData.getReportingPeriodStartDate(), rlcGeneralData.getReportForTheYearEnded(), "BorrowerGroupMember", "GlobalMember", rlcItemData.getRlcBorrowerGroupMember().getUniqueTransactionCodeAxis(), 
    rlcItemData.getRlcBorrowerGroupMember().getGroupBorrowerCode(), rlcItemData.getRlcBorrowerGroupMember().getGroupAxis(), rlcItemData.getRlcBorrowerGroupMember().getIndustryCodeAxis(), rlcItemData.getRlcBorrowerGroupMember().getIndustryNameAxis(), rlcItemData.getRlcBorrowerGroupMember().getLeadBankNameAxis());
    itemContexts.put(RLCUtil.FROMTOGLOBALBORROWERGROUP ,fromToContextForBorrowerGroupGlobal);

    // create context for asof BorrowerGroupGlobal
    Context asOfContextForBorrowerGroupGlobal = RLCUtil.createAsOfContextBorrowerGroupGlobal(rlcGeneralData.getBankCode(), rlcGeneralData.getReportForTheYearEnded(), "BorrowerGroupMember", "GlobalMember", rlcItemData.getRlcBorrowerGroupMember().getUniqueTransactionCodeAxis(), 
    rlcItemData.getRlcBorrowerGroupMember().getGroupBorrowerCode(), rlcItemData.getRlcBorrowerGroupMember().getGroupAxis(), rlcItemData.getRlcBorrowerGroupMember().getIndustryCodeAxis(), rlcItemData.getRlcBorrowerGroupMember().getIndustryNameAxis(), rlcItemData.getRlcBorrowerGroupMember().getLeadBankNameAxis());
    itemContexts.put(RLCUtil.ASOFGLOBALBORROWERGROUP , asOfContextForBorrowerGroupGlobal);

    // create fromTo only BorrowerGroupGlobal
    Context fromToOnlyForBorrowerGroupGlobal = RLCUtil.createFromToContextForBorrowerGroupGlobal(rlcGeneralData.getBankCode(), rlcGeneralData.getReportingPeriodStartDate(), rlcGeneralData.getReportForTheYearEnded(), "BorrowerGroupMember", "GlobalMember", null, null, null, null, null, null);
    itemContexts.put(RLCUtil.FROMTOONLYGLOBALBORROWERGROUP , fromToOnlyForBorrowerGroupGlobal);

    // create context for asof CounterParty Domestic
    Context asOfContextForCounterPartyDomestic = RLCUtil.createAsOfContextCounterParty(rlcGeneralData.getBankCode(), rlcGeneralData.getReportForTheYearEnded(), "CounterPartyBankMember", "DomesticMember",
    null, rlcItemData.getRlcCounterPartyDomestic().getCounterPartyBankNameAxis(), rlcItemData.getRlcCounterPartyDomestic().getCounterPartyBankDomicileAxis(), rlcItemData.getRlcCounterPartyDomestic().getUniqueTransactionCodeAxis());
    itemContexts.put(RLCUtil.ASOFDOMESTICCOUNTERPARTY , asOfContextForCounterPartyDomestic);

    // create context for fromto CounterParty Global
    Context fromToContextForCounterPartyGlobal = RLCUtil.createFromToContextForCounterParty(rlcGeneralData.getBankCode(), rlcGeneralData.getReportingPeriodStartDate(), rlcGeneralData.getReportForTheYearEnded(), "CounterPartyBankMember", null, "GlobalMember",
    rlcItemData.getRlcCounterPartyGlobal().getCounterPartyBankNameAxis(), rlcItemData.getRlcCounterPartyGlobal().getCounterPartyBankDomicileAxis(), rlcItemData.getRlcCounterPartyGlobal().getUniqueTransactionCodeAxis());
    itemContexts.put(RLCUtil.FROMTOGLOBALCOUNTERPARTY ,fromToContextForCounterPartyGlobal);

    // create context for asof CounterParty Global
    Context asOfContextForCounterPartyGlobal = RLCUtil.createAsOfContextCounterParty(rlcGeneralData.getBankCode(), rlcGeneralData.getReportForTheYearEnded(), "CounterPartyBankMember", null, "GlobalMember",
    rlcItemData.getRlcCounterPartyGlobal().getCounterPartyBankNameAxis(), rlcItemData.getRlcCounterPartyGlobal().getCounterPartyBankDomicileAxis(), rlcItemData.getRlcCounterPartyGlobal().getUniqueTransactionCodeAxis());
    itemContexts.put(RLCUtil.ASOFGLOBALCOUNTERPARTY , asOfContextForCounterPartyGlobal);


    return itemContexts;
}

}

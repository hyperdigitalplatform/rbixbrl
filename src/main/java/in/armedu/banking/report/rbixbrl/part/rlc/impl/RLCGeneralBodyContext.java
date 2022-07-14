// package in.armedu.banking.report.rbixbrl.part.rlc.impl;

// import java.util.HashMap;
// import java.util.Map;

// import org.xbrl._2003.instance.Context;

// import in.armedu.banking.report.rbixbrl.model.GeneralData;
// import in.armedu.banking.report.rbixbrl.model.ItemData;
// import in.armedu.banking.report.rbixbrl.model.rlc.RLCGeneralData;
// import in.armedu.banking.report.rbixbrl.model.rlc.RLCItem;
// import in.armedu.banking.report.rbixbrl.part.ContextInterface;

// public class RLCGeneralBodyContext implements ContextInterface {

    
//     @Override
//     public Map<String, Context> getContext(GeneralData generalData) {
//     RLCGeneralData rlcGeneralData = (RLCGeneralData) generalData;
//     Map<String, Context> contexts = new HashMap<String, Context>();


//     // create fromTo only IndividualGlobal
//     Context fromToOnlyForIndividualGlobal = RLCUtil.createFromToContextForIndividualGlobal(rlcGeneralData.getBankCode(), rlcGeneralData.getReportingPeriodStartDate(), rlcGeneralData.getReportForTheYearEnded(), "GlobalMember", "IndividualBorrowersMember", null, null, null, null );
//     contexts.put(RLCUtil.FROMTOONLYGLOBALINDIVIDUALMEMBER , fromToOnlyForIndividualGlobal);

//     // create asof only IndividualGlobal
//     Context asOfOnlyForIndividualGlobal = RLCUtil.createAsOfContextIndividualGlobal(rlcGeneralData.getBankCode(), rlcGeneralData.getReportForTheYearEnded(), "GlobalMember", "IndividualBorrowersMember", null, null, null, null );
//     contexts.put(RLCUtil.ASOFONLYGLOBALINDIVIDUALMEMBER , asOfOnlyForIndividualGlobal);

//     // create context for fromto only CounterParty Domestic
//     Context fromToOnlyForCounterPartyDomestic = RLCUtil.createFromToContextForCounterParty(rlcGeneralData.getBankCode(), rlcGeneralData.getReportingPeriodStartDate(), rlcGeneralData.getReportForTheYearEnded(), "CounterPartyBankMember", "DomesticMember", null, null, null, null);
//     contexts.put(RLCUtil.FROMTOONLYDOMESTICCOUNTERPARTY ,fromToOnlyForCounterPartyDomestic);

//     // create context for asOf only CounterParty Domestic
//     Context asOfOnlyForCounterPartyDomestic = RLCUtil.createAsOfContextCounterParty(rlcGeneralData.getBankCode(), rlcGeneralData.getReportForTheYearEnded(), "CounterPartyBankMember", "DomesticMember", null, null, null, null);
//     contexts.put(RLCUtil.ASOFONLYDOMESTICCOUNTERPARTY ,asOfOnlyForCounterPartyDomestic);

//     // create asof only BorrowerGroupGlobal
//     Context asOfOnlyForBorrowerGroupGlobal = RLCUtil.createAsOfContextBorrowerGroupGlobal(rlcGeneralData.getBankCode(), rlcGeneralData.getReportForTheYearEnded(), "BorrowerGroupMember", "GlobalMember", null, null, null, null, null, null);
//     contexts.put(RLCUtil.ASOFONLYGLOBALBORROWERGROUP , asOfOnlyForBorrowerGroupGlobal);

//     // create context for fromto CounterParty Domestic
//     Context fromToContextForCounterPartyDomestic = RLCUtil.createFromToContextForCounterParty(rlcGeneralData.getBankCode(), rlcGeneralData.getReportingPeriodStartDate(), rlcGeneralData.getReportForTheYearEnded(), "CounterPartyBankMember", "DomesticMember", null, null, null, null );
//     contexts.put(RLCUtil.FROMTODOMESTICCOUNTERPARTY ,fromToContextForCounterPartyDomestic);

//     // create context for fromto only CounterParty Global
//     Context fromToOnlyForCounterPartyGlobal = RLCUtil.createFromToContextForCounterParty(rlcGeneralData.getBankCode(), rlcGeneralData.getReportingPeriodStartDate(), rlcGeneralData.getReportForTheYearEnded(), "CounterPartyBankMember", null, "GlobalMember",  null, null, null );
//     contexts.put(RLCUtil.FROMTOONLYGLOBALCOUNTERPARTY , fromToOnlyForCounterPartyGlobal);

//     // create context for asOf only CounterParty Global
//     Context asOfOnlyCounterPartyGlobal = RLCUtil.createAsOfContextCounterParty(rlcGeneralData.getBankCode(), rlcGeneralData.getReportForTheYearEnded(), "CounterPartyBankMember", null, "GlobalMember", null, null, null );
//     contexts.put(RLCUtil.ASOFONLYGLOBALCOUNTERPARTY , asOfOnlyCounterPartyGlobal);


//     return contexts;
// }

// @Override
// public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {

//     return null;
// }

// }

package in.armedu.banking.report.rbixbrl.part.alo.impl;

import java.util.HashMap;
import java.util.Map;

import org.xbrl._2003.instance.Context;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.alo.ALOGeneralData;
import in.armedu.banking.report.rbixbrl.model.alo.ALOItemData;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;

public class ALOGeneralContext implements ContextInterface {

        @Override
        public Map<String, Context> getContext(GeneralData generalData) {
        ALOGeneralData aloGeneralData = (ALOGeneralData) generalData;
        Map<String, Context> contexts = new HashMap<String, Context>();

        // create fromto context
        Context fromToContext = ALOUtil.createFromToContext(aloGeneralData.getBankCode(), aloGeneralData.getReportingPeriodStartDate(), aloGeneralData.getDateOfQuarterEnded(), null);
        contexts.put(ALOUtil.FROMTO, fromToContext);

        // create asof context
        Context asOfContext = ALOUtil.createAsOfContext(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), null);
        contexts.put(ALOUtil.ASOF , asOfContext);


        return contexts;
    }

    @Override
    public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {
     ALOGeneralData aloGeneralData = (ALOGeneralData) generalData;
        ALOItemData aloItemData = (ALOItemData) itemData;
        Map<String, Context> contexts = new HashMap<String, Context>();

        // create asof context AccountsWithin BanksMember
        Context asofContextOneToTwentyEightDaysMember = ALOUtil.createAsOfContextForReportingPeriod(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "OneToTwentyEightDaysMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFONETOTWENTYEIGHTDAYSMEMBER , asofContextOneToTwentyEightDaysMember);

        Context asofContextTwentyNineDaysAndUptoThreeMonthsMember = ALOUtil.createAsOfContextForReportingPeriod(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "TwentyNineDaysAndUptoThreeMonthsMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFTWENTYNINEDAYSANDUPTOTHREEMONTHSMEMBER , asofContextTwentyNineDaysAndUptoThreeMonthsMember);

        Context asofContextOverThreeMonthsAndUptoSixMonthsMember = ALOUtil.createAsOfContextForReportingPeriod(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "OverThreeMonthsAndUptoSixMonthsMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFOVERTHREEMONTHSANDUPTOSIXMONTHSMEMBER , asofContextOverThreeMonthsAndUptoSixMonthsMember);

        Context asofContextOverSixMonthsAndUptoOneYearMember = ALOUtil.createAsOfContextForReportingPeriod(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "OverSixMonthsAndUptoOneYearMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFOVERSIXMONTHSANDUPTOONEYEARMEMBER , asofContextOverSixMonthsAndUptoOneYearMember);

        Context asofContextOverOneYearUptoAndThreeYearMember = ALOUtil.createAsOfContextForReportingPeriod(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "OverOneYearUptoAndThreeYearMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFOVERONEYEARUPTOANDTHREEYEARMEMBER , asofContextOverOneYearUptoAndThreeYearMember);

        Context asofContextOverThreeYearsAndUptoFiveYearMember = ALOUtil.createAsOfContextForReportingPeriod(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "OverThreeYearsAndUptoFiveYearMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFOVERTHREEYEARSANDUPTOFIVEYEARMEMBER , asofContextOverThreeYearsAndUptoFiveYearMember);

        Context asofContextOverFiveYearsMember = ALOUtil.createAsOfContextForReportingPeriod(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "OverFiveYearsMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFOVERFIVEYEARSMEMBER , asofContextOverFiveYearsMember);

        Context asofContextNonSensitiveMember = ALOUtil.createAsOfContextForReportingPeriod(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "NonSensitiveMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFNONSENSITIVEMEMBER , asofContextNonSensitiveMember);

        Context asofContextReporting = ALOUtil.createAsOfContextForTypedMembers(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFREPORTINGPERIOD , asofContextReporting);

        // create asof context Account with Other Members
        Context asofContextAccountWithMemberOverThreeMonthsAndUptoSixMonthsMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherBranchesMember", "OverThreeMonthsAndUptoSixMonthsMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTWITHMEMBEROVERTHREEMONTHSANDUPTOSIXMONTHSMEMBER , asofContextAccountWithMemberOverThreeMonthsAndUptoSixMonthsMember);
        
        Context asofContextAccountWithMemberOverSixMonthsUptoTwelveMonthsMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherBranchesMember", "OverSixMonthsUptoTwelveMonthsMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTWITHMEMBEROVERSIXMONTHSUPTOTWELVEMONTHSMEMBER , asofContextAccountWithMemberOverSixMonthsUptoTwelveMonthsMember);
        
        Context asofContextAccountWithMemberOverOneYearUptoAndTwoYearMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherBranchesMember", "OverOneYearUptoAndTwoYearMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTWITHMEMBEROVERONEYEARUPTOANDTWOYEARMEMBER , asofContextAccountWithMemberOverOneYearUptoAndTwoYearMember);
        
        Context asofContextAccountWithMemberOverTwoYearMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherBranchesMember", "OverTwoYearMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTWITHMEMBEROVERTWOYEARMEMBER , asofContextAccountWithMemberOverTwoYearMember);
        
        Context asofContextAccountWithMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherBranchesMember", null, aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTWITHMEMBER, asofContextAccountWithMember);
        
        Context asofContextAccountsWithOtherIndianOverThreeMonthsAndUptoSixMonthsMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherIndianBankBranchesInSameForeignCenterMember", "OverThreeMonthsAndUptoSixMonthsMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTSWITHOTHERINDIANOVERTHREEMONTHSANDUPTOSIXMONTHSMEMBER , asofContextAccountsWithOtherIndianOverThreeMonthsAndUptoSixMonthsMember);
        
        Context asofContextAccountsWithOtherIndianOverSixMonthsUptoTwelveMonthsMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherIndianBankBranchesInSameForeignCenterMember", "OverSixMonthsUptoTwelveMonthsMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTSWITHOTHERINDIANOVERSIXMONTHSUPTOTWELVEMONTHSMEMBER , asofContextAccountsWithOtherIndianOverSixMonthsUptoTwelveMonthsMember);
         
        Context asofContextAccountsWithOtherIndianOverOneYearUptoAndTwoYearMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherIndianBankBranchesInSameForeignCenterMember", "OverOneYearUptoAndTwoYearMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTSWITHOTHERINDIANOVERONEYEARUPTOANDTWOYEARMEMBER , asofContextAccountsWithOtherIndianOverOneYearUptoAndTwoYearMember);
         
        Context asofContextAccountsWithOtherIndianOverTwoYearMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherIndianBankBranchesInSameForeignCenterMember", "OverTwoYearMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTSWITHOTHERINDIANOVERTWOYEARMEMBER , asofContextAccountsWithOtherIndianOverTwoYearMember);
        
        Context asofContextAccountsWithOtherIndianMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherIndianBankBranchesInSameForeignCenterMember", null, aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTSWITHOTHERINDIANMEMBER , asofContextAccountsWithOtherIndianMember);
        
        Context asofContextAccountsWithOtherBanksOverThreeMonthsAndUptoSixMonthsMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherBanksMember", "OverThreeMonthsAndUptoSixMonthsMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTSWITHOTHERBANKSOVERTHREEMONTHSANDUPTOSIXMONTHSMEMBER , asofContextAccountsWithOtherBanksOverThreeMonthsAndUptoSixMonthsMember);
        
        Context asofContextAccountsWithOtherBanksOverSixMonthsUptoTwelveMonthsMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherBanksMember", "OverSixMonthsUptoTwelveMonthsMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTSWITHOTHERBANKSOVERSIXMONTHSUPTOTWELVEMONTHSMEMBER , asofContextAccountsWithOtherBanksOverSixMonthsUptoTwelveMonthsMember);
         
        Context asofContextAccountsWithOtherBanksOverOneYearUptoAndTwoYearMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherBanksMember", "OverOneYearUptoAndTwoYearMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTSWITHOTHERBANKSOVERONEYEARUPTOANDTWOYEARMEMBER , asofContextAccountsWithOtherBanksOverOneYearUptoAndTwoYearMember);
         
        Context asofContextAccountsWithOtherBanksOverTwoYearMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherBanksMember", "OverTwoYearMember", aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTSWITHOTHERBANKSOVERTWOYEARMEMBER , asofContextAccountsWithOtherBanksOverTwoYearMember);
         
        Context asofContextAccountsWithOtherBanksMember = ALOUtil.createAsOfContextForAccountWithMember(aloGeneralData.getBankCode(), aloGeneralData.getDateOfQuarterEnded(), "AccountsWithOtherBanksMember", null, aloItemData.getCountryCodeAxis(), aloItemData.getBranchCodeAxis());
        contexts.put(ALOUtil.ASOFCONTEXTACCOUNTSWITHOTHERBANKSMEMBER, asofContextAccountsWithOtherBanksMember);
 
        return contexts;

        }

}
package in.armedu.banking.report.rbixbrl.part.alo.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.JAXBElement;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.IntegerItemType;
import org.xbrl.dtr.type.numeric.PercentItemType;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.alo.ALOItemData;
import in.armedu.banking.report.rbixbrl.model.alo.ALOGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class ALOBody  implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData) {
        return null;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData, ItemData itemData) {

        ALOGeneralData aloGeneralData = (ALOGeneralData) generalData;
        ALOItemData aloItem = (ALOItemData) itemData;

        List<Object> bodyItems = new ArrayList<Object>();
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        Context fromToContext = contexts.get(ALOUtil.FROMTO);
        Context asOfContext = contexts.get(ALOUtil.ASOF);
        Unit currency = units.get(ALOUtil.CURRENCY);
        Unit percentage = units.get(ALOUtil.PERCENTAGE);
        Context asofreportingperiod = contexts.get(ALOUtil.ASOFREPORTINGPERIOD);
        Context asofaccountwithmember = contexts.get(ALOUtil.ASOFACCOUNTWITHMEMBER);

        // create CashAndBalancesWithCentralBanks
        MonetaryItemType cashAndBalancesWithCentralBanksValue = new MonetaryItemType();
        cashAndBalancesWithCentralBanksValue.setContextRef(asofreportingperiod);        
        cashAndBalancesWithCentralBanksValue.setUnitRef(currency);
        cashAndBalancesWithCentralBanksValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getCashAndBalancesWithCentralBanks())));
        cashAndBalancesWithCentralBanksValue.setValue(new BigDecimal(aloItem.getCashAndBalancesWithCentralBanks()));
        JAXBElement<MonetaryItemType> cashAndBalancesWithCentralBanks = rbiObjectFactory.createCashAndBalancesWithCentralBanks(cashAndBalancesWithCentralBanksValue);
        bodyItems.add(cashAndBalancesWithCentralBanks);

        // create InvestmentsInSecurities
        MonetaryItemType investmentsInSecuritiesValue = new MonetaryItemType();
        investmentsInSecuritiesValue.setContextRef(asofreportingperiod);        
        investmentsInSecuritiesValue.setUnitRef(currency);
        investmentsInSecuritiesValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInvestmentsInSecurities())));
        investmentsInSecuritiesValue.setValue(new BigDecimal(aloItem.getInvestmentsInSecurities()));
        JAXBElement<MonetaryItemType> investmentsInSecurities = rbiObjectFactory.createInvestmentsInSecurities(investmentsInSecuritiesValue);
        bodyItems.add(investmentsInSecurities);

        // create InvestmentsInLocalGovernments
        MonetaryItemType investmentsInLocalGovernmentsValue = new MonetaryItemType();
        investmentsInLocalGovernmentsValue.setContextRef(asofreportingperiod);       
        investmentsInLocalGovernmentsValue.setUnitRef(currency);
        investmentsInLocalGovernmentsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInvestmentsInLocalGovernments())));
        investmentsInLocalGovernmentsValue.setValue(new BigDecimal(aloItem.getInvestmentsInLocalGovernments()));
        JAXBElement<MonetaryItemType> investmentsInLocalGovernments = rbiObjectFactory.createInvestmentsInLocalGovernments(investmentsInLocalGovernmentsValue);
        bodyItems.add(investmentsInLocalGovernments);

        // create InvestmentsInIndia
        MonetaryItemType investmentsInIndiaValue = new MonetaryItemType();
        investmentsInIndiaValue.setContextRef(asofreportingperiod);       
        investmentsInIndiaValue.setUnitRef(currency);
        investmentsInIndiaValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInvestmentsInIndia())));
        investmentsInIndiaValue.setValue(new BigDecimal(aloItem.getInvestmentsInIndia()));
        JAXBElement<MonetaryItemType> investmentsInIndia = rbiObjectFactory.createInvestmentsInIndia(investmentsInIndiaValue);
        bodyItems.add(investmentsInIndia);

        // create InvestmentsInOECDCountries
        MonetaryItemType investmentsInOECDCountriesValue = new MonetaryItemType();
        investmentsInOECDCountriesValue.setContextRef(asofreportingperiod);       
        investmentsInOECDCountriesValue.setUnitRef(currency);
        investmentsInOECDCountriesValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInvestmentsInOECDCountries())));
        investmentsInOECDCountriesValue.setValue(new BigDecimal(aloItem.getInvestmentsInOECDCountries()));
        JAXBElement<MonetaryItemType> investmentsInOECDCountries = rbiObjectFactory.createInvestmentsInOECDCountries(investmentsInOECDCountriesValue);
        bodyItems.add(investmentsInOECDCountries);

        // create OtherInvestments
        MonetaryItemType otherInvestmentsValue = new MonetaryItemType();
        otherInvestmentsValue.setContextRef(asofreportingperiod);       
        otherInvestmentsValue.setUnitRef(currency);
        otherInvestmentsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getOtherInvestments())));
        otherInvestmentsValue.setValue(new BigDecimal(aloItem.getOtherInvestments()));
        JAXBElement<MonetaryItemType> otherInvestments = rbiObjectFactory.createOtherInvestments(otherInvestmentsValue);
        bodyItems.add(otherInvestments);

        // create InterBranchPlacementsOrDeposits
        MonetaryItemType interBranchPlacementsOrDepositsValue = new MonetaryItemType();
        interBranchPlacementsOrDepositsValue.setContextRef(asofreportingperiod);       
        interBranchPlacementsOrDepositsValue.setUnitRef(currency);
        interBranchPlacementsOrDepositsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBranchPlacementsOrDeposits())));
        interBranchPlacementsOrDepositsValue.setValue(new BigDecimal(aloItem.getInterBranchPlacementsOrDeposits()));
        JAXBElement<MonetaryItemType> interBranchPlacementsOrDeposits = rbiObjectFactory.createInterBranchPlacementsOrDeposits(interBranchPlacementsOrDepositsValue);
        bodyItems.add(interBranchPlacementsOrDeposits);

        // create InterBranchPlacementsOrDepositsWithBranchesInSameForeignCentre
        MonetaryItemType interBranchPlacementsOrDepositsWithBranchesInSameForeignCentreValue = new MonetaryItemType();
        interBranchPlacementsOrDepositsWithBranchesInSameForeignCentreValue.setContextRef(asofreportingperiod);       
        interBranchPlacementsOrDepositsWithBranchesInSameForeignCentreValue.setUnitRef(currency);
        interBranchPlacementsOrDepositsWithBranchesInSameForeignCentreValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBranchPlacementsOrDepositsWithBranchesInSameForeignCentre())));
        interBranchPlacementsOrDepositsWithBranchesInSameForeignCentreValue.setValue(new BigDecimal(aloItem.getInterBranchPlacementsOrDepositsWithBranchesInSameForeignCentre()));
        JAXBElement<MonetaryItemType> interBranchPlacementsOrDepositsWithBranchesInSameForeignCentre = rbiObjectFactory.createInterBranchPlacementsOrDepositsWithBranchesInSameForeignCentre(interBranchPlacementsOrDepositsWithBranchesInSameForeignCentreValue);
        bodyItems.add(interBranchPlacementsOrDepositsWithBranchesInSameForeignCentre);

        // create InterBranchPlacementsOrDepositsWithBranchesInOtherForeignCentre
        MonetaryItemType interBranchPlacementsOrDepositsWithBranchesInOtherForeignCentreValue = new MonetaryItemType();
        interBranchPlacementsOrDepositsWithBranchesInOtherForeignCentreValue.setContextRef(asofreportingperiod);       
        interBranchPlacementsOrDepositsWithBranchesInOtherForeignCentreValue.setUnitRef(currency);
        interBranchPlacementsOrDepositsWithBranchesInOtherForeignCentreValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBranchPlacementsOrDepositsWithBranchesInOtherForeignCentre())));
        interBranchPlacementsOrDepositsWithBranchesInOtherForeignCentreValue.setValue(new BigDecimal(aloItem.getInterBranchPlacementsOrDepositsWithBranchesInOtherForeignCentre()));
        JAXBElement<MonetaryItemType> interBranchPlacementsOrDepositsWithBranchesInOtherForeignCentre = rbiObjectFactory.createInterBranchPlacementsOrDepositsWithBranchesInOtherForeignCentre(interBranchPlacementsOrDepositsWithBranchesInOtherForeignCentreValue);
        bodyItems.add(interBranchPlacementsOrDepositsWithBranchesInOtherForeignCentre);

        // create interBranchPlacementsOrDepositsWithIndiaBranches
        MonetaryItemType interBranchPlacementsOrDepositsWithIndiaBranchesValue = new MonetaryItemType();
        interBranchPlacementsOrDepositsWithIndiaBranchesValue.setContextRef(asofreportingperiod);       
        interBranchPlacementsOrDepositsWithIndiaBranchesValue.setUnitRef(currency);
        interBranchPlacementsOrDepositsWithIndiaBranchesValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBranchPlacementsOrDepositsWithIndiaBranches())));
        interBranchPlacementsOrDepositsWithIndiaBranchesValue.setValue(new BigDecimal(aloItem.getInterBranchPlacementsOrDepositsWithIndiaBranches()));
        JAXBElement<MonetaryItemType> interBranchPlacementsOrDepositsWithIndiaBranches = rbiObjectFactory.createInterBranchPlacementsOrDepositsWithIndiaBranches(interBranchPlacementsOrDepositsWithIndiaBranchesValue);
        bodyItems.add(interBranchPlacementsOrDepositsWithIndiaBranches);

        // create InterBankPlacementsOrDeposits
        MonetaryItemType interBankPlacementsOrDepositsValue = new MonetaryItemType();
        interBankPlacementsOrDepositsValue.setContextRef(asofreportingperiod);       
        interBankPlacementsOrDepositsValue.setUnitRef(currency);
        interBankPlacementsOrDepositsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBankPlacementsOrDeposits())));
        interBankPlacementsOrDepositsValue.setValue(new BigDecimal(aloItem.getInterBankPlacementsOrDeposits()));
        JAXBElement<MonetaryItemType> interBankPlacementsOrDeposits = rbiObjectFactory.createInterBankPlacementsOrDeposits(interBankPlacementsOrDepositsValue);
        bodyItems.add(interBankPlacementsOrDeposits);

        // create InterBankPlacementsOrDepositsInCurrentAccounts
        MonetaryItemType interBankPlacementsOrDepositsInCurrentAccountsValue = new MonetaryItemType();
        interBankPlacementsOrDepositsInCurrentAccountsValue.setContextRef(asofreportingperiod);       
        interBankPlacementsOrDepositsInCurrentAccountsValue.setUnitRef(currency);
        interBankPlacementsOrDepositsInCurrentAccountsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBankPlacementsOrDepositsInCurrentAccounts())));
        interBankPlacementsOrDepositsInCurrentAccountsValue.setValue(new BigDecimal(aloItem.getInterBankPlacementsOrDepositsInCurrentAccounts()));
        JAXBElement<MonetaryItemType> interBankPlacementsOrDepositsInCurrentAccounts = rbiObjectFactory.createInterBankPlacementsOrDepositsInCurrentAccounts(interBankPlacementsOrDepositsInCurrentAccountsValue);
        bodyItems.add(interBankPlacementsOrDepositsInCurrentAccounts);

        // create interBankPlacementsInOtherDeposits
        MonetaryItemType interBankPlacementsInOtherDepositsValue = new MonetaryItemType();
        interBankPlacementsInOtherDepositsValue.setContextRef(asofreportingperiod);       
        interBankPlacementsInOtherDepositsValue.setUnitRef(currency);
        interBankPlacementsInOtherDepositsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBankPlacementsInOtherDeposits())));
        interBankPlacementsInOtherDepositsValue.setValue(new BigDecimal(aloItem.getInterBankPlacementsInOtherDeposits()));
        JAXBElement<MonetaryItemType> interBankPlacementsInOtherDeposits = rbiObjectFactory.createInterBankPlacementsInOtherDeposits(interBankPlacementsInOtherDepositsValue);
        bodyItems.add(interBankPlacementsInOtherDeposits);

        // create GrossCustomerCredit
        MonetaryItemType grossCustomerCreditValue = new MonetaryItemType();
        grossCustomerCreditValue.setContextRef(asofreportingperiod);       
        grossCustomerCreditValue.setUnitRef(currency);
        grossCustomerCreditValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getGrossCustomerCredit())));
        grossCustomerCreditValue.setValue(new BigDecimal(aloItem.getGrossCustomerCredit()));
        JAXBElement<MonetaryItemType> grossCustomerCredit = rbiObjectFactory.createGrossCustomerCredit(grossCustomerCreditValue);
        bodyItems.add(grossCustomerCredit);

        // create LoansOrOverdrafts
        MonetaryItemType loansOrOverdraftsValue = new MonetaryItemType();
        loansOrOverdraftsValue.setContextRef(asofreportingperiod);       
        loansOrOverdraftsValue.setUnitRef(currency);
        loansOrOverdraftsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getLoansOrOverdrafts())));
        loansOrOverdraftsValue.setValue(new BigDecimal(aloItem.getLoansOrOverdrafts()));
        JAXBElement<MonetaryItemType> loansOrOverdrafts = rbiObjectFactory.createLoansOrOverdrafts(loansOrOverdraftsValue);
        bodyItems.add(loansOrOverdrafts);

        // create LoansAgainstDepositsOrSecuritiesHeldIn
        MonetaryItemType loansAgainstDepositsOrSecuritiesHeldInValue = new MonetaryItemType();
        loansAgainstDepositsOrSecuritiesHeldInValue.setContextRef(asofreportingperiod);       
        loansAgainstDepositsOrSecuritiesHeldInValue.setUnitRef(currency);
        loansAgainstDepositsOrSecuritiesHeldInValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getLoansAgainstDepositsOrSecuritiesHeldIn())));
        loansAgainstDepositsOrSecuritiesHeldInValue.setValue(new BigDecimal(aloItem.getLoansAgainstDepositsOrSecuritiesHeldIn()));
        JAXBElement<MonetaryItemType> loansAgainstDepositsOrSecuritiesHeldIn = rbiObjectFactory.createLoansAgainstDepositsOrSecuritiesHeldIn(loansAgainstDepositsOrSecuritiesHeldInValue);
        bodyItems.add(loansAgainstDepositsOrSecuritiesHeldIn);

        // create LoansAgainstLCOrLOCByHeadOffice
        MonetaryItemType loansAgainstLCOrLOCByHeadOfficeValue = new MonetaryItemType();
        loansAgainstLCOrLOCByHeadOfficeValue.setContextRef(asofreportingperiod);       
        loansAgainstLCOrLOCByHeadOfficeValue.setUnitRef(currency);
        loansAgainstLCOrLOCByHeadOfficeValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getLoansAgainstLCOrLOCByHeadOffice())));
        loansAgainstLCOrLOCByHeadOfficeValue.setValue(new BigDecimal(aloItem.getLoansAgainstLCOrLOCByHeadOffice()));
        JAXBElement<MonetaryItemType> loansAgainstLCOrLOCByHeadOffice = rbiObjectFactory.createLoansAgainstLCOrLOCByHeadOffice(loansAgainstLCOrLOCByHeadOfficeValue);
        bodyItems.add(loansAgainstLCOrLOCByHeadOffice);

        // create LoansToIndianPSU
        MonetaryItemType loansToIndianPSUValue = new MonetaryItemType();
        loansToIndianPSUValue.setContextRef(asofreportingperiod);       
        loansToIndianPSUValue.setUnitRef(currency);
        loansToIndianPSUValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getLoansToIndianPSU())));
        loansToIndianPSUValue.setValue(new BigDecimal(aloItem.getLoansToIndianPSU()));
        JAXBElement<MonetaryItemType> loansToIndianPSU = rbiObjectFactory.createLoansToIndianPSU(loansToIndianPSUValue);
        bodyItems.add(loansToIndianPSU);

        // create ShortTermFacilitiesByBank
        MonetaryItemType shortTermFacilitiesByBankValue = new MonetaryItemType();
        shortTermFacilitiesByBankValue.setContextRef(asofreportingperiod);       
        shortTermFacilitiesByBankValue.setUnitRef(currency);
        shortTermFacilitiesByBankValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getShortTermFacilitiesByBank())));
        shortTermFacilitiesByBankValue.setValue(new BigDecimal(aloItem.getShortTermFacilitiesByBank()));
        JAXBElement<MonetaryItemType> shortTermFacilitiesByBank = rbiObjectFactory.createShortTermFacilitiesByBank(shortTermFacilitiesByBankValue);
        bodyItems.add(shortTermFacilitiesByBank);

        // create BankerAcceptanceFacilities
        MonetaryItemType bankerAcceptanceFacilitiesValue = new MonetaryItemType();
        bankerAcceptanceFacilitiesValue.setContextRef(asofreportingperiod);       
        bankerAcceptanceFacilitiesValue.setUnitRef(currency);
        bankerAcceptanceFacilitiesValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getBankerAcceptanceFacilities())));
        bankerAcceptanceFacilitiesValue.setValue(new BigDecimal(aloItem.getBankerAcceptanceFacilities()));
        JAXBElement<MonetaryItemType> bankerAcceptanceFacilities = rbiObjectFactory.createBankerAcceptanceFacilities(bankerAcceptanceFacilitiesValue);
        bodyItems.add(bankerAcceptanceFacilities);

        // create SyndicatedLoans
        MonetaryItemType syndicatedLoansValue = new MonetaryItemType();
        syndicatedLoansValue.setContextRef(asofreportingperiod);       
        syndicatedLoansValue.setUnitRef(currency);
        syndicatedLoansValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getSyndicatedLoans())));
        syndicatedLoansValue.setValue(new BigDecimal(aloItem.getSyndicatedLoans()));
        JAXBElement<MonetaryItemType> syndicatedLoans = rbiObjectFactory.createSyndicatedLoans(syndicatedLoansValue);
        bodyItems.add(syndicatedLoans);

        // create OtherLoansToIndianPSU
        MonetaryItemType otherLoansToIndianPSUValue = new MonetaryItemType();
        otherLoansToIndianPSUValue.setContextRef(asofreportingperiod);       
        otherLoansToIndianPSUValue.setUnitRef(currency);
        otherLoansToIndianPSUValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getOtherLoansToIndianPSU())));
        otherLoansToIndianPSUValue.setValue(new BigDecimal(aloItem.getOtherLoansToIndianPSU()));
        JAXBElement<MonetaryItemType> otherLoansToIndianPSU = rbiObjectFactory.createOtherLoansToIndianPSU(otherLoansToIndianPSUValue);
        bodyItems.add(otherLoansToIndianPSU);

        // create OtherIndiaRelatedFundedExposures
        MonetaryItemType otherIndiaRelatedFundedExposuresValue = new MonetaryItemType();
        otherIndiaRelatedFundedExposuresValue.setContextRef(asofreportingperiod);       
        otherIndiaRelatedFundedExposuresValue.setUnitRef(currency);
        otherIndiaRelatedFundedExposuresValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getOtherIndiaRelatedFundedExposures())));
        otherIndiaRelatedFundedExposuresValue.setValue(new BigDecimal(aloItem.getOtherIndiaRelatedFundedExposures()));
        JAXBElement<MonetaryItemType> otherIndiaRelatedFundedExposures = rbiObjectFactory.createOtherIndiaRelatedFundedExposures(otherIndiaRelatedFundedExposuresValue);
        bodyItems.add(otherIndiaRelatedFundedExposures);

        // create SovereignLoans
        MonetaryItemType sovereignLoansValue = new MonetaryItemType();
        sovereignLoansValue.setContextRef(asofreportingperiod);       
        sovereignLoansValue.setUnitRef(currency);
        sovereignLoansValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getSovereignLoans())));
        sovereignLoansValue.setValue(new BigDecimal(aloItem.getSovereignLoans()));
        JAXBElement<MonetaryItemType> sovereignLoans = rbiObjectFactory.createSovereignLoans(sovereignLoansValue);
        bodyItems.add(sovereignLoans);

        // create LoansToProblemCountries
        MonetaryItemType loansToProblemCountriesValue = new MonetaryItemType();
        loansToProblemCountriesValue.setContextRef(asofreportingperiod);       
        loansToProblemCountriesValue.setUnitRef(currency);
        loansToProblemCountriesValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getLoansToProblemCountries())));
        loansToProblemCountriesValue.setValue(new BigDecimal(aloItem.getLoansToProblemCountries()));
        JAXBElement<MonetaryItemType> loansToProblemCountries = rbiObjectFactory.createLoansToProblemCountries(loansToProblemCountriesValue);
        bodyItems.add(loansToProblemCountries);

        // create OtherSovereignLoans
        MonetaryItemType otherSovereignLoansValue = new MonetaryItemType();
        otherSovereignLoansValue.setContextRef(asofreportingperiod);       
        otherSovereignLoansValue.setUnitRef(currency);
        otherSovereignLoansValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getOtherSovereignLoans())));
        otherSovereignLoansValue.setValue(new BigDecimal(aloItem.getOtherSovereignLoans()));
        JAXBElement<MonetaryItemType> otherSovereignLoans = rbiObjectFactory.createOtherSovereignLoans(otherSovereignLoansValue);
        bodyItems.add(otherSovereignLoans);

        // create RealEstateExposures
        MonetaryItemType realEstateExposuresValue = new MonetaryItemType();
        realEstateExposuresValue.setContextRef(asofreportingperiod);       
        realEstateExposuresValue.setUnitRef(currency);
        realEstateExposuresValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getRealEstateExposures())));
        realEstateExposuresValue.setValue(new BigDecimal(aloItem.getRealEstateExposures()));
        JAXBElement<MonetaryItemType> realEstateExposures = rbiObjectFactory.createRealEstateExposures(realEstateExposuresValue);
        bodyItems.add(realEstateExposures);

        // create CommercialLoans
        MonetaryItemType commercialLoansValue = new MonetaryItemType();
        commercialLoansValue.setContextRef(asofreportingperiod);       
        commercialLoansValue.setUnitRef(currency);
        commercialLoansValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getCommercialLoans())));
        commercialLoansValue.setValue(new BigDecimal(aloItem.getCommercialLoans()));
        JAXBElement<MonetaryItemType> commercialLoans = rbiObjectFactory.createCommercialLoans(commercialLoansValue);
        bodyItems.add(commercialLoans);

        // create OtherLoans
        MonetaryItemType otherLoansValue = new MonetaryItemType();
        otherLoansValue.setContextRef(asofreportingperiod);       
        otherLoansValue.setUnitRef(currency);
        otherLoansValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getOtherLoans())));
        otherLoansValue.setValue(new BigDecimal(aloItem.getOtherLoans()));
        JAXBElement<MonetaryItemType> otherLoans = rbiObjectFactory.createOtherLoans(otherLoansValue);
        bodyItems.add(otherLoans);

        // create BillsPurchasedAndDiscounted
        MonetaryItemType billsPurchasedAndDiscountedValue = new MonetaryItemType();
        billsPurchasedAndDiscountedValue.setContextRef(asofreportingperiod);       
        billsPurchasedAndDiscountedValue.setUnitRef(currency);
        billsPurchasedAndDiscountedValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getBillsPurchasedAndDiscounted())));
        billsPurchasedAndDiscountedValue.setValue(new BigDecimal(aloItem.getBillsPurchasedAndDiscounted()));
        JAXBElement<MonetaryItemType> billsPurchasedAndDiscounted = rbiObjectFactory.createBillsPurchasedAndDiscounted(billsPurchasedAndDiscountedValue);
        bodyItems.add(billsPurchasedAndDiscounted);

        // create NettingItems
        MonetaryItemType nettingItemsValue = new MonetaryItemType();
        nettingItemsValue.setContextRef(asofreportingperiod);       
        nettingItemsValue.setUnitRef(currency);
        nettingItemsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getNettingItems())));
        nettingItemsValue.setValue(new BigDecimal(aloItem.getNettingItems()));
        JAXBElement<MonetaryItemType> nettingItems = rbiObjectFactory.createNettingItems(nettingItemsValue);
        bodyItems.add(nettingItems);

        // create Provisions
        MonetaryItemType provisionsValue = new MonetaryItemType();
        provisionsValue.setContextRef(asofreportingperiod);       
        provisionsValue.setUnitRef(currency);
        provisionsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getProvisions())));
        provisionsValue.setValue(new BigDecimal(aloItem.getProvisions()));
        JAXBElement<MonetaryItemType> provisions = rbiObjectFactory.createProvisions(provisionsValue);
        bodyItems.add(provisions);

        // create InterestSuspense
        MonetaryItemType interestSuspenseValue = new MonetaryItemType();
        interestSuspenseValue.setContextRef(asofreportingperiod);       
        interestSuspenseValue.setUnitRef(currency);
        interestSuspenseValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterestSuspense())));
        interestSuspenseValue.setValue(new BigDecimal(aloItem.getInterestSuspense()));
        JAXBElement<MonetaryItemType> interestSuspense = rbiObjectFactory.createInterestSuspense(interestSuspenseValue);
        bodyItems.add(interestSuspense);

        // create NetCustomerCredit
        MonetaryItemType netCustomerCreditValue = new MonetaryItemType();
        netCustomerCreditValue.setContextRef(asofreportingperiod);       
        netCustomerCreditValue.setUnitRef(currency);
        netCustomerCreditValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getNetCustomerCredit())));
        netCustomerCreditValue.setValue(new BigDecimal(aloItem.getNetCustomerCredit()));
        JAXBElement<MonetaryItemType> netCustomerCredit = rbiObjectFactory.createNetCustomerCredit(netCustomerCreditValue);
        bodyItems.add(netCustomerCredit);

        // create AccumulatedLosses
        MonetaryItemType accumulatedLossesValue = new MonetaryItemType();
        accumulatedLossesValue.setContextRef(asofreportingperiod);       
        accumulatedLossesValue.setUnitRef(currency);
        accumulatedLossesValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getAccumulatedLosses())));
        accumulatedLossesValue.setValue(new BigDecimal(aloItem.getAccumulatedLosses()));
        JAXBElement<MonetaryItemType> accumulatedLosses = rbiObjectFactory.createAccumulatedLosses(accumulatedLossesValue);
        bodyItems.add(accumulatedLosses);

        // create OtherAssets
        MonetaryItemType otherAssetsValue = new MonetaryItemType();
        otherAssetsValue.setContextRef(asofreportingperiod);       
        otherAssetsValue.setUnitRef(currency);
        otherAssetsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getOtherAssets())));
        otherAssetsValue.setValue(new BigDecimal(aloItem.getOtherAssets()));
        JAXBElement<MonetaryItemType> otherAssets = rbiObjectFactory.createOtherAssets(otherAssetsValue);
        bodyItems.add(otherAssets);

        // create AggregateAssets
        MonetaryItemType aggregateAssetsValue = new MonetaryItemType();
        aggregateAssetsValue.setContextRef(asofreportingperiod);   
        aggregateAssetsValue.setUnitRef(currency);
        aggregateAssetsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getAggregateAssets())));
        aggregateAssetsValue.setValue(new BigDecimal(aloItem.getAggregateAssets()));
        JAXBElement<MonetaryItemType> aggregateAssets = rbiObjectFactory.createAggregateAssets(aggregateAssetsValue);
        bodyItems.add(aggregateAssets);

        // create HeadOfficeFunds
        MonetaryItemType headOfficeFundsValue = new MonetaryItemType();
        headOfficeFundsValue.setContextRef(asofreportingperiod);   
        headOfficeFundsValue.setUnitRef(currency);
        headOfficeFundsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getHeadOfficeFunds())));
        headOfficeFundsValue.setValue(new BigDecimal(aloItem.getHeadOfficeFunds()));
        JAXBElement<MonetaryItemType> headOfficeFunds = rbiObjectFactory.createHeadOfficeFunds(headOfficeFundsValue);
        bodyItems.add(headOfficeFunds);

        // create AssignedCapital
        MonetaryItemType assignedCapitalValue = new MonetaryItemType();
        assignedCapitalValue.setContextRef(asofreportingperiod);   
        assignedCapitalValue.setUnitRef(currency);
        assignedCapitalValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getAssignedCapital())));
        assignedCapitalValue.setValue(new BigDecimal(aloItem.getAssignedCapital()));
        JAXBElement<MonetaryItemType> assignedCapital = rbiObjectFactory.createAssignedCapital(assignedCapitalValue);
        bodyItems.add(assignedCapital);

        // create SupportFunds
        MonetaryItemType supportFundsValue = new MonetaryItemType();
        supportFundsValue.setContextRef(asofreportingperiod);   
        supportFundsValue.setUnitRef(currency);
        supportFundsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getSupportFunds())));
        supportFundsValue.setValue(new BigDecimal(aloItem.getSupportFunds()));
        JAXBElement<MonetaryItemType> supportFunds = rbiObjectFactory.createSupportFunds(supportFundsValue);
        bodyItems.add(supportFunds);

        // create EarningsRetained
        MonetaryItemType earningsRetainedValue = new MonetaryItemType();
        earningsRetainedValue.setContextRef(asofreportingperiod);   
        earningsRetainedValue.setUnitRef(currency);
        earningsRetainedValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getEarningsRetained())));
        earningsRetainedValue.setValue(new BigDecimal(aloItem.getEarningsRetained()));
        JAXBElement<MonetaryItemType> earningsRetained = rbiObjectFactory.createEarningsRetained(earningsRetainedValue);
        bodyItems.add(earningsRetained);

        // create OtherFunds
        MonetaryItemType otherFundsValue = new MonetaryItemType();
        otherFundsValue.setContextRef(asofreportingperiod);   
        otherFundsValue.setUnitRef(currency);
        otherFundsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getOtherFunds())));
        otherFundsValue.setValue(new BigDecimal(aloItem.getOtherFunds()));
        JAXBElement<MonetaryItemType> otherFunds = rbiObjectFactory.createOtherFunds(otherFundsValue);
        bodyItems.add(otherFunds);

        // create CustomerDeposits
        MonetaryItemType customerDepositsValue = new MonetaryItemType();
        customerDepositsValue.setContextRef(asofreportingperiod);   
        customerDepositsValue.setUnitRef(currency);
        customerDepositsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getCustomerDeposits())));
        customerDepositsValue.setValue(new BigDecimal(aloItem.getCustomerDeposits()));
        JAXBElement<MonetaryItemType> customerDeposits = rbiObjectFactory.createCustomerDeposits(customerDepositsValue);
        bodyItems.add(customerDeposits);

        // create CustomerDepositsInCurrentAccounts
        MonetaryItemType customerDepositsInCurrentAccountsValue = new MonetaryItemType();
        customerDepositsInCurrentAccountsValue.setContextRef(asofreportingperiod);   
        customerDepositsInCurrentAccountsValue.setUnitRef(currency);
        customerDepositsInCurrentAccountsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getCustomerDepositsInCurrentAccounts())));
        customerDepositsInCurrentAccountsValue.setValue(new BigDecimal(aloItem.getCustomerDepositsInCurrentAccounts()));
        JAXBElement<MonetaryItemType> customerDepositsInCurrentAccounts = rbiObjectFactory.createCustomerDepositsInCurrentAccounts(customerDepositsInCurrentAccountsValue);
        bodyItems.add(customerDepositsInCurrentAccounts);

        // create CustomerDepositsInOtherAccounts
        MonetaryItemType customerDepositsInOtherAccountsValue = new MonetaryItemType();
        customerDepositsInOtherAccountsValue.setContextRef(asofreportingperiod);   
        customerDepositsInOtherAccountsValue.setUnitRef(currency);
        customerDepositsInOtherAccountsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getCustomerDepositsInOtherAccounts())));
        customerDepositsInOtherAccountsValue.setValue(new BigDecimal(aloItem.getCustomerDepositsInOtherAccounts()));
        JAXBElement<MonetaryItemType> customerDepositsInOtherAccounts = rbiObjectFactory.createCustomerDepositsInOtherAccounts(customerDepositsInOtherAccountsValue);
        bodyItems.add(customerDepositsInOtherAccounts);

        // create InterBranchBorrowingsOrDeposits
        MonetaryItemType interBranchBorrowingsOrDepositsValue = new MonetaryItemType();
        interBranchBorrowingsOrDepositsValue.setContextRef(asofreportingperiod);   
        interBranchBorrowingsOrDepositsValue.setUnitRef(currency);
        interBranchBorrowingsOrDepositsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBranchBorrowingsOrDeposits())));
        interBranchBorrowingsOrDepositsValue.setValue(new BigDecimal(aloItem.getInterBranchBorrowingsOrDeposits()));
        JAXBElement<MonetaryItemType> interBranchBorrowingsOrDeposits = rbiObjectFactory.createInterBranchBorrowingsOrDeposits(interBranchBorrowingsOrDepositsValue);
        bodyItems.add(interBranchBorrowingsOrDeposits);

        // create InterBranchBorrowingsOrDepositsWithBranchesInSameForeign
        MonetaryItemType interBranchBorrowingsOrDepositsWithBranchesInSameForeignValue = new MonetaryItemType();
        interBranchBorrowingsOrDepositsWithBranchesInSameForeignValue.setContextRef(asofreportingperiod);   
        interBranchBorrowingsOrDepositsWithBranchesInSameForeignValue.setUnitRef(currency);
        interBranchBorrowingsOrDepositsWithBranchesInSameForeignValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBranchBorrowingsOrDepositsWithBranchesInSameForeign())));
        interBranchBorrowingsOrDepositsWithBranchesInSameForeignValue.setValue(new BigDecimal(aloItem.getInterBranchBorrowingsOrDepositsWithBranchesInSameForeign()));
        JAXBElement<MonetaryItemType> interBranchBorrowingsOrDepositsWithBranchesInSameForeign = rbiObjectFactory.createInterBranchBorrowingsOrDepositsWithBranchesInSameForeign(interBranchBorrowingsOrDepositsWithBranchesInSameForeignValue);
        bodyItems.add(interBranchBorrowingsOrDepositsWithBranchesInSameForeign);

        // create InterBranchBorrowingsOrDepositswithBranchesInOtherForeign
        MonetaryItemType interBranchBorrowingsOrDepositswithBranchesInOtherForeignValue = new MonetaryItemType();
        interBranchBorrowingsOrDepositswithBranchesInOtherForeignValue.setContextRef(asofreportingperiod);   
        interBranchBorrowingsOrDepositswithBranchesInOtherForeignValue.setUnitRef(currency);
        interBranchBorrowingsOrDepositswithBranchesInOtherForeignValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBranchBorrowingsOrDepositswithBranchesInOtherForeign())));
        interBranchBorrowingsOrDepositswithBranchesInOtherForeignValue.setValue(new BigDecimal(aloItem.getInterBranchBorrowingsOrDepositswithBranchesInOtherForeign()));
        JAXBElement<MonetaryItemType> interBranchBorrowingsOrDepositswithBranchesInOtherForeign = rbiObjectFactory.createInterBranchBorrowingsOrDepositswithBranchesInOtherForeign(interBranchBorrowingsOrDepositswithBranchesInOtherForeignValue);
        bodyItems.add(interBranchBorrowingsOrDepositswithBranchesInOtherForeign);

        // create InterBranchBorrowingsOrDepositsWithIndiaBranches
        MonetaryItemType interBranchBorrowingsOrDepositsWithIndiaBranchesValue = new MonetaryItemType();
        interBranchBorrowingsOrDepositsWithIndiaBranchesValue.setContextRef(asofreportingperiod);   
        interBranchBorrowingsOrDepositsWithIndiaBranchesValue.setUnitRef(currency);
        interBranchBorrowingsOrDepositsWithIndiaBranchesValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBranchBorrowingsOrDepositsWithIndiaBranches())));
        interBranchBorrowingsOrDepositsWithIndiaBranchesValue.setValue(new BigDecimal(aloItem.getInterBranchBorrowingsOrDepositsWithIndiaBranches()));
        JAXBElement<MonetaryItemType> interBranchBorrowingsOrDepositsWithIndiaBranches = rbiObjectFactory.createInterBranchBorrowingsOrDepositsWithIndiaBranches(interBranchBorrowingsOrDepositsWithIndiaBranchesValue);
        bodyItems.add(interBranchBorrowingsOrDepositsWithIndiaBranches);

        // create InterBankBorrowings
        MonetaryItemType interBankBorrowingsValue = new MonetaryItemType();
        interBankBorrowingsValue.setContextRef(asofreportingperiod);   
        interBankBorrowingsValue.setUnitRef(currency);
        interBankBorrowingsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBankBorrowings())));
        interBankBorrowingsValue.setValue(new BigDecimal(aloItem.getInterBankBorrowings()));
        JAXBElement<MonetaryItemType> interBankBorrowings = rbiObjectFactory.createInterBankBorrowings(interBankBorrowingsValue);
        bodyItems.add(interBankBorrowings);

        // create InterBankBorrowingsInCurrentAccount
        MonetaryItemType interBankBorrowingsInCurrentAccountValue = new MonetaryItemType();
        interBankBorrowingsInCurrentAccountValue.setContextRef(asofreportingperiod);   
        interBankBorrowingsInCurrentAccountValue.setUnitRef(currency);
        interBankBorrowingsInCurrentAccountValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBankBorrowingsInCurrentAccount())));
        interBankBorrowingsInCurrentAccountValue.setValue(new BigDecimal(aloItem.getInterBankBorrowingsInCurrentAccount()));
        JAXBElement<MonetaryItemType> interBankBorrowingsInCurrentAccount = rbiObjectFactory.createInterBankBorrowingsInCurrentAccount(interBankBorrowingsInCurrentAccountValue);
        bodyItems.add(interBankBorrowingsInCurrentAccount);

        // create InterBankBorrowingsInOtherDeposits
        MonetaryItemType interBankBorrowingsInOtherDepositsValue = new MonetaryItemType();
        interBankBorrowingsInOtherDepositsValue.setContextRef(asofreportingperiod);   
        interBankBorrowingsInOtherDepositsValue.setUnitRef(currency);
        interBankBorrowingsInOtherDepositsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getInterBankBorrowingsInOtherDeposits())));
        interBankBorrowingsInOtherDepositsValue.setValue(new BigDecimal(aloItem.getInterBankBorrowingsInOtherDeposits()));
        JAXBElement<MonetaryItemType> interBankBorrowingsInOtherDeposits = rbiObjectFactory.createInterBankBorrowingsInOtherDeposits(interBankBorrowingsInOtherDepositsValue);
        bodyItems.add(interBankBorrowingsInOtherDeposits);

        // create OtherDebtInstruments
        MonetaryItemType otherDebtInstrumentsValue = new MonetaryItemType();
        otherDebtInstrumentsValue.setContextRef(asofreportingperiod);   
        otherDebtInstrumentsValue.setUnitRef(currency);
        otherDebtInstrumentsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getOtherDebtInstruments())));
        otherDebtInstrumentsValue.setValue(new BigDecimal(aloItem.getOtherDebtInstruments()));
        JAXBElement<MonetaryItemType> otherDebtInstruments = rbiObjectFactory.createOtherDebtInstruments(otherDebtInstrumentsValue);
        bodyItems.add(otherDebtInstruments);

        // create OtherLiabilities
        MonetaryItemType otherLiabilitiesValue = new MonetaryItemType();
        otherLiabilitiesValue.setContextRef(asofreportingperiod);   
        otherLiabilitiesValue.setUnitRef(currency);
        otherLiabilitiesValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getOtherLiabilities())));
        otherLiabilitiesValue.setValue(new BigDecimal(aloItem.getOtherLiabilities()));
        JAXBElement<MonetaryItemType> otherLiabilities = rbiObjectFactory.createOtherLiabilities(otherLiabilitiesValue);
        bodyItems.add(otherLiabilities);

        // create GeneralProvision
        MonetaryItemType generalProvisionValue = new MonetaryItemType();
        generalProvisionValue.setContextRef(asofreportingperiod);   
        generalProvisionValue.setUnitRef(currency);
        generalProvisionValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getGeneralProvision())));
        generalProvisionValue.setValue(new BigDecimal(aloItem.getGeneralProvision()));
        JAXBElement<MonetaryItemType> generalProvision = rbiObjectFactory.createGeneralProvision(generalProvisionValue);
        bodyItems.add(generalProvision);

        // create MiscellaneousLiabilities
        MonetaryItemType miscellaneousLiabilitiesValue = new MonetaryItemType();
        miscellaneousLiabilitiesValue.setContextRef(asofreportingperiod);   
        miscellaneousLiabilitiesValue.setUnitRef(currency);
        miscellaneousLiabilitiesValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getMiscellaneousLiabilities())));
        miscellaneousLiabilitiesValue.setValue(new BigDecimal(aloItem.getMiscellaneousLiabilities()));
        JAXBElement<MonetaryItemType> miscellaneousLiabilities = rbiObjectFactory.createMiscellaneousLiabilities(miscellaneousLiabilitiesValue);
        bodyItems.add(miscellaneousLiabilities);

        // create AggregateLiabilities
        MonetaryItemType aggregateLiabilitiesValue = new MonetaryItemType();
        aggregateLiabilitiesValue.setContextRef(asofreportingperiod);   
        aggregateLiabilitiesValue.setUnitRef(currency);
        aggregateLiabilitiesValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getAggregateLiabilities())));
        aggregateLiabilitiesValue.setValue(new BigDecimal(aloItem.getAggregateLiabilities()));
        JAXBElement<MonetaryItemType> aggregateLiabilities = rbiObjectFactory.createAggregateLiabilities(aggregateLiabilitiesValue);
        bodyItems.add(aggregateLiabilities);

        // create AggregateCapital
        MonetaryItemType aggregateCapitalValue = new MonetaryItemType();
        aggregateCapitalValue.setContextRef(asofreportingperiod);   
        aggregateCapitalValue.setUnitRef(currency);
        aggregateCapitalValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getAggregateCapital())));
        aggregateCapitalValue.setValue(new BigDecimal(aloItem.getAggregateCapital()));
        JAXBElement<MonetaryItemType> aggregateCapital = rbiObjectFactory.createAggregateCapital(aggregateCapitalValue);
        bodyItems.add(aggregateCapital);

        // create AggregateForwardRateAgreements
        MonetaryItemType aggregateForwardRateAgreementsValue = new MonetaryItemType();
        aggregateForwardRateAgreementsValue.setContextRef(asofreportingperiod);   
        aggregateForwardRateAgreementsValue.setUnitRef(currency);
        aggregateForwardRateAgreementsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getAggregateForwardRateAgreements())));
        aggregateForwardRateAgreementsValue.setValue(new BigDecimal(aloItem.getAggregateForwardRateAgreements()));
        JAXBElement<MonetaryItemType> aggregateForwardRateAgreements = rbiObjectFactory.createAggregateForwardRateAgreements(aggregateForwardRateAgreementsValue);
        bodyItems.add(aggregateForwardRateAgreements);

        // create Swaps
        MonetaryItemType swapsValue = new MonetaryItemType();
        swapsValue.setContextRef(asofreportingperiod);   
        swapsValue.setUnitRef(currency);
        swapsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getSwaps())));
        swapsValue.setValue(new BigDecimal(aloItem.getSwaps()));
        JAXBElement<MonetaryItemType> swaps = rbiObjectFactory.createSwaps(swapsValue);
        bodyItems.add(swaps);

        // create Futures
        MonetaryItemType futuresValue = new MonetaryItemType();
        futuresValue.setContextRef(asofreportingperiod);   
        futuresValue.setUnitRef(currency);
        futuresValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getFutures())));
        futuresValue.setValue(new BigDecimal(aloItem.getFutures()));
        JAXBElement<MonetaryItemType> futures = rbiObjectFactory.createFutures(futuresValue);
        bodyItems.add(futures);

        // create Options
        MonetaryItemType optionsValue = new MonetaryItemType();
        optionsValue.setContextRef(asofreportingperiod);   
        optionsValue.setUnitRef(currency);
        optionsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getOptions())));
        optionsValue.setValue(new BigDecimal(aloItem.getOptions()));
        JAXBElement<MonetaryItemType> options = rbiObjectFactory.createOptions(optionsValue);
        bodyItems.add(options);

        // create OtherProducts
        MonetaryItemType otherProductsValue = new MonetaryItemType();
        otherProductsValue.setContextRef(asofreportingperiod);   
        otherProductsValue.setUnitRef(currency);
        otherProductsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getOtherProducts())));
        otherProductsValue.setValue(new BigDecimal(aloItem.getOtherProducts()));
        JAXBElement<MonetaryItemType> otherProducts = rbiObjectFactory.createOtherProducts(otherProductsValue);
        bodyItems.add(otherProducts);

        // create AggregateOtherProducts
        MonetaryItemType aggregateOtherProductsValue = new MonetaryItemType();
        aggregateOtherProductsValue.setContextRef(asofreportingperiod);   
        aggregateOtherProductsValue.setUnitRef(currency);
        aggregateOtherProductsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getAggregateOtherProducts())));
        aggregateOtherProductsValue.setValue(new BigDecimal(aloItem.getAggregateOtherProducts()));
        JAXBElement<MonetaryItemType> aggregateOtherProducts = rbiObjectFactory.createAggregateOtherProducts(aggregateOtherProductsValue);
        bodyItems.add(aggregateOtherProducts);

        // create NetGap
        MonetaryItemType netGapValue = new MonetaryItemType();
        netGapValue.setContextRef(asofreportingperiod);   
        netGapValue.setUnitRef(currency);
        netGapValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getNetGap())));
        netGapValue.setValue(new BigDecimal(aloItem.getNetGap()));
        JAXBElement<MonetaryItemType> netGap = rbiObjectFactory.createNetGap(netGapValue);
        bodyItems.add(netGap);

        // create CumulativeGap
        MonetaryItemType cumulativeGapValue = new MonetaryItemType();
        cumulativeGapValue.setContextRef(asofreportingperiod);   
        cumulativeGapValue.setUnitRef(currency);
        cumulativeGapValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloItem.getCumulativeGap())));
        cumulativeGapValue.setValue(new BigDecimal(aloItem.getCumulativeGap()));
        JAXBElement<MonetaryItemType> cumulativeGap = rbiObjectFactory.createCumulativeGap(cumulativeGapValue);
        bodyItems.add(cumulativeGap);

        // create NetGapAsPercentageOfAggregateAssets
        PercentItemType netGapAsPercentageOfAggregateAssetsValue = new PercentItemType();
        netGapAsPercentageOfAggregateAssetsValue.setContextRef(asofreportingperiod);   
        netGapAsPercentageOfAggregateAssetsValue.setUnitRef(percentage);
        netGapAsPercentageOfAggregateAssetsValue.setDecimals("4");
        netGapAsPercentageOfAggregateAssetsValue.setValue(new BigDecimal(aloItem.getNetGapAsPercentageOfAggregateAssets()));
        JAXBElement<PercentItemType> netGapAsPercentageOfAggregateAssets = rbiObjectFactory.createNetGapAsPercentageOfAggregateAssets(netGapAsPercentageOfAggregateAssetsValue);
        bodyItems.add(netGapAsPercentageOfAggregateAssets);

        // create DocumentaryCreditsCommitted
        MonetaryItemType documentaryCreditsCommittedValue = new MonetaryItemType();
        documentaryCreditsCommittedValue.setContextRef(asofreportingperiod);   
        documentaryCreditsCommittedValue.setUnitRef(currency);
        documentaryCreditsCommittedValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getDocumentaryCreditsCommitted())));
        documentaryCreditsCommittedValue.setValue(new BigDecimal(aloGeneralData.getDocumentaryCreditsCommitted()));
        JAXBElement<MonetaryItemType> documentaryCreditsCommitted = rbiObjectFactory.createDocumentaryCreditsCommitted(documentaryCreditsCommittedValue);
        bodyItems.add(documentaryCreditsCommitted);

         // create DocumentaryCreditsCommittedIssuedOnClientAccount
         MonetaryItemType documentaryCreditsCommittedIssuedOnClientAccountValue = new MonetaryItemType();
         documentaryCreditsCommittedIssuedOnClientAccountValue.setContextRef(asofreportingperiod);  
         documentaryCreditsCommittedIssuedOnClientAccountValue.setUnitRef(currency);
         documentaryCreditsCommittedIssuedOnClientAccountValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getDocumentaryCreditsCommittedIssuedOnClientAccount())));
         documentaryCreditsCommittedIssuedOnClientAccountValue.setValue(new BigDecimal(aloGeneralData.getDocumentaryCreditsCommittedIssuedOnClientAccount()));
         JAXBElement<MonetaryItemType> documentaryCreditsCommittedIssuedOnClientAccount = rbiObjectFactory.createDocumentaryCreditsCommittedIssuedOnClientAccount(documentaryCreditsCommittedIssuedOnClientAccountValue);
         bodyItems.add(documentaryCreditsCommittedIssuedOnClientAccount);
 
         // create DocumentaryCreditsCommittedIssuedOnBanksAccount
         MonetaryItemType documentaryCreditsCommittedIssuedOnBanksAccountValue = new MonetaryItemType();
         documentaryCreditsCommittedIssuedOnBanksAccountValue.setContextRef(asofreportingperiod);  
         documentaryCreditsCommittedIssuedOnBanksAccountValue.setUnitRef(currency);
         documentaryCreditsCommittedIssuedOnBanksAccountValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getDocumentaryCreditsCommittedIssuedOnBanksAccount())));
         documentaryCreditsCommittedIssuedOnBanksAccountValue.setValue(new BigDecimal(aloGeneralData.getDocumentaryCreditsCommittedIssuedOnBanksAccount()));
         JAXBElement<MonetaryItemType> documentaryCreditsCommittedIssuedOnBanksAccount = rbiObjectFactory.createDocumentaryCreditsCommittedIssuedOnBanksAccount(documentaryCreditsCommittedIssuedOnBanksAccountValue);
         bodyItems.add(documentaryCreditsCommittedIssuedOnBanksAccount);
 
         // create PaymentGuaranteesOrAcceptances
         MonetaryItemType paymentGuaranteesOrAcceptancesValue = new MonetaryItemType();
         paymentGuaranteesOrAcceptancesValue.setContextRef(asofreportingperiod);  
         paymentGuaranteesOrAcceptancesValue.setUnitRef(currency);
         paymentGuaranteesOrAcceptancesValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getPaymentGuaranteesOrAcceptances())));
         paymentGuaranteesOrAcceptancesValue.setValue(new BigDecimal(aloGeneralData.getPaymentGuaranteesOrAcceptances()));
         JAXBElement<MonetaryItemType> paymentGuaranteesOrAcceptances = rbiObjectFactory.createPaymentGuaranteesOrAcceptances(paymentGuaranteesOrAcceptancesValue);
         bodyItems.add(paymentGuaranteesOrAcceptances);
 
         // create PerformanceGuaranteesIssued
         MonetaryItemType performanceGuaranteesIssuedValue = new MonetaryItemType();
         performanceGuaranteesIssuedValue.setContextRef(asofreportingperiod);  
         performanceGuaranteesIssuedValue.setUnitRef(currency);
         performanceGuaranteesIssuedValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getPerformanceGuaranteesIssued())));
         performanceGuaranteesIssuedValue.setValue(new BigDecimal(aloGeneralData.getPerformanceGuaranteesIssued()));
         JAXBElement<MonetaryItemType> performanceGuaranteesIssued = rbiObjectFactory.createPerformanceGuaranteesIssued(performanceGuaranteesIssuedValue);
         bodyItems.add(performanceGuaranteesIssued);
 
         // create LoanCommitments
         MonetaryItemType loanCommitmentsValue = new MonetaryItemType();
         loanCommitmentsValue.setContextRef(asofreportingperiod);  
         loanCommitmentsValue.setUnitRef(currency);
         loanCommitmentsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getLoanCommitments())));
         loanCommitmentsValue.setValue(new BigDecimal(aloGeneralData.getLoanCommitments()));
         JAXBElement<MonetaryItemType> loanCommitments = rbiObjectFactory.createLoanCommitments(loanCommitmentsValue);
         bodyItems.add(loanCommitments);
 
         // create OffBalanceSheetExposures
         MonetaryItemType offBalanceSheetExposuresValue = new MonetaryItemType();
         offBalanceSheetExposuresValue.setContextRef(asofreportingperiod);  
         offBalanceSheetExposuresValue.setUnitRef(currency);
         offBalanceSheetExposuresValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getOffBalanceSheetExposures())));
         offBalanceSheetExposuresValue.setValue(new BigDecimal(aloGeneralData.getOffBalanceSheetExposures()));
         JAXBElement<MonetaryItemType> offBalanceSheetExposures = rbiObjectFactory.createOffBalanceSheetExposures(offBalanceSheetExposuresValue);
         bodyItems.add(offBalanceSheetExposures);
 
         // create OutstandingForexContracts
         MonetaryItemType outstandingForexContractsValue = new MonetaryItemType();
         outstandingForexContractsValue.setContextRef(asofreportingperiod);  
         outstandingForexContractsValue.setUnitRef(currency);
         outstandingForexContractsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getOutstandingForexContracts())));
         outstandingForexContractsValue.setValue(new BigDecimal(aloGeneralData.getOutstandingForexContracts()));
         JAXBElement<MonetaryItemType> outstandingForexContracts = rbiObjectFactory.createOutstandingForexContracts(outstandingForexContractsValue);
         bodyItems.add(outstandingForexContracts);
 
         // create OutstandingInterestRateSwaps
         MonetaryItemType outstandingInterestRateSwapsValue = new MonetaryItemType();
         outstandingInterestRateSwapsValue.setContextRef(asofreportingperiod);  
         outstandingInterestRateSwapsValue.setUnitRef(currency);
         outstandingInterestRateSwapsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getOutstandingInterestRateSwaps())));
         outstandingInterestRateSwapsValue.setValue(new BigDecimal(aloGeneralData.getOutstandingInterestRateSwaps()));
         JAXBElement<MonetaryItemType> outstandingInterestRateSwaps = rbiObjectFactory.createOutstandingInterestRateSwaps(outstandingInterestRateSwapsValue);
         bodyItems.add(outstandingInterestRateSwaps);
 
         // create ForwardRateAgreements
         MonetaryItemType forwardRateAgreementsValue = new MonetaryItemType();
         forwardRateAgreementsValue.setContextRef(asofreportingperiod);  
         forwardRateAgreementsValue.setUnitRef(currency);
         forwardRateAgreementsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getForwardRateAgreements())));
         forwardRateAgreementsValue.setValue(new BigDecimal(aloGeneralData.getForwardRateAgreements()));
         JAXBElement<MonetaryItemType> forwardRateAgreements = rbiObjectFactory.createForwardRateAgreements(forwardRateAgreementsValue);
         bodyItems.add(forwardRateAgreements);
 
         // create OtherFutureAndForwardContracts
         MonetaryItemType otherFutureAndForwardContractsValue = new MonetaryItemType();
         otherFutureAndForwardContractsValue.setContextRef(asofreportingperiod);  
         otherFutureAndForwardContractsValue.setUnitRef(currency);
         otherFutureAndForwardContractsValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getOtherFutureAndForwardContracts())));
         otherFutureAndForwardContractsValue.setValue(new BigDecimal(aloGeneralData.getOtherFutureAndForwardContracts()));
         JAXBElement<MonetaryItemType> otherFutureAndForwardContracts = rbiObjectFactory.createOtherFutureAndForwardContracts(otherFutureAndForwardContractsValue);
         bodyItems.add(otherFutureAndForwardContracts);
 
         // create CurrencyOptionsBought
         MonetaryItemType currencyOptionsBoughtValue = new MonetaryItemType();
         currencyOptionsBoughtValue.setContextRef(asofreportingperiod);  
         currencyOptionsBoughtValue.setUnitRef(currency);
         currencyOptionsBoughtValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getCurrencyOptionsBought())));
         currencyOptionsBoughtValue.setValue(new BigDecimal(aloGeneralData.getCurrencyOptionsBought()));
         JAXBElement<MonetaryItemType> currencyOptionsBought = rbiObjectFactory.createCurrencyOptionsBought(currencyOptionsBoughtValue);
         bodyItems.add(currencyOptionsBought);
 
         // create CurrencyOptionsWritten
         MonetaryItemType currencyOptionsWrittenValue = new MonetaryItemType();
         currencyOptionsWrittenValue.setContextRef(asofreportingperiod);  
         currencyOptionsWrittenValue.setUnitRef(currency);
         currencyOptionsWrittenValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getCurrencyOptionsWritten())));
         currencyOptionsWrittenValue.setValue(new BigDecimal(aloGeneralData.getCurrencyOptionsWritten()));
         JAXBElement<MonetaryItemType> currencyOptionsWritten = rbiObjectFactory.createCurrencyOptionsWritten(currencyOptionsWrittenValue);
         bodyItems.add(currencyOptionsWritten);
 
         // create OtherOffBalanceSheetExposure
         MonetaryItemType otherOffBalanceSheetExposureValue = new MonetaryItemType();
         otherOffBalanceSheetExposureValue.setContextRef(asofreportingperiod);  
         otherOffBalanceSheetExposureValue.setUnitRef(currency);
         otherOffBalanceSheetExposureValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getOtherOffBalanceSheetExposure())));
         otherOffBalanceSheetExposureValue.setValue(new BigDecimal(aloGeneralData.getOtherOffBalanceSheetExposure()));
         JAXBElement<MonetaryItemType> otherOffBalanceSheetExposure = rbiObjectFactory.createOtherOffBalanceSheetExposure(otherOffBalanceSheetExposureValue);
         bodyItems.add(otherOffBalanceSheetExposure);
 
         // create AggregateOffBalanceSheetExposures
         MonetaryItemType aggregateOffBalanceSheetExposuresValue = new MonetaryItemType();
         aggregateOffBalanceSheetExposuresValue.setContextRef(asofreportingperiod);  
         aggregateOffBalanceSheetExposuresValue.setUnitRef(currency);
         aggregateOffBalanceSheetExposuresValue.setDecimals(String.format("%s", CommonFns.getDecimals(aloGeneralData.getAggregateOffBalanceSheetExposures())));
         aggregateOffBalanceSheetExposuresValue.setValue(new BigDecimal(aloGeneralData.getAggregateOffBalanceSheetExposures()));
         JAXBElement<MonetaryItemType> aggregateOffBalanceSheetExposures = rbiObjectFactory.createAggregateOffBalanceSheetExposures(aggregateOffBalanceSheetExposuresValue);
         bodyItems.add(aggregateOffBalanceSheetExposures);
 

        return bodyItems;
            
        }
    
}
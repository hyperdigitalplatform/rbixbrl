package in.armedu.banking.report.rbixbrl.part.rop.impl;

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
import org.xbrl._2003.instance.DecimalItemType;
import org.xbrl._2003.instance.MonetaryItemType;
import org.xbrl._2003.instance.IntegerItemType;
import org.xbrl.dtr.type.numeric.PercentItemType;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.rop.ROPItemData;
import in.armedu.banking.report.rbixbrl.model.rop.ROPGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;
import in.armedu.banking.report.rbixbrl.util.CommonFns;

public class ROPBody  implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData) {
        return null;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalData, ItemData itemData) {

        ROPGeneralData ropGeneralData = (ROPGeneralData) generalData;
        ROPItemData ropItemData = (ROPItemData) itemData;

        List<Object> bodyItems = new ArrayList<Object>();
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();

        Context fromToContext = contexts.get(ROPUtil.FROMTO);
        Context asOfContext = contexts.get(ROPUtil.ASOF);
        Unit currency = units.get(ROPUtil.CURRENCY);
        Unit percentage = units.get(ROPUtil.PERCENTAGE);
        Context fromtoreportingperiod = contexts.get(ROPUtil.FROMTOREPORTINGPERIOD);        
       // Context fromtodateofreport = contexts.get(ROPUtil.FROMTODATEOFREPORT);


//     For Account with members
        // create InterestIncome
        MonetaryItemType interestIncomeValue = new MonetaryItemType();
        interestIncomeValue.setContextRef(fromtoreportingperiod);  
        interestIncomeValue.setUnitRef(currency);
        interestIncomeValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getInterestIncome())));
        interestIncomeValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getInterestIncome()));
        JAXBElement<MonetaryItemType> interestIncome = rbiObjectFactory.createInterestIncome(interestIncomeValue);
        bodyItems.add(interestIncome);

        // create InterestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits
        MonetaryItemType interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCreditsValue = new MonetaryItemType();
        interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCreditsValue.setContextRef(fromtoreportingperiod);  
        interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCreditsValue.setUnitRef(currency);
        interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCreditsValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getInterestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits())));
        interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCreditsValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getInterestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits()));
        JAXBElement<MonetaryItemType> interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits = rbiObjectFactory.createInterestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits(interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCreditsValue);
        bodyItems.add(interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits);

        // create InterestOnLoansAndAdvancesNonBank
        MonetaryItemType interestOnLoansAndAdvancesNonBankValue = new MonetaryItemType();
        interestOnLoansAndAdvancesNonBankValue.setContextRef(fromtoreportingperiod);  
        interestOnLoansAndAdvancesNonBankValue.setUnitRef(currency);
        interestOnLoansAndAdvancesNonBankValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getInterestOnLoansAndAdvancesNonBank())));
        interestOnLoansAndAdvancesNonBankValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getInterestOnLoansAndAdvancesNonBank()));
        JAXBElement<MonetaryItemType> interestOnLoansAndAdvancesNonBank = rbiObjectFactory.createInterestOnLoansAndAdvancesNonBank(interestOnLoansAndAdvancesNonBankValue);
        bodyItems.add(interestOnLoansAndAdvancesNonBank);

        // create InterestOnGovernmentSecurities
        MonetaryItemType interestOnGovernmentSecuritiesValue = new MonetaryItemType();
        interestOnGovernmentSecuritiesValue.setContextRef(fromtoreportingperiod);  
        interestOnGovernmentSecuritiesValue.setUnitRef(currency);
        interestOnGovernmentSecuritiesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getInterestOnGovernmentSecurities())));
        interestOnGovernmentSecuritiesValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getInterestOnGovernmentSecurities()));
        JAXBElement<MonetaryItemType> interestOnGovernmentSecurities = rbiObjectFactory.createInterestOnGovernmentSecurities(interestOnGovernmentSecuritiesValue);
        bodyItems.add(interestOnGovernmentSecurities);

        // create InterestOnOtherInvestments
        MonetaryItemType interestOnOtherInvestmentsValue = new MonetaryItemType();
        interestOnOtherInvestmentsValue.setContextRef(fromtoreportingperiod);  
        interestOnOtherInvestmentsValue.setUnitRef(currency);
        interestOnOtherInvestmentsValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getInterestOnOtherInvestments())));
        interestOnOtherInvestmentsValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getInterestOnOtherInvestments()));
        JAXBElement<MonetaryItemType> interestOnOtherInvestments = rbiObjectFactory.createInterestOnOtherInvestments(interestOnOtherInvestmentsValue);
        bodyItems.add(interestOnOtherInvestments);

        // create InterestIncomeOnOtherInterestBearingAssets
        MonetaryItemType interestIncomeOnOtherInterestBearingAssetsValue = new MonetaryItemType();
        interestIncomeOnOtherInterestBearingAssetsValue.setContextRef(fromtoreportingperiod);  
        interestIncomeOnOtherInterestBearingAssetsValue.setUnitRef(currency);
        interestIncomeOnOtherInterestBearingAssetsValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getInterestIncomeOnOtherInterestBearingAssets())));
        interestIncomeOnOtherInterestBearingAssetsValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getInterestIncomeOnOtherInterestBearingAssets()));
        JAXBElement<MonetaryItemType> interestIncomeOnOtherInterestBearingAssets = rbiObjectFactory.createInterestIncomeOnOtherInterestBearingAssets(interestIncomeOnOtherInterestBearingAssetsValue);
        bodyItems.add(interestIncomeOnOtherInterestBearingAssets);

        // create InterestExpenses
        MonetaryItemType interestExpensesValue = new MonetaryItemType();
        interestExpensesValue.setContextRef(fromtoreportingperiod);  
        interestExpensesValue.setUnitRef(currency);
        interestExpensesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getInterestExpenses())));
        interestExpensesValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getInterestExpenses()));
        JAXBElement<MonetaryItemType> interestExpenses = rbiObjectFactory.createInterestExpenses(interestExpensesValue);
        bodyItems.add(interestExpenses);

        // create InterestExpensesOnCustomerDeposits
        MonetaryItemType interestExpensesOnCustomerDepositsValue = new MonetaryItemType();
        interestExpensesOnCustomerDepositsValue.setContextRef(fromtoreportingperiod);  
        interestExpensesOnCustomerDepositsValue.setUnitRef(currency);
        interestExpensesOnCustomerDepositsValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getInterestExpensesOnCustomerDeposits())));
        interestExpensesOnCustomerDepositsValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getInterestExpensesOnCustomerDeposits()));
        JAXBElement<MonetaryItemType> interestExpensesOnCustomerDeposits = rbiObjectFactory.createInterestExpensesOnCustomerDeposits(interestExpensesOnCustomerDepositsValue);
        bodyItems.add(interestExpensesOnCustomerDeposits);

        // create InterestExpensesOnInterBranchAndInterBankBorrowings
        MonetaryItemType interestExpensesOnInterBranchAndInterBankBorrowingsValue = new MonetaryItemType();
        interestExpensesOnInterBranchAndInterBankBorrowingsValue.setContextRef(fromtoreportingperiod);  
        interestExpensesOnInterBranchAndInterBankBorrowingsValue.setUnitRef(currency);
        interestExpensesOnInterBranchAndInterBankBorrowingsValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getInterestExpensesOnInterBranchAndInterBankBorrowings())));
        interestExpensesOnInterBranchAndInterBankBorrowingsValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getInterestExpensesOnInterBranchAndInterBankBorrowings()));
        JAXBElement<MonetaryItemType> interestExpensesOnInterBranchAndInterBankBorrowings = rbiObjectFactory.createInterestExpensesOnInterBranchAndInterBankBorrowings(interestExpensesOnInterBranchAndInterBankBorrowingsValue);
        bodyItems.add(interestExpensesOnInterBranchAndInterBankBorrowings);

        // create OtherInterestExpended
        MonetaryItemType otherInterestExpendedValue = new MonetaryItemType();
        otherInterestExpendedValue.setContextRef(fromtoreportingperiod);  
        otherInterestExpendedValue.setUnitRef(currency);
        otherInterestExpendedValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getOtherInterestExpended())));
        otherInterestExpendedValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getOtherInterestExpended()));
        JAXBElement<MonetaryItemType> otherInterestExpended = rbiObjectFactory.createOtherInterestExpended(otherInterestExpendedValue);
        bodyItems.add(otherInterestExpended);

        // create NetInterestIncome
        MonetaryItemType netInterestIncomeValue = new MonetaryItemType();
        netInterestIncomeValue.setContextRef(fromtoreportingperiod);  
        netInterestIncomeValue.setUnitRef(currency);
        netInterestIncomeValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getNetInterestIncome())));
        netInterestIncomeValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getNetInterestIncome()));
        JAXBElement<MonetaryItemType> netInterestIncome = rbiObjectFactory.createNetInterestIncome(netInterestIncomeValue);
        bodyItems.add(netInterestIncome);

        // create OtherIncome
        MonetaryItemType otherIncomeValue = new MonetaryItemType();
        otherIncomeValue.setContextRef(fromtoreportingperiod);  
        otherIncomeValue.setUnitRef(currency);
        otherIncomeValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getOtherIncome())));
        otherIncomeValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getOtherIncome()));
        JAXBElement<MonetaryItemType> otherIncome = rbiObjectFactory.createOtherIncome(otherIncomeValue);
        bodyItems.add(otherIncome);

        // create OtherFeeIncome
        MonetaryItemType otherFeeIncomeValue = new MonetaryItemType();
        otherFeeIncomeValue.setContextRef(fromtoreportingperiod);  
        otherFeeIncomeValue.setUnitRef(currency);
        otherFeeIncomeValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getOtherFeeIncome())));
        otherFeeIncomeValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getOtherFeeIncome()));
        JAXBElement<MonetaryItemType> otherFeeIncome = rbiObjectFactory.createOtherFeeIncome(otherFeeIncomeValue);
        bodyItems.add(otherFeeIncome);

        // create ProfitLossOnForexTrading
        MonetaryItemType profitLossOnForexTradingValue = new MonetaryItemType();
        profitLossOnForexTradingValue.setContextRef(fromtoreportingperiod);  
        profitLossOnForexTradingValue.setUnitRef(currency);
        profitLossOnForexTradingValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getProfitLossOnForexTrading())));
        profitLossOnForexTradingValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getProfitLossOnForexTrading()));
        JAXBElement<MonetaryItemType> profitLossOnForexTrading = rbiObjectFactory.createProfitLossOnForexTrading(profitLossOnForexTradingValue);
        bodyItems.add(profitLossOnForexTrading);

        // create ProfitLossOnSecuritiesTrading
        MonetaryItemType profitLossOnSecuritiesTradingValue = new MonetaryItemType();
        profitLossOnSecuritiesTradingValue.setContextRef(fromtoreportingperiod);  
        profitLossOnSecuritiesTradingValue.setUnitRef(currency);
        profitLossOnSecuritiesTradingValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getProfitLossOnSecuritiesTrading())));
        profitLossOnSecuritiesTradingValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getProfitLossOnSecuritiesTrading()));
        JAXBElement<MonetaryItemType> profitLossOnSecuritiesTrading = rbiObjectFactory.createProfitLossOnSecuritiesTrading(profitLossOnSecuritiesTradingValue);
        bodyItems.add(profitLossOnSecuritiesTrading);

        // create MiscellaneousIncome
        MonetaryItemType miscellaneousIncomeValue = new MonetaryItemType();
        miscellaneousIncomeValue.setContextRef(fromtoreportingperiod);  
        miscellaneousIncomeValue.setUnitRef(currency);
        miscellaneousIncomeValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getMiscellaneousIncome())));
        miscellaneousIncomeValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getMiscellaneousIncome()));
        JAXBElement<MonetaryItemType> miscellaneousIncome = rbiObjectFactory.createMiscellaneousIncome(miscellaneousIncomeValue);
        bodyItems.add(miscellaneousIncome);

        // create GrossIncome
        MonetaryItemType grossIncomeValue = new MonetaryItemType();
        grossIncomeValue.setContextRef(fromtoreportingperiod);  
        grossIncomeValue.setUnitRef(currency);
        grossIncomeValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getGrossIncome())));
        grossIncomeValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getGrossIncome()));
        JAXBElement<MonetaryItemType> grossIncome = rbiObjectFactory.createGrossIncome(grossIncomeValue);
        bodyItems.add(grossIncome);

        // create StaffExpenses
        MonetaryItemType staffExpensesValue = new MonetaryItemType();
        staffExpensesValue.setContextRef(fromtoreportingperiod);  
        staffExpensesValue.setUnitRef(currency);
        staffExpensesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getStaffExpenses())));
        staffExpensesValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getStaffExpenses()));
        JAXBElement<MonetaryItemType> staffExpenses = rbiObjectFactory.createStaffExpenses(staffExpensesValue);
        bodyItems.add(staffExpenses);

        // create OtherExpenses
        MonetaryItemType otherExpensesValue = new MonetaryItemType();
        otherExpensesValue.setContextRef(fromtoreportingperiod);  
        otherExpensesValue.setUnitRef(currency);
        otherExpensesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getOtherExpenses())));
        otherExpensesValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getOtherExpenses()));
        JAXBElement<MonetaryItemType> otherExpenses = rbiObjectFactory.createOtherExpenses(otherExpensesValue);
        bodyItems.add(otherExpenses);

        // create AggregateExpenses
        MonetaryItemType aggregateExpensesValue = new MonetaryItemType();
        aggregateExpensesValue.setContextRef(fromtoreportingperiod);  
        aggregateExpensesValue.setUnitRef(currency);
        aggregateExpensesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getAggregateExpenses())));
        aggregateExpensesValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getAggregateExpenses()));
        JAXBElement<MonetaryItemType> aggregateExpenses = rbiObjectFactory.createAggregateExpenses(aggregateExpensesValue);
        bodyItems.add(aggregateExpenses);

        // create OperatingSurplusDeficit
        MonetaryItemType operatingSurplusDeficitValue = new MonetaryItemType();
        operatingSurplusDeficitValue.setContextRef(fromtoreportingperiod);  
        operatingSurplusDeficitValue.setUnitRef(currency);
        operatingSurplusDeficitValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getOperatingSurplusDeficit())));
        operatingSurplusDeficitValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getOperatingSurplusDeficit()));
        JAXBElement<MonetaryItemType> operatingSurplusDeficit = rbiObjectFactory.createOperatingSurplusDeficit(operatingSurplusDeficitValue);
        bodyItems.add(operatingSurplusDeficit);

        // create BadDebtsWrittenoff
        MonetaryItemType badDebtsWrittenoffValue = new MonetaryItemType();
        badDebtsWrittenoffValue.setContextRef(fromtoreportingperiod);  
        badDebtsWrittenoffValue.setUnitRef(currency);
        badDebtsWrittenoffValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getBadDebtsWrittenoff())));
        badDebtsWrittenoffValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getBadDebtsWrittenoff()));
        JAXBElement<MonetaryItemType> badDebtsWrittenoff = rbiObjectFactory.createBadDebtsWrittenoff(badDebtsWrittenoffValue);
        bodyItems.add(badDebtsWrittenoff);

        // create ExtraordinaryLossAndOtherWriteOff
        MonetaryItemType extraordinaryLossAndOtherWriteOffValue = new MonetaryItemType();
        extraordinaryLossAndOtherWriteOffValue.setContextRef(fromtoreportingperiod);  
        extraordinaryLossAndOtherWriteOffValue.setUnitRef(currency);
        extraordinaryLossAndOtherWriteOffValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getExtraordinaryLossAndOtherWriteOff())));
        extraordinaryLossAndOtherWriteOffValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getExtraordinaryLossAndOtherWriteOff()));
        JAXBElement<MonetaryItemType> extraordinaryLossAndOtherWriteOff = rbiObjectFactory.createExtraordinaryLossAndOtherWriteOff(extraordinaryLossAndOtherWriteOffValue);
        bodyItems.add(extraordinaryLossAndOtherWriteOff);

        // create HeadOfficeAdministrationCharges
        MonetaryItemType headOfficeAdministrationChargesValue = new MonetaryItemType();
        headOfficeAdministrationChargesValue.setContextRef(fromtoreportingperiod);  
        headOfficeAdministrationChargesValue.setUnitRef(currency);
        headOfficeAdministrationChargesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getHeadOfficeAdministrationCharges())));
        headOfficeAdministrationChargesValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getHeadOfficeAdministrationCharges()));
        JAXBElement<MonetaryItemType> headOfficeAdministrationCharges = rbiObjectFactory.createHeadOfficeAdministrationCharges(headOfficeAdministrationChargesValue);
        bodyItems.add(headOfficeAdministrationCharges);

        // create ProvisionOtherThanTax
        MonetaryItemType provisionOtherThanTaxValue = new MonetaryItemType();
        provisionOtherThanTaxValue.setContextRef(fromtoreportingperiod);  
        provisionOtherThanTaxValue.setUnitRef(currency);
        provisionOtherThanTaxValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getProvisionOtherThanTax())));
        provisionOtherThanTaxValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getProvisionOtherThanTax()));
        JAXBElement<MonetaryItemType> provisionOtherThanTax = rbiObjectFactory.createProvisionOtherThanTax(provisionOtherThanTaxValue);
        bodyItems.add(provisionOtherThanTax);

        // create ProfitLossBeforeTax
        MonetaryItemType profitLossBeforeTaxValue = new MonetaryItemType();
        profitLossBeforeTaxValue.setContextRef(fromtoreportingperiod);  
        profitLossBeforeTaxValue.setUnitRef(currency);
        profitLossBeforeTaxValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getProfitLossBeforeTax())));
        profitLossBeforeTaxValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getProfitLossBeforeTax()));
        JAXBElement<MonetaryItemType> profitLossBeforeTax = rbiObjectFactory.createProfitLossBeforeTax(profitLossBeforeTaxValue);
        bodyItems.add(profitLossBeforeTax);

        // create NetPovisionOfTaxes
        MonetaryItemType netPovisionOfTaxesValue = new MonetaryItemType();
        netPovisionOfTaxesValue.setContextRef(fromtoreportingperiod);  
        netPovisionOfTaxesValue.setUnitRef(currency);
        netPovisionOfTaxesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getNetPovisionOfTaxes())));
        netPovisionOfTaxesValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getNetPovisionOfTaxes()));
        JAXBElement<MonetaryItemType> netPovisionOfTaxes = rbiObjectFactory.createNetPovisionOfTaxes(netPovisionOfTaxesValue);
        bodyItems.add(netPovisionOfTaxes);

        // create NetProfitLossForPeriod
        MonetaryItemType netProfitLossForPeriodValue = new MonetaryItemType();
        netProfitLossForPeriodValue.setContextRef(fromtoreportingperiod);  
        netProfitLossForPeriodValue.setUnitRef(currency);
        netProfitLossForPeriodValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getNetProfitLossForPeriod())));
        netProfitLossForPeriodValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getNetProfitLossForPeriod()));
        JAXBElement<MonetaryItemType> netProfitLossForPeriod = rbiObjectFactory.createNetProfitLossForPeriod(netProfitLossForPeriodValue);
        bodyItems.add(netProfitLossForPeriod);

        // create RemittanceToHeadOfficeExpenses
        MonetaryItemType remittanceToHeadOfficeExpensesValue = new MonetaryItemType();
        remittanceToHeadOfficeExpensesValue.setContextRef(fromtoreportingperiod);  
        remittanceToHeadOfficeExpensesValue.setUnitRef(currency);
        remittanceToHeadOfficeExpensesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getRemittanceToHeadOfficeExpenses())));
        remittanceToHeadOfficeExpensesValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getRemittanceToHeadOfficeExpenses()));
        JAXBElement<MonetaryItemType> remittanceToHeadOfficeExpenses = rbiObjectFactory.createRemittanceToHeadOfficeExpenses(remittanceToHeadOfficeExpensesValue);
        bodyItems.add(remittanceToHeadOfficeExpenses);

        // create RemittanceToHeadOfficeProfit
        MonetaryItemType remittanceToHeadOfficeProfitValue = new MonetaryItemType();
        remittanceToHeadOfficeProfitValue.setContextRef(fromtoreportingperiod);  
        remittanceToHeadOfficeProfitValue.setUnitRef(currency);
        remittanceToHeadOfficeProfitValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getRemittanceToHeadOfficeProfit())));
        remittanceToHeadOfficeProfitValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getRemittanceToHeadOfficeProfit()));
        JAXBElement<MonetaryItemType> remittanceToHeadOfficeProfit = rbiObjectFactory.createRemittanceToHeadOfficeProfit(remittanceToHeadOfficeProfitValue);
        bodyItems.add(remittanceToHeadOfficeProfit);

        // create RemittanceToHeadOfficeOthers
        MonetaryItemType remittanceToHeadOfficeOthersValue = new MonetaryItemType();
        remittanceToHeadOfficeOthersValue.setContextRef(fromtoreportingperiod);  
        remittanceToHeadOfficeOthersValue.setUnitRef(currency);
        remittanceToHeadOfficeOthersValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopReportingPeriod().getRemittanceToHeadOfficeOthers())));
        remittanceToHeadOfficeOthersValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getRemittanceToHeadOfficeOthers()));
        JAXBElement<MonetaryItemType> remittanceToHeadOfficeOthers = rbiObjectFactory.createRemittanceToHeadOfficeOthers(remittanceToHeadOfficeOthersValue);
        bodyItems.add(remittanceToHeadOfficeOthers);

        // create businessesPerEmployee
        DecimalItemType businessesPerEmployeeValue = new DecimalItemType();
        businessesPerEmployeeValue.setContextRef(fromtoreportingperiod);  
        businessesPerEmployeeValue.setDecimals("INF");
        businessesPerEmployeeValue.setUnitRef(percentage);
        businessesPerEmployeeValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getBusinessesPerEmployee()));
        JAXBElement<DecimalItemType> businessesPerEmployee = rbiObjectFactory.createBusinessesPerEmployee(businessesPerEmployeeValue);
        bodyItems.add(businessesPerEmployee);

        // create profitPerEmployee
        DecimalItemType profitPerEmployeeValue = new DecimalItemType();
        profitPerEmployeeValue.setContextRef(fromtoreportingperiod);  
        profitPerEmployeeValue.setDecimals("INF");
        profitPerEmployeeValue.setUnitRef(percentage);
        profitPerEmployeeValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getProfitPerEmployee()));
        JAXBElement<DecimalItemType> profitPerEmployee = rbiObjectFactory.createProfitPerEmployee(profitPerEmployeeValue);
        bodyItems.add(profitPerEmployee);

        // create AverageYieldOnInterestEarningAssets
        DecimalItemType averageYieldOnInterestEarningAssetsValue = new DecimalItemType();
        averageYieldOnInterestEarningAssetsValue.setContextRef(fromtoreportingperiod);  
        averageYieldOnInterestEarningAssetsValue.setDecimals("2");
        averageYieldOnInterestEarningAssetsValue.setUnitRef(percentage);
        averageYieldOnInterestEarningAssetsValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getAverageYieldOnInterestEarningAssets()));
        JAXBElement<DecimalItemType> averageYieldOnInterestEarningAssets = rbiObjectFactory.createAverageYieldOnInterestEarningAssets(averageYieldOnInterestEarningAssetsValue);
        bodyItems.add(averageYieldOnInterestEarningAssets);

        // create CostOfFundsAveragePercentage
        DecimalItemType costOfFundsAveragePercentageValue = new DecimalItemType();
        costOfFundsAveragePercentageValue.setContextRef(fromtoreportingperiod);  
        costOfFundsAveragePercentageValue.setDecimals("INF");
        costOfFundsAveragePercentageValue.setUnitRef(percentage);
        costOfFundsAveragePercentageValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getCostOfFundsAveragePercentage()));
        JAXBElement<DecimalItemType> costOfFundsAveragePercentage = rbiObjectFactory.createCostOfFundsAveragePercentage(costOfFundsAveragePercentageValue);
        bodyItems.add(costOfFundsAveragePercentage);

        // create ReturnsOnAssets
        DecimalItemType returnsOnAssetsValue = new DecimalItemType();
        returnsOnAssetsValue.setContextRef(fromtoreportingperiod);  
        returnsOnAssetsValue.setDecimals("INF");
        returnsOnAssetsValue.setUnitRef(percentage);
        returnsOnAssetsValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getReturnsOnAssets()));
        JAXBElement<DecimalItemType> returnsOnAssets = rbiObjectFactory.createReturnsOnAssets(returnsOnAssetsValue);
        bodyItems.add(returnsOnAssets);

        // create InterestSpreadInReturnOnProfitability
        DecimalItemType interestSpreadInReturnOnProfitabilityValue = new DecimalItemType();
        interestSpreadInReturnOnProfitabilityValue.setContextRef(fromtoreportingperiod);  
        interestSpreadInReturnOnProfitabilityValue.setDecimals("INF");
        interestSpreadInReturnOnProfitabilityValue.setUnitRef(percentage);
        interestSpreadInReturnOnProfitabilityValue.setValue(new BigDecimal(ropItemData.getRopReportingPeriod().getInterestSpreadInReturnOnProfitability()));
        JAXBElement<DecimalItemType> interestSpreadInReturnOnProfitability = rbiObjectFactory.createInterestSpreadInReturnOnProfitability(interestSpreadInReturnOnProfitabilityValue);
        bodyItems.add(interestSpreadInReturnOnProfitability);

        return bodyItems;
            
        }
    
}
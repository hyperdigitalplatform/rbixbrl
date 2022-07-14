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

public class ROPBodyExtra  implements BodyInterface {

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
        Context fromtodateofreport = contexts.get(ROPUtil.FROMTODATEOFREPORT);


//     For Account with members
        // create InterestIncome
        MonetaryItemType interestIncomeValue = new MonetaryItemType();
        interestIncomeValue.setContextRef(fromtodateofreport);  
        interestIncomeValue.setUnitRef(currency);
        interestIncomeValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getInterestIncome())));
        interestIncomeValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getInterestIncome()));
        JAXBElement<MonetaryItemType> interestIncome = rbiObjectFactory.createInterestIncome(interestIncomeValue);
        bodyItems.add(interestIncome);

        // create InterestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits
        MonetaryItemType interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCreditsValue = new MonetaryItemType();
        interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCreditsValue.setContextRef(fromtodateofreport);  
        interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCreditsValue.setUnitRef(currency);
        interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCreditsValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getInterestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits())));
        interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCreditsValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getInterestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits()));
        JAXBElement<MonetaryItemType> interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits = rbiObjectFactory.createInterestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits(interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCreditsValue);
        bodyItems.add(interestIncomeOnBalancesWithMonetaryAuthorityInterBranchOrbankDepositsAndCredits);

        // create InterestOnLoansAndAdvancesNonBank
        MonetaryItemType interestOnLoansAndAdvancesNonBankValue = new MonetaryItemType();
        interestOnLoansAndAdvancesNonBankValue.setContextRef(fromtodateofreport);  
        interestOnLoansAndAdvancesNonBankValue.setUnitRef(currency);
        interestOnLoansAndAdvancesNonBankValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getInterestOnLoansAndAdvancesNonBank())));
        interestOnLoansAndAdvancesNonBankValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getInterestOnLoansAndAdvancesNonBank()));
        JAXBElement<MonetaryItemType> interestOnLoansAndAdvancesNonBank = rbiObjectFactory.createInterestOnLoansAndAdvancesNonBank(interestOnLoansAndAdvancesNonBankValue);
        bodyItems.add(interestOnLoansAndAdvancesNonBank);

        // create InterestOnGovernmentSecurities
        MonetaryItemType interestOnGovernmentSecuritiesValue = new MonetaryItemType();
        interestOnGovernmentSecuritiesValue.setContextRef(fromtodateofreport);  
        interestOnGovernmentSecuritiesValue.setUnitRef(currency);
        interestOnGovernmentSecuritiesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getInterestOnGovernmentSecurities())));
        interestOnGovernmentSecuritiesValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getInterestOnGovernmentSecurities()));
        JAXBElement<MonetaryItemType> interestOnGovernmentSecurities = rbiObjectFactory.createInterestOnGovernmentSecurities(interestOnGovernmentSecuritiesValue);
        bodyItems.add(interestOnGovernmentSecurities);

        // create InterestOnOtherInvestments
        MonetaryItemType interestOnOtherInvestmentsValue = new MonetaryItemType();
        interestOnOtherInvestmentsValue.setContextRef(fromtodateofreport);  
        interestOnOtherInvestmentsValue.setUnitRef(currency);
        interestOnOtherInvestmentsValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getInterestOnOtherInvestments())));
        interestOnOtherInvestmentsValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getInterestOnOtherInvestments()));
        JAXBElement<MonetaryItemType> interestOnOtherInvestments = rbiObjectFactory.createInterestOnOtherInvestments(interestOnOtherInvestmentsValue);
        bodyItems.add(interestOnOtherInvestments);

        // create InterestIncomeOnOtherInterestBearingAssets
        MonetaryItemType interestIncomeOnOtherInterestBearingAssetsValue = new MonetaryItemType();
        interestIncomeOnOtherInterestBearingAssetsValue.setContextRef(fromtodateofreport);  
        interestIncomeOnOtherInterestBearingAssetsValue.setUnitRef(currency);
        interestIncomeOnOtherInterestBearingAssetsValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getInterestIncomeOnOtherInterestBearingAssets())));
        interestIncomeOnOtherInterestBearingAssetsValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getInterestIncomeOnOtherInterestBearingAssets()));
        JAXBElement<MonetaryItemType> interestIncomeOnOtherInterestBearingAssets = rbiObjectFactory.createInterestIncomeOnOtherInterestBearingAssets(interestIncomeOnOtherInterestBearingAssetsValue);
        bodyItems.add(interestIncomeOnOtherInterestBearingAssets);

        // create InterestExpenses
        MonetaryItemType interestExpensesValue = new MonetaryItemType();
        interestExpensesValue.setContextRef(fromtodateofreport);  
        interestExpensesValue.setUnitRef(currency);
        interestExpensesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getInterestExpenses())));
        interestExpensesValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getInterestExpenses()));
        JAXBElement<MonetaryItemType> interestExpenses = rbiObjectFactory.createInterestExpenses(interestExpensesValue);
        bodyItems.add(interestExpenses);

        // create InterestExpensesOnCustomerDeposits
        MonetaryItemType interestExpensesOnCustomerDepositsValue = new MonetaryItemType();
        interestExpensesOnCustomerDepositsValue.setContextRef(fromtodateofreport);  
        interestExpensesOnCustomerDepositsValue.setUnitRef(currency);
        interestExpensesOnCustomerDepositsValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getInterestExpensesOnCustomerDeposits())));
        interestExpensesOnCustomerDepositsValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getInterestExpensesOnCustomerDeposits()));
        JAXBElement<MonetaryItemType> interestExpensesOnCustomerDeposits = rbiObjectFactory.createInterestExpensesOnCustomerDeposits(interestExpensesOnCustomerDepositsValue);
        bodyItems.add(interestExpensesOnCustomerDeposits);

        // create InterestExpensesOnInterBranchAndInterBankBorrowings
        MonetaryItemType interestExpensesOnInterBranchAndInterBankBorrowingsValue = new MonetaryItemType();
        interestExpensesOnInterBranchAndInterBankBorrowingsValue.setContextRef(fromtodateofreport);  
        interestExpensesOnInterBranchAndInterBankBorrowingsValue.setUnitRef(currency);
        interestExpensesOnInterBranchAndInterBankBorrowingsValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getInterestExpensesOnInterBranchAndInterBankBorrowings())));
        interestExpensesOnInterBranchAndInterBankBorrowingsValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getInterestExpensesOnInterBranchAndInterBankBorrowings()));
        JAXBElement<MonetaryItemType> interestExpensesOnInterBranchAndInterBankBorrowings = rbiObjectFactory.createInterestExpensesOnInterBranchAndInterBankBorrowings(interestExpensesOnInterBranchAndInterBankBorrowingsValue);
        bodyItems.add(interestExpensesOnInterBranchAndInterBankBorrowings);

        // create OtherInterestExpended
        MonetaryItemType otherInterestExpendedValue = new MonetaryItemType();
        otherInterestExpendedValue.setContextRef(fromtodateofreport);  
        otherInterestExpendedValue.setUnitRef(currency);
        otherInterestExpendedValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getOtherInterestExpended())));
        otherInterestExpendedValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getOtherInterestExpended()));
        JAXBElement<MonetaryItemType> otherInterestExpended = rbiObjectFactory.createOtherInterestExpended(otherInterestExpendedValue);
        bodyItems.add(otherInterestExpended);

        // create NetInterestIncome
        MonetaryItemType netInterestIncomeValue = new MonetaryItemType();
        netInterestIncomeValue.setContextRef(fromtodateofreport);  
        netInterestIncomeValue.setUnitRef(currency);
        netInterestIncomeValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getNetInterestIncome())));
        netInterestIncomeValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getNetInterestIncome()));
        JAXBElement<MonetaryItemType> netInterestIncome = rbiObjectFactory.createNetInterestIncome(netInterestIncomeValue);
        bodyItems.add(netInterestIncome);

        // create OtherIncome
        MonetaryItemType otherIncomeValue = new MonetaryItemType();
        otherIncomeValue.setContextRef(fromtodateofreport);  
        otherIncomeValue.setUnitRef(currency);
        otherIncomeValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getOtherIncome())));
        otherIncomeValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getOtherIncome()));
        JAXBElement<MonetaryItemType> otherIncome = rbiObjectFactory.createOtherIncome(otherIncomeValue);
        bodyItems.add(otherIncome);

        // create OtherFeeIncome
        MonetaryItemType otherFeeIncomeValue = new MonetaryItemType();
        otherFeeIncomeValue.setContextRef(fromtodateofreport);  
        otherFeeIncomeValue.setUnitRef(currency);
        otherFeeIncomeValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getOtherFeeIncome())));
        otherFeeIncomeValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getOtherFeeIncome()));
        JAXBElement<MonetaryItemType> otherFeeIncome = rbiObjectFactory.createOtherFeeIncome(otherFeeIncomeValue);
        bodyItems.add(otherFeeIncome);

        // create ProfitLossOnForexTrading
        MonetaryItemType profitLossOnForexTradingValue = new MonetaryItemType();
        profitLossOnForexTradingValue.setContextRef(fromtodateofreport);  
        profitLossOnForexTradingValue.setUnitRef(currency);
        profitLossOnForexTradingValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getProfitLossOnForexTrading())));
        profitLossOnForexTradingValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getProfitLossOnForexTrading()));
        JAXBElement<MonetaryItemType> profitLossOnForexTrading = rbiObjectFactory.createProfitLossOnForexTrading(profitLossOnForexTradingValue);
        bodyItems.add(profitLossOnForexTrading);

        // create ProfitLossOnSecuritiesTrading
        MonetaryItemType profitLossOnSecuritiesTradingValue = new MonetaryItemType();
        profitLossOnSecuritiesTradingValue.setContextRef(fromtodateofreport);  
        profitLossOnSecuritiesTradingValue.setUnitRef(currency);
        profitLossOnSecuritiesTradingValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getProfitLossOnSecuritiesTrading())));
        profitLossOnSecuritiesTradingValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getProfitLossOnSecuritiesTrading()));
        JAXBElement<MonetaryItemType> profitLossOnSecuritiesTrading = rbiObjectFactory.createProfitLossOnSecuritiesTrading(profitLossOnSecuritiesTradingValue);
        bodyItems.add(profitLossOnSecuritiesTrading);

        // create MiscellaneousIncome
        MonetaryItemType miscellaneousIncomeValue = new MonetaryItemType();
        miscellaneousIncomeValue.setContextRef(fromtodateofreport);  
        miscellaneousIncomeValue.setUnitRef(currency);
        miscellaneousIncomeValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getMiscellaneousIncome())));
        miscellaneousIncomeValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getMiscellaneousIncome()));
        JAXBElement<MonetaryItemType> miscellaneousIncome = rbiObjectFactory.createMiscellaneousIncome(miscellaneousIncomeValue);
        bodyItems.add(miscellaneousIncome);

        // create GrossIncome
        MonetaryItemType grossIncomeValue = new MonetaryItemType();
        grossIncomeValue.setContextRef(fromtodateofreport);  
        grossIncomeValue.setUnitRef(currency);
        grossIncomeValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getGrossIncome())));
        grossIncomeValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getGrossIncome()));
        JAXBElement<MonetaryItemType> grossIncome = rbiObjectFactory.createGrossIncome(grossIncomeValue);
        bodyItems.add(grossIncome);

        // create StaffExpenses
        MonetaryItemType staffExpensesValue = new MonetaryItemType();
        staffExpensesValue.setContextRef(fromtodateofreport);  
        staffExpensesValue.setUnitRef(currency);
        staffExpensesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getStaffExpenses())));
        staffExpensesValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getStaffExpenses()));
        JAXBElement<MonetaryItemType> staffExpenses = rbiObjectFactory.createStaffExpenses(staffExpensesValue);
        bodyItems.add(staffExpenses);

        // create OtherExpenses
        MonetaryItemType otherExpensesValue = new MonetaryItemType();
        otherExpensesValue.setContextRef(fromtodateofreport);  
        otherExpensesValue.setUnitRef(currency);
        otherExpensesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getOtherExpenses())));
        otherExpensesValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getOtherExpenses()));
        JAXBElement<MonetaryItemType> otherExpenses = rbiObjectFactory.createOtherExpenses(otherExpensesValue);
        bodyItems.add(otherExpenses);

        // create AggregateExpenses
        MonetaryItemType aggregateExpensesValue = new MonetaryItemType();
        aggregateExpensesValue.setContextRef(fromtodateofreport);  
        aggregateExpensesValue.setUnitRef(currency);
        aggregateExpensesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getAggregateExpenses())));
        aggregateExpensesValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getAggregateExpenses()));
        JAXBElement<MonetaryItemType> aggregateExpenses = rbiObjectFactory.createAggregateExpenses(aggregateExpensesValue);
        bodyItems.add(aggregateExpenses);

        // create OperatingSurplusDeficit
        MonetaryItemType operatingSurplusDeficitValue = new MonetaryItemType();
        operatingSurplusDeficitValue.setContextRef(fromtodateofreport);  
        operatingSurplusDeficitValue.setUnitRef(currency);
        operatingSurplusDeficitValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getOperatingSurplusDeficit())));
        operatingSurplusDeficitValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getOperatingSurplusDeficit()));
        JAXBElement<MonetaryItemType> operatingSurplusDeficit = rbiObjectFactory.createOperatingSurplusDeficit(operatingSurplusDeficitValue);
        bodyItems.add(operatingSurplusDeficit);

        // create BadDebtsWrittenoff
        MonetaryItemType badDebtsWrittenoffValue = new MonetaryItemType();
        badDebtsWrittenoffValue.setContextRef(fromtodateofreport);  
        badDebtsWrittenoffValue.setUnitRef(currency);
        badDebtsWrittenoffValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getBadDebtsWrittenoff())));
        badDebtsWrittenoffValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getBadDebtsWrittenoff()));
        JAXBElement<MonetaryItemType> badDebtsWrittenoff = rbiObjectFactory.createBadDebtsWrittenoff(badDebtsWrittenoffValue);
        bodyItems.add(badDebtsWrittenoff);

        // create ExtraordinaryLossAndOtherWriteOff
        MonetaryItemType extraordinaryLossAndOtherWriteOffValue = new MonetaryItemType();
        extraordinaryLossAndOtherWriteOffValue.setContextRef(fromtodateofreport);  
        extraordinaryLossAndOtherWriteOffValue.setUnitRef(currency);
        extraordinaryLossAndOtherWriteOffValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getExtraordinaryLossAndOtherWriteOff())));
        extraordinaryLossAndOtherWriteOffValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getExtraordinaryLossAndOtherWriteOff()));
        JAXBElement<MonetaryItemType> extraordinaryLossAndOtherWriteOff = rbiObjectFactory.createExtraordinaryLossAndOtherWriteOff(extraordinaryLossAndOtherWriteOffValue);
        bodyItems.add(extraordinaryLossAndOtherWriteOff);

        // create HeadOfficeAdministrationCharges
        MonetaryItemType headOfficeAdministrationChargesValue = new MonetaryItemType();
        headOfficeAdministrationChargesValue.setContextRef(fromtodateofreport);  
        headOfficeAdministrationChargesValue.setUnitRef(currency);
        headOfficeAdministrationChargesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getHeadOfficeAdministrationCharges())));
        headOfficeAdministrationChargesValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getHeadOfficeAdministrationCharges()));
        JAXBElement<MonetaryItemType> headOfficeAdministrationCharges = rbiObjectFactory.createHeadOfficeAdministrationCharges(headOfficeAdministrationChargesValue);
        bodyItems.add(headOfficeAdministrationCharges);

        // create ProvisionOtherThanTax
        MonetaryItemType provisionOtherThanTaxValue = new MonetaryItemType();
        provisionOtherThanTaxValue.setContextRef(fromtodateofreport);  
        provisionOtherThanTaxValue.setUnitRef(currency);
        provisionOtherThanTaxValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getProvisionOtherThanTax())));
        provisionOtherThanTaxValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getProvisionOtherThanTax()));
        JAXBElement<MonetaryItemType> provisionOtherThanTax = rbiObjectFactory.createProvisionOtherThanTax(provisionOtherThanTaxValue);
        bodyItems.add(provisionOtherThanTax);

        // create ProfitLossBeforeTax
        MonetaryItemType profitLossBeforeTaxValue = new MonetaryItemType();
        profitLossBeforeTaxValue.setContextRef(fromtodateofreport);  
        profitLossBeforeTaxValue.setUnitRef(currency);
        profitLossBeforeTaxValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getProfitLossBeforeTax())));
        profitLossBeforeTaxValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getProfitLossBeforeTax()));
        JAXBElement<MonetaryItemType> profitLossBeforeTax = rbiObjectFactory.createProfitLossBeforeTax(profitLossBeforeTaxValue);
        bodyItems.add(profitLossBeforeTax);

        // create NetPovisionOfTaxes
        MonetaryItemType netPovisionOfTaxesValue = new MonetaryItemType();
        netPovisionOfTaxesValue.setContextRef(fromtodateofreport);  
        netPovisionOfTaxesValue.setUnitRef(currency);
        netPovisionOfTaxesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getNetPovisionOfTaxes())));
        netPovisionOfTaxesValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getNetPovisionOfTaxes()));
        JAXBElement<MonetaryItemType> netPovisionOfTaxes = rbiObjectFactory.createNetPovisionOfTaxes(netPovisionOfTaxesValue);
        bodyItems.add(netPovisionOfTaxes);

        // create NetProfitLossForPeriod
        MonetaryItemType netProfitLossForPeriodValue = new MonetaryItemType();
        netProfitLossForPeriodValue.setContextRef(fromtodateofreport);  
        netProfitLossForPeriodValue.setUnitRef(currency);
        netProfitLossForPeriodValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getNetProfitLossForPeriod())));
        netProfitLossForPeriodValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getNetProfitLossForPeriod()));
        JAXBElement<MonetaryItemType> netProfitLossForPeriod = rbiObjectFactory.createNetProfitLossForPeriod(netProfitLossForPeriodValue);
        bodyItems.add(netProfitLossForPeriod);

        // create RemittanceToHeadOfficeExpenses
        MonetaryItemType remittanceToHeadOfficeExpensesValue = new MonetaryItemType();
        remittanceToHeadOfficeExpensesValue.setContextRef(fromtodateofreport);  
        remittanceToHeadOfficeExpensesValue.setUnitRef(currency);
        remittanceToHeadOfficeExpensesValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getRemittanceToHeadOfficeExpenses())));
        remittanceToHeadOfficeExpensesValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getRemittanceToHeadOfficeExpenses()));
        JAXBElement<MonetaryItemType> remittanceToHeadOfficeExpenses = rbiObjectFactory.createRemittanceToHeadOfficeExpenses(remittanceToHeadOfficeExpensesValue);
        bodyItems.add(remittanceToHeadOfficeExpenses);

        // create RemittanceToHeadOfficeProfit
        MonetaryItemType remittanceToHeadOfficeProfitValue = new MonetaryItemType();
        remittanceToHeadOfficeProfitValue.setContextRef(fromtodateofreport);  
        remittanceToHeadOfficeProfitValue.setUnitRef(currency);
        remittanceToHeadOfficeProfitValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getRemittanceToHeadOfficeProfit())));
        remittanceToHeadOfficeProfitValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getRemittanceToHeadOfficeProfit()));
        JAXBElement<MonetaryItemType> remittanceToHeadOfficeProfit = rbiObjectFactory.createRemittanceToHeadOfficeProfit(remittanceToHeadOfficeProfitValue);
        bodyItems.add(remittanceToHeadOfficeProfit);

        // create RemittanceToHeadOfficeOthers
        MonetaryItemType remittanceToHeadOfficeOthersValue = new MonetaryItemType();
        remittanceToHeadOfficeOthersValue.setContextRef(fromtodateofreport);  
        remittanceToHeadOfficeOthersValue.setUnitRef(currency);
        remittanceToHeadOfficeOthersValue.setDecimals(String.format("%s", CommonFns.getDecimals(ropItemData.getRopDateOfReport().getRemittanceToHeadOfficeOthers())));
        remittanceToHeadOfficeOthersValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getRemittanceToHeadOfficeOthers()));
        JAXBElement<MonetaryItemType> remittanceToHeadOfficeOthers = rbiObjectFactory.createRemittanceToHeadOfficeOthers(remittanceToHeadOfficeOthersValue);
        bodyItems.add(remittanceToHeadOfficeOthers);

        // create businessesPerEmployee
        DecimalItemType businessesPerEmployeeValue = new DecimalItemType();
        businessesPerEmployeeValue.setContextRef(fromtodateofreport);  
        businessesPerEmployeeValue.setDecimals("INF");
        businessesPerEmployeeValue.setUnitRef(percentage);
        businessesPerEmployeeValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getBusinessesPerEmployee()));
        JAXBElement<DecimalItemType> businessesPerEmployee = rbiObjectFactory.createBusinessesPerEmployee(businessesPerEmployeeValue);
        bodyItems.add(businessesPerEmployee);

        // create profitPerEmployee
        DecimalItemType profitPerEmployeeValue = new DecimalItemType();
        profitPerEmployeeValue.setContextRef(fromtodateofreport);  
        profitPerEmployeeValue.setDecimals("INF");
        profitPerEmployeeValue.setUnitRef(percentage);
        profitPerEmployeeValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getProfitPerEmployee()));
        JAXBElement<DecimalItemType> profitPerEmployee = rbiObjectFactory.createProfitPerEmployee(profitPerEmployeeValue);
        bodyItems.add(profitPerEmployee);

        // create AverageYieldOnInterestEarningAssets
        DecimalItemType averageYieldOnInterestEarningAssetsValue = new DecimalItemType();
        averageYieldOnInterestEarningAssetsValue.setContextRef(fromtodateofreport);  
        averageYieldOnInterestEarningAssetsValue.setDecimals("2");
        averageYieldOnInterestEarningAssetsValue.setUnitRef(percentage);
        averageYieldOnInterestEarningAssetsValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getAverageYieldOnInterestEarningAssets()));
        JAXBElement<DecimalItemType> averageYieldOnInterestEarningAssets = rbiObjectFactory.createAverageYieldOnInterestEarningAssets(averageYieldOnInterestEarningAssetsValue);
        bodyItems.add(averageYieldOnInterestEarningAssets);

        // create CostOfFundsAveragePercentage
        DecimalItemType costOfFundsAveragePercentageValue = new DecimalItemType();
        costOfFundsAveragePercentageValue.setContextRef(fromtodateofreport);  
        costOfFundsAveragePercentageValue.setDecimals("INF");
        costOfFundsAveragePercentageValue.setUnitRef(percentage);
        costOfFundsAveragePercentageValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getCostOfFundsAveragePercentage()));
        JAXBElement<DecimalItemType> costOfFundsAveragePercentage = rbiObjectFactory.createCostOfFundsAveragePercentage(costOfFundsAveragePercentageValue);
        bodyItems.add(costOfFundsAveragePercentage);

        // create ReturnsOnAssets
        DecimalItemType returnsOnAssetsValue = new DecimalItemType();
        returnsOnAssetsValue.setContextRef(fromtodateofreport);  
        returnsOnAssetsValue.setDecimals("INF");
        returnsOnAssetsValue.setUnitRef(percentage);
        returnsOnAssetsValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getReturnsOnAssets()));
        JAXBElement<DecimalItemType> returnsOnAssets = rbiObjectFactory.createReturnsOnAssets(returnsOnAssetsValue);
        bodyItems.add(returnsOnAssets);

        // create InterestSpreadInReturnOnProfitability
        DecimalItemType interestSpreadInReturnOnProfitabilityValue = new DecimalItemType();
        interestSpreadInReturnOnProfitabilityValue.setContextRef(fromtodateofreport);  
        interestSpreadInReturnOnProfitabilityValue.setDecimals("INF");
        interestSpreadInReturnOnProfitabilityValue.setUnitRef(percentage);
        interestSpreadInReturnOnProfitabilityValue.setValue(new BigDecimal(ropItemData.getRopDateOfReport().getInterestSpreadInReturnOnProfitability()));
        JAXBElement<DecimalItemType> interestSpreadInReturnOnProfitability = rbiObjectFactory.createInterestSpreadInReturnOnProfitability(interestSpreadInReturnOnProfitabilityValue);
        bodyItems.add(interestSpreadInReturnOnProfitability);

        return bodyItems;
            
        }
    
}
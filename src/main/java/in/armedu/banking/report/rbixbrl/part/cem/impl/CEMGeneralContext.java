package in.armedu.banking.report.rbixbrl.part.cem.impl;

import java.util.HashMap;
import java.util.Map;

import org.xbrl._2003.instance.Context;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.cem.CEMGeneralData;
import in.armedu.banking.report.rbixbrl.model.cem.CEMItemData;
import in.armedu.banking.report.rbixbrl.part.ContextInterface;

public class CEMGeneralContext implements ContextInterface {

    @Override
    public Map<String, Context> getContext(GeneralData generalData) {
    CEMGeneralData cemGeneralData = (CEMGeneralData) generalData;
    Map<String, Context> contexts = new HashMap<String, Context>();

    // create fromto context
    Context fromToContext = CEMUtil.createFromToContext(cemGeneralData.getBankCode(), cemGeneralData.getReportingPeriodStartDate(), cemGeneralData.getReportingDate(), null);
    contexts.put(CEMUtil.FROMTO, fromToContext);

    // create asof context
    Context asOfContext = CEMUtil.createAsOfContext(cemGeneralData.getBankCode(), cemGeneralData.getReportingDate(), null);
    contexts.put(CEMUtil.ASOF , asOfContext);


    return contexts;
}

@Override
public Map<String, Context> getContext(GeneralData generalData, ItemData itemData) {
    CEMGeneralData cemGeneralData = (CEMGeneralData) generalData;
    CEMItemData cemItemData = (CEMItemData) itemData;
    Map<String, Context> contexts = new HashMap<String, Context>();

    // create asof context Member
    Context asofContextBetweenSixMonthMember = CEMUtil.createAsOfContextForMembers(cemGeneralData.getBankCode(), cemGeneralData.getReportingDate(), cemItemData.getRiskClassificationAxis(),
    "BetweenSixMonthMember", cemItemData.getCountryCodeAxis(), cemItemData.getBranchCodeAxis(), cemItemData.getExposureCountryCodeAxis());
    contexts.put(CEMUtil.ASOFBETWEENSIXMONTHMEMBER , asofContextBetweenSixMonthMember);

    Context asofContextOverSixMonthsAndUptoOneYearMember = CEMUtil.createAsOfContextForMembers(cemGeneralData.getBankCode(), cemGeneralData.getReportingDate(), cemItemData.getRiskClassificationAxis(),
    "OverSixMonthsAndUptoOneYearMember", cemItemData.getCountryCodeAxis(), cemItemData.getBranchCodeAxis(), cemItemData.getExposureCountryCodeAxis());
    contexts.put(CEMUtil.ASOFOVERSIXMONTHSANDUPTOONEYEARMEMBER , asofContextOverSixMonthsAndUptoOneYearMember);

    Context asofContextOverOneYearAndUptoFiveYearMember = CEMUtil.createAsOfContextForMembers(cemGeneralData.getBankCode(), cemGeneralData.getReportingDate(), cemItemData.getRiskClassificationAxis(),
    "OverOneYearAndUptoFiveYearMember", cemItemData.getCountryCodeAxis(), cemItemData.getBranchCodeAxis(), cemItemData.getExposureCountryCodeAxis());
    contexts.put(CEMUtil.ASOFOVERONEYEARANDUPTOFIVEYEARMEMBER , asofContextOverOneYearAndUptoFiveYearMember);

    Context asofContextOverFiveYearsMember = CEMUtil.createAsOfContextForMembers(cemGeneralData.getBankCode(), cemGeneralData.getReportingDate(), cemItemData.getRiskClassificationAxis(),
    "OverFiveYearsMember", cemItemData.getCountryCodeAxis(), cemItemData.getBranchCodeAxis(), cemItemData.getExposureCountryCodeAxis());
    contexts.put(CEMUtil.ASOFOVERFIVEYEARSMEMBER , asofContextOverFiveYearsMember);

    Context asofContextRiskClassification = CEMUtil.createAsOfRiskClassification(cemGeneralData.getBankCode(), cemGeneralData.getReportingDate(), cemItemData.getRiskClassificationAxis(),
    cemItemData.getCountryCodeAxis(), cemItemData.getBranchCodeAxis(), cemItemData.getExposureCountryCodeAxis());
    contexts.put(CEMUtil.ASOFRISKCLASSIFICATION , asofContextRiskClassification);

    return contexts;

    }

}

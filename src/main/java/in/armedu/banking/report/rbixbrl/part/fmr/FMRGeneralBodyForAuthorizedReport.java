package in.armedu.banking.report.rbixbrl.part.fmr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.rbi.in.xbrl._2012_05_07.in_rbi_rep_types.ReportStatusItemType;
import org.xbrl._2003.instance.BooleanItemType;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.DateItemType;
import org.xbrl._2003.instance.StringItemType;
import org.xbrl._2003.instance.Unit;

import in.armedu.banking.report.rbixbrl.model.GeneralData;
import in.armedu.banking.report.rbixbrl.model.ItemData;
import in.armedu.banking.report.rbixbrl.model.fmr.FMRGeneralData;
import in.armedu.banking.report.rbixbrl.part.BodyInterface;

public class FMRGeneralBodyForAuthorizedReport implements BodyInterface {

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units, GeneralData generalData) {
        List<Object> generalItems = new ArrayList<Object>();
        Context fromToContext = contexts.get(FMRUtil.FROMTO);
        FMRGeneralData fmrGeneralData = (FMRGeneralData) generalData;
        org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory rbiObjectFactory;
        rbiObjectFactory = new org.rbi.in.xbrl._2012_04_25.rbi.ObjectFactory();
        // create NameOfAuthorisedReportingOfficial
        StringItemType nameOfAuthorisedReportingOfficialType = new StringItemType();
        nameOfAuthorisedReportingOfficialType.setContextRef(fromToContext);
        nameOfAuthorisedReportingOfficialType.setValue(fmrGeneralData.getAuthorizedReporting().getNameOfAuthorisedReportingOfficial());
        JAXBElement<StringItemType> nameOfAuthorisedReportingOfficial = rbiObjectFactory.createNameOfAuthorisedReportingOfficial(nameOfAuthorisedReportingOfficialType);
        generalItems.add(nameOfAuthorisedReportingOfficial);
        //  TODO add remaining elements       
        
        return generalItems;
    }

    @Override
    public List<Object> getReportBodyItem(Map<String, Context> contexts, Map<String, Unit> units,
            GeneralData generalInfoData, ItemData rosItem) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
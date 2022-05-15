package in.armedu.banking.report.rbixbrl.reports;

import in.armedu.banking.report.rbixbrl.part.impl.ROSBody;
import in.armedu.banking.report.rbixbrl.part.impl.ROSGeneralBody;
import in.armedu.banking.report.rbixbrl.part.impl.ROSGeneralContext;
import in.armedu.banking.report.rbixbrl.part.impl.ROSUnit;
import in.armedu.banking.report.rbixbrl.reports.impl.RBIROSXBRLReportImpl;

public class XBRLReportBuilder {
    public XBRLReportIntf buildROSReport(){
        RBIROSXBRLReportImpl report = new RBIROSXBRLReportImpl();
        report.setContextIntf(new ROSGeneralContext());
        report.setRosUnits(new ROSUnit());
        report.setRosGeneralBody(new ROSGeneralBody());
        report.setRosBody(new ROSBody());
        return report;
    }
}

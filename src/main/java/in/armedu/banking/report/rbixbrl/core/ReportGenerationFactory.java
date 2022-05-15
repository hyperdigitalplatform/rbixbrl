package in.armedu.banking.report.rbixbrl.core;

import in.armedu.banking.report.rbixbrl.reports.XBRLReportBuilder;
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;

public class ReportGenerationFactory {
    public static final String RBI_ROS_XBRL_REPORT = "RBI_ROS_XBRL_REPORT";

    public XBRLReportIntf createXBRLReport(String reportType){
        if(reportType == null) return null;
        else if(RBI_ROS_XBRL_REPORT.equalsIgnoreCase(reportType)) {
            return new XBRLReportBuilder().buildROSReport();
        }
        return null;
    }
}

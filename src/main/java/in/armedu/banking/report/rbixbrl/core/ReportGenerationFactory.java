package in.armedu.banking.report.rbixbrl.core;

import in.armedu.banking.report.rbixbrl.reports.XBRLReportBuilder;
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;

public class ReportGenerationFactory {
    public static final String RBI_ROS_XBRL_REPORT = "RBI_ROS_XBRL_REPORT";
    public static final String RBI_RLC_XBRL_REPORT = "RBI_RLC_XBRL_REPORT";

    
    public XBRLReportIntf createXBRLReport(String reportType){
        // return null if report type is null
        if(reportType == null) return null;
        // build ROS report
        else if(RBI_ROS_XBRL_REPORT.equalsIgnoreCase(reportType)) {
            return new XBRLReportBuilder().buildROSReport();
        } else if(RBI_RLC_XBRL_REPORT.equalsIgnoreCase(reportType)) { // build RLC report
            return new XBRLReportBuilder().buildRLCReport();
        }
        return null;
    }
}

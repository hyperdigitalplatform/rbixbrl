package in.armedu.banking.report.rbixbrl.core;

import in.armedu.banking.report.rbixbrl.core.impl.XBRLReportGenerationEngine;

public class ReportGenerationEngineFactory {
    public final String xbrlReportType = "XBRLReportType";

    public ReportGenerationEngine reportGenerationEngine(String reportType){
        if(reportType == null) return null;
        else if(reportType.equalsIgnoreCase(xbrlReportType)) {
            return new XBRLReportGenerationEngine();
        }
        return null;
    }
}

package in.armedu.banking.report.rbixbrl.core.impl;

import java.io.StringWriter;

import in.armedu.banking.report.rbixbrl.core.ReportGenerationEngine;
import in.armedu.banking.report.rbixbrl.core.ReportGenerationFactory;
import in.armedu.banking.report.rbixbrl.model.ReportData;
import in.armedu.banking.report.rbixbrl.reports.XBRLReportIntf;

public class XBRLReportGenerationEngine implements ReportGenerationEngine {
    ReportGenerationFactory reportFactory = new ReportGenerationFactory();
    @Override
    public StringWriter execute(String reportType, ReportData data) {
        XBRLReportIntf xbrlReport = reportFactory.createXBRLReport(reportType);
        return xbrlReport.generateReport(data);
    }
    
}

package in.armedu.banking.report.rbixbrl.reports;

import java.io.StringWriter;

import in.armedu.banking.report.rbixbrl.model.ReportData;

public interface XBRLReportIntf {
    public StringWriter generateReport(ReportData reportData);
}

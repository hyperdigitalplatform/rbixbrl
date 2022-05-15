package in.armedu.banking.report.rbixbrl.core;


import java.io.StringWriter;

import in.armedu.banking.report.rbixbrl.model.ReportData;


public interface ReportGenerationEngine {
    public StringWriter execute(String reportType, ReportData reportData);
}
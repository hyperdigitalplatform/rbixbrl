package in.armedu.banking.report.rbixbrl.core;


import java.io.StringWriter;


public interface ReportGenerationEngine {
    public void setInput(String reportName, Object obj);
    public StringWriter execute();
}
package api.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.ExtentTest;

public class BaseForReportAndLogging {

    protected Logger logger; // Log4j logger

    // Call this before any logging
    protected void initLoggers(Class<?> testClass) {
        if (logger == null) {
            logger = LogManager.getLogger(testClass);
        }
        // ❌ Do NOT initialize extentLogger here
    }

    public Logger getLogger() {
        return logger;
    }

    // ✅ Always fetch fresh ExtentTest
    public ExtentTest getExtentLogger() {
        return ExtentReportManager.getTest();
    }
}

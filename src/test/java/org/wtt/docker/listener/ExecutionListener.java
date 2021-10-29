package org.wtt.docker.listener;

import java.time.LocalDateTime;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.time.format.DateTimeFormatter;

public class ExecutionListener implements ITestListener {
	
	private TestStatus testStatus;
	private String startTime;
	private long stime;
	private long etime;
	private String endTime;
	private   DateTimeFormatter dtf;
	private String result;

	public void onTestStart(ITestResult iTestResult) {
		this.testStatus = new TestStatus();
		dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	}

	public void onTestSuccess(ITestResult iTestResult) {
		this.sendStatus(iTestResult, "PASS");
		this.result = "PASSED";
	}

	public void onTestFailure(ITestResult iTestResult) {
		this.sendStatus(iTestResult, "FAIL");
	}

	public void onTestSkipped(ITestResult iTestResult) {
		this.sendStatus(iTestResult, "SKIPPED");
		this.result = "SKIPPED";
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		// skip
	}

	public void onStart(ITestContext iTestContext) {
		 LocalDateTime now = LocalDateTime.now();
		 stime = System.currentTimeMillis();
		 startTime = dtf.format(now);
	}

	public void onFinish(ITestContext iTestContext) {
		// skip
	}

	public void onTestFailure1(ITestResult Result) {
		System.out.println("The name of the testcase failed is :" + Result.getThrowable().getMessage());
		result = Result.getThrowable().getMessage();
		testStatus.setResult(result);
	}

	private void sendStatus(ITestResult iTestResult, String status) {
		 LocalDateTime now = LocalDateTime.now();
		 endTime = dtf.format(now);
		 etime = System.currentTimeMillis();
		this.testStatus.setTestClass(iTestResult.getTestClass().getName());
		this.testStatus.setDescription(iTestResult.getMethod().getDescription());
		this.testStatus.setTestName(iTestResult.getMethod().getMethodName());
		this.testStatus.setStatus(status);
		this.testStatus.setExecutionDate(dtf.format(LocalDateTime.now()));
		this.testStatus.setEndTime(endTime);
		this.testStatus.setStartTime(startTime);
		if(status.equalsIgnoreCase("PASS")){
			this.testStatus.setResult("PASS");

		}else if(status.equalsIgnoreCase("SKIPPED")) {
			this.testStatus.setResult("SKIPPED");
		}else if(status.equalsIgnoreCase( "FAIL")) {
			this.testStatus.setResult(iTestResult.getThrowable().getLocalizedMessage());
		}
		
		long el = etime - stime;
		this.testStatus.setDuration((el/1000) + "s");
		this.testStatus.setTestPlanId(PropertiesUtility.properties.getProperty("test.planId"));
		ResultSender.send(this.testStatus);
	}

}

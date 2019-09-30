package com.api.apitester;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.json.Json;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.api.apitester.utility.Excel;

public class CreateAPI {
	
	
	File path = new File("C:\\Users\\ashjagad\\Documents\\apitester\\apitester\\JsonTestdata\\JsonOutput.txt");

	@Test 
	public void createApi() throws Exception {
		
	    int x = 1;
	    int y = 1; 
	    while (x <= 21 & y <= 21) 
	    	
        { 
	
		FileWriter writer = null;

		try {

			writer = new FileWriter(path);

		} catch (IOException e) {

			e.printStackTrace();
		}
	
    JsonGenerator gen = Json.createGenerator(writer);
    
    String sequenceNumber = Excel.getExcelData("FEEBASED",1, x);
    String requestType = Excel.getExcelData("FEEBASED",2, x);
    String refNumber = Excel.getExcelData("FEEBASED",3, x);
    String sysId = Excel.getExcelData("FEEBASED",4, x);
    String name = Excel.getExcelData("FEEBASED",5, x);
    String description = Excel.getExcelData("FEEBASED",6, x);
    String folderName = Excel.getExcelData("FEEBASED",7, x);
    String accessType = Excel.getExcelData("FEEBASED",8, x);
    String customerStatus = Excel.getExcelData("FEEBASED",9, x);
    String customerId = Excel.getExcelData("FEEBASED",10, x);
    String customerName = Excel.getExcelData("FEEBASED",11, x);
    String customerType = Excel.getExcelData("FEEBASED",12, x);
    String accountStatus = Excel.getExcelData("FEEBASED",13, x);
    String accountNumber = Excel.getExcelData("FEEBASED",14, x);
    String relationshipManager = Excel.getExcelData("FEEBASED",15, x);
    String industry  = Excel.getExcelData("FEEBASED",16, x);
    String infoAsOn  = Excel.getExcelData("FEEBASED",17, x);
    String ebdit  = Excel.getExcelData("FEEBASED",18, x);
    String tax  = Excel.getExcelData("FEEBASED",19, x);
    String deprecation  = Excel.getExcelData("FEEBASED",20, x);
    String eps  = Excel.getExcelData("FEEBASED",22, x);
    String leverageRatio  = Excel.getExcelData("FEEBASED",23, x);
    String longTrmDb  = Excel.getExcelData("FEEBASED",24, x);
    String noOfEmp  = Excel.getExcelData("FEEBASED",25, x);
    String ratingSrc  = Excel.getExcelData("FEEBASED",26, x);
    String addLine2  = Excel.getExcelData("FEEBASED",27, x);
    String addLine3  = Excel.getExcelData("FEEBASED",28, x);
    String city = Excel.getExcelData("FEEBASED",29, x);
    String state  = Excel.getExcelData("FEEBASED",30, x);
    String turnOver  = Excel.getExcelData("FEEBASED",31, x);
    String groupAsset  = Excel.getExcelData("FEEBASED",32, x);
    String currency  = Excel.getExcelData("FEEBASED",33, x);
    String countryOfIncorporation  = Excel.getExcelData("FEEBASED",34, x);
    String statusOfListing  = Excel.getExcelData("FEEBASED",35, x);
    String dateOfIncorporation  = Excel.getExcelData("FEEBASED",36, x);
    String earningAfterTax  = Excel.getExcelData("FEEBASED",37, x);
    String interesetCoverageRatio  = Excel.getExcelData("FEEBASED",38, x);
    String obligorRating  = Excel.getExcelData("FEEBASED",39, x);
    String organizationName  = Excel.getExcelData("FEEBASED",40, x);
    String address = Excel.getExcelData("FEEBASED",41, x);
    String debtCoverageRatio  = Excel.getExcelData("FEEBASED",42, x);
    String industrya  = Excel.getExcelData("FEEBASED",43, x);
    String employementType  = Excel.getExcelData("FEEBASED",44, x);
    String permanentResident  = Excel.getExcelData("FEEBASED",45, x);
    String occupation = Excel.getExcelData("FEEBASED",46, x);
    String region = Excel.getExcelData("FEEBASED",47, x);
    String srCitizenSts  = Excel.getExcelData("FEEBASED",48, x);
    String score = Excel.getExcelData("FEEBASED",49, x);
    String maritalStatus  = Excel.getExcelData("FEEBASED",50, x);
    String nationality = Excel.getExcelData("FEEBASED",51, x);
    String currencya = Excel.getExcelData("FEEBASED",52, x);
    String infoAsOna = Excel.getExcelData("FEEBASED",53, x);
    String firstName = Excel.getExcelData("FEEBASED",54, x);
    String lastName = Excel.getExcelData("FEEBASED",55, x);
    String middleName = Excel.getExcelData("FEEBASED",56, x);
    String dateOfBirth = Excel.getExcelData("FEEBASED",57, x);
    String industryType = Excel.getExcelData("FEEBASED",58, x);
    String customerIncome = Excel.getExcelData("FEEBASED",59, x);
    String customerAge  = Excel.getExcelData("FEEBASED",60, x);
    String customerGender  = Excel.getExcelData("FEEBASED",61, x);
    String scoreSource  = Excel.getExcelData("FEEBASED",62, x);
    String offerDefinitionName = Excel.getExcelData("FEEBASED",63, x);
    String productDealname = Excel.getExcelData("FEEBASED",64, x);
    String folderNamea = Excel.getExcelData("FEEBASED",65, x);
    String offerName = Excel.getExcelData("FEEBASED",66, x);
    String targetMeasure = Excel.getExcelData("FEEBASED",67, x);
    String targetMeasureValue = Excel.getExcelData("FEEBASED",68, x);
    String mitigantStaus  = Excel.getExcelData("FEEBASED",69, x);
    String mitigantId  = Excel.getExcelData("FEEBASED",70, x);
    String mitigantName  = Excel.getExcelData("FEEBASED",71, x);
    String mitiganType = Excel.getExcelData("FEEBASED",72, x);
    String startDt = Excel.getExcelData("FEEBASED",73, x);
    String maturitDt = Excel.getExcelData("FEEBASED",74, x);
    String mitigantIssuer = Excel.getExcelData("FEEBASED",75, x);
    String issuerType = Excel.getExcelData("FEEBASED",76, x);
    String ratingSrca = Excel.getExcelData("FEEBASED",77, x);
    String issuerRating = Excel.getExcelData("FEEBASED",78, x);
    String mitigantRating = Excel.getExcelData("FEEBASED",79, x);
    String revFreq = Excel.getExcelData("FEEBASED",80, x);
    String mitigantValue = Excel.getExcelData("FEEBASED",81, x);
    String mitigantCurrency = Excel.getExcelData("FEEBASED",82, x);
    String collateralType = Excel.getExcelData("FEEBASED",83, x);
    String dealAmortizationType = Excel.getExcelData("FEEBASED",84, x);
    String dealName = Excel.getExcelData("FEEBASED",85, x);
    String dealAmount = Excel.getExcelData("FEEBASED",86, x);
    String dealLimit = Excel.getExcelData("FEEBASED",87, x);
    String startDate = Excel.getExcelData("FEEBASED",88, x);
    String maturityDt = Excel.getExcelData("FEEBASED",89, x);
    String currencyb = Excel.getExcelData("FEEBASED",90, x);
    String fixedRate = Excel.getExcelData("FEEBASED",91, x);
    String floatRateSpred = Excel.getExcelData("FEEBASED",92, x);
    String minReqRate = Excel.getExcelData("FEEBASED",93, x);
    String capitalChrg = Excel.getExcelData("FEEBASED",94, x);
    String seniority = Excel.getExcelData("FEEBASED",95, x);
    String profDrv = Excel.getExcelData("FEEBASED",96, x);
    String profDrvSch = Excel.getExcelData("FEEBASED",97, x);
    String accuralBasis = Excel.getExcelData("FEEBASED",98, x);
    String roundingFactor = Excel.getExcelData("FEEBASED",99, x);
    String rateSetLag = Excel.getExcelData("FEEBASED",100, x);
    String rateSetLagUnit = Excel.getExcelData("FEEBASED",101, x);
    String teasePeriod = Excel.getExcelData("FEEBASED",102, x);
    String teasePeriodUnit = Excel.getExcelData("FEEBASED",103, x);
    String teaseDiscount = Excel.getExcelData("FEEBASED",104, x);
    String compoundBasis = Excel.getExcelData("FEEBASED",105, x);
    String capCmpMthd = Excel.getExcelData("FEEBASED",106, x);
    String expRating = Excel.getExcelData("FEEBASED",107, x);
    String intExpRating = Excel.getExcelData("FEEBASED",108, x);
    String slNum = Excel.getExcelData("FEEBASED",109, x);
    String date = Excel.getExcelData("FEEBASED",110, x);
    String amount = Excel.getExcelData("FEEBASED",111, x);
    String slNuma = Excel.getExcelData("FEEBASED",112, x);
    String datea = Excel.getExcelData("FEEBASED",113, x);
    String amounta = Excel.getExcelData("FEEBASED",114, x);
    String annualfees = Excel.getExcelData("FEEBASED",115, x);
    String offsetAccount = Excel.getExcelData("FEEBASED",116, x);
    String otherfee = Excel.getExcelData("FEEBASED",117, x);
    String maturityRateDuration = Excel.getExcelData("FEEBASED",118, x);
    String maturityRateDurationMult = Excel.getExcelData("FEEBASED",119, x);
    String offsetToLoan = Excel.getExcelData("FEEBASED",120, x);
    String balanceTransfer = Excel.getExcelData("FEEBASED",121, x);
    String balanceTransferDate = Excel.getExcelData("FEEBASED",122, x);
    String interchange = Excel.getExcelData("FEEBASED",123, x);
    String segmentation_cd = Excel.getExcelData("FEEBASED",124, x);
    String payments = Excel.getExcelData("FEEBASED",125, x);
    String purchaseSpread = Excel.getExcelData("FEEBASED",126, x);
    String purchaseRate = Excel.getExcelData("FEEBASED",127, x);
    String balanceSpread = Excel.getExcelData("FEEBASED",128, x);
    String balanceTransferRate = Excel.getExcelData("FEEBASED",129, x);
    String goToSpread = Excel.getExcelData("FEEBASED",130, x);
    String goToRate = Excel.getExcelData("FEEBASED",131, x);
    String productType = Excel.getExcelData("FEEBASED",132, x);
    String productCode = Excel.getExcelData("FEEBASED",133, x);
    String pricingMethodology = Excel.getExcelData("FEEBASED",134, x);
    String interestRateType = Excel.getExcelData("FEEBASED",135, x);
    String floatingRateBenchmark = Excel.getExcelData("FEEBASED",136, x);
    String fixedRateTenure = Excel.getExcelData("FEEBASED",137, x);
    String fixedRateTenureUnit = Excel.getExcelData("FEEBASED",138, x);
    String repricingFrequency = Excel.getExcelData("FEEBASED",139, x);
    String repricingFrequencyUnit = Excel.getExcelData("FEEBASED",140, x);
    String originationFees = Excel.getExcelData("FEEBASED",141, x);
    String disbursementType = Excel.getExcelData("FEEBASED",142, x);
    String repaymentType = Excel.getExcelData("FEEBASED",143, x);
    String paymentFrequency = Excel.getExcelData("FEEBASED",144, x);
    String paymentFrequencyUnit = Excel.getExcelData("FEEBASED",145, x);
    String amortizationType = Excel.getExcelData("FEEBASED",146, x);
    String adjustableType = Excel.getExcelData("FEEBASED",147, x);
    String interestPaymentTiming = Excel.getExcelData("FEEBASED",148, x);
    String rateRoundingType = Excel.getExcelData("FEEBASED",149, x);
    String amortizationTerm = Excel.getExcelData("FEEBASED",150, x);
    String amortizationTermUnit = Excel.getExcelData("FEEBASED",151, x);
    String originalTerm = Excel.getExcelData("FEEBASED",152, x);
    String originalTermUnit = Excel.getExcelData("FEEBASED",153, x);
    String rate = Excel.getExcelData("FEEBASED",154, x);
    String startDatea = Excel.getExcelData("FEEBASED",155, x);
    String endDate = Excel.getExcelData("FEEBASED",156, x);
    String rateType = Excel.getExcelData("FEEBASED",157, x);
    String goToRatea = Excel.getExcelData("FEEBASED",158, x);
    String purchaseRatea = Excel.getExcelData("FEEBASED",159, x);
    String balanceRate = Excel.getExcelData("FEEBASED",160, x);
    String customerTypea = Excel.getExcelData("FEEBASED",161, x);
    String transferPriceMode = Excel.getExcelData("FEEBASED",162, x);
    String expectedLossMode = Excel.getExcelData("FEEBASED",163, x);
    String averageBalanceMode = Excel.getExcelData("FEEBASED",164, x);
    String unexpectedLossMode = Excel.getExcelData("FEEBASED",165, x);
    String miscellaneousFeeMode = Excel.getExcelData("FEEBASED",166, x);
    String otherIncomeMode = Excel.getExcelData("FEEBASED",167, x);
    String expensesMode = Excel.getExcelData("FEEBASED",168, x);
    String paymentsMode = Excel.getExcelData("FEEBASED",169, x);
    String purchaseMode = Excel.getExcelData("FEEBASED",170, x);
    String utilizationRateMode = Excel.getExcelData("FEEBASED",171, x);
    String revolveRateMode = Excel.getExcelData("FEEBASED",172, x);
    String transferPriceValue = Excel.getExcelData("FEEBASED",173, x);
    String expectedLossValue = Excel.getExcelData("FEEBASED",174, x);
    String averageBalanceValue = Excel.getExcelData("FEEBASED",175, x);
    String unexpectedLossValue = Excel.getExcelData("FEEBASED",176, x);
    String miscellaneousFeeValue = Excel.getExcelData("FEEBASED",177, x);
    String otherIncomeValue = Excel.getExcelData("FEEBASED",178, x);
    String expensesValue = Excel.getExcelData("FEEBASED",179, x);
    String paymentsValue = Excel.getExcelData("FEEBASED",180, x);
    String purchaseValue = Excel.getExcelData("FEEBASED",181, x);
    String utilizationRateValue = Excel.getExcelData("FEEBASED",182, x);
    String revolveRateValue = Excel.getExcelData("FEEBASED",183, x);
    String callType = Excel.getExcelData("FEEBASED",184, x);
    
    
    
    gen.writeStartObject().write("sequenceNumber", sequenceNumber)
    .write("requestType", requestType)
    .write("refNumber", refNumber)
    .write("sysId", sysId)
    .write("name", name)
    .write("description", description)
    .write("folderName", folderName)
    .write("accessType", accessType)
    .write("customerStatus", customerStatus)
    .write("customerId", customerId)
    .write("customerName", customerName)
    .write("customerType", customerType)
    .write("accountStatus", accountStatus)
    .write("accountNumber", accountNumber)
    .write("relationshipManager", relationshipManager)
    .writeStartObject("businessDetails")
		.write("industry", industry)
		.write("infoAsOn", infoAsOn)
		.write("ebdit", ebdit)
		.write("tax", tax)
		.write("deprecation", deprecation)
		.writeNull("intExpenses")
		.write("eps", eps)
		.write("leverageRatio", leverageRatio)
		.write("longTrmDb", longTrmDb)
		.write("noOfEmp", noOfEmp)
		.write("ratingSrc", ratingSrc)
		.write("addLine2", addLine2)
		.write("addLine3", addLine3)
		.write("city", city)
		.write("state", state)
		.write("turnOver", turnOver)
		.write("groupAsset", groupAsset)
		.write("currency", currencya)
		.write("countryOfIncorporation", countryOfIncorporation)
		.write("statusOfListing", statusOfListing)
		.write("dateOfIncorporation", dateOfIncorporation)
		.write("earningAfterTax", earningAfterTax)
		.write("interesetCoverageRatio", interesetCoverageRatio)
		.write("obligorRating", obligorRating)
		.write("organizationName", organizationName)
		.write("address", address)
		.write("debtCoverageRatio", debtCoverageRatio)		
		.writeEnd()     
        .writeStartObject("personalDetails")
    		.write("industry", industrya)
    		.write("employementType", employementType)
    		.write("permanentResident", permanentResident)
    		.write("occupation", occupation)
    		.write("region", region)
    		.write("srCitizenSts", srCitizenSts)
    		.write("score", score)
    		.write("maritalStatus", maritalStatus)
    		.write("nationality", nationality)
    		.write("currency", currencyb)
    		.write("infoAsOn", infoAsOna)
    		.write("firstName", firstName)
    		.write("lastName", lastName)
    		.write("middleName", middleName)
    		.write("dateOfBirth", dateOfBirth)
    		.write("industryType", industryType)
    		.write("customerIncome", customerIncome)
    		.write("customerAge", customerAge)
    		.write("customerGender", customerGender)
    		.write("scoreSource", scoreSource)
    	.writeEnd()
    	.writeStartObject("offerDetails")
        	.writeStartArray("offerList")
            	.writeStartObject().write("offerDefinitionName", offerDefinitionName)
                	.write("productDealname", productDealname)
                	.write("folderName", folderNamea)
                	.write("offerName", offerName)
                .writeEnd() 
            .writeEnd() 
        .writeEnd()
        .writeStartObject("optimizationDetails")
        	.write("targetMeasure", targetMeasure)
        	.write("targetMeasureValue", targetMeasureValue)
        .writeEnd()
        .writeStartObject("mitigants")
    		.writeStartArray("mitigantList")
    			.writeStartObject().write("mitigantStaus", mitigantStaus)
    				.write("mitigantId", mitigantId)
    				.write("mitigantName", mitigantName)
    				.write("mitiganType", mitiganType)
    				.write("startDt", startDt)
    				.write("maturitDt", maturitDt)
    				.write("mitigantIssuer", mitigantIssuer)
    				.write("issuerType", issuerType)
    				.write("ratingSrc", ratingSrca)
    				.write("issuerRating", issuerRating)
    				.write("mitigantRating", mitigantRating)
    				.write("revFreq", revFreq)
    				.write("mitigantValue", mitigantValue)
    				.write("mitigantCurrency", mitigantCurrency)
    				.write("collateralType", collateralType)
    			.writeEnd()
    		.writeEnd()
    	.writeEnd()
    
        .writeStartObject("products")
        	.writeStartArray("productList")
        	.writeStartObject().write("dealAmortizationType", dealAmortizationType)
        		.write("dealName", dealName)
        		.write("dealAmount", dealAmount)
        		.write("dealLimit", dealLimit)
        		.write("startDate", startDate)
        		.write("maturityDt", maturityDt)
        		.write("currency", currency)
        		.write("fixedRate", fixedRate)
        		.write("floatRateSpred", floatRateSpred)
        		.write("minReqRate", minReqRate)
        		.write("capitalChrg", capitalChrg)
        		.write("seniority", seniority)
        		.write("profDrv", profDrv)
        		.write("profDrvSch", profDrvSch)
        		.write("accuralBasis", accuralBasis)
        		.write("roundingFactor", roundingFactor)
        		.write("rateSetLag", rateSetLag)
        		.write("rateSetLagUnit", rateSetLagUnit)
        		.write("teasePeriod", teasePeriod)
        		.write("teasePeriodUnit", teasePeriodUnit)
        		.write("teaseDiscount", teaseDiscount)
        		.write("compoundBasis", compoundBasis)
        		.write("capCmpMthd", capCmpMthd)
        		.write("expRating", expRating)
        		.write("intExpRating", intExpRating)
        		.writeStartObject("disbursement")
            		.writeStartArray("disbursementList")
            			.writeStartObject().write("slNum", slNum)
            				.write("date", date)
            				.write("amount", amount)
            			.writeEnd()
            		.writeEnd()
            	.writeEnd()
            	.writeStartObject("payDetails")
        		.writeStartArray("paymenttList")
        			.writeStartObject().write("slNum", slNuma)
        				.write("date", datea)
        				.write("amount", amounta)
        			.writeEnd()
        		.writeEnd()
        	.writeEnd()
        	.writeStartObject("profDriver")
        		.writeStartObject("amounts")
        			.writeStartArray("amountList")
        			.writeEnd()
        		.writeEnd()
        	.writeEnd()
        	.write("annualfees", annualfees)
        	.write("offsetAccount", offsetAccount)
        	.write("otherfee", otherfee)
        	.write("maturityRateDuration", maturityRateDuration)
        	.write("maturityRateDurationMult", maturityRateDurationMult)
        	.write("offsetToLoan", offsetToLoan)
        	.write("balanceTransfer", balanceTransfer)
        	.write("balanceTransferDate", balanceTransferDate)
        	.write("interchange", interchange)
        	.write("segmentation_cd", segmentation_cd)
        	.write("payments", payments)
        	.write("purchaseSpread", purchaseSpread)
        	.write("purchaseRate", purchaseRate)
        	.write("balanceSpread", balanceSpread)
        	.write("balanceTransferRate", balanceTransferRate)
        	.write("goToSpread", goToSpread)
        	.write("goToRate", goToRate)
        	.write("productType", productType)
        	.write("productCode", productCode)
        	.write("pricingMethodology", pricingMethodology)
        	.write("interestRateType", interestRateType)
        	.write("floatingRateBenchmark", floatingRateBenchmark)
        	.write("fixedRateTenure", fixedRateTenure)
        	.write("fixedRateTenureUnit", fixedRateTenureUnit)
        	.write("repricingFrequency", repricingFrequency)
        	.write("repricingFrequencyUnit", repricingFrequencyUnit)
        	.write("originationFees", originationFees)
        	.write("disbursementType", disbursementType)
        	.write("repaymentType", repaymentType)
        	.write("paymentFrequency", paymentFrequency)
        	.write("paymentFrequencyUnit", paymentFrequencyUnit)
        	.write("amortizationType", amortizationType)
        	.write("adjustableType", adjustableType)
        	.write("interestPaymentTiming", interestPaymentTiming)
        	.write("rateRoundingType", rateRoundingType)
        	.write("amortizationTerm", amortizationTerm)
        	.write("amortizationTermUnit", amortizationTermUnit)
        	.write("originalTerm", originalTerm)
        	.write("originalTermUnit", originalTermUnit)
        	.writeStartObject("rateSchedule")
    		.writeStartArray("rateList")
    			.writeStartObject().write("rate", rate)    				
    				.write("startDate", startDatea)
    				.write("endDate", endDate)
    				.write("rateType", rateType)
    				.write("goToRate", goToRatea)
    				.write("purchaseRate", purchaseRatea)
    				.write("balanceRate", balanceRate)
    				.writeEnd()
    			.writeEnd()
    		.writeEnd()
    		.write("customerType", customerTypea)
    		.write("transferPriceMode", transferPriceMode)
    		.write("expectedLossMode", expectedLossMode)
    		.write("averageBalanceMode", averageBalanceMode)
    		.write("unexpectedLossMode", unexpectedLossMode)
    		.write("miscellaneousFeeMode", miscellaneousFeeMode)
    		.write("otherIncomeMode", otherIncomeMode)
    		.write("expensesMode", expensesMode)
    		.write("paymentsMode", paymentsMode)
    		.write("purchaseMode", purchaseMode)
    		.write("utilizationRateMode", utilizationRateMode)
    		.write("revolveRateMode", revolveRateMode)
    		.write("transferPriceValue", transferPriceValue)
    		.write("expectedLossValue", expectedLossValue)
    		.write("averageBalanceValue", averageBalanceValue)
    		.write("unexpectedLossValue", unexpectedLossValue)
    		.write("miscellaneousFeeValue", miscellaneousFeeValue)
    		.write("otherIncomeValue", otherIncomeValue)
    		.write("expensesValue", expensesValue)
    		.write("paymentsValue", paymentsValue)
    		.write("purchaseValue", purchaseValue)
    		.write("utilizationRateValue", utilizationRateValue)
    		.write("revolveRateValue", revolveRateValue)
    		.writeEnd()
    	.writeEnd()
    .writeEnd()
    .write("callType", callType)
  .writeEnd();
   
 gen.close();
   /*  int y = 1;
	while (y <= 3) 
	{ */
 
			try {

				String data = Excel.readFileAsString(
						"C:\\Users\\ashjagad\\Documents\\apitester\\apitester\\JsonTestdata\\JsonOutput.txt");

				System.out.println(data);

				Excel wr = new Excel();

				wr.writeToExcel("APIRequest", y, 2, data);
				HtmlReportHelper.getHtmlReporter().Insert_TC_Step(name , "", data, "Pass", null);
				
				System.out.println("Write data to an Excel Sheet");
			} catch (IOException e) {
				
				System.out.println(e.getMessage());

			}

			/* } */

			x++;
			y++;
		}
	}

}

package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class SendContactDetailsTest extends BaseClass
{
	@Test
	public void sendContactDetailsTest()
	{
		SoftAssert soft = new SoftAssert();
		home.clickGearsTab();
		home.clickSkillraryDemoApp();
		web.handleChildBrowser();
		
		soft.assertTrue(demoApp.getLogoText().contains("ECommerce"));
		
		web.scrollToElement(demoApp.getContactUs());
		demoApp.clickContactUs();
		
		soft.assertTrue(contact.getPageLogo().isDisplayed());
		home.chooseEnglish();
		Map<String,String> map = excel.readDataFromExcel("Sheet1");
		contact.sendDetails(map.get("fullname"),map.get("Email"),map.get("subject"),map.get("Message"));
		
		soft.assertAll();
	}

}

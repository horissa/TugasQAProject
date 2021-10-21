package automationtask.tugas;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basicFunction {
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	public basicFunction(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitwait) {
		this.driver = driver;
		this.explicitWait = explicitwait;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver.get(), this);
	}

	public void openUrl(String url) {
		driver.get().manage().window().maximize();
		driver.get().get(url);
//		driver.get().switchTo().alert().dismiss();
		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(30)));
	}
	
	public void switchWindow(int index) {
		Set<String> handles = driver.get().getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(handles);
		
		driver.get().switchTo().window(tabs.get(index));
	}
	
	public void switchIFrame(String name) {
		driver.get().switchTo().frame(name);
	}
	
	public void setIputText(By locator, String text) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		driver.get().findElement(locator).sendKeys(text);
	}
	
	public void clickButton(By locator) {
		
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public String extractData(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		return driver.get().findElement(locator).getText();
	}
}

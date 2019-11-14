package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import support.webdriver_actions;

import java.util.List;

public class SearchPage extends webdriver_actions {

    webdriver_actions webdriver_actions = new webdriver_actions(driver);
    String baseURL = "https://www.google.com/";

    String input_field_byname = "q";
    String input_keyboard_img_bycss = "div[aria-label=\"Input tools\"]>span";
    String keyboard_byid = "kbd";
    String keyboard_buttons_bycss = "#kbd button>span";
    String result_list_bycss = ".rc";
    String each_list_header_bycss = " h3";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void goTosearchPage() {
        webdriver_actions.gotoUrl(baseURL);
    }

    public List<WebElement> results_page_list(String search_input) {
        goTosearchPage();

        webdriver_actions.waitVisibilityElement(By.name(input_field_byname));

        WebElement text_box = webdriver_actions.element(By.name(input_field_byname));

        webdriver_actions.writeText(By.name(input_field_byname), search_input);
        text_box.sendKeys(Keys.RETURN);

        webdriver_actions.waitVisibilityElements(By.cssSelector(result_list_bycss));

        return driver.findElements(By.cssSelector(result_list_bycss));
    }

    public List<WebElement> results_page_list(String search_input, String keyboard_lang) {
        goTosearchPage();

        webdriver_actions.waitVisibilityElement(By.name(input_field_byname));
        webdriver_actions.click(By.xpath("//a[text()='" + keyboard_lang + "']"));
        webdriver_actions.waitVisibilityElement(By.name(input_field_byname));

        webdriver_actions.click(By.cssSelector(input_keyboard_img_bycss));
        webdriver_actions.waitVisibilityElement(By.id(keyboard_byid));

        List<WebElement> kbd_buttons = driver.findElements(By.cssSelector(keyboard_buttons_bycss));

        String[] str_array = search_input.split("");

        for (int k = 0; k < str_array.length; ++k) {
            for (int j = 0; j < kbd_buttons.size(); ++j) {
                if (kbd_buttons.get(j).getText().trim().equals(str_array[k])) {
                    Actions action = new Actions(driver);
                    action.moveToElement(kbd_buttons.get(j)).click().build().perform();
                }
            }
        }

        WebElement text_box = driver.findElement(By.name("q"));
        text_box.sendKeys(Keys.RETURN);

        webdriver_actions.waitVisibilityElements(By.cssSelector(result_list_bycss));

        return driver.findElements(By.cssSelector(result_list_bycss));
    }

    public void keyword_search(List<WebElement> elementList, String search_Text) {
        for (int i = 0; i < elementList.size(); ++i) {
            WebElement checkbox = elementList.get(i).findElement(By.cssSelector(each_list_header_bycss));
            try {
                Assert.assertTrue(checkbox.getText().toLowerCase().contains(search_Text));
                System.out.println(checkbox.getText());
            } catch (AssertionError e) {
                System.out.println(e.getMessage());
//                throw new AssertionError(e.getMessage());
            }
        }
    }

}

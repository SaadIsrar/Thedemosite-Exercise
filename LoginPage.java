import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(name = "username")
    private WebElement Usernamebox;
    @FindBy(name = "password")
    private WebElement Passwordbox;
    @FindBy(name = "FormsButton2")
    private WebElement TestLogin;
    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
    private WebElement loginMessage;


    public void enterdetails(){
        Usernamebox.sendKeys("saad");
        Passwordbox.sendKeys("saad");
        TestLogin.click();
    }

    public String getLoginMessage(){
        return loginMessage.getText();
    }

}

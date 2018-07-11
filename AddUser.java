import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUser {
    @FindBy(name ="username")
    private WebElement Usernamebox;
    @FindBy(name = "password")
    private WebElement Passwordbox;
    @FindBy (name ="FormsButton2")
    private WebElement save;

    public void enterdetails(){
        Usernamebox.sendKeys("saad");
        Passwordbox.sendKeys("saad");
        save.click();
    }
}

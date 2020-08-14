import com.company.Pages;
import com.company.pages.LoginPage;
import com.company.utils.Browser;
import com.company.utils.configuration.PropertiesHolder;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        PropertiesHolder.populateConfigurationProperties();
        PropertiesHolder.populateEnvironmentProperties();
        Browser.initialise();
        Pages.initialise();
        Pages.loginPage.goTo();

    }
}

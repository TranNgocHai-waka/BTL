package page.UI;

public class AddCustomerUI {
    //home page
    public static final String MENU_DROP = "//*[@id='header']/nav/a[1]";
    public static final String ADD_CUSTOMER = "//nav//a[contains(text(),'Add Customer')]";


    public static final String TITLE_ADDCUSTOMER = "//header/h1";
    public static final String RADIO_DONE = "//label[@for='done']";

    public static final String RADIO_PENDING = "//label[@for='pending']";
    public static final String TXT_FIRSTNAME = "//input[@name='fname']";

    public static final String TXT_LASTNAME = "//input[@name='lname']";
    public static final String TXT_EMAIL = "//input[@name='emailid']";

    public static final String TXT_ADDRESS = "//textarea[@name='addr']";

    public static final String TXT_MOBILE = "//input[@name='telephoneno']";

    public static final String BTN_SUBMIT = "//input[@name='submit']";
    public static final String BTN_RESET = "//input[@type='reset']";


    public static final String MESS_FIRSTNAME = "//label[@id='message']";
    public static final String MESS_LASTNAME = "//label[@id='message50']";
    public static final String MESS_EMAIL = "//label[@id='message9']";
    public static final String MESS_ADDRESS = "//label[@id='message3']";
    public static final String MESS_MOBILE = "//label[@id='message7']";

    public static final String TITLE_ADDCUSTOMER_ACCESS = "//h1[contains(text(),'Access Details to Guru99 Telecom')]";
}

package autotests.co.uk.zpl.pages;

import autotests.co.uk.zpl.utils.BrowserFactory;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sasikala.jayavel on 17/05/2016.
 */
public  class Config {

    public  String base_URL = BrowserFactory.BASE_URL;
    public  String prod_Base_URL = BrowserFactory.PROD_BASE_URL;

    public  String homePageURL             = base_URL + "/";
    
    public   String named_Day_Delivery_Cost = "£4.95";
    
    public   Boolean selected_Serial_Percenatge_Voucher = true;
    public   Float selected_Serial_Percenatge_Voucher_Value = 0.0f;

    public   Map<String, String> totals_In_Basket_Page = new LinkedHashMap<String, String>();
    public   String basket_Page_Order_Total = "";

    public   Map<String, String> totals_In_Order_Summary_Page = new LinkedHashMap<String, String>();

    public   Map<String, String> totals_Specfic_To_Order_Summary_Page = new LinkedHashMap<String, String>();

    public   LinkedHashMap<String, LinkedHashMap<String, String>> basketpage_Product_List = new LinkedHashMap<String, LinkedHashMap<String, String>>();

    public   LinkedHashMap<String, LinkedHashMap<String, String>> orderSummaryPage_Product_List = new LinkedHashMap<String, LinkedHashMap<String, String>>();

    public   LinkedHashMap<String, LinkedHashMap<String, String>> orderConfirmation_Page_Product_List = new LinkedHashMap<String, LinkedHashMap<String, String>>();

    public   Map<String, String> totals_In_Order_Confirmation_Page = new LinkedHashMap<String, String>();

    public   Map<String, String> totals_Specfic_To_Order_Confirmation_Page = new LinkedHashMap<String, String>();

    public   String browsername = BrowserFactory.BROWSER_NAME;

    public   Boolean selected_Use_As_Billing_Address = false;

    public   String orderConfirmationNumber = "";

}

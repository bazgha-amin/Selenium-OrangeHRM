package com.SeleniumDemo.Parameters;

public class AddEmployee {
    public static final String addEmployee = "menu_pim_addEmployee"; //id
    public static final String SaveButton = "//*[@id=\"btnSave\"]";
    public static final String ValidationError = "span.validation-error" ; //class
    //String EmployeeFirstName = "firstName" ; //name
    public static final String EmployeeFirstName = "input#firstName";
    public static final String AddEmployeePage = "menu_pim_viewPimModule"; //id
    // String EmployeeLastName = "lastName" ; //name
    public static final String EmployeeMiddleName = "input[id=middleName]";
    public static final String EmployeeLastName = "input#lastName";
    public static final String EmployeePicture = "photofile"; //name
    public static final String Checkbox = "input[name=chkLogin]"; //name
    public static final String FileValidationMessage = "//*[@id=\"addEmployeeTbl\"]/div"; //css
    public static final String userName = "input[name=user_name]" ; //name
    public static final String password = "input[name=user_password]";
    public static final String confirmPassword = "input[name=re_password]";
    public static final String usernameValidation = "//*[@id=\"frmAddEmp\"]/fieldset/ol/li[5]/span";
    public static final String passwordValidation = "//*[@id=\"frmAddEmp\"]/fieldset/ol/li[6]/span";
    public static final String rePasswordValidation = "//*[@id=\"frmAddEmp\"]/fieldset/ol/li[7]/span";
    public static final String dropDown = "status";
//    public String SearchEmployeePage = "//*[@id=\"menu_pim_viewEmployeeList\"]";
//    public String EmployeeNameTextBox = "//*[@id=\"empsearch_employee_name_empName\"]";
//    public String SearchOptions = "//div[@class='ac_results']//ul//li";
//    public String employeeSearchButton = "//input[@name=\"_search\"]";


}

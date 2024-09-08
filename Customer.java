package TCSProject_OnlineGroceryShopping;

import java.util.*;
import java.util.regex.Pattern;

public class Customer
{
    private int custID;
    private String name;
    private String email;
    private String password;
    private String address;
    private String contact;

    Customer(int custID, String name, String email, String password, String address, String contact)
    {
        this.custID = custID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contact = contact;
    }

    //US001
    public static Customer registration()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name : ");
        String name = sc.nextLine();
        System.out.println("Enter your email id : ");
        String email = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();
        sc.nextLine();
        System.out.println("Enter your address : ");
        String address = sc.nextLine();
        System.out.println("Enter your contact number : ");
        String contact = sc.next();

        Customer cus=null;

        if((name.length()>0 && name.length()<=50) && isValidEmail(email) &&(password.length() >= 6 && password.length() <= 12) && address.length()<=100 && contact.length()<=10)
        {
            int min = 100000;
            int max = 999999;
            int custID = (int) (Math.random()*(max-min+1)+min);

            cus = new Customer(custID,name,email,password,address,contact);

            System.out.println("Customer Registration is successful for "+custID+".");
        }
        return cus;
    }

    public static boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public String getName() { return name; }
    public String getEmail()
    {
        return email;
    }
    public String getPassword() { return password; }

    //US002
    public void update_name(String new_name)
    {
        if (new_name.length()>0 && new_name.length()<=50)
            this.name = new_name;
        System.out.println("Your details has been updated successfully.");
    }
    public void update_email(String new_email)
    {
        if(isValidEmail(email)) {
            this.email = new_email;
            System.out.println("Your details has been updated successfully.");
        }
    }
    public void update_password(String new_password)
    {
        if (new_password.length()>=6 && new_password.length()<=12)
            this.password = new_password;
        System.out.println("Your details has been updated successfully.");
    }
    public void update_address(String new_address)
    {
        if (new_address.length()<=100)
            this.address = new_address;
        System.out.println("Your details has been updated successfully.");
    }

    public void update_contact(String new_contact)
    {
        if (new_contact.length()<=10)
            this.contact = new_contact;
        System.out.println("Your details has been updated successfully.");
    }

    public void display()
    {
        System.out.println("Customer ID : "+custID);
        System.out.println("Name : "+name);
        System.out.println("Email : "+email);
        System.out.println("Address : "+address);
        System.out.println("Contact : "+contact);
    }
}
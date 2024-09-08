package TCSProject_OnlineGroceryShopping;

import java.util.*;
public class Test
{
    public static void main(String args[]) {
        ArrayList<Customer> customerAL = new ArrayList<>();
        ArrayList<Product> productAL = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Are you a Customer or Admin?");
            String role = sc.next();
            if (role.equalsIgnoreCase("customer")) {

                while (true) {
                    System.out.println("What do you want to choose?\n1.Register\n2.Change Name" +
                            "\n3.Change Email ID\n4.Change Password \n5.Change Address\n6.Change Contact Number" +
                            "\nEnter your choice.(1/2/3/4/5/6)\n");
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        System.out.println("--CUSTOMER REGISTRATION--");
                            customerAL.add(Customer.registration()); //US001
                    }
                    //US002
                    else if (choice == 2) {
                        System.out.println("--LOGIN--");
                        Customer c = loginCustomer(customerAL); //US004
                        if (c == null)
                            System.out.println("Invalid Email ID or Password.");
                        else
                            System.out.println(c.getName() + " successfully logged in.");

                        System.out.println("Enter new name. ");
                        sc.nextLine();
                        String new_name = sc.nextLine();
                        c.update_name(new_name);
                    }
                    //US002
                    else if (choice == 3) {
                        System.out.println("--LOGIN--");
                        Customer c = loginCustomer(customerAL); //US004
                        if (c == null)
                            System.out.println("Invalid Email ID or Password.");
                        else
                            System.out.println(c.getName() + " successfully logged in.");

                        System.out.println("Enter new email id. ");
                        String new_email = sc.next();
                        c.update_email(new_email);
                    }
                    //US002
                    else if (choice == 4) {
                        System.out.println("--LOGIN--");
                        Customer c = loginCustomer(customerAL); //US004
                        if (c == null)
                            System.out.println("Invalid Email ID or Password.");
                        else
                            System.out.println(c.getName() + " successfully logged in.");

                        System.out.println("Enter new password ");
                        String new_password = sc.next();
                        c.update_password(new_password);
                    }
                    //US002
                    else if (choice == 5) {
                        System.out.println("--LOGIN--");
                        Customer c = loginCustomer(customerAL); //US004
                        if (c == null)
                            System.out.println("Invalid Email ID or Password.");
                        else
                            System.out.println(c.getName() + " successfully logged in.");

                        System.out.println("Enter new address.");
                        sc.nextLine();
                        String new_address = sc.nextLine();
                        c.update_address(new_address);
                    }
                    //US002
                    else if (choice == 6) {
                        System.out.println("--LOGIN--");
                        Customer c = loginCustomer(customerAL); //US004
                        if (c == null)
                            System.out.println("Invalid Email ID or Password.");
                        else
                            System.out.println(c.getName() + " successfully logged in.");

                        System.out.println("Enter new contact number. ");
                        String new_contact = sc.next();
                        c.update_contact(new_contact);
                    }

                    System.out.println("Do you want to continue as a customer? Y/N");
                    String str = sc.next();
                    if (str.equalsIgnoreCase("Y")) continue;
                    else if (str.equalsIgnoreCase("N")) break;
                }

            } else if (role.equalsIgnoreCase("admin")) {
                while (true) {
                    System.out.println("\nWhat do you want to choose?" +
                            "\n1.Add Product\n2.Find Customer by email id" +
                            "\n3.Find Product with Highest Price\n4.Sort all products by quantity" +
                            "\nEnter Your choice.(1/2/3/4)");
                    int choice = sc.nextInt();
                    //
                    if (choice == 1) {
                        System.out.println("--ADDING PRODUCT--");

                        while (true) {
                            productAL.add(Product.addProduct()); //US003
                            System.out.println("Do you want to continue adding products? Y/N");
                            String str = sc.next();
                            if (str.equalsIgnoreCase("Y")) continue;
                            else if (str.equalsIgnoreCase("N")) break;
                        }
                    }

                    if (choice == 2) {
                        System.out.println("--FINDING CUSTOMER BY EMAIL--");
                        System.out.println("Enter customer's email id.");
                        String email = sc.next();
                        Customer c = searchCustomerByEmail(customerAL, email); //US004
                        if (c == null)
                            System.out.println("No Such Customer Exists With The Given Email.");
                        else
                            c.display();
                    }

                    else if (choice == 3) {
                        System.out.println();
                        System.out.println("--PRODUCT WITH HIGHEST PRICE--");
                        Product highestPriceProd = ProductByHighestPrice(productAL); //US005
                        System.out.println("Product Details with Highest Price : ");
                        highestPriceProd.display();
                    }

                    else if (choice == 4) {
                        List<Product> sortedProducts = sortedProductsByQuantity(productAL);
                        for (Product p : sortedProducts)
                            p.display();
                    }
                    System.out.println("Do you want to continue as an admin? Y/N");
                    String str = sc.next();
                    if (str.equalsIgnoreCase("Y")) continue;
                    else if (str.equalsIgnoreCase("N")) break;
                }
            }
            System.out.println("Do you want to continue with the system? Y/N");
            String str = sc.next();
            if (str.equalsIgnoreCase("Y")) continue;
            else if (str.equalsIgnoreCase("N")) break;
        }
    }

    public static Customer loginCustomer(ArrayList<Customer> al)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email id.");
        String email = sc.next();
        System.out.println("Enter your password.");
        String password = sc.next();
        for(Customer c : al)
        {
            if (Customer.isValidEmail(email) && c.getEmail().equals(email) && c.getPassword().equals(password))
                return c;
        }
        return null;
    }
    //US004
    public static Customer searchCustomerByEmail(ArrayList<Customer> al,String email)
    {
        for(Customer c : al)
        {
            if (c.getEmail().equals(email))
                return c;
        }
        return null;
    }

    //US005
    public static Product ProductByHighestPrice(ArrayList<Product> al)
    {
        if(al.size()==0)
            System.out.println("Product List is Empty.");

        Product temp=null;
        double max_price = Double.MIN_VALUE;
        for(Product p : al)
        {
            if(p.getPrice() > max_price)
            {
                max_price = p.getPrice();
                temp = p;
            }
        }
        return temp;
    }

    //US006
    public static List<Product> sortedProductsByQuantity(ArrayList<Product> al)
    {
        if(al.size()==0)
            System.out.println("Product List is Empty.");
        List<Product> sorted = new ArrayList<>();
        ArrayList<Integer> quant = new ArrayList<>();
        for(Product p : al)
            quant.add(p.getQuantity());
        Collections.sort(quant,Collections.reverseOrder());
        for(Integer q : quant)
        {
            for (Product p : al)
            {
                if(p.getQuantity()==q)
                    sorted.add(p);
            }
        }
        return sorted;
    }
}

package TCSProject_OnlineGroceryShopping;

import java.util.*;
public class Product
{
    private long prodID;
    private String prodName;

    private String prodDesc;

    private int quantity;
    private double price;

    Product(long prodID, String prodName, String prodDesc, int quantity, double price)
    {
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.quantity = quantity;
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }
    public int getQuantity()
    {
        return quantity;
    }
    //US003
    public static Product addProduct()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product name : ");
        String prodName = sc.next();
        sc.nextLine();
        System.out.println("Enter product description : ");
        String prodDesc = sc.nextLine();
        System.out.println("Enter product quantity : ");
        int quantity = sc.nextInt();
        System.out.println("Enter product price : ");
        double price = sc.nextInt();
        sc.nextLine();

        Product prod=null;

        if(prodName.length()<=50 && prodDesc.length()<=100)
        {
            long max = 1000000000;
            long min = 9999999999L;
            long prodID = (long)(Math.random()*(max-min+1) + min);

            price = Math.round(price*100.0)/100.0;

            prod = new Product(prodID,prodName,prodDesc,quantity,price);

            System.out.println("Product with Product ID "+prodID+" added successfully.");
        }
        return prod;
    }

    public void display()
    {
        System.out.println("Product ID : "+prodID);
        System.out.println("Name : "+prodName);
        System.out.println("Description : "+prodDesc);
        System.out.println("Quantity : "+quantity);
        System.out.println("Price : "+price);
    }

}

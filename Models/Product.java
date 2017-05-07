package Models;


/**
 *
 * @author Charlie
 */
public class Product {
       private int productID;
    private String productName;
    private double costPrice;
    private double sellingPrice;
    private String productDescription;
    private int amountInStock;
    private int minimumStock;
  

    /**
     *  Constructor for Product Object
     * @param productID
     * @param productName
     * @param costPrice
     * @param sellingPrice
     * @param productDescription
     * @param amountInStock
     * @param minimumStock
     */
    public Product(int productID, String productName, double costPrice, double sellingPrice, String productDescription, int amountInStock, int minimumStock) {
        this.productID = productID;
        this.productName = productName;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.productDescription = productDescription;
        this.amountInStock = amountInStock;
        this.minimumStock = minimumStock;
        
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    public int getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }


    
}

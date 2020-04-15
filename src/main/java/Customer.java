import java.util.ArrayList;

public class Customer {
    //ID's must be unique, class keeps track of valid ID's in use
    private static ArrayList<Integer> customerIDList = new ArrayList<Integer>();

    private int customerID;
    private String name;
    private ArrayList<Purchase> purchaseHistory;
    private ArrayList<Product> currentBasket;

    /////////////////////////////////////////////////
    //CONSTRUCTORS

    //Constructor validates ID.  If ID is invalid, the Customer will not be able to be
    //added to Shop or Purchase.  Using invalid Customer with Review will create invalid Review.
    public Customer(int customerID) {

        //CustomerID must be a positive value not already on the existing customer ID list
        if(customerID > 0 && (customerIDList.contains(customerID) == false) ) {
            this.customerID = customerID;
            customerIDList.add(customerID);
        }
        else {
            if(customerIDList.contains(customerID) ){
                System.out.println("Customer ID must be unique.  Customer created cannot used in shop or purchases.");
            }

            if(customerID < 0 ){
                System.out.println("Customer ID cannot be negative.  Customer created cannot be used in shop or purchases.");
            }

            this.customerID = -1;


        }

        //Set rest of fields to default
        this.name = "0";
        this.purchaseHistory = new ArrayList<Purchase>();
        this.currentBasket = new ArrayList<Product>();
    }

    public Customer(int customerID, String name, ArrayList<Purchase> purchaseHistory, ArrayList<Product> currentBasket ) {
        this(customerID);

        this.name = name;
        this.setCurrentBasket(currentBasket);
        this.setPurchaseHistory(purchaseHistory);
    }

    /////////////////////////////////////////////////
    //GETTERS
    public String getName() {
        return name;
    }

    public ArrayList<Product> getCurrentBasket() {
        return currentBasket;
    }

    public ArrayList<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public int getCustomerID() {
        return customerID;
    }

    /////////////////////////////////////////////////
    //SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentBasket(ArrayList<Product> currentBasket) {
        for (Product p: currentBasket){
            this.addToCurrentBasket(p);
        }
    }

    public void setPurchaseHistory(ArrayList<Purchase> purchaseHistory) {
        for (Purchase p: purchaseHistory){
            this.addToPurchaseHistory(p);
        }
    }

    /////////////////////////////////////////////////
    //add and remove from basket and purchase history
    //Products and purchases only added if their ID's > 0

    //ADD PRODUCT to BASKET
    public void addToCurrentBasket (Product product){
        if (product.getQtyStock() > 0 && product.getProductID() > 0) {
            this.currentBasket.add(product);
        }

        else {
            if (product.getQtyStock() < 1){
                System.out.println("Product not in stock.  Product not added to basket.");
            }

            if (product.getProductID() < 0) {
                System.out.println("Invalid product ID.  Product not added to basket.");
            }
        }
    }

    //REMOVE PRODUCT FROM BASKET
    public void removeFromCurrentBasket (Product product){
        this.currentBasket.remove(product);
    }

    //ADD PURCHASE TO PURCHASE HISTORY
    public void addToPurchaseHistory (Purchase purchase){
        if (purchase.getPurchaseID() > 0 ){
            this.purchaseHistory.add(purchase);
        }
    }

    //REMOVE PURCHASE FROM PURCHASE HISTORY
    public void removeFromPurchaseHistory (Purchase purchase) {
        this.purchaseHistory.remove(purchase);
    }

    /////////////////////////////////////////////////
    //Calculate total money spent
    public float totalMoneySpent() {
        float returnMoneySpent = 0;

        for(Purchase p: purchaseHistory) {
            returnMoneySpent = returnMoneySpent + p.getTotalCost();
        }

        return returnMoneySpent;
    }

    ///////////////////////////////////////////////
    //Check if Customer ID is taken

    public static boolean isCustomerIDInUse(int customerId) {
        return customerIDList.contains(customerId);
    }


    //////////////////////////////////////////////////////////////
    //EQUALITY: OVERRIDING equals(), same ID means equality
    @Override
    public boolean equals(Object object){
        //True if same object
        if (object == this){
            return true;
        }

        //False if not instance of Customer
        if (!(object instanceof Customer)){
            return false;
        }

        //Reaches this line, object is instance of Customer, ok to cast
        //Equality if productID's are the same
        if (this.getCustomerID() == ((Customer) object).getCustomerID()){
            return true;
        }
        else {
            return false;
        }
    }

    ////////////////////////////////////////////////////////////
    //CLEAR ID LIST: TESTING PURPOSES
    public static void clearIDList() {
        customerIDList.clear();
    }
}

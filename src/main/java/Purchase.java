import java.util.ArrayList;

public class Purchase {
    //ID's must be unique, class keeps track of valid ID's in use
    private static ArrayList<Integer> purchaseIDList = new ArrayList<Integer>();

    private int purchaseID;
    private int date;
    private int payingCustomerID;
    private float totalCost;
    private ArrayList<Product> itemsPurchased;

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //CONSTRUCTORS

    //Constructor validates ID.
    // If ID is invalid, the Purchase will not be able to be added to Shop.
    public Purchase(int purchaseID, Customer customer) {

        //ID must be positive value AND not be on existing purchaseIDList AND
        //the customer ID used with the Purchase must be valid
        if(purchaseID > 0 && (purchaseIDList.contains(purchaseID) == false) && (customer.getCustomerID() > 0)) {
            this.purchaseID = purchaseID;
            purchaseIDList.add(purchaseID);
            this.payingCustomerID = customer.getCustomerID();
        }
        else {
            if(purchaseIDList.contains(purchaseID) ){
                System.out.println("Purchase ID must be unique.  Purchase created cannot used in shop.");
            }

            if(purchaseID < 0 ){
                System.out.println("Purchase ID cannot be negative.  Purchase created cannot be used in shop.");
            }

            if (customer.getCustomerID() < 0) {
                System.out.println("Invalid customer ID.  Purchase created cannot be used in shop.");

            }
            this.purchaseID = -1;


        }

        //Set rest of fields to default
        this.totalCost = 0;
        this.date = 0;
        this.itemsPurchased = new ArrayList<Product>();

    }

    public Purchase(int purchaseID, int date, Customer customer, float totalCost, ArrayList<Product> itemsPurchased) {
        this(purchaseID, customer);
        this.date = date;
        this.totalCost = totalCost;
        this.itemsPurchased = itemsPurchased;
        this.itemsPurchased = new ArrayList<Product>();
    }

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //GETTERS

    public ArrayList<Product> getItemsPurchased() {
        return itemsPurchased;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public int getDate() {
        return date;
    }

    public int getPayingCustomerID() {
        return payingCustomerID;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //SETTERS

    public void setDate(int date) {
        this.date = date;
    }

    public void setItemsPurchased(ArrayList<Product> itemsPurchased) {
        this.itemsPurchased.clear();
        for (Product p: itemsPurchased) {
            this.addItem(p);
        }
    }


    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //Add and remove items from purchase

    //Adding product to purchase
    public void addItem(Product product) {

        if (product.getQtyStock() > 0 && product.getProductID() > 0) {
            itemsPurchased.add(product);

            //recalculate total cost
            this.calculateTotalCost();

            //change stock and purchased number of product
            product.setQtyPurchase(product.getQtyPurchase() + 1);
            product.setQtyStock(product.getQtyStock() - 1);
        }

        else {
            if (product.getProductID() < 0){
                System.out.println("Invalid product ID.  Product not added to Purchase.");
            }
            if (product.getQtyStock() < 1 ) {
                System.out.println("Product not in stock.  Product not added to Purchase");
            }
        }

    }

    //////////////////////////////////////////////////////////////
    //Removing product from purchase
    public void removeItem(Product product) {
        if (itemsPurchased.contains(product)) {
            itemsPurchased.remove(product);

            //recalculate total cost
            this.calculateTotalCost();

            //change stock and purchased number of product
            product.setQtyPurchase(product.getQtyPurchase() - 1);
            product.setQtyStock(product.getQtyStock() + 1);        }
    }

    //////////////////////////////////////////////////////////////
    //Copying customer's basket to a purchase

    public void copyBasket(Customer customer) {

        //Add each Product in currentBasket to itemsPurchased
        for(Product p: customer.getCurrentBasket()){
            this.itemsPurchased.add(p);
        }
        //Recalculate total purchase cost
        this.calculateTotalCost();
    }

    /////////////////////////////////////////////////
    //Calculate total purchase cost
    private void calculateTotalCost() {
        this.totalCost = 0;

        for(Product p: this.itemsPurchased) {
            this.totalCost = this.totalCost + p.getPrice();
        }
    }

    ///////////////////////////////////////////////
    //Check if Purchase ID is taken
    public static boolean isPurchaseIDTaken(int purchaseID) {
        return purchaseIDList.contains(purchaseID);
    }

    //////////////////////////////////////////////////////////////
    //EQUALITY: OVERRIDING equals(), same ID means equality
    @Override
    public boolean equals(Object object){
        //True if same object
        if (object == this){
            return true;
        }

        //False if not instance of Purchase
        if (!(object instanceof Purchase)){
            return false;
        }

        //Reaches this line, object is instance of Purchase, ok to cast
        //Equality if productID's are the same
        if (this.getPurchaseID() == ((Purchase) object).getPurchaseID()){
            return true;
        }
        else {
            return false;
        }
    }


}

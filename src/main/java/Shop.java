import java.util.ArrayList;

public class Shop {

    private String name;
    private ArrayList<Product> products ;
    private ArrayList<Customer> customers;
    private ArrayList<Purchase> purchases;

    ////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////
    //CONSTRUCTORS

    public Shop(){
        this.name = "NoName";
        this.products = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.purchases = new ArrayList<>();
    }

    public Shop(String name, ArrayList<Product> products, ArrayList<Customer> customers, ArrayList<Purchase> purchases){
        this();
        this.name = name;
        this.setProducts(products);
        this.setCustomers(customers);
        this.setPurchases(purchases);
    }


    ////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    //GETTERS

    public String getName() {
        return name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    ////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers.clear();
        for (Customer c: customers){
            this.addCustomer(c);
        }
    }

    public void setProducts(ArrayList<Product> products) {
        this.products.clear();
        for (Product p: products){
            this.addProduct(p);
        }    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases.clear();

        for (Purchase p: purchases){
            this.addPurchase(p);
        }    }

    ////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    //ADD customer/product/purchase

    public void addCustomer(Customer newCustomer) {
        if(newCustomer.getCustomerID() > 0){
            this.customers.add(newCustomer);
        }
    }

    public void addProduct( Product newProduct) {
        if(newProduct.getProductID() > 0) {
            this.products.add(newProduct);
        }
    }

    public void addPurchase( Purchase newPurchase) {
        if(newPurchase.getPurchaseID() > 0){
            this.purchases.add(newPurchase);
        }
    }

    //REMOVE customer/product/purchase
    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);

    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public void removePurchase(Purchase purchase) {
        this.purchases.remove(purchase);
    }

    ////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////
    //OTHER STORE FUNCTIONS

    ////////////////////////////////////////////////////////////
    //Check if product is in stock
    public boolean isInStock(Product checkThisProduct) {
        return products.contains(checkThisProduct);
    }

    ////////////////////////////////////////////////////////////
    //Calculate Total Income
    public float calculateTotalShopIncome() {
        float totalIncomeReturn = 0;

        if (purchases.isEmpty()){
            return 0;
        }

        else {
            for (Purchase p : purchases) {
                totalIncomeReturn = totalIncomeReturn + p.getTotalCost();
            }
        }

        return totalIncomeReturn;
    }

    ////////////////////////////////////////////////////////////
    //Find Best Selling Product
    //Returns invalid Product if there are no products or no sales
    public Product findBestSellingProduct() {

        int maxQtySold = 0;
        ArrayList<Product> bestsellingProduct = new ArrayList<Product>();

        if (products.isEmpty() == false ){
            for (Product p: products) {
                //Keep comparing products, adding the product w the
                //Largest qtyPurchase as the bestseller
                if (maxQtySold <= p.getQtyPurchase()) {

                    maxQtySold = p.getQtyPurchase();
                    bestsellingProduct.clear();
                    bestsellingProduct.add(p);
                }
            }

            //Return invalid product if no sales
            if (maxQtySold == 0) {
                return new MechPencil(-1);
            }

            //Return bestselling product
            return bestsellingProduct.get(0);
        }

        else {
            //Return invalid product if no products
            return new MechPencil(-1);
        }
    }

}

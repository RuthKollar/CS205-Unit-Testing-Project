import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class AddFunctionValidationTests {

    Shop shopMain = new Shop();
    Customer customerMain = new Customer(1);
    Product productMain = new FountainPen(1);
    Purchase purchaseMain = new Purchase(1, customerMain);

    ArrayList<Customer> customerList = new ArrayList<Customer>();
    ArrayList<Product> productList = new ArrayList<Product>();
    ArrayList<Purchase> purchaseList = new ArrayList<Purchase>();

    Customer invalidCustomer = new Customer(-1);
    Customer validCustomer = new Customer(2);

    Product invalidProduct = new MechPencil(-1);
    Product validProduct = new MechPencil(2);
    Product validProduct3 = new MechPencil(3);

    Purchase invalidPurchase = new Purchase(-1, invalidCustomer);
    Purchase validPurchase = new Purchase(2, validCustomer);


    //The invalid customer/product/purchase should not be added
    //The valid should be added
    //The set functions for Shop class just uses the add function for each arraylist elt
    //This works to test both
    @Test
    public void addToShopTest() {

        purchaseList.add(validPurchase);
        purchaseList.add(invalidPurchase);

        productList.add(validProduct);
        productList.add(invalidProduct);

        customerList.add(validCustomer);
        customerList.add(invalidCustomer);

        //Checking Shop does not add invalid, does add valid purchase/product/customer
        shopMain.setPurchases(purchaseList);
        assertFalse(shopMain.getPurchases().contains(invalidPurchase));
        assertTrue(shopMain.getPurchases().contains(validPurchase));

        shopMain.setProducts(productList);
        assertFalse(shopMain.getProducts().contains(invalidProduct));
        assertTrue(shopMain.getProducts().contains(validProduct));

        shopMain.setCustomers(customerList);
        assertFalse(shopMain.getCustomers().contains(invalidCustomer));
        assertTrue(shopMain.getCustomers().contains(validCustomer));


    }

    @Test
    public void addToCustomerTest() {

        purchaseList.add(validPurchase);
        purchaseList.add(invalidPurchase);

        productList.add(validProduct);
        productList.add(invalidProduct);

        //Checking invalid purchase not added, valid added
        customerMain.setPurchaseHistory(purchaseList);
        assertFalse(customerMain.getPurchaseHistory().contains(invalidPurchase));
        assertTrue(customerMain.getPurchaseHistory().contains(validPurchase));

        customerMain.setCurrentBasket(productList);
        customerMain.addToCurrentBasket(validProduct);

        //Qty of product starts at 0 so neither valid nor invalid product
        //Should be added to basket
        assertFalse(customerMain.getCurrentBasket().contains(invalidProduct));
        assertFalse(customerMain.getCurrentBasket().contains(validProduct));

        //Qty adjusted to 1, valid should be added
        invalidProduct.setQtyStock(1);
        validProduct.setQtyStock(1);

        customerMain.setCurrentBasket(productList);
        customerMain.addToCurrentBasket(validProduct);

        assertFalse(customerMain.getCurrentBasket().contains(invalidProduct));
        assertTrue(customerMain.getCurrentBasket().contains(validProduct));

    }

    @Test
    //Tests only one review per customer per product can be added
    //to a product
    public void addToProductTest() {
        Review mainReview = new Review(productMain,customerMain);
        Review duplicateReview = new Review(productMain,customerMain);

        productMain.addReview(mainReview);
        productMain.addReview(duplicateReview);

        //Checks only one review per product per customer can be added
        assertTrue(productMain.getReviews().contains(mainReview));
        assertFalse(productMain.getReviews().contains(duplicateReview));


    }

    @Test
    //Tests qtyStock is added to
    public void addToPurchaseTest() {
        //Stock is 0, nothing can be added to purchase

        validProduct.setQtyStock(0);
        invalidProduct.setQtyStock(0);

        productList.add(validProduct);
        productList.add(invalidProduct);

        purchaseMain.setItemsPurchased(productList);
        assertFalse(purchaseMain.getItemsPurchased().contains(invalidProduct));
        assertFalse(purchaseMain.getItemsPurchased().contains(validProduct));


        //Stock is 2, valid should be added to purchase; invalid not
        validProduct.setQtyStock(2);
        invalidProduct.setQtyStock(2);

        purchaseMain.setItemsPurchased(productList);

        assertFalse(purchaseMain.getItemsPurchased().contains(invalidProduct));
        assertTrue(purchaseMain.getItemsPurchased().contains(validProduct));

        //Check that qtyStock reduced, qtyPurchase increased
        assertEquals(1,validProduct.getQtyStock());
        assertEquals(1,validProduct.getQtyPurchase());

        //Check that qtyStock increased, qtyPurchase decreased
        purchaseMain.removeItem(validProduct);
        assertEquals(2,validProduct.getQtyStock());
        assertEquals(0,validProduct.getQtyPurchase());



    }


}
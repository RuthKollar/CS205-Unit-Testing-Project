import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddToCustomerValidationTest {


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

        //Reset for next test
        TestResetter.clearIDLists();

    }


}

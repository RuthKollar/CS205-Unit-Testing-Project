import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddToShopValidationTest {


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

        //Reset for next test
        TestResetter.clearIDLists();


    }

}

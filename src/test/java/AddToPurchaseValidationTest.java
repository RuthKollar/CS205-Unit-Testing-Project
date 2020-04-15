import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AddToPurchaseValidationTest {


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

        //Reset for next test
        TestResetter.clearIDLists();

    }

}

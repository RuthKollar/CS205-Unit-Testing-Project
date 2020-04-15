import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddToProductValidationTest {


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

        //Reset for next test
        TestResetter.clearIDLists();


    }
}

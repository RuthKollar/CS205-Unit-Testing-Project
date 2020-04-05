import org.junit.Test;

import static org.junit.Assert.*;

//Tests that Purchase Constructor: sets ID to -1 if given
// existing or negative purchase ID or Invalid customer
//
public class PurchaseIDValidationTest {
    //customers to use in purchase test
    Customer validCustomer = new Customer(1);
    Customer invalidCustomer = new Customer(-1);

    //valid purchases to test purchaseIDlist
    Purchase validP1 = new Purchase(1, validCustomer);
    Purchase validP2 = new Purchase(2, validCustomer);

    //invalid ID, valid customer
    Purchase repeatIDPurchase = new Purchase(1, validCustomer);

    //valid ID, invalid customer
    Purchase invalidCustomerPurchase = new Purchase(3, invalidCustomer);

    @Test
    public void isPurchaseIDTaken() {
        //Checks valid ID's added to purchaseIDList
        assertTrue(Purchase.isPurchaseIDTaken(1));
        assertTrue(Purchase.isPurchaseIDTaken(2));

        //Checks valid ID not added to purchaseIDList in case of invalid customer
        //That is, the purchase in invalidated by an invalid customer
        assertFalse(Purchase.isPurchaseIDTaken(3));

        //Checks only valid ID's get added to purchaseIDlist
        assertFalse(Purchase.isPurchaseIDTaken(-1));

    }

    @Test
    public void testEquals() {
        //Even if ID is valid, if the purchase is not, ID should be set to -1
        //By the overridden equals Purchase method, this should make
        //repeatIDPurchase and invalidCustomerPurchase equal
        assertEquals(repeatIDPurchase,invalidCustomerPurchase);

    }
}
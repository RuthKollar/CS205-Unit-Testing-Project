import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewConstructorValidationTest {

    Customer invalidCustomer = new Customer(-1);
    Customer validCustomer1 = new Customer(1);

    Product invalidProduct = new MechPencil(-1);
    Product validProduct = new MechPencil(1);

    @Test
    public void BothIDValid() {
        //Both valid ID's Valid
        Review review1 = new Review(validProduct,validCustomer1);
        assertEquals(1.0,(double)review1.getForProductID(),0);
        assertEquals(1.0, (double)review1.getFromCustomerID(),0);


    }

    @Test
    public void SingleInvalidID() {
        //Mix of valid/invalid ID's
        //If one ID is invalid, the other ID should be set to -1

        Review review2 = new Review(validProduct,invalidCustomer);
        Review review3 = new Review(invalidProduct,validCustomer1);

        assertEquals(-1,review2.getForProductID());
        assertEquals(-1,review3.getFromCustomerID());

    }

}
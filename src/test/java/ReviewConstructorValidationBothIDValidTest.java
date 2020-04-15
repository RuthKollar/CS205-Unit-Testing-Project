import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewConstructorValidationBothIDValidTest {

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

        //Reset for next test
        TestResetter.clearIDLists();

    }



}
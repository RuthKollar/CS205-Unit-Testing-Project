import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerIDValidationIsCustomerIDInUseTest {
    Customer validC1 = new Customer(1);
    Customer validC2 = new Customer(2);

    //invalid ID because ID in use
    //ID validation should set this ID to -1
    Customer invalidC1 = new Customer(1);

    //invalid ID because negative
    Customer invalidC2 = new Customer(-4);


    @Test
    public void testIsCustomerIDInUse() {

        //Checking the valid ID's were added to customerIDList array
        assertEquals(true, Customer.isCustomerIDInUse(1));
        assertEquals(true, Customer.isCustomerIDInUse(2));

        //Checking ONLY valid ID's are added to CustomerIDList array
        assertEquals(false, Customer.isCustomerIDInUse(-1));
        assertEquals(false, Customer.isCustomerIDInUse(-4));

        //Reset for next test
        TestResetter.clearIDLists();

    }


}

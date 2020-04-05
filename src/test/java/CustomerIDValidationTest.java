import org.junit.Test;

import static org.junit.Assert.*;

//Tests that Customer Constructor sets negative or existing ID's to -1
public class CustomerIDValidationTest {

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
    }

    @Test
    public void testEquals() {
        //Checking Invalid ID's are set to -1
        //The ID's of invalid Customers should always be set to -1
        //Meaning they are equal by overridden criteria
        assertEquals(invalidC1,invalidC2);

        //Since valid customers will not have equal ID's, two valid customer objects
        //Would not be equal unless they are the same object
        //If code is working properly, no two valid customers should be equal
        assertEquals(validC1,validC1);
        assertNotEquals(validC1,invalidC1);
    }
}
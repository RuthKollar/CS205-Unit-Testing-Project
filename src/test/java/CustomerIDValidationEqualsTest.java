import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CustomerIDValidationEqualsTest {

    Customer validC1 = new Customer(1);
    Customer validC2 = new Customer(2);

    //invalid ID because ID in use
    //ID validation should set this ID to -1
    Customer invalidC1 = new Customer(1);

    //invalid ID because negative
    Customer invalidC2 = new Customer(-4);


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

        //Reset for next test
        TestResetter.clearIDLists();
    }

}

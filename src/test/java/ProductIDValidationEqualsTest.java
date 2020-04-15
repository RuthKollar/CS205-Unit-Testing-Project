import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProductIDValidationEqualsTest {


    Product validP1 = new MechPencil(1);
    Product validP2 = new FountainPen(2);

    //invalid ID because ID in use by validP1
    //ID validation should set this ID to -1
    Product invalidP1 = new MechPencil(1);

    //invalid ID because negative
    Product invalidP2 = new FountainPen(-4);

    @Test
    public void testEquals() {
        //SAME CODE AS CUSTOMER ID VALIDATION TEST
        //Checking Invalid ID's get set to -1
        //Meaning they are equal by overridden equals criteria
        assertEquals(invalidP1,invalidP2);

        //Since valid Products will not have equal ID's, two valid Products objects
        //Would not be equal unless they are the same object
        //If code is working properly, no two Products can have equal ID's
        assertEquals(validP1,validP1);
        assertNotEquals(validP1,invalidP1);

        //Reset for next test
        TestResetter.clearIDLists();

    }

}

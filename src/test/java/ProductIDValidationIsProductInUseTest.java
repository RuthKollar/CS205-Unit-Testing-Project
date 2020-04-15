import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductIDValidationIsProductInUseTest {


    Product validP1 = new MechPencil(1);
    Product validP2 = new FountainPen(2);

    //invalid ID because ID in use by validP1
    //ID validation should set this ID to -1
    Product invalidP1 = new MechPencil(1);

    //invalid ID because negative
    Product invalidP2 = new FountainPen(-4);


    @Test
    public void isProductIDInUse() {
        //Checking both subclasses' ID's get added
        assertTrue(Product.isProductIDInUse(1));
        assertTrue(Product.isProductIDInUse(2));

        //Checking ONLY valid ID's are added to ProductIDList
        assertFalse(Product.isProductIDInUse(-1));
        assertFalse(Product.isProductIDInUse(-4) );

        //Reset for next test
        TestResetter.clearIDLists();

    }


}

import org.junit.Test;

import static org.junit.Assert.*;

public class MechPencilTest {

    MechPencil f1 = new MechPencil(1);

    @Test
    public void validFieldTesting() {
        //invalid fields
        f1.setMechFields("blue", "air", "XXL", "none");
        assertEquals("0", f1.getBodyMaterial());
        assertEquals("0", f1.getLeadDiameter());
        assertEquals("0", f1.getLeadDispenseMechanism());

        //valid fields
        f1.setMechFields("blue", "metal", "03", "twist");
        assertEquals("metal", f1.getBodyMaterial());
        assertEquals("03", f1.getLeadDiameter());
        assertEquals("twist", f1.getLeadDispenseMechanism());

    }

}
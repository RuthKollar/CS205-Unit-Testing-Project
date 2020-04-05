import java.util.ArrayList;

public class FountainPen extends Product{

    private String bodyColor;
    private  String bodyMaterial;
    private String nibSize;
    private String fillMechanism;

    private static ArrayList<String> validBodyMaterials = new ArrayList<String>();
    private static ArrayList<String> validNibSizes = new ArrayList<String>();
    private static ArrayList<String> validFillMechanisms = new ArrayList<String>();

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //CONSTRUCTORS

    public FountainPen(int productID) {
        super(productID);
        this.bodyColor = "0";
        this.bodyMaterial = "0";
        this.nibSize = "0";
        this.fillMechanism = "0";
        fillValidArrays();
    }

    public FountainPen(int productID, float price, String brand, String name, int qtyPurchase, int qtyStock, int avgRating, ArrayList<Review> reviews) {
        super(productID, price, brand, name, qtyPurchase, qtyStock, avgRating, reviews);
        this.bodyColor = "0";
        this.bodyMaterial = "0";
        this.nibSize = "0";
        this.fillMechanism = "0";
        fillValidArrays();
    }

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //FILL VALID ARRAYS WITH STRINGS

    private void fillValidArrays() {

        validBodyMaterials.add("plastic");
        validBodyMaterials.add("metal");

        validNibSizes.add("EF");
        validNibSizes.add("F");
        validNibSizes.add("M");
        validNibSizes.add("B");


        validFillMechanisms.add("piston");
        validFillMechanisms.add("cartridge");
        validFillMechanisms.add("vacuum");
        validFillMechanisms.add("eyedropper");
    }

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //GETTERS

    public String getBodyColor() {
        return bodyColor;
    }

    public String getBodyMaterial() {
        return bodyMaterial;
    }

    public String getNibSize() {
        return nibSize;
    }

    public String getFillMechanism() {
        return fillMechanism;
    }

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //SETTERS

    //Multi setter for fountain pen unique fields
    public void setFountainFields(String bodyColor, String bodyMaterial, String nibSize, String fillMechanism){
        this.setBodyColor(bodyColor);
        this.setBodyMaterial(bodyMaterial);
        this.setNibSize(nibSize);
        this.setFillMechanism(fillMechanism);

    }


    //////////////////////////////////////////////////////////////
    //Individual setters for fountain pen unique fields
    //checks that fields are valid strings

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public void setBodyMaterial(String bodyMaterial) {
        if (validBodyMaterials.contains(bodyMaterial)){
            this.bodyMaterial = bodyMaterial;
        }
    }

    public void setNibSize(String nibSize) {
        if (validNibSizes.contains(nibSize)){
            this.nibSize = nibSize;
        }
    }

    public void setFillMechanism(String fillMechanism) {
        if (validFillMechanisms.contains(fillMechanism)){
            this.fillMechanism = fillMechanism;
        }
    }

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //
}

import java.util.ArrayList;

public class MechPencil extends Product {

    private String bodyColor;
    private String bodyMaterial;
    private String leadDiameter;
    private String leadDispenseMechanism;

    private static ArrayList<String> validBodyMaterials = new ArrayList<String>();
    private static ArrayList<String> validLeadDiameters = new ArrayList<String>();
    private static ArrayList<String> validLeadDispenseMechanisms = new ArrayList<String>();


    /////////////////////////////////////////////////
    /////////////////////////////////////////////////
    //CONSTRUCTORS

    public MechPencil(int productID) {
        super(productID);
        this.bodyColor = "0";
        this.bodyMaterial = "0";
        this.leadDiameter = "0";
        this.leadDispenseMechanism = "0";

        fillValidArrays();
    }

    public MechPencil(int productID, float price, String brand, String name, int qtyPurchase, int qtyStock, int avgRating, ArrayList<Review> reviews) {
        super(productID, price, brand, name, qtyPurchase, qtyStock, avgRating, reviews);
        this.bodyColor = "0";
        this.bodyMaterial = "0";
        this.leadDiameter = "0";
        this.leadDispenseMechanism = "0";
        fillValidArrays();
    }

    /////////////////////////////////////////////////
    /////////////////////////////////////////////////
    //FILL VALID ARRAYS WTIH DEFAULT STRINGS

    private void fillValidArrays() {
        validBodyMaterials.add("plastic");
        validBodyMaterials.add("metal");

        validLeadDiameters.add("03");
        validLeadDiameters.add("05");
        validLeadDiameters.add("07");
        validLeadDiameters.add("09");

        validLeadDispenseMechanisms.add("topClick");
        validLeadDispenseMechanisms.add("sideClick");
        validLeadDispenseMechanisms.add("twist");
        validLeadDispenseMechanisms.add("shake");

    }


    /////////////////////////////////////////////////
    /////////////////////////////////////////////////
    //GETTERS

    public String getBodyColor() {
        return bodyColor;
    }

    public String getBodyMaterial() {
        return bodyMaterial;
    }

    public String getLeadDiameter() {
        return leadDiameter;
    }

    public String getLeadDispenseMechanism() {
        return leadDispenseMechanism;
    }

    public static ArrayList<String> getValidBodyMaterials() {
        return validBodyMaterials;
    }

    public static ArrayList<String> getValidLeadDiameters() {
        return validLeadDiameters;
    }

    public static ArrayList<String> getValidLeadDispenseMechanisms() {
        return validLeadDispenseMechanisms;
    }

    /////////////////////////////////////////////////
    /////////////////////////////////////////////////
    //SETTERS

    //MULTI setter
    public void setMechFields(String bodyColor, String bodyMaterial, String leadDiameter, String leadDispenseMechanism) {
        this.setBodyColor(bodyColor);
        this.setBodyMaterial(bodyMaterial);
        this.setLeadDiameter(leadDiameter);
        this.setLeadDispenseMechanism(leadDispenseMechanism);
    }

    /////////////////////////////////////////////////
    //INDIVIDUAL SETTERS check that field being set is valid

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public void setBodyMaterial(String bodyMaterial) {
        if (validBodyMaterials.contains(bodyMaterial)){
            this.bodyMaterial = bodyMaterial;
        }
    }

    public void setLeadDiameter(String leadDiameter) {
        if (validLeadDiameters.contains(leadDiameter)){
            this.leadDiameter = leadDiameter;
        }
    }

    public void setLeadDispenseMechanism(String leadDispenseMechanism) {
        if (validLeadDispenseMechanisms.contains(leadDispenseMechanism)){
            this.leadDispenseMechanism = leadDispenseMechanism;
        }
    }


}

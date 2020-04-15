import java.util.ArrayList;

public abstract class Product {

    //ID's must be unique, class keeps track of valid ID's in use
    private static ArrayList<Integer> productIDList = new ArrayList<Integer>();

    //one review per productID per customerID
    private ArrayList<Integer> reviewerIDList = new ArrayList<Integer>();

    private int productID;
    private float price;
    private String brand;
    private String name;

    private int qtyPurchase, qtyStock;
    private float avgRating;
    private ArrayList<Review> reviews;

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //CONSTRUCTOR

    //Constructor validates ID.  If ID is invalid, the Product will not be able to be
    //Added to Shop or Purchase.  Using invalid Product with Review will create invalid Review
    public Product(int productID) {

        if(productID > 0 && (productIDList.contains(productID) == false) ) {
            this.productID = productID;
            productIDList.add(productID);
        }
        else {
            if(productIDList.contains(productID) ){
                System.out.println("Product ID must be unique.  Product created cannot used in shop or purchases.");
            }

            if(productID < 0 ){
                System.out.println("Product ID cannot be negative.  Product created cannot be used in shop or purchases.");
            }

            this.productID = -1;

        }

        //////////////////////////////////////////////////////////////
        //Set rest of fields to default
        this.price = 0;
        this.brand = "0";
        this.name = "0";
        this.qtyPurchase = 0;
        this.qtyStock = 0;
        this.avgRating = 0;
        this.reviews = new ArrayList<Review>();
    }

    public Product(int productID, float price, String brand, String name, int qtyPurchase, int qtyStock, int avgRating, ArrayList<Review> reviews) {
        this(productID);
        this.price = price;
        this.brand = brand;
        this.name = name;
        this.qtyPurchase = qtyPurchase;
        this.qtyStock = qtyStock;
        this.avgRating = avgRating;
        this.reviews = reviews;
    }

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //GETTERS

    public int getProductID() {
        return productID;
    }

    public float getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getQtyPurchase() {
        return qtyPurchase;
    }

    public int getQtyStock() {
        return qtyStock;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }


    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //SETTERS


    public void setPrice(float price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQtyPurchase(int qtyPurchase) {
        if(qtyPurchase >= 0) {
            this.qtyPurchase = qtyPurchase;
        }
    }

    public void setQtyStock(int qtyStock) {
        if(qtyStock >= 0) {
            this.qtyStock = qtyStock;
        }
    }


    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //OTHER REVIEW FUNCTIONS

    //////////////////////////////////////////////////////////////
    //Add / Delete

    //Add Reviews
    public void addReview(Review review) {

        //Review can be added if: product ID in review matches this product ID AND
        //customer Id is valid AND
        //the product has not already been reviewed by this customer
        if ((review.getForProductID() == this.getProductID()) &&
                (review.getFromCustomerID()>0) &&
                (this.reviewerIDList.contains(review.getFromCustomerID()) == false)) {

            //Add review
            reviews.add(review);

            //Add customerID of review to list of customers who have reviewed product
            reviewerIDList.add(review.getFromCustomerID());

            //Recalculate avg rating
            this.calculateAverageRating();
        }
    }

    //Delete Reviews
    public void deleteReview(Review reviewToDelete) {
        reviews.remove(reviewToDelete);
        reviewerIDList.remove(reviewToDelete.getFromCustomerID());
        this.calculateAverageRating();
    }

    //////////////////////////////////////////////////////////////
    //Calculating Average Review Rating
    public void calculateAverageRating() {
        float avgRatingReturnVal = 0;

        if (reviews.isEmpty()) {
            this.avgRating = -1;
        }

        else {
            for (Review r: reviews) {
                avgRatingReturnVal = avgRatingReturnVal + r.getRating();
            }
            this.avgRating = ( avgRatingReturnVal / ( reviews.size() ) );
        }
    }

    //////////////////////////////////////////////////////////////
    //View Reviews
    //prints all review texts
    public void viewReviews() {
        for(Review r: reviews) {
            System.out.println( r.getRating() );
            System.out.println( r.toString() );
            System.out.println(" ");
        }

    }

    //////////////////////////////////////////////////////////////
    //EQUALITY: OVERRIDING equals(), same ID means equality
    @Override
    public boolean equals(Object object){
        //True if same object
        if (object == this){
            return true;
        }

        //False if not instance of Product
        if (!(object instanceof Product)){
            return false;
        }

        //Reaches this line, object is instance of Product, ok to cast
        //Equality if productID's are the same
        if (this.getProductID() == ((Product) object).getProductID()){
            return true;
        }
        else {
            return false;
        }
    }

    ///////////////////////////////////////////////
    //Check if Product ID is taken
    public static boolean isProductIDInUse(int productID) {
        return productIDList.contains(productID);
    }

    ////////////////////////////////////////////////////////////
    //CLEAR ID LIST: TESTING PURPOSES
    public static void clearIDList() {
        productIDList.clear();
    }
}

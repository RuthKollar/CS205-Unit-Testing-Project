public class Review {

    private int rating;
    private String reviewText;
    private int forProductID;
    private int fromCustomerID;

    ////////////////////////////////////////////////////
    ////////////////////////////////////////////////////
    //CONSTRUCTORS

    //Constructor validates customer and product ID's.
    //Invalid ID's creates invalid Review.  Cannot be modified later
    public Review(Product product, Customer customer){
        if (product.getProductID() > 0 && customer.getCustomerID() > 0){
            this.forProductID = product.getProductID();
            this.fromCustomerID = customer.getCustomerID();
        }
        else{
            System.out.println("Invalid Customer or Product");
            this.forProductID = -1;
            this.fromCustomerID = -1;
        }
        this.rating = 0;
        this.reviewText = "0";
    }

    public Review(Product product,Customer customer, int givenRating, String givenReviewText){
        this(product,customer);
        this.rating = givenRating;
        this.reviewText = givenReviewText;
    }

    /////////////////////////////////////////////////////
    ////////////////////////////////////////////////////
    //GETTERS

    public int getForProductID() {
        return forProductID;
    }

    public int getFromCustomerID() {
        return fromCustomerID;
    }

    public int getRating() {
        return rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    ////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////
    //SETTERS

    public void setRating(int rating) {
        if (rating < 6 && rating > (-1)){
            this.rating = rating;
        }

        else {
            System.out.println("Rating must be between 0 and 5 inclusive.");
        }
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    /////////////////////////////////////////////////////////
    //TOSTRING

    @Override
    public String toString() {
        return this.reviewText;
    }
}

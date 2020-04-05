import org.junit.Test;

import static org.junit.Assert.*;

public class ProductAvgRatingTest {

    Product product = new MechPencil(1);
    Customer customer1 = new Customer(1);
    Customer customer2 = new Customer(2);
    Customer customer3 = new Customer(3);

    Review review1 = new Review(product,customer1);
    Review review2 = new Review(product,customer2);
    Review review3 = new Review(product,customer3);

    @Test
    public void calculateAverageRating() {
        //Reviews default to 0 if they are not between 1 and 5
        review1.setRating(-5);
        assertEquals(0,review1.getRating());
        review1.setRating(99);
        assertEquals(0,review1.getRating());
        review1.setRating(1);
        assertEquals(1,review1.getRating());

        review2.setRating(2);
        review3.setRating(3);

        //Adding and deleting reviews
        //Checking avgRating changes as expected
        product.addReview(review1);
        assertEquals(1,product.getAvgRating(),0);

        product.addReview(review2);
        assertEquals(1.5,product.getAvgRating(),0);


        product.addReview(review3);
        assertEquals(2,product.getAvgRating(),0);


        product.deleteReview(review1);
        assertEquals(2.5,product.getAvgRating(),0);


    }
}
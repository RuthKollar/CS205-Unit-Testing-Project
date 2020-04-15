import org.junit.Test;

import static org.junit.Assert.*;

public class ShopCalculationFunctionsTest {

    Shop shop = new Shop();

    Customer customer1 = new Customer(1);

    Product product1 = new MechPencil(1);
    Product product2 = new FountainPen(2);
    Product product3 = new MechPencil(3);


    Purchase purchase1 = new Purchase(1,customer1);
    Purchase purchase2 = new Purchase(2,customer1);

    @Test
    public void calculateTotalShopIncome() {
        product1.setQtyStock(1);
        product1.setPrice(5);
        product2.setQtyStock(1);
        product2.setPrice(100);

        purchase1.addItem(product1);
        purchase2.addItem(product2);

        shop.addPurchase(purchase1);
        shop.addPurchase(purchase2);
        //Calculating shop income after adding purchases
        assertEquals(105,shop.calculateTotalShopIncome(),0);

        //Calculating shop income after removing a purchase
        shop.removePurchase(purchase2);
        assertEquals(5,shop.calculateTotalShopIncome(),0);

        //Reset for next test
        TestResetter.clearIDLists();


    }

    @Test
    public void findBestSellingProduct() {
        //Returns invalid product if there are no products
        assertEquals(-1,shop.findBestSellingProduct().getProductID());

        product1.setQtyPurchase(0);
        product2.setQtyPurchase(10);
        product3.setQtyPurchase(100);

        //Returns invalid product if every product has qtySold 0
        shop.addProduct(product1);
        assertEquals(-1,shop.findBestSellingProduct().getProductID());

        //Returns the bestselling product
        shop.addProduct(product2);
        shop.addProduct(product3);
        assertSame(product3,shop.findBestSellingProduct());

        //Reset for next test
        TestResetter.clearIDLists();

    }

}
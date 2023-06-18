import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopRepositoryTest {
    @Test
    public void testRemoveExistingProduct() {

        ShopRepository shop = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);
        shop.add(product1);
        shop.add(product2);

        shop.removeById(1);

        Product[] products = shop.findAll();
        assertEquals(1, products.length);
        assertEquals(product2, products[0]);
    }

    @Test
    public void testRemoveNonExistingProduct() {

        ShopRepository shop = new ShopRepository();
        Product product = new Product(1, "Product 1", 100);
        shop.add(product);

        assertThrows(NotFoundException.class, () -> shop.removeById(2));
    }
}


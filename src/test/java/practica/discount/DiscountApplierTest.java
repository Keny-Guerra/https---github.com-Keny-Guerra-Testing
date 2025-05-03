package practica.discount;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DiscountApplierTest {
    private final ProductDao dao = mock(ProductDao.class);
    private final DiscountApplier applier = new DiscountApplier(dao);

    @Test
    void businessCategory_shouldApply10PercentIncrease() {
        Product product = new Product("Laptop", 100.0, "BUSINESS");
        when(dao.all()).thenReturn(List.of(product));

        applier.setNewPrices();

        assertEquals(110.0, product.getPrice(), 0.001); // 100 * 1.1 = 110
    }

    @Test
    void homeCategory_shouldApply10PercentDiscount() {
        Product product = new Product("Chair", 100.0, "HOME");
        when(dao.all()).thenReturn(List.of(product));

        applier.setNewPrices();

        assertEquals(90.0, product.getPrice(), 0.001); // 100 * 0.9 = 90
    }

    @Test
    void otherCategory_shouldNotChangePrice() {
        Product product = new Product("Gadget", 100.0, "OTHER");
        when(dao.all()).thenReturn(List.of(product));

        applier.setNewPrices();

        assertEquals(100.0, product.getPrice(), 0.001);
    }

    @Test
    void shouldHandleMultipleProductsCorrectly() {
        Product homeProduct = new Product("Table", 200.0, "HOME");
        Product businessProduct = new Product("Printer", 300.0, "BUSINESS");
        when(dao.all()).thenReturn(List.of(homeProduct, businessProduct));

        applier.setNewPrices();

        assertEquals(180.0, homeProduct.getPrice(), 0.001); // 200 * 0.9
        assertEquals(330.0, businessProduct.getPrice(), 0.001); // 300 * 1.1
    }
}
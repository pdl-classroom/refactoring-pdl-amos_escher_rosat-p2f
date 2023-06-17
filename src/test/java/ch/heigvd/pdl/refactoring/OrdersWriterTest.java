package ch.heigvd.pdl.refactoring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class OrdersWriterTest {
    Orders orders = new Orders();
    Order order0;

    @BeforeEach
    public void SetupOneOrder() {
        // The counter has to be reset before each test since each test is run in parallel with a different context (thus different order ids)
        Order.resetIdCounter();
        order0 = new Order();
        orders.addOrder(order0);
    }

    @Test
    void NoOrder() {
        assertEquals("{\"orders\": []}", new OrdersWriter().getContents(new Orders()));
    }

    @Test
    void OneOrder() {
        String order0 = "{\"id\": 0, \"products\": []}";
        assertEquals("{\"orders\": [" + order0 + "]}", new OrdersWriter().getContents(orders));
    }

    @Test
    void TwoOrders() {
        orders.addOrder(new Order());
        String order0Json = JsonOrder0WithProduct("");
        String order1Json = "{\"id\": 1, \"products\": []}";
        assertEquals("{\"orders\": [" + order0Json + ", " + order1Json + "]}", new OrdersWriter().getContents(orders));
    }

    @Test
    void OneOrderWithOneProduct() {
        order0.addProduct(new Product("Shirt", Color.BLUE, Size.M, 2.99, "TWD"));
        String order0Json = JsonOrder0WithProduct("{\"code\": \"Shirt\", \"color\": \"blue\", \"size\": \"M\", \"price\": 2.99, \"currency\": \"TWD\"}");
        assertEquals("{\"orders\": [" + order0Json + "]}", new OrdersWriter().getContents(orders));
    }

    @Test
    void OneOrderWithOneProductNoSize() {
        order0.addProduct(new Product("Pot", Color.RED, Size.NO_SIZE, 16.50, "SGD"));
        String order0Json = JsonOrder0WithProduct("{\"code\": \"Pot\", \"color\": \"red\", \"price\": 16.5, \"currency\": \"SGD\"}");
        assertEquals("{\"orders\": [" + order0Json + "]}", new OrdersWriter().getContents(orders));
    }

    @Test
    void ColorTest() {
        Product p = new Product("Pot", Color.RED, Size.NO_SIZE, 16.50, "SGD");
        assertEquals(Color.RED, p.getColor());
    }

    @Test
    void SizeTest() {
        Product p = new Product("Pot", Color.RED, Size.NO_SIZE, 16.50, "SGD");
        assertEquals(Size.NO_SIZE, p.getSize());
    }

    private String JsonOrder0WithProduct(String productJson) {
        return "{\"id\": 0, \"products\": [" + productJson + "]}";
    }

}

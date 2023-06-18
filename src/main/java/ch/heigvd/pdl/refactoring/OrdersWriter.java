package ch.heigvd.pdl.refactoring;

import org.json.JSONArray;
import org.json.JSONObject;

public class OrdersWriter {

//    private Orders orders;

//    public OrdersWriter(Orders orders) {
//        this.orders = orders;
//    }

    private OrdersWriter() {
    }

    public static String getContents(Orders orders) {
        StringBuilder sb = new StringBuilder();
        try {
            JSONArray orderArray = new JSONArray();
            for (int i = 0; i < orders.getOrdersCount(); i++) {
                Order order = orders.getOrder(i);
                orderArray.put(getOrder(order));
            }
            JSONObject jsonOrders = new JSONObject();
            jsonOrders.put("orders", orderArray);
            sb.append(jsonOrders.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return putWhiteSpaces(sb).toString();
    }

    private static StringBuilder putWhiteSpaces(StringBuilder sb) {
        int i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == ',' || sb.charAt(i) == ':') {
                sb.insert(i + 1, ' ');
                i++;
            }
            i++;
        }
        return sb;
    }

    private static JSONObject getOrder(Order order) {
        JSONObject object = new JSONObject();
        try {
            object.put("id", order.getOrderId());
            object.put("products", getProducts(order));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    private static JSONArray getProducts(Order order) {
        JSONArray array = new JSONArray();
        for (int i = 0; i < order.getProductsCount(); i++) {
            array.put(getProduct(order.getProduct(i)));
        }
        return array;
    }

    private static JSONObject getProduct(Product product) {
        JSONObject object = new JSONObject();
        try {
            object.put("code", product.getCode());
            object.put("color", product.getColor());
            if (product.getSize() != Size.NO_SIZE) {
                object.put("size", product.getSize());
            }
            object.put("price", product.getPrice());
            object.put("currency", product.getCurrency());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
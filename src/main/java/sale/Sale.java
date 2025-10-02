package sale;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private double totalPrice;
    private List <Product> productList = new ArrayList<>();

    private final static  String message = "In order to make a sale, you must add some products";

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List <Product> getProductList() {
        return productList;
    }

    public void setProductList(List <Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void caltulateTotalPrice() throws ArrayIndexOutOfBoundsException{

        if (productList.size() == 0 || productList.isEmpty()) {
            throw new EmptySaleException(message);
        }

        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
    }

}

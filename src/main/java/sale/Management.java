package sale;

public class Management {
    public static void init(){

        Sale sale = new Sale();

        Product tshirt = new Product("shirt", 10.10);
        Product tshirt2 = new Product("shirt2",20.20);
        Product gauntlet = new Product("gauntlet",30.30);
        Product skirt = new Product("skirt",40.40);
        Product panties = new Product("panties",55);

        sale.addProduct(tshirt);
        sale.addProduct(tshirt2);
        sale.addProduct(gauntlet);
        sale.addProduct(skirt);
        sale.addProduct(skirt);

       try {
           sale.caltulateTotalPrice();
       } catch (ArrayIndexOutOfBoundsException e) {
           throw new EmptySaleException(e.getMessage());
       }
        System.out.println("Total price: " + sale.getTotalPrice());
    }
}

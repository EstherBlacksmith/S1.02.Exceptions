public class Management {
    public static void init(){

        Sale sale = new Sale();

        Product tshirt = new Product();
        tshirt.setName("shirt");
        tshirt.setPrice(10.10);


        Product tshirt2 = new Product();
        tshirt2.setName("shirt2");
        tshirt2.setPrice(20.20);

        Product gauntlet = new Product();
        gauntlet.setName("gauntlet");
        gauntlet.setPrice(30.30);

        Product skirt = new Product();
        skirt.setName("skirt");
        skirt.setPrice(40.40);

        Product panties = new Product();
        panties.setName("panties");
        panties.setPrice(55);

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

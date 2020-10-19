public class Product {

    String _name;
    Integer _count;
    Double _price;

    public Product(String name) {
        _name = name;
    }

    public Product(String name, Integer productCount, Double productPrice) {

        _name = name;
        _count = productCount;
        _price = productPrice;

    }

}
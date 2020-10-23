public class Product {

    String _name;
    Integer _count;
    Double _price;

    public Product(String name) {
        _name = name;
    }

    public Product(Integer productCount, Double productPrice) {

        _count = productCount;
        _price = productPrice;

    }

}
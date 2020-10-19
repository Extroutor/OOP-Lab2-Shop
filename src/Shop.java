import java.util.HashMap;

public class Shop {

    String _name;
    String _address;
    HashMap<Integer, Product> productsListOfThisShop = new HashMap<>();

    public Shop(String name, String address) {

        _name = name;
        _address = address;

    }

    public HashMap<Integer, Product> GetTheProd() {

        return productsListOfThisShop;

    }

    public void PutTheProd(String productName, Integer productID, Integer productCount, Double productPrice) {

        Product value = productsListOfThisShop.get(productID);
        if (value == null)
            productsListOfThisShop.put(productID, new Product(productName, productCount, productPrice));
        else {
            value._price = productPrice;
            value._count += productCount;
        }
    }

    public int GetCount(Integer prodID) {

        return productsListOfThisShop.get(prodID)._count;

    }

    public Double GetPrice(Integer prodID) {

        if (productsListOfThisShop.get(prodID) == null)
            return -1.0;
        return productsListOfThisShop.get(prodID)._price;

    }

    public void ChangePrice(Integer priceID, Double newPrice) {

        productsListOfThisShop.get(priceID)._price = newPrice;

    }

    public void addMoreProducts(Integer prodID, Integer count) {

        productsListOfThisShop.get(prodID)._count += count;

    }

    public void ChangeCount(Integer priceID, Integer newCount) {

        productsListOfThisShop.get(priceID)._count = newCount;

    }
}

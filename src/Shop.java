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

    public void PutTheProd(String productName, Integer productID, Integer productCount, Double productPrice) throws Exception {

        Product value = productsListOfThisShop.get(productID);
        if (value == null)
            productsListOfThisShop.put(productID, new Product(productName, productCount, productPrice));
        else {
            value._price = productPrice;
            value._count += productCount;
        }
    }

    public void opportunityToBuy(Double money) {

        int f = 0;

        for (Integer key : productsListOfThisShop.keySet()) {

            int prodCount = (int) (money / productsListOfThisShop.get(key)._price);

            if (prodCount < 1)
                f = 1;
            else if (prodCount > productsListOfThisShop.get(key)._count)
                System.out.println(productsListOfThisShop.get(key)._count + " " + productsListOfThisShop.get(key)._name);
            else
                System.out.println(prodCount + " " + productsListOfThisShop.get(key)._name);

        }
        if (f == 1)
            System.out.println("Nothing(");

    }

    public Double buyBatchOfProducts(Integer prodID, Integer count) throws Exception {

        if (!productsListOfThisShop.containsKey(prodID))
            throw new Exception("Unvailable products");

        if (count <= productsListOfThisShop.get(prodID)._count)
            return productsListOfThisShop.get(prodID)._price * count;
        else
            return -1.0;

    }


    public int GetCount(Integer prodID) throws Exception {

        if (!productsListOfThisShop.containsKey(prodID))
            throw new Exception("Unvailable shop");

        return productsListOfThisShop.get(prodID)._count;

    }

    public Double GetPrice(Integer prodID) throws Exception {

        if (!productsListOfThisShop.containsKey(prodID))
            throw new Exception("Unvailable shop");

        if (productsListOfThisShop.get(prodID) == null)
            return -1.0;
        return productsListOfThisShop.get(prodID)._price;

    }

    public void ChangePrice(Integer prodID, Double newPrice) throws Exception {
        if (!productsListOfThisShop.containsKey(prodID))
            throw new Exception("Unvailable shop");

        productsListOfThisShop.get(prodID)._price = newPrice;

    }

    public void addMoreProducts(Integer prodID, Integer count) throws Exception {

        if (!productsListOfThisShop.containsKey(prodID))
            throw new Exception("Unvailable shop");

        productsListOfThisShop.get(prodID)._count += count;

    }

    public void ChangeCount(Integer prodID, Integer newCount) throws Exception {

        if (!productsListOfThisShop.containsKey(prodID))
            throw new Exception("Unvailable shop");

        productsListOfThisShop.get(prodID)._count = newCount;

    }
}

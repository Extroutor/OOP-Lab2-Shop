import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;

public class ChainOfStores {

    HashMap<Integer, Shop> shops = new HashMap<>();
    HashMap<Integer, Product> products = new HashMap<>();

    public int AddTheShop(String name, String address) {

        int id = (int) (Math.random() * 100);
        shops.put(id, new Shop(name, address));
        return id;

    }

    public void GetList(HashMap<String, Integer> shopsList) {

        for (String key : shopsList.keySet()) {

            System.out.println("\"" + shops.get(shopsList.get(key))._name + "\" - " + shops.get(shopsList.get(key))._address);

        }

    }

    public void GetAllShopsProduct() {

        for (Integer key : shops.keySet()) {
            HashMap<Integer, Product> map = shops.get(key).GetTheProd();
            System.out.println("\"" + shops.get(key)._name + "\": ");
            for (Integer temp : map.keySet()) {

                System.out.println("name: " + map.get(temp)._name + " (id: " + temp + "), " +
                        "count: " + map.get(temp)._count + ", price: " + map.get(temp)._price);

            }

        }
    }

    public int AddTheProduct(String name) {

        int id = (int) (Math.random() * 1000);
        products.put(id, new Product(name));
        return id;

    }

    public void PutTheProduct(Integer shopID, String productName, Integer productID, Integer productCount, Double productPrice) {

        shops.get(shopID).PutTheProd(productName, productID, productCount, productPrice);

    }

    public Integer GetTheProductsCount(Integer shopID, Integer productID) {

        return shops.get(shopID).GetCount(productID);

    }

    public Double GetTheProductsPrice(Integer shopID, Integer productID) {

        return shops.get(shopID).GetPrice(productID);

    }

    public String GetTheShopsAddress(Integer shopID) {

        return shops.get(shopID)._address;
    }

    public void ChangeThePrice(Integer shopID, Integer productID, Double newPrice) {

        shops.get(shopID).ChangePrice(productID, newPrice);

    }

    public void AddMoreProducts(Integer shopID, Integer prodID, Integer count) {

        shops.get(shopID).addMoreProducts(prodID, count);

    }

    public void ChangeTheCount(Integer shopID, Integer productID, Integer newCount) {

        shops.get(shopID).ChangeCount(productID, newCount);

    }

    public void ShopWithTheCheapestProduct(HashMap<String, Integer> shopsList, Integer productID) {

        String shopWithMinPrice = null;
        double minPrice = -1.0;

        for (String key : shopsList.keySet()) {
            double price = (shops.get(shopsList.get(key))).GetPrice(productID);
            if (price == -1.0)
                continue;
            if (minPrice == -1) {
                minPrice = price;
                shopWithMinPrice = key;
            }

            if (price < minPrice) {
                minPrice = price;
                shopWithMinPrice = key;
            }
        }

        if (minPrice == -1.0 || shopWithMinPrice == null)
            throw new RuntimeException("There is no product in the stores");

        System.out.println("\"" + shopWithMinPrice + "\" - " + minPrice);
    }

    public void OpportunityToBuy(Integer shopID, Double money) {

        HashMap<Integer, Product> map = shops.get(shopID).GetTheProd();

        System.out.println("You can buy in the \"" + shops.get(shopID)._name + "\" for " + money + " rubles:");

        for (Integer key : map.keySet()) {

            int prodCount = (int) (money / map.get(key)._price);

            if (prodCount > map.get(key)._count)
                System.out.println(map.get(key)._count + " " + map.get(key)._name);
            else
                System.out.println(prodCount + " " + map.get(key)._name);
        }

    }

    public Double BuyBatchOfProducts (Integer shopID, Integer prodID, Integer count) {

        HashMap<Integer, Product> map = shops.get(shopID).GetTheProd();

        if (count <= map.get(prodID)._count)
            return map.get(prodID)._price * count;
        else
            return -1.0;

    }


}

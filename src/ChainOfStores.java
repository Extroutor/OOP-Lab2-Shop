import java.util.HashMap;

public class ChainOfStores {

    HashMap<Integer, Shop> shops = new HashMap<>();
    HashMap<Integer, Product> products = new HashMap<>();
    int shopID = 0;
    int prodID = 0;


    public int AddTheShop(String name, String address) {

        shopID++;
        for (int i : shops.keySet()) {
            if (shops.get(i)._name.equals(name)) {
                throw new RuntimeException("Such store already exists");
            }
        }
        shops.put(shopID, new Shop(name, address));
        return shopID;

    }

    public int AddTheProduct(String name) {

        prodID++;
        for (int i : products.keySet()) {
            if (products.get(i)._name.equals(name)) {
                throw new RuntimeException("Such product already exists");
            }
        }
        products.put(prodID, new Product(name));
        return prodID;

    }

    public void AddMoreProducts(Integer shopID, Integer prodID, Integer count) throws Exception {

        if (!shops.containsKey(shopID))
            throw new Exception("Unvailable shop");

        shops.get(shopID).addMoreProducts(prodID, count);

    }

    public void PutTheProductToShop(Integer shopID,  Integer productID, Integer productCount, Double productPrice) throws Exception {

        if (!shops.containsKey(shopID))
            throw new Exception("Unvailable shop");

        shops.get(shopID).PutTheProd(productID, productCount, productPrice);

    }

    public void ChangeThePrice(Integer shopID, Integer productID, Double newPrice) throws Exception {

        if (!shops.containsKey(shopID))
            throw new Exception("Unvailable shop");

        shops.get(shopID).ChangePrice(productID, newPrice);

    }


    public void ChangeTheCount(Integer shopID, Integer productID, Integer newCount) throws Exception {

        if (!shops.containsKey(shopID))
            throw new Exception("Unvailable shop");

        shops.get(shopID).ChangeCount(productID, newCount);

    }

    public void ShopWithTheCheapestProduct(HashMap<String, Integer> shopsList, Integer productID) throws Exception {

        HashMap<String, Double> list = new HashMap<>();
        String shopWithMinPrice = null;
        double minPrice = -1.0;

        for (String key : shopsList.keySet()) {
            double price = (shops.get(shopsList.get(key))).GetPrice(productID);
            if (price == -1.0)
                continue;
            if (minPrice == -1.0) {
                minPrice = price;
                shopWithMinPrice = key;
                list.put(key, price);
            } else {
                if (price < minPrice) {
                    minPrice = price;
                    shopWithMinPrice = key;
                    list.clear();
                    list.put(key, price);
                } else if (price == minPrice) {
                    list.put(key, price);
                }
            }
        }

        if (minPrice == -1.0 || shopWithMinPrice == null)
            throw new RuntimeException("There is no product in the stores");

        for (String key : list.keySet()) {

            System.out.println("\"" + key + "\" - " + list.get(key));

        }

    }

    public void OpportunityToBuy(Integer shopID, Double money) throws Exception {

        if (!shops.containsKey(shopID))
            throw new Exception("Unvailable shop");

        System.out.println("You can buy in the \"" + shops.get(shopID)._name + "\" for " + money + " rubles:");
        shops.get(shopID).opportunityToBuy(money);


    }

    public void BuyBatchOfProducts(Integer shopID, Integer prodID, Integer count) throws Exception {

        if (!shops.containsKey(shopID))
            throw new Exception("Unvailable shop");

        double totalCost = shops.get(shopID).buyBatchOfProducts(prodID, count);
        if (totalCost != -1.0)
            System.out.println("Yes, you can. Total prise is " + totalCost);
        else
            System.out.println("No, you can't. No enough product");

    }


    public void ShopWithTheCheapestBatchOfProducts(HashMap<Integer, Integer> batch) {

        double minSum = -1.0;
        String shopWithMinPrice = "";

        for (Integer key : shops.keySet()) { //перебор магазинов

            HashMap<Integer, Product> listOfProdInShop = shops.get(key).GetTheProd(); //лист продуктов данного магазина
            int size = batch.size();
            double sum = 0.0;
            for (Integer temp : batch.keySet()) { //перебор товаров в партии по id
                if (listOfProdInShop.size() < batch.size())
                    break;
                else {
                    for (Integer product : listOfProdInShop.keySet()) { //проход по каждому продукту
                        if (listOfProdInShop.get(product)._name.equals(products.get(temp)._name))
                            if (listOfProdInShop.get(product)._count >= batch.get(temp))
                                size--;
                    }
                }
            }
            if (size != 0)
                continue;
            else {

                for (Integer prod : batch.keySet()) {
                    for (Integer t : listOfProdInShop.keySet()) {
                        if (products.get(prod)._name.equals(listOfProdInShop.get(t)._name))
                            sum += batch.get(prod) * listOfProdInShop.get(t)._price;

                    }
                }
                if (minSum == -1.0) {
                    minSum = sum;
                    shopWithMinPrice = shops.get(key)._name;
                } else {
                    if (sum < minSum) {
                        minSum = sum;
                        shopWithMinPrice = shops.get(key)._name;
                    }
                }
            }
        }
        if (shopWithMinPrice.equals(""))
            System.out.println("There are no shop, which you need");
        else
            System.out.println("\"" + shopWithMinPrice + "\" - " + minSum);

    }

    public void GetShopsList(HashMap<String, Integer> shopsList) {

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

    public Integer GetTheProductsCount(Integer shopID, Integer productID) throws Exception {

        if (!shops.containsKey(shopID))
            throw new Exception("Unvailable shop");

        return shops.get(shopID).GetCount(productID);

    }

    public Double GetTheProductsPrice(Integer shopID, Integer productID) throws Exception {

        if (!shops.containsKey(shopID))
            throw new Exception("Unvailable shop");

        return shops.get(shopID).GetPrice(productID);

    }

    public String GetTheShopsAddress(Integer shopID) throws Exception {

        if (!shops.containsKey(shopID))
            throw new Exception("Unvailable shop");

        return shops.get(shopID)._address;

    }

}

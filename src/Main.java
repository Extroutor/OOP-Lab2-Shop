import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {

        ChainOfStores chainOfStores = new ChainOfStores();

        HashMap<String, Integer> shopslist = new HashMap<>();
        HashMap<String, Integer> productsList = new HashMap<>();

        // 1. Создать магазины
        shopslist.put("Diksi", chainOfStores.AddTheShop("Diksi", "Leningradskaya 70"));
        shopslist.put("Magnit", chainOfStores.AddTheShop("Magnit", "Solnechnaya 45"));
        shopslist.put("Verniy", chainOfStores.AddTheShop("Verniy", "Prospekt nauki 17"));

        // 1.1 Вывести список магазинов с улицами
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("THE LIST OF SHOPS WITH ADDRESS:");
        chainOfStores.GetShopsList(shopslist);
        System.out.println("");

        // 2. Создать товары
        productsList.put("Bread", chainOfStores.AddTheProduct("Bread"));
        productsList.put("Milk", chainOfStores.AddTheProduct("Milk"));
        productsList.put("Tea", chainOfStores.AddTheProduct("Tea"));
        productsList.put("Soap", chainOfStores.AddTheProduct("Soap"));
        productsList.put("Shampoo", chainOfStores.AddTheProduct("Shampoo"));
        productsList.put("Riсe", chainOfStores.AddTheProduct("Riсe"));
        productsList.put("Pasta", chainOfStores.AddTheProduct("Pasta"));
        productsList.put("Ketchup", chainOfStores.AddTheProduct("Ketchup"));
        productsList.put("Juice", chainOfStores.AddTheProduct("Juice"));
        productsList.put("Yogurt", chainOfStores.AddTheProduct("Yogurt"));

        // 2.1 Вывести доступные товары
        System.out.println("THE LIST OF AVAILABLE PRODUCTS:");
        for (String key : productsList.keySet()) {

            System.out.println("name: " + key + ", id: " + productsList.get(key));

        }
        System.out.println("");

        // 3. Завезти партию товаров в магазины
        chainOfStores.PutTheProductToShop(shopslist.get("Diksi"), "Bread", productsList.get("Bread"), 3, 30.0);
        chainOfStores.PutTheProductToShop(shopslist.get("Diksi"), "Milk", productsList.get("Milk"), 2, 40.0);
        chainOfStores.PutTheProductToShop(shopslist.get("Magnit"), "Bread", productsList.get("Bread"), 2, 28.0);
        chainOfStores.PutTheProductToShop(shopslist.get("Magnit"), "Milk", productsList.get("Milk"), 1, 48.0);
        chainOfStores.PutTheProductToShop(shopslist.get("Verniy"), "Bread", productsList.get("Bread"), 4, 35.0);
        chainOfStores.PutTheProductToShop(shopslist.get("Verniy"), "Juice", productsList.get("Juice"), 5, 25.0);

        // 3.1 Вывести список товаров каждого магазина и их содержание
        System.out.println("THE AVAILABLE PRODUCTS IN EACH SHOPS:");
        chainOfStores.GetAllShopsProduct();
        System.out.println("");


        // 3.1 Поменять стоимость товаров в магазине
        System.out.println("changing the costs...");
        chainOfStores.ChangeThePrice(shopslist.get("Diksi"), productsList.get("Bread"), 35.0);
        chainOfStores.ChangeThePrice(shopslist.get("Magnit"), productsList.get("Milk"), 45.0);
        chainOfStores.ChangeThePrice(shopslist.get("Verniy"), productsList.get("Juice"), 30.0);

        // 3.1.1 Вывести обновлённый список товаров каждого магазина и их содержание
        System.out.println("THE UPDATED LIST OF AVAILABLE PRODUCTS IN EACH SHOPS:");
        chainOfStores.GetAllShopsProduct();
        System.out.println("");

        // 3.2 Добавить ещё товар в магазин (увеличить имеющееся количество продуктов)
        chainOfStores.AddMoreProducts(shopslist.get("Diksi"), productsList.get("Bread"), 3);
        chainOfStores.AddMoreProducts(shopslist.get("Magnit"), productsList.get("Milk"), 2);
        chainOfStores.AddMoreProducts(shopslist.get("Verniy"), productsList.get("Juice"), 1);


        //3.3 Поменять количество товара в магазине
        chainOfStores.ChangeTheCount(shopslist.get("Diksi"), productsList.get("Bread"), 5);
        chainOfStores.ChangeTheCount(shopslist.get("Magnit"), productsList.get("Bread"), 4);
        chainOfStores.ChangeTheCount(shopslist.get("Verniy"), productsList.get("Bread"), 3);


        //3.4 Добавить товар, который уже есть в магазине и/или с другой стоимостью
        // (в таком случае просто увеличить количество продукта и поменять стоимость)
        chainOfStores.PutTheProductToShop(shopslist.get("Diksi"), "Bread", productsList.get("Bread"), 2, 28.0);

        // 3.4.1 Вывести обновлённый список товаров каждого магазина и их содержание
        System.out.println("changing the costs and counts...");
        System.out.println("THE UPDATED LIST OF AVAILABLE PRODUCTS IN EACH SHOPS:");
        chainOfStores.GetAllShopsProduct();
        System.out.println("");

        // 4. Найти магазин, в котором определённый товар самый дешёвый
        System.out.println("THE SHOP(S) WITH THE CHEAPEST BREAD:");
        chainOfStores.ShopWithTheCheapestProduct(shopslist, productsList.get("Bread"));
        System.out.println("");

        // 5. Понять, ĸаĸие товары можно ĸупить в магазине на неĸоторую сумму
        chainOfStores.OpportunityToBuy(shopslist.get("Diksi"), 100.0);
        System.out.println("");
        chainOfStores.OpportunityToBuy(shopslist.get("Magnit"), 10.0);
        System.out.println("");

        // 6. Купить партию товаров в магазине
        System.out.println("CAN I BUY A BATCH OF PRODUCTS IN \"DIKSI\"?");
        chainOfStores.BuyBatchOfProducts(shopslist.get("Diksi"), productsList.get("Bread"), 3);
        System.out.println("");

        // 7. Найти, в каком магазине партия товаров дешевле

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(productsList.get("Bread"), 3);
        map.put(productsList.get("Milk"), 1);

        System.out.println("SHOP WITH THE CHEAPEST BATCH OF PRODUCTS:");
        chainOfStores.ShopWithTheCheapestBatchOfProducts(map);

    }

}
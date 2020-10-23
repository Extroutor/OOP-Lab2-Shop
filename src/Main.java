import java.util.HashMap;
public class Main {
    public static void main(String[] args) throws Exception {

        ChainOfStores chainOfStores = new ChainOfStores();

        HashMap<String, Integer> shopsList = new HashMap<>();
        HashMap<String, Integer> productsList = new HashMap<>();

        // 1. Создать магазины
        shopsList.put("Diksi", chainOfStores.AddTheShop("Diksi", "Leningradskaya 70"));
        shopsList.put("Magnit", chainOfStores.AddTheShop("Magnit", "Solnechnaya 45"));
        shopsList.put("Verniy", chainOfStores.AddTheShop("Verniy", "Prospekt nauki 17"));

        // 1.1 Вывести список магазинов с улицами
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("THE LIST OF SHOPS WITH ADDRESS:");
        chainOfStores.GetShopsList(shopsList);
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
        chainOfStores.PutTheProductToShop(shopsList.get("Diksi"), productsList.get("Bread"), 3, 30.0);
        chainOfStores.PutTheProductToShop(shopsList.get("Diksi"), productsList.get("Milk"), 2, 40.0);
        chainOfStores.PutTheProductToShop(shopsList.get("Magnit"),productsList.get("Bread"), 2, 28.0);
        chainOfStores.PutTheProductToShop(shopsList.get("Magnit"), productsList.get("Milk"), 1, 48.0);
        chainOfStores.PutTheProductToShop(shopsList.get("Verniy"), productsList.get("Bread"), 4, 35.0);
        chainOfStores.PutTheProductToShop(shopsList.get("Verniy"), productsList.get("Juice"), 5, 25.0);

        // 3.1 Вывести список товаров каждого магазина и их содержание
        System.out.println("THE AVAILABLE PRODUCTS IN EACH SHOPS:");
        chainOfStores.GetAllShopsProduct();
        System.out.println("");


        // 3.1 Поменять стоимость товаров в магазине
        System.out.println("changing the costs...");
        chainOfStores.ChangeThePrice(shopsList.get("Diksi"), productsList.get("Bread"), 35.0);
        chainOfStores.ChangeThePrice(shopsList.get("Magnit"), productsList.get("Milk"), 45.0);
        chainOfStores.ChangeThePrice(shopsList.get("Verniy"), productsList.get("Juice"), 30.0);

        // 3.1.1 Вывести обновлённый список товаров каждого магазина и их содержание
        System.out.println("THE UPDATED LIST OF AVAILABLE PRODUCTS IN EACH SHOPS:");
        chainOfStores.GetAllShopsProduct();
        System.out.println("");

        // 3.2 Добавить ещё товар в магазин (увеличить имеющееся количество продуктов)
        chainOfStores.AddMoreProducts(shopsList.get("Diksi"), productsList.get("Bread"), 3);
        chainOfStores.AddMoreProducts(shopsList.get("Magnit"), productsList.get("Milk"), 2);
        chainOfStores.AddMoreProducts(shopsList.get("Verniy"), productsList.get("Juice"), 1);


        //3.3 Поменять количество товара в магазине
        chainOfStores.ChangeTheCount(shopsList.get("Diksi"), productsList.get("Bread"), 5);
        chainOfStores.ChangeTheCount(shopsList.get("Magnit"), productsList.get("Bread"), 4);
        chainOfStores.ChangeTheCount(shopsList.get("Verniy"), productsList.get("Bread"), 3);


        //3.4 Добавить товар, который уже есть в магазине и/или с другой стоимостью
        // (в таком случае просто увеличить количество продукта и поменять стоимость)
        chainOfStores.PutTheProductToShop(shopsList.get("Diksi"), productsList.get("Bread"), 2, 28.0);

        // 3.4.1 Вывести обновлённый список товаров каждого магазина и их содержание
        System.out.println("changing the costs and counts...");
        System.out.println("THE UPDATED LIST OF AVAILABLE PRODUCTS IN EACH SHOPS:");
        chainOfStores.GetAllShopsProduct();
        System.out.println("");

        // 4. Найти магазин, в котором определённый товар самый дешёвый
        System.out.println("THE SHOP(S) WITH THE CHEAPEST BREAD:");
        chainOfStores.ShopWithTheCheapestProduct(shopsList, productsList.get("Bread"));
        System.out.println("");

        // 5. Понять, ĸаĸие товары можно ĸупить в магазине на неĸоторую сумму
        chainOfStores.OpportunityToBuy(shopsList.get("Diksi"), 100.0);
        System.out.println("");
        chainOfStores.OpportunityToBuy(shopsList.get("Magnit"), 10.0);
        System.out.println("");

        // 6. Купить партию товаров в магазине
        System.out.println("CAN I BUY A BATCH OF PRODUCTS IN \"DIKSI\"?");
        chainOfStores.BuyBatchOfProducts(shopsList.get("Diksi"), productsList.get("Bread"), 3);
        System.out.println("");

        // 7. Найти, в каком магазине партия товаров дешевле

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(productsList.get("Bread"), 3);
        map.put(productsList.get("Milk"), 1);

        System.out.println("SHOP WITH THE CHEAPEST BATCH OF PRODUCTS:");
        chainOfStores.ShopWithTheCheapestBatchOfProducts(map);

    }

}
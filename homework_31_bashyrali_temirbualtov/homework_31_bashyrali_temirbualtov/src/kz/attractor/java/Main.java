package kz.attractor.java;

// import static java.util.stream.Collectors.*;
// import static java.util.Comparator.*;

// используя статические imports
// мы импортируем *всё* из Collectors и Comparator.
// теперь нам доступны такие операции как
// toList(), toSet() и прочие, без указания уточняющего слова Collectors. или Comparator.
// вот так было до импорта Collectors.toList(), теперь стало просто toList()

import kz.attractor.java.homework.RestaurantOrders;
import kz.attractor.java.homework.domain.Customer;
import kz.attractor.java.homework.domain.Order;
import kz.attractor.java.lesson.MovieCollection;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // это для занятия
//        var movieCollection = MovieCollection.readFromJson();

        // это для домашки
        // выберите любое количество заказов, какое вам нравится.

        var orders = RestaurantOrders.read("orders_100.json").getOrders();
//        1 задание
        orders.forEach(Order::showOrder);
        Order.maxOrder(orders,5).forEach(Order::showOrder);
        Order.minOrder(orders,5).forEach(Order::showOrder);
        Order.homeOrder(orders).forEach(Order::showOrder);
        Order.homeSort(Order.homeOrder(orders));
        Order.maxMinOrders(orders);
        System.out.format("Общая стоимотсь всех заказов %s", Order.totalToatl(orders));
        Order.printEmailUniq(orders);
//        2 Задание
        Order.uniqCustomerItem(orders);
        Order.uniqCustomerTotal(orders);
        Order.maxCustomer(orders);
        Order.minCustomer(orders);





        //var orders = RestaurantOrders.read("orders_1000.json").getOrders();
        //var orders = RestaurantOrders.read("orders_10_000.json").getOrders();

        // протестировать ваши методы вы можете как раз в этом файле (или в любом другом, в котором вам будет удобно)
    }
}

package kz.attractor.java.homework.domain;

import kz.attractor.java.homework.util.NotImplementedException;
import  kz.attractor.java.homework.domain.Item;

import java.util.*;
import java.util.stream.Collectors;

public class Order {
    // Этот блок кода менять нельзя! НАЧАЛО!
    private final Customer customer;
    private final List<Item> items;
    private final boolean homeDelivery;
    private transient double total = 0.0d;

    public Order(Customer customer, List<Item> orderedItems, boolean homeDelivery) {
        this.customer = customer;
        this.items = List.copyOf(orderedItems);
        this.homeDelivery = homeDelivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return homeDelivery == order.homeDelivery &&
                Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, homeDelivery);
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isHomeDelivery() {
        return homeDelivery;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotal() {
        return total;
    }
    // Этот блок кода менять нельзя! КОНЕЦ!

    //----------------------------------------------------------------------
    //------   Реализация ваших методов должна быть ниже этой линии   ------
    //----------------------------------------------------------------------

    public void calculateTotal() {
        this.total = items.stream()
                .mapToDouble(item -> item.getPrice() * item.getAmount())
                .sum();
    }
    public void showOrder(){
        System.out.format("Полное имя: %s Email: %s \n",getCustomer().getFullName(),getCustomer().getEmail());
        for (Item item: items) {
            System.out.format("Название: %s, Цена: %s, Тип: %s, Количество: %s\n",item.getName(),item.getPrice(), item.getType(), item.getAmount());
        }
        System.out.format("Полная сумма заказа: %s, Доставка до дома: %s\n\n", getTotal(),homeDelivery);
    }
    public static List<Order> maxOrder(List<Order> orders, int count){
        var a = orders.stream()
                .sorted(Comparator.comparingDouble(Order::getTotal).reversed())
                .limit(count)
                .collect(Collectors.toList());
        return a;
    }
    public static  List<Order> minOrder(List<Order> orders, int count){
        var a = orders.stream()
                .sorted(Comparator.comparingDouble(Order::getTotal))
                .limit(count)
                .collect(Collectors.toList());
        return a;
    }
    public static List<Order> homeOrder(List<Order> orders){

        List<Order> a= orders.stream()
                .filter((Order::isHomeDelivery))
                .collect(Collectors.toList());
        return a;
    }
    public static void homeSort (List<Order> orders){

        List<Order> a = orders.stream()
                .sorted(Comparator.comparingDouble(Order::getTotal).reversed())
                .collect(Collectors.toList());
        a.forEach(Order::showOrder);
    }

    public static double totalToatl(List<Order> orders){
        double a = orders.stream()
                .mapToDouble(Order::getTotal)
                .sum();
        return a;
    }
    public static void maxMinOrders(List<Order> orders){
        var a =  orders.stream()
                .max(Comparator.comparingDouble(Order::getTotal)).get();
        var b = orders.stream()
                        .min(Comparator.comparingDouble(Order::getTotal)).get();
        var c = orders.stream()
                .filter(order -> a.getTotal()>order.getTotal() && b.getTotal()<order.getTotal())
                .collect(Collectors.toList());
        c.forEach(Order::showOrder);
    }

    public static void uniqCustomerItem(List<Order> orders){
        var mapOrders = orders.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer().getFullName()));
         for (Map.Entry<String,List<Order>> entry :mapOrders.entrySet()){
             System.out.printf("Имя заказчика: %s \n", entry.getKey());
             for (Order order:entry.getValue()) {
                 for (Item item: order.getItems()){
                     System.out.format("Название: %s, Цена: %s, Тип: %s, Количество: %s\n",item.getName(),item.getPrice(), item.getType(), item.getAmount());
                 }
                 System.out.format("Полная сумма заказа: %s, Доставка до дома: %s\n", order.getTotal(),order.homeDelivery);
             }
             System.out.println();
         }
    }
    public static void uniqCustomerTotal(List<Order> orders){
        var a = orders.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer().getFullName(),Collectors.summingDouble(Order::getTotal)));

        a.forEach((k, v) -> System.out.printf("%s |Общая стоимость всех заказов %s\n", k, v));
    }
    public static Set<String> getEmailUniq(List<Order> orders){
        return orders.stream()
                .map(order -> order.getCustomer().getEmail())
                .collect(Collectors.toCollection(TreeSet::new));
    }
    public static void printEmailUniq(List<Order> orders){
        var emails = getEmailUniq(orders);
        emails.forEach(System.out::println);
    }
    public static void maxCustomer(List<Order> orders){
        var a = orders.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer().getFullName(),Collectors.summingDouble(Order::getTotal)));
        var b = a.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        System.out.printf("Максимальное сумма заказа у зкакзачика: %s\n",b);


    }
    public static void minCustomer(List<Order> orders){
        var b = orders.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer().getFullName(), Collectors.summingDouble(Order::getTotal)));
        var a = b.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        System.out.printf("Минимальное сумма заказа у заказчика: %s\n", a);
    }
}

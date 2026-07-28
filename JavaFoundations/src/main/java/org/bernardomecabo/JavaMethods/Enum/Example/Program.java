package org.bernardomecabo.JavaMethods.Enum.Example;

import org.bernardomecabo.JavaMethods.Enum.Example.entities.Order;
import org.bernardomecabo.JavaMethods.Enum.Example.entities.enums.OrderStatus;

import java.time.Instant;
import java.util.Date;

public class Program {
    static void main() {
        Order order = new Order();
        order.setId(1);
        order.setMoment(Date.from(Instant.now()));
        order.setStatus(OrderStatus.PENDING_PAYMENT);

        System.out.println(order);

        OrderStatus orderStatus = OrderStatus.PROCESSING;
        OrderStatus orderStatus2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(orderStatus);
        System.out.println(orderStatus2);
    }
}

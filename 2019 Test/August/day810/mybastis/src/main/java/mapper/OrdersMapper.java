package mapper;


import po.Orders;
import poEx.OrdersEx;

import java.util.List;

public interface OrdersMapper {
    public List<OrdersEx> queryOrdersANDUser() throws Exception;

    public List<Orders> qyeryOrderToUser() throws Exception;

    public List<Orders> queryOdersToOrderDetail() throws Exception;

    public List<Orders> queryOrdersToitems() throws Exception;
}

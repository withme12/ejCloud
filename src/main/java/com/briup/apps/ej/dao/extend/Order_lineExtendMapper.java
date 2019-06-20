package com.briup.apps.ej.dao.extend;

import com.briup.apps.ej.bean.extend.OrderLineExtend;

import java.util.List;

public interface Order_lineExtendMapper {
    List<OrderLineExtend> findOrderDetails(Long id);
}

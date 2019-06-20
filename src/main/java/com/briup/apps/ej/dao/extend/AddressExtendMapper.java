package com.briup.apps.ej.dao.extend;

import com.briup.apps.ej.bean.extend.AddressExtend;

import java.util.List;

public interface AddressExtendMapper {
    List<AddressExtend> findCustomerAddressById(Long id);
}

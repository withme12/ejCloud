package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.bean.WaiterExample;
import com.briup.apps.ej.dao.WaiterMapper;
import com.briup.apps.ej.service.IWaiterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IWaiterServiceImpl implements IWaiterService {
    @Resource
    private WaiterMapper waiterMapper;

    @Override
    public int saveOrUpdate(Waiter waiter) throws Exception{
        if(waiter.getId() == null)
           return waiterMapper.insert(waiter);
        else
          return   waiterMapper.updateByPrimaryKey(waiter);
    }

    @Override
    public int deleteById(Long id) throws Exception{
        return waiterMapper.deleteByPrimaryKey(id);
    }
//asd
    @Override
    public List<Waiter> selectAll() {
        WaiterExample waiterExample = new WaiterExample();
        return waiterMapper.selectByExample(waiterExample);
    }
}

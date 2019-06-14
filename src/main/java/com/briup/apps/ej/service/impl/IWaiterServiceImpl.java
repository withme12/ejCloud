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
    public List<Waiter> findAll() {
        WaiterExample example = new WaiterExample();
        return waiterMapper.selectByExample(example);
    }

    @Override
    public Waiter selectById(long id) {
            return waiterMapper.selectByPrimaryKey(id);

        }



    @Override
    public void batchDelete(Long[] ids) throws Exception {
        for(long id : ids){
            waiterMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<Waiter> query(Waiter waiter) {
        WaiterExample example=new WaiterExample();
        //通过服务员姓名模糊查询
        if (waiter.getRealname()!=null){
            example.createCriteria().andRealnameLike("%"+waiter.getRealname()+"%");

        }
        //通过服务员电话模糊查询
        if (waiter.getTelephone()!=null){
            example.createCriteria().andTelephoneLike("%"+waiter.getTelephone()+"%");

        }
        //通过服务员Id卡模糊查询
        if (waiter.getIdcard()!=null){
            example.createCriteria().andIdcardLike("%"+waiter.getIdcard()+"%");

        }

        return waiterMapper.selectByExample(example);
    }


    @Override
    public int saveOrUpdate(Waiter waiter) throws Exception{
        if(waiter.getId() == null)
           return waiterMapper.insert(waiter);
        else
          return   waiterMapper.updateByPrimaryKey(waiter);
    }

    @Override
    public int deleteById(Long id) throws Exception{
        Waiter waiter=waiterMapper.selectByPrimaryKey(id);

        if (waiter == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            return waiterMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public List<Waiter> selectAll() {
        WaiterExample waiterExample = new WaiterExample();
        return waiterMapper.selectByExample(waiterExample);
    }
}

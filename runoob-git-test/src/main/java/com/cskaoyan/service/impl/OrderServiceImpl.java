package com.cskaoyan.service.impl;

import com.cskaoyan.bean.C_order;
import com.cskaoyan.bean.C_orderExample;
import com.cskaoyan.bean.CustomExample;
import com.cskaoyan.mapper.C_orderMapper;
import com.cskaoyan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    C_orderMapper cOrderMapper;

    @Override
    public List<C_order> orderPage(int page, int rows) {
        C_orderExample cOrderExample = new C_orderExample();
        C_orderExample.Criteria criteria = cOrderExample.createCriteria();
        criteria.andCustomIdIsNotNull();
        List<C_order> cOrders = cOrderMapper.selectByExample(cOrderExample);
        return cOrders;
    }

    @Override
    public int orderAdd(C_order order) {
        int insert = cOrderMapper.insert(order);
        return insert  != 0 ? 1 : 0;
    }

    @Override
    public int orderUpdate(C_order order) {
        int update = cOrderMapper.updateByPrimaryKey(order);
        return update  != 0 ? 1 : 0;
    }

    @Override
    public int orderDelete(List<String> ids) {
        C_orderExample cOrderExample = new C_orderExample();
        C_orderExample.Criteria criteria = cOrderExample.createCriteria();
        criteria.andCustomIdIn(ids);
        int delete = cOrderMapper.deleteByExample(cOrderExample);
        return delete  != 0 ? 1 : 0;
    }

    @Override
    public List<C_order> searchByOrderId(String id, int page, int rows) {
        C_orderExample cOrderExample = new C_orderExample();
        C_orderExample.Criteria criteria = cOrderExample.createCriteria();
        criteria.andOrderIdLike("%" + id + "%");
        List<C_order> cOrders = cOrderMapper.selectByExample(cOrderExample);
        return cOrders;
    }

    @Override
    public List<C_order> searchByOrderCustom(String custom, int page, int rows) {
        // c_order left join custom
        return null;
    }

    @Override
    public List<C_order> searchByOrderProduct(String product, int page, int rows) {
        // c_order  left join product
        return null;
    }
}

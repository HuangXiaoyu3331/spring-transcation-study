package com.hxy.springtranscation.service.impl;

import com.hxy.springtranscation.model.Table2Model;
import com.hxy.springtranscation.mapper.Table2Mapper;
import com.hxy.springtranscation.service.Table2Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author huangxy
 * @since 2020-08-26
 */
@Service
public class Table2ServiceImpl extends ServiceImpl<Table2Mapper, Table2Model> implements Table2Service {

    @Autowired
    private Table2Mapper table2Mapper;

    @Override
    public void require(Table2Model model) {
        table2Mapper.insert(model);
//        throw new RuntimeException("propagation require children exception");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requireNew(Table2Model model) {
        table2Mapper.insert(model);
        throw new RuntimeException("propagation require new children exception");
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void nested(Table2Model model) {
        table2Mapper.insert(model);
//        throw new RuntimeException("propagation nested children exception");
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void supports(Table2Model model) {
        table2Mapper.insert(model);
        throw new RuntimeException("propagation support children exception");
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupport(Table2Model model) {
        table2Mapper.insert(model);
        throw new RuntimeException("propagation not support exception");
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void mandatory(Table2Model model) {
        table2Mapper.insert(model);
        throw new RuntimeException("propagation mandatory exception");
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void never(Table2Model model) {
        table2Mapper.insert(model);
    }
}

package com.hxy.springtranscation.service.impl;

import com.hxy.springtranscation.model.Table1Model;
import com.hxy.springtranscation.mapper.Table1Mapper;
import com.hxy.springtranscation.model.Table2Model;
import com.hxy.springtranscation.service.Table1Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxy.springtranscation.service.Table2Service;
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
public class Table1ServiceImpl extends ServiceImpl<Table1Mapper, Table1Model> implements Table1Service {

    @Autowired
    private Table2Service table2Service;
    @Autowired
    private Table1Mapper table1Mapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void require() {
        table1Mapper.insert(new Table1Model().setName("require"));
        table2Service.require(new Table2Model().setName("require"));
        throw new RuntimeException("propagation require parent exception");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void requireNew() {
        table1Mapper.insert(new Table1Model().setName("require new"));
        try {
            table2Service.requireNew(new Table2Model().setName("require new"));
        } catch (Exception e) {
            log.error("子事务异常");
        }
//        throw new RuntimeException("propagation requireNew parent exception");
    }

    @Override
    @Transactional
    public void nested() {
        table1Mapper.insert(new Table1Model().setName("nested"));
        table2Service.nested(new Table2Model().setName("nested"));
//        throw new RuntimeException("propagation nested children exception");
    }

    @Override
//    @Transactional
    public void supports() {
        table1Mapper.insert(new Table1Model().setName("support"));
        table2Service.supports(new Table2Model().setName("support"));
    }

    @Override
    @Transactional
    public void notsupport() {
        table1Mapper.insert(new Table1Model().setName("not support"));
        table2Service.notSupport(new Table2Model().setName("not support"));
    }

    @Override
    @Transactional
    public void mandatory() {
        table1Mapper.insert(new Table1Model().setName("mandatory"));
        table2Service.mandatory(new Table2Model().setName("mandatory"));
    }

    @Override
    @Transactional
    public void never() {
        table1Mapper.insert(new Table1Model().setName("never"));
        table2Service.never(new Table2Model().setName("never"));
    }
}

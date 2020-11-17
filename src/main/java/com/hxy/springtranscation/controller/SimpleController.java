package com.hxy.springtranscation.controller;

import com.hxy.springtranscation.service.Table1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangxy
 * @date 2020/08/26 17:43:01
 */
@RestController
@RequestMapping("/propagation")
public class SimpleController {

    @Autowired
    private Table1Service table1Service;

    /**
     * 事务隔离级别：require
     * 支持当前事务，如果当前没有事务，则新建事务
     * 如果当前存在事务，则加入当前事务，合并成一个事务
     */
    @GetMapping("/require")
    public String require() {
        table1Service.require();
        return "success";
    }

    /**
     * 事务隔离级别：require_new
     * 新建事务，如果当前存在事务，则把当前事务挂起
     * 这个方法会独立提交事务，不受调用者的事务影响，父级异常，他也正确提交
     * 子事务异常，如果被父事务catch，父事务可以正常提交
     */
    @GetMapping("requireNew")
    public String requireNew() {
        table1Service.requireNew();
        return "success";
    }

    /**
     * 事务隔离级别：nested
     * 如果当前存在事务，他将会成为父级事务的一个子事务，方法结束后并没有提交，只有等父事务结束才提交
     * 如果当前没有事务，则新建事务
     * 如果子事务异常，父级可以捕获它的异常而父级事务不进行回滚，父级事务正常提交
     * 如果父级异常，子事务必须回滚，这是与 require_new 的区别
     */
    @GetMapping("/nested")
    public String nested() {
        table1Service.nested();
        return "success";
    }

    /**
     * 事务隔离级别：supports
     * 如果当前存在事务，则加入事务
     * 如果当前不存在事务，则以非事务运行
     */
    @GetMapping("/supports")
    public String supports() {
        table1Service.supports();
        return "success";
    }

    /**
     * 事务隔离级别：not_support
     * 以非事务的方式运行
     * 如果当前存在事务，则把当前事务挂起
     */
    @GetMapping("/not_support")
    public String notSupport() {
        table1Service.notsupport();
        return "success";
    }

    /**
     * 事务隔离级别：mandatory
     * 如果当前存在事务，则运行在当前事务中
     * 如果当前不存在事务，则抛出异常，也即父方法必须要有事务
     */
    @GetMapping("/mandatory")
    public String mandatory() {
        table1Service.mandatory();
        return "success";
    }

    /**
     * 以非事务的方式运行，如果当前存在事务，则抛出异常，则父级方法必须无事务
     */
    @GetMapping("/never")
    public String never() {
        table1Service.never();
        return "success";
    }

}

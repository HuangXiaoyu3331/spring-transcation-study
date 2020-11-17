package com.hxy.springtranscation.service;

import com.hxy.springtranscation.model.Table1Model;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangxy
 * @since 2020-08-26
 */
public interface Table1Service extends IService<Table1Model> {

    void require();

    void requireNew();

    void nested();

    void supports();

    void notsupport();

    void mandatory();

    void never();
}

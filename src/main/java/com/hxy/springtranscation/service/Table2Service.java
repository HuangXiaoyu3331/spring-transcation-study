package com.hxy.springtranscation.service;

import com.hxy.springtranscation.model.Table2Model;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author huangxy
 * @since 2020-08-26
 */
public interface Table2Service extends IService<Table2Model> {

    void require(Table2Model model);

    void requireNew(Table2Model model);

    void nested(Table2Model model);

    void supports(Table2Model model);

    void notSupport(Table2Model model);

    void mandatory(Table2Model model);

    void never(Table2Model model);
}

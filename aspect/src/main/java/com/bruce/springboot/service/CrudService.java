package com.bruce.springboot.service;

import com.bruce.springboot.annotation.LogAnnotation;
import com.bruce.springboot.annotation.MarkAnnotation;
import com.bruce.springboot.annotation.PerformanceAnnotation;
import com.bruce.springboot.bean.CrudBean;
import com.bruce.springboot.bean.CrudResult;
import org.springframework.stereotype.Service;

/**
 * Created by bruce on 2019/1/31.
 */
@Service
@MarkAnnotation
public class CrudService {

    @LogAnnotation
    @PerformanceAnnotation
    public CrudResult get(CrudBean bean) {
        CrudResult result = new CrudResult();
        result.setSuccess(true);
        result.setResult( "" + bean.getQuery());
        return result;
    }
}

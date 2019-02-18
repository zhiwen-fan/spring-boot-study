package com.bruce.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by bruce on 2019/1/31.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrudBean {
    private Long id;
    private String query;
}

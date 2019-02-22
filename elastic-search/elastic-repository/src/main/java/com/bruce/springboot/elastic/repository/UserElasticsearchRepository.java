package com.bruce.springboot.elastic.repository;

import com.bruce.springboot.elastic.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by bruce on 2019/2/22.
 */
public interface UserElasticsearchRepository extends ElasticsearchRepository<User,Long> {

    User findById(Long id);

    List<User> findByName(String name);

    List<User> findByAddressProvince(String province);
}

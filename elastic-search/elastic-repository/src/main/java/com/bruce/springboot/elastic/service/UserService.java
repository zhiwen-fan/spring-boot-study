package com.bruce.springboot.elastic.service;

import com.bruce.springboot.elastic.domain.User;
import com.bruce.springboot.elastic.repository.UserElasticsearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by bruce on 2019/2/22.
 */
@Component
public class UserService {

    @Autowired
    private UserElasticsearchRepository userElasticsearchRepository;

    public void index(User user) {
        User index = userElasticsearchRepository.index(user);
    }

    public User findById(Long id) {
        User user = userElasticsearchRepository.findById(id);
        return user;
    }

    public List<User> findByName(String name) {
        return userElasticsearchRepository.findByName(name);
    }
    public List<User> findByProvince(String province) {
        return userElasticsearchRepository.findByAddressProvince(province);
    }
}

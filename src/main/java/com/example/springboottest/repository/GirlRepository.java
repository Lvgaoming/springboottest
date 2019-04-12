package com.example.springboottest.repository;

import com.example.springboottest.domain.Girl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * @author lgm
 * @date 2018/10/9 13:40
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //通过年龄查询
    public List<Girl> findByAge(Integer age);
    public List<Girl> findAll(Specification<Girl> specification);
}

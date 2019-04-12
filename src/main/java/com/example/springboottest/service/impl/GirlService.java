package com.example.springboottest.service.impl;

import com.example.springboottest.Exception.GirlException;
import com.example.springboottest.domain.Girl;
import com.example.springboottest.enums.ResultEnum;
import com.example.springboottest.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


/**
 * @author lgm
 * @date 2018/10/9 16:07
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){

        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(25);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBBBBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);



    }


    public void getAge(Integer id) throws Exception {
        Optional<Girl> girl = girlRepository.findById(id);
        Integer age = girl.get().getAge();
        if(age <10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }
        if(age>10 && age<16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 单表多条件查询
     * @param girl
     * @return
     */

    public List<Girl> findAll(Girl girl) {
        List<Girl> list = girlRepository
                .findAll((Root<Girl> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
                    List<Predicate> predicates = new ArrayList<Predicate>();
                    if (girl.getCupSize() != null && !girl.getCupSize().equals("")){
                        predicates.add(cb.like(root.get("cupSize").as(String.class), "%"+girl.getCupSize() + "%"));
                    }

                    if(girl.getAge() !=null && !girl.getAge().equals("")){
                        predicates.add(cb.like(root.get("age").as(String.class), "%"+girl.getAge() + "%"));
                    }

                    return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
                });
        return list;



    }



}

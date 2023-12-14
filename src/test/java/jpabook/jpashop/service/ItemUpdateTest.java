package jpabook.jpashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;

@SpringBootTest
public class ItemUpdateTest {
    
    @Autowired
    EntityManager em;

}

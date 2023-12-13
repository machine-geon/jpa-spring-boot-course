package jpabook.jpashop.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OrderSearch {
    private String memberName; // 회원 이름
    private OrderStatus orderStatus;// 주문 상태[ORDER, CANCEL]
}
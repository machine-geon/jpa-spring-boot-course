package jpabook.jpashop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;

/**
 * JUnit5: @RunWith(SpringRunner.class) => @ExtendWith(SpringExtension.class)
 * `@SpringBootTest`에 @ExtendWith이 적용이 되어 있기 때문에 생략
 */
// @RunWith(SpringRunner.class) // junit4
@SpringBootTest
@Transactional // Testcase에서는 @Transactional을 사용하면 테스트가 끝나고 롤백을 해준다.
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    // @Rollback(false) // @Rollback(false)를 사용하면 테스트가 끝나고 DB에 반영이 된다.
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long savedId = memberService.join(member);

        // then
        em.flush(); // insert query를 보고 싶을 때 사용, @Rollback을 설정하면 rollback이 된다.
        assertEquals(member, memberRepository.findOne(savedId));

    }

    @Test
    // @Test(expected = IllegalStateException.class) // junit4
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // when
        memberService.join(member1);
        
        // then
        // junit5
        assertThrows(IllegalStateException.class, () -> memberService.join(member2), "예외 발생");
        
        // junit4
        /**
        try {
            memberService.join(member2); // 예외 발생
        } catch (IllegalStateException e) {
            return;
        }
        
        fail("예외 발생");
        */
    }

}

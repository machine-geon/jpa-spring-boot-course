package jpabook.jpashop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.repository.MemberRepository;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    void testFind() {
        // // given
        // Member member = new Member();
        // member.setUsername("memberA");

        // // when
        // Long savedId = memberRepository.save(member);
        // Member findMember = memberRepository.find(savedId);

        // // then
        // Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        // Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        // Assertions.assertThat(findMember).isEqualTo(member);
        // System.out.println("findMember == member: " + (findMember == member));
    }

    @Test
    void testSave() {
        // given

        // when

        // then

    }
}

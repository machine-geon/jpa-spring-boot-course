package jpabook.jpashop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true) // spring framework의 transactional을 사용하자.
@RequiredArgsConstructor // final이 있는 필드만 가지고 생성자를 만들어준다.
public class MemberService {

    // @Autowired
    private final MemberRepository memberRepository;

    /**
     * constructor injection
     * = @AllArgsConstructor
     * @param memberRepository
     */
    // @Autowired // 생성자가 하나일 경우, @Autowired 생략 가능
    // public MemberService(MemberRepository memberRepository) {
    //     this.memberRepository = memberRepository;
    // }

    /**
     * setter injection
     * - 장점: test에 용이하다.
     * - 단점: 누군가가 memberRepository를 바꿀 수 있다.
     * @param memberRepository
     */
    // @Autowired
    // public void setMemberRepository(MemberRepository memberRepository) {
    //     this.memberRepository = memberRepository;
    // }

    /**
     * 회원 가입
     * 
     * @return
     */
    @Transactional// default: readOnly = false
    public Long join(Member member) {
        validateDuplicatedMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());

        // 최적화
        // if (findMembers.size() != 0) {
        // throw new IllegalStateException("이미 존재하는 회원입니다.");
        // }

        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 전체 회원 조회
     * 
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 조회
     * 
     * @return
     */
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}

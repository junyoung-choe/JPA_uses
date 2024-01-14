package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
// JPA 는 트랜잭션이 꼭 있어야 한다 !
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    // final 쓰면은 연결 안해주면 오류 나와주고 ! 생성자 주입으로 Lombok 으로 깔끔해진다(RequiredArgsConstructor) !
    private final MemberRepository memberRepository;


    // 회원 가입
    @Transactional
    public Long join(Member member) {
        // 중복 회원 검증 (비즈니스 로직)
        validateDuplicateMember(member);
        // 사실 이 부분에서 이미 들어가는게 먼저 실행이 될수도 있어 ! -> 실무에서는 DB 에 유티크 조건을 걸어 두는것이 더 좋겠다 !
        memberRepository.save(member); // 여기서의 persistence 한다면 PK 는 만들어서 가지고 있는다 (commit 플러시 하지 않아도 ! )
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 중복이면 Exception

        List<Member> findMembers = memberRepository.findByName(member.getName());

        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}

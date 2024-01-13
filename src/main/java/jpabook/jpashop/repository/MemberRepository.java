package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext // 스프링이 해당 어노테이션을 보고 엔티티 매니저를 주입해준다 (라이브러리의 jpa 가 yml 파일의 정보를 기반으로 실행하고 어노테이션 까지 본다 ! )
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}

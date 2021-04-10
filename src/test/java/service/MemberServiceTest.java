package service;

import domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MemoryMemberRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
       memberRepository.clearStore();
    }

    @Test
    void joinTest() {
        //given
        Member member = new Member();
        member.setName("jee");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember  = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void no_dual_mem(){
        //give
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setName("jee");
        member2.setName("jee");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        try {
//            memberService.join(member2);
//            System.out.println("가입해봐여");
//        }catch(IllegalStateException ex){
//            System.out.println("캐치에여");
//            assertThat(ex.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        }
        
        //then
       
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
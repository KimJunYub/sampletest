package sample.test.sampletest.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.test.sampletest.domain.Member;
import sample.test.sampletest.repository.MemoryMenberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


class MemberServiceTest {

    MemberService memberService;
    MemoryMenberRepository repository;

    @BeforeEach
    public void beforeEach(){
        repository  = new MemoryMenberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    /**
     * 회원가입
     */
    @Test
    void join() {

//        //given
//        Member member = new Member();
//        member.setName("hh");
//        //when
//        String saveId = memberService.join(member);
//        //then
//        Member findMember = memberService.findOne(saveId).get();
//        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

        //given2222
        Member member1 = new Member();
        member1.setName("hh1");
        Member member2 = new Member();
        member2.setName("hh1");
        //when
//        방법1
//        try {
//            memberService.join(member1);
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            System.out.println(e);
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

//      방법2
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
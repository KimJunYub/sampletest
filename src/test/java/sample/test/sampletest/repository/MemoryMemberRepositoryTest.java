package sample.test.sampletest.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.test.sampletest.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMenberRepository repository = new MemoryMenberRepository();


    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public  void save(){
        Member member = new Member();

        member.setId("1");
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(member,result);

        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByNeme("Spring1").get();
 
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}

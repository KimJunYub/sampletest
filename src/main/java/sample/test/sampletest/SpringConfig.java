package sample.test.sampletest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sample.test.sampletest.repository.*;
import sample.test.sampletest.service.MemberService;

@Configuration
public class SpringConfig {

//    private final DataSource dataSource;
//    @PersistenceContext
//    private EntityManager em;

//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    /*private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }*/

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMenberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JDBCTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//    }
//

}

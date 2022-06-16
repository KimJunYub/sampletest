package sample.test.sampletest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.test.sampletest.domain.Member;
import sample.test.sampletest.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입
     * @param member
     * @return
     */
    public String join(Member member) {
        //같은 이름이 있는 중복 회원x
//        Optional<Member> result = memberRepository.findByNeme(member.getName());
//        result.get();
//        result.orElse();
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
//        validateDuplicateMember(member);// 중복회원 검증
        memberRepository.save(member);

        //System.out.println("member.getId() ::::::::: " + member.getId());

        return member.getId();
    }

    private void validateDuplicateMember(Member member) { //컨트롤 + 알트 + 시프트 + T
        memberRepository.findByNeme(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체조회
     * @return
     */
    public List<Member> findMembers (){
        return memberRepository.findAll();
    }

    /**
     * 한명조회
     * @param memberId
     * @return
     */
    public Optional<Member> findOne(String memberId) {
        return memberRepository.findById(memberId);
    }

}

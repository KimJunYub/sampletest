package sample.test.sampletest.repository;

import sample.test.sampletest.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(String id);
    Optional<Member> findByNeme(String name);
    List<Member> findAll();

}

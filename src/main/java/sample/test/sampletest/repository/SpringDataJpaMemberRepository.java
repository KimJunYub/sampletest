package sample.test.sampletest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.test.sampletest.domain.Member;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByNeme(String name);
//    @Override
//    Optional<Member> findById(String id);
//    @Override
//    List<Member> findAll();
}


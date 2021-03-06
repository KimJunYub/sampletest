package sample.test.sampletest.repository;

import org.springframework.stereotype.Repository;
import sample.test.sampletest.domain.Member;

import java.util.*;

//@Repository
public class MemoryMenberRepository implements MemberRepository {

    private static Map<String,Member> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(String.valueOf(++sequence));
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByNeme(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}

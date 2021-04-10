package ojm.hellospring.repository;

import domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("jeemin");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }
    
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("jeemin1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("jeemin2");
        repository.save(member2);

        Member result = repository.findByName("jeemin1").get();
        assertThat(result).isEqualTo(member1);
    }

}

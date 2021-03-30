package kr.co.shopwizard.dom;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class MantncRepositoryTest2 {
    @Autowired
    MantncRepository mantncRepository;

    @Test
    public void testSaveAndLoad() {
        //initialize
        mantncRepository.deleteAll();

        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "테스트 작성";

        mantncRepository.save(Mantnc.builder()
                .reciptTitle(title)
                .reciptCntnts(content)
                .reciptName(author)
        .build());

        //when
        List<Mantnc> mantncList = mantncRepository.findAll();

        //then
        Mantnc mantnc = mantncList.get(0);
        assertThat(mantnc.getReciptTitle()).isEqualTo(title);
        assertThat(mantnc.getReciptCntnts()).isEqualTo(content);

    }

    @Test
    public void testSaveBaseTime() {
        //initialize
        mantncRepository.deleteAll();

        //given
        LocalDateTime now = LocalDateTime.of(2021,3,23,11,29,0);
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "테스트 작성";

        mantncRepository.save(Mantnc.builder()
                .reciptTitle(title)
                .reciptCntnts(content)
                .reciptName(author)
                .build());

        //when
        List<Mantnc> mantncList = mantncRepository.findAll();

        //then
        Mantnc mantnc = mantncList.get(0);
        System.out.println(">>>>>>>>>> registDate="+mantnc.getRegistDate());
        System.out.println(">>>>>>>>>> changeDate="+mantnc.getChangeDate());
        assertThat(mantnc.getRegistDate()).isAfter(now);
        assertThat(mantnc.getChangeDate()).isAfter(now);

    }
}

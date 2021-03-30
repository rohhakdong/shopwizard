package kr.co.shopwizard.web;

import kr.co.shopwizard.dom.Mantnc;
import kr.co.shopwizard.dom.MantncRepository;
import kr.co.shopwizard.web.dto.MantncSaveRequestDto;
import kr.co.shopwizard.web.dto.MantncUpdateRequestDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MantncControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MantncRepository mantncRepository;

    @Test
    public void saveTest() throws Exception {

        //initialize
        mantncRepository.deleteAll();

        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "테스트 작성";

        MantncSaveRequestDto requestDto = MantncSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        String url = "http://localhost:" + port + "/mantnc";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Mantnc> all = mantncRepository.findAll();
        assertThat(all.get(0).getReciptTitle()).isEqualTo(title);
        assertThat(all.get(0).getReciptCntnts()).isEqualTo(content);
    }

    @Test
    public void updateTest() throws Exception {
        //initialize
        mantncRepository.deleteAll();

        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "테스트 작성";

        Mantnc savedMantnc = mantncRepository.save(Mantnc.builder()
                .reciptTitle(title)
                .reciptCntnts(content)
                .reciptName(author)
                .build());

        Long updateId = savedMantnc.getMantncNo();
        String updateTitle = "테스트 게시글 수정";
        String updateContent = "테스트 본문 수정";

        MantncUpdateRequestDto requestDto = MantncUpdateRequestDto.builder()
                .title(updateTitle)
                .content(updateContent)
                .build();

        String url = "http://localhost:" + port + "/mantnc/" + updateId;

        HttpEntity<MantncUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Mantnc> all = mantncRepository.findAll();
        assertThat(all.get(0).getReciptTitle()).isEqualTo(updateTitle);
        assertThat(all.get(0).getReciptCntnts()).isEqualTo(updateContent);
    }
}

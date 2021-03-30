package kr.co.shopwizard.web;

import kr.co.shopwizard.web.dto.SampleResponseDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleResponseDtoTest {
    @Test
    public void lombokTest() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        SampleResponseDto dto = new SampleResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

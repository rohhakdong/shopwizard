package kr.co.shopwizard.web.dto;

import kr.co.shopwizard.dom.Mantnc;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MantncUpdateRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public MantncUpdateRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

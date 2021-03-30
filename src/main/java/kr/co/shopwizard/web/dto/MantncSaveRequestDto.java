package kr.co.shopwizard.web.dto;

import kr.co.shopwizard.dom.Mantnc;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MantncSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public MantncSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Mantnc toEntity() {
        return Mantnc.builder()
                .reciptTitle(title)
                .reciptCntnts(content)
                .reciptName(author)
                .build();
    }
}

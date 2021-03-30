package kr.co.shopwizard.web.dto;

import kr.co.shopwizard.dom.Mantnc;
import lombok.Getter;

@Getter
public class MantncResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public MantncResponseDto(Mantnc mantnc) {
        this.id = mantnc.getMantncNo();
        this.title = mantnc.getReciptTitle();
        this.content = mantnc.getReciptCntnts();
        this.author = mantnc.getReciptName();
    }
}

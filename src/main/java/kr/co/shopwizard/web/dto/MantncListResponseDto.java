package kr.co.shopwizard.web.dto;

import kr.co.shopwizard.dom.Mantnc;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MantncListResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;

    public MantncListResponseDto(Mantnc mantnc) {
        this.id = mantnc.getMantncNo();
        this.title = mantnc.getReciptTitle();
        this.content = mantnc.getReciptCntnts();
        this.author = mantnc.getReciptName();
        this.modifiedDate = mantnc.getChangeDate();
    }
}

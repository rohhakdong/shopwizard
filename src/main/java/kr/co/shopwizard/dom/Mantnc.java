package kr.co.shopwizard.dom;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tOprMantnc")
public class Mantnc extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mantncNo;

    @Column(length = 50, nullable = false)
    private String reciptName;

    @Column(length = 255, nullable = false)
    private String reciptTitle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String reciptCntnts;

    public Mantnc(String reciptName, String reciptTitle, String reciptCntnts) {
       this.reciptName = reciptName;
       this.reciptTitle = reciptTitle;
       this.reciptCntnts = reciptCntnts;
    }

    public void update(String title, String content) {
        this.reciptTitle = title;
        this.reciptCntnts = content;
    }
}

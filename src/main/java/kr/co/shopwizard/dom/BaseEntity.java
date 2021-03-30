package kr.co.shopwizard.dom;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @CreatedDate
    private LocalDateTime registDate;
    @LastModifiedDate
    private LocalDateTime changeDate;

    //TO DO
    private String registName;
    private String registId;
    private String changeName;
    private String changeId;
    private int state;
    private String remark;
}

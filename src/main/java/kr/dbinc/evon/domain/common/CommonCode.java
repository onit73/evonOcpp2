package kr.dbinc.evon.domain.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "db_com_code")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonCode {

    @Id
    @Column(name = "code_key")
    private String id;

    @Column(name = "p_code")
    private String parentCode;

    @Column(name = "data")
    private String data;

    @Column(name = "commant")
    private String comment;

}

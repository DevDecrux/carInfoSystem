package com.tu.carinfocore.persistance.entities;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
@Table(name = "codes")
public class CodesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "code", nullable = false)
    private String code;
    @Basic
    @Column(name = "descCode", nullable = false)
    private String descCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "descCode", nullable = false)
    public String getDescCode() {
        return descCode;
    }

    public void setDescCode(String descCode) {
        this.descCode = descCode;
    }
}

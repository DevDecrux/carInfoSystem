package com.tu.carinfocore.persistance.entities;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
@Table(name = "meteoinfo")
public class MeteoInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "temperature", nullable = false)
    private String temperature;
    @Basic
    @Column(name = "humidity", nullable = false)
    private String humidity;
    @Basic
    @Column(name = "eco2", nullable = false)
    private String eco2;
    @Basic
    @Column(name = "tvoc", nullable = false)
    private String tvoc;
    @Basic
    @Column(name = "m_sys_date", nullable = false)
    private String date;
    @Basic
    @Column(name = "m_sys_hours", nullable = false)
    private String hours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getEco2() {
        return eco2;
    }

    public void setEco2(String eco2) {
        this.eco2 = eco2;
    }

    public String getTvoc() {
        return tvoc;
    }

    public void setTvoc(String tvoc) {
        this.tvoc = tvoc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}

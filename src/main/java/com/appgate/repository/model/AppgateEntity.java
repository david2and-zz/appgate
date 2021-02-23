package com.appgate.repository.model;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigInteger;

@Entity(name = "appgate")
@Getter
public class AppgateEntity {

    public AppgateEntity(String ip_front, String ip_to, String country_code, String country, String region, String city, String latitude, String longitude, String timezone) {
        this.ip_front = ip_front;
        this.ip_to = ip_to;
        this.country_code = country_code;
        this.country = country;
        this.region = region;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ip_front")
    private String ip_front;

    @Column(name = "ip_to")
    private String ip_to;

    @Column(name = "country_code")
    private String country_code;

    @Column(name = "country")
    private String country;

    @Column(name = "region")
    private String region;

    @Column(name = "city")
    private String city;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "timezone")
    private String timezone;

}




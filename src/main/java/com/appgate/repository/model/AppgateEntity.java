package com.appgate.repository.model;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity(name = "appgate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppgateEntity {
    @Id
    @Column(name = "id")
    private String id;

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
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "decimal_value")
    private BigInteger decimal_value;
}




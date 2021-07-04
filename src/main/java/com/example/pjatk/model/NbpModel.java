package com.example.pjatk.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "response")
public class NbpModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id of the record", required = true, value = "id", example = "1")
    private Long id;
    @ApiModelProperty(notes = "Currency of NbpResponse", required = true, value = "currency", example = "EUR")
    private String currency;
    @ApiModelProperty(notes = "This is date and time of a request", required = true, value = "date_from", example = "2021-05-25")
    @Column(name="date_from")
    private String dateFrom;
    @ApiModelProperty(notes = "This is date and time of a request", required = true, value = "date_to", example = "2021-05-26")
    @Column(name="date_to")
    private String dateTo;
    @ApiModelProperty(notes = "This is value for given currency", required = true, value = "exchange_rate", example = "4,54")
    @Column(name="exchange_rate")
    private float exchangeRate;
    @ApiModelProperty(notes = "This is date and time of a request", required = true, value = "request_time", example = "2021-05-25 20:15:55")
    @Column(name="request_time")
    private Timestamp requestTime;

    public NbpModel() {
    }

    public NbpModel(Long id, String currency, String dateFrom, String dateTo, float exchangeRate, Timestamp requestTime) {
        this.id = id;
        this.currency = currency;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.exchangeRate = exchangeRate;
        this.requestTime = requestTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String date_from) {
        this.dateFrom = date_from;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String date_to) {
        this.dateTo = date_to;
    }

    public float getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(float exchange_rate) {
        this.exchangeRate = exchange_rate;
    }

    public Timestamp getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Timestamp request_time) {
        this.requestTime = request_time;
    }
}

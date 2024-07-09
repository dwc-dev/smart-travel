package com.ruoyi.travel.test.domain;

import java.util.List;

public class TestScenic {
    private Integer scenicId;
    private String name;
    private String province;
    private String city;
    private String district;
//    private String description;
//    private String imageUrl;
//    private Date createTime;
    private List<TestTicket> tickets;

    public Integer getScenicId() {
        return scenicId;
    }

    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TestTicket> getTickets() {
        return tickets;
    }

    public void setTickets(List<TestTicket> tickets) {
        this.tickets = tickets;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}

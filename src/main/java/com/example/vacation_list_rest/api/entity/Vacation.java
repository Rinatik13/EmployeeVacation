package com.example.vacation_list_rest.api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private int userId;

    @Enumerated(EnumType.STRING)
    private VacationType type;
//    @NotEmpty
//    private String type;
    @NotEmpty
    private String dateFrom;
    @NotEmpty
    private String dateTo;

    public Vacation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public VacationType getType() {
        return type;
    }

    public void setType(VacationType type) {
        this.type = type;
    }
}

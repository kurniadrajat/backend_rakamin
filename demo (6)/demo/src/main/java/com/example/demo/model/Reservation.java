package com.example.demo.model;

import java.time.LocalDateTime;

public class Reservation {

    private Long id;

    private String customerName;

    private LocalDateTime reservationTime;

    //konstruktor tanpa argumen
    public Reservation() {
    }

    //konstruktor dengan semua argumen
    public Reservation (Long id, String customerName, LocalDateTime reservationTime) {
        this.id = id;
        this.customerName = customerName;
        this.reservationTime = reservationTime;
    }

    //getter dan setter untuk 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //getter dan setter untuk 'customerName'
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    //getter dan setter untuk 'reservationtime'
    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", customer Name='" + customerName + '\'' +
                ", reservationTime=" + reservationTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this ==o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}

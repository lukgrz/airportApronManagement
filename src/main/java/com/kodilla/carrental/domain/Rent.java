package com.kodilla.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "rents")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rent {

    @Id
    @GeneratedValue
    private Long id;

    private Date rentDate;

    private Date returnDate;

    @OneToMany(
            targetEntity = Equipment.class,
            fetch = FetchType.EAGER
    )
    private List<Equipment> equipmentList;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    private Price totalPrice;

    public static class RentBuilder {
        private Long id;
        private Date rentDate;
        private Date returnDate;
        private List<Equipment> equipmentList;
        private Car car;
        private Client client;
        private Price totalPrice;

        public RentBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RentBuilder rentDate(Date rentDate) {
            this.rentDate = rentDate;
            return this;
        }

        public RentBuilder returnDate(Date returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public RentBuilder equipment(Equipment equipment) {
            equipmentList.add(equipment);
            return this;
        }

        public RentBuilder car(Car car) {
            this.car = car;
            return this;
        }

        public RentBuilder client(Client client) {
            this.client = client;
            return this;
        }

        public RentBuilder totalPrice(Price totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Rent build() {
            return new Rent(id,rentDate,returnDate,equipmentList,car,client,totalPrice);
        }
    }
}

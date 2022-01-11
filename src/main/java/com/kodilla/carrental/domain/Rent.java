package com.kodilla.carrental.domain;

import com.kodilla.carrental.service.RateService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity(name = "rents")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rent {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate rentDate;
    private LocalDate returnDate;

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

    public long numberOfDaysForRent() {
        return DAYS.between(rentDate, returnDate) + 1;
    }

    private BigDecimal calculateTotalPriceForCar() {
        BigDecimal carStartingPrice = car.getStartingPrice().getPriceInPln();
        BigDecimal carPricePerDays = car.getPricePerDay().getPriceInPln().multiply(BigDecimal.valueOf(numberOfDaysForRent()));
        return carStartingPrice.add(carPricePerDays);
    }

    private BigDecimal calculateTotalPriceForEquipment() {
        return equipmentList.stream()
                .map(equipment -> equipment.getPricePerDay().getPriceInPln().multiply(BigDecimal.valueOf(numberOfDaysForRent())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public void calculateTotalPrice (RateService rateService) {
        Rate rate = rateService.fetchRates();
        BigDecimal totalPriceInPln = calculateTotalPriceForCar().add(calculateTotalPriceForEquipment());
        totalPrice.setPriceInPln(totalPriceInPln);
        totalPrice.calculatePriceInCurrency(rate);
    }

    public static class RentBuilder {
        private Long id;
        private LocalDate rentDate;
        private LocalDate returnDate;
        private List<Equipment> equipmentList;
        private Car car;
        private Client client;
        private Price totalPrice;

        public RentBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RentBuilder rentDate(LocalDate rentDate) {
            this.rentDate = rentDate;
            return this;
        }

        public RentBuilder returnDate(LocalDate returnDate) {
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
            return new Rent(id, rentDate, returnDate, equipmentList, car, client, totalPrice);
        }
    }
}

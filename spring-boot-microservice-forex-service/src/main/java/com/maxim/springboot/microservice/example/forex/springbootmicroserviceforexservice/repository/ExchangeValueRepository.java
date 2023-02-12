package com.maxim.springboot.microservice.example.forex.springbootmicroserviceforexservice.repository;

import com.maxim.springboot.microservice.example.forex.springbootmicroserviceforexservice.domain.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(String from, String to);

}

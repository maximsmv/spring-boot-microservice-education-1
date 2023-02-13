package com.maxim.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion.controller;

import com.maxim.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion.proxy.CurrencyExchangeServiceProxy;
import com.maxim.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion.entity.CurrencyConversionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
                                                       @PathVariable BigDecimal quantity) {
        CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
        logger.info("{}", response);
        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }

//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
//    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
//                                                  @PathVariable BigDecimal quantity) {
//        Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("from", from);
//        uriVariables.put("to", to);
//        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate()
//                .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
//        CurrencyConversionBean response = responseEntity.getBody();
//        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
//                quantity.multiply(response.getConversionMultiple()), response.getPort());
//    }
}

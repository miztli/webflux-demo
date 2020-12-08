package com.webflux.controllers;

import javax.annotation.Resource;

import com.webflux.models.BitcoinPrice;
import com.webflux.service.IBitcoinService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/bitcoin")
public class BitcoinController
{
    @Resource
    private IBitcoinService iBitcoinService;

    @GetMapping(value = "/prices", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<BitcoinPrice> streamPrices()
    {
        // Add log to trace events
        return iBitcoinService.streamBitcoinPrices()
            .log();
    }
}

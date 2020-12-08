package com.webflux.service;

import com.webflux.models.BitcoinPrice;
import reactor.core.publisher.Flux;

public interface IBitcoinService
{
    Flux<BitcoinPrice> streamBitcoinPrices();
}

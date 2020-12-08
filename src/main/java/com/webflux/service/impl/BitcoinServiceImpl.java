package com.webflux.service.impl;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

import com.webflux.models.BitcoinPrice;
import com.webflux.service.IBitcoinService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class BitcoinServiceImpl implements IBitcoinService
{
    private final Random random = new Random();

    private final Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));

    private final Flux<BitcoinPrice> bitcoinPrice =
        Flux.fromStream(Stream.generate(() ->
            BitcoinPrice.from(new Date(), BigDecimal.valueOf(random.nextDouble()).multiply(BigDecimal.valueOf(100)))));

    // trigger source immediately
    private final Flux<BitcoinPrice> bitcoinPriceStream = Flux.zip(interval, bitcoinPrice).map(tuple -> tuple.getT2())
        .share()
        .cache(5); // historical data

    /**
     * @return A continuous stream of {@link BitcoinPrice}
     */
    @Override
    public Flux<BitcoinPrice> streamBitcoinPrices()
    {
        return Flux.from(bitcoinPriceStream);
    }
}

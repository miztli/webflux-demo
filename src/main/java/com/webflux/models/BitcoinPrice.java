package com.webflux.models;

import java.math.BigDecimal;
import java.util.Date;

public class BitcoinPrice
{
    private Date date;

    private BigDecimal price;

    public BitcoinPrice(final Date date, final BigDecimal price)
    {
        this.date = date;
        this.price = price;
    }

    public static BitcoinPrice from(final Date date, final BigDecimal price)
    {
        return new BitcoinPrice(date, price);
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(final Date date)
    {
        this.date = date;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(final BigDecimal price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "BitcoinPrice{" +
            "date=" + date +
            ", price=" + price +
            '}';
    }
}

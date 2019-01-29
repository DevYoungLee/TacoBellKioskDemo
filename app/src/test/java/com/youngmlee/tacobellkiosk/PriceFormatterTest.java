package com.youngmlee.tacobellkiosk;

import com.youngmlee.tacobellkiosk.utils.PriceFormatter;

import static org.junit.Assert.*;
import org.junit.Test;

public class PriceFormatterTest {
    private PriceFormatter priceFormatter = PriceFormatter.getInstance();

    @Test
    public void priceFormatIsCorrect(){

        assertEquals("$1.00", priceFormatter.formatPrice(1.0));
        assertEquals("$0.00", priceFormatter.formatPrice(0));
        assertEquals("$13.99", priceFormatter.formatPrice(13.99));
        assertEquals("$14.00", priceFormatter.formatPrice(13.999));
        assertEquals("$13.99", priceFormatter.formatPrice(13.992));
        assertEquals("$100.00", priceFormatter.formatPrice(100.0));
    }

}

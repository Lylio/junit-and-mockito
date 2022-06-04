package com.lylechristine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    @Test
    void truncateAInFirst2Positions() {
        StringHelper helper = new StringHelper();
        String result1 = helper.truncateAInFirst2Positions("AABC");
        assertEquals("BC", result1);

        String result2 = helper.truncateAInFirst2Positions("DAAY");
        assertEquals("DAY", result2);

        String result3 = helper.truncateAInFirst2Positions("ZQWE");
        assertEquals("ZQWE", result3);

        String result4 = helper.truncateAInFirst2Positions("W");
        assertEquals("W", result4);
    }

    @Test
    void areFirstAndLastTwoCharactersTheSame() {
        StringHelper helper = new StringHelper();
        Boolean result1 = helper.areFirstAndLastTwoCharactersTheSame("YYNMYY");
        assertEquals(true, result1);
        
        Boolean result2 = helper.areFirstAndLastTwoCharactersTheSame("UNHGFTT");
        assertEquals(false, result2);
    }
}

package com.ShengQin.OneShot.Utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CronExpressionGeneratorTest {
    @Autowired
    CronExpressionGenerator cronExpressionGenerator;

    @Test
    void getCronExpression() {
        System.out.println(CronExpressionGenerator.getCronExpression(new Date()));
    }
}
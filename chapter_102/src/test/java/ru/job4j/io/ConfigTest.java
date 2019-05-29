package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    @Test
    public void testValue() {
        Config cfg = new Config("app.properties");
        cfg.load();
        assertThat(cfg.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
    }
}
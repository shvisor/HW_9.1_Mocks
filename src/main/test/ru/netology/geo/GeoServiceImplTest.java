package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class GeoServiceImplTest {
    GeoServiceImpl geoService = new GeoServiceImpl();

    @Test
    @DisplayName("Передаем Локальный IP")
    public void shouldLocalhostIp() {
        Location expected = new Location(null, null, null, 0);
        Location actual = geoService.byIp("127.0.0.1");
        assertThat(actual, samePropertyValuesAs(expected));
    }

    @Test
    @DisplayName("Передаем московский IP")
    public void shouldMoscowIp() {
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location actual = geoService.byIp("172.0.32.11");
        assertThat(actual, samePropertyValuesAs(expected));
    }

    @Test
    @DisplayName("Передаем Нью-Йоркский IP")
    public void shouldNewYorkIp() {
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location actual = geoService.byIp("96.44.183.149");
        assertThat(actual, samePropertyValuesAs(expected));
    }

    @Test
    @DisplayName("Передаем российский IP")
    public void shouldRussianIp() {
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);
        Location actual = geoService.byIp("172.123.12.19");
        assertThat(actual, samePropertyValuesAs(expected));
    }

    @Test
    @DisplayName("Передаем американский IP")
    public void shouldamericanIp() {
        Location expected = new Location("New York", Country.USA, null, 0);
        Location actual = geoService.byIp("96.123.12.19");
        assertThat(actual, samePropertyValuesAs(expected));
    }
}

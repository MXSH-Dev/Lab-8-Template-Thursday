package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
// change this to fail on purpose
//        real expected = 1, change to 0 for lab 8 purpose
        assertEquals(1, cityList.countCities());

        cityList.add(new City("Regina", "Saskatchewan"));
// expected 2, change to 1 to fail the test
        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(new City("Regina", "Saskatchewan")));

        cityList.add(new City("Brandon", "Manitoba"));
// expected 2, change to 1 to fail the test
        assertEquals(3, cityList.countCities());
        assertTrue(cityList.hasCity(new City("Brandon", "Manitoba")));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();

        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();

        City city = new City("Victoria", "British Columbia");
        cityList.add(city);

        assertEquals(2, cityList.countCities());

        cityList.delete(mockCity());

        assertEquals(1, cityList.countCities());
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();

        cityList.delete(mockCity());

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(mockCity());
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());
    }
}
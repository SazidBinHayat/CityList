package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City c1 = new City("Regina", "SK");
        City c2 = new City("R", "K");
        City c3 = new City("e", "S");
        cityList.add(c1);
        cityList.add(c2);
        cityList.add(c3);

        cityList.delete(c2);

        assertEquals(3, cityList.getCities().size());
        assertFalse(cityList.getCities().contains(c2));
    }


    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City c1 = new City("Regina", "SK");
        City c2 = new City("R", "K");
        cityList.add(c1);
        cityList.add(c2);

        cityList.delete(c1);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(c1);
        });
    }

}

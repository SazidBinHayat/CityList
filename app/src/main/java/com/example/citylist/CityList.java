package com.example.citylist;

import androidx.core.widget.TextViewCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This function returns sorted list according to city and province
     * @param sortType
     *
     * @return
     * returns sorted list
     */
    public List<City> getCities(int sortType) {
        List<City> cityList = cities;
        if(sortType==1) {
            Collections.sort(cityList);
        }

        else if (sortType==2)
        {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }


        return cityList;
    }



    /**
     * This deletes a city to the list if that city does not exist
     * @param city
     *      This is the city to delete
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * counts city number
     * @return
     * total  no of cities
     */


    public int countCity()
    {
        return cities.size();

    }


}

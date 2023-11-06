package com.example.forbeslist;

public class Person {
    private String name;
    private String countryFlag; //имя ресурса изображения флага (например, "flag_russia")
    private String wealth;

    public Person(String name, String countryFlag, String wealth) {
        this.name = name;//получаем имя миллиардера("Илон Маск")
        this.countryFlag = countryFlag;//получаем имя ресурса флага ("flag_united_states")
        this.wealth = wealth;//получаем состояние миллиарда("$219 В")
    }

    public String getName() {
        return name;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public String getWealth() {
        return wealth;
    }
}


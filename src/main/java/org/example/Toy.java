package org.example;

public class Toy implements Comparable<Toy>{


    int id;

    String name; // тип игрушки

    int quantity; // количество всего

    int frequency; // частота выпадения игрушки

    public Toy() { // коструктор по умолчанию
    }

    public Toy(int id, String name, int quantity, int frequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }


    @Override
        public int compareTo(Toy o) {
        return Integer.compare(o.quantity, this.quantity); // Сортировка по убыванию количества
    }

}


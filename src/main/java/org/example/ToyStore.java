package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyStore {


    // Создание приоритетной очереди с элементами типа Toy
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>();



    public void put(int id, String name, int quantity, int frequency){
        // Создаем тип игрушки и добавляем в класс PriorityQueue в виде объектов
        Toy toy = new Toy(id, name, quantity, frequency);
        toyQueue.offer(toy);
    }


    public int get() {
        // Метод - вероятность получение игрушек
        Random random = new Random();
        int randomizer = random.nextInt(100);

        if (randomizer < 20) {return 1;}
        else if (randomizer < 40) {return 2;}
        else {return 3;}

    }

    public void WriteToFile(String filename, int count) {
        // метод записи в текстовой файл
        try {
            FileWriter writer = new FileWriter(filename);
            for (int i = 0; i < count; i++) {
                int selectedID = get();
                for (Toy toy: toyQueue) {
                    if (toy.id == selectedID)
                        writer.write("ID: " + toy.id + ", Name: " + toy.name + ", quantity: " +
                                toy.quantity + ", frequency: " + toy.frequency + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ToyStore toys = new ToyStore();

        toys.put(1,"wolf", 2, 20);
        toys.put(2, "elephant", 2, 20);
        toys.put(3, "rabbit", 6, 60);

        toys.WriteToFile("FileToToys.txt", 10);

    }


}

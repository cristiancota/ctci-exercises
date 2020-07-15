package stackAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
    Queue<Animal> animalQueue = new LinkedList<>();
    Queue<Animal> buffer = new LinkedList<>();

    public void enqueue(Animal animal) {
        animalQueue.add(animal);
    }

    public Animal dequeueAny() {
        return animalQueue.remove();
    }

    public Dog dequeueDog() {
        Dog dog = null;
        boolean useAnimalQueue = !animalQueue.isEmpty();

        while (!animalQueue.isEmpty() || !buffer.isEmpty() && dog == null) {
            if (useAnimalQueue && animalQueue.isEmpty() || !useAnimalQueue && buffer.isEmpty()) return null;

            Animal animal = useAnimalQueue ? animalQueue.remove() : buffer.remove();
            if (animal instanceof Dog && dog == null) {
                dog = (Dog) animal;
            } else {
                if (useAnimalQueue) {
                    buffer.add(animal);
                } else {
                    animalQueue.add(animal);
                }
            }
        }

        return dog;
    }

    public Cat dequeueCat() {
        Cat cat = null;
        boolean useAnimalQueue = !animalQueue.isEmpty();

        while (!animalQueue.isEmpty() || !buffer.isEmpty() && cat == null) {
            if (useAnimalQueue && animalQueue.isEmpty() || !useAnimalQueue && buffer.isEmpty()) return null;

            Animal animal = useAnimalQueue ? animalQueue.remove() : buffer.remove();
            if (animal instanceof Cat && cat == null) {
                cat = (Cat) animal;
            } else {
                if (useAnimalQueue) buffer.add(animal);
                else animalQueue.add(animal);

            }
        }

        return cat;
    }
}

class Animal {
    private String _name;

    public Animal(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);

    }
}
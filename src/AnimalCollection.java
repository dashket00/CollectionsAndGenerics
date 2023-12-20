import java.util.LinkedList;

public class AnimalCollection {
    private LinkedList<String> animals = new LinkedList<>();

    public void addAnimal(String animal) {
        animals.addFirst(animal);
    }

    public String removeAnimal() {
        return animals.pollLast();
    }

    public void displayAnimals() {
        System.out.println("Животные: " + animals);
    }

    public static void main(String[] args) {
        AnimalCollection animalCollection = new AnimalCollection();

        animalCollection.addAnimal("Лев");
        animalCollection.addAnimal("Тигр");
        animalCollection.addAnimal("Зебра");

        animalCollection.displayAnimals();

        String removedAnimal = animalCollection.removeAnimal();
        System.out.println("Удалено: " + removedAnimal);

        animalCollection.displayAnimals();
    }
}

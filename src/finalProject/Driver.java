package finalProject;

public class Driver {
    public static void main(String[] args) throws Exception {
        Organization animals = new Organization(Purpose.ANIMAL_RIGHTS, 3, 9);
        Branch animalBranch = new Branch("Dog House", 3, animals);
        Event animalEvent = new Event("Animals", "Cat House");
        animals.addBranch(null);
        animals.addBranch(animalBranch);
        animalBranch.addEvent(null);
        animalBranch.addEvent(animalEvent);
    }
}

package finalProject;

public class Driver {
    public static void main(String[] args) throws Exception {
        Organization animals = new Organization(Purpose.ANIMAL_RIGHTS, 3, 9);
        Branch animalBranch = new Branch("Dog House", 3, animals);
        Event animalEvent = new Event("Animals", "Cat House");
        Organizer animalOrganizer = new Organizer("Rex", animalBranch);
        Event greenEnergyEvent = new Event("Green Energy", "Power Grid");
        Member animalMember = new Member("Air Bud", Role.MEMBER);
        animalOrganizer.addEvent(animalEvent);
        animals.addBranch(null);
        animals.addBranch(animalBranch);
        animalBranch.addEvent(null);
        animalBranch.addEvent(animalEvent);
        animalOrganizer.planEvent("Dog Naming", "Shelter");
        animalOrganizer.addAttendee(animalEvent, animalMember);
        animalOrganizer.addAttendee(greenEnergyEvent, animalMember);
        animalOrganizer.removeAttendee(animalEvent, animalMember);
        animalOrganizer.removeAttendee(greenEnergyEvent, animalMember);
        animalOrganizer.removeAttendee(animalEvent, animalMember);
        animalOrganizer.addAttendee(animalOrganizer.getEvents().get(0), animalMember);
    }
}

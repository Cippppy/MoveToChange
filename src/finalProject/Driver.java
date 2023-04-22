package finalProject;

public class Driver {
    public static void main(String[] args) throws Exception {

        // // Organization constructors
        // Organization animals = new Organization("PETA", Purpose.ANIMAL_RIGHTS, 3, 9);
        // Organization nullOrganization = new Organization(null, null, 0, 0);

        // // Branch constructors
        // Branch animalBranch = new Branch("Dog House", 3, animals);
        // Branch nullBranch = new Branch(null, null);
        // Branch testBranch = new Branch("Test", nullOrganization);

        // // Event constructors
        // Event animalEvent = new Event("Animals", "Cat House");
        // Speech animalSpeech = new Speech("Animals", "Cat House");
        // March animalMarch = new March("Animals", "Cat House");
        // Meeting animalMeeting = new Meeting("Animals", "Cat House");

        // Event greenEnergyEvent = new Event("Green Energy", "Power Grid");
        // Event nullEvent = new Event(null, null);

        // // People Constuctors
        // President animalPresident = new President("President Lizard", animalBranch);
        // Organizer animalOrganizer = new Organizer("Rex", animalBranch);
        // Recruiter animalRecruiter = new Recruiter("Slinky", animalBranch);
        // Member animalMember = new Member("Air Bud");
        // Member animalTestMember = new Member("Boot");
        // animalBranch.addMember(animalTestMember);

        // animalOrganizer.addEvent(animalEvent);
        // animalBranch.addEvent(null);
        // animalBranch.addEvent(animalEvent);
        // animalOrganizer.planEvent("Dog Naming", "Shelter");
        // animalOrganizer.addAttendee(animalEvent, animalMember);
        // animalOrganizer.addAttendee(greenEnergyEvent, animalMember);
        // animalOrganizer.removeAttendee(animalEvent, animalMember);
        // animalOrganizer.removeAttendee(greenEnergyEvent, animalMember);
        // animalOrganizer.removeAttendee(animalEvent, animalMember);
        // animalOrganizer.addAttendee(animalOrganizer.getEvents().get(0), animalMember);
        // animalPresident.changePosition(animals, animalTestMember, "Organizer");
        // System.out.println(animalBranch.getMembers().contains(animalTestMember));
        // animalPresident.kickMember(animals,animalTestMember);
        // System.out.println(animalBranch.getMembers().contains(animalTestMember));
        // animalBranch.addMember(animalTestMember);
        // animalBranch.addMember(animalMember);

        // animalBranch.saveMembers();
        // animalBranch.setMembers("testMembers.txt", 0);
        // System.out.println(animalBranch.getMembers());

        // animals.saveBranches();
        // animals.setBranches("testBranches.txt", 0);
        // System.out.println(animals.getBranches());
        // animalBranch.removeMember(null);
        Person person = new Person("person", "user", "pass");
        System.out.println(person.getUsernameAndPassword());

        Login login = new Login("Credentials.txt");
        login.setCredentials(0);
        login.addLogin(person);
        login.saveCredentials();
    }
}

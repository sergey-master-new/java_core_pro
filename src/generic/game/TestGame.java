package generic.game;

public class TestGame {

    public static void main(String[] args) {

        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Maria", 15);

        Student student1 = new Student("Nikolay", 20);
        Student student2 = new Student("Ksenia", 18);

        Employee employee1 = new Employee("Roman", 32);
        Employee employee2 = new Employee("Mikhail", 47);

//        Если в Team нет дженерика, то я могу добавлять и студентов и рабочих
//        Team schoolarTeam = new Team("Dragons");
//        schoolarTeam.addNewParticipant(schoolar1);
//        schoolarTeam.addNewParticipant(schoolar2);
//        schoolarTeam.addNewParticipant(student1);
//        schoolarTeam.addNewParticipant(employee1);

        Team<Schoolar> schoolarTeam = new Team("Dragons");
        Team<Student> studentTeam = new Team("Vpered!");
        Team<Employee> employeeTeam = new Team("Cowboys");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);


//        Компилятор пропускает, но в Rintime ошибка ClassCastException, если public class Team <T>{...}
//        Team<String> anotherTeam = new Team("Fantasy");
//        anotherTeam.addNewParticipant("Hello!");
//
//        В этом месте класса Team ошибка:
//        System.out.println("In team " + name + " add new participant by name " + ((Participant) participant).getName());
//
//        Если public class Team <T extends Participant>{ ... }, то компилятор не пропустит:
//        Team<String> anotherTeam = new Team("Fantasy");


        Team<Schoolar> schoolarTeam2 = new Team("Mudreci");
        Schoolar schoolar3 = new Schoolar("Sergey", 12);
        Schoolar schoolar4 = new Schoolar("Olya", 14);
        schoolarTeam.addNewParticipant(schoolar3);
        schoolarTeam.addNewParticipant(schoolar4);

        schoolarTeam.playWith(schoolarTeam2);

//        Программа работает не корректно при методе public void playWith(Team team){...}
//        могут играть команды с разных групп (лиг):
//        schoolarTeam.playWith(studentTeam);




    }
}

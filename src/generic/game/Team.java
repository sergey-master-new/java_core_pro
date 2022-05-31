package generic.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team <T extends Participant>{

    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant){

        participants.add(participant);
        System.out.println("In team " + name + " add new participant by name " + participant.getName());

//        Компилятор не пониает, какие классы и соответсвенно методы могут быть под дженериком <T>
//        у класса public class Team <T>{ ... }, поэтому в этом случае тип нужно скастить
//        System.out.println("In team " + name + " add new participant by name " + ((Participant) participant).getName());
    }

    public void playWith(Team<T> team){

        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 1){
            winnerName = team.name;
        } else {
            winnerName = this.name;
        }

        System.out.println("Team winning:: " + winnerName);
    }
}

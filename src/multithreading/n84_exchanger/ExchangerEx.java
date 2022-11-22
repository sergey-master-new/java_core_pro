package multithreading.n84_exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerEx {

    public static void main(String[] args) {

        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> friend1Aactions = new ArrayList<>();
        friend1Aactions.add(Action.NOZNICI);
        friend1Aactions.add(Action.BUMAGA);
        friend1Aactions.add(Action.NOZNICI);
        List<Action> friend2Aactions = new ArrayList<>();
        friend2Aactions.add(Action.BUMAGA);
        friend2Aactions.add(Action.KAMEN);
        friend2Aactions.add(Action.KAMEN);

        new BestFriend("Vanya", friend1Aactions, exchanger);
        new BestFriend("Roma", friend2Aactions, exchanger);
    }
}

enum Action {

    KAMEN, NOZNICI, BUMAGA;
}

class BestFriend extends Thread {

    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    public BestFriend(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }

    private void determineWinner(Action myAction, Action friendsAction) {

        if ((myAction == Action.KAMEN && friendsAction == Action.NOZNICI)
                || (myAction == Action.NOZNICI && friendsAction == Action.BUMAGA)
                || (myAction == Action.BUMAGA && friendsAction == Action.KAMEN)) {

            System.out.println(name + " wins!!!");
        }
    }

    public void run() {

        Action replay;

        for (Action action : myActions) {

            try {
                replay = exchanger.exchange(action);
                determineWinner(action, replay);
                sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
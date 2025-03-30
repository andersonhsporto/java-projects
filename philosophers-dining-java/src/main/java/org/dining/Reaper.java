package org.dining;

import java.util.List;

public class Reaper implements Runnable {

    private final Integer timeToDie;

    List<Philosopher> philosophers;

    public Reaper(Integer timeToDie, List<Philosopher> philosophers) {
        this.timeToDie = timeToDie;
        this.philosophers = philosophers;
    }

    @Override
    public void run() {
        while (true) {
            for (var philosopher : philosophers) {
                if (philosopher.isDead()) {
                    System.out.println("Philosopher " + philosopher.getId() + " died");
                    System.exit(1);
                }
            }
        }
    }
}

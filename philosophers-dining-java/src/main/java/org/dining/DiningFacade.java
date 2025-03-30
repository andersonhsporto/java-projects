package org.dining;

import java.util.ArrayList;
import java.util.List;

public class DiningFacade {

    private final Integer numberOfPhilosopher;

    private final Integer timeToDie;

    private final Integer timeToEat;

    private final Integer timeToSleep;

    private final Integer numberOfTimesToEat;
    private DiningFacade(Integer numberOfPhilosopher, Integer timeToDie, Integer timeToEat, Integer timeToSleep, Integer numberOfTimesToEat) {
        this.numberOfPhilosopher = numberOfPhilosopher;
        this.timeToDie = timeToDie;
        this.timeToEat = timeToEat;
        this.timeToSleep = timeToSleep;
        this.numberOfTimesToEat = numberOfTimesToEat;
    }

    public static DiningFacade ofArgs(String[] args) {
        Integer numberOfPhilosopher = Integer.parseInt(args[0]);
        Integer timeToDie = Integer.parseInt(args[1]);
        Integer timeToEat = Integer.parseInt(args[2]);
        Integer timeToSleep = Integer.parseInt(args[3]);

        if (args.length == 5) {
            Integer numberOfTimesToEat = Integer.parseInt(args[4]);
            return new DiningFacade(numberOfPhilosopher, timeToDie, timeToEat, timeToSleep, numberOfTimesToEat);
        } else {
            return new DiningFacade(numberOfPhilosopher, timeToDie, timeToEat, timeToSleep, 0);
        }
    }

    public List<Philosopher> init() {
        List<Mutex> forks = initForks();
        List<Philosopher> philosophers = new ArrayList<>();

        for (int i = 0; i < numberOfPhilosopher; i++) {
            Mutex leftFork = forks.get(i);
            Mutex rightFork = forks.get((i + 1) % numberOfPhilosopher);

            if (i == numberOfPhilosopher - 1) {
                philosophers.add(Philosopher.of(i, rightFork, leftFork, timeToDie, timeToEat, timeToSleep, numberOfTimesToEat));
            } else {
                philosophers.add(Philosopher.of(i, leftFork, rightFork, timeToDie, timeToEat, timeToSleep, numberOfTimesToEat));
            }
        }

        return philosophers;
    }

    private List<Mutex> initForks() {
        List<Mutex> forks = new ArrayList<>();

        for (int i = 0; i < numberOfPhilosopher; i++) {
            forks.add(new Mutex(i));
        }
        return forks;
    }

    public Integer getTimeToDie() {
        return timeToDie;
    }
}

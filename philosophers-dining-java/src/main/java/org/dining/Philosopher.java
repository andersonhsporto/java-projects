package org.dining;

public class Philosopher implements Runnable {

    private final Integer id;

    private final Mutex leftFork;

    private final Mutex rightFork;

    private final Integer timeToDie;

    private final Integer timeToEat;

    private final Integer timeToSleep;

    private final Integer numberOfTimesToEat;

    private Integer numberOfTimesEaten = 0;

    private Long startTimeStamp = 0L;

    private Long lastMealTimeStamp = 0L;

    private boolean isDead = false;

    private Philosopher(Integer id, Mutex leftFork, Mutex rightFork, Integer timeToDie, Integer timeToEat, Integer timeToSleep, Integer numberOfTimesToEat) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.timeToDie = timeToDie;
        this.timeToEat = timeToEat;
        this.timeToSleep = timeToSleep;
        this.numberOfTimesToEat = numberOfTimesToEat;
    }

    public static Philosopher of(Integer id, Mutex leftFork, Mutex rightFork, Integer timeToDie, Integer timeToEat, Integer timeToSleep, Integer numberOfTimesToEat) {
        return new Philosopher(id, leftFork, rightFork, timeToDie, timeToEat, timeToSleep, numberOfTimesToEat);
    }

    @Override
    public void run() {
        this.startTimeStamp = System.currentTimeMillis();

        if (numberOfTimesToEat == 0 && !isDead) {
            while (!isDead) {
                eat();
                think();
                sleep();
            }
        } else {
            while (numberOfTimesEaten < numberOfTimesToEat && !isDead ) {
                eat();
                think();
                sleep();
            }
        }
    }

    private void think() {
        System.out.println(printCurrentTime() + "Philosopher " + id + " is thinking");
    }

    private void eat() {
        if (getForks()) {
            System.out.println(printCurrentTime() + "Philosopher " + id + " is eating");
            try {
                Thread.sleep(timeToEat);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            leftFork.unlock();
            rightFork.unlock();
            numberOfTimesEaten++;
            lastMealTimeStamp = System.currentTimeMillis();
        }
    }


    private void sleep() {
        System.out.println(printCurrentTime() + "Philosopher " + id + " is sleeping");
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Integer getId() {
        return id;
    }

    public Mutex getLeftFork() {
        return leftFork;
    }

    public Mutex getRightFork() {
        return rightFork;
    }

    public Integer getTimeToDie() {
        return timeToDie;
    }

    public Integer getTimeToEat() {
        return timeToEat;
    }

    public Integer getTimeToSleep() {
        return timeToSleep;
    }

    public Integer getNumberOfTimesToEat() {
        return numberOfTimesToEat;
    }

    public void setStartTimeStamp(Long startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    private String printCurrentTime() {
        return "[" + (System.currentTimeMillis() - startTimeStamp) + "ms] ";
    }

    public boolean isDead() {
        if (System.currentTimeMillis() - startTimeStamp > timeToDie * 1000) {
            System.out.println(printCurrentTime() + "Philosopher " + id + " died");
            isDead = true;
        }
        return isDead;
    }

    private boolean getForks() {
        if (leftFork.getId() < rightFork.getId()) {
            try {
                leftFork.lock();
                rightFork.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                rightFork.lock();
                leftFork.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}

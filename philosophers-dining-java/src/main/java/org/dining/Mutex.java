package org.dining;

public class Mutex {

    private final Integer id;

    private boolean isLocked;

    public Mutex(Integer id) {
        this.id = id;
        this.isLocked = false;
    }

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }

    public Integer getId() {
        return id;
    }
}

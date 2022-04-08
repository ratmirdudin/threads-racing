package com.company;

class MyThreadRace extends Thread {
    private int scoreOfThread = 0;
    private final int maxCount;


    public MyThreadRace(int maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < this.maxCount) {
            synchronized (Main.score) {
                if (!Main.score.empty()) {
                    this.scoreOfThread += Main.score.pop();
                }
                if (Main.isStarted) {
                    i++;
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " score = " + this.scoreOfThread);
    }
}

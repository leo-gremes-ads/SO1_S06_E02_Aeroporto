package controller;

import java.util.concurrent.Semaphore;
import java.lang.InterruptedException;

public class Aviao extends Thread
{
    private int id;
    private Semaphore semaforo;

    public Aviao(int id, Semaphore semaforo)
    {
        this.id = id;
        this.semaforo = semaforo;
    }

    @Override
    public void run()
    {
        try {
            semaforo.acquire();
            decolar();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            semaforo.release();
        }
    }

    public void decolar()
    {
        try {
            int tempo = (int)((Math.random() * 400) + 300);
            System.out.println("Avião número " + String.format("%2d", this.id) + " está manobrando (" + tempo + " ms)");
            sleep(tempo);
            tempo = (int)((Math.random() * 500) + 500);
            System.out.println("Avião número " + String.format("%2d", this.id) + " está taxiando (" + tempo + " ms)");
            sleep(tempo);
            tempo = (int)((Math.random() * 200) + 600);
            System.out.println("Avião número " + String.format("%2d", this.id) + " está decolando(" + tempo + " ms)");
            sleep(tempo);
            tempo = (int)((Math.random() * 500) + 300);
            System.out.println("Avião número " + String.format("%2d", this.id) + " está se afastando (" + tempo + " ms)");
            sleep(tempo);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
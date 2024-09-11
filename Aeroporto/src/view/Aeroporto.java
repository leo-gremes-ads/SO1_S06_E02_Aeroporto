package view;

import controller.*;
import java.util.concurrent.Semaphore;

public class Aeroporto
{
    public static void main(String[] args)
    {
        Semaphore semaforo = new Semaphore(2);
        for (int i = 1; i <= 12; i++) {
            Thread t  = new Aviao(i, semaforo);
            t.start();
        }
    }
}


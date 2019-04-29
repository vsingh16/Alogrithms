package com.macquarie.shiner.gcsupgrade;

public class EvenOddPrinter {

    static class Printer {

        private Boolean isEvenPrinted;

        public Printer(Boolean isEvenPrinted) {
            this.isEvenPrinted = isEvenPrinted;
        }

        public void printEven(int i) throws InterruptedException {

            synchronized (this) {
                while (isEvenPrinted) {
                    this.wait();
                }
                System.out.println("Even " + i);
                isEvenPrinted = true;
                this.notify();
            }

        }

        public void printOdd(int i) throws InterruptedException {

            synchronized (this) {
                while (!isEvenPrinted) {
                    this.wait();
                }
                System.out.println("Odd " + i);
                isEvenPrinted = false;
                this.notify();
            }

        }
    }


    static class EvenNumberGenerator implements Runnable {

        private Printer printer;
        private int max;

        public EvenNumberGenerator(Printer printer, int max) {
            this.printer = printer;
            this.max = max;
        }


        @Override
        public void run() {
            for (int i = 2; i <= max; i += 2) {
                try {
                    printer.printEven(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class OddNumberGenerator implements Runnable {

        private Printer printer;
        private int max;

        public OddNumberGenerator(Printer printer, int max) {
            this.printer = printer;
            this.max = max;
        }


        @Override
        public void run() {
            for (int i = 1; i <= max; i += 2) {
                try {
                    printer.printOdd(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        Printer printer = new Printer(Boolean.TRUE);
        int max = 10;
        EvenNumberGenerator evenNumberGenerator = new EvenNumberGenerator(printer, max);
        OddNumberGenerator oddNumberGenerator = new OddNumberGenerator(printer, max);
        Thread even = new Thread(evenNumberGenerator);
        Thread odd = new Thread(oddNumberGenerator);

        even.start();
        odd.start();

    }
}

package diningphilosophers;

public class ChopStick {
    private static int stickCount = 0;
    private boolean iAmFree = true;
    private final int myNumber;

    public ChopStick() {
        myNumber = ++stickCount;
    }

    synchronized public Boolean take() throws InterruptedException {
       /* while (!iAmFree) {
            wait();
        }
        // assert iAmFree;
        iAmFree = false;

        System.out.println("baguette " + myNumber + " prise");
        // Pas utile de faire notifyAll ici, personne n'attend qu'elle soit occupée
        return iAmFree;*/
        if(!iAmFree){
            wait();
            if(!iAmFree){
                iAmFree=false;
                System.out.println("baguette " + myNumber + " prise");

            } else {
                iAmFree=true;
            }

        }else {
             iAmFree=true;

            System.out.println("baguette " + myNumber + " libre");

        }
        return iAmFree;
    }

    synchronized public void release() {
        // assert !iAmFree;
        System.out.println("baguette " + myNumber + " relâchée");
        iAmFree = true;
        notifyAll(); // On prévient ceux qui attendent que la baguette soit libre
    }

   @Override
    public String toString() {
        return "baguette #" + myNumber;
    }
    
}

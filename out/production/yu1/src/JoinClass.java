public class JoinClass {

    public static void main(String args[]) {

        final Thread thread1 = new Thread(new Runnable(){

            @Override
            public void run() {
                 System.out.println("t1 begin ");
            }
        },"t1");

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join(10);
                    System.out.println("t2 begin");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2");

        final Thread thread3 = new Thread(new Runnable() {

            public void run(){
                try {
                    thread2.join(10);
                    System.out.println("t3 begin");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t3");

        thread2.start();
        thread1.start();
        thread3.start();
    }

}

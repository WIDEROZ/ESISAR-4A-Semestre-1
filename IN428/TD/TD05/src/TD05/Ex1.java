package TD05;

public class Ex1 extends Thread{
        int from;
        int to;
        float res;

        public Ex1(int from, int to){
            this.to = to;
            this.from = from;
            res = 0;
        }
        
        public void run(){
            for(int i = from; i <= to; i++){
                res += Math.pow(i, -2);
            }
        }

        public float getRes(){
            return res;
        }

        public static void main(String[] args) {
            Ex1 thread1 = new Ex1(1, 1000000000);
            Ex1 thread2 = new Ex1(1000000001, 2000000000);
            thread1.start();
            thread2.start();


            


            try {
                thread1.join();
                thread2.join();
            } catch (Exception e) {
                System.err.println("Exception : " + e);
            }
            float res = thread1.getRes() + thread2.getRes();
            System.out.println("Resultat : " + res);
        }
}

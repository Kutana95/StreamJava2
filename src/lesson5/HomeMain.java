package lesson5;

public class HomeMain  {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args){

        System.out.println(method1()*0.001);
        System.out.println(method2()*0.001);
    }

    public static float[] createArray(){
       float[] arr = new float[size];
       for (int i = 0; i < arr.length; i++){
           arr[i] = 1;
       }
       return arr;
    }

    public static synchronized void mathArray(float[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

    }

    public static long method1(){
        long a = System.currentTimeMillis();
        mathArray(createArray());
        return System.currentTimeMillis() - a;
    }

    public static long method2(){
        long a = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        float[] arr = createArray();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        Runnable r1 = () -> mathArray(arr1);
        Runnable r2 = () -> mathArray(arr2);
        Thread t1 = new Thread(r1, "Thread #1");
        t1.start();
        Thread t2 =  new Thread(r2, "Thread #1");
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        return System.currentTimeMillis() - a;
    }
}


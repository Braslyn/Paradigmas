/*
1) Compile y corra
2) Usando FP elimine la clase Chronometer, de forma que funcione igual

Creditos
El truco de //1 es de https://stackoverflow.com/questions/465348/how-can-i-overwrite-print-over-the-current-line-in-windows-command-line

*/

public class Chrono {
    static void sleep(int ms){
       try{
         Thread.sleep(ms * 1000);
       }catch(Exception e){
       }
    }
    public static void main(String... args)throws Exception{
        Thread t = new Thread(() ->{System.out.println("*** Starting ***");
        for(int i = 0; ; i++){
          Chrono.sleep(1);
          System.out.print("\r:" + (i % 60)); // 1
        }});
        t.start();
        t.join();
    }
}

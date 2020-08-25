public class Test{
    int add(int x, int y){
        return x + y;
    }
    int do_add(int x){
        return add(x, x);
        
    }
    static public void main(String... args){
        Test me = new Test();
        System.out.println(me.do_add(666));
    }
}
public class Recursion{
	static public double aproximeE(int ne){
		double fact=1;
		for(int i=2;i<=ne;i++)
			fact*=i;
		if(ne==0)
			return 1;
		return 1/fact+aproximeE(ne-1);
	}
	public static void main(String... args){
		System.out.println(aproximeE(17));
	};
}
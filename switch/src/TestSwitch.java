
public class TestSwitch {
	public static void main(String[] args) {
		/**
		 * 1.如果没有符合的case值就会走default语句，并把下面的所有case执行，一直遇到break,结束
		 * 2.如果遇到匹配的Case值但没有break，会继续往下走直到break结束
		 */
		int i=9;
		switch(i) {
		default:
			System.out.println("default");
		case 0:
			System.out.println("zero");
			
		case 1:
			System.out.println("one");
			
		case 2:
			System.out.println("two");
			break;
		}
		
	}

}

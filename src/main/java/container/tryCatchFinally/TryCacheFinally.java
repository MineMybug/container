package container.tryCatchFinally;
/** 
 * @author  阮航  
 * @date 创建时间：2018年2月28日 下午3:59:05 
 * @version 1.0 
*/
public class TryCacheFinally {
	
//	private static String tString = "";
	
	
	/**
	 * 1.如果在finally里面添加return 语句，则会屏蔽之前try cache 的异常
	 * 2.finally 里面的对象和try cache 的对象不同，jvm 内存模型  类加载机制
	 * @return
	 */
	public static final String test(){
		String tString = "";
		try {
			tString = "try";
			return tString;
		} catch (Exception e) {
			tString = "cache";
			return tString;
		}finally {
			tString = "finally";
			return tString;
		}
	}
	
	public static void main(String[] args) {
//		TryCacheFinally tryCacheFinally = new TryCacheFinally();
		System.out.println(TryCacheFinally.test());
		
	}

}

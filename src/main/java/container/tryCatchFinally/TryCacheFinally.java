package container.tryCatchFinally;
/** 
 * @author  �  
 * @date ����ʱ�䣺2018��2��28�� ����3:59:05 
 * @version 1.0 
*/
public class TryCacheFinally {
	
//	private static String tString = "";
	
	
	/**
	 * 1.�����finally�������return ��䣬�������֮ǰtry cache ���쳣
	 * 2.finally ����Ķ����try cache �Ķ���ͬ��jvm �ڴ�ģ��  ����ػ���
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

package container.callBack;
/** 
 * @author  阮航  
 * @date 创建时间：2018年1月16日 下午4:04:55 
 * @version 1.0 
*/
public class CallBackDemo implements CallBackFileIo{

	private String fileName;
	private String context;
	
	public CallBackDemo(String fileNme,String context){
		this.fileName = fileNme;
		this.context = context;
	}
	
	public void saveStr(){
		FileIo fileIo = new FileIo();
		fileIo.saveStrToFile(fileName, context, this);
	}

	@Override
	public void onResult(boolean isSave) {

		System.out.println(isSave?"保存成功！":"保存失败！");
	}
}

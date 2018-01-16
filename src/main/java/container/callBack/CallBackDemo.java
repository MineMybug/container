package container.callBack;
/** 
 * @author  �  
 * @date ����ʱ�䣺2018��1��16�� ����4:04:55 
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

		System.out.println(isSave?"����ɹ���":"����ʧ�ܣ�");
	}
}

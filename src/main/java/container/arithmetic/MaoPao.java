package container.arithmetic;
/** 
 * @author  阮航  
 * @date 创建时间：2018年1月18日 上午11:50:02 
 * @version 1.0 
*/
public class MaoPao {

	private int[] arr;
	
	public MaoPao(int[] arr){
		this.arr = arr;
	}
	
	public int[] sortArr(){

		int temp = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = i + 1; j < arr.length; j++){
				if(arr[i] < arr[j] ){
//					swap(arr[i],arr[j]);
					
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	public void swap(int a, int b){
		int temp = 0;
		temp = b;
		b = a;
		a = temp;
		
	}
	
	public static void main(String[] args) {
		int [] testArr = {1,2,6,3,9,6};
		MaoPao maoPao = new MaoPao(testArr);
		testArr = maoPao.sortArr();
		for(int s : testArr){
			System.out.println(s);
		}
	}
}

package twitterProblemWithJUnit.main;

public class TwitterProblem {

	private static int[] array;
	private static int absoluteMax;
	
	public static void setValuesOfArray(int[] inputArray){
		array = inputArray;
	}
	public static int[] getArray(){
		return array;
	}
	public static int searchAbsoluteMax(int[] array) {
		for(int i=0;i<array.length-1;i++){
			if(array[i]<array[i+1]){
				absoluteMax = array[i+1];
			}
		}
		return absoluteMax;
	}
	public static int getAbsoluteMax(){
		return absoluteMax;
	}
	public static int calculateVolume(){
		int volume = 0;
		int leftLocalMax=0;
		int rightLocalMax=0;
		for(int positionOfLeftPointer=0,positionOfRightPointer=array.length-1;
			positionOfLeftPointer<positionOfRightPointer;){
			
			if(array[positionOfLeftPointer]>leftLocalMax){
				leftLocalMax = array[positionOfLeftPointer];
			}
			if(array[positionOfRightPointer]>rightLocalMax){
				rightLocalMax = array[positionOfRightPointer];
			}
			if(leftLocalMax < rightLocalMax){
				volume +=leftLocalMax-array[positionOfLeftPointer];
				positionOfLeftPointer++;
			}
			else{
				volume +=rightLocalMax-array[positionOfRightPointer];
				positionOfRightPointer--;
			}
		}
		return volume;
	}
	public static void main(String[] args){
		int[] inputArray = {2,5,1,2,3,4,7,7,6,2,3,6};
		TwitterProblem.setValuesOfArray(inputArray);
		int volume = TwitterProblem.calculateVolume();
		System.out.println("volume:"+volume);
	}
}

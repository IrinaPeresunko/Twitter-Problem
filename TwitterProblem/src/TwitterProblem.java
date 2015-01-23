public class TwitterProblem {
	
	public static int calculateCountOfMaxElements(int arr[],int max){
		int count=0;
		for(int i=0;i<arr.length;i++){
			if(max==arr[i]) count++;
		}
		return count;
	}
	public static int searchMaxElement(int arr[]){
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			if(max<arr[i]) max=arr[i];
		}
		return max;
	}
	public static int[] getPositionOfMaxElements(int arr[],int count,int max){
		int positionOfMaxElements[]=new int[count];
		int p=0;
		for(int i=0;i<arr.length;i++){
			if(max==arr[i]){
				positionOfMaxElements[p]=i;
				p++;
			}
		}
		return positionOfMaxElements;
	}
	
	public static void main(String[] args) {
		
		//int arr[]={2,5,1,2,3,4,7,7,6};
		//int arr[]={4,3,6,2,7,8,4,1,8,2,5,8,6,1,8};
		int arr[]={16,15,7,10,19,8,10,1,5,2,11,19,5,1,7,9,13};
		for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
		
		int max=searchMaxElement(arr);
		int count=calculateCountOfMaxElements(arr,max);
		int positionOfMaxElements[]=getPositionOfMaxElements(arr,count,max);

	    //calculate the sum between max elements
	    int sumBetweenMax=0;
	   if(count>1){
		   int posOfMaxElement=positionOfMaxElements[0];
		   for(int i=positionOfMaxElements[0]+1;i<positionOfMaxElements[count-1];i++){
							sumBetweenMax+=arr[posOfMaxElement]-arr[i];				
				}
	   }
	   System.out.println("\n"+"sum between max elements="+sumBetweenMax);
	   
	 //check for an increasing sequence
	 		boolean flagInc = true;
	 		int temp=arr[0],p=1;
	 		while(p!=positionOfMaxElements[0] && flagInc!=false){
	 			if(temp<arr[p]){
	 				flagInc=true;
	 				temp=arr[p];
	 			}
	 			else flagInc=false;
	 			p++;
	 		}	 		
	 		System.out.println(flagInc);
	 		
	 		int sumUntilMaxElem=0;
	   //calculate sum until max element
	 		int posTempMax = 0;
	 		int tempMax=arr[0];
	 		 if(flagInc==true) sumUntilMaxElem=0; 
	 		 else{
	 			for(int i=1;i<positionOfMaxElements[0];i++){
	 				if(tempMax<arr[i]){
	 					tempMax=arr[i];
	 					posTempMax=i;
	 				}
	 				else{
	 					sumUntilMaxElem+=arr[posTempMax]-arr[i];
	 				}
	 			}
	 		 }
	 		System.out.println("sum until the max element="+sumUntilMaxElem);
	 		
	 		//check for a decreasing sequence
			boolean flagDec = true;
			if(positionOfMaxElements[count-1]<arr.length-1) tempMax=arr[positionOfMaxElements[count-1]+1];
			p=positionOfMaxElements[count-1]+1;;
		    while(p<arr.length-1 && flagDec!=false){
				if(tempMax<=arr[p+1]){
					flagDec=true;
					tempMax=arr[p+1];
				}
				else flagDec=false;
				p++;
			}
		    System.out.println(flagDec);
		    
	   //calculate sum after max element
		    int sumAfterMaxElement=0;
		    if(positionOfMaxElements[count-1]<arr.length-1) posTempMax=positionOfMaxElements[count-1]+1;
		    tempMax=arr[posTempMax];
		    if(flagDec==true) sumAfterMaxElement=0;
		    else{
		    	for(int i=posTempMax+1;i<arr.length;i++){
					if(tempMax<arr[i]){
						tempMax=arr[i];	
						posTempMax=i;
					}
				}
		    	
		    	p=positionOfMaxElements[count-1]+1;
		    	while(p<=posTempMax){
		    		sumAfterMaxElement+=arr[posTempMax]-arr[p];
		    		p++;
		    	}
			}
		    System.out.println("sum after max element="+sumAfterMaxElement);
		    int volume=sumUntilMaxElem+sumAfterMaxElement+sumBetweenMax;
		    System.out.println("volume="+volume);
	}
}



public class Stock {

	public static void main(String[] args) {

		for (int count = 0; count <1;count++){
		
			int[] array = new int[99];
			for (int i=0; i<99; i++){
				array[i]= (int)(100*Math.random());
				if (array[i]<10)
					System.out.print("0"+array[i]+" ");
				else
					System.out.print(array[i]+" ");
			}
			System.out.println("");
			for (int i=0; i<99; i++){
				if (i<10)
					System.out.print("0"+i+" ");
				else
					System.out.print(i+" ");
			}
			int []array1={9,8,7,6,5};
			if(!findBestLinear(array).equals(findBestBrute(array)))
				System.out.println("\n unequal");
			findMaxLose(array);
			findMaxLoseNonLinear(array);
		}

	}

	private static void findMaxLose(int[] array) {
			int maxPos=0;
			int minPos=0;
			int worstMax=0;
			int diff=0;
			
			for (int i=0;i<array.length;i++){
				
				if (array[i]>array[maxPos]){					
					maxPos=i;		
				}
				
				if (array[i]-array[maxPos]<diff){					
					minPos=i;
					worstMax=maxPos;
					diff=array[minPos]-array[maxPos];

				}

			}
			System.out.print("\n"+worstMax+" "+minPos+" "+array[worstMax]+" "+array[minPos]+" "+diff);

	}
	
	
	private static void findMaxLoseNonLinear(int[] array) {
		int maxPos=0;
		int minPos=0;
		int diff=0;
		
		for (int i=0;i<array.length;i++){
			
			for (int j=i+1;j<array.length;j++){
				
				if (array[j]-array[i]<diff){
					minPos=j;
					maxPos=i;
					diff=array[j]-array[i];
					
				}
			}

		}
		System.out.print("\n"+maxPos+" "+minPos+" "+array[maxPos]+" "+array[minPos]+" "+diff);

}
	

	private static String findBestLinear(int[] array) {
		int bestMinPos = 0;
		int minPos = 0;
		int bestMaxPos = 0;
		int dValue = array[bestMaxPos] - array[bestMinPos];
	
		for (int i=0; i<array.length;i++){

			if (array[i]<array[minPos])				
				minPos=i;		
			
			if (array[i]-array[minPos]>dValue){
				bestMaxPos=i;
				bestMinPos=minPos;
				dValue=array[bestMaxPos] - array[bestMinPos];
			}						
		}		
		System.out.print("\n"+bestMinPos+" "+bestMaxPos+" "+array[bestMinPos]+" "+array[bestMaxPos]+" "+dValue);	
		return bestMinPos+" "+bestMaxPos+" "+array[bestMinPos]+" "+array[bestMaxPos]+" "+dValue;
		
	}
	
	
	private static String findBestBrute(int[] array) {
		int minPos = 0;
		int maxPos = 0;
		int maxDValue = array[maxPos] - array[minPos];
	
		for (int i=0;i<array.length;i++){			
			for (int j=i+1;j<array.length;j++){				
				if(array[j]-array[i]>maxDValue){
					maxDValue=array[j]-array[i];
					minPos=i;
					maxPos=j;
				}
			}
		}			
		System.out.print("\n"+minPos+" "+maxPos+" "+array[minPos]+" "+array[maxPos]+" "+maxDValue);	
		return minPos+" "+maxPos+" "+array[minPos]+" "+array[maxPos]+" "+maxDValue;
	}
}

interface ArrayProcessing {
	double apply (double[] array);
}

public class Week06_02 {
	public static final ArrayProcessing maxer=array-> {
		double max=array[0];
		for (double value:array) {
			if(value>max) {
				max=value;
			}
		}return max;
		
	};
	
	public static final ArrayProcessing miner=array-> {
		double min= array[0];
		for(double value:array) {
			if(value<min) {
				min=value;
			}
		}return min;
	};
	
	public static final ArrayProcessing sumer= array-> {
		double sum=array[0];
		for (double value: array) {
			sum+=value;
		}return sum/array.length;
	 
};

	public static final ArrayProcessing averager=array->sumer.apply(array)/array.length;

public static void main(String[] args) {
	double[] array= {23,56,15,78,9,35,62,43};
	
	System.out.println("Maximum value: "+ maxer.apply(array));
	System.out.println("Minimum value: "+ miner.apply(array));
	System.out.println("Sum value: "+ sumer.apply(array));
	System.out.println("Average value: "+ averager.apply(array));
}
}
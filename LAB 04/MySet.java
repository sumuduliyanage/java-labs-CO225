
//* my array list: an array that behaves like a list 
 /* E/16/200
 */

public class MySet<T/* Can we have any T */> { 

    int nextItem; 
    int currentCapacity; 
    T[] data; // DO NOT CHANGE

    private static int defaultSizeToCreate = 10; // how many elements to create 

	//overloaded constructor
	@SuppressWarnings("unchecked")
    public MySet(int elements) { 
		this.nextItem = 0; 
		defaultSizeToCreate = elements; 
		this.currentCapacity = elements; 

		this.data = (T[]) new Object[defaultSizeToCreate]; 
    }
    
	//default constructor
    @SuppressWarnings("unchecked")
	public MySet() { 
		this(defaultSizeToCreate); 
		this.nextItem = 0;
		this.currentCapacity = defaultSizeToCreate;
		this.data = (T[]) new Object[defaultSizeToCreate];
    }
	
	//return true when nextItem is zero
    public boolean isEmpty() { return this.nextItem == 0; } 
    
    //return true when nextitem is equal to currentcpacity
    public boolean isFull() { return nextItem == currentCapacity;} 
    
    
    //more function to add more elements when the size is full
    @SuppressWarnings("unchecked")
	private void more() {
		int newSize = this.currentCapacity + defaultSizeToCreate;  //create a new array with currentCapacity+defaultSizeToCreate, 
		T[] newData = (T[]) new Object[newSize];
		
		for(int i=0; i<this.currentCapacity; i++)  //copy the old conents into that
			newData[i] = this.data[i];
			
		currentCapacity = newSize;
		data = newData;
	}
    
    
    

	
    public boolean add(T item) { 
			
		

		/* if there is any element delete it 
		 * then add the new element. 
		 * How do you handle when the array is full: 
		 * crate a new array with currentCapacity+defaultSizeToCreate, 
		 * copy the old conents into that
		 * Accessing array when full might be a problem
		 */

		/* Add the item to the array if the item is not there */
		
			
		//checking whether the item is already in the set	
		for (int i=0;i<currentCapacity;i++)
		{
			if(item.equals(this.data[i])){
				return false;
			}
		}
			
		
		
					
		//if the array is full, we have make  a new array with size currentCapacity+defaultSizetoCreate
		if(isFull()){
			more();
		} 

		//when there is no matching item, we have to add it into the set
		this.data[nextItem++] = item;
	
			
		//handling error if the index is outof bound	
		try{
			data[nextItem] = null;//DO NOT CHANGE
			return true;//return true when the array is modified
		}
		catch(ArrayIndexOutOfBoundsException e){
		}
			
		
		return true	;
		
    }



    public T remove() { 
		/* remove the first element in the array 
		 * and copy the rest front. 
		 * FIFO structure. 
		 * If the ArrayList is empty return null
		 */
		 
		 
		 
		/* Option 1: */
		if(isEmpty()) return null;   //If the ArrayList is empty return null
		// IMPLEMENT THE REST 
		
		T value=data[0];  //remove the first element in the array 
		
		for(int i=0;i<currentCapacity-1;i++)//and copy the rest front. 
		{
			data[i]=data[i+1];
		}
		
		data[currentCapacity-1]=null;//FIFO structure
		
		return value;
		
		
		 /*Option 2: 
	    if(!isEmpty()) { 
			// IMPLEMENT THE REST
				T value=data[0];  //remove the first element in the array 
			
			for(int i=0;i<currentCapacity-1;i++)//and copy the rest front. 
			{
				data[i]=data[i+1];
			}
			
			data[currentCapacity-1]=null;//FIFO structure
			
			return value;
			
		}
		   return null;*/
	    // which option is better? why? 

	
    }


}
	 

	

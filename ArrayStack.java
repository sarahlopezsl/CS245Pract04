
public class ArrayStack implements Stack {

	
	private int top;
	private Object[] arr = new Object [10];
	
	public ArrayStack() {
	}

	public void push(Object item) {
		if(top == arr.length){
			grow();
		}
		arr[top++] = item; 
	}
	
	private void grow(){
		Object[] new_arr = new Object[arr.length*2];
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
		arr = new_arr;
	}

	//Returns and removes the item that is at the top of the stack
	//(the last item that was added to the stack)
	public Object pop() {
		if(!empty()){
			return arr[--top];
		}
		return null;
		
		//maybe not best logic? Should we check if it is empty then return null
	}

	//Returns the item that was last added to the stack 
	//(just below top of the stack where next item would be placed
	public Object peek() {
		if(!empty()){
			return arr[top-1];
		}
		return null;
	}

	//checks if the top of the stack points at index 0
	public boolean empty() {
		if(top == 0){
			return true; 
		}
		return false;
	}

}

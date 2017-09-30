
public class ArrayQueue implements Queue {

	
	private int head;
	private int tail;
	private Object[] arr = new Object[10];
	
	public ArrayQueue() {

	}

	public Object dequeue() {
		
		if(empty()){
			return null;
		}
		Object item = arr[head++];
		if(head>=arr.length){
			head = 0;
		}
		return item; 
	}

	public void enqueue(Object item) {
		if(full()){
			grow();
		}
		arr[tail] = item;
		tail++;
		if(tail>=arr.length){
			tail=0;
		}
	}


	private void grow() {
		Object[] new_arr = new Object[arr.length*2];
		
			if (head>tail){
				int j=arr.length-head; 
				System.arraycopy(arr, head, new_arr, head, head-tail);
				
			}
			if(head<=tail){
				System.arraycopy(arr, tail, new_arr, 0, arr.length-tail);
				System.arraycopy(arr, 0, new_arr, arr.length-tail, head);
				
				head = arr.length-(tail-head); 
				tail = 0;
				
			}

		arr = new_arr;
		
	}


	private boolean full() {
		if((tail +1)%arr.length == head){
			return true;
		}
		return false; 
	}


	public boolean empty() {
		if(head == tail){
			return true;
		}
		return false;
	}

}

/*



public class NegativeIterator {
	private List list = new ArrayList();
	private Iterator iterator(Collection intergers);
	int current = iterator.next();
	public int next() {
		if (list.size()>0){
			for (Integer i: list){
				if (current == i )
					flag = true;
				if (flag && i<0)
					current =i;
					return i;
			}
		}
		while (iterator.hasNext()){			
			if(current<0) 
				return next;
			current = iterator.next();
		}
		return null;
	}
	public boolean hasNext(){
		boolean flag = false;
		if (list.size()>0){
			for (Integer i: list){
				if (current == i )
					flag = true;
				if (flag && i<0)
					return true;
			}
		}
		int current = iterator.next();
		list.clear();
		int next = current;
		while (iterator.hasNext()){			
			if(next<0) 
				return true;
			list.add(next);
			next = iterator.next();
		}
		return false;
	}
}
public class NegativeIterator {
	private List list = new ArrayList();
	int current = iterator.next();
	List list = new ArrayList();
	int current_index = 0;
	public NegativeIterator(Collection intergers){
		while (integers.iterater().hasNext()){
			list.add(integers.iterater().next());
		}
	}
	public int next(){
		for (Integer i: list){
			current_index++;
			if (i<0)
				return i;
		}
		return null;
	}
	public boolean hasNext(){
		for (int i = current_index; i<list.size();i++){
			if (list.get(i)<0)
				return true;
		}
		return false;
	}
}






*/

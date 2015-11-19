package simpledatabase;
import java.util.ArrayList;
import java.util.Collection;

public class Join extends Operator{

	private ArrayList<Attribute> newAttributeList;
	private String joinPredicate;
	ArrayList<Tuple> tuples1;

	
	//Join Constructor, join fill
	public Join(Operator leftChild, Operator rightChild, String joinPredicate){
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.joinPredicate = joinPredicate;
		newAttributeList = new ArrayList<Attribute>();
		tuples1 = new ArrayList<Tuple>();
		
	}

	
	/**
     * It is used to return a new tuple which is already joined by the common attribute
     * @return the new joined tuple
     */
	//The record after join with two tables
	@Override
	public Tuple next(){
		int common=0;
		int i=0;
		while(leftChild.next()!=null)
	     tuples1.add(leftChild.next());
	  
	     System.out.println(tuples1.size());
	     System.out.println("here"+tuples1.get(0).getAttributeValue(1));
		//}
	    ArrayList<String> names = null;
	    for (Attribute attribute:tuples1.get(0).getAttributeList())
	    	names.add(attribute.getAttributeName());
		Tuple test=rightChild.next();
		for(Attribute findcommon:test.getAttributeList()){
			if (names.contains(findcommon.getAttributeName()))
					common=test.getAttributeList().indexOf(findcommon);
			else
				i++;
			
		}
		for(Tuple test1:tuples1){
			if(test.equals(test1)){
				newAttributeList.addAll(test.getAttributeList());
				newAttributeList.addAll(test1.getAttributeList());
				newAttributeList.remove(test.getAttributeList().size()+i);
				return new Tuple(newAttributeList);
		}
		}
		while(newAttributeList==null){
			test=rightChild.next();
			for(Tuple test1:tuples1){
				if(test.equals(test1)){
					newAttributeList.addAll(test.getAttributeList());
					newAttributeList.addAll(test1.getAttributeList());
					newAttributeList.remove(test.getAttributeList().size()+i);
					return new Tuple(newAttributeList);
			}
			}
			return null;
		}
		return null;
	}
	
	
	/**
     * The function is used to get the attribute list of the tuple
     * @return attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		if(joinPredicate.isEmpty())
			return child.getAttributeList();
		else
			return(newAttributeList);
	}

}
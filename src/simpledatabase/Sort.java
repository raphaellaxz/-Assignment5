package simpledatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort extends Operator{
	
	private ArrayList<Attribute> newAttributeList;
	private String orderPredicate;
	ArrayList<Tuple> tuplesResult;

	
	public Sort(Operator child, String orderPredicate){
		this.child = child;
		this.orderPredicate = orderPredicate;
		newAttributeList = new ArrayList<Attribute>();
		tuplesResult = new ArrayList<Tuple>();
		
	}
	
	
	/**
     * The function is used to return the sorted tuple
     * @return tuple
     */
	@Override
	public Tuple next(){
		ArrayList<Attribute> sortList=getAttributeList();
		Collections.sort(sortList, new Comparator<Attribute>(){
			public int compare(Attribute attribute1,Attribute attribute2)
			{
				return ((String) attribute1.attributeValue).compareTo((String) attribute2.attributeValue);
			}
			});
		Tuple sortedtuple=new Tuple(sortList);
		return sortedtuple;
		
	}
	
	/**
     * The function is used to get the attribute list of the tuple
     * @return attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		return child.getAttributeList();
	}

}
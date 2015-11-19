package simpledatabase;
import java.util.ArrayList;

public class Projection extends Operator{
	
	ArrayList<Attribute> newAttributeList;
	private String attributePredicate;


	public Projection(Operator child, String attributePredicate){
		
		this.attributePredicate = attributePredicate;
		this.child = child;
		newAttributeList = new ArrayList<Attribute>();
		
	}
	
	
	/**
     * Return the data of the selected attribute as tuple format
     * @return tuple
     */
	@Override
	public Tuple next(){
		Tuple tuple=child.next();
		if (tuple==null)
			return null;
		ArrayList<Attribute> toproject=tuple.getAttributeList();
		newAttributeList.clear();
		for(Attribute target:toproject){
			if(target.getAttributeName().equals(attributePredicate)){
				newAttributeList.add(target);
				Tuple selected=new Tuple(newAttributeList);
			}
		}
		
		Tuple selected=new Tuple(newAttributeList);
		return selected;
		
	}
		

	
	/**
     * The function is used to get the attribute list of the tuple
     * @return attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		return child.getAttributeList();
	}

}
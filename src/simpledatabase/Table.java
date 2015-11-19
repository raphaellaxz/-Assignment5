package simpledatabase;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Table extends Operator{
	private BufferedReader br = null;
	private boolean getAttribute=false;
	private String name;
	private String type;
	private String value;
	private Tuple tuple;
	
	public Table(String from){
		this.from = from;
		
		//Create buffer reader
		try{
			br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/datafile/"+from+".csv")));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		try { 
			System.out.println("test");
			//System.out.println(br.readLine());
			this.name=br.readLine();
			this.type=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	/**
     * Create a new tuple and return the tuple to its parent.
     * Set the attribute list if you have not prepare the attribute list
     * @return the tuple
     */
	@Override
	public Tuple next(){
		/*if (!getAttribute){
		tuple.setAttributeName();
		tuple.setAttributeType();
		tuple.setAttributeValue();
		getAttribute=true;
		}*/
		try {
			System.out.println("fuckyou");
			value=br.readLine();
			if(value==null)
				return null;
			System.out.println(name+" "+type+" " +value);
			tuple=new Tuple(name,type,value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tuple.setAttributeName();
		tuple.setAttributeType();
		tuple.setAttributeValue();
		getAttribute=true;
		
		return tuple;
	}
	

	/**
     * The function is used to get the attribute list of the tuple
     * @return the attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		return tuple.getAttributeList();
	}
	
}
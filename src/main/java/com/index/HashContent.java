package com.index;
import java.util.HashMap; 
import java.util.Map;

public class HashContent {

	public static int keycheck(String pname)
	{
		 HashMap<String,Integer> map=new HashMap<>();
		    map.put("DHP Dakota Upholstered Faux Leather Platform Bed with Wooden Slat Support and Tufted Headboard and Footboard, Twin, White Faux Leather",46365699 );
		    map.put("Zinus 14 Metal Platform Bed with Headboard, Multiple Sizes",53838176);
		    map.put("Better Homes and Gardens Knox Upholstered Platform Bed, Multiple Sizes",487635305);
		    map.put("Walmart 5-Burner Gas Grill, Stainless Steel/Black", 49760308);
		    map.put("Revoace 2 Burner Gas Grill",734661401);
		if(map.containsKey(pname))
		{
			int a= map.get(pname);
			return(a);
		}
		return(0);
	}

}

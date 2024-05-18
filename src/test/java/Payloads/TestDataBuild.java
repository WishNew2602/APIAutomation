package Payloads;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addPlaceJSon() {
		AddPlace p = new AddPlace();
		Location l = new Location();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 99");
		p.setLanguage("English - IND");
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		p.setName("Valorant INC");
		p.setWebsite("www.valorant.com");
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		p.setTypes(types);
		return p;
	}
}
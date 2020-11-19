package version_01;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DataBusRoot {
//	private String url = "	http://apis.data.go.kr/6280000/busRouteService";
//	
//	DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
//	DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if(nValue == null) {
			return null;
		}
		return nValue.getNodeValue();
	}
	static void main() {
		int page = 1;
		try {
			while(true) {
				Staring url = "http://apis.data.go.kr/6280000/busRouteService/getBusRouteNo?serviceKey=K0aiz%2F6OvknTAkiJOdHVTxiaN%2BnQHe5Z%2F%2BIu%2F5PeGx0l2nQDMa4HlRkB9dAvtRNte7ap8JK%2BcQwCWekqgfXZQQ%3D%3D&pageNo=1&numOfRows=10&routeNo="+page;
			}
		}
	}
}
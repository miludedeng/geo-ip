package cc.cafetime.geoip;

public class GetIPLocation {
	public static void main(String[] args) throws Exception {
		GeoIPService service = new GeoIPService();
		System.out.println(service.getLocation("60.25.248.111"));
		System.out.println(service.getLocation("36.32.64.25"));
		System.out.println(service.getLocation("112.132.156.111"));
		System.out.println(service.getLocation("113.64.5.8"));
		System.out.println(service.getLocation("61.159.130.251"));
	}

}

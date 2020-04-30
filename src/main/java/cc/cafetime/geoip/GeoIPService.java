package cc.cafetime.geoip;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Subdivision;

public class GeoIPService {
	
	 private DatabaseReader reader = null;
	

	public GeoIPService() throws IOException {
		//GeoIP2-City 数据库文件D
        File database = new File("data/GeoLite2-City.mmdb");
        // 创建 DatabaseReader对象
        reader = new DatabaseReader.Builder(database).build();
	}
	
	public List<String> getLocation(String ip) throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        // 获取查询结果
        CityResponse response = reader.city(ipAddress);
        // 获取国家信息
        Country country = response.getCountry();
        // 获取省份
        Subdivision subdivision = response.getMostSpecificSubdivision();
        //城市
        City city = response.getCity();
		return Arrays.asList(country.getNames().get("zh-CN"),subdivision.getNames().get("zh-CN") ,city.getNames().get("zh-CN"));
	}
}

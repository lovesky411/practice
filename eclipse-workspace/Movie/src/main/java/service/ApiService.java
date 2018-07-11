package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import model.Movie;

@Service
public class ApiService {
	
	/* Naver Open API 관련 */
	private static final String naver_url = "https://openapi.naver.com/v1/search/movie.json";
	private static final String naver_id = "";
	private static final String naver_secret = "";
	
	
	private static final String kobis_url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?";
	private static final String kobis_key = "key=430156241533f1d058c603178cc3ca0e";

	LocalDateTime now = LocalDateTime.now();
	LocalDateTime now1 = now.minusDays(1);
	
	
	public String getImgUrl(String movieName) {
		String imgUrl = "";
		 try {
	            String text = URLEncoder.encode("그린팩토리", "UTF-8");
	            String apiURL = naver_url+"?query="+movieName; // json 결과
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-Naver-Client-Id", naver_id);
	            con.setRequestProperty("X-Naver-Client-Secret", naver_secret);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	        } catch (Exception e) {
	            System.out.println(e);
	        }
		return imgUrl;
	}
	
	public List<Movie> getMovieInfo() throws Exception{
		
				
		System.out.println("@@@@@@@@");
		BufferedReader br = null;
		List<Movie> list = new ArrayList<Movie>();
		String strUrl = kobis_url + kobis_key + "&targetDt=20180619";
				
		URL url = new URL(strUrl);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setRequestMethod("GET");
		
		br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
		String result = "";
		String line;
		while((line = br.readLine()) != null) {
			result = result + line + "\n";
		}
		System.out.println(result);
		
		return list;
	}
	
	public void parseJson(JSONObject obj) {
		
	}
	
}

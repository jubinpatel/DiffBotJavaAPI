import com.DiffBot.Api.DiffBot;
import com.DiffBot.Json.JSONObject;

public class Test {

	public static void main(String[] args) {
		String url = "http://www.roopfashion.com";
		String token = "f87638a63ff6b18d0a8c5aa7c416ce73";
		String api = "article";
		String[] fields = { "meta", "querystring", "images(*)" };

		Integer version = 2;
		JSONObject obj = DiffBot.APICall(url, token, api, fields, version);
	}

}

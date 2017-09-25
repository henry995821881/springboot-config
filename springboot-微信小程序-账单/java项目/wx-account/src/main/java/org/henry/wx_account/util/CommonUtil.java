package org.henry.wx_account.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;



public class CommonUtil {
	
	
	
	public static final String APPID="wxb77f431bf3c8830b";
	public static final String SECRET="69187f156cd7576cbdb6a326e2ae1ee8";


	
    public static String creatToken(String str) {  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  //SHA1
            //MessageDigest md = MessageDigest.getInstance("SHA1");  //SHA1
            md.update(str.getBytes());  
            StringBuffer sb = new StringBuffer();  
            byte[] bytes = md.digest();  
            for (int i = 0; i < bytes.length; i++) {  
                int b = bytes[i] & 0xFF;  
                if (b < 0x10) {  
                    sb.append('0');  
                }  
                sb.append(Integer.toHexString(b));  
            }  
            return sb.toString();  
        } catch (Exception e) {  
            return "";  
        }  
    }
    
   
    
    
    @SuppressWarnings("unchecked")
	public static Map<String,Object> getSessionKeyAndOPenid(String code){
    	
    	Map<String,Object> map = new HashMap<String, Object>();
    	
    	
    	String body = getSessionKeyBody(code);
    	
    	map = JSON.parseObject(body,Map.class); 
        System.out.println(map);
    	if(map.containsKey("errcode")){
    		return null;
    	}
    	
    	return map;
    }
    
    
    
    /**
     * {
      "openid": "OPENID",
      "session_key": "SESSIONKEY"
}
//错误时返回JSON数据包(示例为Code无效)
{
    "errcode": 40029,
    "errmsg": "invalid code"
}
     * @return
     */
    
    public static String getSessionKeyBody(String code){
    	
    	//设置header
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json; charset=UTF-8");

		//设置参数
		Map<String, String> hashMap = new LinkedHashMap<String, String>();
		//hashMap.put("random", "1234556");
		//hashMap.put("orderNo", "Z20170327110912921426");
		//hashMap.put("requestSource","");
		HttpEntity<Map<String, String>> requestEntity = new HttpEntity<Map<String, String>>(hashMap, httpHeaders);

		//执行请求
		RestTemplate restTemplate = new RestTemplate();
		//ResponseEntity<String> resp = restTemplate.exchange("https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN",HttpMethod.POST,requestEntity, String.class);
	   //ResponseEntity<String> resp = restTemplate.exchange("https://www.baidu.com",HttpMethod.POST,requestEntity, String.class);
     //https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
		String url ="https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+SECRET+"&js_code="+code+"&grant_type=authorization_code";
		
	   ResponseEntity<String> resp = restTemplate.exchange(url,HttpMethod.GET,requestEntity, String.class);
		//获取返回的header
		List<String> val = resp.getHeaders().get("Set-Cookie");
		System.out.println(val);

		//获得返回值
		String body = resp.getBody();
		byte[] bytes=null;
		String b="";
		try {
			bytes = body.getBytes("ISO-8859-1");
			 b = new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return b.toString();
    	
    }
}

package javatest;

import java.util.HashMap;
import java.util.Map;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class Test1 {
	private static String token;
	static {
		//自动化测试
		String loginURL="https://www.ahsj.link/nebula-api/login";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("username", "20195533135");
		param.put("password", "b88c8943097b6e0095ac3f3d48b53081");
		//转化为json格式
		String jsonParam=JSONUtil.toJsonStr(param);
		//发送请求
		String resultParam=HttpRequest.post(loginURL)
				.body(jsonParam)
				.execute()
				.body();
		System.out.println(resultParam);
		//将返回的数据转换为json类型的对象
		JSONObject jo=JSONUtil.parseObj(resultParam);
		
		token=(String)jo.get("data");
		
	}
	public static void selectList() {
		String loginURL="https://www.ahsj.link/nebula-api/api/cust";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("current", "2");
		param.put("size", "6");
		String resultParm=HttpRequest
		.get(loginURL)
		.header("x-auth-token",token)
		.form(param).execute().body();
		System.out.println(resultParm);
	}

	public static void main(String[] args) {
		selectList();
	}

}

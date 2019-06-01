import java.util.HashMap;
import java.util.Map;

public class City {

    //配置您申请的KEY
    public static final String APPKEY ="76bba25e59def5c36e9ba7f37b69a78f";

    //1.根据城市查询天气
    public static void getRequest1(){
        String result =null;
        String url ="http://apis.juhe.cn/simpleWeather/query";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("city","成都");//要查询的城市，如：温州、上海、北京
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml或json，默认json

        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        getRequest1();
    }
}

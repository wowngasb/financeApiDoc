import com.test.HttpApi;
import net.sf.json.JSONObject;

public class test {

    public static void main(String[] args) {
        JSONObject test1_args = new JSONObject();
        test1_args.put("room_id", 73);
        test1_args.put("expire", 1000);
        test1_args.put("uid", "234234");
        test1_args.put("nick", "ttt");
        test1_args.put("ava", "");
        JSONObject test_1 = HttpApi.post("RoomMgr", "getAuthToken", test1_args);
        System.out.println("test_1" + test_1.toString());

        JSONObject test2_args = new JSONObject();
        test2_args.put("token", test_1.get("Info"));
        test2_args.put("page", 1);
        test2_args.put("num", 20);
        
        JSONObject test_2 = HttpApi.post("JiaoYuUserInfo", "listWisDoc", test2_args);
        System.out.println("test_2" + test_2.toString());
    }

}
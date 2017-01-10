import net.sf.json.JSONObject
import com.test.HttpApi

object Test {
    /* This is my first java program.  
     * This will print 'Hello World' as the output
     */
    def main(args: Array[String]) {
        
        val test1_args = new JSONObject()
        test1_args.put("room_id", 73)
        test1_args.put("expire", 1000)
        test1_args.put("uid", "234234")
        test1_args.put("nick", "ttt")
        test1_args.put("ava", "")

        val test_1 = HttpApi.post("RoomMgr", "getAuthToken", test1_args)
        println("test_1 " +test_1.toString() )

        val test2_args = new JSONObject()
        test2_args.put("token", test_1.get("Info"))
        test2_args.put("page", 1)
        test2_args.put("num", 20)
        
        val test_2 = HttpApi.post("JiaoYuUserInfo", "listWisDoc", test2_args)
        System.out.println("test_2 " + test_2.toString())
    }
}
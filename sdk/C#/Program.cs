using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json;

namespace HttpApi
{
    class Program
    {
        static void Main(string[] args)
        {
            var test_1_args = new JObject(
                new JProperty("room_id", 73),
                new JProperty("expire", 1000),
                new JProperty("uid", "234234"),
                new JProperty("nick", "ttt"),
                new JProperty("ava", "")
            );

            var test_1 = HttpApi.post("RoomMgr", "getAuthToken", test_1_args);

            Console.WriteLine("test_1 " + test_1.ToString());

            var test_2_args = new JObject(
                new JProperty("token", test_1.Info),
                new JProperty("page", 1),
                new JProperty("num", 20)

            );
            var test_2 = HttpApi.post("JiaoYuUserInfo", "listWisDoc", test_2_args);
            Console.WriteLine("test_2 " + test_2.ToString());
        }
    }
}

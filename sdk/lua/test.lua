HttpApi = require("HttpApi")
json = require("json")

test_1 = HttpApi.post("RoomMgr", "getAuthToken", {
	room_id = 73, 
	expire = 1000, 
	uid = "234234", 
	nick = "ttt", 
	ava = ""
})
print("test_1 " .. json.encode(test_1))

test_2 = HttpApi.post("JiaoYuUserInfo", "listWisDoc", {
	token = test_1.Info, 
	page = 1, 
	num = 20
})
print("test_2 " .. json.encode(test_2))
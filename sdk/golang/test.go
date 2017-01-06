package main

import (
	"fmt"

	"./httpapi"

	"github.com/jeffail/gabs"
)

func main() {

	test_1_args := gabs.New()
	test_1_args.Set(73, "room_id")
	test_1_args.Set(1000, "expire")
	test_1_args.Set("234234", "uid")
	test_1_args.Set("ttt", "nick")
	test_1_args.Set("", "ava")

	test_1 := httpapi.Post("RoomMgr", "getAuthToken", test_1_args)
	fmt.Println("test_1", test_1.String())

	token := test_1.Path("Info").Data().(string)
	test_2_args := gabs.New()
	test_2_args.Set(token, "token")
	test_2_args.Set(1, "page")
	test_2_args.Set(20, "num")

	test_2 := httpapi.Post("JiaoYuUserInfo", "listWisDoc", test_2_args)
	fmt.Println("test_2", test_2.String())

}

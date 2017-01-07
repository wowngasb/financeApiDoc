require File.dirname(__FILE__)+'/HttpApi'


test_1 = HttpApi.post('RoomMgr', 'getAuthToken', {
    'room_id' => 73,
    'expire' => 1000,
    'uid' => '234234',
    'nick' => 'ttt',
    'ava' => ''
})
puts 'test_1 ' + test_1.to_json


test_2 = HttpApi.post('JiaoYuUserInfo', 'listWisDoc', {
    'token' => test_1['Info'],
    'page' => 1,
    'num' => 20
})
puts 'test_2 ' + test_2.to_json

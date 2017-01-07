use HttpApi;
use JSON;

$test_1 = HttpApi::post('RoomMgr', 'getAuthToken', (
    'room_id' => 73,
    'expire' => 1000,
    'uid' => '234234',
    'nick' => 'ttt',
    'ava' => ''
));
print 'test_1 ', encode_json($test_1), "\n";


$test_2 = HttpApi::post('JiaoYuUserInfo', 'listWisDoc', (
    'token' => ${$test_1}{'Info'},
    'page' => 1,
    'num' => 20
));
print 'test_2 ', encode_json($test_2), "\n";
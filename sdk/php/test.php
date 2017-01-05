<?php
include_once( dirname(__FILE__)  . '/HttpApi.php'  );

$test_1 = HttpApi::post('RoomMgr', 'getAuthToken', array(
    'room_id' => 73,
    'expire' => 1000,
    'uid' => '234234',
    'nick' => 'ttt',
    'ava' => ''
));
echo 'teste1 ', json_encode($test_1);


$test_2 = HttpApi::post('JiaoYuUserInfo', 'listWisDoc', array(
    'token' => $test_1['Info'],
    'page' => 1,
    'num' => 20,
));
echo 'test_2 ', json_encode($test_2);
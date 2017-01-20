<?php
include_once( dirname(__FILE__)  . '/HttpApi.php'  );

$test_1 = HttpApi::post('RoomMgr', 'getAuthToken', array(
    'room_id' => 73,
    'expire' => 1000,
    'uid' => '234234',
    'nick' => 'ttt',
    'ava' => ''
));
echo 'test_1 ', json_encode($test_1), "\n";


$test_2 = HttpApi::post('JiaoYuUserInfo', 'listWisDoc', array(
    'token' => $test_1['Info'],
    'page' => 1,
    'num' => 20
));
echo 'test_2 ', json_encode($test_2), "\n";

$mps = HttpApi::post('RoomVideo', 'newMpsPlayerByVod', array(
    'vod_id' => "585900228894efebbb0008af", 
    'vod_type' => 'upload', 
    'vod_size' => 'm3u8_360', 
    'config' => array(
        'surfaceType' => 2,
        'surfaceUrl' => 'http://www.google.cn/landing/cnexp/google-search.png',
    ), 
    'mps_id' => 1593,
    'admin_id' => 280,
));
echo 'mps ', json_encode($mps), "\n";
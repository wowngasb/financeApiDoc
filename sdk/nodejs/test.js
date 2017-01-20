var HttpApi = require('./HttpApi.js');

HttpApi.post('RoomMgr', 'getAuthToken', {
    'room_id': 73,
    'expire': 1000,
    'uid': '234234',
    'nick': 'ttt',
    'ava': ''
}, function(test_1) {
    console.log('test_1', JSON.stringify(test_1));
    HttpApi.post('JiaoYuUserInfo', 'listWisDoc', {
        'token': test_1.Info,
        'page': 1,
        'num': 20
    }, function(test_2) {
        console.log('test_2', JSON.stringify(test_2));
    });
});
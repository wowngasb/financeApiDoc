# -*- coding: utf-8 -*-
from HttpApi import HttpApi

def main():

    test_1 = HttpApi.post('RoomMgr', 'getAuthToken', {
        'room_id': 73,
        'expire': 1000,
        'uid': '234234',
        'nick': 'ttt',
        'ava': ''
    })
    print 'test_1', test_1

    test_2 = HttpApi.post('JiaoYuUserInfo', 'listWisDoc', {
        'token': test_1.get('Info', ''),
        'page': 1,
        'num': 20
    })
    print 'test_2', test_2


if __name__ == '__main__':
    main()
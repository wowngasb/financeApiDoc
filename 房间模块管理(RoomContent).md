# 房间模块管理 RoomContent

房间自定义模块管理 相关操作

## 获取模块列表(getRoomContentList)

请求方式 GET POST  不需要认证

获取模块列表

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomContent/getRoomContentList" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomContent/getRoomContentList',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| --------------------- | ------------------------------------------------ |
| room_id           | `int`  房间id    |
| content_type      | `string`  区块类型   手机菜单自定义内容  mobile_menu_custom      |
| state              | `int`  状态  1正常  7预览  9删除  默认为 1  |

> 返回结果如下:

```
{
    "Flag": 100,
    "rows": [
        {
            "content_id": 2,
            "room_id": 147,
            "content_type": "mobile_menu_cust",
            "content_title": "菜单二",
            "content_html": "<p>123456789</p>",
            "content_text": "123456789",
            "content_config": [],
            "rank": 200,
            "state": 1,
            "create_time": "2017-05-22 13:34:25",
            "uptime": "2017-05-22 13:36:10"
        },
        //......
    ],
    "results": 3
}
```


## 获取区块信息(getRoomContent)

请求方式 GET POST 不需要认证

获取区块信息

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomContent/getRoomContent" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomContent/getRoomContent',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| content_id          | `int`  区块id               |

> 返回结果如下:

```
{
    "Flag": 100,
    "Info": {
        "content_id": 8,
        "room_id": 147,
        "content_type": "mobile_menu_cust",
        "content_title": "菜单三",
        "content_html": "<p>123456789</p>",
        "content_text": "123456789",
        "content_config": [],
        "rank": 200,
        "state": 1,
        "create_time": "2017-05-22 13:39:49",
        "uptime": "2017-05-22 13:43:04"
    },
    "FlagString": "获取成功"
}
```

## 新增房间区块内容(newRoomContent)

请求方式 GET POST 需要认证

新增房间区块内容    需要子公司自身或所属总公司权限 

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomContent/newRoomContent" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomContent/newRoomContent',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id           | `int`  房间id    |
| content_type      | `string`  区块类型   手机菜单自定义内容  mobile_menu_custom      |
| content_title      | `string`  区块标题      |
| content_html      | `string`  区块内容 html     |
| content_text      | `string`  区块内容 text     |
| content_config      | `array`  区块内容 json     |
| state              | `int`  状态  1正常  7预览  9删除  默认为 1  |
| rank              | `int`  排序值  默认为 100  |

> 返回结果如下:

```
{
    "Flag": 100,
    "Info": {
        "content_id": 9,
        "room_id": 147,
        "content_type": "mobile_menu_cust",
        "content_title": "菜单四",
        "content_html": "abcd",
        "content_text": "abcd",
        "content_config": [],
        "rank": 100,
        "state": 1,
        "create_time": "2017-05-22 14:12:39",
        "uptime": "2017-05-22 14:14:17"
    },
    "FlagString": "添加成功"
}
```


## 修改区块信息(setRoomContent)

请求方式 GET POST 需要认证

修改区块信息  需要子公司自身或所属总公司权限 

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomContent/setRoomContent" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomContent/setRoomContent',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| content_id          | `int`  区块id               |
| content_title      | `string`  区块标题      |
| content_html      | `string`  区块内容 html     |
| content_text      | `string`  区块内容 text     |
| content_config      | `array`  区块内容 json     |
| rank              | `int`  排序值  默认为 100  |

> 返回结果如下:

```
{
    "Flag": 100,
    "Info": {
        "content_id": 9,
        "room_id": 147,
        "content_type": "mobile_menu_cust",
        "content_title": "菜单四",
        "content_html": "abcd",
        "content_text": "abcd",
        "content_config": [],
        "rank": 100,
        "state": 1,
        "create_time": "2017-05-22 14:12:39",
        "uptime": "2017-05-22 14:14:17"
    },
    "FlagString": "修改成功"
}
```


## 修改区块状态(stateRoomContent)

请求方式 GET POST 需要认证

修改区块状态  需要子公司自身或所属总公司权限 

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomContent/stateRoomContent" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomContent/stateRoomContent',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| content_id          | `int`  区块id               |
| state              | `int`  状态  1正常  7预览  9删除  默认为 1  |

> 返回结果如下:

```
{
    "Flag": 100,
    "Info": {
        "content_id": 9,
        "room_id": 147,
        "content_type": "mobile_menu_cust",
        "content_title": "菜单四",
        "content_html": "abcd",
        "content_text": "abcd",
        "content_config": [],
        "rank": 100,
        "state": 1,
        "create_time": "2017-05-22 14:12:39",
        "uptime": "2017-05-22 14:14:17"
    },
    "FlagString": "修改成功"
}
```
# MPS播放器设置功能 MpsMgr

MPS播放器设置功能相关操作

## 新建播放器(newMpsItem)

请求方式 GET POST 需要认证

根据admin_id创建Mps播放器
```shell
curl -X "POST" "http://finance.aodianyun.com/api/MpsMgr/newMpsItem" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/MpsMgr/newMpsItem',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  需要设置的子公司admin_id                     |
| name             | `string`  播放器名称                    |
| style             | `int`  播放器样式 默认1                    |

```
{
    "Flag": 100,
    "FlagString": "修改api key成功",
}
```

## 获取播放器信息(listMpsItem)

请求方式 GET POST 需要认证

获取指定admin_id Mps播放器信息

```shell
curl -X "POST" "http://finance.aodianyun.com/api/MpsMgr/listMpsItem" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/MpsMgr/listMpsItem',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  需要设置的子公司admin_id                     |
```
{
    "Flag": 100,
    "Info": [
        {
           //修改后的mps实例信息 参见接口getMpsItem
            },
            "isDefault": "1",
            "addTime": "1469609578",
            "upTime": "1469609578",
            "mps_id": "36"
        },
        ...
    ],
    "mps_item_list": [
        {
            "mps_id": "36",
            "name": "默认播放器"
        },
        ...
    ]
}
```

## 设置logo(editLogo)

请求方式 GET POST 需要认证

设置MPS的logo

```shell
curl -X "POST" "http://finance.aodianyun.com/api/MpsMgr/editLogo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/MpsMgr/editLogo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  需要设置的子公司admin_id                     |
| mps_id             | `int`  播放器id                    |
| logoPosition             | `string`  right 右侧 center 中间 left 左侧                    |
| adveReAddr             | `string`  点击跳转链接(完整链接地址)                   |

```
{
    "Flag": 100,
    "FlagString": "操作成功",
    "new_config": {
        "logoAddr": "367a711d2b5fc83755a4bf76dd58a0db",
        "logoPosition": "center",
        "adveReAddr": "http://www.baidu.com"
    },
    "last_config": {
        "logoAddr": "367a711d2b5fc83755a4bf76dd58a0db",
        "logoPosition": "right",
        "adveReAddr": ""
    },
    "new_name": "测试",
    "last_name": "测试",
    "Info": {
        "Flag": 100,
        "FlagString": "查询成功",
        "Info": {
           //修改后的mps实例信息 参见接口getMpsItem
            },
            "isDefault": "0",
            "addTime": "1482916581",
            "upTime": "1482918734"
        },
        "_uptime_": 1482918733
    }
}
```


## 清除logo(clearLogo)

请求方式 GET POST 需要认证

清除MPS的logo

```shell
curl -X "POST" "http://finance.aodianyun.com/api/MpsMgr/clearLogo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/MpsMgr/clearLogo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  需要设置的子公司admin_id                     |
| mps_id             | `int`  播放器id                    |

```
{
    "Flag": 100,
    "FlagString": "操作成功",
    "new_config": {
        "logoAddr": "",
        "logoPosition": "",
        "adveReAddr": ""
    },
    "last_config": {
        "logoAddr": "367a711d2b5fc83755a4bf76dd58a0db",
        "logoPosition": "center",
        "adveReAddr": "http://www.baidu.com"
    },
    "new_name": "测试",
    "last_name": "测试",
    "Info": {
        "Flag": 100,
        "FlagString": "查询成功",
        "Info": {
            //修改后的mps实例信息 参见接口getMpsItem
        },
        "_uptime_": 1482918963
    }
}
```

## 设定名称(editName)

请求方式 GET POST 需要认证

设定播放器名称

```shell
curl -X "POST" "http://finance.aodianyun.com/api/MpsMgr/editName" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/MpsMgr/editName',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  需要设置的子公司admin_id                     |
| mps_id             | `int`  播放器id                    |
| name             | `string`  播放器名称                   |

```
{
    "Flag": 100,
    "FlagString": "操作成功",
    "new_config": {
        "logoAddr": "",
        "logoPosition": "",
        "adveReAddr": ""
    },
    "last_config": {
        "logoAddr": "",
        "logoPosition": "",
        "adveReAddr": ""
    },
    "new_name": "测试",
    "last_name": "等噶欧云舞若",
    "Info": {  //修改后的mps实例信息 参见接口getMpsItem
        },
        "_uptime_": 1482919150
    }
}
```




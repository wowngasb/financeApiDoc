# 播放器管理 MpsMgr

MPS播放器设置功能相关操作

## 新建播放器(newMpsItem)

请求方式 GET POST 需要认证

根据admin_id 创建Mps播放器

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
| admin_id          | `int`  需要设置的子公司admin_id                     |
| name             | `string`  播放器名称                    |
| style             | `int`  播放器样式 默认1                    |

```
{
    "Flag": 100,
    "FlagString": "创建成功",
    "Info": [  // 创建成功之后  当前已存在的播放器列表
        {
            "mps_id": "36",
            "name": "默认播放器"
        },
        ......
    ]
}
```

## 列出播放器(listMpsItem)

请求方式 GET POST 需要认证

获取指定admin_id 已创建的播放器列表

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
| admin_id             | `int`  指定的子公司admin_id                     |

```
{
    "Flag": 100,
    "mps_item_list": [
        {
            "mps_id": "36",  // 播放器唯一标识id
            "name": "默认播放器"  // 播放器名称
        },
        ...
    ]
}
```


## 获取播放器信息(getMpsItem)

请求方式 GET POST 需要认证

获取指定mps_id的播放器的详细信息

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
| admin_id             | `int`  指定的子公司admin_id                     |

```
{
    "Flag": 100,
    "FlagString": "查询成功",
    "Info": {
        "id": "1587",
        "uin": "1436",
        "name": "测试",
        "style": "2",
        "config": {  // 播放器详细配置
            "watermarkPosition": "",    //浮层图片位置1
            "watermarkPosition2": "",   //浮层图片位置2
            "watermark2": "",      //浮层图片2
            "watermark": "",    //浮层图片1
            "supernatantword": "",   //浮层文字
            "displayfrequen": "",   //浮层文字 显示频率
            "scrollposition": "",   //浮动文字 滚动位置
            "logoPosition": "left",  // logo位置  right 右侧 center 中间 left 左侧    
            "adveReAddr": "",  // logo 点击跳转链接
            "logoAddr": "http://pic.aodianyun.com/aodianyun/mps/logo/b4413fa2dcb00868004e3ad85eabbe65/0/0",  //logo图片地址
            "backgroundimage": ""  
        },
        "isDefault": "0",
        "addTime": "1482916581",
        "upTime": "1482977511"
    }
}
```

## 设置logo(editLogo)

请求方式 GET POST 需要认证

设置MPS播放器的logo

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
| logoPosition       | `string`  logo位置  right 右侧 center 中间 left 左侧                    |
| adveReAddr       | `string`  点击跳转链接(完整链接地址)                   |
| logoAddr_bytes   | `string`   图片文件具体内容 使用base64编码  |

```
{
    "Flag": 100,
    "FlagString": "操作成功",
    "Info": {
        "Flag": 100,
        "FlagString": "查询成功",
        "Info": {},   //修改后的mps实例信息 参见接口getMpsItem
    }
}
```


## 清除logo(clearLogo)

请求方式 GET POST 需要认证

清除MPS播放器的logo

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
    "Info": {
        "Flag": 100,
        "FlagString": "查询成功",
        "Info": {},  //修改后的mps实例信息 参见接口getMpsItem
        "_uptime_": 1482918963
    }
}
```

## 设定名称(editName)

请求方式 GET POST 需要认证

修改MPS播放器的名称

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
    "Info": { },  //修改后的mps实例信息 参见接口getMpsItem
    }
}
```




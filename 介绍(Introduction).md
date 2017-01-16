# 介绍 Introduction

欢迎使用 金融解决方案 开放 API

接口地址：http://finance.aodianyun.com/api/{{API所在模块}}/{{具体需要调用的API}}

接口返回 `json` 格式的数据, 默认包含 `Flag` 和 `FlagString` 两个字段，成功时 `Flag==100` ，失败时 `Flag!=100` ，并有 `FlagString` 表示失败原因

[文档 GitHub](https://github.com/aodianyunGroup/financeApiDoc)

[DEMO GitHub](https://github.com/aodianyunGroup/financeWebSDK)

POST参数支持 `application/json` 和 `application/x-www-form-urlencoded` 两种封装格式，中文编码使用utf-8

所有接口均支持 `HTTP` 和 `HTTPS`

已集成常见后端开发语言SDK [SDK Github](https://github.com/aodianyunGroup/financeApiDoc/tree/master/sdk)

## 认证

部分接口需认证授权，请联系工作人员获取 API_KEY

API_KEY 调用接口的权限等同于对应管理员帐号

使用 API_KEY 访问 api 时需要在 http 的 header 中设置认证参数，格式为

`Authorization: dyyadmin:{{API_KEY}}`

`Accept: application/json`

发送请求时需设置

`Content-Type: application/x-www-form-urlencoded; charset=UTF-8`

或者

`Content-Type: application/json; charset=UTF-8`


# 错误处理 ErrorCode

API 可能返回以下错误:

| Error Code               | Meaning                                             |
| ---------------------------- | ----------------------------------------------------------- |
| 400                      | Bad Request 请求格式错误，请查阅对应的文档条目                  |
| 401                      | bad credentials – access token 过期，或请求的API超过授权     |
| 403                      | Forbidden 访问被拒绝 或短时间内请求次数过多                    |
| 404                      | Not Found 调用的 API 不存在，请查看本文档                    |
| 405                      | Method Not Allowed 请求 method 错误， 请查阅对应的文档条目 |
| 406                      | Not Acceptable 请求不是 json 格式                        |
| 500                      | Internal Server Error 服务器错误，请联系客服                   |
| 503                      | Service Unavailable 服务器暂时下线，请稍候重试                 |

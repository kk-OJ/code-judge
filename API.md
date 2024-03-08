# code-judge 接口文档

### 获取签名密钥

- 请求url：`http://后端ip:3000/api/getApiKey`

- 请求方式：`GET`

- 请求头：无

- 请求参数：无

- 请求结果示例：

  - 成功：code为 `200`，status为 `success`

    ```json
    {
        "status": "success",
        "code": 200,
        "info": "获取API签名密钥成功",
        "data": {
            "SecretKey": "yNe/7SiLfq+jWbZH7Y2Lw12lT3zSot+cvPKJMxK5C0/PdmIsTgDQ1366A7H/iqF488Ty62DawVNyGsyyAHX/vtpYK+rC1zA/qq6aDLXLnnI=",
            "AccessKey": "1709890945214-15955a1a-8915-4f11-aed5-d6f9641f9eb9-1709894545214"
        }
    }
    ```

  - 失败：

    ```json
    {"status":"error","code":403,"info":"访问频率超出限制","data":null}
    ```

### 执行代码

- 请求url：`http://后端ip:3000/api/execode`

- 请求方式：`POST`

- 请求头：`Authorization`

  - 格式：`Bearer AccessKey SecretKey`

  - 示例：

    ```markdown
    Authorization:
    Bearer 1709890945214-15955a1a-8915-4f11-aed5-d6f9641f9eb9-1709894545214 yNe/7SiLfq+jWbZH7Y2Lw12lT3zSot+cvPKJMxK5C0/PdmIsTgDQ1366A7H/iqF488Ty62DawVNyGsyyAHX/vtpYK+rC1zA/qq6aDLXLnnI=
    ```

- 请求参数：

  | 参数名      | 含义            | 类型   | 默认值 | 取值范围                            |
  | ----------- | --------------- | ------ | ------ | ----------------------------------- |
  | code        | 代码内容        | String | 必传   | 最大值为 64KB                       |
  | lang        | 代码语言        | String | 必传   | java/c++/c/python/javascript/golang |
  | input       | 输入数据        | Array  | [""]   | /                                   |
  | timeLimit   | 限制时间 (毫秒) | Long   | 1000ms | 最大值为 5000ms                     |
  | memoryLimit | 限制内存 (字节) | Long   | 256MB  | 最大值为 512MB                      |

- 请求结果示例：

  - 成功：code为 `200`，status为 `success`

    ```json
    {
        "status": "success",
        "code": 200,
        "info": "执行成功",
        "data": {
            "executeType": "执行成功",
            "executeDetail": "代码执行成功",
            "stdin": [
                "1 2"
            ],
            "stdout": [
                "3\n"
            ],
            "stderr": [
                ""
            ],
            "time": 179,
            "memory": 225280
        }
    }
    ```

  - 失败：

    ```json
    {"status":"error","code":403,"info":"访问频率超出限制","data":null}
    ```
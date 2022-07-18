# DDD架构Demo

- `bootstrap` : 启动层
- `web-home` : WEB展示层，用于处理前端请求(相当于controller层)，不做业务逻辑
- `biz` : 业务层
    - `biz-shared` : 业务编排层，将一些简单的业务编排成复杂的业务
    - `service-facade-impl` : 外观层，提供内部使用的RPC接口
- `core` : 核心领域层
    - `core-service` : 提供复用度高的业务服务
    - `core-model` : 为core层提供BO (Param & Model)
    - `core-service-integration` : 集成外部服务
- `common` : 基础层
    - `common-dal` : 存放Mapper和DO，与数据库交互
    - `common-util` : 为项目提供一些通用工具
    - `common-service-facade` : 外观层的接口

目标：解耦，提高复用，层次分明


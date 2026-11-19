# maven-git-lab

软件工程专业《编程实践（二）》团队项目：用 Maven 构建、由 Maven 管理依赖，并用 Git 完成协作开发。

## 项目坐标

| 项目 | 内容 |
| --- | --- |
| groupId | com.hyj |
| artifactId | maven-git-lab |
| version | 1.0.0 |
| packaging | jar |

## 目录结构

```
maven-git-lab/
├─ pom.xml              项目描述文件（坐标、依赖、编译级别）
├─ src/main/java/       源码目录（App、util.DbUtil、util.ConfigUtil）
├─ src/main/resources/  资源目录（db.properties、log4j.properties）
├─ src/test/java/       测试源码目录（AppTest）
└─ target/              构建输出目录（Maven 生成）
```

## 构建与运行

```bash
mvn clean package     # 编译、跑单元测试并打包
mvn exec:java         # 或在 IDEA 中直接运行 com.hyj.lab.App
```

## 依赖

- mysql-connector-j 9.1.0：JDBC 驱动
- junit 4.13.2：单元测试
- log4j 1.2.17：日志

## 协作方式

远程仓库托管在 GitHub，仓库所有者是 yunshaoyou，合作者 A-song233 在
Settings → Collaborators 中获得了 Write 权限；双方以 master 分支为主线，
提交前先 `git pull` 拉取远程更新，避免非快进推送被拒绝。

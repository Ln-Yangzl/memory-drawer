## ootlab

实现⼀个根据绘图指令在内存中绘图的程序，程序读⼊写在脚本⽂件中的指令，打印后给出输出的结果。

### 环境

JDK 11

Maven 3.6.3

IntelliJ IDEA 2021.1.3

### 项目结构

├─src
    ├─main
    │  ├─java
    │  │  └─org
    │  │      └─zlyang
    │  │          └─memoryDrawer		--- 项目主文件夹
    │  │              ├─board					--- 内存画板
    │  │              ├─service					--- 运行服务
    │  │              │  └─parser	
    │  │              ├─command				--- 命令类
    │  │              └─utils						--- 工具类
    │  └─resources					--- 存放测试脚本及输出内容
    │      ├─out							--- 存放手动测试输出内容文件夹
    │      └─testScripts				--- 自动测试脚本依赖文件
    └─test
        └─java
            └─org
                └─zlyang
                    └─memoryDrawer	--- 测试文件夹
                       ├─board				--- board的组件测试
                       ├─drawer			--- drawer的组件测试
                       ├─serviceTest	--- service的组件测试
                       └─system				--- line，text，undo等命令的自动测试脚本

### 自动测试用例运行步骤

#### 使用maven生命周期测试

![image-20220509153230312](https://ln-markdown-image-bucket.oss-cn-beijing.aliyuncs.com/img/image-20220509153230312.png)

#### 使用junit的testSuite进行测试

##### 对各个组件进行单元测试

运行ComponentTestSuite，对Board，Drawer，Service等各个组件进行测试：

![image-20220509153603043](https://ln-markdown-image-bucket.oss-cn-beijing.aliyuncs.com/img/image-20220509153603043.png)

##### 对各个命令进行单元测试

运行CommandTestSuite，对Line，Text，Undo等命令进行逐一测试：

![image-20220509153727819](https://ln-markdown-image-bucket.oss-cn-beijing.aliyuncs.com/img/image-20220509153727819.png)

### 手工测试用例运行步骤

运行Main，配置Main的参数输入，调用resources下的scripte.txt进行手工测试，输出在resources/out文件夹下

![image-20220509153927725](https://ln-markdown-image-bucket.oss-cn-beijing.aliyuncs.com/img/image-20220509153927725.png)

![image-20220509154032314](https://ln-markdown-image-bucket.oss-cn-beijing.aliyuncs.com/img/image-20220509154032314.png)

运行该配置，可得到resources/out/script1.txt

该文件展示了输出内容


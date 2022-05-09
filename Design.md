## ootlab设计分析

该lab总体设计框架采用了命令模式，client作为命令调用者，Board（内存画板）作为命令接受者，同时有CommandReader，CommandParser，CommandExecuter作为辅助。

项目整体架构：

<img src="https://ln-markdown-image-bucket.oss-cn-beijing.aliyuncs.com/img/image-20220509154828360.png" alt="image-20220509154828360" style="zoom:200%;" />

### 采用命令模式对命令进行处理

#### 命令模式结构

![image-20220509160624361](https://ln-markdown-image-bucket.oss-cn-beijing.aliyuncs.com/img/image-20220509160624361.png)

这里Main即为Clinet，同时又兼任了调用者的职责

CommandExecutor负责执行命令，同时为undo, redo的功能提供支持

#### 命令体系

![image-20220509161000267](https://ln-markdown-image-bucket.oss-cn-beijing.aliyuncs.com/img/image-20220509161000267.png)

与lab中的命令一一对应

### 命令解析及构建流程

![image-20220509161247906](https://ln-markdown-image-bucket.oss-cn-beijing.aliyuncs.com/img/image-20220509161247906.png)

数据流动过程如下

![image-20220509161729534](https://ln-markdown-image-bucket.oss-cn-beijing.aliyuncs.com/img/image-20220509161729534.png)

CommandParser对于不同的命令，利用函数式编程和策略模式，进行解析

![image-20220509162225518](https://ln-markdown-image-bucket.oss-cn-beijing.aliyuncs.com/img/image-20220509162225518.png)

```java
//parser构建
private static final Map<CmdType, BiFunction<String, CommandParser, Command>> parser = new HashMap<>();
static {
    parser.put(CmdType.LINE, new LineParser());
    parser.put(CmdType.TEXT, new TextParser());
    parser.put(CmdType.COLOR, new ColorParser());
    parser.put(CmdType.MACRO_CALL, new MacroCallParser());
    parser.put(CmdType.MACRO_DEFINE, new MacroDefineParser());
    parser.put(CmdType.REDO, new RedoParser());
    parser.put(CmdType.UNDO, new UndoParser());
}

//LineParser
public class LineParser implements BiFunction<String, CommandParser, Command> {

    @Override
    public Command apply(String s, CommandParser parser) {
        List<Integer> args = Arrays.stream(s.substring(s.indexOf('(') + 1, s.indexOf(')'))
                .split(","))
                .map(String::stripLeading)
                .map(String::stripTrailing)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return new LineCommand(args.get(0), args.get(1), args.get(2), args.get(3));
    }
}

//命令解析
Command command = parser.get(CmdType.getType(commandString)).apply(commandString, this);	
```


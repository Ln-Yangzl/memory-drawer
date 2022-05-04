package utils;

/**
 * @author: zlyang
 * @date: 2022-05-03 10:48
 * @description:
 */
public enum CmdType {

    /**
     *
     */
    MACRO_DEFINE("#"),
    MACRO_CALL("!"),
    LINE("line"),
    TEXT("text"),
    COLOR("color")
    ;

    public static CmdType getType(String s){
        s = s.split("\\n")[0];
        for (CmdType value : CmdType.values()) {
            if(s.contains(value.getName())){
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CMD type of input string:\n" + s);
    }

    CmdType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final String name;
}

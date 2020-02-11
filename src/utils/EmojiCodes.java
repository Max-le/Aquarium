package utils;

public enum EmojiCodes {
    HERBIVORE("\uD83D\uDC1F"),
    CARNIVORE("\uD83E\uDD88"),
    WEED("\uD83C\uDF43"),
    DEAD("\u271D");

    private String code;
    EmojiCodes(String code) {
        this.code = code;
    }
    public String code(){
        return code;
    }
}

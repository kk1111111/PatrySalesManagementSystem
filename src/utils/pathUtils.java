package utils;

public class pathUtils {//取得图片文件的文件路径的工具
    private static final String Path = "images\\";
    public static String getRealPath(String path){
        return Path+path;
    }
}

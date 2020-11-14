package chess.entity;

import java.io.Serializable;

/**
 * @PackgeName: chess.entity
 * @ClassName: FootStyle
 * @Author: XuWen
 * Date: 2020/10/31 0:24
 * Introduce:针对pane中的每个文字对象进行封装
 */
public class FontStyle implements Serializable {
    private static final long serialVersionUID = 8766365277097628924L;

    //每一个FontStyle里面都只会是一个文字或者一个图片
    //如果是文字，就不会是图片，如果是图片就不会是文字
    private String content;
//    private int size;
//    private String color;
    private String path;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

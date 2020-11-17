package chess.board;

import chess.entity.FontStyle;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: chess.board
 * @ClassName: FontSupport
 * @Author: XuWen
 * Date: 2020/10/31 0:09
 * Introduce:文字支持类，将textPanel中的文档内容取出做处理
 */
public class FontSupport {

    /**
     * 将发送区域的文字封装成对象
     * @param textPane  发送区
     * @return
     */
    public static List<FontStyle> footEncode(JTextPane textPane){
        Document document = textPane.getDocument(); //得到文档
        List<FontStyle> list = new ArrayList<>();   //存放发送区每一个文字
        //对每一个文字进行单独的处理
        for(int i=0;i<document.getLength();i++){
            try {
                StyledDocument sd = textPane.getStyledDocument();
                FontStyle font = new FontStyle();
                Element e = sd.getCharacterElement(i);
                if(e instanceof AbstractDocument.LeafElement){
                    if(e.getName().equals("content")){  //那么就是文字
                        font.setContent(sd.getText(i,1));
                    }else if(e.getName().equals("icon")){   //这就是图片
                        font.setPath(e.getAttributes().getAttribute(StyleConstants.IconAttribute).toString());

                    }
                }
                list.add(font);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 将文字内容对象，赋值到接收框上面
     * @param textPane  接收框
     * @return
     */
    public static void footDecode(JTextPane textPane,List<FontStyle> list,String userName){
        Document doc = textPane.getDocument();
        //添加一个可以设置样式的类
        StyleContext sc = StyleContext.getDefaultStyleContext();
        //为所添加的样式类添加字体颜色
        AttributeSet asetLine = sc.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground, Color.BLACK);
        try {
            doc.insertString(doc.getLength(),"\n"+userName+"说：",asetLine);

        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        for(FontStyle zi:list){
            if(zi!=null) {
                //得到编辑器中的文档
                if (zi.getContent() != null) {
                    try {

                        //为所添加的样式类添加字体颜色
                        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLACK);
                        //为添加的样式类添加字体
                        doc.insertString(doc.getLength(), zi.getContent(), aset);
                    }catch(BadLocationException e){
                        e.printStackTrace();
                    }
                }else {
                    textPane.setCaretPosition(doc.getLength());
                    textPane.insertIcon(new ImageIcon(zi.getPath()));
                }
            }
        }
    }
}

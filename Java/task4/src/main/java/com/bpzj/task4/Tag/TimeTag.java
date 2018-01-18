package com.bpzj.task4.Tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTag extends TagSupport implements JspTag {

    /**
     * 在jsp文件中，使用本标签时传入的值
     * 这里传入的是一个 long 类型的表示时间的值
     *
     * 参考 c:out 标签 ＜c:out value=""/＞ 假如，这里是
     * ＜c:out value="${time}"/＞ 就会取出 ${time} 的值
     * 传给标签，也就是传给类的 setValue 方法，赋值
     */
    private String value;

    private String pattern;

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setValue(String value) {
        this.value= value;
    }


    // 应该是在 doEndTag 方法中转换时间，标准库的 <fmt:formatDate> 也是这样做的
    @Override
    public int doEndTag() throws JspException {


        // ***********************************************************************************
        // 入参判断，如果没有传入pattern，使用默认值
        String formatted = null;
        if (pattern != null) {
            formatted = pattern;
            } else { formatted = "yyyy-MM-dd HH:mm:ss";}


        // ***********************************************************************************
        // 使用Date模块获取时间，并格式化为字符串
        long time = Long.valueOf(value);
        Date date =new Date(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatted);
        String formattedTime = dateFormat.format(date);


        // ***********************************************************************************
        // 使用 Calendar 获取时间
        // long time = Long.valueOf(value);
        // Calendar calendar = Calendar.getInstance();
        // calendar.setTimeInMillis(time);
        // SimpleDateFormat dateFormat = new SimpleDateFormat(formatted);
        // 得到格式化的时间
        // String formattedTime = dateFormat.format(calendar.getTime());


        // ************************************************************************
        // 输出 字符串到jsp文件
        try {
            // 使用 pageContext.getOut().write 向 jsp 文件写入内容
            pageContext.getOut().write(formattedTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doEndTag();
    }
}

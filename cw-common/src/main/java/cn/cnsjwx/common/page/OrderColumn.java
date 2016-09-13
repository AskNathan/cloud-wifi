package cn.cnsjwx.common.page;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 字段排序
 * Created by Nathan on 2016-08-23.
 */
public class OrderColumn {

    private String order;
    private String sort;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return camel4underline(sort).toUpperCase();
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public static String camel4underline(String param) {
        Pattern p = Pattern.compile("[A-Z]");
        if (param == null || param.equals("")) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param);
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() + i, mc.end() + i, "_" + mc.group().toLowerCase());
            i++;
        }

        if ('_' == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }
}

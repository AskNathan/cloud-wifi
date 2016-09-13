package cn.cnsjwx.common.page;
import cn.cnsjwx.common.logger.SimpleLogger;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Nathan on 2016-08-23.
 */
public class JcUtil {

    private static SimpleLogger logger = SimpleLogger.getLogger();

    // 去除字符串中的特殊符号
    public static String replaceHtmlSymbols(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        return str.trim().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;");
    }

    // 封装每页数据大小
    public static void formatPageSize(String pageNo, String limit, Page<?> page) {
        try {
            if (StringUtils.isNotBlank(pageNo)) {
                page.setPageNo(Integer.parseInt(pageNo));
            }
            if (StringUtils.isNotBlank(limit)) {
                page.setPageSize(Integer.parseInt(limit));
            }
        } catch (NumberFormatException e) {
            logger.error("page format excption for " + (page.getClass().getName()));
        }
    }
}
package com.qianyuan.core.freemarker;

import com.qianyuan.common.util.LoggerUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by rock on 2018-03-29
 */
public class FreeMarkerViewExtend extends FreeMarkerView {

    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        try {
            super.exposeHelpers(model, request);
        } catch (Exception e) {
            LoggerUtils.fmtError(FreeMarkerViewExtend.class,e, "FreeMarkerViewExtend 加载父类出现异常。请检查。");
        }
        /** 待添加*/
        model.put("basePath", request.getContextPath());//base目录。
    }
}

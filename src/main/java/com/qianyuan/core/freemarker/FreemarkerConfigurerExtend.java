package com.qianyuan.core.freemarker;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;

/**
 * Created by rock on 2018-03-29
 */
public class FreemarkerConfigurerExtend extends FreeMarkerConfigurer {

    @Override
    public void afterPropertiesSet() throws IOException, TemplateException {
        super.afterPropertiesSet();
        Configuration cfg = this.getConfiguration();
        putInitShared(cfg);
    }

    public static void put(Configuration cfg, String k, Object v) throws TemplateModelException {
        /*这一行是为了加入shiro的标签库到freemarker中*/
        cfg.setSharedVariable(k,v);
        cfg.setNumberFormat("#");
    }
    public static void putInitShared(Configuration cfg) throws TemplateModelException {
        put(cfg,"shiro", new ShiroTags());
    }
}

/*
Copyright [2020] [https://www.xiaonuo.vip]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：

1.请不要删除和修改根目录下的LICENSE文件。
2.请不要删除和修改Snowy源码头部的版权声明。
3.请保留源码和相关描述文件的项目出处，作者声明等。
4.分发源码时候，请注明软件出处 https://gitee.com/xiaonuobase/snowy
5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/xiaonuobase/snowy
6.若您的项目无法满足以上几点，可申请商业授权，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.kuarker.nacos.provider.util;


import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 默认分页参数构建
 *
 * @author yubaoshan
 * @date 2017/11/15 13:52
 */
public class PageFactoryUtil {

    /**
     * 每页大小（默认20）
     */
    private static final String PAGE_SIZE_PARAM_NAME = "pageSize";

    /**
     * 第几页（从1开始）
     */
    private static final String PAGE_NO_PARAM_NAME = "pageNum";
    /**
     * 排序字段，需要注意优先顺序
     */
    private static final String ORDER_ITEM_PARAM_NAME = "orderItem";

    /**
     * 默认分页，在使用时PageFactory.defaultPage会自动获取pageSize和pageNum参数
     *
     * @author xuyuxiang
     * @date 2020/3/30 16:42
     */
    public static <T> Page<T> defaultPage() {

        int pageSize = 20;
        int pageNo = 1;
        List<OrderItem> orderItemList = Lists.newArrayList();
        HttpServletRequest request = HttpServletUtil.getRequest();
        // header的长度和URI的情况是一样的。协议中并没有显示限制header的大小。理论上在header中放多少属性都是可以的
        //每页条数
        String pageSizeString = request.getHeader(PAGE_SIZE_PARAM_NAME);
        if (ObjectUtil.isNotEmpty(pageSizeString)) {
            pageSize = Integer.parseInt(pageSizeString);
        }
        // 第几页
        String pageNoStr = request.getHeader(PAGE_NO_PARAM_NAME);
        if (ObjectUtil.isNotEmpty(pageNoStr)) {
            pageNo = Integer.parseInt(pageNoStr);
        }

        //排序字段
        String orderItemStr = request.getHeader(ORDER_ITEM_PARAM_NAME);

        if (ObjectUtil.isNotEmpty(orderItemStr)) {
            try {
                String camelToUnderline = CamelToUnderlineUtil.change(orderItemStr);
                List<OrderItem> orderItems = JSON.parseArray(camelToUnderline, OrderItem.class);
                orderItemList.addAll(orderItems);
            } catch (Exception e) {
                throw new RuntimeException("排序字段序列化出错");
            }
        }

        Page<T> page = new Page<>(pageNo, pageSize);
        page.addOrder(orderItemList);
        return page;
    }

    /**
     * 驼峰命名字符串
     */
    static class CamelToUnderlineUtil {
        public static final char UNDERLINE = '_';
        public static final String EMPTY = "";

        public static boolean isBlank(CharSequence cs) {
            if (cs != null) {
                int length = cs.length();
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(cs.charAt(i))) {
                        return false;
                    }
                }
            }
            return true;
        }

        /**
         *  驼峰命名的字段转变成下划线字段
         * @param param 驼峰命名的字段
         * @return 下线字段
         */
        public static String change(String param) {
            if (isBlank(param)) {
                return EMPTY;
            }
            int len = param.length();
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++) {
                char c = param.charAt(i);
                if (Character.isUpperCase(c) && i > 0) {
                    sb.append(UNDERLINE);
                }
                sb.append(Character.toLowerCase(c));
            }
            return sb.toString();
        }
    }

    static class HttpServletUtil {

        /**
         * 获取当前请求的request对象
         *
         * @author xuyuxiang
         * @date 2020/3/30 15:10
         */
        public static HttpServletRequest getRequest() {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (requestAttributes == null) {
                throw new RuntimeException("获取请求参数异常");
            } else {
                return requestAttributes.getRequest();
            }
        }

        /**
         * 获取当前请求的response对象
         *
         * @author xuyuxiang
         * @date 2020/3/30 15:10
         */
        public static HttpServletResponse getResponse() {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (requestAttributes == null) {
                throw new RuntimeException("获取请求参数异常");
            } else {
                return requestAttributes.getResponse();
            }
        }
    }


}

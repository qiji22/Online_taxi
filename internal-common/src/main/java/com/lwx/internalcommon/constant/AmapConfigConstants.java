package com.lwx.internalcommon.constant;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-09-04  14:56
 */
public class AmapConfigConstants {

    /*
     * @description:路径规划地址
     **/
    public static final String DIRECTION_URL = "https://restapi.amap.com/v3/direction/driving";

    /*
     * @description:行政区域查询
     **/
    public static final String DISTRICT_URL = "https://restapi.amap.com/v3/config/district";
    /*
     * @description:新增服务
     **/
    public static final String SERVICE_ADD_URL = "https://tsapi.amap.com/v1/track/service/add";

    /*
     * @description: 添加新的终端（车辆）
     **/
    public static final String TERMINAL_ADD_URL = "https://tsapi.amap.com/v1/track/terminal/add";

    /*
     * @description:查询轨迹
     **/
    public static final String TERMINAL_SEARCH_URL = "https://tsapi.amap.com/v1/track/terminal/aroundsearch";

    /*
    添加新的轨迹
    * */
    public static final String TRACK_ADD_URL = "https://tsapi.amap.com/v1/track/trace/add";

    /*
添加新的轨迹点
* */
    public static final String POINT_UPLOAD_URL = "https://tsapi.amap.com/v1/track/point/upload";

    /*
     * @description:路径规划地址 json key值
     **/
    public static final String STATUS = "status";
    public static final String ROUTE = "route";
    public static final String PATHS = "paths";
    public static final String DISTANCE = "distance";
    public static final String DURATION = "duration";
    public static final String DISTRICTS = "districts";
    public static final String ADCODE = "adcode";
    public static final String NAME = "name";
    public static final String LEVEL = "level";
    public static final String STREET = "street";
}

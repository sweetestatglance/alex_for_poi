package com.alex.service.imp;

import com.alex.mapper.AlexDataServiceMapper;
import com.alex.service.AlexDataService;
import com.alex.utils.AlexExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlexDataServiceImp implements AlexDataService {

    @Autowired
    private AlexDataServiceMapper alexDataServiceMapper;


    @Override
    public List<Map<String, Object>> getdatalist() {
        //数据库表名
        String tabsqlname = AlexExcelUtils.getTableName(new Date());
        //本年
        Integer ye = AlexExcelUtils.getyear();
        //本月
        Integer mo = AlexExcelUtils.getmonth();
        //本月有多少天
        Integer days = AlexExcelUtils.monthhaveday(ye,mo);
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 1;i <= days;i ++){
            //按每天的数据去查
            Map<String, Object> map = new HashMap<>();
            //早8点
            String sqltm8 = ye + "-" + mo + "-" + i + " 08:00:00";
            //14
            String sqltm14 = ye + "-" + mo + "-" + i + " 14:00:00";
            //20
            String sqltm20 = ye + "-" + mo + "-" + i + " 20:00:00";

            if(i == 1){
                //如果是第一天
                //上月
                Integer mox = AlexExcelUtils.getmonth() - 1;
                //上月最后一天
                Integer daysx = AlexExcelUtils.monthhaveday(ye,mox);
                //拼接8点查询时间段，起始
                String tmstart = ye + "-" + mox + "-" + daysx + " 08:00:00";
                String tmsend = ye + "-" + mox + "-" + daysx + " 08:00:00";
                //
            }
        }



        return null;
    }
}

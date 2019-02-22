package work.lishubin.call.log.producer;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 用于生产数据
 * @author 李树彬
 * @date 2019/2/23  0:17
 */
public class CallLogProducer {

    private List<String> phoneList = new ArrayList<>();
    private Map<String, String> phoneNameMap = new HashMap<>();

    private static final String STARTTIME="2018-01-01";
    private static final String ENDTIME="2018-12-31";

    /**
     * 初始化phoneList和phoneNameMap
     */
    public void init(){

        phoneList.add("19239952227");
        phoneList.add("16772992184");
        phoneList.add("19816078067");
        phoneList.add("18827762917");
        phoneList.add("13531705838");
        phoneList.add("13003829830");
        phoneList.add("13497248058");
        phoneList.add("15492972666");
        phoneList.add("14745102443");
        phoneList.add("19744869991");
        phoneList.add("18993262883");
        phoneList.add("14986643893");
        phoneList.add("14719862244");
        phoneList.add("16994042427");
        phoneList.add("19912331206");
        phoneList.add("14481112882");
        phoneList.add("13271956359");
        phoneList.add("19065438700");
        phoneList.add("16343015852");
        phoneList.add("18388350233");
        phoneList.add("14367650818");
        phoneList.add("17233192471");
        phoneList.add("13969929325");
        phoneList.add("13842466221");
        phoneList.add("14235978319");


        phoneNameMap.put("19239952227","李雁");
        phoneNameMap.put("16772992184","卫艺");
        phoneNameMap.put("19816078067","仰莉");
        phoneNameMap.put("18827762917","陶欣悦");
        phoneNameMap.put("13531705838","施梅梅");
        phoneNameMap.put("13003829830","金虹霖");
        phoneNameMap.put("13497248058","魏明艳");
        phoneNameMap.put("15492972666","华贞");
        phoneNameMap.put("14745102443","华啟倩");
        phoneNameMap.put("19744869991","仲采绿");
        phoneNameMap.put("18993262883","卫丹");
        phoneNameMap.put("14986643893","戚丽红");
        phoneNameMap.put("14719862244","何翠柔");
        phoneNameMap.put("16994042427","钱溶艳");
        phoneNameMap.put("19912331206","钱琳");
        phoneNameMap.put("14481112882","缪静欣");
        phoneNameMap.put("13271956359","焦秋菊");
        phoneNameMap.put("19065438700","吕访琴");
        phoneNameMap.put("16343015852","沈丹");
        phoneNameMap.put("18388350233","褚美丽");
        phoneNameMap.put("14367650818","孙怡");
        phoneNameMap.put("17233192471","许婵");
        phoneNameMap.put("13969929325","曹红恋");
        phoneNameMap.put("13842466221","吕柔");
        phoneNameMap.put("14235978319","冯怜云");

    }


    /**
     * 生产通话记录数据
     * 数据格式为：
     * caller,callee,time,duration
     */
    public String product(){

        String result = null;

        try {
            // get caller callee
            String caller = phoneList.get((int) (Math.random()*phoneList.size()));
            String callee = null;
            String callerName = phoneNameMap.get(caller);

            while (true){
                callee = phoneList.get((int) (Math.random()*phoneList.size()));
                if (!callee.equals(caller)) {break;}
            }
            String calleeName = phoneNameMap.get(callee);

            //get time
            // parse STARTTIME and ENDTIME
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date startTime = simpleDateFormat.parse(CallLogProducer.STARTTIME);
            Date endTime = simpleDateFormat.parse(CallLogProducer.ENDTIME);
            long randomTimeStamp = startTime.getTime() + (long) ((endTime.getTime() - startTime.getTime()) * Math.random());

            simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
            String randomTime = simpleDateFormat.format(new Date(randomTimeStamp));


            long randomDurationStamp = (long) (30 * 60 * Math.random());
            DecimalFormat decimalFormat = new DecimalFormat("0000");
            String randomDuration = decimalFormat.format(randomDurationStamp);

            result = String.format("%s,%s,%s,%s,%s,%s",caller,callerName,callee,calleeName,randomTime,randomDuration);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;

    }









}

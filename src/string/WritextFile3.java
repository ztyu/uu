package string;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;


public class WritextFile3 {


    private static Map<String,String> blendMap = new HashMap<>();
    public static void readTxt(String filePath) {

        try {

            Map map = WechatConf.getWechatConfig();
            Map result = new HashMap();
            File file = new File(filePath);
            int count = 0;
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                StringBuilder s  = new StringBuilder();
                StringBuilder end  = new StringBuilder();
                while ((lineTxt = br.readLine()) != null) {
                    //String first = "\""+lineTxt.substring(1, 29)+"\"";
                    //System.out.println(lineTxt.trim());

                    String str = lineTxt;
                    if (str.length() == 0) {
                        continue;
                    }
                    String appId = str.substring(str.indexOf("appId=") + 6, str.indexOf(","));
                    if (appId.equals("null")) {
                        System.out.println(str);
                        continue;
                    }
                    String merchantId = str.substring(str.indexOf("merchantId=") + 11);
                   /* System.out.println(appId);
                    System.out.println(merchantId);*/
                    String weMerId = (String) map.get(appId);
                    if (!merchantId.equals(weMerId)) {
                        //System.out.println(str);
                        result.put(appId, merchantId);
                    }
                  /*  String[] first = lineTxt.split(",");
                    blendMap.put(first[0].trim(), "1");*/
                    //blendMap.put(lineTxt.trim(), "1");

                   /* count++;
                    System.out.println("count---" + blendMap.size());*/
                }
                result.forEach((k, v) -> System.out.println(k + "=" + v));
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("文件读取错误!");
        }

    }


    public static void main(String[] args) {
        String filePath = "C:\\Users\\yuzhengteng2\\Desktop\\11.txt";
        readTxt(filePath);
        /*String filePath2 = "C:\\Users\\yuzhengteng2\\Desktop\\2.txt";
        readTxt2(filePath2);*/

    }

    public static void readTxt2(String filePath) {

        StringBuilder builder = new StringBuilder();
        try {
            File file = new File(filePath);
            BigDecimal count = new BigDecimal(0);
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                StringBuilder s  = new StringBuilder();
                StringBuilder end  = new StringBuilder();
                while ((lineTxt = br.readLine()) != null) {
                    //String first = "\""+lineTxt.substring(1, 29)+"\"";
                    //System.out.println(lineTxt.trim());
                   /* if (!blendMap.containsKey(lineTxt.split(",")[0].trim())) {
                        builder.append(",").append(lineTxt.split(",")[0].trim());
                    }*/
                    String[] first = lineTxt.split(",");
                    if (!blendMap.containsKey(first[0].trim())) {
                        builder.append(",").append(first[0].trim());
                    }
                    count = count.add(new BigDecimal( first[1].trim()));
                    System.out.println(count+"---------++++++++++++------------");
                }
                System.out.println(builder);
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }

    }

    public enum WechatConf {

        /** 邮乐优鲜APP */
        ULE_UX_APP("wxa4e40e54ff7d77b7", "1584477011", "/wechat/wechat_1584477011.p12", "1584477011", "bfdbcae3147bc94b01b60e4923e5c295"),
        /** 邮乐APP */
        ULEAPP("wx3ef5581343645f6c", "1359541702", "/wechat/wechat_1359541702.p12", "1359541702", "1c7d3b31de53b14c147aa757cfb3bab6"),
        /** 掌柜APP */
        UBOSS("wx691bce5d24e8e9cd", "1507498681", "/wechat/wechat_1507498681.p12", "1507498681", "f2b10c57a30121f526621976d514d9bc"),
        /** 邮小店APP */
        YXD("wx50fce49d9bdada80", "1480329902", "/wechat/wechat_1480329902.p12", "1480329902", "3283edf4e4c83f4d0047c61b1b67024a"),
        /** 邮小店社区买菜APP */
        YXD_COMMUNITY("wxa4e40e54ff7d77b7", "1480329902", "/wechat/wechat_1480329902.p12", "1480329902", "3283edf4e4c83f4d0047c61b1b67024a"),
        YXD_COMMUNITY_MIN_PROGRAM("wx61b81426b15c5052", "1225586302", "/wechat/wechat_1225586302.p12", "1225586302", "Iv0neQAgA3pZhDwYSZgGcLWIYjz2UDbP"),
        /** 邮乐公众号 */
        ULEWAP("wx174a5809f2b70161", "1225586302", "/wechat/wechat_1225586302.p12", "1225586302", "Iv0neQAgA3pZhDwYSZgGcLWIYjz2UDbP"),
        /** 小程序 */
        BENEFIT_MIN_PROGRAM("wx6f5d3465913b34fb", "1225586302", "/wechat/wechat_1225586302.p12", "1225586302", "Iv0neQAgA3pZhDwYSZgGcLWIYjz2UDbP"),
        /** 邮乐商城小程序 */
        ULE_PROGRAM("wxbbd95efd68bc8a5e", "1225586302", "/wechat/wechat_1225586302.p12", "1225586302", "Iv0neQAgA3pZhDwYSZgGcLWIYjz2UDbP"),
        /** 微信公众号 */
        WECHAT_SUBSCRIPTION("wx2614c9bb0a8ddf45", "1225586302", "/wechat/wechat_1225586302.p12", "1225586302", "Iv0neQAgA3pZhDwYSZgGcLWIYjz2UDbP"),
        /** 小程序 */
        MIN_PROGRAM("wx49733049f2717950", "1225586302", "/wechat/wechat_1225586302.p12", "1225586302", "Iv0neQAgA3pZhDwYSZgGcLWIYjz2UDbP"),
        ULEAPP_OLD("wx6270c98aee233d11", "1250569301", "/wechat/wechat_1250569301.p12", "1250569301", "MIIDzTCCArWgAwIAAgIEAWb1BTANBgkq"),
        ULIFE("wx9a69b10a8aaa92be", "1251203601", "/wechat/wechat_1251203601.p12", "1251203601", "b4147c1b946b7a754c0596e44b04dd82"),
        ULIFE2("wx75ecb64dd0e76d34", "1364796002", "/wechat/wechat_1364796002.p12", "1364796002", "02db2d580453e345ed75bc613302d9f3"),
        PSBCSELFHTLP("wxfa0cd412db786796", "1364320302", "/wechat/wechat_1364320302.p12", "1364320302", "3309cd4kdbuuslke870ck987az08v7ef"),
        ;
        private String appId;
        private String merchantId;
        private String certPath;
        private String certPassword;
        private String appSecret;

        WechatConf(String appId, String merchantId, String certPath, String certPassword, String appSecret) {
            this.appId = appId;
            this.merchantId = merchantId;
            this.certPath = certPath;
            this.certPassword = certPassword;
            this.appSecret = appSecret;
        }

        public static Map getWechatConfig()  {
            //公众号支付
            Map<String, String> map = new HashMap<>();
            for (WechatConf c : WechatConf.values()) {
                map.put(c.appId, c.merchantId);

            }
            return map;

        }

        public String getAppId() {
            return appId;
        }

        public String getMerchantId() {
            return merchantId;
        }

        public String getCertPath() {
            return certPath;
        }

        public String getCertPassword() {
            return certPassword;
        }

        public String getAppSecret() {
            return appSecret;
        }
    }

}
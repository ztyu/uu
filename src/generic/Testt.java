package generic;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class Testt {

    @Test
    public void ge(){
        System.out.println(compareVersion("10.1.0","10.1.3"));
    }

    private int compareVersion(String newVersion, String oldVersion) {
        String[] newVersionArr = newVersion.split("\\.");
        String[] oldVersionArr = oldVersion.split("\\.");
        for (int i = 0; i < newVersion.length(); i++) {
            int compare = newVersionArr[i].compareTo(oldVersionArr[i]);
            if (compare != 0) {
                return compare < 0 ? -1 : 1;
            }
        }
        return -2;
    }

    @Test
    public  void urlcode() throws UnsupportedEncodingException {
        String xing = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCclXWbAIHB+SPd4trtg1I+/qXl FmQ1GqUVx89SwhlvTPIf5P/iuCFghKtLj0eu1U8FU9t1QfohP+DItit5BmZ3/hKO LH5rj8BE72W+FHTtJA6u/aVPPn/T4g9GlEOUUdOLZVOYMFROzcUQX0DPP/l4khos 2Y4DzvSszZLJbxFbRwIDAQAB";

        String encodeData = URLEncoder.encode(xing, "UTF-8")
                .replaceAll("\\+", "%20")
                .replaceAll("\\!", "%21")
                .replaceAll("\\'", "%27")
                .replaceAll("\\(", "%28")
                .replaceAll("\\)", "%29")
                .replaceAll("\\~", "%7E");
        System.out.println(encodeData);
        System.out.println(URLDecoder.decode(encodeData,"UTF-8"));
    }

    @Test
    public void ttte(){
        String s = "{\"attach\":\"{\\\"memberPhoneNum\\\":\\\"\\\",\\\"usrOnlyId\\\":10000024260,\\\"bonusPoint\\\":0,\\\"unionMerchatId\\\":\\\"M20190816151556E96B3\\\",\\\"payGateway\\\":\\\"MPOST_PAY\\\",\\\"unionPayMid\\\":\\\"1001784256\\\",\\\"rsaKey\\\":\\\"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCclXWbAIHB SPd4trtg1I /qXl\\\\nFmQ1GqUVx89SwhlvTPIf5P/iuCFghKtLj0eu1U8FU9t1QfohP DItit5BmZ3/hKO\\\\nLH5rj8BE72W FHTtJA6u/aVPPn/T4g9GlEOUUdOLZVOYMFROzcUQX0DPP/l4khos\\\\n2Y4DzvSszZLJbxFbRwIDAQAB\\\\n\\\",\\\"md5Key\\\":\\\"eab1eefb473df6ba022ac3079671f042\\\",\\\"merFee\\\":0,\\\"merName\\\":\\\"哦哦哦哦哦\\\"}\",\"channel\":\"Wap\",\"currencyType\":\"CNY\",\"limitPay\":\"[{\\\"limitPayMode\\\":\\\"WapAliPay\\\",\\\"limitBank\\\":[\\\"UNION_ALI_SCAN_PAY\\\"]},{\\\"limitPayMode\\\":\\\"WapUnionQuickPass\\\",\\\"limitBank\\\":[\\\"BARCODE_UNION_OFFLINE\\\",\\\"UNION_OFFLINE_SCAN_PAY\\\"]},{\\\"limitPayMode\\\":\\\"WapOnlineBank\\\",\\\"limitBank\\\":[\\\"JSCHINA_CCY_PAY\\\"]},{\\\"limitPayMode\\\":\\\"WapWechatPay\\\",\\\"limitBank\\\":[\\\"UNION_WECHART_SCAN_PAY\\\"]}]\",\"merchantId\":\"10001346\",\"notifyUrl\":\"http://vps-vpsOnlinePayInternalService.http.beta.uledns.com/vpsOnlinePayInternalService/vpsPay/vpsOnlinePayReturn\",\"payableAmount\":0.01,\"productDetail\":\"W3sib3JkZXJObyI6IjIwMjAwMTA2MTAyMzM5NjQxMDQzNzIzNTkiLCJvcmRlckFtb3VudCI6IjAuMDEiLCJpdGVtcyI6W3siaWQiOiIiLCJ1cGMiOiIxNjAyMDEwMTAwMjAxIiwibmFtZSI6IuiMtuWPtuibiyIsInByaWNlIjoiMC4wMSIsIm51bSI6IjEifV19XQ\",\"receivingName\":\"哦哦哦哦哦\",\"reqNo\":\"100013462020010610243600029767\",\"returnUrl\":\"https://vps.beta.ule.com/vpsOnlinePayService/vpsPay/toPaysuccess\",\"sign\":\"e6f1e53e770372476ab670f70659a97f\",\"terminalCreateIp\":\"180.169.59.213\",\"terminalMacId\":\"64D9546424F4\",\"timeStart\":\"2020-01-06 10:24:36\",\"usrOnlyId\":0}";
        System.out.println(s.charAt(435));
    }

}

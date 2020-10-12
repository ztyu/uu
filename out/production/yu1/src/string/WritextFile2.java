package string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by liguoqing on 2016/3/28.
 */
public class WritextFile2 {


    public static void readTxt(String filePath) {

        try {
            File file = new File(filePath);
            int c =0;
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                StringBuilder s  = new StringBuilder();
                while ((lineTxt = br.readLine()) != null) {
                    StringBuilder end  = new StringBuilder();
                    //String first = "\""+lineTxt.substring(1, 29)+"\"";
                    String first = lineTxt.substring(1, 29);
                    s.append(first+",");
                    end.append(first);
                    if (lineTxt.contains("RESP_TX")){
                        int startIndex = lineTxt.indexOf("RESP_TX");
                        int endIndex = lineTxt.indexOf("TRAN_CHNL");
                        end.append(lineTxt.substring(startIndex+12,endIndex-5));
                    }else {
                        end.append("超时！");
                    }
                    //System.out.println(lineTxt.trim());
                    System.out.println(end);
                }
                 System.out.println(s);
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }

    }


    public static void main(String[] args) {
        String filePath = "C:\\Users\\yuzhengteng2\\Desktop\\x.txt";
        readTxt(filePath);
    }

}
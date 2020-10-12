package string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by liguoqing on 2016/3/28.
 */
public class WritextFile3 {


    public static void readTxt(String filePath) {

        try {
            File file = new File(filePath);
            int c =0;
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                StringBuilder s  = new StringBuilder();
                StringBuilder end  = new StringBuilder();
                while ((lineTxt = br.readLine()) != null) {
                    //String first = "\""+lineTxt.substring(1, 29)+"\"";
                    String first = lineTxt.substring(0, 28);
                    if (lineTxt.contains("超时")){
                        c++;
                        end.append(first.trim()+",");
                    }
                    //System.out.println(lineTxt.trim());
                    System.out.println(end);
                    System.out.println("--------------------------------------------"+c);
                }
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
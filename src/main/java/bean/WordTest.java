package bean;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class WordTest {

    private Configuration configuration = null;

    public WordTest() {
        configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
    }

    public String createWord(List<Expression> list) throws IOException {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        getData(dataMap, list);
        String temppath = this.getClass().getResource("").getPath();
        String basepath = temppath + "\\..\\..\\..\\file\\";
        File baseFile = new File(basepath);
        System.out.println("baseFile = " + baseFile);
        configuration.setDirectoryForTemplateLoading(baseFile);//模板文件所在路径
        Template t = null;
        try {
            t = configuration.getTemplate("test.ftl"); //获取模板文件
            System.out.println("========== getT");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String uuid = UUID.randomUUID().toString().replace("-", "") + ".doc";
        System.out.println("uuid = " + uuid);
        String filename = basepath + "\\" + uuid;

        File outFile = new File(filename); //导出文件
        System.out.println("outFile = " + outFile.getCanonicalPath());

        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            t.process(dataMap, out); //将填充数据填入模板文件并输出到目标文件
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uuid;
    }

    private void getData(Map<String, Object> dataMap, List<Expression> l) {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String timestr = dateFormat.format(date);

        dataMap.put("timestr", timestr);

        List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>();
        int cout = l.size();
        for (int i = 0; i < cout; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            Expression e = l.get(i);
            String cal = e.getInta() + e.getOperator() + e.getIntb() + "=";
            System.out.println("cal = " + cal);
            map.put("no", i + 1);
            map.put("title", cal);
            newList.add(map);
        }
        dataMap.put("newList", newList);
    }
}
package com.wanghl.algorithm.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;

public class JsonConver {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("admin");
        //读取json文件
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/json/01.json"));
//            BufferedWriter bw = new BufferedWriter(new FileWriter("src/json/newFile.json"));
            String str = null;
            String data = "";
            while ((str = br.readLine()) != null) {
                data = data + str + "\n";
            }

//            JSONObject dataJson = (JSONObject) JSONObject.toJSON(data);
            JSONObject jsonObject = JSON.parseObject(data);
//            System.out.println(jsonObject);
            String dataStr = jsonObject.getString("global_config");
            JSONObject dataStrJSON = JSON.parseObject(dataStr);
            String org_name = dataStrJSON.getString("org_name");
            System.out.println(dataStr);
            System.out.println(org_name);
            //根据if(1,2,3 .equals org_name查comm_org.getOrgLevel)
//            JSONArray jsonArray = JSON.parseArray(dataStr);
//            System.out.println(jsonArray.size());
//            System.out.println(jsonArray.getJSONObject(0).getString());
//            JSONArray features = ((JSONObject)data).getJSONArray("features");
//            for (int i = 0; i < features.length(); i++) {
//                JSONObject info = features.getJSONObject(i);// 获取features数组的第i个json对象  
//                JSONObject properties = info.getJSONObject("properties");// 找到properties的json对象  
//                String name = properties.getString("name");// 读取properties对象里的name字段值  
//                System.out.println(name);
//                properties.put("NAMEID", list.get(i));// 添加NAMEID字段  
//                // properties.append("name", list.get(i));  
//                System.out.println(properties.getString("NAMEID"));
//                properties.remove("ISO");// 删除ISO字段 
//                String ws = dataJson.toString();
//                System.out.println(ws);
//                bw.write(ws);
//                // bw.newLine();  
//                bw.flush();
//                br.close();
//                bw.close();
//            }
        } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }// 读取原始json文件 
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}

package com.cn.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.cn.model.Admin;

public class AdminDao {
	//读取管理员数据
	public Map<String, String> readAdmin() {
		Map<String, String> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("admin.txt"))) {
            String line = br.readLine();
            String[] textData = null;

            while (line != null) {
                textData = line.split("\\,");
                String name = textData[0];
                String password = textData[1];

                map.put(name, password);

                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

}

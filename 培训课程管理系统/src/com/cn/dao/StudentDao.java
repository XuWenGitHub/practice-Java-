package com.cn.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.cn.model.Student;

public class StudentDao {
	//读取学生数据
	public ArrayList<Student> readStudent() {
		ArrayList<Student> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader("student.txt"))) {
			String line = br.readLine();
			String[] textData = null;

			while (line != null) {
				textData = line.split("\\,");
				String name = textData[0];
				String age = textData[1];
				String address = textData[2];
				String tel = textData[3];

				Student student = new Student(0, name, age, address, tel);

				list.add(student);
				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	//写入学生数据
	public int writeStudent(Student student) {
		ArrayList<Student> list = readStudent();
		list.add(student);
		int num = 0;
		try {
			FileWriter fileWriter = new FileWriter("student.txt");

			for (int i = 0; i < list.size(); i++) {
				Student stu = list.get(i);
				fileWriter.write(
						stu.getName() + "," + stu.getAge() + "," + stu.getAddress() + "," + stu.getTel() + "\r\n");
			}

			fileWriter.flush();
			fileWriter.close();
			num = 1;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return num;
	}
	
	//删除学生
	public int delStudent(String name) {
		ArrayList<Student> list = readStudent();
		int num = 0;

		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getName())) {
				list.remove(i);
			}
		}

		try {
			FileWriter fileWriter = new FileWriter("student.txt");

			for (int i = 0; i < list.size(); i++) {
				Student stu = list.get(i);
				fileWriter.write(
						stu.getName() + "," + stu.getAge() + "," + stu.getAddress() + "," + stu.getTel() + "\r\n");
			}

			fileWriter.flush();
			fileWriter.close();
			num = 1;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return num;
	}
	
	//按名字查找学生
	public ArrayList<Student> findStudent(String name) {
		ArrayList<Student> list = readStudent();
		ArrayList<Student> newlist = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contains(name)){
				newlist.add(list.get(i));
			}
		}
			
		return newlist;
	}

}

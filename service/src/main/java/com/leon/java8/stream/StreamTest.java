package com.leon.java8.stream;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
  * ClassName:    StreamTest
  * @Description: stream特性
  * @Author:      liyang
  * @Date:        2021/1/8
  * version     1.0.0
 */
public class StreamTest {
    public static void main(String[] args){
        Stream.of(1,2,3);
        Stream<Integer> iterNum = Stream.iterate(2, a -> a + 2).limit(5);
        iterNum.forEach(a->System.out.println(a));
//        iterNum.forEach(System.out::println);
        Math.random();
        Stream<Double> genNum = Stream.generate(Math::random).limit(3);
        genNum.forEach(System.out::println);


        // 分隔符
        Pattern compile = Pattern.compile(",");
        Stream<String> stringStream = compile.splitAsStream("a,v,s,c");

        // -------------------------流中间操作--------------------------------
        // ----1.1-筛选和切片----
        Stream<Integer> integerStream = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 10, 23);
        Stream<Integer> midStream = integerStream.filter(c -> c > 5).distinct().sorted().skip(2).limit(11);
        midStream.forEach(System.out::println);
        // ----1.2-映射----
        List<String> list = Arrays.asList("a,b,c", "1,2,3");
        Stream<String> mapStream = list.stream().map(a -> a.replaceAll(",", ""));
        mapStream.forEach(System.out::println);
        // -------------------------流终止操作--------------------------------
        Student s1 = new Student("aa", 10,1);
        Student s2 = new Student("bb", 20,2);
        Student s3 = new Student("cc", 10,3);
        List<Student> list2 = Arrays.asList(s1, s2, s3);

//装成list
        List<Integer> ageList = list2.stream().map(Student::getAge).collect(Collectors.toList()); // [10, 20, 10]

//转成set
        Set<Integer> ageSet = list2.stream().map(Student::getAge).collect(Collectors.toSet()); // [20, 10]

//转成map,注:key不能相同，否则报错
        Map<String, Integer> studentMap = list2.stream().collect(Collectors.toMap(Student::getName, Student::getAge)); // {cc=10, bb=20, aa=10}

//字符串分隔符连接
        String joinName = list2.stream().map(Student::getName).collect(Collectors.joining(",", "(", ")")); // (aa,bb,cc)

//聚合操作
//1.学生总数
        Long count = list2.stream().collect(Collectors.counting()); // 3
//2.最大年龄 (最小的minBy同理)
        Integer maxAge = list2.stream().map(Student::getAge).collect(Collectors.maxBy(Integer::compare)).get(); // 20
//3.所有人的年龄
        Integer sumAge = list2.stream().collect(Collectors.summingInt(Student::getAge)); // 40
//4.平均年龄
        Double averageAge = list2.stream().collect(Collectors.averagingDouble(Student::getAge)); // 13.333333333333334
// 带上以上所有方法
        DoubleSummaryStatistics statistics = list2.stream().collect(Collectors.summarizingDouble(Student::getAge));
        System.out.println("count:" + statistics.getCount() + ",max:" + statistics.getMax() + ",sum:" + statistics.getSum() + ",average:" + statistics.getAverage());

//分组
        Map<Integer, List<Student>> ageMap = list2.stream().collect(Collectors.groupingBy(Student::getAge));
//多重分组,先根据类型分再根据年龄分
        Map<Integer, Map<Integer, List<Student>>> typeAgeMap = list2.stream().collect(Collectors.groupingBy(Student::getType, Collectors.groupingBy(Student::getAge)));

//分区
//分成两部分，一部分大于10岁，一部分小于等于10岁
        Map<Boolean, List<Student>> partMap = list2.stream().collect(Collectors.partitioningBy(v -> v.getAge() > 10));

//规约
        Integer allAge = list2.stream().map(Student::getAge).collect(Collectors.reducing(Integer::sum)).get(); //40



    }



}

class Student{
    public String name;
    public int age;
    public int type;

    public Student(String name, int age, int order) {
        this.name = name;
        this.age = age;
        this.type = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
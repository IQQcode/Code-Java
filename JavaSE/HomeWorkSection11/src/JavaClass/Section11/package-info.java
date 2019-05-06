package JavaClass.Section11;

/**
 * 11.1 (三角形类Triangle)设计一个名为Triangle的类来扩展CeometricObject类。
 * 该类包括：
 * ■ 三个名为side1,side2和side3 的double 数据域表示这个三角形的三条边，
 * 它们的默认值是1.0。
 * • 一个无参构造方法创建默认的三角形。
 * • 一个能创建带指定sidel、side2 和side3 的三角形的构造方法。
 * • 所有个数据域的访问器方法。
 * • 一个名为 getArea()的方法返回这个三角形的面积。
 * • 一个名为 getPerimeter() 的方法返回这个三角形的周长。
 * • 一个名为 toStringO 的方法返回这个三角形的字符串描述。
 * 计算三角形面积的公式参见编程练习题2.19。toStringO 方法的实现如下所示：
 * return "Triangle: side1 = " + side1 + " side2 = " + side2 +
 * "side3 "  + side3;
 * 画出Triangle 类和GeometricObject 类的UML图并实现这些类。
 * 编写一个测试程序，提示用户输入三角形的三条边、顔色以及一个Boolean 值
 * 表明该三角形是否填充。程序应该使用输人创建一个具有这些边并设置
 * color和filled 属性的三角形。程序应该显示面积、边长、顔色以及表明
 * 是否填充的真或者假的值。
 */




/**
 * 11.2( Person、Student、Employee、Faculty 和Staff 类）
 * 设计一个名为Person 的类和它的两个名为Student 和Employee 的子类。
 * Employee 类又有子类：教员类Faculty 和职员类Staff。
 * 每个人都有姓名、地址、电话号码和电子邮件地址。学生有班级状态
 * （大一、大二、大三或大四）。将这些状态定义为常量。
 * 一个雇员涉及办公室、工资和受聘日期。
 * 使用编程练习题 10.14中定义的MyDate 类为受聘日期创建一个对象。
 * 教员有办公时间和级别。职员有职务称号。覆盖每个类中的toString 方法，
 * 显示相应的类别名字和人名。画出这些类的UML图并实现这些类。
 * 编写一个测试程序，创建Person、Student 、Employee、Faculty和Staff,
 * 并且调用它们的toStringO 方法。
 */

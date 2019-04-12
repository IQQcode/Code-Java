import javax.swing.JFrame;

/**
 * 生成相同大小的俩个图形界面窗口
 */

public class TestFrame {
    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setTitle("Window 账号");
        frame1.setSize(400,300);
        frame1.setLocation(200,100);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);

        JFrame frame2 = new JFrame();
        frame2.setTitle("Window 密码");
        frame2.setSize(400,300);
        frame2.setLocation(450,200);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);//true为真，显示窗口
    }
}

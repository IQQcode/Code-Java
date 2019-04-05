javaIo--BIO(阻塞式IO)

java.io;

       掌握核心的五个类：
       File,OutputStream,InputStream,Reader,Writer

       一个接口：Serializable

一、File文件操作类

1.File类是唯一一个与文件本身操作有关的程序类(创建、删除、取得信息)
   产生File对象：
       public File(String pathname):根据文件的绝对路径产生file对象
       public File(URI uri):根据网络产生File对象

       if(file.exists()) {  //判断是否存在
            file.delete();  //删除
        }else {
            file.createNewFile();  //创建文件
        }

     文件分隔符： File.separator

2.目录操作
    取得父路径的File对象：   public File getParentFile() { }
    取得父路径的目录    ：   public String getParent() { }

    创建多级父路径(一次性创建多级不存在的父路径)    public boolean mkdirs()


3.取得文件信息

    判断File对象是否是文件： public boolean isFile()

             取得文件大小： public long length()  --字节为单位
             
                 取得上次修改时间： public long lastModified()

    判断File对象是否是文件夹： public  boolean isDirectory()

    列出一个目录的全部组成： public File[] listFiles()





二、字节流与字符流
                   java.io包分为俩类：输入流与输出流

字节流(byte)：原生操作，无需转换；可以处理文本文件、图像、音乐、视频等资源
InputStream,OutputStream


字符流(char)： 经过处理后的操作；只用于处理中文文本
Reader,Writer


*** 流模型的操作流程：
1).取得终端对象
2).根据终端对象取得输入输出流
3).根据输入输出流进行数据的读取与写入
4).关闭流(I/O操作属于资源处理，所有的资源处理[IO操作、数据库操作、网络操作]
在使用后一定要关闭)


1.字节的输出流 OutputStream
    public abstract class OutputStream implements Cloneable,Flushable


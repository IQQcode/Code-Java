create table photo (
     id int not null auto_increment primary key,
     name varchar(100) comment '名称',
     photo blob comment '照片'
)
ENGINE = InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;


create table tb_file(
     fid SMALLINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
     fname VARCHAR(50) NOT NULL comment '名称',
     fcontent LONGBLOB NOT NULL comment '照片'
     );


-- HU7804,广州-北京,2007-07-18,谢丽珍,3,1,C,3A,服务保障信息：未用餐随行人员…

CREATE TABLE text_pictureInformation

(
    FltNum  VARCHAR(10) comment '朝代号',

    FltLine  VARCHAR(30) comment '朝代',

    FltDate  VARCHAR(10) comment '日期', 

    PsgName  VARCHAR(30) comment '服饰名称', 

    PsgType  VARCHAR(30) comment '服饰类型类型，数字表示，目前是1-13', 

    PsgSex  VARCHAR(1) comment '0 男  1 女',

    PsgCab  VARCHAR(1) comment '几等舱， F/Y  舱位按字母顺序排列', 

    PsgSeatNo  VARCHAR(5) comment '座位号 2A,22F，根据这个得到一排有多少个座位，共有多少排座位信息', 

    PsgInfo  VARCHAR(2048) comment '详细信息,可能很长' 

);
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: qlnhahang
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ca`
--

DROP TABLE IF EXISTS `ca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ca` (
  `MaCa` int NOT NULL AUTO_INCREMENT,
  `TenCa` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`MaCa`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ca`
--

LOCK TABLES `ca` WRITE;
/*!40000 ALTER TABLE `ca` DISABLE KEYS */;
INSERT INTO `ca` VALUES (1,'sáng'),(2,'trưa'),(3,'tối'),(4,'cuối tuần');
/*!40000 ALTER TABLE `ca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietsanh`
--

DROP TABLE IF EXISTS `chitietsanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietsanh` (
  `MaChiTiet` int NOT NULL AUTO_INCREMENT,
  `sanh_MaSanh` int NOT NULL,
  `ca_MaCa` int NOT NULL,
  `Gia` decimal(10,0) NOT NULL,
  PRIMARY KEY (`MaChiTiet`),
  KEY `fk_chitietsanh_sanh1_idx` (`sanh_MaSanh`),
  KEY `fk_chitietsanh_ca1_idx` (`ca_MaCa`),
  CONSTRAINT `fk_chitietsanh_ca1` FOREIGN KEY (`ca_MaCa`) REFERENCES `ca` (`MaCa`),
  CONSTRAINT `fk_chitietsanh_sanh1` FOREIGN KEY (`sanh_MaSanh`) REFERENCES `sanh` (`MaSanh`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietsanh`
--

LOCK TABLES `chitietsanh` WRITE;
/*!40000 ALTER TABLE `chitietsanh` DISABLE KEYS */;
INSERT INTO `chitietsanh` VALUES (19,1,1,500000),(20,1,2,500000),(21,1,3,500000),(22,1,4,500000),(23,2,1,8500000),(24,2,2,8500000),(25,2,3,8500000),(26,2,4,8500000),(27,3,1,10000000),(28,3,2,10000000),(29,3,3,10000000),(30,3,4,10000000),(31,4,4,15000000),(32,4,1,15000000),(33,4,2,15000000),(34,4,3,15000000),(35,5,4,20000000),(36,6,4,20000000);
/*!40000 ALTER TABLE `chitietsanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dichvu`
--

DROP TABLE IF EXISTS `dichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dichvu` (
  `MaDV` int NOT NULL,
  `TenDV` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `Gia` decimal(20,0) NOT NULL,
  PRIMARY KEY (`MaDV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvu`
--

LOCK TABLES `dichvu` WRITE;
/*!40000 ALTER TABLE `dichvu` DISABLE KEYS */;
INSERT INTO `dichvu` VALUES (1,'MC chương trình',1000000),(2,'Pháo kim tuyến',500000),(3,'Violin  Piano sảnh chính',300000),(4,'Tượng đá hoa đăng',150000),(5,'Tranh cát',150000),(6,'Bàn lễ tân đặc biệt',1000000),(7,'Cổng hoa tươi',200000),(8,'Quay phim',100000);
/*!40000 ALTER TABLE `dichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `MaHD` int NOT NULL AUTO_INCREMENT,
  `khachhang_MaKH` int NOT NULL,
  `chitietsanh_MaChiTiet` int NOT NULL,
  `NgayToChuc` datetime NOT NULL,
  `TongCong` int DEFAULT NULL,
  `Note` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `NgayLap` datetime NOT NULL,
  PRIMARY KEY (`MaHD`),
  KEY `fk_hoadon_khachhang_idx` (`khachhang_MaKH`),
  KEY `fk_hoadon_chitietsanh1_idx` (`chitietsanh_MaChiTiet`),
  CONSTRAINT `fk_hoadon_chitietsanh1` FOREIGN KEY (`chitietsanh_MaChiTiet`) REFERENCES `chitietsanh` (`MaChiTiet`),
  CONSTRAINT `fk_hoadon_khachhang` FOREIGN KEY (`khachhang_MaKH`) REFERENCES `khachhang` (`MaKH`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES (11,2,34,'2022-03-03 00:00:00',NULL,NULL,'2022-06-05 00:00:00'),(12,3,35,'2022-04-04 00:00:00',NULL,NULL,'2022-05-06 00:00:00'),(13,1,30,'2022-04-04 00:00:00',NULL,NULL,'2022-04-04 00:00:00');
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadondichvu`
--

DROP TABLE IF EXISTS `hoadondichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadondichvu` (
  `MaHDDV` int NOT NULL AUTO_INCREMENT,
  `dichvu_MaDV` int NOT NULL,
  `hoadon_MaHD` int NOT NULL,
  PRIMARY KEY (`MaHDDV`),
  KEY `fk_hoadondichvu_dichvu1_idx` (`dichvu_MaDV`),
  KEY `fk_hoadondichvu_hoadon1_idx` (`hoadon_MaHD`),
  CONSTRAINT `fk_hoadondichvu_dichvu1` FOREIGN KEY (`dichvu_MaDV`) REFERENCES `dichvu` (`MaDV`),
  CONSTRAINT `fk_hoadondichvu_hoadon1` FOREIGN KEY (`hoadon_MaHD`) REFERENCES `hoadon` (`MaHD`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadondichvu`
--

LOCK TABLES `hoadondichvu` WRITE;
/*!40000 ALTER TABLE `hoadondichvu` DISABLE KEYS */;
INSERT INTO `hoadondichvu` VALUES (1,1,11),(2,2,12),(3,3,13);
/*!40000 ALTER TABLE `hoadondichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadonmonan`
--

DROP TABLE IF EXISTS `hoadonmonan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadonmonan` (
  `MaHDMA` int NOT NULL AUTO_INCREMENT,
  `menu_MaMenu` int NOT NULL,
  `hoadon_MaHD` int NOT NULL,
  `SoLuong` int NOT NULL,
  `ThanhTien` int NOT NULL,
  PRIMARY KEY (`MaHDMA`),
  KEY `fk_hoadonmonan_menu1_idx` (`menu_MaMenu`),
  KEY `fk_hoadonmonan_hoadon1_idx` (`hoadon_MaHD`),
  CONSTRAINT `fk_hoadonmonan_hoadon1` FOREIGN KEY (`hoadon_MaHD`) REFERENCES `hoadon` (`MaHD`),
  CONSTRAINT `fk_hoadonmonan_menu1` FOREIGN KEY (`menu_MaMenu`) REFERENCES `menu` (`MaMenu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadonmonan`
--

LOCK TABLES `hoadonmonan` WRITE;
/*!40000 ALTER TABLE `hoadonmonan` DISABLE KEYS */;
INSERT INTO `hoadonmonan` VALUES (1,21,11,100,25000000),(2,26,12,50,22000000),(3,30,13,500,23000000);
/*!40000 ALTER TABLE `hoadonmonan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `MaKH` int NOT NULL AUTO_INCREMENT,
  `TenKH` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `GioiTInh` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `SĐT` int NOT NULL,
  `Email` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `TaiKhoan` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `MatKhau` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `Avatar` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'Huỳnh Thị Như Ngọc','Nữ',326598624,'nhungoc@gmail.com','nhungoc','ngoc123',NULL),(2,'Hà Thanh Mai','Nữ',123694896,'thanhmai@gmail.com','thanhmai','mai123',NULL),(3,'Nguyễn Minh Phượng','Nữ',658762469,'phuong@gmail.com','minhphuong','phuong123',NULL),(4,'Huỳnh Ngọc Tú','Nam',964876234,'ngoctu@gmail.com','ngoctu','tu123',NULL),(5,'Lê Thanh Ẩn','Nam',978462315,'thanhan@gmail.com','thanhan','an123',NULL),(6,'Hồ Nguyên Vũ','Nam',986325468,'nguyenvu@gmail.com','nguyenvu','vu123',NULL);
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `MaMenu` int NOT NULL AUTO_INCREMENT,
  `TenMon` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `LoaiMon` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `Gia` decimal(10,0) NOT NULL,
  PRIMARY KEY (`MaMenu`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (21,'Gỏi tôm thái tây thi','Khai vị',50000),(22,'Chả giò chiên giòn','Khai vị',50000),(23,'Mực viên bao trứng muối','Khai vị',50000),(24,'Tôm giòn leo chanh','Khai vị',50000),(25,'Chả thanh cua Nhật','Khai vị',50000),(26,'Cơm chiên gà quay lá é','Món chính',80000),(27,'Cơm chiên bào ngư','Món chính',70000),(28,'Mì xào xa tế tôm','Món chính',75000),(29,'Bồ câu quay','Món chính',90000),(30,'Bò hầm rượu vang + bánh mì','Món chính',10000),(31,'Cua lột sốt chanh dây','Món chính',11000),(32,'Tôm rang muối Hồng Kông','Món chính',13000),(33,'Lẩu tôm Thái Lan','Món chính',15600),(34,'Lẩu hải sản sa tế','Món chính',19000),(35,'Rau câu dừa','Tráng miệng',10000),(36,'Mousse dâu','Tráng miệng',20000),(37,'Panna cotta chanh dây','Tráng miệng',13000),(38,'Passion fruit layer cake','Tráng miệng',15000),(39,'Sweet love','Tráng miệng',20000);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `MaNV` int NOT NULL AUTO_INCREMENT,
  `TenNV` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `SĐT` int NOT NULL,
  `NgaySinh` datetime NOT NULL,
  `GioiTInh` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `LoaiNV` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `TaiKhoan` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `MatKhau` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`MaNV`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Hoàng Minh Huân',912345678,'2001-01-01 00:00:00','Nam','Admin','Admin123','abc123'),(2,'Trần Minh Hoàn',91234567,'2001-02-01 00:00:00','Nam','Admin','Admin123','abc123'),(3,'Thạch Thiên Trí',71234586,'2001-03-01 00:00:00','Nam','Nhân Viên','Tri123','tri123'),(4,'Đặng Văn Quốc Khánh',91235895,'2001-04-01 00:00:00','Nam','Nhân Viên','KhanhNV','khanh123');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanh`
--

DROP TABLE IF EXISTS `sanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanh` (
  `MaSanh` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `SoBan` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`MaSanh`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanh`
--

LOCK TABLES `sanh` WRITE;
/*!40000 ALTER TABLE `sanh` DISABLE KEYS */;
INSERT INTO `sanh` VALUES (1,'Ruby','50'),(2,'Saphỉe','85'),(3,'Emerald','100'),(4,'Platinum','125'),(5,'Pearl','150'),(6,'Diamond','200');
/*!40000 ALTER TABLE `sanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'qlnhahang'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-06  1:53:10

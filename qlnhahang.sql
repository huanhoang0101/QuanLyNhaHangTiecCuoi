-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: qlnhahang
-- ------------------------------------------------------
-- Server version	8.0.28

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
  `TenCa` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaCa`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
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
-- Table structure for table `comment_dichvu`
--

DROP TABLE IF EXISTS `comment_dichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_dichvu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dichvu_id` int NOT NULL,
  `user_id` int NOT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_dichvu_idx` (`dichvu_id`),
  KEY `fk_comment_user_dichvu_idx` (`user_id`),
  CONSTRAINT `fk_comment_dichvu` FOREIGN KEY (`dichvu_id`) REFERENCES `dichvu` (`MaDV`),
  CONSTRAINT `fk_comment_user_dichvu` FOREIGN KEY (`user_id`) REFERENCES `khachhang` (`MaKH`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_dichvu`
--

LOCK TABLES `comment_dichvu` WRITE;
/*!40000 ALTER TABLE `comment_dichvu` DISABLE KEYS */;
INSERT INTO `comment_dichvu` VALUES (1,'Dịch vụ tốt lắm',1,3,'2022-08-14 16:30:00'),(2,'Dich vu rất tuyệt',1,3,'2022-08-14 16:30:00');
/*!40000 ALTER TABLE `comment_dichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_monan`
--

DROP TABLE IF EXISTS `comment_monan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_monan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `monan_id` int NOT NULL,
  `user_id` int NOT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_monan_idx` (`monan_id`),
  KEY `fk_comment_user_monan_idx` (`user_id`),
  CONSTRAINT `fk_comment_monan` FOREIGN KEY (`monan_id`) REFERENCES `menu` (`MaMenu`),
  CONSTRAINT `fk_comment_user_monan` FOREIGN KEY (`user_id`) REFERENCES `khachhang` (`MaKH`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_monan`
--

LOCK TABLES `comment_monan` WRITE;
/*!40000 ALTER TABLE `comment_monan` DISABLE KEYS */;
INSERT INTO `comment_monan` VALUES (1,'Món ăn tốt lắm',22,3,'2022-08-14 16:30:00'),(2,'Món ăn rất tuyệt',23,3,'2022-08-14 16:30:00'),(3,'Rất ngon!',21,1,'2022-08-23 16:38:54');
/*!40000 ALTER TABLE `comment_monan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_sanh`
--

DROP TABLE IF EXISTS `comment_sanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_sanh` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sanh_id` int NOT NULL,
  `user_id` int NOT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_sanh_idx` (`sanh_id`),
  KEY `fk_comment_user_sanh_idx` (`user_id`),
  CONSTRAINT `fk_comment_sanh` FOREIGN KEY (`sanh_id`) REFERENCES `sanh` (`MaSanh`),
  CONSTRAINT `fk_comment_user_sanh` FOREIGN KEY (`user_id`) REFERENCES `khachhang` (`MaKH`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_sanh`
--

LOCK TABLES `comment_sanh` WRITE;
/*!40000 ALTER TABLE `comment_sanh` DISABLE KEYS */;
INSERT INTO `comment_sanh` VALUES (1,'Sảnh tốt lắm',1,3,'2022-08-14 16:30:00'),(2,'Sảnh rất tuyệt',1,3,'2022-08-14 16:30:00');
/*!40000 ALTER TABLE `comment_sanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dichvu`
--

DROP TABLE IF EXISTS `dichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dichvu` (
  `MaDV` int NOT NULL,
  `TenDV` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Gia` decimal(20,0) NOT NULL,
  `image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaDV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvu`
--

LOCK TABLES `dichvu` WRITE;
/*!40000 ALTER TABLE `dichvu` DISABLE KEYS */;
INSERT INTO `dichvu` VALUES (1,'MC chương trình',1000000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660209400/Dich%20vu/MC_l4b6al.jpg'),(2,'Pháo kim tuyến',500000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660209401/Dich%20vu/Ph%C3%A1o_kim_tuy%E1%BA%BFn_nryjln.jpg'),(3,'Violin  Piano sảnh chính',300000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660209401/Dich%20vu/Violin_Piano_ozfbm8.jpg'),(4,'Tượng đá hoa đăng',150000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660209401/Dich%20vu/T%C6%B0%E1%BB%A3ng_%C4%91%C3%A1_hoa_%C4%91%C4%83ng_gtxhyx.jpg'),(5,'Tranh cát',150000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660209399/Dich%20vu/tranh_c%C3%A1t_wpkhpr.jpg'),(6,'Bàn lễ tân đặc biệt',1000000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660209400/Dich%20vu/B%C3%A0n_l%E1%BB%85_t%C3%A2n_lgwuxt.jpg'),(7,'Cổng hoa tươi',200000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660209400/Dich%20vu/C%E1%BB%95ng_hoa_sxguh6.jpg'),(8,'Quay phim',100000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660210494/Dich%20vu/Quay_phim_qtlz87.jpg');
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
  `Note` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `NgayLap` datetime NOT NULL,
  PRIMARY KEY (`MaHD`),
  KEY `fk_hoadon_khachhang_idx` (`khachhang_MaKH`),
  KEY `fk_hoadon_chitietsanh1_idx` (`chitietsanh_MaChiTiet`),
  CONSTRAINT `fk_hoadon_chitietsanh1` FOREIGN KEY (`chitietsanh_MaChiTiet`) REFERENCES `chitietsanh` (`MaChiTiet`),
  CONSTRAINT `fk_hoadon_khachhang` FOREIGN KEY (`khachhang_MaKH`) REFERENCES `khachhang` (`MaKH`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
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
  `TenKH` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GioiTInh` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `SĐT` int NOT NULL,
  `Email` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TaiKhoan` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Avatar` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
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
  `TenMon` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `LoaiMon` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Gia` decimal(10,0) NOT NULL,
  `image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaMenu`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (21,'Gỏi tôm thái tây thi','Khai vị',50000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208800/Foods/G%E1%BB%8Fi_t%C3%B4m_th%C3%A1i_t%C3%A2y_thi_vpuajp.jpg'),(22,'Chả giò chiên giòn','Khai vị',50000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208799/Foods/Ch%E1%BA%A3_gi%C3%B2_chi%C3%AAn_gi%C3%B2n_sctoge.jpg'),(23,'Mực viên bao trứng muối','Khai vị',50000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208801/Foods/M%E1%BB%B1c_vi%C3%AAn_bao_tr%E1%BB%A9ng_mu%E1%BB%91i_gai2mk.jpg'),(24,'Tôm giòn leo chanh','Khai vị',50000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208802/Foods/T%C3%B4m_gi%C3%B2n_leo_chanh_u7zqnq.jpg'),(25,'Chả thanh cua Nhật','Khai vị',50000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208799/Foods/Ch%E1%BA%A3_thanh_cua_Nh%E1%BA%ADt_qehpvo.jpg'),(26,'Cơm chiên gà quay lá é','Món chính',80000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208799/Foods/C%C6%A1m_chi%C3%AAn_g%C3%A0_quay_l%C3%A1_%C3%A9_gspupe.jpg'),(27,'Cơm chiên bào ngư','Món chính',70000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1662304220/Foods/C%C6%A1m_chi%C3%AAn_b%C3%A0o_ng%C6%B0_tw5p7w.jpg'),(28,'Mì xào xa tế tôm','Món chính',75000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208800/Foods/M%C3%AC_x%C3%A0o_xa_t%E1%BA%BF_t%C3%B4m_cgyqdp.jpg'),(29,'Bồ câu quay','Món chính',90000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208799/Foods/B%E1%BB%93_c%C3%A2u_quay_lv0rtx.jpg'),(30,'Bò hầm rượu vang + bánh mì','Món chính',10000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208799/Foods/B%C3%B2_h%E1%BA%A7m_r%C6%B0%E1%BB%A3u_vang_b%C3%A1nh_m%C3%AC_ixurxd.jpg'),(31,'Cua lột sốt chanh dây','Món chính',11000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208800/Foods/Cua_l%E1%BB%99t_s%E1%BB%91t_chanh_d%C3%A2y_gdcjha.jpg'),(32,'Tôm rang muối Hồng Kông','Món chính',13000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208802/Foods/T%C3%B4m_rang_mu%E1%BB%91i_H%E1%BB%93ng_K%C3%B4ng_pyn5pb.jpg'),(33,'Lẩu tôm Thái Lan','Món chính',15600,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1662304403/Foods/L%E1%BA%A9u_t%C3%B4m_Th%C3%A1i_Lan_abrrie.jpg'),(34,'Lẩu hải sản sa tế','Món chính',19000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1662304528/Foods/L%E1%BA%A9u_h%E1%BA%A3i_s%E1%BA%A3n_sa_t%E1%BA%BF_pocnmu.jpg'),(35,'Rau câu dừa','Tráng miệng',10000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1662304715/Foods/Rau_c%C3%A2u_d%E1%BB%ABa_lv0jii.jpg'),(36,'Mousse dâu','Tráng miệng',20000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208801/Foods/Mousse_d%C3%A2u_sjdpnl.jpg'),(37,'Panna cotta chanh dây','Tráng miệng',13000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208801/Foods/Panna_cotta_chanh_d%C3%A2y_gcfllj.jpg'),(38,'Passion fruit layer cake','Tráng miệng',15000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1662304638/Foods/Passion_fruit_layer_cake_orlzoo.jpg'),(39,'Sweet love','Tráng miệng',20000,'https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208802/Foods/Sweet_Love_xyi3lg.jpg');
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
  `TenNV` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `SĐT` int NOT NULL,
  `NgaySinh` datetime NOT NULL,
  `GioiTInh` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `LoaiNV` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `TaiKhoan` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaNV`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Hoàng Minh Huân',912345678,'2001-01-01 00:00:00','Nam','Admin','Admin123','abc123'),(2,'Trần Minh Hoàn',91234567,'2001-02-01 00:00:00','Nam','Admin','Admin456','abc123'),(3,'Thạch Thiên Trí',71234586,'2001-03-01 00:00:00','Nam','Nhân Viên','Tri123','tri123'),(4,'Đặng Văn Quốc Khánh',91235895,'2001-04-01 00:00:00','Nam','Nhân Viên','KhanhNV','khanh123');
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
  `Ten` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `SoBan` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaSanh`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanh`
--

LOCK TABLES `sanh` WRITE;
/*!40000 ALTER TABLE `sanh` DISABLE KEYS */;
INSERT INTO `sanh` VALUES (1,'Ruby','50','https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208838/Sanh/s%E1%BA%A3nh_Ruby_sgzq6y.jpg'),(2,'Saphire','85','https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208839/Sanh/s%E1%BA%A3nh_Saphire_w49bxh.jpg'),(3,'Emerald','100','https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208838/Sanh/s%E1%BA%A3nh_Emerald_mfithn.jpg'),(4,'Platinum','125','https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208838/Sanh/s%E1%BA%A3nh_Platinum_srutrx.jpg'),(5,'Pearl','150','https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208838/Sanh/s%E1%BA%A3nh_Pearl_buitjd.jpg'),(6,'Diamond','200','https://res.cloudinary.com/dnrpggpn0/image/upload/v1660208838/Sanh/s%E1%BA%A3nh_Diamond_bpvsqc.jpg');
/*!40000 ALTER TABLE `sanh` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-04 22:21:09

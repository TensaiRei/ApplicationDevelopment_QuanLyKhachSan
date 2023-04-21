--
GO
use master

GO
DROP DATABASE HotelManagement

--CREATE DATABASE
GO
CREATE DATABASE HotelManagement
ON PRIMARY
(
	NAME = HotelManagement,
	FILENAME = N'D:\8. Code\Microsoft SQL Server\Databases\HotelManagement\HotelManagement.mdf', --CHANGE THIS
	SIZE = 32MB,
	MAXSIZE = 128MB,
	FILEGROWTH = 1MB
)
LOG ON
(
	NAME = HotelManagement_LOG,
	FILENAME = N'D:\8. Code\Microsoft SQL Server\Databases\HotelManagement\HotelManagement.ldf', --CHANGE THIS
	SIZE = 8MB,
	MAXSIZE = 32MB,
	FILEGROWTH = 1MB
)

GO
USE HotelManagement

GO
--CREATE TABLES (No constraint)
CREATE TABLE KhachHang
(
	MaKhachHang		int NOT NULL IDENTITY(10000,1),
	HoDem			nvarchar(30) NOT NULL,
	Ten				nvarchar(10) NOT NULL,
	CCCD			varchar(15) NOT NULL,
	SDT				varchar(12),
	QuocTich		nvarchar(20)
)
CREATE TABLE Phong
(
	MaPhong			varchar(7) NOT NULL,
	SoPhong			int,
	SoTang			int,
	TenPhong		nvarchar(20),
	TinhTrang		nvarchar(20),
	MaLoaiPhong		varchar(7) NOT NULL
)
CREATE TABLE LoaiPhong
(
	MaLoaiPhong		varchar(7) NOT NULL,
	TenLoaiPhong	nvarchar(20),
	DonGia			money
)
CREATE TABLE TiepTan
(
	MaTiepTan		varchar(7) NOT NULL,
	HoDem			nvarchar(30) NOT NULL,
	Ten				nvarchar(10) NOT NULL,
	CCCD			varchar(15),
	SDT				varchar(12),
	MaTaiKhoan		varchar(10)
)
CREATE TABLE DichVu
(
	MaDichVu		varchar(7) NOT NULL,
	TenDichVu		nvarchar(30),
	DonGia			money,
	LoaiDichVu		nvarchar(20) NOT NULL
)
CREATE TABLE DonDatPhong
(
	MaDonDat		int NOT NULL IDENTITY(100000,1),
	MaKhachHang		int NOT NULL,
	MaPhong			varchar(7) NOT NULL,
	MaTiepTan		varchar(7) NOT NULL,
	SoLuongKhach	int,
	HinhThucThue	nvarchar(20) NOT NULL,
	NgayDatPhong	DateTime
)
CREATE TABLE DonDatPhong_Phong
(
	MaDonDat		int NOT NULL,
	MaPhong			varchar(7) NOT NULL
)
CREATE TABLE DonDatPhong_DichVu
(
	MaDonDat		int NOT NULL,
	MaDichVu		varchar(7) NOT NULL,
	SoLuong			int
)
CREATE TABLE HoaDon
(
	MaHoaDon		int NOT NULL IDENTITY(100000,1),
	MaDonDat		int NOT NULL,
	PhuPhi			money,
	TongThanhTien	money,
	NgayDatPhong	DateTime,
	NgayTraPhong	DateTime
)
CREATE TABLE TaiKhoan
(
	MaTaiKhoan		varchar(10) NOT NULL,
	TenTaiKhoan		varchar(30) NOT NULL,
	MatKhauTaiKhoan	varbinary(100) NOT NULL
)

GO
--CREATE CONSTRAINT
GO
ALTER TABLE TaiKhoan
ADD CONSTRAINT PK_TaiKhoan PRIMARY KEY (MaTaiKhoan);

GO
ALTER TABLE LoaiPhong
ADD CONSTRAINT PK_LoaiPhong		PRIMARY KEY (MaLoaiPhong),
	CONSTRAINT CK_DonGia_LP		CHECK (DonGia>=0);

GO
ALTER TABLE Phong
ADD CONSTRAINT PK_Phong			PRIMARY KEY (MaPhong),
	CONSTRAINT CK_SoPhong		CHECK(SoPhong>0),
	CONSTRAINT CK_SoTang		CHECK(SoTang>0),
	CONSTRAINT CK_TrangThai		CHECK(TinhTrang in ('Available', 'Booked', 'Not Available')),
	CONSTRAINT FK_MaLoaiPhong	FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong(MaLoaiPhong);

GO
ALTER TABLE KhachHang
ADD CONSTRAINT PK_KhachHang PRIMARY KEY (MaKhachHang),
	CONSTRAINT UN_KhachHang UNIQUE (CCCD);

GO
ALTER TABLE TiepTan
ADD CONSTRAINT PK_TiepTan		PRIMARY KEY (MaTiepTan),
	CONSTRAINT FK_MaTaiKhoan	FOREIGN KEY (MaTaiKhoan) REFERENCES TaiKhoan(MaTaiKhoan),
	CONSTRAINT UN_TiepTan		UNIQUE (CCCD);

GO
ALTER TABLE DichVu
ADD CONSTRAINT PK_DichVu		PRIMARY KEY (MaDichVu),
	CONSTRAINT CK_DonGia_DV		CHECK (DonGia>=0),
	CONSTRAINT CK_LoaiDV		CHECK (LoaiDichVu in ('Foods', 'Drinks', 'Others'));

GO
ALTER TABLE DonDatPhong
ADD CONSTRAINT PK_DonDatPhong	PRIMARY KEY (MaDonDat),
	CONSTRAINT FK_MaPhong		FOREIGN KEY (MaPhong)		REFERENCES Phong(MaPhong),
	CONSTRAINT FK_MaKhachHang	FOREIGN KEY (MaKhachHang)	REFERENCES KhachHang(MaKhachHang),
	CONSTRAINT FK_MaTiepTan		FOREIGN KEY (MaTiepTan)		REFERENCES TiepTan(MaTiepTan),
	CONSTRAINT CK_SoLuongKhach	CHECK (SoLuongKhach>0);

GO
ALTER TABLE DonDatPhong_Phong
ADD CONSTRAINT FK_MaDonDat_DP		FOREIGN KEY (MaDonDat) REFERENCES DonDatPhong(MaDonDat),
	CONSTRAINT FK_MaPhong_DP		FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong),
	CONSTRAINT PK_DonDatPhong_Phong PRIMARY KEY(MaDonDat, MaPhong);

GO
ALTER TABLE DonDatPhong_DichVu
ADD CONSTRAINT FK_MaDonDat_DDV			FOREIGN KEY (MaDonDat) REFERENCES DonDatPhong(MaDonDat),
	CONSTRAINT FK_MaDichVu_DDV			FOREIGN KEY (MaDichVu) REFERENCES DichVu(MaDichVu),
	CONSTRAINT CK_SoLuong_DDV			CHECK (SoLuong>=0),
	CONSTRAINT PK_DonDatPhong_DichVu	PRIMARY KEY (MaDonDat, MaDichVu);

GO
ALTER TABLE HoaDon
ADD CONSTRAINT PK_HoaDon		PRIMARY KEY (MaHoaDon),
	CONSTRAINT FK_MaDonDat		FOREIGN KEY (MaDonDat) REFERENCES DonDatPhong(MaDonDat),
	CONSTRAINT CK_PhuPhi_HD		CHECK (PhuPhi>=0),
	CONSTRAINT CK_TTT_HD		CHECK (TongThanhTien>=0),
	CONSTRAINT CK_NTP_NDP_HD	CHECK (NgayTraPhong > NgayDatPhong);
GO


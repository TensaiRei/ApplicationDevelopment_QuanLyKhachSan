USE [HotelManagement]
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([MaKhachHang], [HoDem], [Ten], [CCCD], [SDT], [QuocTich]) VALUES (10000, N'Nguyễn Văn', N'An', N'077100000001', N'0900800101', N'Việt Nam')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [TenTaiKhoan], [MatKhauTaiKhoan]) VALUES (N'TKNTTN0001', N'KimThanh', 0x0200000028897A0168EF83C2CDE25ECCB70F48F30697169C8FA8FE7B0634BB1D6968B9AE820B053C1142F7E5EF2D50FBBCC3F277)
INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [TenTaiKhoan], [MatKhauTaiKhoan]) VALUES (N'TKNTTN0002', N'ThienPhu', 0x0200000063DC2420C8A9138A4C37A910FAB8F402AF0103D25003E20014398141A75E139D8E9E521813758FC26F25A8DCD5847363)
INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [TenTaiKhoan], [MatKhauTaiKhoan]) VALUES (N'TKNTTN0003', N'ThanhTin', 0x02000000F2BABD3ED562CD2B1EDD158E0C590EC3A83FC2444F9A762C0B1C01780FC27782E414DC7E0BCB213B41C1DE466F1590BA)
INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [TenTaiKhoan], [MatKhauTaiKhoan]) VALUES (N'TKNTTN0004', N'LuuLy', 0x02000000D03C2635297C1A720869F61C7372A5B0C23E52DAF00BF8B0DFB71D6D325B44AB69EC0D5EB6689B29C58A19538DFFA4C9)
GO
INSERT [dbo].[TiepTan] ([MaTiepTan], [HoDem], [Ten], [CCCD], [SDT], [MaTaiKhoan]) VALUES (N'TTN0001', N'Huỳnh Kim', N'Thành', N'07700000001', N'0900800701', N'TKNTTN0001')
INSERT [dbo].[TiepTan] ([MaTiepTan], [HoDem], [Ten], [CCCD], [SDT], [MaTaiKhoan]) VALUES (N'TTN0002', N'Nguyễn Thiên', N'Phú', N'07700000002', N'0900800702', N'TKNTTN0002')
INSERT [dbo].[TiepTan] ([MaTiepTan], [HoDem], [Ten], [CCCD], [SDT], [MaTaiKhoan]) VALUES (N'TTN0003', N'Nguyễn Trọng', N'Tín', N'07700000003', N'0900800703', N'TKNTTN0003')
INSERT [dbo].[TiepTan] ([MaTiepTan], [HoDem], [Ten], [CCCD], [SDT], [MaTaiKhoan]) VALUES (N'TTN0004', N'Huỳnh Thị Lưu', N'Ly', N'07700000004', N'0900800704', N'TKNTTN0004')
GO
SET IDENTITY_INSERT [dbo].[DonDatPhong] ON 

INSERT [dbo].[DonDatPhong] ([MaDonDat], [MaKhachHang], [MaTiepTan], [SoLuongKhach], [HinhThucThue], [TrangThaiThanhToan], [NgayDatPhong]) VALUES (100000, 10000, N'TTN0002', 10, N'Theo giờ', N'Chưa thanh toán', CAST(N'2023-04-21T14:32:04.273' AS DateTime))
SET IDENTITY_INSERT [dbo].[DonDatPhong] OFF
GO
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [DonGia]) VALUES (N'LPG0001', N'Phòng Đơn', 700000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [DonGia]) VALUES (N'LPG0002', N'Phòng Đôi', 1200000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [DonGia]) VALUES (N'LPG0003', N'Phòng Hai Giường Đơn', 1400000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [DonGia]) VALUES (N'LPG0004', N'Phòng Gia Đình', 2000000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [DonGia]) VALUES (N'LPG0005', N'Phòng Suite', 2000000.0000)
GO
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0201', 201, 2, N'Phòng 1 Tầng 2', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0202', 202, 2, N'Phòng 2 Tầng 2', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0203', 203, 2, N'Phòng 3 Tầng 2', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0204', 204, 2, N'Phòng 4 Tầng 2', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0205', 205, 2, N'Phòng 5 Tầng 2', N'Available', N'LPG0002')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0206', 206, 2, N'Phòng 6 Tầng 2', N'Available', N'LPG0002')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0207', 207, 2, N'Phòng 7 Tầng 2', N'Available', N'LPG0003')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0208', 208, 2, N'Phòng 8 Tầng 2', N'Available', N'LPG0003')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0209', 209, 2, N'Phòng 9 Tầng 2', N'Available', N'LPG0004')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0210', 210, 2, N'Phòng 10 Tầng 2', N'Available', N'LPG0004')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0301', 301, 3, N'Phòng 1 Tầng 3', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0302', 302, 3, N'Phòng 2 Tầng 3', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0303', 303, 3, N'Phòng 3 Tầng 3', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0304', 304, 3, N'Phòng 4 Tầng 3', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0305', 305, 3, N'Phòng 5 Tầng 3', N'Available', N'LPG0002')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0306', 306, 3, N'Phòng 6 Tầng 3', N'Available', N'LPG0002')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0307', 307, 3, N'Phòng 7 Tầng 3', N'Available', N'LPG0003')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0308', 308, 3, N'Phòng 8 Tầng 3', N'Available', N'LPG0003')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0309', 309, 3, N'Phòng 9 Tầng 3', N'Available', N'LPG0005')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0310', 310, 3, N'Phòng 10 Tầng 3', N'Available', N'LPG0005')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0401', 401, 4, N'Phòng 1 Tầng 4', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0402', 402, 4, N'Phòng 2 Tầng 4', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0403', 403, 4, N'Phòng 3 Tầng 4', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0404', 404, 4, N'Phòng 4 Tầng 4', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0405', 405, 4, N'Phòng 5 Tầng 4', N'Available', N'LPG0002')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0406', 406, 4, N'Phòng 6 Tầng 4', N'Available', N'LPG0002')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0407', 407, 4, N'Phòng 7 Tầng 4', N'Available', N'LPG0003')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0408', 408, 4, N'Phòng 8 Tầng 4', N'Available', N'LPG0003')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0409', 409, 4, N'Phòng 9 Tầng 4', N'Available', N'LPG0004')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0410', 410, 4, N'Phòng 10 Tầng 4', N'Available', N'LPG0004')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0501', 501, 5, N'Phòng 1 Tầng 5', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0502', 502, 5, N'Phòng 2 Tầng 5', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0503', 503, 5, N'Phòng 3 Tầng 5', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0504', 504, 5, N'Phòng 4 Tầng 5', N'Available', N'LPG0001')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0505', 505, 5, N'Phòng 5 Tầng 5', N'Available', N'LPG0002')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0506', 506, 5, N'Phòng 6 Tầng 5', N'Available', N'LPG0002')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0507', 507, 5, N'Phòng 7 Tầng 5', N'Available', N'LPG0003')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0508', 508, 5, N'Phòng 8 Tầng 5', N'Available', N'LPG0003')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0509', 509, 5, N'Phòng 9 Tầng 5', N'Available', N'LPG0005')
INSERT [dbo].[Phong] ([MaPhong], [SoPhong], [SoTang], [TenPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'PHG0510', 510, 5, N'Phòng 10 Tầng 5', N'Available', N'LPG0005')
GO
SET IDENTITY_INSERT [dbo].[DonDatPhong_Phong] ON 

INSERT [dbo].[DonDatPhong_Phong] ([ID], [MaDonDat], [MaPhong]) VALUES (1, 100000, N'PHG0401')
INSERT [dbo].[DonDatPhong_Phong] ([ID], [MaDonDat], [MaPhong]) VALUES (2, 100000, N'PHG0402')
INSERT [dbo].[DonDatPhong_Phong] ([ID], [MaDonDat], [MaPhong]) VALUES (3, 100000, N'PHG0404')
INSERT [dbo].[DonDatPhong_Phong] ([ID], [MaDonDat], [MaPhong]) VALUES (4, 100000, N'PHG0406')
SET IDENTITY_INSERT [dbo].[DonDatPhong_Phong] OFF
GO
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVD001', N'Sprite', 15000.0000, N'Drinks')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVD002', N'Pepsi', 15000.0000, N'Drinks')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVD003', N'Nước cam ép', 18000.0000, N'Drinks')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVD004', N'Cà phê', 18000.0000, N'Drinks')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVD005', N'Vodka nhỏ', 55000.0000, N'Drinks')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVF001', N'Cơm chiên dương châu', 55000.0000, N'Foods')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVF002', N'Cơm gà', 65000.0000, N'Foods')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVF003', N'Mì ý sốt bò', 65000.0000, N'Foods')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVF004', N'Trứng chiên thịt bằm', 45000.0000, N'Foods')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVF005', N'Canh khổ qua', 40000.0000, N'Foods')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVF006', N'Gỏi xoài', 70000.0000, N'Foods')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVF007', N'Caesar Salad - xa lát caesar', 80000.0000, N'Foods')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVO001', N'Giặt, ủi đồ', 60000.0000, N'Others')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonGia], [LoaiDichVu]) VALUES (N'DVO002', N'Xe đưa đón sân bay', 200000.0000, N'Others')
GO
SET IDENTITY_INSERT [dbo].[DonDatPhong_DichVu] ON 

INSERT [dbo].[DonDatPhong_DichVu] ([ID], [MaDonDat], [MaDichVu], [MaPhong], [SoLuong]) VALUES (1, 100000, N'DVD001', N'PHG0401', 3)
INSERT [dbo].[DonDatPhong_DichVu] ([ID], [MaDonDat], [MaDichVu], [MaPhong], [SoLuong]) VALUES (2, 100000, N'DVF004', N'PHG0402', 3)
INSERT [dbo].[DonDatPhong_DichVu] ([ID], [MaDonDat], [MaDichVu], [MaPhong], [SoLuong]) VALUES (3, 100000, N'DVO001', N'PHG0401', 1)
SET IDENTITY_INSERT [dbo].[DonDatPhong_DichVu] OFF
GO

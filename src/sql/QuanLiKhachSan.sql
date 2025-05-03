CREATE DATABASE QUANLIKHACHSAN;
GO

USE QUANLIKHACHSAN;
GO

-- Bảng Nhân viên
CREATE TABLE NhanVien (
    MaNhanVien INT PRIMARY KEY,
    Ho NVARCHAR(50) NOT NULL,
    Ten NVARCHAR(50) NOT NULL,
    NgaySinh DATE,
    GioiTinh VARCHAR(10),
    Email VARCHAR(100),
    SoDienThoai VARCHAR(15),
    ChucVu NVARCHAR(50),
    Luong DECIMAL(18,2)
);

select * from NhanVien

-- Bảng Tài khoản (dành cho nhân viên đăng nhập)
CREATE TABLE TaiKhoan (
    MaTaiKhoan INT PRIMARY KEY IDENTITY(1,1),
    TenDangNhap VARCHAR(50) UNIQUE NOT NULL,
    MatKhau VARCHAR(255) NOT NULL,
    MaNhanVien INT UNIQUE,
    VaiTro VARCHAR(50), -- admin / nhanvien
    TrangThai VARCHAR(20), -- active / inactive
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);

CREATE TABLE NhanVienDangNhap (
    MaTaiKhoan INT PRIMARY KEY,
    TenDangNhap NVARCHAR(50),
    MaNhanVien INT,
    VaiTro NVARCHAR(50),
    ThoiGianDangNhap DATETIME
);


-- Bảng Khách hàng
CREATE TABLE KhachHang (
    MaKhachHang INT PRIMARY KEY,
    Ho NVARCHAR(50) NOT NULL,
    Ten NVARCHAR(50) NOT NULL,
    NgaySinh DATE,
    GioiTinh VARCHAR(10),
    Email VARCHAR(100),
    SoDienThoai VARCHAR(15),
);

-- Bảng Loại phòng
CREATE TABLE LoaiPhong (
    MaLoaiPhong VARCHAR(10) PRIMARY KEY,
    TenLoaiPhong NVARCHAR(50),
    MoTa NVARCHAR(50)
);

-- Tạo bảng Phong 
CREATE TABLE Phong (
    MaPhong INT PRIMARY KEY,
    MaLoaiPhong VARCHAR(10),
    SoGiuong INT,
    DonGia DECIMAL(18,2),
    TrangThai NVARCHAR(20),
    FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong(MaLoaiPhong)
);

-- Bảng Phiếu thuê phòng
CREATE TABLE PhieuThuePhong (
    MaThuePhong INT PRIMARY KEY,
    MaKhachHang INT,
    MaNhanVien INT,
    NgayLapPhieu Date,
    TongTien DECIMAL(18,2),
	TrangThai VARCHAR(50) -- ví dụ: 'DangThue', 'DaTraHet', 'DaHuy',
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);
select * from PhieuThuePhong
select * from ChiTietPhieuThue
delete from ChiTietPhieuThue
delete from PhieuThuePhong
-- Bảng Chi tiết phiếu thuê phòng
CREATE TABLE ChiTietPhieuThue (
    ID INT IDENTITY(1,1) PRIMARY KEY, -- Khóa chính mới
    MaThuePhong INT,
    MaPhong INT,
    NgayDatPhong DATE,
    NgayTraPhong DATE,
    GiaPhong DECIMAL(18,2),
    ThanhTien DECIMAL(18,2),
    FOREIGN KEY (MaThuePhong) REFERENCES PhieuThuePhong(MaThuePhong),
    FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong)
);

-- Bảng Kiểm tra tình trạng phòng
CREATE TABLE KiemTraTinhTrang (
    MaKiemTra INT PRIMARY KEY,
    MaPhong INT,
    MaThuePhong INT,
    MaNhanVien INT,
    NgayKiemTra DATE,
    MoTaThietHai TEXT,
    ChiPhiDenBu DECIMAL(18,2),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien),
    FOREIGN KEY (MaThuePhong) REFERENCES PhieuThuePhong(MaThuePhong)
);

-- Bảng Dịch vụ
CREATE TABLE DichVu (
    MaDichVu INT PRIMARY KEY,
    TenDichVu NVARCHAR(100),
    MoTa NVARCHAR(50),
    DonGia DECIMAL(18,2),
    SoLuong INT
);

-- Bảng Dịch vụ thuê
CREATE TABLE DatDichVu (
    IDChiTietPhieuThue INT NOT NULL,
    MaDichVu INT NOT NULL,
    SoLuong INT NOT NULL,
    DonGia DECIMAL(18,2) NOT NULL,
    ThanhTien DECIMAL(18,2) NOT NULL,
    PRIMARY KEY (IDChiTietPhieuThue, MaDichVu),
    FOREIGN KEY (IDChiTietPhieuThue) REFERENCES ChiTietPhieuThue(ID),
    FOREIGN KEY (MaDichVu) REFERENCES DichVu(MaDichVu)
);

CREATE TABLE HoaDon (
    MaHD INT PRIMARY KEY,
    MaPTP INT,           
    NgayLap DATE,
    TongTien DECIMAL(18,2),
    FOREIGN KEY (MaPTP) REFERENCES PhieuThuePhong(MaThuePhong),
   
);

CREATE TABLE ChiTietHoaDon (
    MaCTHD INT PRIMARY KEY,  -- Mã chi tiết hóa đơn
    MaHD INT,                -- Mã hóa đơn
    MaPhong INT,             -- Mã phòng
    MaDV INT,                -- Mã dịch vụ
    LoaiChiTiet VARCHAR(50), -- Loại chi tiết (Phòng hoặc Dịch vụ)
    SoLuong INT,             -- Số lượng
    DonGia DECIMAL(18,2),    -- Đơn giá
    ThanhTien DECIMAL(18,2), -- Thành tiền
    FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
    FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong),
    FOREIGN KEY (MaDV) REFERENCES DichVu(MaDichVu)
);

-- Bảng Nhà cung cấp
CREATE TABLE NhaCungCap (
    MaNhaCungCap INT PRIMARY KEY,
    TenNhaCungCap NVARCHAR(100),
    SoDienThoai VARCHAR(15),
    DiaChi NVARCHAR(255)
);

-- Bảng Phiếu nhập hàng
CREATE TABLE PhieuNhapHang (
    MaPhieuNhapHang INT PRIMARY KEY,
    MaNhanVienXacNhan INT,
    MaNhaCungCap INT,
    NgayNhap DATE,
    TongTien DECIMAL(18,2),
    FOREIGN KEY (MaNhanVienXacNhan) REFERENCES NhanVien(MaNhanVien),
    FOREIGN KEY (MaNhaCungCap) REFERENCES NhaCungCap(MaNhaCungCap)
);

-- Bảng Nhu Yếu Phẩm
CREATE TABLE NhuYeuPham (
    MaHang VARCHAR(10) PRIMARY KEY,
    TenHang NVARCHAR(100) NOT NULL,
    DonViTinh NVARCHAR(20) NOT NULL,
    GiaNhap DECIMAL(18, 2) NOT NULL,
    NgaySanXuat DATE,
    NgayHetHan DATE,
    LoaiNhuYeuPham NVARCHAR(50),
    NhaSanXuat NVARCHAR(100),
    SoLuongTon INT DEFAULT 0,
    MoTa NTEXT
);

-- Bảng Đồ Gia Dụng
CREATE TABLE DoGiaDung (
    MaHang VARCHAR(10) PRIMARY KEY,
    TenHang NVARCHAR(100) NOT NULL,
    DonViTinh NVARCHAR(20) NOT NULL,
    GiaNhap DECIMAL(18, 2) NOT NULL,
    ThuongHieu NVARCHAR(50),
    XuatXu NVARCHAR(50),
    ChatLieu NVARCHAR(50),
    BaoHanh INT, -- Số tháng bảo hành
    SoLuongTon INT DEFAULT 0,
    MoTa NTEXT
);

-- Thêm dữ liệu cho bảng NhuYeuPham
INSERT INTO NhuYeuPham (MaHang, TenHang, DonViTinh, GiaNhap, NgaySanXuat, NgayHetHan, LoaiNhuYeuPham, NhaSanXuat, SoLuongTon, MoTa)
VALUES
('NYP001', N'Gạo Thơm Jasmine', N'Kg', 15000, '2025-01-15', '2025-07-15', N'Thực phẩm', N'Công ty Hạt Ngọc', 500, N'Gạo thơm jasmine cao cấp'),
('NYP002', N'Mì Gói Hảo Hảo', N'Thùng', 120000, '2025-02-01', '2025-08-01', N'Thực phẩm', N'Acecook Việt Nam', 200, N'Thùng 30 gói mì hương tôm chua cay'),
('NYP003', N'Dầu Ăn Neptune', N'Chai', 45000, '2025-01-10', '2025-12-10', N'Dầu ăn', N'Tường An', 150, N'Dầu ăn nguyên chất từ đậu nành, chai 1 lít'),
('NYP004', N'Sữa Tươi Vinamilk', N'Hộp', 7500, '2025-03-01', '2025-04-15', N'Đồ uống', N'Vinamilk', 300, N'Sữa tươi tiệt trùng hộp 180ml'),
('NYP005', N'Đường Trắng Biên Hòa', N'Kg', 22000, '2025-01-20', '2026-01-20', N'Gia vị', N'Đường Biên Hòa', 100, N'Đường tinh luyện chất lượng cao'),
('NYP006', N'Nước Mắm Nam Ngư', N'Chai', 35000, '2025-02-10', '2026-02-10', N'Gia vị', N'Masan Consumer', 120, N'Nước mắm cốt 40 độ đạm, chai 500ml'),
('NYP007', N'Bột Giặt Omo', N'Túi', 85000, '2025-02-15', '2027-02-15', N'Hóa phẩm', N'Unilever', 80, N'Bột giặt hương sạch khuẩn, túi 3kg'),
('NYP008', N'Kem Đánh Răng Colgate', N'Tuýp', 28000, '2025-01-05', '2026-07-05', N'Hóa phẩm', N'Colgate-Palmolive', 200, N'Kem đánh răng bảo vệ nướu, tuýp 200g'),
('NYP009', N'Khăn Giấy Pulppy', N'Gói', 32000, '2025-03-10', '2027-03-10', N'Vệ sinh', N'AB Corporation', 150, N'Gói 3 cuộn giấy mềm 3 lớp'),
('NYP010', N'Nước Rửa Chén Sunlight', N'Chai', 39000, '2025-02-20', '2026-08-20', N'Hóa phẩm', N'Unilever', 100, N'Nước rửa chén hương chanh, chai 750ml');

-- Thêm dữ liệu cho bảng DoGiaDung
INSERT INTO DoGiaDung (MaHang, TenHang, DonViTinh, GiaNhap, ThuongHieu, XuatXu, ChatLieu, BaoHanh, SoLuongTon, MoTa)
VALUES
('DGD001', N'Nồi Cơm Điện', N'Cái', 850000, N'Sunhouse', N'Việt Nam', N'Nhôm', 12, 20, N'Nồi cơm điện dung tích 1.8L, công nghệ 3D'),
('DGD002', N'Bếp Gas Đôi', N'Cái', 450000, N'Kangaroo', N'Việt Nam', N'Inox', 24, 15, N'Bếp gas đôi mặt kính cường lực'),
('DGD003', N'Chảo Chống Dính', N'Cái', 250000, N'Tefal', N'Pháp', N'Nhôm phủ chống dính', 6, 30, N'Chảo chống dính 26cm, cán bọc nhựa cách nhiệt'),
('DGD004', N'Máy Xay Sinh Tố', N'Cái', 650000, N'Philips', N'Indonesia', N'Nhựa, Thép không gỉ', 12, 10, N'Máy xay sinh tố 2 cối, công suất 500W'),
('DGD005', N'Bộ Nồi Inox', N'Bộ', 1200000, N'Elmich', N'Đức', N'Inox 304', 24, 5, N'Bộ 3 nồi inox 3 đáy, phù hợp mọi loại bếp'),
('DGD006', N'Bình Đun Nước', N'Cái', 280000, N'Lock&Lock', N'Hàn Quốc', N'Nhựa, Thép không gỉ', 12, 25, N'Bình đun nước 1.8L, tự ngắt khi sôi'),
('DGD007', N'Đèn Bàn LED', N'Cái', 220000, N'Rạng Đông', N'Việt Nam', N'Nhựa ABS', 12, 40, N'Đèn bàn học chống cận, 3 chế độ ánh sáng'),
('DGD008', N'Quạt Đứng', N'Cái', 480000, N'Senko', N'Việt Nam', N'Nhựa, Kim loại', 24, 15, N'Quạt đứng 5 cánh, 3 tốc độ, đường kính 40cm'),
('DGD009', N'Ấm Trà', N'Bộ', 380000, N'Minh Long', N'Việt Nam', N'Sứ', 0, 20, N'Bộ ấm chén men bóng, in hoa văn truyền thống'),
('DGD010', N'Máy Hút Bụi', N'Cái', 1600000, N'Electrolux', N'Malaysia', N'Nhựa ABS', 24, 8, N'Máy hút bụi không dây, pin lithium 45 phút sử dụng');



-- Bảng Chi tiết phiếu nhập hàng
CREATE TABLE ChiTietPhieuNhapHang (
    MaPhieuNhapHang INT,
    MaHang INT,
    SoLuong INT,
    DonGia DECIMAL(18,2),
    ThanhTien DECIMAL(18,2),
    PRIMARY KEY (MaPhieuNhapHang, MaHang),
    FOREIGN KEY (MaPhieuNhapHang) REFERENCES PhieuNhapHang(MaPhieuNhapHang),
    FOREIGN KEY (MaHang) REFERENCES HangHoa(MaHang)
);


INSERT INTO NhanVien (MaNhanVien, Ho, Ten, NgaySinh, GioiTinh, Email, SoDienThoai, ChucVu, Luong)
VALUES 
(1, N'Nguyễn', N'Tuấn Tài', '2005-01-19', 'Nam', 'tuantai1915@gmail.com', '0707666999', N'Admin', 15000000),
(2, N'Vũ', N'Thị B', '2000-05-05', N'Nữ', 'nhanvien@example.com', '0987654321', N'Nhân Viên', 8000000);

select * from NhanVien

INSERT INTO TaiKhoan (TenDangNhap, MatKhau, MaNhanVien, VaiTro, TrangThai)
VALUES 
('ntt', '1', 1, 'Admin', 'active'),
('vtb', '2', 2, 'Nhanvien', 'active');

select * from NhanVienDangNhap

INSERT INTO LoaiPhong (MaLoaiPhong, TenLoaiPhong, MoTa) 
VALUES
('LP01', 'Single', N'Phòng đơn dành cho một người, thiết kế hiện đại.'),
('LP02', 'Double', N'Phòng đôi thoải mái, phù hợp cho cặp đôi.'),
('LP03', 'Single-VIP', N'Phòng đơn cao cấp với nội thất sang trọng, view đẹp.'),
('LP04', 'Double-VIP', N'Phòng đôi VIP rộng rãi, tiện nghi cao cấp.'),
('LP05', 'Group', N'Phòng dành cho 5 người, thích hợp đi nhóm.');

DELETE FROM Phong;
DELETE FROM LoaiPhong;

select * from Phong



--Cách in thứ 1 
--------------------------------------
--          KHÁCH SẠN ABC
--        HÓA ĐƠN THANH TOÁN
--------------------------------------
--Mã Hóa Đơn: 1
--Ngày Lập: 27/04/2025
--Khách hàng: Nguyễn Văn A
--Nhân viên lập: Trần Thị B

--*** Tiền thuê phòng ***
--Phòng 101 | 2 ngày | 500k/ngày | 1.000k
--Phòng 102 | 2 ngày | 400k/ngày | 800k

--*** Dịch vụ đã sử dụng ***
--Phòng 101 | Ăn sáng | 2 suất x 100k = 200k
--Phòng 101 | Giặt đồ | 1 lần x 50k = 50k

--------------------------------------
--Tổng tiền phòng: 1.800k
--Tổng tiền dịch vụ: 250k
--Tổng cộng thanh toán: 2.050k
--------------------------------------
--Xin cảm ơn Quý khách!


--Cách in thứ 2
--       KHÁCH SẠN XYZ
--    HÓA ĐƠN THANH TOÁN SỐ 1
--Ngày lập: 28/04/2025

--Phòng 101:
--  - Tiền phòng: 1 x 300.000 đ     300.000 đ
--  - Dịch vụ Giặt đồ: 1 x 50.000 đ  50.000 đ
--  - Dịch vụ Đồ ăn:    2 x 100.000 đ 200.000 đ

--Phòng 102:
--  - Tiền phòng: 1 x 400.000 đ     400.000 đ

------------------------------------------------
--Tổng tiền phòng: 300.000 + 400.000 = 700.000 đ
--Tổng tiền dịch vụ: 50.000 + 200.000 = 250.000 đ
--TỔNG CỘNG: 950.000 đ
------------------------------------------------

--Cảm ơn Quý khách và hẹn gặp lại!





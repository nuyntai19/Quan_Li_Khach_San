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
    MaNhanVien INT,
    MaThuePhong INT,
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
    FOREIGN KEY (MaPTP) REFERENCES PhieuThuePhong(MaPTP),
   
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

-- Bảng Hàng hóa
CREATE TABLE HangHoa (
    MaHang INT PRIMARY KEY,
    TenHang NVARCHAR(100),
    DonViTinh VARCHAR(50),
    GiaNhap DECIMAL(18,2)
);

-- Tạo bảng NhuYeuPham
CREATE TABLE NhuYeuPham (
    MaNhuYeuPham INT PRIMARY KEY,
    TenNhuYeuPham NVARCHAR(100) NOT NULL,
    DonViTinh NVARCHAR(20) NOT NULL,
    GiaNhap DECIMAL(18,2) NOT NULL,
    HanSuDung DATE NOT NULL,
    NhaCungCap NVARCHAR(100) NOT NULL
);

-- Tạo bảng DoGiaDung
CREATE TABLE DoGiaDung (
    MaDoGiaDung INT PRIMARY KEY,
    TenDoGiaDung NVARCHAR(100) NOT NULL,
    DonViTinh NVARCHAR(20) NOT NULL,
    GiaNhap DECIMAL(18,2) NOT NULL,
    TinhTrang NVARCHAR(50) NOT NULL
);

-- Thêm ràng buộc khóa ngoại cho bảng NhuYeuPham
ALTER TABLE NhuYeuPham
ADD CONSTRAINT FK_NhuYeuPham_HangHoa
FOREIGN KEY (MaNhuYeuPham) REFERENCES HangHoa(MaHang);

-- Thêm ràng buộc khóa ngoại cho bảng DoGiaDung
ALTER TABLE DoGiaDung
ADD CONSTRAINT FK_DoGiaDung_HangHoa
FOREIGN KEY (MaDoGiaDung) REFERENCES HangHoa(MaHang);

-- Thêm dữ liệu mẫu cho bảng NhuYeuPham
INSERT INTO NhuYeuPham (MaNhuYeuPham, TenNhuYeuPham, DonViTinh, GiaNhap, HanSuDung, NhaCungCap)
VALUES 
(1, N'Nước khoáng Lavie', N'Chai', 5000, '2024-12-31', N'Công ty TNHH Lavie'),
(2, N'Bánh mì', N'Cái', 10000, '2024-04-30', N'Công ty TNHH ABC'),
(3, N'Sữa tươi Vinamilk', N'Hộp', 8000, '2024-05-15', N'Công ty Vinamilk');

-- Thêm dữ liệu mẫu cho bảng DoGiaDung
INSERT INTO DoGiaDung (MaDoGiaDung, TenDoGiaDung, DonViTinh, GiaNhap, TinhTrang)
VALUES 
(4, N'Bàn ủi', N'Cái', 250000, N'Mới'),
(5, N'Quạt điện', N'Cái', 350000, N'Đã qua sử dụng'),
(6, N'Bếp điện', N'Cái', 500000, N'Mới'); 

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





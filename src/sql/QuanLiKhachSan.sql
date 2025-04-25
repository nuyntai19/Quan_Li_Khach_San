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
    MaThuePhong INT,
	MaPhong INT,
    MaDichVu INT,
    SoLuong INT,
    DonGia DECIMAL(18,2),
    ThanhTien DECIMAL(18,2),
    PRIMARY KEY (MaThuePhong, MaDichVu),
	FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong),
    FOREIGN KEY (MaThuePhong) REFERENCES PhieuThuePhong(MaThuePhong),
    FOREIGN KEY (MaDichVu) REFERENCES DichVu(MaDichVu)
);

-- Bảng Hóa đơn
CREATE TABLE HoaDon (
    MaHoaDon INT PRIMARY KEY,
    MaKhachHang INT,
    MaNhanVien INT,
    NgayThanhToan DATE,
    HinhThucThanhToan VARCHAR(50),
    TongTien DECIMAL(18,2),
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);

-- Bảng Chi tiết hóa đơn
CREATE TABLE ChiTietHoaDon (
    MaHoaDon INT,
    MaDichVu INT,
    DonGia DECIMAL(18,2),
    ThanhTien DECIMAL(18,2),
    PRIMARY KEY (MaHoaDon, MaDichVu),
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (MaDichVu) REFERENCES DichVu(MaDichVu)
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






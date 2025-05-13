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
    MoTaThietHai NVARCHAR(25),
    ChiPhiDenBu DECIMAL(18,2),
    FOREIGN KEY (MaPhong) REFERENCES ChiTietPhieuThue(MaPhong),
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
    DiaChi NVARCHAR(255),
	TrangThai NVARCHAR(255)
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

CREATE TABLE LoaiHangHoa (
    MaLoaiHang VARCHAR(10) PRIMARY KEY,
    TenLoaiHang NVARCHAR(50),
    MoTa NVARCHAR(255)
);

-- Bảng HangHoa 
CREATE TABLE HangHoa (
    MaHang VARCHAR(10) PRIMARY KEY,
    TenHang NVARCHAR(100) NOT NULL,
    MaLoaiHang VARCHAR(10),
    DonViTinh NVARCHAR(20) NOT NULL,
    GiaNhap DECIMAL(18, 2) NOT NULL,
    SoLuongTon INT DEFAULT 0,
    ThuongHieu NVARCHAR(50),
    XuatXu NVARCHAR(50),
    MoTa NTEXT,
    FOREIGN KEY (MaLoaiHang) REFERENCES LoaiHangHoa(MaLoaiHang)
);

-- Bảng ChiTietPhieuNhapHang 
CREATE TABLE ChiTietPhieuNhapHang (
    MaPhieuNhapHang INT,
    MaHang VARCHAR(10),  
    TenHang NVARCHAR(100) NOT NULL,  
    MaLoaiHang VARCHAR(10),
    DonViTinh NVARCHAR(20) NOT NULL,
    SoLuong INT,
    DonGia DECIMAL(18,2),
    ThanhTien DECIMAL(18,2),
    PRIMARY KEY (MaPhieuNhapHang, MaHang),
    FOREIGN KEY (MaPhieuNhapHang) REFERENCES PhieuNhapHang(MaPhieuNhapHang),
    FOREIGN KEY (MaLoaiHang) REFERENCES LoaiHangHoa(MaLoaiHang),
    FOREIGN KEY (MaHang) REFERENCES HangHoa(MaHang)
);

--Cách in hóa đơn
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






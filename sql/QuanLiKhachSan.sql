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

-- Bảng Khách hàng
CREATE TABLE KhachHang (
    MaKhachHang INT PRIMARY KEY,
    Ho NVARCHAR(50) NOT NULL,
    Ten NVARCHAR(50) NOT NULL,
    NgaySinh DATE,
    GioiTinh VARCHAR(10),
    Email VARCHAR(100),
    SoDienThoai VARCHAR(15),
    VaiTro VARCHAR(50)
);

-- Bảng Loại phòng
CREATE TABLE LoaiPhong (
    MaLoaiPhong INT PRIMARY KEY,
    TenLoaiPhong NVARCHAR(50),
    MoTa TEXT
);

-- Bảng Phòng
CREATE TABLE Phong (
    MaPhong INT PRIMARY KEY,
    MaLoaiPhong INT,
    SoGiuong INT,
    DonGia DECIMAL(18,2),
    TrangThai VARCHAR(50),
    FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong(MaLoaiPhong)
);

-- Bảng Phiếu thuê phòng
CREATE TABLE PhieuThuePhong (
    MaThuePhong INT PRIMARY KEY,
    MaKhachHang INT,
    MaNhanVien INT,
    NgayDatPhong DATE,
    NgayTraPhong DATE,
    TongTien DECIMAL(18,2),
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);

-- Bảng Chi tiết phiếu thuê phòng
CREATE TABLE ChiTietPhieuThue (
    MaThuePhong INT,
    MaPhong INT,
    MaDichVu INT,
    GiaPhong DECIMAL(18,2),
    SoNgayO INT,
    ThanhTien DECIMAL(18,2),
    PRIMARY KEY (MaThuePhong, MaPhong),
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
    MoTa TEXT,
    DonGia DECIMAL(18,2),
    SoLuong INT
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

CREATE DATABASE QUANLIKHACHSAN;
GO

USE QUANLIKHACHSAN;
GO

-- Bảng Nhân viên
CREATE TABLE NhanVien (
    MaNhanVien BIGINT PRIMARY KEY,
    Ho NVARCHAR(50),
    Ten NVARCHAR(50),
    NgaySinh DATE,
    GioiTinh VARCHAR(10),
    Email VARCHAR(100),
    SoDienThoai VARCHAR(15),
    ChucVu NVARCHAR(50),
    Luong DECIMAL(18,2)
);

-- Bảng Tài khoản (dành cho nhân viên đăng nhập)
CREATE TABLE TaiKhoan (
    MaTaiKhoan BIGINT PRIMARY KEY IDENTITY(1,1),
    TenDangNhap VARCHAR(50) UNIQUE NOT NULL,
    MatKhau VARCHAR(255) NOT NULL,
    MaNhanVien BIGINT UNIQUE,
    VaiTro VARCHAR(50), -- admin / nhanvien
    TrangThai VARCHAR(20), -- active / inactive
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);

-- Bảng Khách hàng
CREATE TABLE KhachHang (
    MaKhachHang BIGINT PRIMARY KEY,
    Ho NVARCHAR(50),
    Ten NVARCHAR(50),
    NgaySinh DATE,
    GioiTinh VARCHAR(10),
    Email VARCHAR(100),
    SoDienThoai VARCHAR(15),
    VaiTro VARCHAR(50)
);

-- Bảng Loại phòng
CREATE TABLE LoaiPhong (
    MaLoaiPhong BIGINT PRIMARY KEY,
    TenLoaiPhong NVARCHAR(50),
    MoTa TEXT
);

-- Bảng Phòng
CREATE TABLE Phong (
    MaPhong BIGINT PRIMARY KEY,
    MaLoaiPhong BIGINT,
    SoGiuong BIGINT,
    DonGia DECIMAL(18,2),
    TrangThai VARCHAR(50),
    FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong(MaLoaiPhong)
);

-- Bảng Phiếu thuê phòng
CREATE TABLE PhieuThuePhong (
    MaThuePhong BIGINT PRIMARY KEY,
    MaKhachHang BIGINT,
    MaNhanVien BIGINT,
    NgayDatPhong DATE,
    NgayTraPhong DATE,
    TongTien DECIMAL(18,2),
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);

-- Bảng Chi tiết phiếu thuê phòng
CREATE TABLE ChiTietPhieuThue (
    MaThuePhong BIGINT,
    MaPhong BIGINT,
    MaDichVu BIGINT,
    GiaPhong DECIMAL(18,2),
    SoNgayO INT,
    ThanhTien DECIMAL(18,2),
    PRIMARY KEY (MaThuePhong, MaPhong),
    FOREIGN KEY (MaThuePhong) REFERENCES PhieuThuePhong(MaThuePhong),
    FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong)
);

-- Bảng Kiểm tra tình trạng phòng
CREATE TABLE KiemTraTinhTrang (
    MaKiemTra BIGINT PRIMARY KEY,
    MaNhanVien BIGINT,
    MaThuePhong BIGINT,
    NgayKiemTra DATE,
    MoTaThietHai TEXT,
    ChiPhiDenBu DECIMAL(18,2),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien),
    FOREIGN KEY (MaThuePhong) REFERENCES PhieuThuePhong(MaThuePhong)
);

-- Bảng Dịch vụ
CREATE TABLE DichVu (
    MaDichVu BIGINT PRIMARY KEY,
    TenDichVu NVARCHAR(100),
    MoTa TEXT,
    DonGia DECIMAL(18,2),
    SoLuong INT
);

-- Bảng Hóa đơn
CREATE TABLE HoaDon (
    MaHoaDon BIGINT PRIMARY KEY,
    MaKhachHang BIGINT,
    MaNhanVien BIGINT,
    NgayThanhToan DATE,
    HinhThucThanhToan VARCHAR(50),
    TongTien DECIMAL(18,2),
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);

-- Bảng Chi tiết hóa đơn
CREATE TABLE ChiTietHoaDon (
    MaHoaDon BIGINT,
    MaDichVu BIGINT,
    DonGia DECIMAL(18,2),
    ThanhTien DECIMAL(18,2),
    PRIMARY KEY (MaHoaDon, MaDichVu),
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (MaDichVu) REFERENCES DichVu(MaDichVu)
);

-- Bảng Nhà cung cấp
CREATE TABLE NhaCungCap (
    MaNhaCungCap BIGINT PRIMARY KEY,
    TenNhaCungCap NVARCHAR(100),
    SoDienThoai BIGINT,
    DiaChi NVARCHAR(255)
);

-- Bảng Phiếu nhập hàng
CREATE TABLE PhieuNhapHang (
    MaPhieuNhapHang BIGINT PRIMARY KEY,
    MaNhanVienXacNhan BIGINT,
    MaNhaCungCap BIGINT,
    NgayNhap DATE,
    TongTien DECIMAL(18,2),
    FOREIGN KEY (MaNhanVienXacNhan) REFERENCES NhanVien(MaNhanVien),
    FOREIGN KEY (MaNhaCungCap) REFERENCES NhaCungCap(MaNhaCungCap)
);

-- Bảng Hàng hóa
CREATE TABLE HangHoa (
    MaHang BIGINT PRIMARY KEY,
    TenHang NVARCHAR(100),
    DonViTinh VARCHAR(50),
    GiaNhap DECIMAL(18,2)
);

-- Bảng Chi tiết phiếu nhập hàng
CREATE TABLE ChiTietPhieuNhapHang (
    MaPhieuNhapHang BIGINT,
    MaHang BIGINT,
    SoLuong BIGINT,
    DonGia DECIMAL(18,2),
    ThanhTien DECIMAL(18,2),
    PRIMARY KEY (MaPhieuNhapHang, MaHang),
    FOREIGN KEY (MaPhieuNhapHang) REFERENCES PhieuNhapHang(MaPhieuNhapHang),
    FOREIGN KEY (MaHang) REFERENCES HangHoa(MaHang)
);

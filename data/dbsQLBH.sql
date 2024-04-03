USE [master]
GO
/****** Object:  Database [QLCuaHangTL]    Script Date: 3/26/2024 7:13:37 PM ******/
CREATE DATABASE [QLCuaHangTL]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLCuaHangTL', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QLCuaHangTL.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLCuaHangTL_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QLCuaHangTL_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QLCuaHangTL] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLCuaHangTL].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLCuaHangTL] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLCuaHangTL] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLCuaHangTL] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLCuaHangTL] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLCuaHangTL] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET RECOVERY FULL 
GO
ALTER DATABASE [QLCuaHangTL] SET  MULTI_USER 
GO
ALTER DATABASE [QLCuaHangTL] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLCuaHangTL] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLCuaHangTL] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLCuaHangTL] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLCuaHangTL] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLCuaHangTL] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLCuaHangTL', N'ON'
GO
ALTER DATABASE [QLCuaHangTL] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLCuaHangTL] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLCuaHangTL]
GO
/****** Object:  Table [dbo].[ChiTietDonNhap]    Script Date: 3/26/2024 7:13:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDonNhap](
	[maDonNhap] [char](10) NOT NULL,
	[maGiaSanPham] [char](10) NOT NULL,
	[soLuongNhap] [int] NOT NULL,
	[trangThaiHangNhap] [bit] NOT NULL,
	[thanhTien] [decimal](18, 3) NOT NULL,
 CONSTRAINT [PK_ChiTietDonNhap_1] PRIMARY KEY CLUSTERED 
(
	[maDonNhap] ASC,
	[maGiaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 3/26/2024 7:13:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHoaDon] [char](10) NOT NULL,
	[maGiaSanPham] [char](10) NOT NULL,
	[soLuong] [int] NOT NULL,
	[giamGia] [float] NOT NULL,
	[thanhTien] [decimal](18, 3) NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon_1] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC,
	[maGiaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonVi]    Script Date: 3/26/2024 7:13:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonVi](
	[maDonVi] [char](10) NOT NULL,
	[tenDonVi] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_DonVi] PRIMARY KEY CLUSTERED 
(
	[maDonVi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GiaSanPham]    Script Date: 3/26/2024 7:13:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GiaSanPham](
	[maGiaSanPham] [char](10) NOT NULL,
	[maSanPham] [char](13) NOT NULL,
	[maDonVi] [char](10) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [decimal](18, 3) NOT NULL,
	[giaVon] [decimal](18, 3) NOT NULL,
	[trangThai] [bit] NOT NULL,
 CONSTRAINT [PK_GiaSanPham_1] PRIMARY KEY CLUSTERED 
(
	[maGiaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 3/26/2024 7:13:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [char](10) NOT NULL,
	[maNhanVien] [char](10) NOT NULL,
	[ngayLap] [datetime] NOT NULL,
	[tongTien] [decimal](18, 3) NOT NULL,
	[maKhach] [char](10) NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonNhap]    Script Date: 3/26/2024 7:13:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonNhap](
	[maDonNhap] [char](10) NOT NULL,
	[maNhaCungCap] [char](10) NOT NULL,
	[ngayLap] [datetime] NOT NULL,
	[trangThaiDonNhap] [bit] NOT NULL,
	[tongTien] [decimal](18, 3) NOT NULL,
 CONSTRAINT [PK_HoaDonNhap] PRIMARY KEY CLUSTERED 
(
	[maDonNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 3/26/2024 7:13:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhach] [char](10) NOT NULL,
	[tenKhach] [nvarchar](50) NOT NULL,
	[soDienThoai] [char](10) NOT NULL,
	[mail] [nvarchar](50) NOT NULL,
	[diemTichLuy] [int] NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKhach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 3/26/2024 7:13:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[maLoai] [char](10) NOT NULL,
	[tenLoai] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_LoaiSanPham] PRIMARY KEY CLUSTERED 
(
	[maLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 3/26/2024 7:13:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNhaCungCap] [char](10) NOT NULL,
	[tenNhaCungCap] [nvarchar](50) NOT NULL,
	[diaChiNhaCungCap] [nvarchar](50) NOT NULL,
	[soDienThoai] [varchar](15) NOT NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[maNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 3/26/2024 7:13:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [char](10) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[ngayNhanViec] [date] NOT NULL,
	[trangThai] [bit] NOT NULL,
	[soDienThoai] [char](15) NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
	[chucDanh] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 3/26/2024 7:13:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [char](13) NOT NULL,
	[tenSanPham] [nvarchar](50) NOT NULL,
	[maNhaCungCap] [char](10) NOT NULL,
	[maLoaiSanPham] [char](10) NOT NULL,
	[anhSanPham] [varchar](50) NOT NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 3/26/2024 7:13:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maNhanVien] [char](10) NOT NULL,
	[matKhau] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietDonNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonNhap_GiaSanPham] FOREIGN KEY([maGiaSanPham])
REFERENCES [dbo].[GiaSanPham] ([maGiaSanPham])
GO
ALTER TABLE [dbo].[ChiTietDonNhap] CHECK CONSTRAINT [FK_ChiTietDonNhap_GiaSanPham]
GO
ALTER TABLE [dbo].[ChiTietDonNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonNhap_HoaDonNhap] FOREIGN KEY([maDonNhap])
REFERENCES [dbo].[HoaDonNhap] ([maDonNhap])
GO
ALTER TABLE [dbo].[ChiTietDonNhap] CHECK CONSTRAINT [FK_ChiTietDonNhap_HoaDonNhap]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_GiaSanPham] FOREIGN KEY([maGiaSanPham])
REFERENCES [dbo].[GiaSanPham] ([maGiaSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_GiaSanPham]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[GiaSanPham]  WITH CHECK ADD  CONSTRAINT [FK_GiaSanPham_DonVi] FOREIGN KEY([maDonVi])
REFERENCES [dbo].[DonVi] ([maDonVi])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[GiaSanPham] CHECK CONSTRAINT [FK_GiaSanPham_DonVi]
GO
ALTER TABLE [dbo].[GiaSanPham]  WITH CHECK ADD  CONSTRAINT [FK_GiaSanPham_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[GiaSanPham] CHECK CONSTRAINT [FK_GiaSanPham_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKhach])
REFERENCES [dbo].[KhachHang] ([maKhach])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonNhap]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonNhap_NhaCungCap] FOREIGN KEY([maNhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([maNhaCungCap])
GO
ALTER TABLE [dbo].[HoaDonNhap] CHECK CONSTRAINT [FK_HoaDonNhap_NhaCungCap]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[TaiKhoan] ([maNhanVien])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_LoaiSanPham] FOREIGN KEY([maLoaiSanPham])
REFERENCES [dbo].[LoaiSanPham] ([maLoai])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_LoaiSanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhaCungCap] FOREIGN KEY([maNhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([maNhaCungCap])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhaCungCap]
GO
USE [master]
GO
ALTER DATABASE [QLCuaHangTL] SET  READ_WRITE 
GO

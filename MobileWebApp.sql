USE [master]
GO
/****** Object:  Database [MobileWebAppDb]    Script Date: 6/10/2021 8:28:10 PM ******/
CREATE DATABASE [MobileWebAppDb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MobileWebAppDb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\MobileWebAppDb.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'MobileWebAppDb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\MobileWebAppDb_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [MobileWebAppDb] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MobileWebAppDb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MobileWebAppDb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET ARITHABORT OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MobileWebAppDb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MobileWebAppDb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET  ENABLE_BROKER 
GO
ALTER DATABASE [MobileWebAppDb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MobileWebAppDb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET RECOVERY FULL 
GO
ALTER DATABASE [MobileWebAppDb] SET  MULTI_USER 
GO
ALTER DATABASE [MobileWebAppDb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MobileWebAppDb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MobileWebAppDb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MobileWebAppDb] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [MobileWebAppDb] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [MobileWebAppDb] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'MobileWebAppDb', N'ON'
GO
ALTER DATABASE [MobileWebAppDb] SET QUERY_STORE = OFF
GO
USE [MobileWebAppDb]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 6/10/2021 8:28:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[orderId] [int] NULL,
	[productId] [int] NULL,
	[amount] [int] NULL,
	[price] [decimal](18, 0) NULL,
 CONSTRAINT [PK_OrderDetails] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderHeaders]    Script Date: 6/10/2021 8:28:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderHeaders](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[userId] [int] NULL,
	[orderDate] [nvarchar](50) NULL,
	[total] [decimal](18, 0) NULL,
	[status] [nvarchar](64) NULL,
 CONSTRAINT [PK_OrderHeaders] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 6/10/2021 8:28:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](64) NULL,
	[imageUrl] [nvarchar](64) NULL,
	[manufacturer] [nvarchar](64) NULL,
	[category] [nvarchar](64) NULL,
	[condition] [nvarchar](64) NULL,
	[available] [int] NULL,
	[description] [text] NULL,
	[unitPrice] [decimal](18, 0) NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 6/10/2021 8:28:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](64) NULL,
 CONSTRAINT [PK_Role_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ShoppingCarts]    Script Date: 6/10/2021 8:28:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ShoppingCarts](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[userId] [int] NULL,
	[productId] [int] NULL,
	[count] [int] NULL,
 CONSTRAINT [PK_ShoppingCarts] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 6/10/2021 8:28:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](64) NULL,
	[password] [nvarchar](64) NULL,
	[fullName] [nvarchar](64) NULL,
	[roleId] [int] NULL,
	[email] [nvarchar](64) NULL,
	[phoneNumber] [nvarchar](64) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[OrderHeaders] ON 

INSERT [dbo].[OrderHeaders] ([id], [userId], [orderDate], [total], [status]) VALUES (1, 2, N'10/06/2021', CAST(1597 AS Decimal(18, 0)), N'STATUS_IN_PROCESS')
INSERT [dbo].[OrderHeaders] ([id], [userId], [orderDate], [total], [status]) VALUES (2, 2, N'10/06/2021', CAST(1597 AS Decimal(18, 0)), N'STATUS_IN_PROCESS')
SET IDENTITY_INSERT [dbo].[OrderHeaders] OFF
GO
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([id], [name], [imageUrl], [manufacturer], [category], [condition], [available], [description], [unitPrice]) VALUES (1, N'Iphone X', N'images\products\iphonex.jpg', N'Apple', N'Apple', N'New', 900, N'A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile boardband cellular network connection for voice, SMS, and Internet data communication; most, if not all, smartphones also support Wifi', CAST(1099 AS Decimal(18, 0)))
INSERT [dbo].[Products] ([id], [name], [imageUrl], [manufacturer], [category], [condition], [available], [description], [unitPrice]) VALUES (2, N'Iphone 8 Plus 64GB PRODUCT RED', N'images\products\iphone8plus.jpg', N'Apple', N'Apple', N'Refurbished', 250, N'A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile boardband cellular network connection for voice, SMS, and Internet data communication; most, if not all, smartphones also support Wifi', CAST(599 AS Decimal(18, 0)))
INSERT [dbo].[Products] ([id], [name], [imageUrl], [manufacturer], [category], [condition], [available], [description], [unitPrice]) VALUES (3, N'Huawei P20 Pro DUAL SIM', N'images\products\p20pro.jpg', N'Huawei', N'Huawei', N'New', 800, N'A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile boardband cellular network connection for voice, SMS, and Internet data communication; most, if not all, smartphones also support Wifi', CAST(499 AS Decimal(18, 0)))
INSERT [dbo].[Products] ([id], [name], [imageUrl], [manufacturer], [category], [condition], [available], [description], [unitPrice]) VALUES (4, N'Galaxy s8', N'images\products\galaxys8.jpg', N'Samsung', N'Samsung', N'New', 850, N'A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile boardband cellular network connection for voice, SMS, and Internet data communication; most, if not all, smartphones also support Wifi', CAST(899 AS Decimal(18, 0)))
SET IDENTITY_INSERT [dbo].[Products] OFF
GO
SET IDENTITY_INSERT [dbo].[Roles] ON 

INSERT [dbo].[Roles] ([id], [name]) VALUES (1, N'Admin')
INSERT [dbo].[Roles] ([id], [name]) VALUES (2, N'Member')
SET IDENTITY_INSERT [dbo].[Roles] OFF
GO
SET IDENTITY_INSERT [dbo].[ShoppingCarts] ON 

INSERT [dbo].[ShoppingCarts] ([id], [userId], [productId], [count]) VALUES (5, 1, 3, 2)
INSERT [dbo].[ShoppingCarts] ([id], [userId], [productId], [count]) VALUES (6, 1, 2, 1)
INSERT [dbo].[ShoppingCarts] ([id], [userId], [productId], [count]) VALUES (7, 1, 1, 1)
SET IDENTITY_INSERT [dbo].[ShoppingCarts] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([id], [username], [password], [fullName], [roleId], [email], [phoneNumber]) VALUES (1, N'admin', N'admin', N'Huy Phùng', 1, N'huypc2410@gmail.com', N'0349797318')
INSERT [dbo].[Users] ([id], [username], [password], [fullName], [roleId], [email], [phoneNumber]) VALUES (2, N'member', N'member', N'Huy PC', 2, N'huyse140675@fpt.edu.vn', N'0349797318')
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_OrderHeaders] FOREIGN KEY([orderId])
REFERENCES [dbo].[OrderHeaders] ([id])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_OrderHeaders]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_Products] FOREIGN KEY([productId])
REFERENCES [dbo].[Products] ([id])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_Products]
GO
ALTER TABLE [dbo].[OrderHeaders]  WITH CHECK ADD  CONSTRAINT [FK_OrderHeaders_Users] FOREIGN KEY([userId])
REFERENCES [dbo].[Users] ([id])
GO
ALTER TABLE [dbo].[OrderHeaders] CHECK CONSTRAINT [FK_OrderHeaders_Users]
GO
ALTER TABLE [dbo].[ShoppingCarts]  WITH CHECK ADD  CONSTRAINT [FK_ShoppingCarts_Products] FOREIGN KEY([productId])
REFERENCES [dbo].[Products] ([id])
GO
ALTER TABLE [dbo].[ShoppingCarts] CHECK CONSTRAINT [FK_ShoppingCarts_Products]
GO
ALTER TABLE [dbo].[ShoppingCarts]  WITH CHECK ADD  CONSTRAINT [FK_ShoppingCarts_Users] FOREIGN KEY([userId])
REFERENCES [dbo].[Users] ([id])
GO
ALTER TABLE [dbo].[ShoppingCarts] CHECK CONSTRAINT [FK_ShoppingCarts_Users]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_User_Role] FOREIGN KEY([roleId])
REFERENCES [dbo].[Roles] ([id])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_User_Role]
GO
USE [master]
GO
ALTER DATABASE [MobileWebAppDb] SET  READ_WRITE 
GO

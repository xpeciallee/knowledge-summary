USE [nacos]
GO

/****** Object:  Table [nacos].[permissions]    Script Date: 2022/1/15 星期六 22:47:00 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [nacos].[permissions](
	[role] [varchar](50) NOT NULL,
	[resource] [varchar](255) NOT NULL,
	[action] [varchar](8) NOT NULL,
 CONSTRAINT [permissions$uk_role_permission] UNIQUE CLUSTERED 
(
	[role] ASC,
	[resource] ASC,
	[action] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'nacos.permissions' , @level0type=N'SCHEMA',@level0name=N'nacos', @level1type=N'TABLE',@level1name=N'permissions'
GO

